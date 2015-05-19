package nc.itf.docpower;

import nc.vo.pub.BusinessException;

public interface IPowerQueryService {
	
    /**
	 * <b>查询符合条件con的权限PKs</b>
	 * @return PKs[]
	 * @throws BusinessException
	 */
    String[] queryPowerPKsByCondition(String con) throws BusinessException;
}
