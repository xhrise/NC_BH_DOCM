package nc.impl.docmng;

import nc.impl.pub.ace.AceDocpropertyPubServiceImpl;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.itf.docmng.IDocpropertyMaintain;
import nc.vo.pub.BusinessException;

public class DocpropertyMaintainImpl extends AceDocpropertyPubServiceImpl
		implements IDocpropertyMaintain {

	@Override
	public void delete(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		super.pubdeleteBills(clientFullVOs, originBills);
	}

	@Override
	public AggDocProperty[] insert(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		return super.pubinsertBills(clientFullVOs, originBills);
	}

	@Override
	public AggDocProperty[] update(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		return super.pubupdateBills(clientFullVOs, originBills);
	}

	@Override
	public AggDocProperty[] query(IQueryScheme queryScheme)
			throws BusinessException {
		return super.pubquerybills(queryScheme);
	}

	@Override
	public AggDocProperty[] save(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		return super.pubsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggDocProperty[] unsave(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		return super.pubunsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggDocProperty[] approve(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		return super.pubapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggDocProperty[] unapprove(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		return super.pubunapprovebills(clientFullVOs, originBills);
	}

}
