package nc.ui.mmgp.uif2.scale;

import java.util.List;

import nc.ui.pub.bill.IBillItem;

/**
 * ����������������
 * <p>
 * ����Ҫ�����������λָ����С��λ�����þ���
 * 
 * @author wangweiu
 * 
 */
public class MMGPNumScaleBean {

	// ����item��key
	private List<String> numkeys;
	private int pos = IBillItem.HEAD;
	// ���ӱ���Ч
	private String tabcode;
	// ��λitem��key
	private String unitkey = "pk_measdoc";
	private int unitpos = IBillItem.HEAD;
	// ���ӱ���Ч
	private String unittabcode;
	
	/**
	 * �Ƿ�Ϊ������
	 */
	private ScaleBeanType type = ScaleBeanType.NumAssNum;

	public List<String> getNumkeys() {
		return numkeys;
	}

	public void setNumkeys(List<String> numkeys) {
		this.numkeys = numkeys;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getTabcode() {
		return tabcode;
	}

	public void setTabcode(String tabcode) {
		this.tabcode = tabcode;
	}

	public String getUnitkey() {
		return unitkey;
	}

	public void setUnitkey(String unitkey) {
		this.unitkey = unitkey;
	}

	public int getUnitpos() {
		return unitpos;
	}

	public void setUnitpos(int unitpos) {
		this.unitpos = unitpos;
	}

	public String getUnittabcode() {
		return unittabcode;
	}

	public void setUnittabcode(String unittabcode) {
		this.unittabcode = unittabcode;
	}

    /**
     * @return the type
     */
    public ScaleBeanType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ScaleBeanType type) {
        this.type = type;
    }

}
