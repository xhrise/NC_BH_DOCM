package nc.ui.mmgp.uif2.lazilyload;

import nc.md.model.IBean;
import nc.md.model.access.javamap.BeanStyleEnum;
import nc.ui.mmgp.uif2.utils.MMGPMetaUtils;
import nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager;
import nc.ui.pubapp.uif2app.model.BillManageModel;

public class MMGPLazilyLoadManager extends LazilyLoadManager {

	@Override
	public void setModel(BillManageModel billManageModel) {
		IBean bean = MMGPMetaUtils.getIBean(billManageModel.getContext());
		// 只有主子表才好使
		if(bean.getBeanStyle().getStyle() == BeanStyleEnum.AGGVO_HEAD ||bean.getBeanStyle().getStyle() ==  BeanStyleEnum.EXTAGGVO_HEAD){
			super.setModel(billManageModel);
		}
	}

}
