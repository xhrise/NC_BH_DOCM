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
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void setComponentVisible(boolean visible) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public boolean isComponentVisible() {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void addTabbedPaneAwareComponentListener(
			ITabbedPaneAwareComponentListener l) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void setAutoShowUpEventListener(IAutoShowUpEventListener l) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void showMeUp() {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public List<Action> getActions() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
