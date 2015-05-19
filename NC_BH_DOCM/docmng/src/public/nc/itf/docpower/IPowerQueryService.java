package nc.itf.docpower;

import nc.vo.pub.BusinessException;

public interface IPowerQueryService {
	
    /**
	 * <b>��ѯ��������con��Ȩ��PKs</b>
	 * @return PKs[]
	 * @throws BusinessException
	 */
    String[] queryPowerPKsByCondition(String con) throws BusinessException;
}
