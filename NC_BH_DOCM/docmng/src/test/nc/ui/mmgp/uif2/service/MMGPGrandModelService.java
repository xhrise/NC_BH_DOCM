package nc.ui.mmgp.uif2.service;

import nc.bs.framework.common.NCLocator;
import nc.itf.mmgp.uif2.IMMGPGrandOperateService;
import nc.ui.pubapp.pub.task.ISingleBillService;
import nc.ui.pubapp.uif2app.actions.IDataOperationService;
import nc.vo.mmgp.util.MMStringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;

/**
 * <b> ��Ҫ�������� </b>
 * <p>
 * ��ϸ��������
 * </p>
 * 
 * @since �������� May 21, 2013
 * @author wangweir
 */
@SuppressWarnings("rawtypes")
public class MMGPGrandModelService implements IDataOperationService, ISingleBillService<IBill> {

    private IMMGPGrandOperateService manageService;

    private String manageServiceItf;

    /*
     * (non-Javadoc)
     * @see nc.ui.pubapp.pub.task.ISingleBillService#operateBill(java.lang.Object)
     */
    @Override
    public IBill operateBill(IBill bill) throws Exception {
        this.delete(new IBill[]{bill });
        return bill;
    }

    /*
     * (non-Javadoc)
     * @see nc.ui.pubapp.uif2app.actions.IDataOperationService#insert(nc.vo.pubapp.pattern.model.entity.bill.IBill[])
     */
    @Override
    public IBill[] insert(IBill[] value) throws BusinessException {
        return this.getManageService().insert(value);
    }

    /*
     * (non-Javadoc)
     * @see nc.ui.pubapp.uif2app.actions.IDataOperationService#update(nc.vo.pubapp.pattern.model.entity.bill.IBill[])
     */
    @Override
    public IBill[] update(IBill[] value) throws BusinessException {
        return this.getManageService().update(value);
    }

    /*
     * (non-Javadoc)
     * @see nc.ui.pubapp.uif2app.actions.IDataOperationService#delete(nc.vo.pubapp.pattern.model.entity.bill.IBill[])
     */
    @Override
    public IBill[] delete(IBill[] value) throws BusinessException {
        this.getManageService().delete(value);
        return null;
    }

    public IMMGPGrandOperateService getManageService() {
        if (manageService == null) {
            if (MMStringUtil.isNotEmpty(manageServiceItf)) {
                manageService = (IMMGPGrandOperateService) NCLocator.getInstance().lookup(manageServiceItf);
            } else {
                manageService = NCLocator.getInstance().lookup(IMMGPGrandOperateService.class);
            }
        }
        return manageService;
    }

    public String getManageServiceItf() {
        return manageServiceItf;
    }

    public void setManageServiceItf(String itfClassName) {
        try {
            Class clazz = Class.forName(itfClassName);
            if (!IMMGPGrandOperateService.class.isAssignableFrom(clazz)) {
                throw new IllegalArgumentException("��̨�ӿڱ���̳�nc.itf.mmgp.uif2.IMMGPGrandOperateService");
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("���õĺ�̨�ӿ�[" + itfClassName + "]������");
        }
        this.manageServiceItf = itfClassName;
    }

}
