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
*����
*/
public String code;
/**
*����ʱ��
*/
public static final String CREATIONTIME="creationtime";
/**
*������
*/
public static final String CREATOR="creator";
/**
*�޸�ʱ��
*/
public static final String MODIFIEDTIME="modifiedtime";
/**
*�޸���
*/
public static final String MODIFIER="modifier";
/**
*����
*/
public String name;
/**
*����
*/
public static final String PK_GROUP="pk_group";
/**
*��֯
*/
public static final String PK_ORG="pk_org";
/**
*��Ŀ
*/
public String pk_project;
/**
*����
*/
public String pk_sub;
/**
*ʱ���
*/
public UFDateTime ts;
/** 
* ��ȡ����
*
* @return ����
*/
public String getCode () {
return this.code;
 } 

/** 
* ���ñ���
*
* @param code ����
*/
public void setCode ( String code) {
this.code=code;
 } 

/** 
* ��ȡ����ʱ��
*
* @return ����ʱ��
*/
public UFDateTime getCreationtime () {
return (UFDateTime) this.getAttributeValue( SubProject.CREATIONTIME);
 } 

/** 
* ���ô���ʱ��
*
* @param creationtime ����ʱ��
*/
public void setCreationtime ( UFDateTime creationtime) {
this.setAttributeValue( SubProject.CREATIONTIME,creationtime);
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getCreator () {
return (String) this.getAttributeValue( SubProject.CREATOR);
 } 

/** 
* ���ô�����
*
* @param creator ������
*/
public void setCreator ( String creator) {
this.setAttributeValue( SubProject.CREATOR,creator);
 } 

/** 
* ��ȡ�޸�ʱ��
*
* @return �޸�ʱ��
*/
public UFDateTime getModifiedtime () {
return (UFDateTime) this.getAttributeValue( SubProject.MODIFIEDTIME);
 } 

/** 
* �����޸�ʱ��
*
* @param modifiedtime �޸�ʱ��
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.setAttributeValue( SubProject.MODIFIEDTIME,modifiedtime);
 } 

/** 
* ��ȡ�޸���
*
* @return �޸���
*/
public String getModifier () {
return (String) this.getAttributeValue( SubProject.MODIFIER);
 } 

/** 
* �����޸���
*
* @param modifier �޸���
*/
public void setModifier ( String modifier) {
this.setAttributeValue( SubProject.MODIFIER,modifier);
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getName () {
return this.name;
 } 

/** 
* ��������
*
* @param name ����
*/
public void setName ( String name) {
this.name=name;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk_group () {
return (String) this.getAttributeValue( SubProject.PK_GROUP);
 } 

/** 
* ���ü���
*
* @param pk_group ����
*/
public void setPk_group ( String pk_group) {
this.setAttributeValue( SubProject.PK_GROUP,pk_group);
 } 

/** 
* ��ȡ��֯
*
* @return ��֯
*/
public String getPk_org () {
return (String) this.getAttributeValue( SubProject.PK_ORG);
 } 

/** 
* ������֯
*
* @param pk_org ��֯
*/
public void setPk_org ( String pk_org) {
this.setAttributeValue( SubProject.PK_ORG,pk_org);
 } 

/** 
* ��ȡ��Ŀ
*
* @return ��Ŀ
*/
public String getPk_project () {
return this.pk_project;
 } 

/** 
* ������Ŀ
*
* @param pk_project ��Ŀ
*/
public void setPk_project ( String pk_project) {
this.pk_project=pk_project;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk_sub () {
return this.pk_sub;
 } 

/** 
* ��������
*
* @param pk_sub ����
*/
public void setPk_sub ( String pk_sub) {
this.pk_sub=pk_sub;
 } 

/** 
* ��ȡʱ���
*
* @return ʱ���
*/
public UFDateTime getTs () {
return this.ts;
 } 

/** 
* ����ʱ���
*
* @param ts ʱ���
*/
public void setTs ( UFDateTime ts) {
this.ts=ts;
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("docmng.SubProject");
  }
}