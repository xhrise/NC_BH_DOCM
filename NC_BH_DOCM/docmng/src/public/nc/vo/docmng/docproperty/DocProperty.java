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
*审核批语
*/
public String approvenite;
/**
*审批人
*/
public String approver;
/**
*审批时间
*/
public UFDateTime approvetime;
/**
*制单人
*/
public String billmaker;
/**
*单据类型
*/
public String billtype;
/**
*创建时间
*/
public static final String CREATIONTIME="creationtime";
/**
*创建人
*/
public static final String CREATOR="creator";
/**
*日期
*/
public UFDate dbilldate;
/**
*上传日期
*/
public UFDate dcreatedate;
/**
*自定义项1
*/
public String def1;
/**
*自定义项10
*/
public String def10;
/**
*自定义项11
*/
public String def11;
/**
*自定义项12
*/
public String def12;
/**
*自定义项13
*/
public String def13;
/**
*自定义项14
*/
public String def14;
/**
*自定义项15
*/
public String def15;
/**
*自定义项16
*/
public String def16;
/**
*自定义项17
*/
public String def17;
/**
*自定义项18
*/
public String def18;
/**
*自定义项19
*/
public String def19;
/**
*自定义项2
*/
public String def2;
/**
*自定义项20
*/
public String def20;
/**
*自定义项3
*/
public String def3;
/**
*自定义项4
*/
public String def4;
/**
*自定义项5
*/
public String def5;
/**
*自定义项6
*/
public String def6;
/**
*自定义项7
*/
public String def7;
/**
*自定义项8
*/
public String def8;
/**
*自定义项9
*/
public String def9;
/**
*解决时间
*/
public UFDateTime donetime;
/**
*文件大小
*/
public static final String FILELENGTH="filelength";
/**
*存储路径
*/
public String filepath;
/**
*文档类型
*/
public static final String FILETYPE="filetype";
/**
*审批状态
*/
public Integer fstatusflag;
/**
*已解决
*/
public UFBoolean isdone;
/**
*需解决
*/
public UFBoolean isneed;
/**
*修改时间
*/
public static final String MODIFIEDTIME="modifiedtime";
/**
*修改人
*/
public static final String MODIFIER="modifier";
/**
*主键
*/
public String pk_docid;
/**
*pk_doctype
*/
public static final String PK_DOCTYPE="pk_doctype";
/**
*集团
*/
public static final String PK_GROUP="pk_group";
/**
*组织
*/
public static final String PK_ORG="pk_org";
/**
*组织版本
*/
public static final String PK_ORG_V="pk_org_v";
/**
*项目
*/
public static final String PK_PROJECT="pk_project";
/**
*上传人
*/
public String pk_uploader;
/**
*解决方法
*/
public String solution;
/**
*时间戳
*/
public UFDateTime ts;
/**
*单据号
*/
public String vbillcode;
/**
*关键字
*/
public static final String VKEYWORD="vkeyword";
/**
*文件名称
*/
public static final String VNAME="vname";
/**
*备注
*/
public String vnote;
/** 
* 获取审核批语
*
* @return 审核批语
*/
public String getApprovenite () {
return this.approvenite;
 } 

/** 
* 设置审核批语
*
* @param approvenite 审核批语
*/
public void setApprovenite ( String approvenite) {
this.approvenite=approvenite;
 } 

/** 
* 获取审批人
*
* @return 审批人
*/
public String getApprover () {
return this.approver;
 } 

/** 
* 设置审批人
*
* @param approver 审批人
*/
public void setApprover ( String approver) {
this.approver=approver;
 } 

/** 
* 获取审批时间
*
* @return 审批时间
*/
public UFDateTime getApprovetime () {
return this.approvetime;
 } 

/** 
* 设置审批时间
*
* @param approvetime 审批时间
*/
public void setApprovetime ( UFDateTime approvetime) {
this.approvetime=approvetime;
 } 

/** 
* 获取制单人
*
* @return 制单人
*/
public String getBillmaker () {
return this.billmaker;
 } 

/** 
* 设置制单人
*
* @param billmaker 制单人
*/
public void setBillmaker ( String billmaker) {
this.billmaker=billmaker;
 } 

/** 
* 获取单据类型
*
* @return 单据类型
*/
public String getBilltype () {
return this.billtype;
 } 

/** 
* 设置单据类型
*
* @param billtype 单据类型
*/
public void setBilltype ( String billtype) {
this.billtype=billtype;
 } 

/** 
* 获取创建时间
*
* @return 创建时间
*/
public UFDateTime getCreationtime () {
return (UFDateTime) this.getAttributeValue( DocProperty.CREATIONTIME);
 } 

