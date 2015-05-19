package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.UncommitStatusCheckRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.docmng.docproperty.plugin.bpplugin.DocpropertyPluginPoint;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.itf.docmng.IDocpropertyMaintain;

public class N_WDZX_UNSAVEBILL extends AbstractPfAction<AggDocProperty> {

	@Override
	protected CompareAroundProcesser<AggDocProperty> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggDocProperty> processor = new CompareAroundProcesser<AggDocProperty>(
				DocpropertyPluginPoint.UNSEND_APPROVE);
		// TODO 在此处添加前后规则
		processor.addBeforeRule(new UncommitStatusCheckRule());

		return processor;
	}

	@Override
	protected AggDocProperty[] processBP(Object userObj,
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills) {
		IDocpropertyMaintain operator = NCLocator.getInstance().lookup(
				IDocpropertyMaintain.class);
		AggDocProperty[] bills = null;
		try {
			bills = operator.unsave(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
