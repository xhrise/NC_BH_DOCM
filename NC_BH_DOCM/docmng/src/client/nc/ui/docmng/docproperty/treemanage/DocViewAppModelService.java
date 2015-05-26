package nc.ui.docmng.docproperty.treemanage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ColumnListProcessor;
import nc.ui.pubapp.uif2app.model.IQueryService;
import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.pub.SqlBuilder;
import nc.vo.trade.sqlutil.IInSqlBatchCallBack;
import nc.vo.trade.sqlutil.InSqlBatchCaller;
import nc.vo.uif2.LoginContext;

public class DocViewAppModelService implements IAppModelService,
		IPaginationQueryService,IQueryService {
	
	public DocViewAppModelService(){
		super();
	}
	
	

	@Override
	public Object[] queryObjectByPks(String[] pks) throws BusinessException {
		if(pks == null || pks.length == 0)
			return null;
		SqlBuilder sb = new SqlBuilder();
		sb.append("pk_doctype", pks);
		/**
		 * lxiaofan
		 * 这里根据传递的树节点的参数查询VO
		 * 返回的是Object[]，可以是表头集，也可以是聚合VO集；
		 * 以下仅演示，简单处理；
		 * 需要注意的是，这里的返回对象类型需要与config.xml里的卡控件对应类，
		 * 即这里的MaterialBillForm里的synchronizeDataFromModel方法同步；
		 */
		sb.append(" and ");
		sb.append("fstatusflag", 1);
		final List<AggDocProperty[]> result = new ArrayList<AggDocProperty[]>();
		AggDocProperty[] billvos = (AggDocProperty[])HYPubBO_Client.queryBillVOByCondition(new String[]{
				AggDocProperty.class.getName(),DocProperty.class.getName()}
		,  
				sb.toString());
		if(billvos!=null&&billvos.length>0){
			result.add(billvos);
		}
		
		if(null != result && result.size() > 0){
			return result.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Object insert(Object object) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Object update(Object object) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void delete(Object object) throws Exception {
		// TODO 自动生成的方法存根

	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext context)
			throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}
	
	
	public Object[] queryCusts(LoginContext context, String condition)
			throws Exception {
		/**
		 * lxiaofan
		 * 查询管理型单据的主键集
		 */
		String sql = "select pk_doctype from docmng_doctype where isnull(dr,0) = 0 and " + condition;
		List<String> pkList = (List<String>) NCLocator.getInstance()
				.lookup(IUAPQueryBS.class)
				.executeQuery(sql, new ColumnListProcessor());
		return pkList == null || pkList.size() == 0 ? null : pkList
				.toArray(new String[0]);
	}



	@Override
	public Object[] queryByWhereSql(String whereSql) throws Exception {
		if(whereSql == null || whereSql.equals(""))
			return null;
		/**
		 * lxiaofan
		 * 这里根据传递的树节点的参数查询VO
		 * 返回的是Object[]，可以是表头集，也可以是聚合VO集；
		 * 以下仅演示，简单处理；
		 * 需要注意的是，这里的返回对象类型需要与config.xml里的卡控件对应类，
		 * 即这里的MaterialBillForm里的synchronizeDataFromModel方法同步；
		 */
		final List<AggDocProperty[]> result = new ArrayList<AggDocProperty[]>();
		AggDocProperty[] billvos = (AggDocProperty[])HYPubBO_Client.queryBillVOByCondition(new String[]{
				AggDocProperty.class.getName(),DocProperty.class.getName()}
		, whereSql);
		if(billvos!=null&&billvos.length>0){
			result.add(billvos);
		}
		
		if(null != result && result.size() > 0){
			return result.get(0);
		}else{
			return null;
		}
	}

}
