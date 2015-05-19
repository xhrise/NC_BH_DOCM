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
*����ʱ��
*/
public UFDateTime creationtime;
/**
*������
*/
public String creator;
/**
*����
*/
public String pk_detail;
/**
*�ĵ�����
*/
public String pk_doctype;
/**
*����
*/
public String pk_group;
/**
*�ĵ�Ȩ��
*/
public String pk_power;
/**
*ʱ���
*/
public UFDateTime ts;
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
* ��ȡ����
*
* @return ����
*/
public String getPk_detail () {
return this.pk_detail;
 } 

/** 
* ��������
*
* @param pk_detail ����
*/
public void setPk_detail ( String pk_detail) {
this.pk_detail=pk_detail;
 } 

/** 
* ��ȡ�ĵ�����
*
* @return �ĵ�����
*/
public String getPk_doctype () {
return this.pk_doctype;
 } 

/** 
* �����ĵ�����
*
* @param pk_doctype �ĵ�����
*/
public void setPk_doctype ( String pk_doctype) {
this.pk_doctype=pk_doctype;
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
* ��ȡ�ĵ�Ȩ��
*
* @return �ĵ�Ȩ��
*/
public String getPk_power () {
return this.pk_power;
 } 

/** 
* �����ĵ�Ȩ��
*
* @param pk_power �ĵ�Ȩ��
*/
public void setPk_power ( String pk_power) {
this.pk_power=pk_power;
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
    return VOMetaFactory.getInstance().getVOMeta("docmng.DmPowerDetail");
  }
}