package nc.ui.docmng.docproperty.action;

import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.vo.docmng.doctype.DocType;

public class AddAction extends nc.ui.pubapp.uif2app.actions.AddAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HierachicalDataAppModel hAppModel;

	public HierachicalDataAppModel gethAppModel() {
		return hAppModel;
	}

	public void sethAppModel(HierachicalDataAppModel hAppModel) {
		this.hAppModel = hAppModel;
	}

	@Override
	protected boolean isActionEnable() {
		// TODO Auto-generated method stub
		DocType docType = (DocType)this.gethAppModel().getSelectedData();
		if(docType==null|| docType.getPk_doctype()==null||docType.getPk_doctype().equals(""))
			return false;
		return super.isActionEnable();
	}
	
	

}
