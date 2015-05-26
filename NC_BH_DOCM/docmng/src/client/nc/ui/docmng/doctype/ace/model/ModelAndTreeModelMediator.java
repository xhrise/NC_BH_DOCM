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

	// Ϊ��ֹ�����һ������һ����ť��������selection_changed�¼�����
	// ֮������Ϊ-1,�����ڲ�ѯ�������ݵ�ʱ��getModel().getSelectedRow()=-1. ���ù��˵�
	private int respModelCurrentSelecteIndex = -1;

	@Override
	public void handleEvent(AppEvent event) {
		if (event instanceof UIStateChangeEvent) {
			if (((UIStateChangeEvent) event).getNewState() == UIState.ADD)
				respModelCurrentSelecteIndex = -1;
		}
		if (event.getSource() == getModel()) {
			if (AppEventConst.MODEL_INITIALIZED.equals(event.getType())) {
				respModelCurrentSelecteIndex = -1; // ��Model����init�󣬽���ǰѡ���б�־������Ϊ-1
			}

			if (AppEventConst.SELECTION_CHANGED.equals(event.getType())) {
				if (getModel().getSelectedRow() != respModelCurrentSelecteIndex) {
					// Ϊ�����������ʱ����ؽ����� ��ʾ���ؽ��档
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
				//�ڿ��ٵ����һ������һ��������� ��ͻȻ���������
				//ǰ������˹�����Model�������߳���initModel����ɲ�һ�µ����
				//���ԣ�����ǰrespAppModel��UIStateΪ����ʱ�Ͳ�initModel��
				if(getModel().getUiState() != UIState.ADD){
					getDetailTreeModel().initModel(busiFuncItems);
					getDetailTreeModel().setWhichResponsibility(pk_power); 
				}
				
				DmPower currentSelectedVO = (DmPower)getModel().getSelectedData();
				if(currentSelectedVO != null){
					String currentSelectedPK = currentSelectedVO.getPrimaryKey();
					//���Taskִ�е������ǵ�ǰѡ�е�ְ������� ��loadingpanel����������ʾ����
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
