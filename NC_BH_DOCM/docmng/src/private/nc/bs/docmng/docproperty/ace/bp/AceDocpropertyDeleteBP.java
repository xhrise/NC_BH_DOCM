package nc.bs.docmng.docproperty.ace.bp;

import nc.bs.docmng.docproperty.plugin.bpplugin.DocpropertyPluginPoint;
import nc.vo.docmng.docproperty.AggDocProperty;

import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;


/**
 * ��׼����ɾ��BP
 */
public class AceDocpropertyDeleteBP {

	public void delete(AggDocProperty[] bills) {

		DeleteBPTemplate<AggDocProperty> bp = new DeleteBPTemplate<AggDocProperty>(
				DocpropertyPluginPoint.DELETE);
		// ����ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ����ִ�к�ҵ�����
		this.addAfterRule(bp.getAroundProcesser());
		bp.delete(bills);
	}

	private void addBeforeRule(AroundProcesser<AggDocProperty> processer) {
		// TODO ǰ����
		IRule<AggDocProperty> rule = null;
		rule = new nc.bs.pubapp.pub.rule.BillDeleteStatusCheckRule();
		processer.addBeforeRule(rule);
	}

	/**
	 * ɾ����ҵ�����
	 * 
	 * @param processer
	 */
	private void addAfterRule(AroundProcesser<AggDocProperty> processer) {
		// TODO �����

	}
}
