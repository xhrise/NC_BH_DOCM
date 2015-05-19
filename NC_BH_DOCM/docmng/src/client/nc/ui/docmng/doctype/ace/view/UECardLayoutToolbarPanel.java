package nc.ui.docmng.doctype.ace.view;

import java.util.List;

import javax.swing.Action;

import nc.bs.uif2.IActionCode;
import nc.funcnode.ui.action.INCAction;
import nc.ui.uif2.NCAction;

public class UECardLayoutToolbarPanel extends
		nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
    public void setActions(List<Action> actions) {
            this.removeFileAction(actions);
            super.setActions(actions);
    }

    private void removeFileAction(List<Action> actions) {
            Action fileAction = null;
            for(Action action : actions) {
                    if(action instanceof NCAction && IActionCode.FILE.equals(((NCAction)action).getValue(INCAction.CODE))){
                            fileAction = action;
                            break;
                    }
            }
            actions.remove(fileAction);
    }

}
