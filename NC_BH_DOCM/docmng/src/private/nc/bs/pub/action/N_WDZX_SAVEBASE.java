package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.docmng.docproperty.plugin.bpplugin.DocpropertyPluginPoint;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.itf.docmng.IDocpropertyMaintain;

public class N_WDZX_SAVEBASE extends AbstractPfAction<AggDocProperty> {

	@Override
	protected CompareAroundProcesser<AggDocProperty> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggDocProperty> processor = null;
		AggDocProperty[] clientFullVOs = (AggDocProperty[]) this.getVos();
		if (!StringUtil.isEmptyWithTrim(clientFullVOs[0].getParentVO()
				.getPrimaryKey())) {
			processor = new CompareAroundProcesser<AggDocProperty>(
					DocpropertyPluginPoint.SCRIPT_UPDATE);
		} else {
			processor = new CompareAroundProcesser<AggDocProperty>(
					DocpropertyPluginPoint.SCRIPT_INSERT);
		}
		// TODO 在此处添加前后规则
		IRule<AggDocProperty> rule = null;

		return processor;
	}

	@Override
	protected AggDocProperty[] processBP(Object userObj,
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills) {

		AggDocProperty[] bills = null;
		try {
			IDocpropertyMaintain operator = NCLocator.getInstance()
					.lookup(IDocpropertyMaintain.class);
			if (!StringUtil.isEmptyWithTrim(clientFullVOs[0].getParentVO()
					.getPrimaryKey())) {
				bills = operator.update(clientFullVOs, originBills);
			} else {
				bills = operator.insert(clientFullVOs, originBills);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}
}
