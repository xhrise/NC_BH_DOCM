package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.docmng.docproperty.plugin.bpplugin.DocpropertyPluginPoint;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.itf.docmng.IDocpropertyMaintain;

public class N_WDZX_DELETE extends AbstractPfAction<AggDocProperty> {

	@Override
	protected CompareAroundProcesser<AggDocProperty> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggDocProperty> processor = new CompareAroundProcesser<AggDocProperty>(
				DocpropertyPluginPoint.SCRIPT_DELETE);
		// TODO 在此处添加前后规则
		return processor;
	}

	@Override
	protected AggDocProperty[] processBP(Object userObj,
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills) {
		IDocpropertyMaintain operator = NCLocator.getInstance().lookup(
				IDocpropertyMaintain.class);
		try {
			operator.delete(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return clientFullVOs;
	}

}
