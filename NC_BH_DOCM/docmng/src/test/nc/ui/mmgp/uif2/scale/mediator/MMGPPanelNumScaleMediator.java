package nc.ui.mmgp.uif2.scale.mediator;

import java.util.Collection;

import nc.ui.mmgp.uif2.scale.MMGPCardNumScaleBean;
import nc.ui.mmgp.uif2.scale.MMGPListNumScaleBean;
import nc.ui.mmgp.uif2.scale.MMGPNumScaleBean;
import nc.ui.mmgp.uif2.scale.NumScaleUtil;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillListPanel;
import nc.ui.pubapp.scale.CardPaneScaleProcessor;
import nc.ui.pubapp.scale.ListPaneScaleProcessor;
import nc.vo.mmgp.util.MMCollectionUtil;
import nc.vo.pubapp.scale.BillScaleProcessor;

public class MMGPPanelNumScaleMediator {

	private BillCardPanel billCardPanel;

	private BillListPanel billListPanel;

	private nc.vo.uif2.LoginContext context;

	private Collection<MMGPCardNumScaleBean> cardScaleBeanList;

	private Collection<MMGPListNumScaleBean> listScaleBeanList;

	private Collection<MMGPNumScaleBean> scaleBeanList;

	public void init() {

		setCardScale();

		setListScale();

	}

	protected void setListScale() {

		if (getBillListPanel() == null ) {
			return;
		}
		else if(MMCollectionUtil.isEmpty(getListScaleBeanList()) && MMCollectionUtil
				.isEmpty(getScaleBeanList())){
			return;
		}
				
				
		// 设置列表界面精度
		BillScaleProcessor scaleprocess = new ListPaneScaleProcessor(
				getContext().getPk_group(), getBillListPanel());

		if (!MMCollectionUtil.isEmpty(getScaleBeanList())) {
			NumScaleUtil.setScale(scaleprocess,
					getScaleBeanList().toArray(new MMGPNumScaleBean[0]));
		}

		if (!MMCollectionUtil.isEmpty(getListScaleBeanList())) {
			NumScaleUtil.setScale(scaleprocess,
					getListScaleBeanList().toArray(new MMGPNumScaleBean[0]));
		}
	}

	protected void setCardScale() {

		if (getBillCardPanel() == null ) {
			return;
		}
		else if(MMCollectionUtil.isEmpty(getCardScaleBeanList()) && MMCollectionUtil
				.isEmpty(getScaleBeanList())){
			return;
		}

		// 设置卡片界面精度
		BillScaleProcessor scaleprocess = new CardPaneScaleProcessor(
				getContext().getPk_group(), getBillCardPanel());

		if (!MMCollectionUtil.isEmpty(getScaleBeanList())) {
			NumScaleUtil.setScale(scaleprocess,
					getScaleBeanList().toArray(new MMGPNumScaleBean[0]));
		}

		if (!MMCollectionUtil.isEmpty(getCardScaleBeanList())) {
			NumScaleUtil.setScale(scaleprocess,
					getCardScaleBeanList().toArray(new MMGPNumScaleBean[0]));
		}
	}

	public nc.vo.uif2.LoginContext getContext() {
		return context;
	}

	public void setContext(nc.vo.uif2.LoginContext context) {
		this.context = context;
	}

	public BillCardPanel getBillCardPanel() {
		return billCardPanel;
	}

	public void setBillCardPanel(BillCardPanel billCardPanel) {
		this.billCardPanel = billCardPanel;
	}

	public BillListPanel getBillListPanel() {
		return billListPanel;
	}

	public void setBillListPanel(BillListPanel billListPanel) {
		this.billListPanel = billListPanel;
	}

	public Collection<MMGPCardNumScaleBean> getCardScaleBeanList() {
		return cardScaleBeanList;
	}

	public void setCardScaleBeanList(
			Collection<MMGPCardNumScaleBean> cardScaleBeanList) {
		this.cardScaleBeanList = cardScaleBeanList;
	}

	public Collection<MMGPListNumScaleBean> getListScaleBeanList() {
		return listScaleBeanList;
	}

	public void setListScaleBeanList(
			Collection<MMGPListNumScaleBean> listScaleBeanList) {
		this.listScaleBeanList = listScaleBeanList;
	}

	public Collection<MMGPNumScaleBean> getScaleBeanList() {
		return scaleBeanList;
	}

	public void setScaleBeanList(Collection<MMGPNumScaleBean> scaleBeanList) {
		this.scaleBeanList = scaleBeanList;
	}


}
