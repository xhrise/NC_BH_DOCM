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
*����
*/
public String code;
/**
*����
*/
public String name;
/**
*�ϼ�����
*/
public String pid;
/**
*����
*/
public String pk_busipower;
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
* ��ȡ�ϼ�����
*
* @return �ϼ�����
*/
public String getPid () {
return this.pid;
 } 

/** 
* �����ϼ�����
*
* @param pid �ϼ�����
*/
public void setPid ( String pid) {
this.pid=pid;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk_busipower () {
return this.pk_busipower;
 } 

/** 
* ��������
*
* @param pk_busipower ����
*/
public void setPk_busipower ( String pk_busipower) {
this.pk_busipower=pk_busipower;
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
    return VOMetaFactory.getInstance().getVOMeta("docmng.BusiPowerItem");
  }
}