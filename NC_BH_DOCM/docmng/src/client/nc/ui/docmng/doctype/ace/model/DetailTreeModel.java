package nc.ui.docmng.doctype.ace.model;

import nc.ui.uif2.model.HierachicalDataAppModel;

public class DetailTreeModel extends HierachicalDataAppModel {

	//为了解决权限关联功能异步加载而造成的，分配对话框已分配从Model中取出错误数据的问题。
	private String whichResponsibility;

	public String getWhichResponsibility() {
		return whichResponsibility;
	}

	public void setWhichResponsibility(String whichResponsibility) {
		this.whichResponsibility = whichResponsibility;
	}
}
