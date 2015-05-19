package nc.ui.docmng.doctype.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.billform.AddEvent;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pubapp.AppContext;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillItem;

public class AceAddHandler implements IAppEventHandler<AddEvent> {

	@Override
	public void handleAppEvent(AddEvent e) {
		String pk_group = e.getContext().getPk_group();
		String pk_org = e.getContext().getPk_org();
		BillCardPanel panel = e.getBillForm().getBillCardPanel();
		// 设置主组织默认值
		panel.setHeadItem("pk_group", pk_group);
		panel.setHeadItem("pk_org", pk_org);
		initParentCode(e);
	}
	
	
	private void initParentCode(AddEvent e){
		BillItem item = e.getBillForm().getBillCardPanel().getHeadItem("pid");
		if(e.getBillForm().getModel().getSelectedData()!=null){
			DocType dtype = (DocType)e.getBillForm().getModel().getSelectedData();
			item.setValue(dtype.getPk_doctype());
			item.setEdit(false);
		}else
			item.setEdit(true);
	}
}
