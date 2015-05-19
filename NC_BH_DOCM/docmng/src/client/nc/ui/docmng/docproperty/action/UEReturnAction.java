package nc.ui.docmng.docproperty.action;

import java.awt.event.ActionEvent;

import nc.ui.uif2.AppEvent;
import nc.ui.uif2.model.HierachicalDataAppModel;

public class UEReturnAction extends nc.ui.pubapp.uif2app.actions.UEReturnAction {
	

	private HierachicalDataAppModel treeModel;

	public HierachicalDataAppModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(HierachicalDataAppModel treeModel) {
		this.treeModel = treeModel;
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.doAction(e);
		this.getTreeModel().fireEvent(new AppEvent(this.getTreeModel().SELECTION_CHANGED,getTreeModel(),null));
		
	}
	
	
}