/** 
* 设置创建时间
*
* @param creationtime 创建时间
*/
public void setCreationtime ( UFDateTime creationtime) {
this.setAttributeValue( DocProperty.CREATIONTIME,creationtime);
 } 

/** 
* 获取创建人
*
* @return 创建人
*/
public String getCreator () {
return (String) this.getAttributeValue( DocProperty.CREATOR);
 } 

/** 
* 设置创建人
*
* @param creator 创建人
*/
public void setCreator ( String creator) {
this.setAttributeValue( DocProperty.CREATOR,creator);
 } 

/** 
* 获取日期
*
* @return 日期
*/
public UFDate getDbilldate () {
return this.dbilldate;
 } 

/** 
* 设置日期
*
* @param dbilldate 日期
*/
public void setDbilldate ( UFDate dbilldate) {
this.dbilldate=dbilldate;
 } 

/** 
* 获取上传日期
*
* @return 上传日期
*/
public UFDate getDcreatedate () {
return this.dcreatedate;
 } 

/** 
* 设置上传日期
*
* @param dcreatedate 上传日期
*/
public void setDcreatedate ( UFDate dcreatedate) {
this.dcreatedate=dcreatedate;
 } 

/** 
* 获取自定义项1
*
* @return 自定义项1
*/
public String getDef1 () {
return this.def1;
 } 

/** 
* 设置自定义项1
*
* @param def1 自定义项1
*/
public void setDef1 ( String def1) {
this.def1=def1;
 } 

/** 
* 获取自定义项10
*
* @return 自定义项10
*/
public String getDef10 () {
return this.def10;
 } 

/** 
* 设置自定义项10
*
* @param def10 自定义项10
*/
public void setDef10 ( String def10) {
this.def10=def10;
 } 

/** 
* 获取自定义项11
*
* @return 自定义项11
*/
public String getDef11 () {
return this.def11;
 } 

/** 
* 设置自定义项11
*
* @param def11 自定义项11
*/
public void setDef11 ( String def11) {
this.def11=def11;
 } 

/** 
* 获取自定义项12
*
* @return 自定义项12
*/
public String getDef12 () {
return this.def12;
 } 

/** 
* 设置自定义项12
*
* @param def12 自定义项12
*/
public void setDef12 ( String def12) {
this.def12=def12;
 } 

/** 
* 获取自定义项13
*
* @return 自定义项13
*/
public String getDef13 () {
return this.def13;
 } 

/** 
* 设置自定义项13
*
* @param def13 自定义项13
*/
public void setDef13 ( String def13) {
this.def13=def13;
 } 

/** 
* 获取自定义项14
*
* @return 自定义项14
*/
public String getDef14 () {
return this.def14;
 } 

/** 
* 设置自定义项14
*
* @param def14 自定义项14
*/
public void setDef14 ( String def14) {
this.def14=def14;
 } 

/** 
* 获取自定义项15
*
* @return 自定义项15
*/
public String getDef15 () {
return this.def15;
 } 

/** 
* 设置自定义项15
*
* @param def15 自定义项15
*/
public void setDef15 ( String def15) {
this.def15=def15;
 } 

/** 
* 获取自定义项16
*
* @return 自定义项16
*/
public String getDef16 () {
return this.def16;
 } 

/** 
* 设置自定义项16
*
* @param def16 自定义项16
*/
public void setDef16 ( String def16) {
this.def16=def16;
 } 

/** 
* 获取自定义项17
*
* @return 自定义项17
*/
public String getDef17 () {
return this.def17;
 } 

/** 
* 设置自定义项17
*
* @param def17 自定义项17
*/
public void setDef17 ( String def17) {
this.def17=def17;
 } 

/** 
* 获取自定义项18
*
* @return 自定义项18
*/
public String getDef18 () {
return this.def18;
 } 

/** 
* 设置自定义项18
*
* @param def18 自定义项18
*/
public void setDef18 ( String def18) {
this.def18=def18;
 } 

/** 
* 获取自定义项19
*
* @return 自定义项19
*/
public String getDef19 () {
return this.def19;
 } 

/** 
* 设置自定义项19
*
* @param def19 自定义项19
*/
public void setDef19 ( String def19) {
this.def19=def19;
 } 

/** 
* 获取自定义项2
*
* @return 自定义项2
*/
public String getDef2 () {
return this.def2;
 } 

/** 
* 设置自定义项2
*
* @param def2 自定义项2
*/
public void setDef2 ( String def2) {
this.def2=def2;
 } 

