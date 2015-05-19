package nc.vo.docmng.docproperty;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggDocPropertyMeta extends AbstractBillMeta {
  public AggDocPropertyMeta() {
    this.init();
  }
  private void init() {
    this.setParent(nc.vo.docmng.docproperty.DocProperty.class);
  }
}