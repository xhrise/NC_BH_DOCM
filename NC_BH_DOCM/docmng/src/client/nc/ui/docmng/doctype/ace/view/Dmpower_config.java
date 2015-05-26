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

public nc.ui.docmng.docpower.ace.serviceproxy.PowerModelService getPowerModelService(){
 if(context.get("powerModelService")!=null)
 return (nc.ui.docmng.docpower.ace.serviceproxy.PowerModelService)context.get("powerModelService");
  nc.ui.docmng.docpower.ace.serviceproxy.PowerModelService bean = new nc.ui.docmng.docpower.ace.serviceproxy.PowerModelService();
  context.put("powerModelService",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.vo.bd.meta.GeneralBDObjectAdapterFactory getBOAdapterFactory(){
 if(context.get("BOAdapterFactory")!=null)
 return (nc.vo.bd.meta.GeneralBDObjectAdapterFactory)context.get("BOAdapterFactory");
  nc.vo.bd.meta.GeneralBDObjectAdapterFactory bean = new nc.vo.bd.meta.GeneralBDObjectAdapterFactory();
  context.put("BOAdapterFactory",bean);
  bean.setMode("MD");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.doctype.ace.model.BusiPowerItemBDObjectAdaptorFactory getBusinessObjectAdapterFactory(){
 if(context.get("businessObjectAdapterFactory")!=null)
 return (nc.ui.docmng.doctype.ace.model.BusiPowerItemBDObjectAdaptorFactory)context.get("businessObjectAdapterFactory");
  nc.ui.docmng.doctype.ace.model.BusiPowerItemBDObjectAdaptorFactory bean = new nc.ui.docmng.doctype.ace.model.BusiPowerItemBDObjectAdaptorFactory();
  context.put("businessObjectAdapterFactory",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.doctype.ace.view.BusiItemTreeCreateStrategy getBusiItemTreeCreateStrategy(){
 if(context.get("busiItemTreeCreateStrategy")!=null)
 return (nc.ui.docmng.doctype.ace.view.BusiItemTreeCreateStrategy)context.get("busiItemTreeCreateStrategy");
  nc.ui.docmng.doctype.ace.view.BusiItemTreeCreateStrategy bean = new nc.ui.docmng.doctype.ace.view.BusiItemTreeCreateStrategy();
  context.put("busiItemTreeCreateStrategy",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.model.BillManageModel getModel(){
 if(context.get("model")!=null)
 return (nc.ui.uif2.model.BillManageModel)context.get("model");
  nc.ui.uif2.model.BillManageModel bean = new nc.ui.uif2.model.BillManageModel();
  context.put("model",bean);
  bean.setContext(getContext());
  bean.setService(getPowerModelService());
  bean.setBusinessObjectAdapterFactory(getBOAdapterFactory());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.doctype.ace.model.DetailTreeModel getDetailTreeModel(){
 if(context.get("detailTreeModel")!=null)
 return (nc.ui.docmng.doctype.ace.model.DetailTreeModel)context.get("detailTreeModel");
  nc.ui.docmng.doctype.ace.model.DetailTreeModel bean = new nc.ui.docmng.doctype.ace.model.DetailTreeModel();
  context.put("detailTreeModel",bean);
  bean.setContext(getContext());
  bean.setTreeCreateStrategy(getBusiItemTreeCreateStrategy());
  bean.setBusinessObjectAdapterFactory(getBusinessObjectAdapterFactory());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.components.pagination.PaginationModel getPaginationModel(){
 if(context.get("paginationModel")!=null)
 return (nc.ui.uif2.components.pagination.PaginationModel)context.get("paginationModel");
  nc.ui.uif2.components.pagination.PaginationModel bean = new nc.ui.uif2.components.pagination.PaginationModel();
  context.put("paginationModel",bean);
  bean.init();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.components.pagination.BillManagePaginationDelegator getPaginationDelegator(){
 if(context.get("paginationDelegator")!=null)
 return (nc.ui.uif2.components.pagination.BillManagePaginationDelegator)context.get("paginationDelegator");
  nc.ui.uif2.components.pagination.BillManagePaginationDelegator bean = new nc.ui.uif2.components.pagination.BillManagePaginationDelegator(getModel(),getPaginationModel());  context.put("paginationDelegator",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.docpower.modelmanage.PowerModelDataManager getModelDataManager(){
 if(context.get("modelDataManager")!=null)
 return (nc.ui.docmng.docpower.modelmanage.PowerModelDataManager)context.get("modelDataManager");
  nc.ui.docmng.docpower.modelmanage.PowerModelDataManager bean = new nc.ui.docmng.docpower.modelmanage.PowerModelDataManager();
  context.put("modelDataManager",bean);
  bean.setModel(getModel());
  bean.setPaginationModel(getPaginationModel());
  bean.setPaginationDelegator(getPaginationDelegator());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.doctype.ace.model.ModelAndTreeModelMediator getRespAndRespFuncMediator(){
 if(context.get("respAndRespFuncMediator")!=null)
 return (nc.ui.docmng.doctype.ace.model.ModelAndTreeModelMediator)context.get("respAndRespFuncMediator");
  nc.ui.docmng.doctype.ace.model.ModelAndTreeModelMediator bean = new nc.ui.docmng.doctype.ace.model.ModelAndTreeModelMediator();
  context.put("respAndRespFuncMediator",bean);
  bean.setModel(getModel());
  bean.setDetailTreeModel(getDetailTreeModel());
  bean.setDetailTreePanel(getDetailTreePanel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.TemplateContainer getTemplateContainer(){
 if(context.get("templateContainer")!=null)
 return (nc.ui.uif2.editor.TemplateContainer)context.get("templateContainer");
  nc.ui.uif2.editor.TemplateContainer bean = new nc.ui.uif2.editor.TemplateContainer();
  context.put("templateContainer",bean);
  bean.setContext(getContext());
  bean.setNodeKeies(getManagedList0());
  bean.load();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList0(){  List list = new ArrayList();  list.add("bt");  return list;}

public nc.ui.docmng.doctype.ace.view.PowerListView getPowerListView(){
 if(context.get("powerListView")!=null)
 return (nc.ui.docmng.doctype.ace.view.PowerListView)context.get("powerListView");
  nc.ui.docmng.doctype.ace.view.PowerListView bean = new nc.ui.docmng.doctype.ace.view.PowerListView();
  context.put("powerListView",bean);
  bean.setModel(getModel());
  bean.setMultiSelectionEnable(true);
  bean.setNodekey("bt");
  bean.setTemplateContainer(getTemplateContainer());
  bean.setSouth(getPaginationBar());
  bean.setNorth(getPowerToolBarPanel());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel getPowerToolBarPanel(){
 if(context.get("powerToolBarPanel")!=null)
 return (nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel)context.get("powerToolBarPanel");
  nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel bean = new nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel();
  context.put("powerToolBarPanel",bean);
  bean.setModel(getModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.doctype.ace.view.PowerEditor getPowerEditor(){
 if(context.get("powerEditor")!=null)
 return (nc.ui.docmng.doctype.ace.view.PowerEditor)context.get("powerEditor");
  nc.ui.docmng.doctype.ace.view.PowerEditor bean = new nc.ui.docmng.doctype.ace.view.PowerEditor();
  context.put("powerEditor",bean);
  bean.setModel(getModel());
  bean.setNodekey("bt");
  bean.setTemplateContainer(getTemplateContainer());
  bean.setNorth(getEditortoolBarPanel());
  bean.setDetailTreeModel(getDetailTreeModel());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel getEditortoolBarPanel(){
 if(context.get("editortoolBarPanel")!=null)
 return (nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel)context.get("editortoolBarPanel");
  nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel bean = new nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel();
  context.put("editortoolBarPanel",bean);
  bean.setActions(getManagedList1());
  bean.setModel(getModel());
  bean.setTitleAction(getReturnAction());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList1(){  List list = new ArrayList();  list.add(getFirstlineAction());  list.add(getPrelineAction());  list.add(getNextlineAction());  list.add(getLastLineAction());  return list;}

public nc.ui.docmng.doctype.ace.view.DetailTreePanel getDetailTreePanel(){
 if(context.get("detailTreePanel")!=null)
 return (nc.ui.docmng.doctype.ace.view.DetailTreePanel)context.get("detailTreePanel");
  nc.ui.docmng.doctype.ace.view.DetailTreePanel bean = new nc.ui.docmng.doctype.ace.view.DetailTreePanel();
  context.put("detailTreePanel",bean);
  bean.setModel(getDetailTreeModel());
  bean.setNodekey("btitem");
  bean.setActions(getManagedList2());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList2(){  List list = new ArrayList();  list.add(getAssignAction());  list.add(getDetailTreeRefreshAction());  return list;}

public nc.ui.uif2.actions.QueryAreaShell getQueryAreaShell(){
 if(context.get("queryAreaShell")!=null)
 return (nc.ui.uif2.actions.QueryAreaShell)context.get("queryAreaShell");
  nc.ui.uif2.actions.QueryAreaShell bean = new nc.ui.uif2.actions.QueryAreaShell();
  context.put("queryAreaShell",bean);
  bean.setQueryArea(getQueryAction_created_12039a4());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.queryarea.QueryArea getQueryAction_created_12039a4(){
 if(context.get("queryAction.created#12039a4")!=null)
 return (nc.ui.queryarea.QueryArea)context.get("queryAction.created#12039a4");
  nc.ui.queryarea.QueryArea bean = getQueryAction().createQueryArea();
  context.put("queryAction.created#12039a4",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.components.pagination.PaginationBar getPaginationBar(){
 if(context.get("paginationBar")!=null)
 return (nc.ui.uif2.components.pagination.PaginationBar)context.get("paginationBar");
  nc.ui.uif2.components.pagination.PaginationBar bean = new nc.ui.uif2.components.pagination.PaginationBar();
  context.put("paginationBar",bean);
  bean.setPaginationModel(getPaginationModel());
  bean.setContext(getContext());
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
  bean.setNodeKey("qt");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller getRemoteCallCombinatorCaller(){
 if(context.get("remoteCallCombinatorCaller")!=null)
 return (nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller)context.get("remoteCallCombinatorCaller");
  nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller bean = new nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller();
  context.put("remoteCallCombinatorCaller",bean);
  bean.setRemoteCallers(getManagedList3());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList3(){  List list = new ArrayList();  list.add(getTemplateContainer());  list.add(getQueryTemplateContainer());  return list;}

public nc.ui.uif2.TangramContainer getContainer(){
 if(context.get("container")!=null)
 return (nc.ui.uif2.TangramContainer)context.get("container");
  nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
  context.put("container",bean);
  bean.setTangramLayoutRoot(getTBNode_cdc74a());
  bean.setModel(getModel());
  bean.setActions(getManagedList6());
  bean.setEditActions(getManagedList7());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_cdc74a(){
 if(context.get("nc.ui.uif2.tangramlayout.node.TBNode#cdc74a")!=null)
 return (nc.ui.uif2.tangramlayout.node.TBNode)context.get("nc.ui.uif2.tangramlayout.node.TBNode#cdc74a");
  nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
  context.put("nc.ui.uif2.tangramlayout.node.TBNode#cdc74a",bean);
  bean.setTabs(getManagedList4());
  bean.setName("");
  bean.setShowMode("CardLayout");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList4(){  List list = new ArrayList();  list.add(getHSNode_1ea024());  list.add(getVSNode_12cae49());  return list;}

private nc.ui.uif2.tangramlayout.node.HSNode getHSNode_1ea024(){
 if(context.get("nc.ui.uif2.tangramlayout.node.HSNode#1ea024")!=null)
 return (nc.ui.uif2.tangramlayout.node.HSNode)context.get("nc.ui.uif2.tangramlayout.node.HSNode#1ea024");
  nc.ui.uif2.tangramlayout.node.HSNode bean = new nc.ui.uif2.tangramlayout.node.HSNode();
  context.put("nc.ui.uif2.tangramlayout.node.HSNode#1ea024",bean);
  bean.setName(getI18nFB_1664389());
  bean.setLeft(getCNode_1574570());
  bean.setRight(getCNode_4b5110());
  bean.setDividerLocation(0.2f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1664389(){
 if(context.get("nc.ui.uif2.I18nFB#1664389")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1664389");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1664389",bean);  bean.setResDir("10120ROLM");
  bean.setResId("UC001-0000107");
  bean.setDefaultValue("列表");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1664389",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1574570(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1574570")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1574570");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1574570",bean);
  bean.setComponent(getQueryAreaShell());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_4b5110(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#4b5110")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#4b5110");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#4b5110",bean);
  bean.setComponent(getPowerListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_12cae49(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#12cae49")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#12cae49");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#12cae49",bean);
  bean.setName(getI18nFB_173c325());
  bean.setUp(getCNode_86afe());
  bean.setDown(getTBNode_b47afb());
  bean.setDividerLocation(200.0f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_173c325(){
 if(context.get("nc.ui.uif2.I18nFB#173c325")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#173c325");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#173c325",bean);  bean.setResDir("10120ROLM");
  bean.setResId("UC001-0000106");
  bean.setDefaultValue("卡片");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#173c325",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_86afe(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#86afe")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#86afe");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#86afe",bean);
  bean.setComponent(getPowerEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_b47afb(){
 if(context.get("nc.ui.uif2.tangramlayout.node.TBNode#b47afb")!=null)
 return (nc.ui.uif2.tangramlayout.node.TBNode)context.get("nc.ui.uif2.tangramlayout.node.TBNode#b47afb");
  nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
  context.put("nc.ui.uif2.tangramlayout.node.TBNode#b47afb",bean);
  bean.setTabs(getManagedList5());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList5(){  List list = new ArrayList();  list.add(getCNode_1c3e94d());  return list;}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1c3e94d(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1c3e94d")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1c3e94d");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1c3e94d",bean);
  bean.setName(getI18nFB_bd68be());
  bean.setComponent(getDetailTreePanel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_bd68be(){
 if(context.get("nc.ui.uif2.I18nFB#bd68be")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#bd68be");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#bd68be",bean);  bean.setResDir("10120RESPADMIN");
  bean.setResId("010120RESPADMIN0006");
  bean.setDefaultValue("功能设置");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#bd68be",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList6(){  List list = new ArrayList();  list.add(getAddAction());  list.add(getEditAction());  list.add(getDeleteAction());  list.add(getSeperatorAction());  list.add(getQueryAction());  list.add(getRefreshAction());  list.add(getSeperatorAction());  return list;}

private List getManagedList7(){  List list = new ArrayList();  list.add(getSaveAction());  list.add(getSaveAddAction());  list.add(getSeperatorAction());  list.add(getCancelAction());  return list;}

public nc.ui.uif2.actions.FirstLineAction getFirstlineAction(){
 if(context.get("firstlineAction")!=null)
 return (nc.ui.uif2.actions.FirstLineAction)context.get("firstlineAction");
  nc.ui.uif2.actions.FirstLineAction bean = new nc.ui.uif2.actions.FirstLineAction();
  context.put("firstlineAction",bean);
  bean.setModel(getModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.PreLineAction getPrelineAction(){
 if(context.get("prelineAction")!=null)
 return (nc.ui.uif2.actions.PreLineAction)context.get("prelineAction");
  nc.ui.uif2.actions.PreLineAction bean = new nc.ui.uif2.actions.PreLineAction();
  context.put("prelineAction",bean);
  bean.setModel(getModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.NextLineAction getNextlineAction(){
 if(context.get("nextlineAction")!=null)
 return (nc.ui.uif2.actions.NextLineAction)context.get("nextlineAction");
  nc.ui.uif2.actions.NextLineAction bean = new nc.ui.uif2.actions.NextLineAction();
  context.put("nextlineAction",bean);
  bean.setModel(getModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.LastLineAction getLastLineAction(){
 if(context.get("lastLineAction")!=null)
 return (nc.ui.uif2.actions.LastLineAction)context.get("lastLineAction");
  nc.ui.uif2.actions.LastLineAction bean = new nc.ui.uif2.actions.LastLineAction();
  context.put("lastLineAction",bean);
  bean.setModel(getModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.ShowMeUpAction getReturnAction(){
 if(context.get("returnAction")!=null)
 return (nc.ui.uif2.actions.ShowMeUpAction)context.get("returnAction");
  nc.ui.uif2.actions.ShowMeUpAction bean = new nc.ui.uif2.actions.ShowMeUpAction();
  context.put("returnAction",bean);
  bean.setGoComponent(getPowerListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.docpower.actions.AddAction getAddAction(){
 if(context.get("addAction")!=null)
 return (nc.ui.docmng.docpower.actions.AddAction)context.get("addAction");
  nc.ui.docmng.docpower.actions.AddAction bean = new nc.ui.docmng.docpower.actions.AddAction();
  context.put("addAction",bean);
  bean.setModel(getModel());
  bean.setDetailTreeModel(getDetailTreeModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.EditAction getEditAction(){
 if(context.get("editAction")!=null)
 return (nc.ui.uif2.actions.EditAction)context.get("editAction");
  nc.ui.uif2.actions.EditAction bean = new nc.ui.uif2.actions.EditAction();
  context.put("editAction",bean);
  bean.setModel(getModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.DeleteAction getDeleteAction(){
 if(context.get("deleteAction")!=null)
 return (nc.ui.uif2.actions.DeleteAction)context.get("deleteAction");
  nc.ui.uif2.actions.DeleteAction bean = new nc.ui.uif2.actions.DeleteAction();
  context.put("deleteAction",bean);
  bean.setModel(getModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.docpower.actions.ListCardRefreshAction getRefreshAction(){
 if(context.get("refreshAction")!=null)
 return (nc.ui.docmng.docpower.actions.ListCardRefreshAction)context.get("refreshAction");
  nc.ui.docmng.docpower.actions.ListCardRefreshAction bean = new nc.ui.docmng.docpower.actions.ListCardRefreshAction();
  context.put("refreshAction",bean);
  bean.setModel(getModel());
  bean.setDataManager(getModelDataManager());
  bean.setCardEditor(getPowerEditor());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.SaveAction getSaveAction(){
 if(context.get("saveAction")!=null)
 return (nc.ui.uif2.actions.SaveAction)context.get("saveAction");
  nc.ui.uif2.actions.SaveAction bean = new nc.ui.uif2.actions.SaveAction();
  context.put("saveAction",bean);
  bean.setModel(getModel());
  bean.setEditor(getPowerEditor());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.SaveAddAction getSaveAddAction(){
 if(context.get("saveAddAction")!=null)
 return (nc.ui.uif2.actions.SaveAddAction)context.get("saveAddAction");
  nc.ui.uif2.actions.SaveAddAction bean = new nc.ui.uif2.actions.SaveAddAction();
  context.put("saveAddAction",bean);
  bean.setModel(getModel());
  bean.setAddAction(getAddAction());
  bean.setEditor(getPowerEditor());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.docpower.actions.CancelAction getCancelAction(){
 if(context.get("cancelAction")!=null)
 return (nc.ui.docmng.docpower.actions.CancelAction)context.get("cancelAction");
  nc.ui.docmng.docpower.actions.CancelAction bean = new nc.ui.docmng.docpower.actions.CancelAction();
  context.put("cancelAction",bean);
  bean.setModel(getModel());
  bean.setEditor(getPowerEditor());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.QueryAction getQueryAction(){
 if(context.get("queryAction")!=null)
 return (nc.ui.uif2.actions.QueryAction)context.get("queryAction");
  nc.ui.uif2.actions.QueryAction bean = new nc.ui.uif2.actions.QueryAction();
  context.put("queryAction",bean);
  bean.setModel(getModel());
  bean.setDataManager(getModelDataManager());
  bean.setTemplateContainer(getQueryTemplateContainer());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.docpower.actions.AssignAction getAssignAction(){
 if(context.get("assignAction")!=null)
 return (nc.ui.docmng.docpower.actions.AssignAction)context.get("assignAction");
  nc.ui.docmng.docpower.actions.AssignAction bean = new nc.ui.docmng.docpower.actions.AssignAction();
  context.put("assignAction",bean);
  bean.setModel(getModel());
  bean.setDetailTreeModel(getDetailTreeModel());
  bean.setDetailTreePanel(getDetailTreePanel());
  bean.setCode("AssignFunc");
  bean.setPowerEditor(getPowerEditor());
  bean.setShowNameInToolbar(true);
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.docpower.actions.DetailTreeRefreshAction getDetailTreeRefreshAction(){
 if(context.get("detailTreeRefreshAction")!=null)
 return (nc.ui.docmng.docpower.actions.DetailTreeRefreshAction)context.get("detailTreeRefreshAction");
  nc.ui.docmng.docpower.actions.DetailTreeRefreshAction bean = new nc.ui.docmng.docpower.actions.DetailTreeRefreshAction();
  context.put("detailTreeRefreshAction",bean);
  bean.setCode("DetailTreeRefreshAction");
  bean.setModel(getDetailTreeModel());
  bean.setDetailTreeModel(getDetailTreeModel());
  bean.setDetailTreePanel(getDetailTreePanel());
  bean.setAppModel(getModel());
  bean.setShowNameInToolbar(true);
  bean.setExceptionHandler(getExceptionHandler());
  bean.setNeedProgress(false);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.SeparatorAction getSeperatorAction(){
 if(context.get("seperatorAction")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("seperatorAction");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("seperatorAction",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.DefaultExceptionHanler getExceptionHandler(){
 if(context.get("exceptionHandler")!=null)
 return (nc.ui.uif2.DefaultExceptionHanler)context.get("exceptionHandler");
  nc.ui.uif2.DefaultExceptionHanler bean = new nc.ui.uif2.DefaultExceptionHanler();
  context.put("exceptionHandler",bean);
  bean.setContext(getContext());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

}
