package nc.bs.docmng.docproperty.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * ��׼���������BP
 */
public class AceDocpropertySendApproveBP {
	/**
	 * ������
	 * 
	 * @param vos
	 *            ����VO����
	 * @param script
	 *            ���ݶ����ű�����
	 * @return �����ĵ���VO����
	 */

	public AggDocProperty[] sendApprove(AggDocProperty[] clientBills,
			AggDocProperty[] originBills) {
		for (AggDocProperty clientFullVO : clientBills) {
			clientFullVO.getParentVO().setAttributeValue("${vmObject.billstatus}",
					BillStatusEnum.COMMIT.value());
			clientFullVO.getParentVO().setStatus(VOStatus.UPDATED);
		}
		// ���ݳ־û�
		AggDocProperty[] returnVos = new BillUpdate<AggDocProperty>().update(
				clientBills, originBills);
		return returnVos;
	}
}
