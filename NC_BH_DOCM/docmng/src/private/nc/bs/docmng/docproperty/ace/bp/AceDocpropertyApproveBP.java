package nc.bs.docmng.docproperty.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.pub.VOStatus;
import nc.vo.docmng.docproperty.AggDocProperty;

/**
 * ��׼������˵�BP
 */
public class AceDocpropertyApproveBP {

	/**
	 * ��˶���
	 * 
	 * @param vos
	 * @param script
	 * @return
	 */
	public AggDocProperty[] approve(AggDocProperty[] clientBills,
			AggDocProperty[] originBills) {
		for (AggDocProperty clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggDocProperty> update = new BillUpdate<AggDocProperty>();
		AggDocProperty[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}

}
