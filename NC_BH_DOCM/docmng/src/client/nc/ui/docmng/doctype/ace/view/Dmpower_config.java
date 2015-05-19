package nc.ui.docmng.doctype.ace.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class Dmpower_config extends AbstractJavaBeanDefinition{
	private Map<String, Object> context = new HashMap();
public nc.vo.uif2.LoginContext getContext(){
 if(context.get("context")!=null)
 return (nc.vo.uif2.LoginContext)context.get("context");
  nc.vo.uif2.LoginContext bean = new nc.vo.uif2.LoginContext();
  context.put("context",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.QueryAreaShell getQueryAreaShell(){
 if(context.get("queryAreaShell")!=null)
 return (nc.ui.uif2.actions.QueryAreaShell)context.get("queryAreaShell");
  nc.ui.uif2.actions.QueryAreaShell bean = new nc.ui.uif2.actions.QueryAreaShell();
  context.put("queryAreaShell",bean);
  bean.setQueryArea(getQueryAction_created_12536ee());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.queryarea.QueryArea getQueryAction_created_12536ee(){
 if(context.get("queryAction.created#12536ee")!=null)
 return (nc.ui.queryarea.QueryArea)context.get("queryAction.created#12536ee");
  nc.ui.queryarea.QueryArea bean = getQueryAction().createQueryArea();
  context.put("queryAction.created#12536ee",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.QueryTemplateContainer getQueryTemplateContainer(){
 if(context.get("queryTemplateContainer")!=null)
 return (nc.ui.uif2.editor.QueryTemplateContainer)context.get("queryTemplateContainer");
  nc.ui.uif2.editor.QueryTemplateContainer bean = new nc.ui.uif2.editor.QueryTemplateContainer();
  context.put("queryTemplateContainer",bean);
  bean.setContext(getContext());
  bean.setNodeKey("respquery");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller getRemoteCallCombinatorCaller(){
 if(context.get("remoteCallCombinatorCaller")!=null)
 return (nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller)context.get("remoteCallCombinatorCaller");
  nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller bean = new nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller();
  context.put("remoteCallCombinatorCaller",bean);
  bean.setRemoteCallers(getManagedList0());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList0(){  List list = new ArrayList();  list.add((nc.vo.util.remotecallcombination.IRemoteCallCombinatorUser)findBeanInUIF2BeanFactory("templateContainer"));  list.add(getQueryTemplateContainer());  return list;}

public nc.ui.uif2.TangramContainer getContainer(){
 if(context.get("container")!=null)
 return (nc.ui.uif2.TangramContainer)context.get("container");
  nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
  context.put("container",bean);
  bean.setTangramLayoutRoot(getTBNode_2433c());
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("respAppModel"));
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_2433c(){
 if(context.get("nc.ui.uif2.tangramlayout.node.TBNode#2433c")!=null)
 return (nc.ui.uif2.tangramlayout.node.TBNode)context.get("nc.ui.uif2.tangramlayout.node.TBNode#2433c");
  nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
  context.put("nc.ui.uif2.tangramlayout.node.TBNode#2433c",bean);
  bean.setTabs(getManagedList1());
  bean.setName("");
  bean.setShowMode("CardLayout");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList1(){  List list = new ArrayList();  list.add(getHSNode_14fe037());  list.add(getVSNode_a8982d());  return list;}

private nc.ui.uif2.tangramlayout.node.HSNode getHSNode_14fe037(){
 if(context.get("nc.ui.uif2.tangramlayout.node.HSNode#14fe037")!=null)
 return (nc.ui.uif2.tangramlayout.node.HSNode)context.get("nc.ui.uif2.tangramlayout.node.HSNode#14fe037");
  nc.ui.uif2.tangramlayout.node.HSNode bean = new nc.ui.uif2.tangramlayout.node.HSNode();
  context.put("nc.ui.uif2.tangramlayout.node.HSNode#14fe037",bean);
  bean.setName(getI18nFB_1baac9f());
  bean.setLeft(getCNode_1d72262());
  bean.setRight(getCNode_1eaff73());
  bean.setDividerLocation(0.2f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1baac9f(){
 if(context.get("nc.ui.uif2.I18nFB#1baac9f")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1baac9f");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1baac9f",bean);  bean.setResDir("10120ROLM");
  bean.setResId("UC001-0000107");
  bean.setDefaultValue("列表");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1baac9f",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1d72262(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1d72262")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1d72262");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1d72262",bean);
  bean.setComponent(getQueryAreaShell());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1eaff73(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1eaff73")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1eaff73");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1eaff73",bean);
  bean.setComponent((java.lang.Object)findBeanInUIF2BeanFactory("respListView"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_a8982d(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#a8982d")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#a8982d");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#a8982d",bean);
  bean.setName(getI18nFB_16f7f15());
  bean.setUp(getCNode_1518368());
  bean.setDown(getTBNode_3e0da8());
  bean.setDividerLocation(200.0f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_16f7f15(){
 if(context.get("nc.ui.uif2.I18nFB#16f7f15")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#16f7f15");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#16f7f15",bean);  bean.setResDir("10120ROLM");
  bean.setResId("UC001-0000106");
  bean.setDefaultValue("卡片");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#16f7f15",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1518368(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1518368")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1518368");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1518368",bean);
  bean.setComponent((java.lang.Object)findBeanInUIF2BeanFactory("respEditor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_3e0da8(){
 if(context.get("nc.ui.uif2.tangramlayout.node.TBNode#3e0da8")!=null)
 return (nc.ui.uif2.tangramlayout.node.TBNode)context.get("nc.ui.uif2.tangramlayout.node.TBNode#3e0da8");
  nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
  context.put("nc.ui.uif2.tangramlayout.node.TBNode#3e0da8",bean);
  bean.setTabs(getManagedList2());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList2(){  List list = new ArrayList();  list.add(getCNode_1e2e496());  list.add(getCNode_3228a8());  return list;}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1e2e496(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1e2e496")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1e2e496");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1e2e496",bean);
  bean.setName(getI18nFB_17ce016());
  bean.setComponent((java.lang.Object)findBeanInUIF2BeanFactory("funcTreePanel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_17ce016(){
 if(context.get("nc.ui.uif2.I18nFB#17ce016")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#17ce016");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#17ce016",bean);  bean.setResDir("10120RESPADMIN");
  bean.setResId("010120RESPADMIN0006");
  bean.setDefaultValue("功能设置");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#17ce016",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_3228a8(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#3228a8")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#3228a8");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#3228a8",bean);
  bean.setName(getI18nFB_15faca8());
  bean.setComponent((java.lang.Object)findBeanInUIF2BeanFactory("respRelateRoleTable"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_15faca8(){
 if(context.get("nc.ui.uif2.I18nFB#15faca8")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#15faca8");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#15faca8",bean);  bean.setResDir("10120RESPADMIN");
  bean.setResId("010120RESPADMIN00010");
  bean.setDefaultValue("关联角色");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#15faca8",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.uif2.actions.ActionContributors getToftpanelActionContributors(){
 if(context.get("toftpanelActionContributors")!=null)
 return (nc.ui.uif2.actions.ActionContributors)context.get("toftpanelActionContributors");
  nc.ui.uif2.actions.ActionContributors bean = new nc.ui.uif2.actions.ActionContributors();
  context.put("toftpanelActionContributors",bean);
  bean.setContributors(getManagedList3());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList3(){  List list = new ArrayList();  list.add(getActionsOfList());  list.add(getActionsOfCard());  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfList(){
 if(context.get("actionsOfList")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfList");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer((nc.ui.uif2.components.ITabbedPaneAwareComponent)findBeanInUIF2BeanFactory("respListView"));  context.put("actionsOfList",bean);
  bean.setActions(getManagedList4());
  bean.setEditActions(getManagedList5());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList4(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("addAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("editAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("deleteAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("seperatorAction"));  list.add(getQueryAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("refreshAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("seperatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("createRoleAction"));  return list;}

private List getManagedList5(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("saveAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("saveAddAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("seperatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("cancelAction"));  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfCard(){
 if(context.get("actionsOfCard")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfCard");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer((nc.ui.uif2.components.ITabbedPaneAwareComponent)findBeanInUIF2BeanFactory("respEditor"));  context.put("actionsOfCard",bean);
  bean.setActions(getManagedList6());
  bean.setEditActions(getManagedList7());
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("respAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList6(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("addAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("editAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("deleteAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("seperatorAction"));  list.add(getQueryAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("refreshAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("seperatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("funcAssignAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("createRoleAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("importFuncAction"));  return list;}

private List getManagedList7(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("saveAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("saveAddAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("seperatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("cancelAction"));  return list;}

public nc.ui.uif2.actions.QueryAction getQueryAction(){
 if(context.get("queryAction")!=null)
 return (nc.ui.uif2.actions.QueryAction)context.get("queryAction");
  nc.ui.uif2.actions.QueryAction bean = new nc.ui.uif2.actions.QueryAction();
  context.put("queryAction",bean);
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("respAppModel"));
  bean.setDataManager((nc.ui.uif2.model.IQueryAndRefreshManager)findBeanInUIF2BeanFactory("modelDataManager"));
  bean.setTemplateContainer(getQueryTemplateContainer());
  bean.setExceptionHandler((nc.ui.uif2.IExceptionHandler)findBeanInUIF2BeanFactory("exceptionHandler"));
  bean.setQueryDelegator(getRbacQueryDelegator_636849());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uap.rbac.usermanage.actions.RbacQueryDelegator getRbacQueryDelegator_636849(){
 if(context.get("nc.ui.uap.rbac.usermanage.actions.RbacQueryDelegator#636849")!=null)
 return (nc.ui.uap.rbac.usermanage.actions.RbacQueryDelegator)context.get("nc.ui.uap.rbac.usermanage.actions.RbacQueryDelegator#636849");
  nc.ui.uap.rbac.usermanage.actions.RbacQueryDelegator bean = new nc.ui.uap.rbac.usermanage.actions.RbacQueryDelegator();
  context.put("nc.ui.uap.rbac.usermanage.actions.RbacQueryDelegator#636849",bean);
  bean.setContext(getContext());
  bean.setNodeKey("respquery");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

}
