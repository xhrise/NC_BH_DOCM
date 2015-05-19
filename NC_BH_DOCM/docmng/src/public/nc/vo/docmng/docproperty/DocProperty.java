package nc.vo.docmng.docproperty;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class DocProperty extends SuperVO {
/**
*�������
*/
public String approvenite;
/**
*������
*/
public String approver;
/**
*����ʱ��
*/
public UFDateTime approvetime;
/**
*�Ƶ���
*/
public String billmaker;
/**
*��������
*/
public String billtype;
/**
*����ʱ��
*/
public static final String CREATIONTIME="creationtime";
/**
*������
*/
public static final String CREATOR="creator";
/**
*����
*/
public UFDate dbilldate;
/**
*�ϴ�����
*/
public UFDate dcreatedate;
/**
*�Զ�����1
*/
public String def1;
/**
*�Զ�����10
*/
public String def10;
/**
*�Զ�����11
*/
public String def11;
/**
*�Զ�����12
*/
public String def12;
/**
*�Զ�����13
*/
public String def13;
/**
*�Զ�����14
*/
public String def14;
/**
*�Զ�����15
*/
public String def15;
/**
*�Զ�����16
*/
public String def16;
/**
*�Զ�����17
*/
public String def17;
/**
*�Զ�����18
*/
public String def18;
/**
*�Զ�����19
*/
public String def19;
/**
*�Զ�����2
*/
public String def2;
/**
*�Զ�����20
*/
public String def20;
/**
*�Զ�����3
*/
public String def3;
/**
*�Զ�����4
*/
public String def4;
/**
*�Զ�����5
*/
public String def5;
/**
*�Զ�����6
*/
public String def6;
/**
*�Զ�����7
*/
public String def7;
/**
*�Զ�����8
*/
public String def8;
/**
*�Զ�����9
*/
public String def9;
/**
*���ʱ��
*/
public UFDateTime donetime;
/**
*�ļ���С
*/
public static final String FILELENGTH="filelength";
/**
*�洢·��
*/
public String filepath;
/**
*�ĵ�����
*/
public static final String FILETYPE="filetype";
/**
*����״̬
*/
public Integer fstatusflag;
/**
*�ѽ��
*/
public UFBoolean isdone;
/**
*����
*/
public UFBoolean isneed;
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
public String pk_docid;
/**
*pk_doctype
*/
public static final String PK_DOCTYPE="pk_doctype";
/**
*����
*/
public static final String PK_GROUP="pk_group";
/**
*��֯
*/
public static final String PK_ORG="pk_org";
/**
*��֯�汾
*/
public static final String PK_ORG_V="pk_org_v";
/**
*��Ŀ
*/
public static final String PK_PROJECT="pk_project";
/**
*�ϴ���
*/
public String pk_uploader;
/**
*�������
*/
public String solution;
/**
*ʱ���
*/
public UFDateTime ts;
/**
*���ݺ�
*/
public String vbillcode;
/**
*�ؼ���
*/
public static final String VKEYWORD="vkeyword";
/**
*�ļ�����
*/
public static final String VNAME="vname";
/**
*��ע
*/
public String vnote;
/** 
* ��ȡ�������
*
* @return �������
*/
public String getApprovenite () {
return this.approvenite;
 } 

/** 
* �����������
*
* @param approvenite �������
*/
public void setApprovenite ( String approvenite) {
this.approvenite=approvenite;
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getApprover () {
return this.approver;
 } 

/** 
* ����������
*
* @param approver ������
*/
public void setApprover ( String approver) {
this.approver=approver;
 } 

/** 
* ��ȡ����ʱ��
*
* @return ����ʱ��
*/
public UFDateTime getApprovetime () {
return this.approvetime;
 } 

/** 
* ��������ʱ��
*
* @param approvetime ����ʱ��
*/
public void setApprovetime ( UFDateTime approvetime) {
this.approvetime=approvetime;
 } 

/** 
* ��ȡ�Ƶ���
*
* @return �Ƶ���
*/
public String getBillmaker () {
return this.billmaker;
 } 

/** 
* �����Ƶ���
*
* @param billmaker �Ƶ���
*/
public void setBillmaker ( String billmaker) {
this.billmaker=billmaker;
 } 

/** 
* ��ȡ��������
*
* @return ��������
*/
public String getBilltype () {
return this.billtype;
 } 

/** 
* ���õ�������
*
* @param billtype ��������
*/
public void setBilltype ( String billtype) {
this.billtype=billtype;
 } 

/** 
* ��ȡ����ʱ��
*
* @return ����ʱ��
*/
public UFDateTime getCreationtime () {
return (UFDateTime) this.getAttributeValue( DocProperty.CREATIONTIME);
 } 

/** 
* ���ô���ʱ��
*
* @param creationtime ����ʱ��
*/
public void setCreationtime ( UFDateTime creationtime) {
this.setAttributeValue( DocProperty.CREATIONTIME,creationtime);
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getCreator () {
return (String) this.getAttributeValue( DocProperty.CREATOR);
 } 

/** 
* ���ô�����
*
* @param creator ������
*/
public void setCreator ( String creator) {
this.setAttributeValue( DocProperty.CREATOR,creator);
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public UFDate getDbilldate () {
return this.dbilldate;
 } 

/** 
* ��������
*
* @param dbilldate ����
*/
public void setDbilldate ( UFDate dbilldate) {
this.dbilldate=dbilldate;
 } 

/** 
* ��ȡ�ϴ�����
*
* @return �ϴ�����
*/
public UFDate getDcreatedate () {
return this.dcreatedate;
 } 

/** 
* �����ϴ�����
*
* @param dcreatedate �ϴ�����
*/
public void setDcreatedate ( UFDate dcreatedate) {
this.dcreatedate=dcreatedate;
 } 

/** 
* ��ȡ�Զ�����1
*
* @return �Զ�����1
*/
public String getDef1 () {
return this.def1;
 } 

/** 
* �����Զ�����1
*
* @param def1 �Զ�����1
*/
public void setDef1 ( String def1) {
this.def1=def1;
 } 

/** 
* ��ȡ�Զ�����10
*
* @return �Զ�����10
*/
public String getDef10 () {
return this.def10;
 } 

/** 
* �����Զ�����10
*
* @param def10 �Զ�����10
*/
public void setDef10 ( String def10) {
this.def10=def10;
 } 

/** 
* ��ȡ�Զ�����11
*
* @return �Զ�����11
*/
public String getDef11 () {
return this.def11;
 } 

/** 
* �����Զ�����11
*
* @param def11 �Զ�����11
*/
public void setDef11 ( String def11) {
this.def11=def11;
 } 

/** 
* ��ȡ�Զ�����12
*
* @return �Զ�����12
*/
public String getDef12 () {
return this.def12;
 } 

/** 
* �����Զ�����12
*
* @param def12 �Զ�����12
*/
public void setDef12 ( String def12) {
this.def12=def12;
 } 

/** 
* ��ȡ�Զ�����13
*
* @return �Զ�����13
*/
public String getDef13 () {
return this.def13;
 } 

/** 
* �����Զ�����13
*
* @param def13 �Զ�����13
*/
public void setDef13 ( String def13) {
this.def13=def13;
 } 

/** 
* ��ȡ�Զ�����14
*
* @return �Զ�����14
*/
public String getDef14 () {
return this.def14;
 } 

/** 
* �����Զ�����14
*
* @param def14 �Զ�����14
*/
public void setDef14 ( String def14) {
this.def14=def14;
 } 

/** 
* ��ȡ�Զ�����15
*
* @return �Զ�����15
*/
public String getDef15 () {
return this.def15;
 } 

/** 
* �����Զ�����15
*
* @param def15 �Զ�����15
*/
public void setDef15 ( String def15) {
this.def15=def15;
 } 

/** 
* ��ȡ�Զ�����16
*
* @return �Զ�����16
*/
public String getDef16 () {
return this.def16;
 } 

/** 
* �����Զ�����16
*
* @param def16 �Զ�����16
*/
public void setDef16 ( String def16) {
this.def16=def16;
 } 

/** 
* ��ȡ�Զ�����17
*
* @return �Զ�����17
*/
public String getDef17 () {
return this.def17;
 } 

/** 
* �����Զ�����17
*
* @param def17 �Զ�����17
*/
public void setDef17 ( String def17) {
this.def17=def17;
 } 

/** 
* ��ȡ�Զ�����18
*
* @return �Զ�����18
*/
public String getDef18 () {
return this.def18;
 } 

/** 
* �����Զ�����18
*
* @param def18 �Զ�����18
*/
public void setDef18 ( String def18) {
this.def18=def18;
 } 

/** 
* ��ȡ�Զ�����19
*
* @return �Զ�����19
*/
public String getDef19 () {
return this.def19;
 } 

/** 
* �����Զ�����19
*
* @param def19 �Զ�����19
*/
public void setDef19 ( String def19) {
this.def19=def19;
 } 

/** 
* ��ȡ�Զ�����2
*
* @return �Զ�����2
*/
public String getDef2 () {
return this.def2;
 } 

/** 
* �����Զ�����2
*
* @param def2 �Զ�����2
*/
public void setDef2 ( String def2) {
this.def2=def2;
 } 

/** 
* ��ȡ�Զ�����20
*
* @return �Զ�����20
*/
public String getDef20 () {
return this.def20;
 } 

/** 
* �����Զ�����20
*
* @param def20 �Զ�����20
*/
public void setDef20 ( String def20) {
this.def20=def20;
 } 

/** 
* ��ȡ�Զ�����3
*
* @return �Զ�����3
*/
public String getDef3 () {
return this.def3;
 } 

/** 
* �����Զ�����3
*
* @param def3 �Զ�����3
*/
public void setDef3 ( String def3) {
this.def3=def3;
 } 

/** 
* ��ȡ�Զ�����4
*
* @return �Զ�����4
*/
public String getDef4 () {
return this.def4;
 } 

/** 
* �����Զ�����4
*
* @param def4 �Զ�����4
*/
public void setDef4 ( String def4) {
this.def4=def4;
 } 

/** 
* ��ȡ�Զ�����5
*
* @return �Զ�����5
*/
public String getDef5 () {
return this.def5;
 } 

/** 
* �����Զ�����5
*
* @param def5 �Զ�����5
*/
public void setDef5 ( String def5) {
this.def5=def5;
 } 

/** 
* ��ȡ�Զ�����6
*
* @return �Զ�����6
*/
public String getDef6 () {
return this.def6;
 } 

/** 
* �����Զ�����6
*
* @param def6 �Զ�����6
*/
public void setDef6 ( String def6) {
this.def6=def6;
 } 

/** 
* ��ȡ�Զ�����7
*
* @return �Զ�����7
*/
public String getDef7 () {
return this.def7;
 } 

/** 
* �����Զ�����7
*
* @param def7 �Զ�����7
*/
public void setDef7 ( String def7) {
this.def7=def7;
 } 

/** 
* ��ȡ�Զ�����8
*
* @return �Զ�����8
*/
public String getDef8 () {
return this.def8;
 } 

/** 
* �����Զ�����8
*
* @param def8 �Զ�����8
*/
public void setDef8 ( String def8) {
this.def8=def8;
 } 

/** 
* ��ȡ�Զ�����9
*
* @return �Զ�����9
*/
public String getDef9 () {
return this.def9;
 } 

/** 
* �����Զ�����9
*
* @param def9 �Զ�����9
*/
public void setDef9 ( String def9) {
this.def9=def9;
 } 

/** 
* ��ȡ���ʱ��
*
* @return ���ʱ��
*/
public UFDateTime getDonetime () {
return this.donetime;
 } 

/** 
* ���ý��ʱ��
*
* @param donetime ���ʱ��
*/
public void setDonetime ( UFDateTime donetime) {
this.donetime=donetime;
 } 

/** 
* ��ȡ�ļ���С
*
* @return �ļ���С
*/
public Integer getFilelength () {
return (Integer) this.getAttributeValue( DocProperty.FILELENGTH);
 } 

/** 
* �����ļ���С
*
* @param filelength �ļ���С
*/
public void setFilelength ( Integer filelength) {
this.setAttributeValue( DocProperty.FILELENGTH,filelength);
 } 

/** 
* ��ȡ�洢·��
*
* @return �洢·��
*/
public String getFilepath () {
return this.filepath;
 } 

/** 
* ���ô洢·��
*
* @param filepath �洢·��
*/
public void setFilepath ( String filepath) {
this.filepath=filepath;
 } 

/** 
* ��ȡ�ĵ�����
*
* @return �ĵ�����
*/
public String getFiletype () {
return (String) this.getAttributeValue( DocProperty.FILETYPE);
 } 

/** 
* �����ĵ�����
*
* @param filetype �ĵ�����
*/
public void setFiletype ( String filetype) {
this.setAttributeValue( DocProperty.FILETYPE,filetype);
 } 

/** 
* ��ȡ����״̬
*
* @return ����״̬
* @see String
*/
public Integer getFstatusflag () {
return this.fstatusflag;
 } 

/** 
* ��������״̬
*
* @param fstatusflag ����״̬
* @see String
*/
public void setFstatusflag ( Integer fstatusflag) {
this.fstatusflag=fstatusflag;
 } 

/** 
* ��ȡ�ѽ��
*
* @return �ѽ��
*/
public UFBoolean getIsdone () {
return this.isdone;
 } 

/** 
* �����ѽ��
*
* @param isdone �ѽ��
*/
public void setIsdone ( UFBoolean isdone) {
this.isdone=isdone;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public UFBoolean getIsneed () {
return this.isneed;
 } 

/** 
* ��������
*
* @param isneed ����
*/
public void setIsneed ( UFBoolean isneed) {
this.isneed=isneed;
 } 

/** 
* ��ȡ�޸�ʱ��
*
* @return �޸�ʱ��
*/
public UFDateTime getModifiedtime () {
return (UFDateTime) this.getAttributeValue( DocProperty.MODIFIEDTIME);
 } 

/** 
* �����޸�ʱ��
*
* @param modifiedtime �޸�ʱ��
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.setAttributeValue( DocProperty.MODIFIEDTIME,modifiedtime);
 } 

/** 
* ��ȡ�޸���
*
* @return �޸���
*/
public String getModifier () {
return (String) this.getAttributeValue( DocProperty.MODIFIER);
 } 

/** 
* �����޸���
*
* @param modifier �޸���
*/
public void setModifier ( String modifier) {
this.setAttributeValue( DocProperty.MODIFIER,modifier);
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk_docid () {
return this.pk_docid;
 } 

/** 
* ��������
*
* @param pk_docid ����
*/
public void setPk_docid ( String pk_docid) {
this.pk_docid=pk_docid;
 } 

/** 
* ��ȡpk_doctype
*
* @return pk_doctype
*/
public String getPk_doctype () {
return (String) this.getAttributeValue( DocProperty.PK_DOCTYPE);
 } 

/** 
* ����pk_doctype
*
* @param pk_doctype pk_doctype
*/
public void setPk_doctype ( String pk_doctype) {
this.setAttributeValue( DocProperty.PK_DOCTYPE,pk_doctype);
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk_group () {
return (String) this.getAttributeValue( DocProperty.PK_GROUP);
 } 

/** 
* ���ü���
*
* @param pk_group ����
*/
public void setPk_group ( String pk_group) {
this.setAttributeValue( DocProperty.PK_GROUP,pk_group);
 } 

/** 
* ��ȡ��֯
*
* @return ��֯
*/
public String getPk_org () {
return (String) this.getAttributeValue( DocProperty.PK_ORG);
 } 

/** 
* ������֯
*
* @param pk_org ��֯
*/
public void setPk_org ( String pk_org) {
this.setAttributeValue( DocProperty.PK_ORG,pk_org);
 } 

/** 
* ��ȡ��֯�汾
*
* @return ��֯�汾
*/
public String getPk_org_v () {
return (String) this.getAttributeValue( DocProperty.PK_ORG_V);
 } 

/** 
* ������֯�汾
*
* @param pk_org_v ��֯�汾
*/
public void setPk_org_v ( String pk_org_v) {
this.setAttributeValue( DocProperty.PK_ORG_V,pk_org_v);
 } 

/** 
* ��ȡ��Ŀ
*
* @return ��Ŀ
*/
public String getPk_project () {
return (String) this.getAttributeValue( DocProperty.PK_PROJECT);
 } 

/** 
* ������Ŀ
*
* @param pk_project ��Ŀ
*/
public void setPk_project ( String pk_project) {
this.setAttributeValue( DocProperty.PK_PROJECT,pk_project);
 } 

/** 
* ��ȡ�ϴ���
*
* @return �ϴ���
*/
public String getPk_uploader () {
return this.pk_uploader;
 } 

/** 
* �����ϴ���
*
* @param pk_uploader �ϴ���
*/
public void setPk_uploader ( String pk_uploader) {
this.pk_uploader=pk_uploader;
 } 

/** 
* ��ȡ�������
*
* @return �������
*/
public String getSolution () {
return this.solution;
 } 

/** 
* ���ý������
*
* @param solution �������
*/
public void setSolution ( String solution) {
this.solution=solution;
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
* ��ȡ���ݺ�
*
* @return ���ݺ�
*/
public String getVbillcode () {
return this.vbillcode;
 } 

/** 
* ���õ��ݺ�
*
* @param vbillcode ���ݺ�
*/
public void setVbillcode ( String vbillcode) {
this.vbillcode=vbillcode;
 } 

/** 
* ��ȡ�ؼ���
*
* @return �ؼ���
*/
public String getVkeyword () {
return (String) this.getAttributeValue( DocProperty.VKEYWORD);
 } 

/** 
* ���ùؼ���
*
* @param vkeyword �ؼ���
*/
public void setVkeyword ( String vkeyword) {
this.setAttributeValue( DocProperty.VKEYWORD,vkeyword);
 } 

/** 
* ��ȡ�ļ�����
*
* @return �ļ�����
*/
public String getVname () {
return (String) this.getAttributeValue( DocProperty.VNAME);
 } 

/** 
* �����ļ�����
*
* @param vname �ļ�����
*/
public void setVname ( String vname) {
this.setAttributeValue( DocProperty.VNAME,vname);
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
    return VOMetaFactory.getInstance().getVOMeta("docmng.DocProperty");
  }
}