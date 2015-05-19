package nc.ui.docmng.doctype.ace.model;

import nc.vo.bd.meta.IBDObject;
import nc.vo.bd.meta.IBDObjectAdapterFactory;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.uap.rbac.BusiFuncItemVO;

public class BusiPowerItemBDObjectAdaptorFactory implements IBDObjectAdapterFactory {

	@Override
	public IBDObject createBDObject(Object obj){
		if(obj!=null && obj instanceof BusiPowerItem){
			BusiPowerItem vo = (BusiPowerItem)obj;
			return new BDObjectForBusiItem(vo); 
		}else
			return null;
	}
	
	private class BDObjectForBusiItem implements IBDObject{
		private BusiPowerItem vo;
		public BDObjectForBusiItem(BusiPowerItem vo){
			this.vo = vo;
		}
		public Object getId(){
			return vo.getPk_busipower();
		}
		public Object getPId(){
			return vo.getPid();
		}
		public Object getPk_org(){
			return null;
		}
		public Object getCode(){
			return vo.getCode();
		}
		public Object getName(){
			return vo.getName();
		}
		public Object getPk_group(){
			return null;
		}
	}

}
