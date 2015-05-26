package nc.ui.docmng.ref;

import nc.md.MDBaseQueryFacade;
import nc.md.model.IBean;
import nc.md.model.MetaDataException;
import nc.ui.bd.ref.AbstractRefModel;
import nc.vo.util.VisibleUtil;
import nc.vo.docmng.subproject.SubProject;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public class SubProjectRefModel extends AbstractRefModel{
	
	public SubProjectRefModel(){
		super();
		this.reset();
	}
	
	private String key;
	
    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private int m_iDefaultFieldCount = 4;
    
    @Override
    public String[] getFieldCode() {
        return new String[]{"code","name","pk_project" };
    }

    @Override
    public String[] getFieldName() {
        return new String[]{/* "分组编码", "分组名称", */"编码", "名称","项目"};
    }

    @Override
    public void reset() {
        setFieldCode(getFieldCode());
        setFieldName(getFieldName());
        setHiddenFieldCode(new String[]{"pk_sub"});
        setRefCodeField("code");
        setRefNameField("name");
        setTableName("docmng_subproject");
        setPkFieldCode("pk_sub");
        setRefTitle("工程");
        resetFieldName();
    }

    @Override
    public String getWherePart() {
        String wherePart = super.getWherePart();
        if (wherePart == null) {
            wherePart = "  isnull(dr,0)=0";
        } else {
            wherePart += " and isnull(dr,0)=0";
        }
        if(this.key==null){
        	wherePart += " and pk_project=''";
        }else{
        	wherePart += " and pk_project='"+this.key+"'";
        	
        }

        return wherePart;
    }

    @Override
    public int getDefaultFieldCount() {
        return m_iDefaultFieldCount;
    }

    @Override
    protected String getEnvWherePart() {
        return null;
    }




}
