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
	// 新增
	public AggDocProperty[] pubinsertBills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		try {
			// 数据库中数据和前台传递过来的差异VO合并后的结果
			BillTransferTool<AggDocProperty> transferTool = new BillTransferTool<AggDocProperty>(
					clientFullVOs);
			// 调用BP
			AceDocpropertyInsertBP action = new AceDocpropertyInsertBP();
			AggDocProperty[] retvos = action.insert(clientFullVOs);
			// 构造返回数据
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// 删除
	public void pubdeleteBills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		try {
			// 调用BP
			new AceDocpropertyDeleteBP().delete(clientFullVOs);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// 修改
	public AggDocProperty[] pubupdateBills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		try {
			// 加锁 + 检查ts
			BillTransferTool<AggDocProperty> transferTool = new BillTransferTool<AggDocProperty>(
					clientFullVOs);
			AceDocpropertyUpdateBP bp = new AceDocpropertyUpdateBP();
			AggDocProperty[] retvos = bp.update(clientFullVOs, originBills);
			// 构造返回数据
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
	 * 由子类实现，查询之前对queryScheme进行加工，加入自己的逻辑
	 * 
	 * @param queryScheme
	 */
	protected void preQuery(IQueryScheme queryScheme) {
		// 查询之前对queryScheme进行加工，加入自己的逻辑
	}

	// 提交
	public AggDocProperty[] pubsendapprovebills(
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills)
			throws BusinessException {
		AceDocpropertySendApproveBP bp = new AceDocpropertySendApproveBP();
		AggDocProperty[] retvos = bp.sendApprove(clientFullVOs, originBills);
		return retvos;
	}

	// 收回
	public AggDocProperty[] pubunsendapprovebills(
			AggDocProperty[] clientFullVOs, AggDocProperty[] originBills)
			throws BusinessException {
		AceDocpropertyUnSendApproveBP bp = new AceDocpropertyUnSendApproveBP();
		AggDocProperty[] retvos = bp.unSend(clientFullVOs, originBills);
		return retvos;
	};

	// 审批
	public AggDocProperty[] pubapprovebills(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceDocpropertyApproveBP bp = new AceDocpropertyApproveBP();
		AggDocProperty[] retvos = bp.approve(clientFullVOs, originBills);
		return retvos;
	}

	// 弃审

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