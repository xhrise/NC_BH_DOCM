package nc.ui.docmng.docproperty.treemanage;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.commons.lang.StringUtils;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.trade.business.HYPubBO;
import nc.itf.uap.IUAPQueryBS;
import nc.ui.docmng.docproperty.util.DocmngUtil;
import nc.ui.pubapp.uif2app.model.IQueryService;
import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.uif2.components.pagination.BillManagePaginationDelegator;
import nc.ui.uif2.components.pagination.IPaginationModelListener;
import nc.ui.uif2.components.pagination.PaginationModel;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.ui.uif2.model.IAppModelDataManager;
import nc.ui.uif2.model.IAppModelDataManagerEx;
import nc.ui.uif2.model.IQueryAndRefreshManager;
import nc.uif.pub.exception.UifException;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.pub.SqlBuilder;

public class DocViewModelDataManager implements IAppModelDataManagerEx,
		IQueryAndRefreshManager, IPaginationModelListener,IQueryService {

	BillManageModel model;
	
	private String whereSql ;

	public String getWhereSql() {
		return whereSql;
	}

	public void setWhereSql(String whereSql) {
		this.whereSql = whereSql;
	}

	public HierachicalDataAppModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(HierachicalDataAppModel treeModel) {
		this.treeModel = treeModel;
	}

	PaginationModel paginationModel;
	

	private HierachicalDataAppModel treeModel;
	
	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
	}

	public PaginationModel getPaginationModel() {
		return paginationModel;
	}

	public void setPaginationModel(PaginationModel paginationModel) {
		this.paginationModel = paginationModel;
		this.paginationModel.addPaginationModelListener(this);
	}

	public void setDelegator(BillManagePaginationDelegator delegator) {
		this.delegator = delegator;
	}

	private BillManagePaginationDelegator delegator;
	
	
	public BillManagePaginationDelegator getDelegator() {
		if (delegator == null) {
			delegator = new BillManagePaginationDelegator(getModel(),
					getPaginationModel());
		}
		return delegator;
	}
	
	public DocViewModelDataManager(){
		super();
	}
	
	@Override
	public void initModel() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void onStructChanged() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void onDataReady() {
	}

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void initModelBySqlWhere(String sqlWhere) {
		try {
			if (StringUtils.isEmpty(sqlWhere)) {
				sqlWhere = "1=1 and dr = 0";
			}
			/**
			 * lxiaofan
			 * 这里根据条件查询出符合树节点条件的管理型单据的主键集合
			 */
			String[] pks = (String[]) new DocViewAppModelService()
					.queryCusts(getModel().getContext(), sqlWhere);
			/**
			 * lxiaofan
			 * 
			 */
			Object[] objs = null;
			if(this.whereSql==null||this.whereSql.equals("")){
				objs = new DocViewAppModelService().queryObjectByPks(pks);
			}
			else{
				SqlBuilder sb = new SqlBuilder();

				sb.append(this.whereSql);
				if(pks!=null){
					sb.append(" and ");
					sb.append("pk_doctype", pks);
					sb.append(" and ");
					sb.append("fstatusflag", 1);
					objs= new DocTypeAppModelService().queryByWhereSql(sb.toString());
				}
			}
//			if(objs!=null){
//
//				Map<String,List<AggDocProperty>> map = DocmngUtil.findAllDocProperty(objs);
//				DocmngUtil.filterTree(map, this.treeModel);
//			}

			getModel().initModel(objs);
			
//			getModel()..setObjectPks(pks);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}

	}

	@Override
	public void setShowSealDataFlag(boolean showSealDataFlag) {
		// TODO 自动生成的方法存根

	}

	@Override
	public Object[] queryByWhereSql(String whereSql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object[] queryBillModel(String sql) throws Exception{
		if(this.whereSql == null || this.whereSql.equals(""))
			return null;
		/**
		 * lxiaofan
		 * 这里根据传递的树节点的参数查询VO
		 * 返回的是Object[]，可以是表头集，也可以是聚合VO集；
		 * 以下仅演示，简单处理；
		 * 需要注意的是，这里的返回对象类型需要与config.xml里的卡控件对应类，
		 * 即这里的MaterialBillForm里的synchronizeDataFromModel方法同步；
		 */
		List<AggDocProperty[]> result = new ArrayList<AggDocProperty[]>();
		AggDocProperty[] billvos = (AggDocProperty[])HYPubBO_Client.queryBillVOByCondition(new String[]{
				AggDocProperty.class.getName(),DocProperty.class.getName()}
		, this.whereSql);
		if(billvos!=null&&billvos.length>0){
			result.add(billvos);
		}
		
		if(null != result && result.size() > 0){
			return result.get(0);
		}else{
			return null;
		}
	
	}
	
	public Object[] queryTreeModel(String sql) throws Exception{
		List<DocType> result = new ArrayList<DocType>();
		Collection c = NCLocator
				.getInstance()
				.lookup(IUAPQueryBS.class)
				.retrieveByClause(DocType.class,
						sql);
		result.addAll(c);
		return result.toArray(new DocType[0]);
	}

}
