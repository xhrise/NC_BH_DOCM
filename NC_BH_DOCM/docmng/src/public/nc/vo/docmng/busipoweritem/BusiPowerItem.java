package nc.vo.docmng.busipoweritem;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;
import nc.vo.uap.rbac.BusiFuncItemVO;

public class BusiPowerItem extends SuperVO {
/**
*编码
*/
public String code;
/**
*名称
*/
public String name;
/**
*功能
*/
public String permdisplay;
/**
*上级对象
*/
public String pid;
/**
*主键
*/
public String pk_busipower;
/**
*明细
*/
public String pk_detail;
/**
*时间戳
*/
public UFDateTime ts;
/** 
* 获取编码
*
* @return 编码
*/
public String getCode () {
return this.code;
 } 

/** 
* 设置编码
*
* @param code 编码
*/
public void setCode ( String code) {
this.code=code;
 } 

/** 
* 获取名称
*
* @return 名称
*/
public String getName () {
return this.name;
 } 

/** 
* 设置名称
*
* @param name 名称
*/
public void setName ( String name) {
this.name=name;
 } 

/** 
* 获取功能
*
* @return 功能
*/
public String getPermdisplay () {
return this.permdisplay;
 } 

/** 
* 设置功能
*
* @param permdisplay 功能
*/
public void setPermdisplay ( String permdisplay) {
this.permdisplay=permdisplay;
 } 

/** 
* 获取上级对象
*
* @return 上级对象
*/
public String getPid () {
return this.pid;
 } 

/** 
* 设置上级对象
*
* @param pid 上级对象
*/
public void setPid ( String pid) {
this.pid=pid;
 } 

/** 
* 获取主键
*
* @return 主键
*/
public String getPk_busipower () {
return this.pk_busipower;
 } 

/** 
* 设置主键
*
* @param pk_busipower 主键
*/
public void setPk_busipower ( String pk_busipower) {
this.pk_busipower=pk_busipower;
 } 

/** 
* 获取明细
*
* @return 明细
*/
public String getPk_detail () {
return this.pk_detail;
 } 

/** 
* 设置明细
*
* @param pk_detail 明细
*/
public void setPk_detail ( String pk_detail) {
this.pk_detail=pk_detail;
 } 

/** 
* 获取时间戳
*
* @return 时间戳
*/
public UFDateTime getTs () {
return this.ts;
 } 

/** 
* 设置时间戳
*
* @param ts 时间戳
*/
public void setTs ( UFDateTime ts) {
this.ts=ts;
 } 


@Override
public boolean equals(Object o) {
	if (!(o instanceof BusiPowerItem))
		return false;
	BusiPowerItem vo = (BusiPowerItem) o;
	String s1 = getPk_busipower();
	String s2 = vo.getPk_busipower();
	if (s1 == null && s2 == null)
		return true;
	else if (s1 == null || s2 == null)
		return false;
	else if (s1.equals(s2))
		return true;
	else
		return false;
}

@Override
public int hashCode() {
	return super.hashCode();
}




  @Override
public String getPrimaryKey() {
	// TODO Auto-generated method stub
	return this.getPk_detail();
}

@Override
public String toString() {
	  return this.getCode() + "  " + this.getName(); 
}

@Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("docmng.BusiPowerItem");
  }
}