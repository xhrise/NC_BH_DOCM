package nc.ui.docmng.docproperty.treemanage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.ui.pubapp.uif2app.model.IQueryService;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.query.IQueryConstants;
import nc.vo.uif2.LoginContext;

@SuppressWarnings("restriction")
public class DocTypeAppService implements IAppModelService,IQueryService {

	@Override
	public Object insert(Object object) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Object update(Object object) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void delete(Object object) throws Exception {
		// TODO �Զ����ɵķ������

	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext context)
			throws Exception {
		// lxiaofan
		// �÷�����ȡ�����ݣ������BDObjectAdpaterFactory�е�createBDObject���������������Ԫ���ݽ��в㼶����
		final List<DocType> result = new ArrayList<DocType>();
		Collection c = NCLocator
				.getInstance()
				.lookup(IUAPQueryBS.class)
				.retrieveByClause(DocType.class,
						" isnull(dr,0) = 0 and 1=1 ");
		result.addAll(c);
		return result.toArray(new DocType[0]);
	}

	@Override
	public Object[] queryByWhereSql(String whereSql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
