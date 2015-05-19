package nc.ui.docmng.docproperty.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import nc.bs.uif2.BusinessExceptionAdapter;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.md.MDBaseQueryFacade;
import nc.md.data.access.NCObject;
import nc.md.model.IBean;
import nc.md.model.IBusinessEntity;
import nc.ui.docmng.docproperty.util.DocmngUtil;
import nc.ui.pub.filesystem.FileManageServletClient;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.list.ListBillItemHyperlinkEvent;
import nc.ui.pubapp.uif2app.event.list.ListHeadDoubleClickEvent;
import nc.ui.pubapp.uif2app.model.IAppModelEx;
import nc.ui.pubapp.uif2app.view.BillListView;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.bd.meta.IBDObject;
import nc.vo.bd.meta.NCObject2BDObjectAdapter;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;

public class MouseClickShowPanelMediator {

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
	}

	private BillManageModel model;

	class ListHyperLinkListener implements
			IAppEventHandler<ListBillItemHyperlinkEvent> {

		@Override
		public void handleAppEvent(ListBillItemHyperlinkEvent e) {
			// 配置了多个MouseClickShowPanelMediator时，会多次进入此方法，需要加上事件源的比对，避免调用覆盖
			if (e.getItem()
					.getKey()
					.equals(MouseClickShowPanelMediator.this
							.getHyperLinkColumn())
					&& e.getBillListPanel() == MouseClickShowPanelMediator.this
							.getListView().getBillListPanel()) {
				MouseClickShowPanelMediator.this.showUpComponent.showMeUp();
				MouseClickShowPanelMediator.this
						.setCardSelectedTabedPaneFromList();
				MouseClickShowPanelMediator.this.showSuccessInfo();
			}
		}

	}

	class MouseListenerHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() > 1) {
				try {
					String dsName = WorkbenchEnvironment.getInstance()
							.getLoginBusiCenter().getDataSourceName();
					String path = MouseClickShowPanelMediator.this
							.getFilePath();
					if (path != null)
						FileManageServletClient.showFileInWeb(dsName, path);
				} catch (BusinessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		}
	}

	// 设置卡片界面表体选中页签为列表界面表体选中页签
	protected void setCardSelectedTabedPaneFromList() {
		int listTabIndex = listView.getBillListPanel().getBodyTabbedPane()
				.getSelectedIndex();
		if (showUpComponent instanceof nc.ui.uif2.editor.BillForm) {
			int cardTabCount = ((nc.ui.uif2.editor.BillForm) showUpComponent)
					.getBillCardPanel().getBodyTabbedPane().getTabCount();
			if (cardTabCount == 0)
				return;
			((nc.ui.uif2.editor.BillForm) showUpComponent).getBillCardPanel()
					.getBodyTabbedPane().setSelectedIndex(listTabIndex);
		}
	}

	IAutoShowUpComponent showUpComponent;

	private String hyperLinkColumn;

	private BillListView listView;

	public String getHyperLinkColumn() {
		return this.hyperLinkColumn;
	}

	public BillListView getListView() {
		return this.listView;
	}

	public IAutoShowUpComponent getShowUpComponent() {
		return this.showUpComponent;
	}

	public void setHyperLinkColumn(String hyperLinkColumn) {
		this.hyperLinkColumn = hyperLinkColumn;
	}

	public void setListView(BillListView listView) {
		this.listView = listView;
		this.match();
	}

	public void setShowUpComponent(IAutoShowUpComponent showUpComponent) {
		this.showUpComponent = showUpComponent;
		this.match();
	}

	/**
	 * 切换界面时清空状态栏提示信息
	 */
	void showSuccessInfo() {
		ShowStatusBarMsgUtil.showStatusBarMsg(null, this.listView.getModel()
				.getContext());
	}

	private void match() {
		if (null == this.listView || null == this.showUpComponent) {
			return;
		}
		MouseListenerHandler l = new MouseListenerHandler();
		this.listView.getBillListPanel().getHeadTable().addMouseListener(l);
		// listView.getBillListPanel().getBodyTable().addMouseListener(l);
		((IAppModelEx) this.listView.getModel()).addAppEventListener(
				ListBillItemHyperlinkEvent.class, new ListHyperLinkListener());
	}

	public String getFilePath() throws BusinessException {

		AggDocProperty aggVO = (AggDocProperty) this.getModel()
				.getSelectedData();
		if (aggVO == null) {
			return null;
		}
		IBDObject target = this.createBDObject(aggVO);
		DocProperty parent = aggVO.getParentVO();
		String path = (String) target.getId();
		StringBuilder sb = new StringBuilder(DocmngUtil.path);
		sb.append(path);
		sb.append("/");
		if(parent.getVname()!=null && !parent.getVname().equals(""))
		sb.append(parent.getVname());
		return sb.toString();
	}

	private IBDObject createBDObject(Object obj) {
		if (obj == null) {
			return null;
		}

		if (obj instanceof String) {
			return null;
		}

		// 元数据
		try {
			String className = null;
			if (obj instanceof AbstractBill) {
				className = ((AbstractBill) obj).getParentVO().getClass()
						.getName();
			} else {
				className = obj.getClass().getName();
			}
			// TODO: 递归搜索父类所对应的元数据，以支持继承
			IBean bean = MDBaseQueryFacade.getInstance()
					.getBeanByFullClassName(className);
			if (bean == null) {
				return null;
			}
			Map<String, String> name_path_map = ((IBusinessEntity) bean)
					.getBizInterfaceMapInfo(IBDObject.class.getName());
			return new NCObject2BDObjectAdapter(NCObject.newInstance(obj),
					name_path_map);
		} catch (nc.md.model.MetaDataException e) {
			throw new BusinessExceptionAdapter(e);
		}
	}

}
