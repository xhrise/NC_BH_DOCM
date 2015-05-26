package nc.ui.docmng.docproperty.treemanage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.itf.uap.rbac.IRoleManageQuery;
import nc.ui.pubapp.uif2app.model.IQueryService;
import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.docmng.dmpowerdetail.DmPowerDetail;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.BusinessException;
import nc.vo.pub.query.IQueryConstants;
import nc.vo.pubapp.AppContext;
import nc.vo.pubapp.pattern.pub.SqlBuilder;
import nc.vo.uap.rbac.role.RoleVO;
import nc.vo.uif2.LoginContext;

@SuppressWarnings("restriction")
public class DocViewAppService implements IAppModelService,IQueryService {

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
		// lxiaofan
		// 该方法读取树数据，其后在BDObjectAdpaterFactory中的createBDObject方法里根据树所在元数据进行层级构造
		final List<DocType> result = new ArrayList<DocType>();

		Collection c = this.getQueryBS()
				.retrieveByClause(DocType.class,
						"1=1 and isnull(dr,0)=0");
		result.addAll(c);
		return result.toArray(new DocType[0]);
	}
	
	private IUAPQueryBS getQueryBS(){
		return NCLocator
				.getInstance()
				.lookup(IUAPQueryBS.class);
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
