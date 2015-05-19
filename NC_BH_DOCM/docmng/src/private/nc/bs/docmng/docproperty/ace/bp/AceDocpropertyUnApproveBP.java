package nc.bs.docmng.docproperty.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.pub.VOStatus;

/**
 * 标准单据弃审的BP
 */
public class AceDocpropertyUnApproveBP {

	public AggDocProperty[] unApprove(AggDocProperty[] clientBills,
			AggDocProperty[] originBills) {
		for (AggDocProperty clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggDocProperty> update = new BillUpdate<AggDocProperty>();
		AggDocProperty[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}
}
