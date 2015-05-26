package nc.ui.docmng.docproperty.dialog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import nc.desktop.ui.WorkbenchEnvironment;
import nc.ui.docmng.docproperty.ref.ProjectDefaultRefModel;
import nc.ui.docmng.ref.SubProjectRefModel;
import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.beans.UIButton;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillEditListener;
import nc.ui.pub.bill.BillItem;
import nc.ui.uif2.editor.BillForm;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.pubapp.AppContext;

@SuppressWarnings("deprecation")
public class BatchDownloadDialog extends UIDialog {

	private BillCardPanel bcp;

	private UIButton affirmBtn;

	private UIButton cancelBtn;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BatchDownloadDialog(Container con) {
		super(con);
		this.init();

	}

	private class DialogExcutor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == BatchDownloadDialog.this.getAffirmBtn()) {
				BatchDownloadDialog.this.onBtnAffirm();
			} else if (e.getSource() == BatchDownloadDialog.this.getCancelBtn()) {
				BatchDownloadDialog.this.onBtnCancel();
			}
		}

	}

	private void onBtnCancel() {
		this.closeCancel();

	}

	private void onBtnAffirm() {
		this.closeOK();
	}

	public Map<String, String> getChoise() {
		BillItem[] items = this.bcp.getHeadItems();
		Map<String, String> map = new HashMap<String, String>();
		for (BillItem item : items) {
			map.put(item.getKey(), item.getValueObject() == null ? null : item
					.getValueObject().toString());
		}
		return map;
	}

	private void init() {
		this.setTitle("下载信息");
		this.setSize(600, 100);
		this.setResizable(true);
		UIPanel uip = new UIPanel(new BorderLayout());
		uip.add(this.getBillCardPanel());
		UIPanel btnPanel = new UIPanel();
		btnPanel.add(this.getAffirmBtn());
		btnPanel.add(this.getCancelBtn());
		UIPanel content = new UIPanel(new BorderLayout());
		content.add(uip, BorderLayout.CENTER);
		content.add(btnPanel, BorderLayout.SOUTH);
		this.setContentPane(content);
		DialogExcutor excutor = new DialogExcutor();
		this.getAffirmBtn().addActionListener(excutor);
		this.getCancelBtn().addActionListener(excutor);
	}

	private BillCardPanel getBillCardPanel() {
		if (this.bcp == null) {
			this.bcp = new BillCardPanel();
			this.bcp.loadTemplet("DMJ10203", "", "", "");
			BillItem itemProject = this.bcp.getHeadItem(DocProperty.PK_PROJECT);
			UIRefPane uiPanel = (UIRefPane) itemProject.getComponent();
			// ProjectDefaultRefModel project = (ProjectDefaultRefModel)
			// uiPanel.getRefModel();
			// project.setOrgvos(null);
			// uiPanel.setPk_org(null);
			// project.reloadData();
			uiPanel.setRefModel(new ProjectDefaultRefModel());
			bcp.addEditListener(new BillEditListener() {

				@Override
				public void bodyRowChange(BillEditEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterEdit(BillEditEvent e) {
					if (e.getKey().equals("pk_project")) {
						BillItem item = BatchDownloadDialog.this.bcp
								.getHeadItem("def1");
						item.setValue(null);
						BillItem project = BatchDownloadDialog.this.bcp
								.getHeadItem("pk_project");
						UIRefPane ref = (UIRefPane) item.getComponent();
						SubProjectRefModel refModel =  (SubProjectRefModel) ref.getRefModel();
						refModel.setKey(project==null?"":project.getValueObject().toString());
					}
				}
			});
		}
		return this.bcp;
	}

	private UIButton getAffirmBtn() {
		if (this.affirmBtn == null) {
			String msg = "确定";
			this.affirmBtn = new UIButton(msg);
			this.affirmBtn.setToolTipText(msg);
		}
		return this.affirmBtn;
	}

	private UIButton getCancelBtn() {
		if (this.cancelBtn == null) {
			this.cancelBtn = new UIButton("取消");
			this.cancelBtn.setToolTipText("取消");
		}
		return this.cancelBtn;
	}

}
