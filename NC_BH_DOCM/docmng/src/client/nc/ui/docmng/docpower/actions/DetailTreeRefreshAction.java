package nc.ui.docmng.docpower.actions;


import java.awt.event.ActionEvent;

import org.apache.commons.lang.StringUtils;

import nc.bs.framework.common.NCLocator;
import nc.itf.docpower.IPowerQueryService;
import nc.ui.docmng.doctype.ace.model.DetailTreeModel;
import nc.ui.docmng.doctype.ace.view.DetailTreePanel;
import nc.ui.uap.rbac.resp.model.BusiFuncItemClientHelper;
import nc.ui.uif2.LoadingPanel;
import nc.ui.uif2.LongUITask;
import nc.ui.uif2.UIState;
import nc.ui.uif2.actions.RefreshAction;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.uap.rbac.BusiFuncItemSmartVO;
import nc.vo.uap.rbac.BusiFuncItemVO;
import nc.vo.uap.rbac.ResponsibilityVO;


public class DetailTreeRefreshAction extends RefreshAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4398617727858414202L;
	
	
	private BillManageModel appModel;
	
	private DetailTreeModel detailTreeModel;
	
	private DetailTreePanel detailTreePanel;
	
	private final LoadingPanel loadingPanel = new LoadingPanel();
	

	private IPowerQueryService powerQueryService = NCLocator.getInstance()
			.lookup(IPowerQueryService.class);


	@Override
	public void doAction(ActionEvent e) throws Exception {
		//为了数据量大的时候加载较慢， 显示加载界面。
		getDetailTreePanel().remove(getDetailTreePanel().getBillListPanel());
		getDetailTreePanel().add(loadingPanel);
		getDetailTreePanel().updateUI();
		
		initFuncTreeModelBySelectedResp();	
	}
	
	private void initFuncTreeModelBySelectedResp() {
		LongUITask longTask = new LongUITask(){
			
			private String pk_power;

			private BusiPowerItem[] busiFuncItems = null;
			
			@Override
			public Object construct() throws Exception {
				Object obj = getAppModel().getSelectedData();
				if(obj!=null && obj instanceof DmPower){
					DmPower vo =(DmPower)obj;
					pk_power = vo.getPrimaryKey();
					busiFuncItems = powerQueryService.queryBusiFuncItemsByResp(pk_power);
					
				}
				return null;
			}
			
			@Override
			public void finished() {
				getDetailTreeModel().initModel(busiFuncItems);
				getDetailTreeModel().setWhichResponsibility(pk_power); 
				
				DmPower currentSelectedVO = (DmPower)getAppModel().getSelectedData();
				if(currentSelectedVO != null){
					String currentSelectedPK = currentSelectedVO.getPrimaryKey();
					//如果Task执行的任务是当前选中的职责的任务， 则将loadingpanel换成树表显示数据
					if(StringUtils.isNotEmpty(pk_power) && pk_power.equals(currentSelectedPK)){
						getDetailTreePanel().remove(loadingPanel);
						getDetailTreePanel().add(getDetailTreePanel().getBillListPanel());
						getDetailTreePanel().updateUI();
					}	
				}				
			}			
		};
		getAppModel().getContext().getExecutor().execute(longTask);
	}
	
	


	@Override
	protected boolean isActionEnable() {
		return getAppModel().getUiState() == UIState.NOT_EDIT && getAppModel().getSelectedData() != null;
	}

	public BillManageModel getAppModel() {
		return appModel;
	}


	public void setAppModel(BillManageModel appModel) {
		this.appModel = appModel;
		this.appModel.addAppEventListener(this);
	}


	public DetailTreeModel getDetailTreeModel() {
		return detailTreeModel;
	}


	public void setDetailTreeModel(DetailTreeModel detailTreeModel) {
		this.detailTreeModel = detailTreeModel;
	}


	public DetailTreePanel getDetailTreePanel() {
		return detailTreePanel;
	}


	public void setDetailTreePanel(DetailTreePanel detailTreePanel) {
		this.detailTreePanel = detailTreePanel;
	}


	public LoadingPanel getLoadingPanel() {
		return loadingPanel;
	}
	
	
	
	
	
	

}
