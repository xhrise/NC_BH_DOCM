package nc.ui.docmng.docpower.ace.serviceproxy;

import org.apache.commons.lang.ArrayUtils;

import nc.bs.bd.baseservice.ArrayClassConvertUtil;
import nc.bs.framework.common.NCLocator;
import nc.itf.docpower.IPowerService;
import nc.itf.uap.rbac.IResponsibilityService;
import nc.ui.uap.rbac.resp.model.BusiFuncItemClientHelper;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.bd.meta.BatchOperateVO;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.pub.BusinessException;
import nc.vo.uap.rbac.BusiFuncItemSaveVO;
import nc.vo.uap.rbac.BusiFuncItemSmartVO;
import nc.vo.uap.rbac.ResponsibilityVO;
import nc.vo.uap.rbac.util.BusiFuncItemHelper;
import nc.vo.uap.rbac.util.RbacPubUtil;
import nc.vo.uif2.LoginContext;

public class PowerModelService implements IAppModelService {

	@Override
	public Object insert(Object object) throws Exception {
		boolean isObjectInValid = object != null || object instanceof DmPower;
		if (isObjectInValid) {
			DmPower vo = (DmPower) object;
			return getPowerService().insertPower(vo);
		}
		return null;
	}

	@Override
	public Object update(Object object) throws Exception {
		boolean isObjectInValid = object != null || object instanceof DmPower;
		if (isObjectInValid) {
			DmPower vo = (DmPower) object;
			return getPowerService().updatePower(vo);
		}
		return null;
	}

	@Override
	public void delete(Object object) throws Exception {
		if (object != null) {
			Object power = (Object) object;
			DmPower[] powers = ArrayClassConvertUtil.convert(new Object[]{power},
					DmPower.class);
			getPowerService().deletePower(powers);
		}

	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext context)
			throws Exception {
		return null;
	}

	private IPowerService getPowerService() {
		return NCLocator.getInstance().lookup(IPowerService.class);
	}

	public BusiPowerItem[] batchAssignOrRemoveItem(String pk_power,
			BatchOperateVO vo) throws BusinessException {
		Object[] addObjs = vo.getAddObjs();
		Object[] delObjs = vo.getDelObjs();

		BusiPowerItem[] toAddItems = null;
		BusiPowerItem[] toDelItems = null;

		if (!ArrayUtils.isEmpty(addObjs))
			toAddItems = RbacPubUtil.convert(addObjs, BusiPowerItem.class);
		if (!ArrayUtils.isEmpty(delObjs))
			toDelItems = RbacPubUtil.convert(delObjs, BusiPowerItem.class);

		BusiPowerItem[] funcSmartItems = getPowerService()
				.batchAssignedAndRemovedItems(pk_power, toAddItems, toDelItems);

		return funcSmartItems;
	}

}
