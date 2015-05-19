package nc.impl.docmng;

import nc.impl.pub.ace.AceDoctypePubServiceImpl;
import nc.itf.docmng.IDoctypeMaintain;
import nc.vo.docmng.doctype.DocType;
import nc.vo.pub.BusinessException;

public class DoctypeMaintainImpl extends AceDoctypePubServiceImpl implements IDoctypeMaintain {

      @Override
    public void delete(DocType vos) throws BusinessException {
        super.deletetreeinfo(vos);
    }
  
      @Override
    public DocType insert(DocType vos) throws BusinessException {
        return super.inserttreeinfo(vos);
    }
    
      @Override
    public DocType update(DocType vos) throws BusinessException {
        return super.updatetreeinfo(vos);    
    }
  
      @Override
    public DocType[] query(String whereSql)
        throws BusinessException {
        return super.querytreeinfo(whereSql);
    }

  
}
