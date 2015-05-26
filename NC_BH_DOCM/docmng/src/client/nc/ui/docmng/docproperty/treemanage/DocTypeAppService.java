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
import nc.ui.uif2.model.IAppModelService;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.docmng.dmpowerdetail.DmPowerDetail;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.BusinessException;
import nc.vo.pub.query.IQueryConstants;
import nc.vo.pubapp.AppContext;
import nc.vo.pubapp.pattern.pub.SqlBuilder;
import nc.vo.uap.rbac.role.RoleVO;
import nc.vo.uif2.LoginContext;

@SuppressWarnings("restriction")
public class DocTypeAppService implements IAppModelService,IQueryService {

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
		String[] docTypes = this.queryCanbeUsedType();
		SqlBuilder sb = new SqlBuilder();
		if(docTypes==null||docTypes.length<=0){
			sb.append("1<>1");
		}else{
			sb.append("pk_doctype", docTypes);
		}
		Collection c = this.getQueryBS()
				.retrieveByClause(DocType.class,
						sb.toString());
		result.addAll(c);
		return result.toArray(new DocType[0]);
	}
	
	
	private String[] queryCanbeUsedType() throws BusinessException{
		String[] ruleKeys = this.queryAllRoleOfUserInGroup();
		if(ruleKeys==null || ruleKeys.length<=0){
			return null;
		}
		String [] powerKeys = this.queryPowerPkByRule(ruleKeys);
		if(powerKeys==null || powerKeys.length<=0){
			return null;
		}
		SqlBuilder sb = new SqlBuilder();
		sb.append("pk_power", powerKeys);
		Collection c = this.getQueryBS().retrieveByClause(DmPowerDetail.class, sb.toString());
		DmPowerDetail[] details = (DmPowerDetail[]) c.toArray(new DmPowerDetail[0]);
		Set<String> set = new HashSet<String>();
		if(details==null||details.length<=0)
			return null;
		for(int i = 0;i<details.length;i++){
			set.add(details[i].getPk_doctype());
		}
		return set.toArray(new String[0]);
	}
	
	private String[] queryPowerPkByRule(String[] pks) throws BusinessException{
		SqlBuilder sb = new SqlBuilder();
		sb.append("pk_role", pks);
		Collection power = this.getQueryBS().retrieveByClause(DmPower.class, sb.toString());
		DmPower[] powers = (DmPower[]) power.toArray(new DmPower[0]);
		if(powers==null || powers.length<=0){
			return null;
		}
		String[] keys = new String[powers.length];
		for(int i = 0;i<powers.length;i++){
			keys[i] = powers[i].getPk_power();
		}
		return keys;
	}
	
	private String[] queryAllRoleOfUserInGroup() throws BusinessException{
		RoleVO[] rules = NCLocator.getInstance().lookup(IRoleManageQuery.class).queryAllRoleOfUserInGroup(AppContext.getInstance().getPkUser(), AppContext.getInstance().getPkGroup());
		String [] keys = new String[rules.length];
		for(int i = 0;i<rules.length;i++){
			keys[i] = rules[i].getPk_role();
		}
		return keys;
	}

	@Override
	public Object[] queryByWhereSql(String whereSql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private IUAPQueryBS getQueryBS(){
		return NCLocator
				.getInstance()
				.lookup(IUAPQueryBS.class);
	}

}
