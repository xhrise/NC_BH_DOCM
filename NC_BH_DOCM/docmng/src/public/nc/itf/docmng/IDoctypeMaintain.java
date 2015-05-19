package nc.itf.docmng;

import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.BusinessException;

public interface IDoctypeMaintain {

	public void delete(DocType vo) throws BusinessException;

	public DocType insert(DocType vo) throws BusinessException;

	public DocType update(DocType vo) throws BusinessException;

	public DocType[] query(String whereSql) throws BusinessException;
}