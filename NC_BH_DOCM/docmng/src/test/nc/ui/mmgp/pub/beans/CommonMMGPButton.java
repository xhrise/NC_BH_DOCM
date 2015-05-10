package nc.ui.mmgp.pub.beans;

import nc.ui.mmgp.base.IUIState;

/**
 * <b> ���а�ť���� </b>
 * <p>
 * ��ϸ��������
 * </p>
 * ��������:2011-2-22
 * 
 * @author wangweiu
 * @deprecated by wangweiu :ȫ��ʹ��NCAction���а�ť��ʾ
 * @see nc.ui.uif2.NCAction
 */
public class CommonMMGPButton {

    public static MMGPButtonObject createEditButton() {
        MMGPButtonObject bo = new MMGPButtonObject("�޸�", "�޸�", "�޸�");
        bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createFileButton() {
        MMGPButtonObject bo = new MMGPButtonObject("�ļ�", "�ļ�", "�ļ�");
        bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createOpenButton() {
        MMGPButtonObject bo = new MMGPButtonObject("��", "��", "��");
        bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createDelButton() {

        MMGPButtonObject bo = new MMGPButtonObject("ɾ��", "ɾ��", "ɾ��");
        bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE, IUIState.STATE_MODIFY });
        return bo;
    }
    
    public static MMGPButtonObject createSaveButton() {
    	
    	MMGPButtonObject bo = new MMGPButtonObject("����", "����", "����");
    	bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE, IUIState.STATE_MODIFY });
    	return bo;
    }
    
    public static MMGPButtonObject createCircleButton() {
    	
    	MMGPButtonObject bo = new MMGPButtonObject("��·���", "��·���", "��·���");
    	bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE, IUIState.STATE_MODIFY });
    	return bo;
    }

    public static MMGPButtonObject createCancelButton() {
        MMGPButtonObject bo = new MMGPButtonObject("ȡ��", "ȡ��", "ȡ��");
        bo.setOprateStatus(new int[]{IUIState.STATE_MODIFY, IUIState.STATE_ADD });
        return bo;
    }

    public static MMGPButtonObject createCommitButton() {
        MMGPButtonObject bo = new MMGPButtonObject("�ύ", "�ύ", "�ύ");
        bo.setOprateStatus(new int[]{IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createUnCommitButton() {
        MMGPButtonObject bo = new MMGPButtonObject("ȡ���ύ", "ȡ���ύ", "ȡ���ύ");
        bo.setOprateStatus(new int[]{IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createExportButton() {
        MMGPButtonObject bo = new MMGPButtonObject("����", "����", "����");
        bo.setOprateStatus(new int[]{IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createRefreshButton() {
        MMGPButtonObject bo = new MMGPButtonObject("ˢ��", "ˢ��", "ˢ��");
        bo.setOprateStatus(new int[]{IUIState.STATE_CARD_BROWSE, IUIState.STATE_LIST });
        return bo;
    }

    public static MMGPButtonObject createQueryButton() {
        MMGPButtonObject bo = new MMGPButtonObject("��ѯ", "��ѯ", "��ѯ");
        bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createZoomOutButton() {
        MMGPButtonObject bo = new MMGPButtonObject("�Ŵ�", "�Ŵ�", "�Ŵ�");
        bo.setOprateStatus(new int[]{IUIState.STATE_CARD_BROWSE, IUIState.STATE_LIST });
        return bo;
    }

    public static MMGPButtonObject createZoomInButton() {
        MMGPButtonObject bo = new MMGPButtonObject("��С", "��С", "��С");
        bo.setOprateStatus(new int[]{IUIState.STATE_CARD_BROWSE, IUIState.STATE_LIST });
        return bo;
    }

    public static MMGPButtonObject createZoomResetButton() {
        MMGPButtonObject bo = new MMGPButtonObject("��ԭ", "��ԭ", "��ԭ");
        bo.setOprateStatus(new int[]{IUIState.STATE_CARD_BROWSE, IUIState.STATE_LIST });
        return bo;

    }

    public static MMGPButtonObject createViewButton() {
        MMGPButtonObject bo = new MMGPButtonObject("��ͼ", "��ͼ", "��ͼ");
        bo.setOprateStatus(new int[]{IUIState.STATE_MODIFY, IUIState.STATE_CARD_BROWSE, IUIState.STATE_LIST });
        return bo;
    }

    public static MMGPButtonObject createNewButton() {
        MMGPButtonObject bo = new MMGPButtonObject("�½�", "�½�", "�½�");
        bo.setOprateStatus(new int[]{IUIState.STATE_INIT, IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createSealButton() {
        MMGPButtonObject bo = new MMGPButtonObject("���", "���", "���");
        bo.setOprateStatus(new int[]{IUIState.STATE_MODIFY, IUIState.STATE_CARD_BROWSE });
        return bo;
    }

    public static MMGPButtonObject createCancelSealButton() {
        MMGPButtonObject bo = new MMGPButtonObject("���", "���", "���");
        bo.setOprateStatus(new int[]{IUIState.STATE_MODIFY, IUIState.STATE_CARD_BROWSE });
        return bo;
    }

}
