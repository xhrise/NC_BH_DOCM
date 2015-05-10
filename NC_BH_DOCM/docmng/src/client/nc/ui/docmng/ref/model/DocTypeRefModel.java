package nc.ui.docmng.ref.model;

import nc.itf.bd.pub.IBDResourceIDConst;
import nc.ui.bd.ref.AbstractRefTreeModel;
import nc.ui.bd.ref.IRefDocEdit;
import nc.ui.bd.ref.IRefMaintenanceHandler;
import nc.vo.bd.material.marbasclass.MarBasClassVO;

public class DocTypeRefModel extends AbstractRefTreeModel {

	@Override
	public void reset() {
		this.setRootName("文档分类");
	    this.setFieldCode(new String[] {
	      "code", "name"
	    });
	    this.setFieldName(new String[] {
	      "编码",
	      "名称"});
	    this.setHiddenFieldCode(new String[] {
	      "pk_doctype","pid"
	    });
	    this.setPkFieldCode("pk_doctype");
	    this.setFatherField("pid");
	    this.setChildField("pk_doctype");
	    this.setRefCodeField("code");
	    this.setRefNameField("name");
	    this.setTableName("docmng_doctype");


	    // 维护
	    this.setRefMaintenanceHandler(new IRefMaintenanceHandler() {

	      @Override
	      public String[] getFucCodes() {
	        return new String[] {
	          "DM0101", "DM0101"
	        };
	      }

	      @Override
	      public IRefDocEdit getRefDocEdit() {
	        return null;
	      }
	    });

	    this.resetFieldName();
	}

}
