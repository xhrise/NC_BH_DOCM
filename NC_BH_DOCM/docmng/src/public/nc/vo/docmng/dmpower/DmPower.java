package nc.vo.docmng.dmpower;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class DmPower extends SuperVO {
/**
*编码
*/
public String code;
/**
*创建时间
*/
public UFDateTime creationtime;
/**
*创建人
*/
public String creator;
/**
*修改时间
*/
public UFDateTime modifiedtime;
/**
*修改人
*/
public String modifier;
/**
*名称
*/
public String name;
/**
*集团
*/
public String pk_group;
/**
*主键
*/
public String pk_power;
/**
*角色
*/
public String pk_role;
/**
*时间戳
*/
public UFDateTime ts;
/**
*备注
*/
public String vnote;
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
* 获取修改时间
*
* @return 修改时间
*/
public UFDateTime getModifiedtime () {
return this.modifiedtime;
 } 

/** 
* 设置修改时间
*
* @param modifiedtime 修改时间
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.modifiedtime=modifiedtime;
 } 

/** 
* 获取修改人
*
* @return 修改人
*/
public String getModifier () {
return this.modifier;
 } 

/** 
* 设置修改人
*
* @param modifier 修改人
*/
public void setModifier ( String modifier) {
this.modifier=modifier;
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
* 获取主键
*
* @return 主键
*/
public String getPk_power () {
return this.pk_power;
 } 

/** 
* 设置主键
*
* @param pk_power 主键
*/
public void setPk_power ( String pk_power) {
this.pk_power=pk_power;
 } 

/** 
* 获取角色
*
* @return 角色
*/
public String getPk_role () {
return this.pk_role;
 } 

/** 
* 设置角色
*
* @param pk_role 角色
*/
public void setPk_role ( String pk_role) {
this.pk_role=pk_role;
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

/** 
* 获取备注
*
* @return 备注
*/
public String getVnote () {
return this.vnote;
 } 

/** 
* 设置备注
*
* @param vnote 备注
*/
public void setVnote ( String vnote) {
this.vnote=vnote;
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("docmng.DmPower");
  }
}