/** 
* 获取自定义项20
*
* @return 自定义项20
*/
public String getDef20 () {
return this.def20;
 } 

/** 
* 设置自定义项20
*
* @param def20 自定义项20
*/
public void setDef20 ( String def20) {
this.def20=def20;
 } 

/** 
* 获取自定义项3
*
* @return 自定义项3
*/
public String getDef3 () {
return this.def3;
 } 

/** 
* 设置自定义项3
*
* @param def3 自定义项3
*/
public void setDef3 ( String def3) {
this.def3=def3;
 } 

/** 
* 获取自定义项4
*
* @return 自定义项4
*/
public String getDef4 () {
return this.def4;
 } 

/** 
* 设置自定义项4
*
* @param def4 自定义项4
*/
public void setDef4 ( String def4) {
this.def4=def4;
 } 

/** 
* 获取自定义项5
*
* @return 自定义项5
*/
public String getDef5 () {
return this.def5;
 } 

/** 
* 设置自定义项5
*
* @param def5 自定义项5
*/
public void setDef5 ( String def5) {
this.def5=def5;
 } 

/** 
* 获取自定义项6
*
* @return 自定义项6
*/
public String getDef6 () {
return this.def6;
 } 

/** 
* 设置自定义项6
*
* @param def6 自定义项6
*/
public void setDef6 ( String def6) {
this.def6=def6;
 } 

/** 
* 获取自定义项7
*
* @return 自定义项7
*/
public String getDef7 () {
return this.def7;
 } 

/** 
* 设置自定义项7
*
* @param def7 自定义项7
*/
public void setDef7 ( String def7) {
this.def7=def7;
 } 

/** 
* 获取自定义项8
*
* @return 自定义项8
*/
public String getDef8 () {
return this.def8;
 } 

/** 
* 设置自定义项8
*
* @param def8 自定义项8
*/
public void setDef8 ( String def8) {
this.def8=def8;
 } 

/** 
* 获取自定义项9
*
* @return 自定义项9
*/
public String getDef9 () {
return this.def9;
 } 

/** 
* 设置自定义项9
*
* @param def9 自定义项9
*/
public void setDef9 ( String def9) {
this.def9=def9;
 } 

/** 
* 获取解决时间
*
* @return 解决时间
*/
public UFDateTime getDonetime () {
return this.donetime;
 } 

/** 
* 设置解决时间
*
* @param donetime 解决时间
*/
public void setDonetime ( UFDateTime donetime) {
this.donetime=donetime;
 } 

/** 
* 获取文件大小
*
* @return 文件大小
*/
public Integer getFilelength () {
return (Integer) this.getAttributeValue( DocProperty.FILELENGTH);
 } 

/** 
* 设置文件大小
*
* @param filelength 文件大小
*/
public void setFilelength ( Integer filelength) {
this.setAttributeValue( DocProperty.FILELENGTH,filelength);
 } 

/** 
* 获取存储路径
*
* @return 存储路径
*/
public String getFilepath () {
return this.filepath;
 } 

/** 
* 设置存储路径
*
* @param filepath 存储路径
*/
public void setFilepath ( String filepath) {
this.filepath=filepath;
 } 

/** 
* 获取文档类型
*
* @return 文档类型
*/
public String getFiletype () {
return (String) this.getAttributeValue( DocProperty.FILETYPE);
 } 

/** 
* 设置文档类型
*
* @param filetype 文档类型
*/
public void setFiletype ( String filetype) {
this.setAttributeValue( DocProperty.FILETYPE,filetype);
 } 

/** 
* 获取审批状态
*
* @return 审批状态
* @see String
*/
public Integer getFstatusflag () {
return this.fstatusflag;
 } 

/** 
* 设置审批状态
*
* @param fstatusflag 审批状态
* @see String
*/
public void setFstatusflag ( Integer fstatusflag) {
this.fstatusflag=fstatusflag;
 } 

/** 
* 获取已解决
*
* @return 已解决
*/
public UFBoolean getIsdone () {
return this.isdone;
 } 

/** 
* 设置已解决
*
* @param isdone 已解决
*/
public void setIsdone ( UFBoolean isdone) {
this.isdone=isdone;
 } 

/** 
* 获取需解决
*
* @return 需解决
*/
public UFBoolean getIsneed () {
return this.isneed;
 } 

/** 
* 设置需解决
*
* @param isneed 需解决
*/
public void setIsneed ( UFBoolean isneed) {
this.isneed=isneed;
 } 

