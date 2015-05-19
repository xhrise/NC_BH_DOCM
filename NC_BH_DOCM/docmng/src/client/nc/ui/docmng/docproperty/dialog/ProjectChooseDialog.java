package nc.ui.docmng.docproperty.dialog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import nc.desktop.ui.WorkbenchEnvironment;
import nc.ui.docmng.docproperty.ref.ProjectDefaultRefModel;
import nc.ui.pub.ClientEnvironment;
import nc.ui.pub.beans.UIButton;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillItem;
import nc.ui.uif2.editor.BillForm;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.pubapp.AppContext;

@SuppressWarnings("deprecation")
public class ProjectChooseDialog extends UIDialog {
	
	
	private BillCardPanel bcp;
	
	private UIButton affirmBtn;

	private UIButton cancelBtn;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ProjectChooseDialog(Container con){
		super(con);
		this.init();
		
	}
	
	private class DialogExcutor implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == ProjectChooseDialog.this.getAffirmBtn())
			{
				ProjectChooseDialog.this.onBtnAffirm();
			} else if (e.getSource() == ProjectChooseDialog.this
					.getCancelBtn())
			{
				ProjectChooseDialog.this.onBtnCancel();
			}
		}

	}
	
	private void onBtnCancel()
	{
		this.closeCancel();

	}
	
	
	private void onBtnAffirm() {
		this.closeOK();
	}
	
	public Map<String, String> getChoise(){
		BillItem[] items = this.bcp.getHeadItems();
		Map<String, String> map = new HashMap<String, String>();
		for(BillItem item : items){
			map.put(item.getKey(), item.getValueObject()==null?null:item.getValueObject().toString());
		}
		return map;
	}


	private void init(){
		this.setTitle("上传信息");
		this.setSize(750, 300); 
		this.setResizable(true);
		UIPanel uip = new UIPanel(new BorderLayout());
		uip.add(this.getBillCardPanel());
		UIPanel btnPanel = new UIPanel();
		btnPanel.add(this.getAffirmBtn());
		btnPanel.add(this.getCancelBtn());
		UIPanel content = new UIPanel(new BorderLayout());
		content.add(uip,BorderLayout.CENTER);
		content.add(btnPanel,BorderLayout.SOUTH);
		this.setContentPane(content);
		DialogExcutor excutor = new DialogExcutor();
		this.getAffirmBtn().addActionListener(excutor);
		this.getCancelBtn().addActionListener(excutor);
	}
	
	private BillCardPanel getBillCardPanel() {
		if(this.bcp==null){
			this.bcp = new BillCardPanel();
			this.bcp.loadTemplet("DMJ10201", "", "", "");
			BillItem itemProject = this.bcp.getHeadItem(DocProperty.PK_PROJECT);
			UIRefPane uiPanel = (UIRefPane) itemProject.getComponent();
//			ProjectDefaultRefModel project = (ProjectDefaultRefModel) uiPanel.getRefModel();
//			project.setOrgvos(null);
//			uiPanel.setPk_org(null);
//			project.reloadData();
			uiPanel.setRefModel(new ProjectDefaultRefModel());
			BillItem itemUpload = this.bcp.getHeadItem("pk_uploader");
			itemUpload.setValue(AppContext.getInstance().getPkUser());
			BillItem dcreatedate = this.bcp.getHeadItem("dcreatedate");
			dcreatedate.setValue(AppContext.getInstance().getBusiDate());
		}
		return this.bcp;
	}
	
	private UIButton getAffirmBtn()
	{
		if (this.affirmBtn == null)
		{
			String msg = "确定";
			this.affirmBtn = new UIButton(msg);
			this.affirmBtn.setToolTipText(msg);
		}
		return this.affirmBtn;
	}

	private UIButton getCancelBtn()
	{
		if (this.cancelBtn == null)
		{
			this.cancelBtn = new UIButton("取消");
			this.cancelBtn.setToolTipText("取消");
		}
		return this.cancelBtn;
	}

}
