package nc.ui.docmng.doctype.ace.model;

import nc.ui.trade.component.DefaultItemChooserModel;
import nc.ui.uap.rbac.TreeValueObject;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.uap.rbac.BusiFuncItemVO;

public class ItemChooserModel extends DefaultItemChooserModel{

	public ItemChooserModel(Object[] leftData, Object[] rightData) {
		super(leftData, rightData);
		// TODO 自动生成的构造函数存根
	}
	
	
	@Override
	public void leftToRight(Object[] toBeMoved) {
		if (toBeMoved == null)
			return;
		for (int i = 0; i < toBeMoved.length; i++) {
			Object obj = toBeMoved[i];
			BusiPowerItem vo = null;
			boolean isRemove = true;
			if(obj instanceof String)
				continue;
			if(obj instanceof TreeValueObject){
				isRemove = ((TreeValueObject)obj).isRemove();
				vo = (BusiPowerItem)((TreeValueObject)obj).getTreeNode().getUserObject();
			}
			if(obj instanceof BusiPowerItem){
				vo = (BusiPowerItem)obj;
			}
			if (isRemove) {
				//从左边删除
				left.remove(vo);
				
				//不关心左边有没有删除成功，右边直接增加。 
				//--因为左边删除失败只有一种情况就是局部新增了东西，为了保证局部刷新特性特不重新刷新树
				if (!right.contains(vo) && vo != null) {
					right.add(vo);
				}
				
			} else {
				if (!right.contains(vo) && vo != null) {
					right.add(vo);
				}
			}
		}
		setChanged();
		notifyObservers();
	}

	@Override
	public void rightToLeft(Object[] toBeMoved) {
		if (toBeMoved == null)
			return;
		for (int i = 0; i < toBeMoved.length; i++) {
			Object obj = toBeMoved[i];
			BusiPowerItem vo = null;
			boolean isRemove = true;
			if(obj instanceof String)
				continue;
			if(obj instanceof TreeValueObject){
				isRemove = ((TreeValueObject)obj).isRemove();
				vo = (BusiPowerItem)((TreeValueObject)obj).getTreeNode().getUserObject();
			}
			if(obj instanceof BusiPowerItem){
				vo = (BusiPowerItem)obj;
			}
			if (isRemove) {
				if (right.remove(vo)) {
					if (!left.contains(vo) && vo != null) {
						left.add(vo);
					}
				}
			} else {
				if (!left.contains(vo) && vo != null) {
					left.add(vo);
				}
			}
		}
		setChanged();
		notifyObservers();
	}	

}