/** 
* 获取修改时间
*
* @return 修改时间
*/
public UFDateTime getModifiedtime () {
return (UFDateTime) this.getAttributeValue( DocProperty.MODIFIEDTIME);
 } 

/** 
* 设置修改时间
*
* @param modifiedtime 修改时间
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.setAttributeValue( DocProperty.MODIFIEDTIME,modifiedtime);
 } 

/** 
* 获取修改人
*
* @return 修改人
*/
public String getModifier () {
return (String) this.getAttributeValue( DocProperty.MODIFIER);
 } 

/** 
* 设置修改人
*
* @param modifier 修改人
*/
public void setModifier ( String modifier) {
this.setAttributeValue( DocProperty.MODIFIER,modifier);
 } 

/** 
* 获取主键
*
* @return 主键
*/
public String getPk_docid () {
return this.pk_docid;
 } 

/** 
* 设置主键
*
* @param pk_docid 主键
*/
public void setPk_docid ( String pk_docid) {
this.pk_docid=pk_docid;
 } 

/** 
* 获取pk_doctype
*
* @return pk_doctype
*/
public String getPk_doctype () {
return (String) this.getAttributeValue( DocProperty.PK_DOCTYPE);
 } 

/** 
* 设置pk_doctype
*
* @param pk_doctype pk_doctype
*/
public void setPk_doctype ( String pk_doctype) {
this.setAttributeValue( DocProperty.PK_DOCTYPE,pk_doctype);
 } 

/** 
* 获取集团
*
* @return 集团
*/
public String getPk_group () {
return (String) this.getAttributeValue( DocProperty.PK_GROUP);
 } 

/** 
* 设置集团
*
* @param pk_group 集团
*/
public void setPk_group ( String pk_group) {
this.setAttributeValue( DocProperty.PK_GROUP,pk_group);
 } 

/** 
* 获取组织
*
* @return 组织
*/
public String getPk_org () {
return (String) this.getAttributeValue( DocProperty.PK_ORG);
 } 

/** 
* 设置组织
*
* @param pk_org 组织
*/
public void setPk_org ( String pk_org) {
this.setAttributeValue( DocProperty.PK_ORG,pk_org);
 } 

/** 
* 获取组织版本
*
* @return 组织版本
*/
public String getPk_org_v () {
return (String) this.getAttributeValue( DocProperty.PK_ORG_V);
 } 

/** 
* 设置组织版本
*
* @param pk_org_v 组织版本
*/
public void setPk_org_v ( String pk_org_v) {
this.setAttributeValue( DocProperty.PK_ORG_V,pk_org_v);
 } 

/** 
* 获取项目
*
* @return 项目
*/
public String getPk_project () {
return (String) this.getAttributeValue( DocProperty.PK_PROJECT);
 } 

/** 
* 设置项目
*
* @param pk_project 项目
*/
public void setPk_project ( String pk_project) {
this.setAttributeValue( DocProperty.PK_PROJECT,pk_project);
 } 

/** 
* 获取上传人
*
* @return 上传人
*/
public String getPk_uploader () {
return this.pk_uploader;
 } 

/** 
* 设置上传人
*
* @param pk_uploader 上传人
*/
public void setPk_uploader ( String pk_uploader) {
this.pk_uploader=pk_uploader;
 } 

/** 
* 获取解决方法
*
* @return 解决方法
*/
public String getSolution () {
return this.solution;
 } 

/** 
* 设置解决方法
*
* @param solution 解决方法
*/
public void setSolution ( String solution) {
this.solution=solution;
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
* 获取单据号
*
* @return 单据号
*/
public String getVbillcode () {
return this.vbillcode;
 } 

/** 
* 设置单据号
*
* @param vbillcode 单据号
*/
public void setVbillcode ( String vbillcode) {
this.vbillcode=vbillcode;
 } 

/** 
* 获取关键字
*
* @return 关键字
*/
public String getVkeyword () {
return (String) this.getAttributeValue( DocProperty.VKEYWORD);
 } 

/** 
* 设置关键字
*
* @param vkeyword 关键字
*/
public void setVkeyword ( String vkeyword) {
this.setAttributeValue( DocProperty.VKEYWORD,vkeyword);
 } 

/** 
* 获取文件名称
*
* @return 文件名称
*/
public String getVname () {
return (String) this.getAttributeValue( DocProperty.VNAME);
 } 

/** 
* 设置文件名称
*
* @param vname 文件名称
*/
public void setVname ( String vname) {
this.setAttributeValue( DocProperty.VNAME,vname);
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
    return VOMetaFactory.getInstance().getVOMeta("docmng.DocProperty");
  }
}