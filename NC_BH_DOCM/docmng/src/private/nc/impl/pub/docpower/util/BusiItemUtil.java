package nc.impl.pub.docpower.util;

import java.util.List;

import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.BeanListProcessor;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.power.util.SQLUtil;
import nc.vo.pub.BusinessException;
import nc.vo.uap.rbac.BusiFuncItemVO;
import nc.vo.uap.rbac.util.RbacSqlUtils;
import nc.vo.util.SqlWrapper;

public class BusiItemUtil {
	@SuppressWarnings("unchecked")
	public List<BusiPowerItem> getAllItemsList(String pk_group)
			throws BusinessException {
		BaseDAO dao = new BaseDAO();
		String sql = SQLUtil.All_POWERITEM_SQL;
		SQLParameter sp = new SQLParameter();
		sp.addParam(pk_group);

		List<BusiPowerItem> menuItems = (List<BusiPowerItem>) dao.executeQuery(
				sql, sp, new BeanListProcessor(BusiPowerItem.class));
		return menuItems;
	}

	@SuppressWarnings("unchecked")
	public List<BusiPowerItem> getMenuItemsMapByResp(String pk_power)
			throws BusinessException {
		BaseDAO dao = new BaseDAO();
		String sql = SQLUtil.ASSIGN_POWERITEM_SQL;
		SQLParameter sp = new SQLParameter();
		sp.addParam(pk_power);
		List<BusiPowerItem> menuItems = (List<BusiPowerItem>) dao.executeQuery(
				sql, sp, new BeanListProcessor(BusiPowerItem.class));
		return menuItems;
	}
}
