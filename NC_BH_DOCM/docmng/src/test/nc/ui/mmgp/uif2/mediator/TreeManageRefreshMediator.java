package nc.ui.mmgp.uif2.mediator;


import nc.ui.mmgp.uif2.model.MMGPTreeMangeModelDataManager;
import nc.ui.uif2.model.AbstractTreeManageQueryAndRefreshMrg;
import nc.vo.pub.SuperVO;

public class TreeManageRefreshMediator extends AbstractTreeManageQueryAndRefreshMrg {

	@Override
	protected void doLeftTreeModelSelectedChanged() {
		String pk_node = null;
		SuperVO obj = (SuperVO) getLeftTreeModel().getSelectedData();
		if (obj != null) {
			pk_node = obj.getPrimaryKey();
		}
		((MMGPTreeMangeModelDataManager)getRightManageDataManager()).initManageModelBySelectNode(pk_node);

	}

}

