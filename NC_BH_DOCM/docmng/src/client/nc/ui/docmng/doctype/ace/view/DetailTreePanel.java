package nc.ui.docmng.doctype.ace.view;

import java.util.List;

import javax.swing.Action;

import nc.ui.uif2.UIState;
import nc.ui.uif2.components.AutoShowUpEventSource;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.components.IAutoShowUpEventListener;
import nc.ui.uif2.components.IComponentWithActions;
import nc.ui.uif2.components.ITabbedPaneAwareComponent;
import nc.ui.uif2.components.ITabbedPaneAwareComponentListener;
import nc.ui.uif2.components.TabbedPaneAwareCompnonetDelegate;
import nc.ui.uif2.editor.BillTreeView;
import nc.vo.uap.rbac.BusiFuncItemVO;

public class DetailTreePanel extends BillTreeView implements IComponentWithActions, IAutoShowUpComponent, ITabbedPaneAwareComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Action> actions = null;
	private ITabbedPaneAwareComponent tabbedPaneAwareComponent  = null;
	private IAutoShowUpComponent autoShowUpComponent;
	
	
	public DetailTreePanel() {
		autoShowUpComponent = new AutoShowUpEventSource(this);
		tabbedPaneAwareComponent = new TabbedPaneAwareCompnonetDelegate();
	}
	
	@Override
	public void initUI() {
		super.initUI();
		setTreeMode(BillTreeView.COLUMNTREETABLEMODE);
		setTreeColumnName("permdisplay");
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
		tabbedPaneAwareComponent.setComponentVisible(visible);
		
	}

	@Override
	public boolean isComponentVisible() {
		return tabbedPaneAwareComponent.isComponentVisible();
	}

	@Override
	public void addTabbedPaneAwareComponentListener(
			ITabbedPaneAwareComponentListener l) {
		tabbedPaneAwareComponent.addTabbedPaneAwareComponentListener(l);
		
	}

	@Override
	public void setAutoShowUpEventListener(IAutoShowUpEventListener l) {
		autoShowUpComponent.setAutoShowUpEventListener(l);
		
	}

	@Override
	public void showMeUp() {
		autoShowUpComponent.showMeUp();
		
	}

	@Override
	public List<Action> getActions() {
		return actions;
	}
	

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
