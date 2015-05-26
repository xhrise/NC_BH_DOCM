package nc.ui.docmng.docproperty.dialog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import nc.bs.framework.common.NCLocator;
import nc.itf.docpower.IPowerQueryService;
import nc.itf.uap.rbac.IResponsibilityQueryService;
import nc.ui.docmng.docpower.ace.serviceproxy.PowerModelService;
import nc.ui.docmng.docpower.factory.TreeListDataViewFactory;
import nc.ui.docmng.doctype.ace.model.DetailTreeModel;
import nc.ui.docmng.doctype.ace.model.ItemChooserModel;
import nc.ui.trade.component.AssignDialog;
import nc.ui.trade.component.IListDataViewerFactory;
import nc.ui.trade.component.ListToListPanel;
import nc.ui.uap.rbac.auth.functree.FuncItemChooserModel;
import nc.ui.uap.rbac.auth.functree.FuncTreeListDataViewFactory;
import nc.ui.uap.rbac.resp.model.BusiFuncItemClientHelper;
import nc.ui.uap.rbac.resp.model.RespFuncTreeModel;
import nc.ui.uap.rbac.resp.model.ResponsibilityAppModel;
import nc.ui.uap.rbac.resp.model.ResponsibilityModelService;
import nc.ui.uif2.LoadingPanel;
import nc.ui.uif2.LongUITask;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.bd.meta.BatchOperateVO;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.power.util.BusiItemHelper;
import nc.vo.uap.rbac.BusiFuncItemSmartVO;
import nc.vo.uap.rbac.BusiFuncItemVO;
import nc.vo.uap.rbac.util.BusiFuncItemHelper;
import nc.vo.uap.rbac.util.RbacPubUtil;

