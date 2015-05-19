package nc.bs.docmng.docproperty.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * ��׼�����ջص�BP
 */
public class AceDocpropertyUnSendApproveBP {

	public AggDocProperty[] unSend(AggDocProperty[] clientBills,
			AggDocProperty[] originBills) {
		// ��VO�־û������ݿ���
		this.setHeadVOStatus(clientBills);
		BillUpdate<AggDocProperty> update = new BillUpdate<AggDocProperty>();
		AggDocProperty[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}

	private void setHeadVOStatus(AggDocProperty[] clientBills) {
		for (AggDocProperty clientBill : clientBills) {
			clientBill.getParentVO().setAttributeValue("${vmObject.billstatus}",
					BillStatusEnum.FREE.value());
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
	}
}
