package nc.ui.mmgp.uif2.scale;

import java.util.List;

import nc.ui.pub.bill.IBillItem;

/**
 * 【数量】精度配置
 * <p>
 * 数量要根据其计量单位指定的小数位数设置精度
 * 
 * @author wangweiu
 * 
 */
public class MMGPNumScaleBean {

	// 数量item的key
	private List<String> numkeys;
	private int pos = IBillItem.HEAD;
	// 多子表有效
	private String tabcode;
	// 单位item的key
	private String unitkey = "pk_measdoc";
	private int unitpos = IBillItem.HEAD;
	// 多子表有效
	private String unittabcode;
	
	/**
	 * 是否为换算率
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
