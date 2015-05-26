package nc.ui.docmng.docpower.actions;

import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;

import nc.ui.uif2.model.HierachicalDataAppModel;

public class AddAction extends nc.ui.uif2.actions.AddAction {
	private static final long serialVersionUID = 1L;

	private HierachicalDataAppModel detailTreeModel;

	public AddAction() {
		super();
		this.setBtnName(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("common","UC001-0000108")/*@res "新增"*/);
		this.setCode("Add");
		this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
		this.putValue(Action.SHORT_DESCRIPTION, nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("10120RESPADMIN","010120RESPADMIN0003")/*@res "新增业务数据(Ctrl+N)"*/);
	}


	@Override
	public void doAction(ActionEvent e) throws Exception {
		super.doAction(e);
		getDetailTreeModel().initModel(null);
	}


	public HierachicalDataAppModel getDetailTreeModel() {
		return detailTreeModel;
	}


	public void setDetailTreeModel(HierachicalDataAppModel detailTreeModel) {
		this.detailTreeModel = detailTreeModel;
	}

	
}
