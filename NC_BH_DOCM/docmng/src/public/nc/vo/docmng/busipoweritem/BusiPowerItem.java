package nc.vo.docmng.busipoweritem;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

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
*上级对象
*/
public String pid;
/**
*主键
*/
public String pk_busipower;
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
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("docmng.BusiPowerItem");
  }
}