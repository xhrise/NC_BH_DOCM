package nc.ui.docmng.docpower.actions;

import java.awt.event.ActionEvent;

import nc.ui.pub.beans.UIDialog;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.UIState;
import nc.ui.uif2.actions.EventFromClosingHandlerJudger;
import nc.ui.uif2.components.CommonConfirmDialogUtils;
import nc.ui.uif2.editor.BillForm;

public class CancelAction extends nc.ui.uif2.actions.CancelAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3781551706444024441L;

	@Override
	public void doAction(ActionEvent e) throws Exception {

		//����Ǵ�ClosingHandler������CancelAction����ѯ�ʣ�ֱ��ȡ��
		//����ڶ�ҳǩ������������ġ� ����һ��Ľڵ㣬���ֱ�ӹر��ˣ��Ƿ����setUiState��ʵ�޹ؽ�Ҫ
		if(EventFromClosingHandlerJudger.isFromClosingHandler(e)
				||
				UIDialog.ID_YES==CommonConfirmDialogUtils.showConfirmCancelDialog(getModel().getContext().getEntranceUI()))
		
		{  
			
			doBeforeCancel();
			getModel().setUiState(UIState.NOT_EDIT);
			//ȡ��ʱ��������״̬�仯�⣬����Ҫ��������ѡ������
			doResetSelectedData();
			
			//�������ͼ��
			((BillForm) getEditor()).getBillCardPanel().getBillData().clearHeadTailItemShowWarning();
			
			ShowStatusBarMsgUtil.showStatusBarMsg(IShowMsgConstant.getCancelInfo(), getModel().getContext());
		} 
	}
}
