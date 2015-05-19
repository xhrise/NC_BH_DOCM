package nc.ui.docmng.docproperty.treemanage;

import nc.bs.logging.Logger;
import nc.ui.pubapp.uif2app.query2.model.IModelDataManager;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.ui.uif2.model.IAppModelDataManager;

public class DocTypeDataManager implements IAppModelDataManager, IModelDataManager {
	
	/**
	 * �̳нӿ�IModelDataManager�������޷����ذ�ť
	 */
	
	HierachicalDataAppModel model;
	
	public HierachicalDataAppModel getModel() {
		return model;
	}

	public void setModel(HierachicalDataAppModel model) {
		this.model = model;
	}

	public DocTypeDataManager(){
		super();
	}

	@Override
	public void initModelByQueryScheme(IQueryScheme queryScheme) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void refresh() {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void initModel() {
		Object[] classVOs = null;
		try {
			classVOs = new DocTypeAppService().queryByDataVisibilitySetting(getModel().getContext());
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		getModel().initModel(classVOs);
		
	}

}
