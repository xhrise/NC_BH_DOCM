package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.ApproveStatusCheckRule;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.docmng.docproperty.plugin.bpplugin.DocpropertyPluginPoint;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.itf.docmng.IDocpropertyMaintain;

public class N_WDZX_APPROVE extends AbstractPfAction<AggDocProperty> {

	public N_WDZX_APPROVE() {
		super();
	}

	@Override
	protected CompareAroundProcesser<AggDocProperty> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggDocProperty> processor = new CompareAroundProcesser<AggDocProperty>(
				DocpropertyPluginPoint.APPROVE);
		processor.addBeforeRule(new ApproveStatusCheckRule());
		return processor;
	}

	@Override
	protected AggDocProperty[] processBP(Object userObj,
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills) {
		AggDocProperty[] bills = null;
		IDocpropertyMaintain operator = NCLocator.getInstance().lookup(
				IDocpropertyMaintain.class);
		try {
			bills = operator.approve(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
