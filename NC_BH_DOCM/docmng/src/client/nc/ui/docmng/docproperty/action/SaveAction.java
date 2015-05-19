package nc.ui.docmng.docproperty.action;

import nc.ui.pubapp.uif2app.actions.pflow.SaveScriptAction;
import nc.ui.uif2.UIState;
import nc.ui.uif2.editor.BillForm;

public class SaveAction extends SaveScriptAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public void setValue(Object obj){
		this.editor.setValue(obj);
		this.getModel().setUiState(UIState.ADD);
	}
	
	
	
	
}
