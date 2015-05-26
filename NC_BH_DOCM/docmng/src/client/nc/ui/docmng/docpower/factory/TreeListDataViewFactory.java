package nc.ui.docmng.docpower.factory;

import nc.ui.docmng.doctype.ace.view.ItemTreeCellRender;
import nc.ui.docmng.doctype.ace.view.TreeListDataViewer;
import nc.ui.trade.component.IListDataViewer;
import nc.ui.trade.component.IListDataViewerFactory;
import nc.ui.trade.component.TreeListDataViewerWithFilter;
import nc.ui.uap.rbac.auth.functree.FuncItemTreeCellRender;
import nc.ui.uap.rbac.auth.functree.FuncItemTreeCreateStrategy;
import nc.ui.uap.rbac.auth.functree.FuncTreeListDataViewer;

public class TreeListDataViewFactory  implements IListDataViewerFactory{

	@Override
	public IListDataViewer createIListDataViwer() {
		TreeListDataViewer dataViewer = new TreeListDataViewer(new nc.ui.docmng.doctype.ace.view.BusiItemTreeCreateStrategy(), new ItemTreeCellRender());
		
		//�˴�����Ϊ�����ˣ�ӦΪ����λ�� ��Ϊ��Ҫ�����Ľڵ�,ҳǩ,ҵ����Ϣ
		dataViewer.setSearchMode(TreeListDataViewerWithFilter.SEARCHMODE_LOCATION);
		
		return dataViewer;
	}

}
