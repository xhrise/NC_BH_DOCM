package nc.bs.mmgp.lock;

import java.util.List;

import nc.bs.mmgp.common.VoUtils;
import nc.bs.uap.lock.PKLock;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;

/**
 * <b> PK����װ </b>
 * <p>
 * ����UAP����������ʧ�����쳣
 * </p>
 * ��������:2011-2-26
 * 
 * @author wangweiu
 * @deprecated
 * @see nc.vo.util.BDPKLockUtil
 */
public class MMGPPKLock {
	public static final String ERROR_MESSAGE = "���ڽ�����ز��������Ժ����ԣ�";

	// NCLangResOnserver.getInstance().getStrByID("40040503",
	// "UPP40040503-000000");
	public static void addDynamicLock(String lock) throws BusinessException {
		boolean success = PKLock.getInstance().addDynamicLock(lock);
		if (!success) {
			throw new BusinessException(ERROR_MESSAGE);
		}
	}

	public static void addBatchDynamicLock(List<String> pks)
			throws BusinessException {
		addBatchDynamicLock(pks.toArray(new String[0]));
	}

	public static void addBatchDynamicLock(CircularlyAccessibleValueObject[] vos)
			throws BusinessException {
		List<String> pks = VoUtils.getPrimaryFiledValues(vos);
		addBatchDynamicLock(pks);
	}

	public static void addBatchDynamicLock(String[] locks)
			throws BusinessException {
		boolean success = PKLock.getInstance().addBatchDynamicLock(locks);
		if (!success) {
			throw new BusinessException(ERROR_MESSAGE);
		}
	}

	private MMGPPKLock() {

	}

}