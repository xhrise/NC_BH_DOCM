package nc.ui.docmng.docpower.modelmanage;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.docpower.IPowerQueryService;
import nc.itf.uap.rbac.IResponsibilityQueryService;
import nc.ui.uap.rbac.resp.model.ResponsibilitycModelDataManager;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.AppEventListener;
import nc.ui.uif2.IExceptionHandler;
import nc.ui.uif2.LongUITask;
import nc.ui.uif2.components.pagination.BillManagePaginationDelegator;
import nc.ui.uif2.components.pagination.IPaginationModelListener;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.ui.uif2.components.pagination.PaginationModel;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.IAppModelDataManagerEx;
import nc.ui.uif2.model.ModelDataDescriptor;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pub.BusinessRuntimeException;

public class PowerModelDataManager implements AppEventListener,
		IAppModelDataManagerEx, IPaginationModelListener {
	
	//刷新-查询条件储存
	private String queryCond;	

	private BillManageModel model;

	private IExceptionHandler exceptionHandler = null;

	// 加入分页逻辑
	private PaginationModel paginationModel = null;
	private BillManagePaginationDelegator paginationDelegator = null;
	
	private IPowerQueryService powerQueryService;

	@Override
	public void handleEvent(AppEvent event) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void initModel() {
		this.getModel().initModel(null);

	}

	@Override
	public void refresh() {
		initModelBySqlWhere(queryCond);

	}

	@Override
	public void initModelBySqlWhere(final String sqlWhere) {
		LongUITask longTask = new LongUITask() {

			private String cond = sqlWhere;
			private String[] respIDs = null;

			@Override
			public Object construct() throws Exception {
				String pk_group = getModel().getContext()
						.getPk_group();
				if (!StringUtil.isEmptyWithTrim(sqlWhere))
					cond = sqlWhere + " and pk_group='" + pk_group + "'";
				else
					cond = " pk_group='" + pk_group + "'";
				PowerModelDataManager.this.queryCond = sqlWhere;
				respIDs = getPowerQueryService()
						.queryPowerPKsByCondition(cond);
				return null;
			}

			@Override
			public void finished() {
				try {
					getPaginationModel().setObjectPks(respIDs);
				} catch (BusinessException e) {
					Logger.error(e.getMessage());
					throw new BusinessRuntimeException(e.getMessage());
				}
			}
		};
		getModel().getContext().getExecutor().execute(longTask);

	}

	@Override
	public void onStructChanged() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void onDataReady() {
		getPaginationDelegator().onDataReady();

	}

	@Override
	public void setShowSealDataFlag(boolean showSealDataFlag) {
		// TODO 自动生成的方法存根

	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	public IExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}

	public void setExceptionHandler(IExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	public PaginationModel getPaginationModel() {
		return paginationModel;
	}

	public void setPaginationModel(PaginationModel paginationModel) {
		this.paginationModel = paginationModel;
		this.paginationModel.addPaginationModelListener(this);		
		this.paginationModel.setPaginationQueryService(new IPaginationQueryService() {
			@Override
			public Object[] queryObjectByPks(String[] pks) throws BusinessException {
				return getPowerQueryService().queryPowerByPKs(pks);
			}
		});
	}

	public BillManagePaginationDelegator getPaginationDelegator() {
		return paginationDelegator;
	}

	public void setPaginationDelegator(
			BillManagePaginationDelegator paginationDelegator) {
		this.paginationDelegator = paginationDelegator;
	}
	
	public IPowerQueryService getPowerQueryService() {
		if(powerQueryService == null)
		{
			powerQueryService = NCLocator.getInstance().lookup(IPowerQueryService.class);
		}
		return this.powerQueryService;
	}

}
