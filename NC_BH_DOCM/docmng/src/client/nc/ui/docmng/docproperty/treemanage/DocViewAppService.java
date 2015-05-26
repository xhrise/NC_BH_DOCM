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
		// lxiaofan
		// �÷�����ȡ�����ݣ������BDObjectAdpaterFactory�е�createBDObject���������������Ԫ���ݽ��в㼶����
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
