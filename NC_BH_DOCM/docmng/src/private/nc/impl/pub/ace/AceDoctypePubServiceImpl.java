package nc.impl.pub.ace;

import nc.vo.docmng.doctype.DocType;
import nc.bs.pubapp.pub.rule.FillUpdateDataRule;
import nc.impl.pubapp.pattern.data.vo.VODelete;
import nc.impl.pubapp.pattern.data.vo.VOInsert;
import nc.impl.pubapp.pattern.data.vo.VOQuery;
import nc.impl.pubapp.pattern.data.vo.VOUpdate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.util.AuditInfoUtil;

public abstract class AceDoctypePubServiceImpl {

	// 增加方法
	public DocType inserttreeinfo(DocType vo) throws BusinessException {
		try {
			// 添加BP规则
			AroundProcesser<DocType> processer = new AroundProcesser<DocType>(
					null);
			AuditInfoUtil.addData(vo);
			processer.before(new DocType[] { vo });
			VOInsert<DocType> ins = new VOInsert<DocType>();
			DocType[] superVOs = ins.insert(new DocType[] { vo });
			return superVOs[0];
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// 删除方法
	public void deletetreeinfo(DocType vo) throws BusinessException {
		try {
			// 添加BP规则
			AroundProcesser<DocType> processer = new AroundProcesser<DocType>(
					null);
			processer.before(new DocType[] { vo });
			VODelete<DocType> voDel = new VODelete<DocType>();
			voDel.delete(new DocType[] { vo });
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}

	}

	// 修改方法
	public DocType updatetreeinfo(DocType vo) throws BusinessException {
		try {
			// 添加BP规则
			AroundProcesser<DocType> processer = new AroundProcesser<DocType>(
					null);

			DocType[] originVOs = this
					.getTreeCardVOs(new DocType[] { vo });
			AuditInfoUtil.updateData(vo);
			processer.before(new DocType[] { vo });
			VOUpdate<DocType> upd = new VOUpdate<DocType>();
			DocType[] superVOs = upd.update(new DocType[] { vo },
					originVOs);
			return superVOs[0];
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	private DocType[] getTreeCardVOs(DocType[] vos) {
		String[] ids = this.getIDS(vos);
		VOQuery<DocType> query = new VOQuery<DocType>(DocType.class);
		return query.query(ids);
	}

	private String[] getIDS(DocType[] vos) {
		int size = vos.length;
		String[] ids = new String[size];
		for (int i = 0; i < size; i++) {
			ids[i] = vos[i].getPrimaryKey();
		}
		return ids;
	}

	// 查询方法
	public DocType[] querytreeinfo(String whereSql) throws BusinessException {
		VOQuery<DocType> query = new VOQuery<DocType>(DocType.class);
		return query.query(whereSql, null);
	}
}