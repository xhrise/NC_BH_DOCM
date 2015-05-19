package nc.itf.docmng;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.docmng.docproperty.AggDocProperty;
import nc.vo.pub.BusinessException;

public interface IDocpropertyMaintain {

	public void delete(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException;

	public AggDocProperty[] insert(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException;

	public AggDocProperty[] update(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException;

	public AggDocProperty[] query(IQueryScheme queryScheme)
			throws BusinessException;

	public AggDocProperty[] save(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException;

	public AggDocProperty[] unsave(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException;

	public AggDocProperty[] approve(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException;

	public AggDocProperty[] unapprove(AggDocProperty[] clientFullVOs,
			AggDocProperty[] originBills) throws BusinessException;
}
