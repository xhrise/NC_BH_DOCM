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
*����
*/
public String code;
/**
*����
*/
public String name;
/**
*����
*/
public String permdisplay;
/**
*�ϼ�����
*/
public String pid;
/**
*����
*/
public String pk_busipower;
/**
*��ϸ
*/
public String pk_detail;
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
* ��ȡ����
*
* @return ����
*/
public String getPermdisplay () {
return this.permdisplay;
 } 

/** 
* ���ù���
*
* @param permdisplay ����
*/
public void setPermdisplay ( String permdisplay) {
this.permdisplay=permdisplay;
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
* ��ȡ��ϸ
*
* @return ��ϸ
*/
public String getPk_detail () {
return this.pk_detail;
 } 

/** 
* ������ϸ
*
* @param pk_detail ��ϸ
*/
public void setPk_detail ( String pk_detail) {
this.pk_detail=pk_detail;
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