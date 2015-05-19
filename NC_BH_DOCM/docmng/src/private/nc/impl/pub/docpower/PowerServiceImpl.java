package nc.impl.pub.docpower;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nc.bs.bd.baseservice.BaseService;
import nc.bs.businessevent.IEventType;
import nc.bs.dao.BaseDAO;
import nc.itf.docpower.IPowerService;
import nc.vo.docmng.dmpower.DmPower;
import nc.vo.pub.BusinessException;
import nc.vo.trade.sqlutil.IInSqlBatchCallBack;
import nc.vo.trade.sqlutil.InSqlBatchCaller;
import nc.vo.trade.voutils.VOUtil;
import nc.vo.uap.rbac.ResponsibilityVO;

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
								.executeUpdate("delete from docmng_powerdetail where pk_power in "
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

}
