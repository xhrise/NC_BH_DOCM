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
		return new DefaultMutableTreeNode(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("10120UPQ","010120UPQ0003")/*@res "功能资源树"*/);
	}

	/**
	 * 如果是Pk树，则需实现此方法，返回此节点ID值
	 * @param obj 此节点值
	 * @return
	 */
	public Object getNodeId(Object obj) {
		BusiPowerItem vo = (BusiPowerItem) obj;
		return vo.getPk_busipower();
	}

	/**
	 * 如果是PK树，则需实现此方法,返回此节点的父节点PK值
	 * @param obj 此节点值
	 * @return
	 */
	public Object getParentNodeId(Object obj) {
		BusiPowerItem vo = (BusiPowerItem) obj;
		return vo.getPid();
	}
	
	
	@Override
	public boolean isCodeTree() {
		// TODO 自动生成的方法存根
		return false;
	}

}
