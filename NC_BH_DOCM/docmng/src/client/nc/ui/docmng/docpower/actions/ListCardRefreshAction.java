package nc.ui.docmng.docpower.actions;


import java.awt.event.ActionEvent;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.md.data.access.NCObject;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.actions.RefreshAction;
import nc.ui.uif2.components.ITabbedPaneAwareComponent;
import nc.ui.uif2.model.AppEventConst;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.SuperVO;

public class ListCardRefreshAction extends RefreshAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3341367266577032669L;
	
	private IUAPQueryBS uapQry;
	private IMDPersistenceQueryService mdQry;
	
	private ITabbedPaneAwareComponent cardEditor;
	
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		if(!getCardEditor().isComponentVisible()) //列表界面在显示
			super.doAction(e);
		else{
			//卡片界面显示时，只刷新卡片数据; 
			BillManageModel manageModel = (BillManageModel)getModel();
			int selectedRow = manageModel.getSelectedRow();
			if(selectedRow<0) return;
			Object selectedObj = manageModel.getSelectedData();
			if(selectedObj instanceof SuperVO){
				SuperVO oldBillVO = (SuperVO)selectedObj;
				Object newBillVO = getUapQry().retrieveByPK(oldBillVO.getClass(), oldBillVO.getPrimaryKey());
				if(newBillVO!=null){
					copyNewValueToOldObject((SuperVO)newBillVO, oldBillVO);
					manageModel.setSelectedRow(selectedRow);
				}				
			}
			if(selectedObj instanceof AggregatedValueObject){
				AggregatedValueObject aggVO = (AggregatedValueObject)selectedObj;
				SuperVO oldBillVO = (SuperVO)aggVO.getParentVO();
				NCObject newBillNCVO = getMdQry().queryBillOfNCObjectByPK(oldBillVO.getClass(), oldBillVO.getPrimaryKey());
				if(newBillNCVO!=null){
					AggregatedValueObject newBillAggVO = (AggregatedValueObject)newBillNCVO.getContainmentObject();
					aggVO.setParentVO(newBillAggVO.getParentVO());
					manageModel.setSelectedRow(selectedRow);
				}				
			}
		}				
		

	}
	
	
	
	@Override
	public void doAfterSuccess(ActionEvent actionEvent) {
		//发数据刷新事件
		AppEvent refreshEvent = new AppEvent(AppEventConst.DATA_REFRESHED, getModel(), null);
		getModel().fireEvent(refreshEvent);
		super.doAfterSuccess(actionEvent);
	}
	
	
	private void copyNewValueToOldObject(SuperVO newBillVO,SuperVO oldBillVO){
		String[] attributeNames = oldBillVO.getAttributeNames();
		for(String attribute : attributeNames){
			oldBillVO.setAttributeValue(attribute, newBillVO.getAttributeValue(attribute));
		}
	}
	
	

	public void setCardEditor(ITabbedPaneAwareComponent cardEditor) {
		this.cardEditor = cardEditor;
	}

	public ITabbedPaneAwareComponent getCardEditor() {
		return cardEditor;
	}

	public IUAPQueryBS getUapQry() {
		if(uapQry == null){
			uapQry = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		}
		return uapQry;
	}
	
	public IMDPersistenceQueryService getMdQry(){
		if(mdQry == null){
			mdQry = NCLocator.getInstance().lookup(IMDPersistenceQueryService.class);
		}
		return mdQry;
	}

}
