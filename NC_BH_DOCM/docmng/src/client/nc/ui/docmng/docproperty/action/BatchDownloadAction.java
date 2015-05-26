package nc.ui.docmng.docproperty.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import nc.bs.framework.common.NCLocator;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.docmng.IFilePathGenerator;
import nc.ui.docmng.docproperty.dialog.BatchDownloadDialog;
import nc.ui.docmng.docproperty.treemanage.DocViewAppService;
import nc.ui.docmng.docproperty.util.DocmngUtil;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.filesystem.FileManageServletClient;
import nc.ui.uif2.NCAction;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.pubapp.pattern.pub.SqlBuilder;
import nc.vo.uif2.LoginContext;

public class BatchDownloadAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginContext login;

	@Override
	public void doAction(ActionEvent e) throws Exception {

		BatchDownloadDialog dlg = new BatchDownloadDialog(
				this.login.getEntranceUI());
		Map<String, String> mapName = new HashMap<String, String>();
		Map<String, String> mapDT = new HashMap<String, String>();
		if (dlg.showModal() == UIDialog.ID_OK) {
			Map<String, String> map = dlg.getChoise();
			Object[] docPros = this.queryByMap(map);
			if(docPros==null||docPros.length<=0){
				MessageDialog.showErrorDlg(login.getEntranceUI(), "提示", "查询结果没有可下载的数据!");
				return;
			}
			for (Object docPro : docPros) {
				AggDocProperty aggVO = (AggDocProperty) docPro;
				DocProperty parent = aggVO.getParentVO();
				String pk = parent.getPk_docid();
				String name = parent.getVname();
				String doctype = parent.getPk_doctype();
				mapName.put(pk, name);
				mapDT.put(pk, doctype);
			}
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if(chooser.showSaveDialog(login.getEntranceUI())==JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				if(file!=null&&file.isDirectory()){
					String savePath = file.getAbsolutePath();
					String dsName = WorkbenchEnvironment.getInstance()
							.getLoginBusiCenter().getDataSourceName();
					mapDT = (Map<String, String>) NCLocator.getInstance().lookup(IFilePathGenerator.class).getFilePathWithName(mapName, mapDT);
					for(Map.Entry<String, String> ety : mapDT.entrySet()){
						String sPath = savePath+File.separator+ety.getValue();
						this.createDir(sPath);
						FileOutputStream out = new FileOutputStream(sPath);
						FileManageServletClient.downloadFile(dsName,DocmngUtil.path+ety.getKey()+File.separator+mapName.get(ety.getKey()), out);
					}
				}
			}
		}
	}

	private void createDir(String value) {
		String path = value.substring(0, value.lastIndexOf(File.separator));
		File dir = new File(path);
		if(dir.exists()){
			return;
		}
		dir.mkdirs();
		
	}

	private Object[] queryByMap(Map<String, String> map) throws Exception {
		SqlBuilder sb = new SqlBuilder();
		for (Map.Entry<String, String> ety : map.entrySet()) {
			if (ety.getValue() != null && !"".equals(ety.getValue())) {
				sb.append(ety.getKey(), ety.getValue());
				sb.append(" and ");
			}
		}
		sb.append("isnull(dr,0)=0 and fstatusflag=1");
		Object[] objs = new DocViewAppService().queryByWhereSql(sb.toString());
		return objs;
	}

	public LoginContext getLogin() {
		return login;
	}

	public void setLogin(LoginContext login) {
		this.login = login;
	}

}
