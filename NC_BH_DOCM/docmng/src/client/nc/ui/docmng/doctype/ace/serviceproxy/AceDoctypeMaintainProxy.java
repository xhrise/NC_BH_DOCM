package nc.ui.docmng.doctype.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.vo.docmng.doctype.DocType;
import nc.itf.docmng.IDoctypeMaintain;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.ui.pubapp.uif2app.model.IQueryService;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.uif2.LoginContext;

/**
 * 示例单据的操作代理
 * 
 * @author author
 * @version tempProject version
 */
public class AceDoctypeMaintainProxy implements IAppModelService, IQueryService {
	@Override
	public Object insert(Object object) throws Exception {
		IDoctypeMaintain operator = NCLocator.getInstance().lookup(
				IDoctypeMaintain.class);
		return operator.insert((DocType) object);
	}

	@Override
	public Object update(Object object) throws Exception {
		IDoctypeMaintain operator = NCLocator.getInstance().lookup(
				IDoctypeMaintain.class);
		return operator.update((DocType) object);
	}

	@Override
	public void delete(Object object) throws Exception {
		IDoctypeMaintain operator = NCLocator.getInstance().lookup(
				IDoctypeMaintain.class);
		operator.delete((DocType) object);
	}

	@Override
	public Object[] queryByWhereSql(String whereSql) throws Exception {
		IDoctypeMaintain query = NCLocator.getInstance().lookup(
				IDoctypeMaintain.class);
		return query.query(whereSql);
	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext context)
			throws Exception {
		return null;
	}
}
