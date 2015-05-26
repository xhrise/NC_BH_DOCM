package nc.ui.docmng.docpower.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.KeyStroke;

import nc.ui.docmng.docproperty.dialog.PowerAssignDialog;
import nc.ui.docmng.doctype.ace.model.DetailTreeModel;
import nc.ui.docmng.doctype.ace.view.DetailTreePanel;
import nc.ui.docmng.doctype.ace.view.PowerEditor;
import nc.ui.uap.rbac.auth.functree.FuncItemAssignDialog;
import nc.ui.uap.rbac.resp.model.RespFuncTreeModel;
import nc.ui.uap.rbac.resp.model.ResponsibilityAppModel;
import nc.ui.uap.rbac.resp.view.RespEditor;
import nc.ui.uap.rbac.resp.view.RespFuncTreePanel;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.UIState;
import nc.ui.uif2.model.BillManageModel;
import nc.uitheme.ui.ThemeResourceCenter;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.pub.BusinessException;
import nc.vo.uap.rbac.ResponsibilityVO;

public class AssignAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404032284006687955L;

	public final static Icon ASSIGN_ICON = ThemeResourceCenter.getInstance()
			.getImage("themeres/ui/toolbaricons/assign.png");

	private BillManageModel model;
	private DetailTreeModel detailTreeModel;
	private DetailTreePanel detailTreePanel;
	private PowerEditor PowerEditor;

	// 可重载这个方法，设置不同的按钮图标
	protected Icon getImageIcon() {
		return ASSIGN_ICON;
	}

	@Override
	protected boolean isActionEnable() {
		Object obj = getModel().getSelectedData();
		if (getModel().getUiState() == UIState.NOT_EDIT && obj != null)
			return true;
		else
			return false;
	}

	public AssignAction() {
		putValue(SMALL_ICON, getImageIcon());
		setBtnName(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID(
				"10120RESPADMIN", "010120RESPADMIN0000")/* @res "分配功能" */);
		putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('F', KeyEvent.CTRL_DOWN_MASK));
		putValue(
				Action.SHORT_DESCRIPTION,
				nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID(
						"10120RESPADMIN", "010120RESPADMIN0001")/*
																 * @res
																 * "分配功能(Ctrl+F)"
																 */);
	}

	@Override
	public void doAction(ActionEvent arg0) throws Exception {
		if (!getPowerEditor().isComponentVisible())
			getPowerEditor().showMeUp();
		if (!getDetailTreePanel().isComponentVisible()) {
			getDetailTreePanel().showMeUp();
		}
		Object obj = getModel().getSelectedData();
		if (obj == null || !(obj instanceof DmPower))
			throw new BusinessException("请选择权限");


		String pk_power = ((DmPower) obj).getPrimaryKey();
		PowerAssignDialog dialog = new PowerAssignDialog(getModel()
				.getContext().getEntranceUI());

		dialog.setModel(getModel());
		dialog.setDetailTreeModel(getDetailTreeModel());
		dialog.setPk_power(pk_power);

		dialog.initUI();
		dialog.showModal();

	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	public DetailTreeModel getDetailTreeModel() {
		return detailTreeModel;
	}

	public void setDetailTreeModel(DetailTreeModel detailTreeModel) {
		this.detailTreeModel = detailTreeModel;
	}

	public DetailTreePanel getDetailTreePanel() {
		return detailTreePanel;
	}

	public void setDetailTreePanel(DetailTreePanel detailTreePanel) {
		this.detailTreePanel = detailTreePanel;
	}

	public PowerEditor getPowerEditor() {
		return PowerEditor;
	}

	public void setPowerEditor(PowerEditor powerEditor) {
		PowerEditor = powerEditor;
	}

}
