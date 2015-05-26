package nc.impl.pub.docpower;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

import nc.bs.bd.baseservice.ArrayClassConvertUtil;
import nc.bs.bd.baseservice.BaseService;
import nc.bs.businessevent.IEventType;
import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.itf.docpower.IPowerService;
import nc.vo.bd.meta.BatchOperateVO;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.trade.sqlutil.IInSqlBatchCallBack;
import nc.vo.trade.sqlutil.InSqlBatchCaller;

public class PowerServiceImpl extends BaseService<DmPower> implements IPowerService {
	
	public PowerServiceImpl(){
		super("02082aab-26e5-4292-ba94-d8916bcc3df1");
	}

	@Override
	public void deletePower(DmPower[] vos) throws BusinessException {
		if (vos == null)
			return;
		// 删除该职责关联的功能
//		RespFuncManageService respfuncService = new RespFuncManageService();
//		List<String> respPKList = VOUtil.extractFieldValues(vos,
//				ResponsibilityVO.PK_RESPONSIBILITY, null);
//		respfuncService.deleteRespFuncByRespPKs(respPKList
//				.toArray(new String[0]));
		if (vos != null) {
			Set<String> pks = new HashSet<String>();
			for (DmPower v : vos) {
				if (v != null) {
					if (v.getPk_power() != null) {
						pks.add(v.getPk_power());
					}
				}
			}
			InSqlBatchCaller caller = new InSqlBatchCaller(pks
					.toArray(new String[0]));
			try {
				caller.execute(new IInSqlBatchCallBack() {
					@Override
					public Object doWithInSql(String inSql)
							throws BusinessException, SQLException {
						return new BaseDAO()
								.executeUpdate("delete from docmng_dmpowerdetail where pk_power in "
										+ inSql);

					}
				});
			} catch (SQLException e) {
				throw new BusinessException(e);
			}
		}

		deleteVO(vos);
		
	}

	@Override
	public DmPower insertPower(DmPower vo) throws BusinessException {
		if (vo == null)
			return null;
		DmPower newResp = insertVO(vo)[0];
		return newResp;
	}

	@Override
	public DmPower updatePower(DmPower vo) throws BusinessException {
		if (vo == null)
			return null;
		return updateVO(vo)[0];
	}
	
	
	
	@Override
	public BusiPowerItem[] batchAssignedAndRemovedItems(
			String pk_power, BatchOperateVO vo)
			throws BusinessException {
		if (vo == null)
			return null;
		if (StringUtil.isEmptyWithTrim(pk_power))
			throw new BusinessException(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("rbac","0RBAC0136")/*@res "职责不能为空！"*/);
		Object[] addVOs = vo.getAddObjs();
		Object[] deleteVOs = vo.getDelObjs();
		if (ArrayUtils.isEmpty(addVOs) && ArrayUtils.isEmpty(deleteVOs))
			return null;
		BusiPowerItem[] addFuncItems = ArrayClassConvertUtil.convert(addVOs,
				BusiPowerItem.class);
		BusiPowerItem[] delFuncItems = ArrayClassConvertUtil.convert(
				deleteVOs, BusiPowerItem.class);

		PowerRefService respfuncService = new PowerRefService();
		if (!ArrayUtils.isEmpty(addVOs)) {
			respfuncService
					.insertItems(pk_power, addFuncItems);
		}
		if (!ArrayUtils.isEmpty(deleteVOs)) {
			respfuncService
					.deleteItems(pk_power, delFuncItems);
		}

		// 查出此职责的最新功能资源项
		PowerQueryServiceImpl queryService = new PowerQueryServiceImpl();
		BusiPowerItem[] lastFuncItemsOfResp = queryService.queryBusiFuncItemsByResp(pk_power);
		
		return lastFuncItemsOfResp;
	}
	
	
	
	@Override
	public BusiPowerItem[] batchAssignedAndRemovedItems(String pk_power, BusiPowerItem[] toAdds,BusiPowerItem[] toRemoves) throws BusinessException {
		
		if (StringUtil.isEmptyWithTrim(pk_power))
			throw new BusinessException("权限不能为空");
		
		PowerRefService respfuncService = new PowerRefService();
		
		if(!ArrayUtils.isEmpty(toAdds))
			respfuncService.insertItems(pk_power, toAdds);
		
		if(!ArrayUtils.isEmpty(toRemoves))
			respfuncService.deleteItems(pk_power, toRemoves);
		

		// 查出此职责的最新功能资源项
		PowerQueryServiceImpl queryService = new PowerQueryServiceImpl();
		BusiPowerItem[] lastFuncItemsOfResp = queryService.queryBusiFuncItemsByResp(pk_power);
		
		return lastFuncItemsOfResp;
	}
	

}
