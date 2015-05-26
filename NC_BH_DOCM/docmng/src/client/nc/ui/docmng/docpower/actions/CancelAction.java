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

		//如果是从ClosingHandler触发的CancelAction不用询问，直接取消
		//这对于多页签档案是有意义的。 对于一般的节点，如果直接关闭了，是否调用setUiState其实无关紧要
		if(EventFromClosingHandlerJudger.isFromClosingHandler(e)
				||
				UIDialog.ID_YES==CommonConfirmDialogUtils.showConfirmCancelDialog(getModel().getContext().getEntranceUI()))
		
		{  
			
			doBeforeCancel();
			getModel().setUiState(UIState.NOT_EDIT);
			//取消时，除进行状态变化外，还需要重新设置选中数据
			doResetSelectedData();
			
			//清楚警告图标
			((BillForm) getEditor()).getBillCardPanel().getBillData().clearHeadTailItemShowWarning();
			
			ShowStatusBarMsgUtil.showStatusBarMsg(IShowMsgConstant.getCancelInfo(), getModel().getContext());
		} 
	}
}
