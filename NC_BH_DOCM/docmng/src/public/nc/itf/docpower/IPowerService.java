package nc.itf.docpower;

import nc.vo.bd.meta.BatchOperateVO;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.pub.BusinessException;
import nc.vo.uap.rbac.BusiFuncItemSmartVO;

public interface IPowerService {

	

	public void deletePower(DmPower[] vo) throws BusinessException;
	
	public DmPower insertPower(DmPower vo) throws BusinessException;	
	
	public DmPower updatePower(DmPower vo) throws BusinessException;

	BusiPowerItem[] batchAssignedAndRemovedItems(
			String pk_power, BatchOperateVO vo)
			throws BusinessException;

	BusiPowerItem[] batchAssignedAndRemovedItems(String pk_power,
			BusiPowerItem[] toAdds, BusiPowerItem[] toRemoves)
			throws BusinessException;
}
