package nc.ui.mmgp.uif2.meta;

import nc.vo.bd.meta.BDObjectAdpaterFactory;
import nc.vo.bd.meta.IBDObject;
import nc.vo.pub.AggregatedValueObject;
/**
 * ��չ��uap��������aggVO��֧��
 * 
 * @author wangweiu
 *
 */
public class MMGPCommonVOMetaBDObjectAdapterFactory extends BDObjectAdpaterFactory {

	@Override
	public IBDObject createBDObject(Object obj) {
		if (obj == null || obj instanceof String) {
			return null;
		}

		if (obj instanceof AggregatedValueObject) {
			AggregatedValueObject avo = (AggregatedValueObject) obj;
			return super.createBDObject(avo.getParentVO());
		}
		return super.createBDObject(obj);
	}

}
