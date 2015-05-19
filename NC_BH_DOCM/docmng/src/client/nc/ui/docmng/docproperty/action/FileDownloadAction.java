package nc.ui.docmng.docproperty.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.pub.filesystem.IFileSystemService;
import nc.bs.uif2.BusinessExceptionAdapter;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.md.MDBaseQueryFacade;
import nc.md.data.access.NCObject;
import nc.md.model.IBean;
import nc.md.model.IBusinessEntity;
import nc.ui.ml.NCLangRes;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIFileChooser;
import nc.ui.pub.filesystem.FileManageServletClient;
import nc.ui.pub.filesystem.FileManageUI;
import nc.ui.pub.msg.FileChoosePanel;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.bd.meta.IBDObject;
import nc.vo.bd.meta.NCObject2BDObjectAdapter;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;

public class FileDownloadAction extends NCAction {
	
	private IFileSystemService fileService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994713240289773280L;
	private BillManageModel model;

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	@Override
	public void doAction(ActionEvent arg0) throws Exception {
		AggDocProperty aggVO = (AggDocProperty) this.model.getSelectedData();
		DocProperty parent = aggVO.getParentVO();
		String dsName = WorkbenchEnvironment.getInstance()
				.getLoginBusiCenter().getDataSourceName();
		String path = this.getFilePath();
		if(path!=null)
			FileManageServletClient.showFileInWeb(dsName, path);
	}

	public String getFilePath() throws BusinessException {
		AggDocProperty aggVO = (AggDocProperty) this.getModel().getSelectedData();
		if (aggVO == null) {
			return null;
		}
		IBDObject target = this.createBDObject(aggVO);
		DocProperty parent = aggVO.getParentVO();
		String path = (String) target.getId();
		StringBuilder sb = new StringBuilder(path);
		sb.append("/");
		sb.append(parent.getVname());
		return sb.toString();
	}


	
	
	private IBDObject createBDObject(Object obj) {
		if (obj == null) {
			return null;
		}

		if (obj instanceof String) {
			return null;
		}

		// 元数据
		try {
			String className = null;
			if (obj instanceof AbstractBill) {
				className = ((AbstractBill) obj).getParentVO().getClass()
						.getName();
			} else {
				className = obj.getClass().getName();
			}
			// TODO: 递归搜索父类所对应的元数据，以支持继承
			IBean bean = MDBaseQueryFacade.getInstance()
					.getBeanByFullClassName(className);
			if (bean == null) {
				return null;
			}
			Map<String, String> name_path_map = ((IBusinessEntity) bean)
					.getBizInterfaceMapInfo(IBDObject.class.getName());
			return new NCObject2BDObjectAdapter(NCObject.newInstance(obj),
					name_path_map);
		} catch (nc.md.model.MetaDataException e) {
			throw new BusinessExceptionAdapter(e);
		}
	}

}
