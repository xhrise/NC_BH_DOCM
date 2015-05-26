package nc.impl.pub.docpower;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.impl.pub.docpower.util.BusiItemUtil;
import nc.itf.docpower.IPowerQueryService;
import nc.uap.rbac.core.rule.sql.ISQLNode;
import nc.uap.rbac.core.rule.sql.SQLNodeFactory;
import nc.uap.rbac.core.sqlprovider.func.RespAuthPermWherePartProvider;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.trade.sqlutil.IInSqlBatchCallBack;
import nc.vo.trade.sqlutil.InSqlBatchCaller;
import nc.vo.trade.voutils.VOUtil;
import nc.vo.uap.rbac.BusiFuncItemSmartVO;
import nc.vo.uap.rbac.BusiFuncItemVO;
import nc.vo.uap.rbac.ResponsibilityVO;
import nc.vo.uap.rbac.util.BusiFuncItemHelper;

public class PowerQueryServiceImpl implements IPowerQueryService {
	
	
	
	@SuppressWarnings("unchecked")
	public DmPower[] queryDmPowerByCondition(String con)
			throws BusinessException {
		if (StringUtil.isEmptyWithTrim(con))
			con = "1=1";
		
		BaseDAO dao = new BaseDAO();
		
		List<DmPower> voList = (List<DmPower>) dao.retrieveByClause(DmPower.class, con);
		
		return voList == null ? null : voList.toArray(new DmPower[voList.size()]);
	}

	@Override
	public String[] queryPowerPKsByCondition(String con)
			throws BusinessException {	
		DmPower[] vos = queryDmPowerByCondition(con);
		List<String> voPKList = new ArrayList<String>();
		if(!ArrayUtils.isEmpty(vos))
			voPKList = VOUtil.extractFieldValues(vos, "pk_power", null);
		return voPKList == null ? null : voPKList.toArray(new String[voPKList.size()]);
		

	}
	
	
	public DmPower[] queryPowerVOByPKs(String[] pk_power)
			throws BusinessException{
		DmPower[] vOArray = null;
		try{
			InSqlBatchCaller caller = new InSqlBatchCaller(pk_power);
			vOArray = (DmPower[])caller.execute(new IInSqlBatchCallBack(){
				
				private List<DmPower> respList = new ArrayList<DmPower>();
				
				@Override
				public Object doWithInSql(String inSql) throws BusinessException,SQLException {
					BaseDAO dao = new BaseDAO();
					String condition = "pk_power"+" in "+inSql;
					Collection<DmPower> resultVOColl = dao.retrieveByClause(DmPower.class, condition);
					
					respList.addAll(resultVOColl);
					
					return respList.toArray(new DmPower[0]);
				}
				
			});
		}catch(SQLException e){
			throw new BusinessException(e);
		}		
		return vOArray;
	}

	@Override
	public BusiPowerItem[] queryAllBusiItemsByGroup(String pk_group)
			throws BusinessException {
		BusiItemUtil util = new BusiItemUtil();
		List<BusiPowerItem> items= util.getAllItemsList(pk_group);
		return items.toArray(new BusiPowerItem[0]);
	}

	@Override
	public BusiPowerItem[] queryBusiFuncItemsByResp(String pk_power)	throws BusinessException {
		//初始化资源功能项实用工具
		BusiItemUtil busiFuncUtil = new BusiItemUtil();
		
		// 查询该责任对应的功能菜单
		List<BusiPowerItem> menuItems = busiFuncUtil.getMenuItemsMapByResp(pk_power);
		
		if (menuItems == null)
			return null;
		
		return menuItems.toArray(new BusiPowerItem[menuItems.size()]);
	}
	
	
	@SuppressWarnings("unchecked")
	public DmPower[] queryPowerByPKs(String[] pks)
			throws BusinessException {
		DmPower[] voArray = null;
		try{
			InSqlBatchCaller caller = new InSqlBatchCaller(pks);
			voArray = (DmPower[])caller.execute(new IInSqlBatchCallBack(){
				
				private List<DmPower> list = new ArrayList<DmPower>();
				
				@Override
				public Object doWithInSql(String inSql) throws BusinessException,SQLException {
					BaseDAO dao = new BaseDAO();
					String condition =  "pk_power in "+inSql;
					Collection<DmPower> resultVOColl = dao.retrieveByClause(DmPower.class, condition);
					
					list.addAll(resultVOColl);
					
					return list.toArray(new DmPower[0]);
				}
				
			});
		}catch(SQLException e){
			throw new BusinessException(e);
		}		
		return voArray;
	}
	
}
