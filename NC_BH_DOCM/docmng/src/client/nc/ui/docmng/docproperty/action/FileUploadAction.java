package nc.ui.docmng.docproperty.action;

import java.awt.event.ActionEvent;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.pub.filesystem.IQueryFolderTreeNodeService;
import nc.bs.uif2.BusinessExceptionAdapter;
import nc.bs.uif2.IActionCode;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.docmng.IDocpropertyMaintain;
import nc.md.MDBaseQueryFacade;
import nc.md.data.access.NCObject;
import nc.md.model.IBean;
import nc.md.model.IBusinessEntity;
import nc.pub.filesystem.newui.FileBroseConst;
import nc.pub.filesystem.newui.FileContentPanel;
import nc.pub.filesystem.newui.FileManageTreeRenderer;
import nc.pub.filesystem.newui.FileManageTreeUI;
import nc.ui.docmng.docproperty.dialog.ProjectChooseDialog;
import nc.ui.docmng.docproperty.util.DocmngUtil;
import nc.ui.ml.NCLangRes;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UIFileChooser;
import nc.ui.pub.beans.UITree;
import nc.ui.pub.bill.BillStatus;
import nc.ui.pub.filesystem.FileManageServletClient;
import nc.ui.pub.msg.FileChoosePanel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillCardPanelForm;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;
import nc.ui.uif2.IExceptionHandler;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.UIState;
import nc.ui.uif2.actions.ActionInitializer;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.vo.arap.pub.BillEnumCollection.ApproveStatus;
import nc.vo.bd.meta.IBDObject;
import nc.vo.bd.meta.NCObject2BDObjectAdapter;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.BusinessException;
import nc.vo.pub.filesystem.NCFileNode;
import nc.vo.pubapp.AppContext;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.vo.pubapp.pattern.model.transfer.bill.ClientBillCombinServer;

