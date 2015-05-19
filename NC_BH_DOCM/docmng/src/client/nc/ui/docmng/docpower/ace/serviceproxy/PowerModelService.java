package nc.ui.docmng.docpower.ace.serviceproxy;

import nc.bs.bd.baseservice.ArrayClassConvertUtil;
import nc.bs.framework.common.NCLocator;
import nc.itf.docpower.IPowerService;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.uap.rbac.ResponsibilityVO;
import nc.vo.uif2.LoginContext;

public class PowerModelService implements IAppModelService {

	@Override
	public Object insert(Object object) throws Exception {

		return null;
	}

	@Override
	public Object update(Object object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object object) throws Exception {		
		if(object!=null){
		Object[] power = (Object[])object; 
		DmPower[] powers = ArrayClassConvertUtil.convert(power, DmPower.class);
		getPowerService().deletePower(powers);
	}
	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext context)
			throws Exception {
		return null ;
	}
	
	private IPowerService getPowerService(){
		return NCLocator.getInstance().lookup(IPowerService.class);
	}

}
