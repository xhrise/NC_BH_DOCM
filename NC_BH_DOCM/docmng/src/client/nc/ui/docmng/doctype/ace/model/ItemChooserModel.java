package nc.ui.docmng.doctype.ace.model;

import nc.ui.trade.component.DefaultItemChooserModel;
import nc.ui.uap.rbac.TreeValueObject;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.uap.rbac.BusiFuncItemVO;

public class ItemChooserModel extends DefaultItemChooserModel{

	public ItemChooserModel(Object[] leftData, Object[] rightData) {
		super(leftData, rightData);
		// TODO �Զ����ɵĹ��캯�����
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
				//�����ɾ��
				left.remove(vo);
				
				//�����������û��ɾ���ɹ����ұ�ֱ�����ӡ� 
				//--��Ϊ���ɾ��ʧ��ֻ��һ��������Ǿֲ������˶�����Ϊ�˱�֤�ֲ�ˢ�������ز�����ˢ����
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
