package nc.ui.docmng.doctype.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.itf.pubapp.pub.smart.IBillMaintainService;
import nc.ui.pubapp.uif2app.actions.IDataOperationService;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;

public class DocpropertyService implements IDataOperationService {

	@Override
	public IBill[] insert(IBill[] value) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBill[] update(IBill[] value) throws BusinessException {
		if(value!=null &&value.length==1){
			IBill bill = NCLocator.getInstance().lookup(IBillMaintainService.class).update(value[0]);
			return new IBill[]{bill};
		}
		return null;
	}

	@Override
	public IBill[] delete(IBill[] value) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
