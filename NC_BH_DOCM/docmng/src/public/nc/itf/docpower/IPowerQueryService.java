package nc.itf.docpower;

import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.pub.BusinessException;

public interface IPowerQueryService {

	/**
	 * <b>查询符合条件con的权限PKs</b>
	 * 
	 * @return PKs[]
	 * @throws BusinessException
	 */
	String[] queryPowerPKsByCondition(String con) throws BusinessException;

	public BusiPowerItem[] queryAllBusiItemsByGroup(String pk_group)
			throws BusinessException;

	public DmPower[] queryPowerVOByPKs(String[] pk_power)
			throws BusinessException;

	public DmPower[] queryDmPowerByCondition(String con)
			throws BusinessException;

	BusiPowerItem[] queryBusiFuncItemsByResp(String pk_power)
			throws BusinessException;

	DmPower[] queryPowerByPKs(String[] pks) throws BusinessException;
}
