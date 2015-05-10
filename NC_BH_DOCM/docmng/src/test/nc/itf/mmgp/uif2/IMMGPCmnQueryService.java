package nc.itf.mmgp.uif2;

import java.util.List;
import java.util.Map;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pub.ISuperVO;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.lazilyload.BillLazilyLoaderVO;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;

public interface IMMGPCmnQueryService {

    Object[] cmnQueryAllDatas(Class< ? > clazz) throws BusinessException;

    Object[] cmnQueryDatasByCondition(Class< ? > clazz,
                                      String con) throws BusinessException;

    Object cmnQueryDatasByPk(Class< ? > clazz,
                             String pk) throws BusinessException;
    
    /**
     * @param clazz
     * @param pks
     * @return
     * @throws BusinessException
     */
    Object[] cmnQueryDatasByPks(Class< ? > clazz,
                                String[] pks) throws BusinessException;

    Object[] cmnQueryDatasByConditionWithDataPermission(Class< ? > clazz,
                                                        String con,
                                                        String resouceCode,
                                                        String opratecode) throws BusinessException;

    Object[] cmnQueryDatasByConditionLazyLoad(Class< ? > clazz,
                                              String con,
                                              boolean isLazyLoad) throws BusinessException;

    IBill cmnQueryChildrenByParentPK(Class< ? > clazz,
                                     String parentPk) throws BusinessException;

    Map<String, Map<Class< ? extends ISuperVO>, SuperVO[]>> cmnQueryChildrenByParent(Map<BillLazilyLoaderVO, List<Class< ? extends ISuperVO>>> map)
            throws BusinessException;

    /**
     * ͨ����ѯ������ѯ��֧����������������
     * 
     * @param clazz
     * @param queryScheme
     *        IQueryScheme
     * @param billTypeCode
     *        ��������
     * @return ��ѯ��� 
     * @throws BusinessException
     *         �쳣
     */
    Object[] cmnQueryDatasByScheme(Class< ? extends AbstractBill> clazz,
                                   IQueryScheme queryScheme,
                                   String billTypeCode) throws BusinessException;

}
