package nc.ui.docmng.doctype.ace.view;

import java.util.List;

import javax.swing.Action;

import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.components.IAutoShowUpEventListener;
import nc.ui.uif2.components.IComponentWithActions;
import nc.ui.uif2.components.ITabbedPaneAwareComponent;
import nc.ui.uif2.components.ITabbedPaneAwareComponentListener;
import nc.ui.uif2.editor.BillTreeView;

public class DetailTreePanel extends BillTreeView implements IComponentWithActions, IAutoShowUpComponent, ITabbedPaneAwareComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean canBeHidden() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void setComponentVisible(boolean visible) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean isComponentVisible() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void addTabbedPaneAwareComponentListener(
			ITabbedPaneAwareComponentListener l) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setAutoShowUpEventListener(IAutoShowUpEventListener l) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void showMeUp() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public List<Action> getActions() {
		// TODO 自动生成的方法存根
		return null;
	}

}