import java.io.FileInputStream;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class FileUploadAction extends NCAction {
	/**
	 * 
	 */

	private boolean isGoing = false;

	private static final long serialVersionUID = 1L;

	private SaveAction saveAction;

	private AggDocProperty aggVO;

	private HierachicalDataAppModel hAppModel;

	public HierachicalDataAppModel gethAppModel() {
		return hAppModel;
	}

	public void sethAppModel(HierachicalDataAppModel hAppModel) {
		this.hAppModel = hAppModel;
		this.hAppModel.addAppEventListener(this);
	}

	private String rootDirStr;
	protected NCFileNode rootNode;

	private ShowUpableBillListView listView;

	private ShowUpableBillForm billForm;

	public ShowUpableBillForm getBillForm() {
		return billForm;
	}

	public void setBillForm(ShowUpableBillForm billForm) {
		this.billForm = billForm;
	}

	public ShowUpableBillListView getListView() {
		return listView;
	}

	public void setListView(ShowUpableBillListView listView) {
		this.listView = listView;
	}

	/**
	 * 左边树的model
	 */
	private DefaultTreeModel treemodel = null;

	private boolean isCard = false;

	public SaveAction getSaveAction() {
		return saveAction;
	}

	public void setSaveAction(SaveAction saveAction) {
		this.saveAction = saveAction;
	}

	public FileUploadAction() {
		this.putValue(
				AbstractAction.NAME,
				NCLangRes.getInstance().getStrByID("sftemp",
						"UploadAction-0000")/* 上传附件 */);
		this.putValue(Action.SHORT_DESCRIPTION, NCLangRes.getInstance()
				.getStrByID("sftemp", "UploadAction-0000")/* 上传附件 */);
		// this.putValue(AbstractAction.SMALL_ICON,
		// ClientToolKit.loadImageIcon("images/filesystem/newfolder.png"));
	}

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
		// FileChoosePanel chooser = new FileChoosePanel();
		// UIFileChooser uiChooser = chooser.getFileChooser();
		// uiChooser.setMultiSelectionEnabled(true);
		// File[] files;
		// if(uiChooser.showOpenDialog(null) == UIFileChooser.APPROVE_OPTION){
		// files = uiChooser.getSelectedFiles();
		// if(files==null|| files.length==0)
		// return;
		// int len = files.length;
		// FileInputStream input = null;
		// String dsName =
		// WorkbenchEnvironment.getInstance().getLoginBusiCenter().getDataSourceName();
		// String creator =
		// WorkbenchEnvironment.getInstance().getLoginUser().getCuserid();
		// AggDocProperty docp = (AggDocProperty)this.model.getSelectedData();
		// DocProperty parent = docp.getParentVO();
		// String key = parent.getPrimaryKey();
		// for(int i = 0;i<len;i++){
		// input = new FileInputStream(files[i]);
		// String fileName = files[i].getName();
		// String pPath = "filesaver/"+key+"/"+files[i].getName();
		// NCFileNode node = FileManageServletClient.uploadFile(dsName, pPath,
		// fileName, input, creator, files[i].length());
		//
		// }
		// }

		if (!isGoing)
			return;

		this.treemodel = null;
		this.rootDirStr = null;
		this.rootNode = null;

		Object selectedData = this.model.getSelectedData();

		JFileChooser chooser = new JFileChooser();
		// 要求上传多个文件
		chooser.setMultiSelectionEnabled(true);
		if (chooser.showOpenDialog(this.listView) == JFileChooser.APPROVE_OPTION) {
			File[] arrfiles = chooser.getSelectedFiles();
			if (arrfiles == null || arrfiles.length == 0) {
				// 没有选择文件退出
				return;
			}
			for (File file : arrfiles) {
				String fileName = file.getName();
				long size = (long) FileBroseConst.getfilelimit() * 1024L * 1024L;
				if (size < file.length()) {
					MessageDialog.showErrorDlg(
							null,
							NCLangRes.getInstance().getStrByID("sftemp",
									"UploadAction-0001")/* 文件超过限制 */,
							NCLangRes.getInstance().getStrByID("sftemp",
									"UploadAction-0002", null,
									new String[] { fileName })/*
															 * {0}大小超过限制不能上传！
															 */);
					return;
				}
			}
			IDocpropertyMaintain mainTain = NCLocator.getInstance().lookup(
					IDocpropertyMaintain.class);
			this.aggVO.getParentVO().setVname(arrfiles[0].getName());
			AggDocProperty[] vo = mainTain.insert(
					new AggDocProperty[] { this.aggVO }, null);
			new ClientBillCombinServer<IBill>()
					.combine((IBill[]) new AggDocProperty[] { this.aggVO },
							(IBill[]) vo);
			this.model.directlyAdd(this.aggVO);
			selectedData = this.model.getSelectedData();
			IBDObject target = this.createBDObject(selectedData);
			if (target == null)
				return;
			this.rootDirStr = (String) target.getId();

			this.getTreemodel();

			if (this.rootNode == null) {
				return;
			}
			TreePath path = new TreePath(this.rootNode.getPath());
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
					.getLastPathComponent();

			String pPath = "";
			if (node instanceof NCFileNode) {
				pPath = ((NCFileNode) node).getFullPath();
				pPath = DocmngUtil.path + pPath;
			}
			// File file = chooser.getSelectedFile();
			// 多文件上传

			String dsName = WorkbenchEnvironment.getInstance()
					.getLoginBusiCenter().getDataSourceName();

			String creator = WorkbenchEnvironment.getInstance().getLoginUser()
					.getCuserid();
			FileInputStream input = null;

			try {
				for (File file : arrfiles) {
					String fileName = file.getName();
					// //校验是否同名
					// if(parentpanel.CheckTheSameFileName((NCFileNode)node,
					// fileName)){
					// continue ;
					// }
					// 检查 附件大小 ,文件超过 参数设置的大小不能上传

					input = new FileInputStream(file);
					NCFileNode newNode = FileManageServletClient.uploadFile(
							dsName, pPath, fileName, input, creator,
							file.length());
					if (newNode != null) {
						// NCFileVO newfilevo = new NCFileVO();
						// newfilevo.set
						// newfilevo.setPath(newpath+newaddfilevo.getFullPath());
						// newfilevo.setCreator(newaddfilevo.getCreator());
						// newfilevo.setTime(newaddfilevo.getTime());
						// newfilevo.setFileLen(newaddfilevo.getFileLen());
						// parentpanel.nodeToFileVO((NCFileNode)node, newNode);
					}
				}
			} catch (Exception ex) {
				Logger.error(ex.getMessage(), ex);
				MessageDialog.showErrorDlg(
						null,
						NCLangRes.getInstance().getStrByID("pc",
								"FileManageUI-000000")/* 错误 */,
						NCLangRes.getInstance().getStrByID("sftemp",
								"UploadAction-0003")/* 上传时发生错误！ */);
			} finally {
				try {
					if (input != null) {
						input.close();
					}
				} catch (Exception e2) {
				}
			}
		}
	}

	@Override
	protected boolean isActionEnable() {
		// TODO Auto-generated method stub
		DocType docType = (DocType) this.gethAppModel().getSelectedData();
		if (docType == null || docType.getPk_doctype() == null
				|| docType.getPk_doctype().equals(""))
			return false;
		if (this.billForm.isShowing())
			return false;
		return super.isActionEnable();
	}

	@SuppressWarnings("unchecked")
	NCFileNode findNode(NCFileNode node, String path) {
		Enumeration<NCFileNode> enumer = node.breadthFirstEnumeration();
		NCFileNode retrNode = null;
		while (enumer.hasMoreElements()) {
			NCFileNode tempNode = (NCFileNode) enumer.nextElement();
			if (tempNode.getFullPath().equals(path)) {
				retrNode = tempNode;
				// retrNode.setParent(null);
				break;
			}
		}
		return retrNode;
	}

	protected DefaultTreeModel getTreemodel() {
		if (treemodel == null) {
			treemodel = new DefaultTreeModel(null);
			treemodel.setAsksAllowsChildren(true);

			try {
				if (rootDirStr != null) {
					IQueryFolderTreeNodeService service = NCLocator
							.getInstance().lookup(
									IQueryFolderTreeNodeService.class);
					NCFileNode node = service.getNCFileNodeTreeAndCreateAsNeed(
							rootDirStr, WorkbenchEnvironment.getInstance()
									.getLoginUser().getCuserid());
					rootNode = findNode(node, rootDirStr);
				} else {
					rootNode = null;
				}

				treemodel.setRoot(rootNode);
				treemodel.nodeStructureChanged(rootNode);

			} catch (BusinessException e) {
				Logger.error(e);
			}
		}
		return treemodel;
	}

	public IBDObject createBDObject(Object obj) {
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

	@Override
	protected void beforeDoAction() {
		// TODO Auto-generated method stub
		super.beforeDoAction();
		this.aggVO = new AggDocProperty();
		DocProperty parent = new DocProperty();
		AppContext appContext = AppContext.getInstance();
		ProjectChooseDialog dlg = new ProjectChooseDialog(this.listView);
		if (dlg.showModal() == UIDialog.ID_OK) {
			Map<String, String> map = dlg.getChoise();
			for (Map.Entry<String, String> enty : map.entrySet()) {
				parent.setAttributeValue(enty.getKey(), enty.getValue());
			}
			this.isGoing = true;
		} else {
			this.isGoing = false;
		}
		parent.setPk_group(AppContext.getInstance().getPkGroup());
		parent.setPk_org("GLOBLE00000000000000");
		parent.setCreator(appContext.getPkUser());
		parent.setCreationtime(appContext.getServerTime());
		parent.setDbilldate(appContext.getBusiDate());
		parent.setBillmaker(appContext.getPkUser());
		parent.setFstatusflag(ApproveStatus.NOSTATE.VALUE);
		parent.setBilltype("0001ZZ1000000000PHMJ");
		parent.setPk_doctype(this.gethAppModel().getSelectedData() == null ? null
				: ((DocType) this.gethAppModel().getSelectedData())
						.getPk_doctype());
		aggVO.setParent(parent);
	}

}
