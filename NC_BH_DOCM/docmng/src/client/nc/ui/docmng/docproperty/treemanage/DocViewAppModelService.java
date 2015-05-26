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
		 * ������ݴ��ݵ����ڵ�Ĳ�����ѯVO
		 * ���ص���Object[]�������Ǳ�ͷ����Ҳ�����Ǿۺ�VO����
		 * ���½���ʾ���򵥴���
		 * ��Ҫע����ǣ�����ķ��ض���������Ҫ��config.xml��Ŀ��ؼ���Ӧ�࣬
		 * �������MaterialBillForm���synchronizeDataFromModel����ͬ����
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
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Object update(Object object) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void delete(Object object) throws Exception {
		// TODO �Զ����ɵķ������

	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext context)
			throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}
	
	
	public Object[] queryCusts(LoginContext context, String condition)
			throws Exception {
		/**
		 * lxiaofan
		 * ��ѯ�����͵��ݵ�������
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
		 * ������ݴ��ݵ����ڵ�Ĳ�����ѯVO
		 * ���ص���Object[]�������Ǳ�ͷ����Ҳ�����Ǿۺ�VO����
		 * ���½���ʾ���򵥴���
		 * ��Ҫע����ǣ�����ķ��ض���������Ҫ��config.xml��Ŀ��ؼ���Ӧ�࣬
		 * �������MaterialBillForm���synchronizeDataFromModel����ͬ����
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
