package nc.impl.pub.ace;

import nc.bs.docmng.docproperty.ace.bp.AceDocpropertyInsertBP;
import nc.bs.docmng.docproperty.ace.bp.AceDocpropertyUpdateBP;
import nc.bs.docmng.docproperty.ace.bp.AceDocpropertyDeleteBP;
import nc.bs.docmng.docproperty.ace.bp.AceDocpropertySendApproveBP;
import nc.bs.docmng.docproperty.ace.bp.AceDocpropertyUnSendApproveBP;
import nc.bs.docmng.docproperty.ace.bp.AceDocpropertyApproveBP;
import nc.bs.docmng.docproperty.ace.bp.AceDocpropertyUnApproveBP;
import nc.impl.pubapp.pattern.data.bill.BillLazyQuery;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public abstract class AceDocpropertyPubServiceImpl {
	// ����
	public AggDocProperty[] pubinsertBills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		try {
			// ���ݿ������ݺ�ǰ̨���ݹ����Ĳ���VO�ϲ���Ľ��
			BillTransferTool<AggDocProperty> transferTool = new BillTransferTool<AggDocProperty>(
					clientFullVOs);
			// ����BP
			AceDocpropertyInsertBP action = new AceDocpropertyInsertBP();
			AggDocProperty[] retvos = action.insert(clientFullVOs);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// ɾ��
	public void pubdeleteBills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		try {
			// ����BP
			new AceDocpropertyDeleteBP().delete(clientFullVOs);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// �޸�
	public AggDocProperty[] pubupdateBills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		try {
			// ���� + ���ts
			BillTransferTool<AggDocProperty> transferTool = new BillTransferTool<AggDocProperty>(
					clientFullVOs);
			AceDocpropertyUpdateBP bp = new AceDocpropertyUpdateBP();
			AggDocProperty[] retvos = bp.update(clientFullVOs, originBills);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	public AggDocProperty[] pubquerybills(IQueryScheme queryScheme)
			throws BusinessException {
		AggDocProperty[] bills = null;
		try {
			this.preQuery(queryScheme);
			BillLazyQuery<AggDocProperty> query = new BillLazyQuery<AggDocProperty>(
					AggDocProperty.class);
			bills = query.query(queryScheme, null);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return bills;
	}

	/**
	 * ������ʵ�֣���ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	 * 
	 * @param queryScheme
	 */
	protected void preQuery(IQueryScheme queryScheme) {
		// ��ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	}

	// �ύ
	public AggDocProperty[] pubsendapprovebills(
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills)
			throws BusinessException {
		AceDocpropertySendApproveBP bp = new AceDocpropertySendApproveBP();
		AggDocProperty[] retvos = bp.sendApprove(clientFullVOs, originBills);
		return retvos;
	}

	// �ջ�
	public AggDocProperty[] pubunsendapprovebills(
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills)
			throws BusinessException {
		AceDocpropertyUnSendApproveBP bp = new AceDocpropertyUnSendApproveBP();
		AggDocProperty[] retvos = bp.unSend(clientFullVOs, originBills);
		return retvos;
	};

	// ����
	public AggDocProperty[] pubapprovebills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceDocpropertyApproveBP bp = new AceDocpropertyApproveBP();
		AggDocProperty[] retvos = bp.approve(clientFullVOs, originBills);
		return retvos;
	}

	// ����

	public AggDocProperty[] pubunapprovebills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceDocpropertyUnApproveBP bp = new AceDocpropertyUnApproveBP();
		AggDocProperty[] retvos = bp.unApprove(clientFullVOs, originBills);
		return retvos;
	}

}