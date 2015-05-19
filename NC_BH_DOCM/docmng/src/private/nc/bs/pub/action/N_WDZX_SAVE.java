package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.CommitStatusCheckRule;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.docmng.docproperty.plugin.bpplugin.DocpropertyPluginPoint;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.itf.docmng.IDocpropertyMaintain;

public class N_WDZX_SAVE extends AbstractPfAction<AggDocProperty> {

	protected CompareAroundProcesser<AggDocProperty> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggDocProperty> processor = new CompareAroundProcesser<AggDocProperty>(
				DocpropertyPluginPoint.SEND_APPROVE);
		// TODO 在此处添加审核前后规则
		IRule<AggDocProperty> rule = new CommitStatusCheckRule();
		processor.addBeforeRule(rule);
		return processor;
	}

	@Override
	protected AggDocProperty[] processBP(Object userObj,
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills) {
		IDocpropertyMaintain operator = NCLocator.getInstance().lookup(
				IDocpropertyMaintain.class);
		AggDocProperty[] bills = null;
		try {
			bills = operator.save(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
