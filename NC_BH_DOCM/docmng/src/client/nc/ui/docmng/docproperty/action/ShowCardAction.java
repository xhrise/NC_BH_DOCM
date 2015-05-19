package nc.ui.docmng.docproperty.action;

import java.awt.event.ActionEvent;

import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.model.BillManageModel;

public class ShowCardAction extends NCAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BillManageModel model;
	

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	private ShowUpableBillListView listView;
	public ShowUpableBillForm getBillForm() {
		return billForm;
	}

	public void setBillForm(ShowUpableBillForm billForm) {
		this.billForm = billForm;
	}

	private ShowUpableBillForm billForm;
	

	public ShowUpableBillListView getListView() {
		return listView;
	}

	public void setListView(ShowUpableBillListView listView) {
		this.listView = listView;
	}

	@Override
	public void doAction(ActionEvent arg0) throws Exception {
		if(this.listView.isShowing()){
			this.billForm.showMeUp();
			this.setBtnName("显示列表");
		}else if(this.billForm.isShowing()){
			this.listView.showMeUp();
			this.setBtnName("显示卡片");
		}

	}



	
}
