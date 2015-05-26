package nc.ui.docmng.doctype.ace.view;

import javax.swing.tree.DefaultMutableTreeNode;

import nc.vo.bd.access.tree.AbastractTreeCreateStrategy;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.uap.rbac.BusiFuncItemVO;

public class BusiItemTreeCreateStrategy  extends AbastractTreeCreateStrategy {

	
	@Override
	public DefaultMutableTreeNode createTreeNode(Object obj) {
		BusiPowerItem vo = (BusiPowerItem) obj;
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(vo);
		return node;
	}
	
	@Override
	public DefaultMutableTreeNode getRootNode() {
		return new DefaultMutableTreeNode(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("10120UPQ","010120UPQ0003")/*@res "������Դ��"*/);
	}

	/**
	 * �����Pk��������ʵ�ִ˷��������ش˽ڵ�IDֵ
	 * @param obj �˽ڵ�ֵ
	 * @return
	 */
	public Object getNodeId(Object obj) {
		BusiPowerItem vo = (BusiPowerItem) obj;
		return vo.getPk_busipower();
	}

	/**
	 * �����PK��������ʵ�ִ˷���,���ش˽ڵ�ĸ��ڵ�PKֵ
	 * @param obj �˽ڵ�ֵ
	 * @return
	 */
	public Object getParentNodeId(Object obj) {
		BusiPowerItem vo = (BusiPowerItem) obj;
		return vo.getPid();
	}
	
	
	@Override
	public boolean isCodeTree() {
		// TODO �Զ����ɵķ������
		return false;
	}

}
