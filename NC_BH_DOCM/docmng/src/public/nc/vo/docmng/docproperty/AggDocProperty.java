package nc.vo.docmng.docproperty;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;

@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.docmng.docproperty.DocProperty")
public class AggDocProperty extends AbstractBill {

  @Override
  public IBillMeta getMetaData() {
    IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggDocPropertyMeta.class);
    return billMeta;
  }

  @Override
  public DocProperty getParentVO() {
    return (DocProperty) this.getParent();
  }
}