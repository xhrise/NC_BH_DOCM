package nc.ui.docmng.docproperty.action;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ufida.web.html.Doctype;

import nc.ui.docmng.docproperty.treemanage.DocTypeModelDataManager;
import nc.ui.docmng.docproperty.util.DocmngUtil;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pubapp.pattern.pub.SqlBuilder;
import nc.vo.querytemplate.queryscheme.SimpleQuerySchemeVO;

public class QueryAction extends DefaultQueryAction {
	

	private HierachicalDataAppModel treeModel;
	private BillManageModel manageAppModel;
	private DocTypeModelDataManager manageModelDataManager;

	public HierachicalDataAppModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(HierachicalDataAppModel treeModel) {
		this.treeModel = treeModel;
	}

	public BillManageModel getManageAppModel() {
		return manageAppModel;
	}

	public void setManageAppModel(BillManageModel manageAppModel) {
		this.manageAppModel = manageAppModel;
	}

	public DocTypeModelDataManager getManageModelDataManager() {
		return manageModelDataManager;
	}

	public void setManageModelDataManager(
			DocTypeModelDataManager manageModelDataManager) {
		this.manageModelDataManager = manageModelDataManager;
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		if (this.getQryDLGDelegator().showModal() == UIDialog.ID_OK) {
			this.processQuery();
		}
	}
	
	private void processQuery() throws Exception {
		IQueryScheme queryScheme = this.getQryDLGDelegator().getQueryScheme();
		String where = (String) queryScheme.get(IQueryScheme.KEY_SQL_WHERE);
		DocType classVO = (DocType) getTreeModel()
				.getSelectedData();
		String classID = classVO == null ? "" : classVO.getPrimaryKey();
		
		/**
		 * lxiaofan
		 * 这里构建根据树节点相关参数查询管理单据主键的过滤条件
		 */
		String sql = " pk_doctype = '"+classID+"'";
		/**
		 * lxiaofan end
		 */
		String whereSql = queryScheme.get(IQueryScheme.KEY_SQL_WHERE).toString();
		getManageModelDataManager().setWhereSql(whereSql);
		Object[] objs = getManageModelDataManager().queryBillModel(whereSql);

		Set<String> set = new HashSet<String>();
			Map<String,List<AggDocProperty>> map = DocmngUtil.findAllDocProperty(objs);
			DocmngUtil.filterTree(map, this.treeModel);
			this.getTreeModel().fireEvent(new AppEvent(this.getTreeModel().SELECTION_CHANGED,getTreeModel(),null));
		
	}

	
	
	
	
}