public class PowerAssignDialog extends AssignDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8504950166121315677L;
	
	// 可分配的功能权限信息
	private Object[] canAssignfuncPermissionInfo;
	// 已分配的功能权限信息
	private Object[] assignedfuncPermissionInfo;

	private BillManageModel model;
	private DetailTreeModel detailTreeModel;
	private String pk_power;
	
	
	//数据加载完成前的， 等待界面
	private final LoadingPanel panel = new LoadingPanel();
	
	//ListToListPanel  itemChooserModel
	private ItemChooserModel chooserModel;

	public PowerAssignDialog(Container parent) {
		super(parent);
		setTitle(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("10120respadmin","010120respadmin0007")/*@res "功能分配"*/);
		setSize(new Dimension(800, 650));
	}
	
	@Override 
	public void initUI() {
		
		editorPanel.setLayout(new BorderLayout());
		editorPanel.add(panel, BorderLayout.CENTER);
		contentPanel.remove(getM_buttonPane());
		contentPanel.remove(themePanel);
		
		//初始化数据
		initDataWhenInitDialog();
		
	}
	
	
	
	
	
	private void initDataWhenInitDialog() {
		LongUITask task = new LongUITask(){

			private BusiPowerItem[] canAssignFuncPermissionInfo;
			private BusiPowerItem[] assignedFuncPermissionInfo;
			
			@Override
			public Object construct() throws Exception {
//				while(StringUtils.isBlank(getDetailTreeModel().getWhichResponsibility()) 
//						|| !getDetailTreeModel().getWhichResponsibility().equals(pk_power)){
//					Thread.sleep(100);
//				}		
				
				IPowerQueryService powerQueryService = NCLocator.getInstance().lookup(IPowerQueryService.class);
				
				
				canAssignFuncPermissionInfo = powerQueryService.queryAllBusiItemsByGroup(getModel().getContext().getPk_group());
				Object[] assignedFuncPermissionInfoObj = getDetailTreeModel().getAllDatas();
				assignedFuncPermissionInfo = RbacPubUtil.convert(assignedFuncPermissionInfoObj, BusiPowerItem.class);
				
				canAssignFuncPermissionInfo = BusiItemHelper.subtract(canAssignFuncPermissionInfo, assignedFuncPermissionInfo);
								
				return null;
			}

			@Override
			public void finished() {
				
				setCanAssignObjects(canAssignFuncPermissionInfo);
				setCanAssignfuncPermissionInfo(canAssignFuncPermissionInfo);
				setAssignedfuncPermissionInfo(assignedFuncPermissionInfo);
				
				editorPanel.removeAll();
				editorPanel.add(getListToListPanel(), BorderLayout.CENTER);
				editorPanel.updateUI();
				
				contentPanel.add(getM_buttonPane(), BorderLayout.SOUTH);
				
				contentPanel.remove(themePanel);
				contentPanel.updateUI();
				
			}
		};
		
		getModel().getContext().getExecutor().execute(task);
	}
	
	
	protected ListToListPanel getListToListPanel() {
		if (listToListPanel == null) {
			Object[] leftData = getCanAssignfuncPermissionInfo();
			Object[] rightData = getAssignedfuncPermissionInfo();
			chooserModel = new ItemChooserModel(leftData, rightData);
			IListDataViewerFactory listDataViewerFactory_left = new TreeListDataViewFactory();
			IListDataViewerFactory listDataViewerFactory_right = new TreeListDataViewFactory();
			listToListPanel = new ListToListPanel(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("10120UPQ","010120UPQ0001")/*@res "待选功能"*/, leftData, nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("10120UPQ","010120UPQ0002")/*@res "已选功能"*/, rightData, chooserModel, false,
					listDataViewerFactory_left, listDataViewerFactory_right);
			listToListPanel.setShowSettingPane(false);
			listToListPanel.setPreferredSize(new Dimension(620, 500));
			
			listToListPanel.setOpaque(false);
		}
		return listToListPanel;
	}

	public Object[] getCanAssignfuncPermissionInfo() {
		return canAssignfuncPermissionInfo;
	}

	public void setCanAssignfuncPermissionInfo(Object[] canAssignfuncPermissionInfo) {
		this.canAssignfuncPermissionInfo = canAssignfuncPermissionInfo;
	}

	public Object[] getAssignedfuncPermissionInfo() {
		return assignedfuncPermissionInfo;
	}

	public void setAssignedfuncPermissionInfo(Object[] assignedfuncPermissionInfo) {
		this.assignedfuncPermissionInfo = assignedfuncPermissionInfo;
	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
	}

	public DetailTreeModel getDetailTreeModel() {
		return detailTreeModel;
	}

	public void setDetailTreeModel(DetailTreeModel detailTreeModel) {
		this.detailTreeModel = detailTreeModel;
	}

	public String getPk_power() {
		return pk_power;
	}

	public void setPk_power(String pk_power) {
		this.pk_power = pk_power;
	}

	public ItemChooserModel getChooserModel() {
		return chooserModel;
	}

	public void setChooserModel(ItemChooserModel chooserModel) {
		this.chooserModel = chooserModel;
	}

	public LoadingPanel getPanel() {
		return panel;
	}

	@Override
	protected void complete() throws Exception {
		BatchOperateVO batchVO = getAssignedAndRemovedItems();
		BusiPowerItem[] lastBusiFuncItems = ((PowerModelService)getModel().getService()).batchAssignOrRemoveItem(pk_power, batchVO);
		if(ArrayUtils.isEmpty(lastBusiFuncItems))
			getDetailTreeModel().initModel(getLastAssignedDatas());
		else
			getDetailTreeModel().initModel(lastBusiFuncItems);
	}
	
	public Object[] getLastAssignedDatas(){
		return getListToListPanel().getRightData();
	}
	
	
	/**
	 * 获得分配和取消分配的VO数组
	 * @return
	 */
	public BatchOperateVO getAssignedAndRemovedItems(){
		BatchOperateVO batchVO = new BatchOperateVO();
		//当前最新处于被分配状态的功能项
		Object[] assignedData = getListToListPanel().getRightData();
		//原来处于被分配状态的功能项
		Object[] preAssignedData = getAssignedfuncPermissionInfo();
		if(ArrayUtils.isEmpty(preAssignedData) && !ArrayUtils.isEmpty(assignedData))
			batchVO.setAddObjs(assignedData);
		if(!ArrayUtils.isEmpty(preAssignedData) && ArrayUtils.isEmpty(assignedData))
			batchVO.setDelObjs(preAssignedData);
		if(!ArrayUtils.isEmpty(preAssignedData) && !ArrayUtils.isEmpty(assignedData)){
			List<Object> assignedDataList = Arrays.asList(assignedData);
			List<Object> preAssignedDataList = Arrays.asList(preAssignedData);
			HashSet<Object> totalOperateSet = new HashSet<Object>();
			//找出原来没有而被最新分配的功能项
			totalOperateSet.clear();
			totalOperateSet.addAll(assignedDataList);
			totalOperateSet.addAll(preAssignedDataList);
			totalOperateSet.removeAll(preAssignedDataList);
			batchVO.setAddObjs(totalOperateSet.toArray());
			//找出原来有而现在被删除的功能项
			totalOperateSet.clear();
			totalOperateSet.addAll(assignedDataList);
			totalOperateSet.addAll(preAssignedDataList);
			totalOperateSet.removeAll(assignedDataList);
			batchVO.setDelObjs(totalOperateSet.toArray());
		}
		return batchVO;
	}
	
	
	

}
