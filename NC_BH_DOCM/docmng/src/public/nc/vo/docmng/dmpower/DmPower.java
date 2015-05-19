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
*����
*/
public String code;
/**
*����ʱ��
*/
public UFDateTime creationtime;
/**
*������
*/
public String creator;
/**
*�޸�ʱ��
*/
public UFDateTime modifiedtime;
/**
*�޸���
*/
public String modifier;
/**
*����
*/
public String name;
/**
*����
*/
public String pk_group;
/**
*����
*/
public String pk_power;
/**
*��ɫ
*/
public String pk_role;
/**
*ʱ���
*/
public UFDateTime ts;
/**
*��ע
*/
public String vnote;
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
return this.creationtime;
 } 

/** 
* ���ô���ʱ��
*
* @param creationtime ����ʱ��
*/
public void setCreationtime ( UFDateTime creationtime) {
this.creationtime=creationtime;
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getCreator () {
return this.creator;
 } 

/** 
* ���ô�����
*
* @param creator ������
*/
public void setCreator ( String creator) {
this.creator=creator;
 } 

/** 
* ��ȡ�޸�ʱ��
*
* @return �޸�ʱ��
*/
public UFDateTime getModifiedtime () {
return this.modifiedtime;
 } 

/** 
* �����޸�ʱ��
*
* @param modifiedtime �޸�ʱ��
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.modifiedtime=modifiedtime;
 } 

/** 
* ��ȡ�޸���
*
* @return �޸���
*/
public String getModifier () {
return this.modifier;
 } 

/** 
* �����޸���
*
* @param modifier �޸���
*/
public void setModifier ( String modifier) {
this.modifier=modifier;
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
return this.pk_group;
 } 

/** 
* ���ü���
*
* @param pk_group ����
*/
public void setPk_group ( String pk_group) {
this.pk_group=pk_group;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk_power () {
return this.pk_power;
 } 

/** 
* ��������
*
* @param pk_power ����
*/
public void setPk_power ( String pk_power) {
this.pk_power=pk_power;
 } 

/** 
* ��ȡ��ɫ
*
* @return ��ɫ
*/
public String getPk_role () {
return this.pk_role;
 } 

/** 
* ���ý�ɫ
*
* @param pk_role ��ɫ
*/
public void setPk_role ( String pk_role) {
this.pk_role=pk_role;
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

/** 
* ��ȡ��ע
*
* @return ��ע
*/
public String getVnote () {
return this.vnote;
 } 

/** 
* ���ñ�ע
*
* @param vnote ��ע
*/
public void setVnote ( String vnote) {
this.vnote=vnote;
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("docmng.DmPower");
  }
}