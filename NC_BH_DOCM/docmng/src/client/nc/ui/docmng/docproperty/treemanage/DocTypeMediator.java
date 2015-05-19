package nc.ui.docmng.docproperty.treemanage;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import nc.ui.docmng.docproperty.util.DocmngUtil;
import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.AppEventListener;
import nc.ui.uif2.UIState;
import nc.ui.uif2.model.AppEventConst;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.uif.pub.exception.UifException;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pubapp.pattern.pub.SqlBuilder;

public class DocTypeMediator implements AppEventListener {

	private String whereSql;

	public String getWhereSql() {
		return whereSql;
	}

	public void setWhereSql(String whereSql) {
		this.whereSql = whereSql;
	}

	public DocTypeMediator() {
		super();
	}

	private HierachicalDataAppModel treeModel;
	private BillManageModel manageAppModel;
	private DocTypeModelDataManager manageModelDataManager;

	public HierachicalDataAppModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(HierachicalDataAppModel treeModel) {
		this.treeModel = treeModel;
		treeModel.addAppEventListener(this);
	}

	public BillManageModel getManageAppModel() {
		return manageAppModel;
	}

	public void setManageAppModel(BillManageModel manageAppModel) {
		this.manageAppModel = manageAppModel;
		this.manageAppModel.addAppEventListener(this);
	}

	public DocTypeModelDataManager getManageModelDataManager() {
		return manageModelDataManager;
	}

	public void setManageModelDataManager(
			DocTypeModelDataManager manageModelDataManager) {
		this.manageModelDataManager = manageModelDataManager;
	}

	public static String TREE_STATUS_CHANGED = "TREE_STATUS_CHANGED";
	public static int TREE_DISABLE = 1;
	public static int TREE_ENABLE = 0;

	@Override
	public void handleEvent(AppEvent event) {
		if (event.getSource() == getManageAppModel()) {// ���ݳ�ʼ���ж�
			Object[] treedatas = getTreeModel().getAllDatas();
			if (AppEventConst.MODEL_INITIALIZED.equals(event.getType())
					&& (null == treedatas || treedatas.length <= 0)) {// ֻ��������Ϊ�գ���δ����ʱִ�У�������ѭ��
				try {
					Object[] data = getTreeModel().getService()
							.queryByDataVisibilitySetting(
									getManageAppModel().getContext());
					if (data != null && data.length > 0) {
						getTreeModel().initModel(data);
						fillInFigure(data);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else if (AppEventConst.DATA_INSERTED.equals(event.getType())
					|| AppEventConst.DATA_UPDATED.equals(event.getType())
					|| AppEventConst.DATA_DELETED.equals(event.getType())) {
				this.getTreeModel().fireEvent(
						new AppEvent(this.getTreeModel().SELECTED_DATE_CHANGED,
								getTreeModel(), null));
			}
		} else if (event.getSource() == getTreeModel()) {
			/**
			 * lxiaofan ��ѡ��ı��¼�
			 */
			if (AppEventConst.SELECTION_CHANGED.equals(event.getType())) {
				DocType classVO = (DocType) getTreeModel().getSelectedData();
				String classID = classVO == null ? "" : classVO.getPrimaryKey();

				/**
				 * lxiaofan ���ﹹ���������ڵ���ز�����ѯ�����������Ĺ�������
				 */
				String sql = " pk_doctype = '" + classID + "' ";
				/**
				 * lxiaofan end
				 */

				getManageModelDataManager().initModelBySqlWhere(sql);
			} else if (AppEventConst.SELECTED_DATE_CHANGED.equals(event
					.getType())) {
				DefaultMutableTreeNode node = getTreeModel().getSelectedNode();
				int rowCount = this.getManageAppModel().getRowCount();
				DocType docType = (DocType) node.getUserObject();
				String pk_doctype = docType.getPk_doctype();
				try {
					DocType dt = (DocType) HYPubBO_Client.queryByPrimaryKey(
							DocType.class, docType.getPk_doctype());
					dt.setName(dt.getName() + " (" + rowCount
							+ ")");
					node.setUserObject(dt);
					treeModel.getTree().nodeChanged(node);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			if (AppEventConst.UISTATE_CHANGED.equals(event.getType())) {
				if (getManageModelDataManager().getModel().getUiState() == UIState.EDIT) {
					getTreeModel().fireEvent(
							new AppEvent(TREE_STATUS_CHANGED, getTreeModel(),
									TREE_DISABLE));
				} else {
					getTreeModel().fireEvent(
							new AppEvent(TREE_STATUS_CHANGED, getTreeModel(),
									TREE_ENABLE));
				}
			}
		}
		/** ��������������**lxiaofan**2013-01-15**START **/
		/**
		 * ����ʽ�Ƚ�׾�ӣ���Ѱ���·���
		 */
		if (event instanceof nc.ui.pubapp.uif2app.event.billform.AddEvent) {
			Object obj = getTreeModel().getSelectedNode().getUserObject();
			if (null != obj && obj instanceof DocType) {
				String treepk = ((DocType) obj).getPrimaryKey();
				nc.ui.pubapp.bill.BillCardPanel cp = (nc.ui.pubapp.bill.BillCardPanel) ((nc.ui.pubapp.uif2app.event.billform.AddEvent) event)
						.getBillForm().getBillCardPanel();
				cp.setHeadItem("pk_doctype", treepk);
			}
		}

	}

	private void fillInFigure(Object[] data) throws Exception {
		String[] keys = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			DocType docType = (DocType) data[i];
			String key = docType.getPk_doctype();
			keys[i] = key;
		}
		SqlBuilder sb = new SqlBuilder();
		sb.append("pk_doctype", keys);
		Object[] objs = new DocTypeAppModelService().queryByWhereSql(sb
				.toString());
		Map<String, List<AggDocProperty>> map = DocmngUtil
				.findAllDocProperty(objs);
		DocmngUtil.filterTree(map, this.treeModel);

	}

}
