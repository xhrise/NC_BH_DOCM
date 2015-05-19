package nc.ui.docmng.doctype.ace.view;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import nc.ui.uif2.AppEvent;
import nc.ui.uif2.model.AppEventConst;

public class TreePanel extends nc.ui.uif2.components.TreePanel {


	private void expandAll(JTree tree, TreePath parent, boolean expand) {
		// Traverse children
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path, expand);
			}
		}
		if (expand) { 
            tree.expandPath(parent); 
        } else { 
            tree.collapsePath(parent);
        }
	}

	@Override
	public void handleEvent(AppEvent event) {
		// TODO Auto-generated method stub
		super.handleEvent(event);		
		if(event.getType().equals(AppEventConst.MODEL_INITIALIZED))
		{
			JTree tree = this.getTree();
			TreeNode root = (TreeNode) tree.getModel().getRoot();
			expandAll(tree,new TreePath(root),true);
		}

	}


}
