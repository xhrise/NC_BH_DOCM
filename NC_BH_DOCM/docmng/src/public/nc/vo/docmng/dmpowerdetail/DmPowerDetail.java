package nc.vo.docmng.dmpowerdetail;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class DmPowerDetail extends SuperVO {
/**
*创建时间
*/
public UFDateTime creationtime;
/**
*创建人
*/
public String creator;
/**
*主键
*/
public String pk_detail;
/**
*文档类型
*/
public String pk_doctype;
/**
*集团
*/
public String pk_group;
/**
*文档权限
*/
public String pk_power;
/**
*时间戳
*/
public UFDateTime ts;
/** 
* 获取创建时间
*
* @return 创建时间
*/
public UFDateTime getCreationtime () {
return this.creationtime;
 } 

/** 
* 设置创建时间
*
* @param creationtime 创建时间
*/
public void setCreationtime ( UFDateTime creationtime) {
this.creationtime=creationtime;
 } 

/** 
* 获取创建人
*
* @return 创建人
*/
public String getCreator () {
return this.creator;
 } 

/** 
* 设置创建人
*
* @param creator 创建人
*/
public void setCreator ( String creator) {
this.creator=creator;
 } 

/** 
* 获取主键
*
* @return 主键
*/
public String getPk_detail () {
return this.pk_detail;
 } 

/** 
* 设置主键
*
* @param pk_detail 主键
*/
public void setPk_detail ( String pk_detail) {
this.pk_detail=pk_detail;
 } 

/** 
* 获取文档类型
*
* @return 文档类型
*/
public String getPk_doctype () {
return this.pk_doctype;
 } 

/** 
* 设置文档类型
*
* @param pk_doctype 文档类型
*/
public void setPk_doctype ( String pk_doctype) {
this.pk_doctype=pk_doctype;
 } 

/** 
* 获取集团
*
* @return 集团
*/
public String getPk_group () {
return this.pk_group;
 } 

/** 
* 设置集团
*
* @param pk_group 集团
*/
public void setPk_group ( String pk_group) {
this.pk_group=pk_group;
 } 

/** 
* 获取文档权限
*
* @return 文档权限
*/
public String getPk_power () {
return this.pk_power;
 } 

/** 
* 设置文档权限
*
* @param pk_power 文档权限
*/
public void setPk_power ( String pk_power) {
this.pk_power=pk_power;
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
    return VOMetaFactory.getInstance().getVOMeta("docmng.DmPowerDetail");
  }
}