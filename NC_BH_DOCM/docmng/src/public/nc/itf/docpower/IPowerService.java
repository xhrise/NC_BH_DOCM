package nc.itf.docpower;

import nc.vo.docmng.dmpower.DmPower;
import nc.vo.pub.BusinessException;

public interface IPowerService {

	

	public void deletePower(DmPower[] vo) throws BusinessException;
	
	public DmPower insertPower(DmPower vo) throws BusinessException;	
	
	public DmPower updatePower(DmPower vo) throws BusinessException;
}
