package nc.ui.docmng.docproperty.action;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.Map;

import nc.bs.pubapp.pf.util.ApproveFlowUtil;
import nc.md.data.access.NCObject;
import nc.ui.docmng.docproperty.dialog.UpdateDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pubapp.uif2app.actions.DifferentVOSaveAction;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;
import nc.ui.uif2.UIState;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.vo.pubapp.pattern.model.transfer.bill.ClientBillCombinServer;
import nc.vo.pubapp.pattern.model.transfer.bill.ClientBillToServer;

@SuppressWarnings("restriction")
public class UpdateAction extends DifferentVOSaveAction {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private ShowUpableBillForm billForm;
	
	private ShowUpableBillListView listView;
	
	


	public ShowUpableBillForm getBillForm() {
		return billForm;
	}

	public void setBillForm(ShowUpableBillForm billForm) {
		this.billForm = billForm;
	}

	public ShowUpableBillListView getListView() {
		return listView;
	}

	public void setListView(ShowUpableBillListView listView) {
		this.listView = listView;
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		Container con = this.billForm.isShowing()?this.billForm:this.listView;
		UpdateDialog upDLG = new UpdateDialog(con);
		if(upDLG.showModal()==UIDialog.ID_OK){
			AggDocProperty aggVO = (AggDocProperty) this.getModel().getSelectedData();
			DocProperty parent = aggVO.getParentVO();
			DocProperty newVO = (DocProperty) parent.clone();
			Map<String, String> map = upDLG.getChoise();
			for (Map.Entry<String, String> enty : map.entrySet()) {
				newVO.setAttributeValue(enty.getKey(), enty.getValue());
			}
			newVO.setStatus(VOStatus.UPDATED);
			AggDocProperty agg = new AggDocProperty();
			agg.setParentVO(newVO);
			this.doEditSave(agg);
		}

	}
	
	
	

	@Override
	protected void doEditSave(Object value) throws Exception {
	    // ȡ����vo����
	    IBill[] clientVOs = new IBill[] {
	      (IBill) value
	    };


	    IBill[] afterUpdateVOs = null;

	    // IAppModelService service = ((BillManageModel)
	    // this.getModel()).getService();
	    if (this.getService() == null) {
	      throw new BusinessException("service����Ϊ�ա�");/*-=notranslate=-*/
	    }
	    afterUpdateVOs = this.getService().update(clientVOs);

	    // clientVOsΪ�����ϵ����ݣ�afterUpdateVOsΪ��̨���صĲ�������
	    new ClientBillCombinServer<IBill>().combine(clientVOs, afterUpdateVOs);

	    this.getModel().directlyUpdate(clientVOs[0]);
	    this.getModel().setUiState(UIState.NOT_EDIT);
	}

	@Override
	protected boolean isActionEnable() {
		if(this.getModel()==null)
			return false;
		if (this.getModel().getSelectedData() != null) {
			NCObject obj = NCObject.newInstance(this.getModel()
					.getSelectedData());
			// ����̬ʱ�����޸�
			if (obj != null) {
				Integer fstatusflag = ApproveFlowUtil.getBillStatus(obj);
				if (this.tryMakeFlow(fstatusflag)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean tryMakeFlow(Integer fstatusflag) {
		return BillStatusEnum.APPROVED.equalsValue(fstatusflag);
	}
	
	

}
