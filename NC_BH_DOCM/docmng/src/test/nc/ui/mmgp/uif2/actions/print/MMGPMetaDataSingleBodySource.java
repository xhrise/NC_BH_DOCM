package nc.ui.mmgp.uif2.actions.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nc.ui.bd.pub.actions.print.MetaDataAllDatasSource;
import nc.ui.mmgp.uif2.scale.MMGPCardNumScaleBean;
import nc.ui.mmgp.uif2.scale.MMGPNumScaleBean;
import nc.vo.mmgp.util.MMArrayUtil;
import nc.vo.mmgp.util.MMSystemUtil;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;

@SuppressWarnings("serial")
public class MMGPMetaDataSingleBodySource extends MetaDataAllDatasSource
		implements BeanFactoryAware {
	private List<MMGPNumScaleBean> scaleBeans = new ArrayList<MMGPNumScaleBean>();

	@Override
	public Object[] getMDObjects() {
		Object[] objs = super.getMDObjects();
		if (MMArrayUtil.isEmpty(objs)) {
			return null;
		}
		PrintNumScaleUtils.setPrintScale(objs, getModel().getContext()
				.getPk_group(), scaleBeans, true);
		return objs;
	}

	//
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		ListableBeanFactory factory = (ListableBeanFactory) beanFactory;

		MMSystemUtil.assertTrue(getModel().getContext() != null);

		this.deal(factory);
	}

	protected void deal(ListableBeanFactory factory) {
		Collection<MMGPNumScaleBean> numScaleBeans = BeanFactoryUtils
				.beansOfTypeIncludingAncestors(factory, MMGPNumScaleBean.class)
				.values();
		scaleBeans.addAll(numScaleBeans);
		Collection<MMGPCardNumScaleBean> cardBeans = BeanFactoryUtils
				.beansOfTypeIncludingAncestors(factory,
						MMGPCardNumScaleBean.class).values();
		scaleBeans.addAll(cardBeans);

	}
}
