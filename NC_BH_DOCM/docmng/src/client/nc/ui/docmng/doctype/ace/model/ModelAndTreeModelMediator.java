package nc.ui.docmng.doctype.ace.model;

import org.apache.commons.lang.StringUtils;

import nc.bs.framework.common.NCLocator;
import nc.itf.docpower.IPowerQueryService;
import nc.ui.docmng.doctype.ace.view.DetailTreePanel;
import nc.ui.uap.rbac.resp.model.BusiFuncItemClientHelper;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.AppEventListener;
import nc.ui.uif2.LoadingPanel;
import nc.ui.uif2.LongUITask;
import nc.ui.uif2.UIState;
import nc.ui.uif2.UIStateChangeEvent;
import nc.ui.uif2.model.AppEventConst;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.uap.rbac.BusiFuncItemSmartVO;
import nc.vo.uap.rbac.BusiFuncItemVO;
import nc.vo.uap.rbac.ResponsibilityVO;

public class ModelAndTreeModelMediator implements AppEventListener {

	private BillManageModel model;

	private DetailTreeModel detailTreeModel;

	private IPowerQueryService powerQueryService = NCLocator.getInstance()
			.lookup(IPowerQueryService.class);

	private DetailTreePanel detailTreePanel;

	private final LoadingPanel loadingPanel = new LoadingPanel();

	// 为防止点击上一条和下一条按钮触发两次selection_changed事件而设
	// 之所以置为-1,是由于查询不到数据的时候getModel().getSelectedRow()=-1. 正好过滤掉
	private int respModelCurrentSelecteIndex = -1;

	@Override
	public void handleEvent(AppEvent event) {
		if (event instanceof UIStateChangeEvent) {
			if (((UIStateChangeEvent) event).getNewState() == UIState.ADD)
				respModelCurrentSelecteIndex = -1;
		}
		if (event.getSource() == getModel()) {
			if (AppEventConst.MODEL_INITIALIZED.equals(event.getType())) {
				respModelCurrentSelecteIndex = -1; // 当Model重新init后，将当前选中行标志重新置为-1
			}

			if (AppEventConst.SELECTION_CHANGED.equals(event.getType())) {
				if (getModel().getSelectedRow() != respModelCurrentSelecteIndex) {
					// 为了数据量大的时候加载较慢， 显示加载界面。
					getDetailTreePanel().remove(
							getDetailTreePanel().getBillListPanel());
					getDetailTreePanel().add(loadingPanel);
					getDetailTreePanel().updateUI();

					initFuncTreeModelBySelectedResp();
					respModelCurrentSelecteIndex = getModel()
							.getSelectedRow();
				}
			}
		}

	}
	
	
	private void initFuncTreeModelBySelectedResp() {
		LongUITask longTask = new LongUITask(){
			
			private String pk_power;

			private BusiPowerItem[] busiFuncItems = null;
			
			@Override
			public Object construct() throws Exception {
				Object obj = getModel().getSelectedData();
				if(obj!=null && obj instanceof DmPower){
					DmPower vo =(DmPower)obj;
					pk_power = vo.getPrimaryKey();
					busiFuncItems = powerQueryService.queryBusiFuncItemsByResp(pk_power);
				}
				return null;
			}
			
			@Override
			public void finished() {
				//在快速点击上一条和下一条的情况下 ，突然点击新增。
				//前面情况了功能树Model，后面线程又initModel而造成不一致的情况
				//所以，若当前respAppModel的UIState为新增时就不initModel了
				if(getModel().getUiState() != UIState.ADD){
					getDetailTreeModel().initModel(busiFuncItems);
					getDetailTreeModel().setWhichResponsibility(pk_power); 
				}
				
				DmPower currentSelectedVO = (DmPower)getModel().getSelectedData();
				if(currentSelectedVO != null){
					String currentSelectedPK = currentSelectedVO.getPrimaryKey();
					//如果Task执行的任务是当前选中的职责的任务， 则将loadingpanel换成树表显示数据
					if(StringUtils.isNotEmpty(pk_power) && pk_power.equals(currentSelectedPK)){
						treeViewPaneDisplay();
					}	
				}else{
					treeViewPaneDisplay();
				}
			}

			private void treeViewPaneDisplay() {
				getDetailTreePanel().remove(loadingPanel);
				getDetailTreePanel().add(getDetailTreePanel().getBillListPanel());
				getDetailTreePanel().updateUI();
			}			
		};
		getModel().getContext().getExecutor().execute(longTask);
	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
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

	public int getRespModelCurrentSelecteIndex() {
		return respModelCurrentSelecteIndex;
	}

	public void setRespModelCurrentSelecteIndex(int respModelCurrentSelecteIndex) {
		this.respModelCurrentSelecteIndex = respModelCurrentSelecteIndex;
	}

	public LoadingPanel getLoadingPanel() {
		return loadingPanel;
	}

}
