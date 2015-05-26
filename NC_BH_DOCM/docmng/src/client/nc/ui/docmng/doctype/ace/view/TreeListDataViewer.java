package nc.ui.docmng.doctype.ace.view;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import nc.ui.trade.component.TreeListDataViewerWithFilter;
import nc.ui.uap.rbac.TreeValueObject;
import nc.vo.bd.access.tree.ITreeCreateStrategy;
import nc.vo.uap.rbac.BusiFuncItemVO;

public class TreeListDataViewer  extends TreeListDataViewerWithFilter{

	public TreeListDataViewer(ITreeCreateStrategy treeCreateStrategy,
			TreeCellRenderer renderer) {
		super(treeCreateStrategy, renderer);
	}
	public TreeListDataViewer(DefaultTreeModel treeModel, TreeCellRenderer renderer) {
		super(treeModel, renderer);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Object[] getSelectedValues() {
		TreePath[] selectedPaths = getTree().getSelectionPaths();
		ArrayList<Object> objectList = new ArrayList<Object>();
		int iLen = ArrayUtils.getLength(selectedPaths);
		for (int i = 0; i < iLen; i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectedPaths[i].getLastPathComponent();
			TreeValueObject currentTreeValueObj = null;
			// 叶子节点则返回它的所有上级
			if (node.isLeaf()) {
				if (node.getUserObject() instanceof String) {
					continue;
				}
				// 叶子节点
				currentTreeValueObj = new TreeValueObject();
				currentTreeValueObj.setRemove(true);
				currentTreeValueObj.setTreeNode(node);
				objectList.add(TreeValueObject.getFunctionTreeValueObj(
						currentTreeValueObj.getTreeNode(), currentTreeValueObj
								.isRemove()));
				// 依次加入叶子节点的所有上级
				while (!((DefaultMutableTreeNode) currentTreeValueObj
						.getTreeNode().getParent()).isRoot()) {
					currentTreeValueObj = resetCurrentTreeValueObj(currentTreeValueObj);
					objectList.add(currentTreeValueObj);
				}
			}
			// 非叶子节点则返回所选下属及它的所有上级
			else {
				// 所选下属及当前节点
				Enumeration preorderTreeEnum = node.preorderEnumeration();
				while (preorderTreeEnum.hasMoreElements()) {
					DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) preorderTreeEnum
							.nextElement();
					objectList.add(childNode.getUserObject());
				}
				if (!node.isRoot()) {
					// 它的所有上级
					currentTreeValueObj = new TreeValueObject();
					currentTreeValueObj.setRemove(true);
					currentTreeValueObj.setTreeNode(node);
					// 依次加入叶子节点的所有上级
					while (!((DefaultMutableTreeNode) currentTreeValueObj
							.getTreeNode().getParent()).isRoot()) {
						currentTreeValueObj = resetCurrentTreeValueObj(currentTreeValueObj);
						objectList.add(currentTreeValueObj);
					}
				}
			}
		}
		return objectList.toArray();
	}

	private TreeValueObject resetCurrentTreeValueObj(
			TreeValueObject currentTreeValueObj) {
		boolean isOldCurrentRemove = currentTreeValueObj.isRemove();
		boolean isNewCurrentRemove = true;
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) currentTreeValueObj
				.getTreeNode().getParent();
		if (!isOldCurrentRemove) {
			isNewCurrentRemove = false;
		} else {
			if (parentNode.getChildCount() == 1) {
				Object parentNodeObj = parentNode.getUserObject();
				//如果不是虚菜单. 是功能节点或者页签
				if(parentNodeObj instanceof BusiFuncItemVO){
					BusiFuncItemVO funcItem = (BusiFuncItemVO)parentNodeObj;
					if(StringUtils.isNotEmpty(funcItem.getBusi_pk()))
						isNewCurrentRemove = false;					
				}else
					isNewCurrentRemove = true;
			} else {
				isNewCurrentRemove = false;
			}
		}
		return TreeValueObject.getFunctionTreeValueObj(parentNode,
				isNewCurrentRemove);
	}
	

}
