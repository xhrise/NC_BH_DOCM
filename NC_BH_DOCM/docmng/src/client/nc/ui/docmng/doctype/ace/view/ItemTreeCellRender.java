package nc.ui.docmng.doctype.ace.view;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import nc.uitheme.ui.ThemeResourceCenter;
import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.uap.rbac.BusiFuncItemVO;
import nc.vo.uap.rbac.constant.IRespFunctionCont;

public class ItemTreeCellRender  extends DefaultTreeCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private  Icon inexecfuncIcon_close = ThemeResourceCenter.getInstance().getImage("themeres/control/tree/folder.png");
	private  Icon inexecfuncIcon_open = ThemeResourceCenter.getInstance().getImage("themeres/control/tree/folder_open.png");
	
	
	public ItemTreeCellRender(){
		super();
	}
	
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		
		String   stringValue = tree.convertValueToText(value, sel, expanded, leaf, row, hasFocus);
		this.hasFocus = hasFocus;
		setText(stringValue);

		if(sel) 
		    setForeground(getTextSelectionColor());
		else
		    setForeground(getTextNonSelectionColor());
		if(value != null && value instanceof DefaultMutableTreeNode)
		{
			Object userObj = ((DefaultMutableTreeNode)value).getUserObject();
			if(userObj instanceof String)
			{
				if(expanded)
					innerSetIcon(tree, inexecfuncIcon_open);
				else
					innerSetIcon(tree, inexecfuncIcon_close);
			}
			if(userObj instanceof BusiPowerItem)
			{
				if(expanded)
					innerSetIcon(tree, inexecfuncIcon_open);
				else
					innerSetIcon(tree, inexecfuncIcon_close);
			}			
		}
		
	    setComponentOrientation(tree.getComponentOrientation());
	    
		selected = sel;

		return this;
	}
	
	private void innerSetIcon(JTree tree, Icon icon)
	{
		if(!tree.isEnabled())
			setDisabledIcon(icon);
		else
			setIcon(icon);
	}

}
