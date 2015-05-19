package nc.ui.docmng.doctype.ace.view;


import nc.bs.uif2.BusinessExceptionAdapter;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillEditListener;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.UIState;
import nc.ui.uif2.components.AutoShowUpEventSource;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.components.IAutoShowUpEventListener;
import nc.ui.uif2.components.ITabbedPaneAwareComponent;
import nc.ui.uif2.components.ITabbedPaneAwareComponentListener;
import nc.ui.uif2.components.TabbedPaneAwareCompnonetDelegate;
import nc.ui.uif2.editor.BillForm;
import nc.ui.uif2.model.AppEventConst;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.vo.pub.ValidationException;
import nc.vo.uap.rbac.ResponsibilityVO;

public class PowerEditor extends BillForm implements IAutoShowUpComponent, ITabbedPaneAwareComponent,BillEditListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private ITabbedPaneAwareComponent tabbedPaneAwareComponent  = null;
	private IAutoShowUpComponent autoShowUpComponent;
	private boolean initialized = false;
	
	

	public boolean isInitialized() {
		return initialized;
	}



	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	private HierachicalDataAppModel detailTreeModel;
	
	
	
	
	public HierachicalDataAppModel getDetailTreeModel() {
		return detailTreeModel;
	}



	public void setDetailTreeModel(HierachicalDataAppModel detailTreeModel) {
		this.detailTreeModel = detailTreeModel;
	}



	public PowerEditor() {
		this.autoShowUpComponent = new AutoShowUpEventSource(this);
		this.tabbedPaneAwareComponent = new TabbedPaneAwareCompnonetDelegate();
	}

	
	
	@Override
	public void initUI() {
		super.initUI();
		this.getBillCardPanel().addEditListener(this);
	}
	
	@Override
	public void handleEvent(AppEvent event) {
		if (event.getType().equals(AppEventConst.SHOW_EDITOR)
				|| event.getType().equals(AppEventConst.SELECTION_CHANGED)
				|| event.getType().equals(AppEventConst.UISTATE_CHANGED)
				|| event.getType().equals(AppEventConst.SELECTED_DATE_CHANGED))
			this.setInitialized(false);
		boolean b = this.isComponentVisible();
		if (event.getType().equals(AppEventConst.SHOW_EDITOR))
			this.showMeUp();
		if (!b && this.isComponentVisible()) {
			this.getModel().fireEvent(new AppEvent(AppEventConst.SELECTION_CHANGED));
			this.setInitialized(true);
		}
		super.handleEvent(event);
	}
	
	@Override
	protected void onAdd() {
		super.onAdd();
		this.showMeUp();
	}

	@Override
	protected void onEdit() {
		super.onEdit();
		this.showMeUp();
	}
	
	
	/**
	 * 在编辑器进入新增状态后被调用。 此方法设置编辑器默认值.
	 */
	protected void setDefaultValue(){
		String pk_group = getModel().getContext().getPk_group();
		UIRefPane groupRefPane = (UIRefPane)getBillCardPanel().getHeadItem(ResponsibilityVO.PK_GROUP).getComponent();
		groupRefPane.setPK(pk_group);
	}


	@Override
	protected void beforeGetValue() {
		super.beforeGetValue();
		try {
			this.getBillCardPanel().dataNotNullValidate();
		} catch (ValidationException e) {
			throw new BusinessExceptionAdapter(e);
		}
	}

	@Override
	public void afterEdit(BillEditEvent e) {
		
	}

	@Override
	public void bodyRowChange(BillEditEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean canBeHidden() {
		if (getModel().getUiState() == UIState.EDIT || getModel().getUiState() == UIState.ADD) {
			return false;
		}
		return true;
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
		// TODO 自动生成的方法存根
		
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
