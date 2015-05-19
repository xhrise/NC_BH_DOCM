package nc.ui.docmng.doctype.ace.view;

import nc.ui.pub.bill.BillItemHyperlinkEvent;
import nc.ui.pub.bill.BillItemHyperlinkListener;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.components.AutoShowUpEventSource;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.components.IAutoShowUpEventListener;
import nc.ui.uif2.components.ITabbedPaneAwareComponent;
import nc.ui.uif2.components.ITabbedPaneAwareComponentListener;
import nc.ui.uif2.components.TabbedPaneAwareCompnonetDelegate;
import nc.ui.uif2.editor.BillListView;
import nc.ui.uif2.model.AppEventConst;

public class PowerListView extends BillListView implements IAutoShowUpComponent,BillItemHyperlinkListener,ITabbedPaneAwareComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -802210576252843420L;
	
	
	private IAutoShowUpComponent autoShowUpComponent;
	private ITabbedPaneAwareComponent tabbedPaneAwareComponent  = null;
	
	public PowerListView(){
		autoShowUpComponent = new AutoShowUpEventSource(this);
		tabbedPaneAwareComponent = new TabbedPaneAwareCompnonetDelegate();
	}
	
	

	@Override
	public void initUI() {
		// TODO 自动生成的方法存根
		super.initUI();
		getBillListPanel().getHeadItem("code").addBillItemHyperlinkListener(this);
	}

	


	@Override
	public void handleEvent(AppEvent event) {
		super.handleEvent(event);
		if(event.getType() == AppEventConst.MODEL_INITIALIZED)
			showMeUp();
	}


	@Override
	public boolean canBeHidden() {
		return tabbedPaneAwareComponent.canBeHidden();
	}

	@Override
	public void setComponentVisible(boolean visible) {
		this.tabbedPaneAwareComponent.setComponentVisible(visible);
		
	}

	@Override
	public boolean isComponentVisible() {
		return this.tabbedPaneAwareComponent.isComponentVisible();
	}

	@Override
	public void addTabbedPaneAwareComponentListener(
			ITabbedPaneAwareComponentListener l) {
		this.tabbedPaneAwareComponent.addTabbedPaneAwareComponentListener(l);
		
	}

	@Override
	public void hyperlink(BillItemHyperlinkEvent event) {
		this.getModel().fireShowEditorEvent();
		
	}

	@Override
	public void setAutoShowUpEventListener(IAutoShowUpEventListener l) {
		this.autoShowUpComponent.setAutoShowUpEventListener(l);
		
	}
	
	

	@Override
	public void showMeUp() {
		this.autoShowUpComponent.showMeUp();
		
	}

}
