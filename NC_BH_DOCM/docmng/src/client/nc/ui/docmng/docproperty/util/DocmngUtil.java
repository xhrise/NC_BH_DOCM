package nc.ui.docmng.docproperty.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.uif.pub.exception.UifException;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.docmng.docproperty.DocProperty;
import nc.vo.docmng.doctype.DocType;

public class DocmngUtil {
	
	public static String path = "binhai/doc/";

	public static Map<String, List<AggDocProperty>> findAllDocProperty(
			Object[] objs) {
		Map<String, List<AggDocProperty>> map = new HashMap<String, List<AggDocProperty>>();
		if(objs==null)
			return map;
		for (Object obj : objs) {
			AggDocProperty aggVO = (AggDocProperty) obj;
			DocProperty parent = aggVO.getParentVO();
			String key = parent.getPk_doctype();
			if (!map.containsKey(key)) {
				List<AggDocProperty> list = new ArrayList<AggDocProperty>();
				list.add(aggVO);
				map.put(key, list);
			} else {
				map.get(key).add(aggVO);
			}
		}
		return map;
	}

	public static void filterTree(Map<String, List<AggDocProperty>> map,
			HierachicalDataAppModel treeModel) throws Exception {
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel
				.getTree().getRoot();
		Enumeration e = root.preorderEnumeration();
		e.nextElement();
		while (e.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
					.nextElement();
			DocType docType = (DocType) node.getUserObject();
			String pk_doctype = docType.getPk_doctype();
			if (map.containsKey(pk_doctype)) {
				DocType dt = (DocType) HYPubBO_Client.queryByPrimaryKey(
						DocType.class, docType.getPk_doctype());
				dt.setName(dt.getName() + " (" + map.get(pk_doctype).size()
						+ ")");
				node.setUserObject(dt);
				treeModel.getTree().nodeChanged(node);
			} else {
				DocType dt = (DocType) HYPubBO_Client.queryByPrimaryKey(
						DocType.class, docType.getPk_doctype());
				dt.setName(dt.getName() + " (0)");
				node.setUserObject(dt);
				treeModel.getTree().nodeChanged(node);
			}
		}
	}

}
