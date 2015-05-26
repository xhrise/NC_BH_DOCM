package nc.impl.pub.docpower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nc.bs.bd.baseservice.BaseService;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.docmng.dmpowerdetail.DmPowerDetail;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.uap.rbac.RespFuncVO;

public class PowerRefService extends BaseService<DmPowerDetail> {

	public PowerRefService() {
		super("6fd9bd1d-448a-4b9d-ab6b-d10e0ee53e72");
		// TODO 自动生成的构造函数存根
	}

	public void insertItems(String pk_power, BusiPowerItem[] addFuncItems) throws BusinessException {
		DmPowerDetail[] respfuncvos = ConvertItemVOToDetailVO(pk_power, addFuncItems);
		insertVO(respfuncvos);// TODO 自动生成的方法存根
		
	}

	public void deleteItems(String pk_power, BusiPowerItem[] delFuncItems) throws BusinessException {
		DmPowerDetail[] respfuncvos = ConvertItemVOToDetailVO(pk_power, delFuncItems);
		deleteVO(respfuncvos);
		
	}
	
	private DmPowerDetail[] ConvertItemVOToDetailVO(String pk_power, Object[] busiItemVOs) {
		//确保一个busiPK 只保存一份RefpFuncVO
		HashMap<String,String> busiPKMap = new HashMap<String,String>();

		List<DmPowerDetail> respfuncList = new ArrayList<DmPowerDetail>();
		for(Object busiItem: busiItemVOs){
			BusiPowerItem itemVO = (BusiPowerItem)busiItem;
			String busi_pk = itemVO.getPk_busipower();

			if(busiPKMap.get(busi_pk)==null)
				busiPKMap.put(busi_pk, busi_pk);
			else continue;

			String pk_detail = itemVO.getPk_detail();
			if(StringUtil.isEmptyWithTrim(busi_pk))
				continue;
			DmPowerDetail vo = new DmPowerDetail();
			vo.setPk_power(pk_power);
			vo.setPk_doctype(busi_pk);
			vo.setPk_detail(pk_detail);
			//加上集团纬度
			String pk_group = InvocationInfoProxy.getInstance().getGroupId();
			vo.setPk_group(pk_group);
			
			vo.setTs(itemVO.getTs());
			respfuncList.add(vo);
		}
		DmPowerDetail[] respfuncvos = respfuncList.toArray(new DmPowerDetail[respfuncList.size()]);
		return respfuncvos;
	}

}
