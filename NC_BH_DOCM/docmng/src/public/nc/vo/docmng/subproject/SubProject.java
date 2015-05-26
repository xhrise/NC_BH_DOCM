package nc.vo.docmng.subproject;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class SubProject extends SuperVO {
/**
*编码
*/
public String code;
/**
*创建时间
*/
public static final String CREATIONTIME="creationtime";
/**
*创建人
*/
public static final String CREATOR="creator";
/**
*修改时间
*/
public static final String MODIFIEDTIME="modifiedtime";
/**
*修改人
*/
public static final String MODIFIER="modifier";
/**
*名称
*/
public String name;
/**
*集团
*/
public static final String PK_GROUP="pk_group";
/**
*组织
*/
public static final String PK_ORG="pk_org";
/**
*项目
*/
public String pk_project;
/**
*主键
*/
public String pk_sub;
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
* 获取创建时间
*
* @return 创建时间
*/
public UFDateTime getCreationtime () {
return (UFDateTime) this.getAttributeValue( SubProject.CREATIONTIME);
 } 

/** 
* 设置创建时间
*
* @param creationtime 创建时间
*/
public void setCreationtime ( UFDateTime creationtime) {
this.setAttributeValue( SubProject.CREATIONTIME,creationtime);
 } 

/** 
* 获取创建人
*
* @return 创建人
*/
public String getCreator () {
return (String) this.getAttributeValue( SubProject.CREATOR);
 } 

/** 
* 设置创建人
*
* @param creator 创建人
*/
public void setCreator ( String creator) {
this.setAttributeValue( SubProject.CREATOR,creator);
 } 

/** 
* 获取修改时间
*
* @return 修改时间
*/
public UFDateTime getModifiedtime () {
return (UFDateTime) this.getAttributeValue( SubProject.MODIFIEDTIME);
 } 

/** 
* 设置修改时间
*
* @param modifiedtime 修改时间
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.setAttributeValue( SubProject.MODIFIEDTIME,modifiedtime);
 } 

/** 
* 获取修改人
*
* @return 修改人
*/
public String getModifier () {
return (String) this.getAttributeValue( SubProject.MODIFIER);
 } 

/** 
* 设置修改人
*
* @param modifier 修改人
*/
public void setModifier ( String modifier) {
this.setAttributeValue( SubProject.MODIFIER,modifier);
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
return (String) this.getAttributeValue( SubProject.PK_GROUP);
 } 

/** 
* 设置集团
*
* @param pk_group 集团
*/
public void setPk_group ( String pk_group) {
this.setAttributeValue( SubProject.PK_GROUP,pk_group);
 } 

/** 
* 获取组织
*
* @return 组织
*/
public String getPk_org () {
return (String) this.getAttributeValue( SubProject.PK_ORG);
 } 

/** 
* 设置组织
*
* @param pk_org 组织
*/
public void setPk_org ( String pk_org) {
this.setAttributeValue( SubProject.PK_ORG,pk_org);
 } 

/** 
* 获取项目
*
* @return 项目
*/
public String getPk_project () {
return this.pk_project;
 } 

/** 
* 设置项目
*
* @param pk_project 项目
*/
public void setPk_project ( String pk_project) {
this.pk_project=pk_project;
 } 

/** 
* 获取主键
*
* @return 主键
*/
public String getPk_sub () {
return this.pk_sub;
 } 

/** 
* 设置主键
*
* @param pk_sub 主键
*/
public void setPk_sub ( String pk_sub) {
this.pk_sub=pk_sub;
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
    return VOMetaFactory.getInstance().getVOMeta("docmng.SubProject");
  }
}