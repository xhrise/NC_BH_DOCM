package nc.ui.mmgp.uif2.scale.mediator;

import java.util.Collection;

import nc.ui.mmgp.uif2.scale.MMGPCardNumScaleBean;
import nc.ui.mmgp.uif2.scale.MMGPListNumScaleBean;
import nc.ui.mmgp.uif2.scale.MMGPNumScaleBean;
import nc.ui.uif2.editor.IBillCardPanelEditor;
import nc.ui.uif2.editor.IBillListPanelView;
import nc.vo.mmgp.util.MMSystemUtil;
import nc.vo.uif2.LoginContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;

public class MMGPDefaultNumScaleMediator implements BeanFactoryAware {

	private IBillCardPanelEditor editor;

	private IBillListPanelView listView;

	private LoginContext context;

	public MMGPDefaultNumScaleMediator() {
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		ListableBeanFactory factory = (ListableBeanFactory) beanFactory;

		MMSystemUtil.assertTrue(context != null);

		this.deal(factory);
	}

	protected void deal(ListableBeanFactory factory) {
		Collection<MMGPNumScaleBean> scaleBeans = BeanFactoryUtils
				.beansOfTypeIncludingAncestors(factory, MMGPNumScaleBean.class)
				.values();

		Collection<MMGPCardNumScaleBean> cardBeans = BeanFactoryUtils
				.beansOfTypeIncludingAncestors(factory,
						MMGPCardNumScaleBean.class).values();


		Collection<MMGPListNumScaleBean> listBeans = BeanFactoryUtils
				.beansOfTypeIncludingAncestors(factory,
						MMGPListNumScaleBean.class).values();
		
		MMGPPanelNumScaleMediator mnm = new MMGPPanelNumScaleMediator();
		mnm.setContext(getContext());
		
		mnm.setBillCardPanel(getEditor().getBillCardPanel());
		mnm.setBillListPanel(getListView().getBillListPanel());
		
		mnm.setScaleBeanList(scaleBeans);
		mnm.setCardScaleBeanList(cardBeans);
		mnm.setListScaleBeanList(listBeans);
		
		mnm.init();


	}


	public IBillCardPanelEditor getEditor() {
		return editor;
	}

	public void setEditor(IBillCardPanelEditor editor) {
		this.editor = editor;
	}

	public IBillListPanelView getListView() {
		return listView;
	}

	public void setListView(IBillListPanelView listView) {
		this.listView = listView;
	}

	public LoginContext getContext() {
		return context;
	}

	public void setContext(LoginContext context) {
		this.context = context;
	}

}
