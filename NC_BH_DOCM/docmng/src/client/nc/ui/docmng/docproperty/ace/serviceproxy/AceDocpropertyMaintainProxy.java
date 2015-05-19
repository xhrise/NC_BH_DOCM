package nc.ui.docmng.docproperty.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.itf.docmng.IDocpropertyMaintain;
import nc.ui.pubapp.uif2app.query2.model.IQueryService;
import nc.ui.querytemplate.querytree.IQueryScheme;

/**
 * 示例单据的操作代理
 * 
 * @author author
 * @version tempProject version
 */
public class AceDocpropertyMaintainProxy implements IQueryService {
	@Override
	public Object[] queryByQueryScheme(IQueryScheme queryScheme)
			throws Exception {
		IDocpropertyMaintain query = NCLocator.getInstance().lookup(
				IDocpropertyMaintain.class);
		return query.query(queryScheme);
	}

}