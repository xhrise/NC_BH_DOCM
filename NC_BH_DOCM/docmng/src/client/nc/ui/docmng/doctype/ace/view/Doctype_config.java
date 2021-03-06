package nc.ui.docmng.doctype.ace.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class Doctype_config extends AbstractJavaBeanDefinition{
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

public nc.ui.docmng.doctype.ace.serviceproxy.AceDoctypeMaintainProxy getHModelModelService(){
 if(context.get("hModelModelService")!=null)
 return (nc.ui.docmng.doctype.ace.serviceproxy.AceDoctypeMaintainProxy)context.get("hModelModelService");
  nc.ui.docmng.doctype.ace.serviceproxy.AceDoctypeMaintainProxy bean = new nc.ui.docmng.doctype.ace.serviceproxy.AceDoctypeMaintainProxy();
  context.put("hModelModelService",bean);
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

public nc.vo.bd.meta.BDObjectTreeCreateStrategy getHModelTreeCreateStrategy(){
 if(context.get("hModelTreeCreateStrategy")!=null)
 return (nc.vo.bd.meta.BDObjectTreeCreateStrategy)context.get("hModelTreeCreateStrategy");
  nc.vo.bd.meta.BDObjectTreeCreateStrategy bean = new nc.vo.bd.meta.BDObjectTreeCreateStrategy();
  context.put("hModelTreeCreateStrategy",bean);
  bean.setFactory(getBOAdapterFactory());
  bean.setRootName("�ĵ�����");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.model.HierachicalDataAppModel getHModel(){
 if(context.get("hModel")!=null)
 return (nc.ui.pubapp.uif2app.model.HierachicalDataAppModel)context.get("hModel");
  nc.ui.pubapp.uif2app.model.HierachicalDataAppModel bean = new nc.ui.pubapp.uif2app.model.HierachicalDataAppModel();
  context.put("hModel",bean);
  bean.setContext(getContext());
  bean.setService(getHModelModelService());
  bean.setBusinessObjectAdapterFactory(getBOAdapterFactory());
  bean.setTreeCreateStrategy(getHModelTreeCreateStrategy());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.docmng.doctype.ace.serviceproxy.DoctypeModelDataManager getHModelModelDataManager(){
 if(context.get("hModelModelDataManager")!=null)
 return (nc.ui.docmng.doctype.ace.serviceproxy.DoctypeModelDataManager)context.get("hModelModelDataManager");
  nc.ui.docmng.doctype.ace.serviceproxy.DoctypeModelDataManager bean = new nc.ui.docmng.doctype.ace.serviceproxy.DoctypeModelDataManager();
  context.put("hModelModelDataManager",bean);
  bean.setModel(getHModel());
  bean.setService(getHModelModelService());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.TemplateContainer getTemplateContainer(){
 if(context.get("templateContainer")!=null)
 return (nc.ui.pubapp.uif2app.view.TemplateContainer)context.get("templateContainer");
  nc.ui.pubapp.uif2app.view.TemplateContainer bean = new nc.ui.pubapp.uif2app.view.TemplateContainer();
  context.put("templateContainer",bean);
  bean.setContext(getContext());
  bean.setNodeKeies(getManagedList0());
  bean.load();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList0(){  List list = new ArrayList();  list.add("bt");  return list;}

public nc.ui.uif2.components.TreePanel getTreePanel(){
 if(context.get("treePanel")!=null)
 return (nc.ui.uif2.components.TreePanel)context.get("treePanel");
  nc.ui.uif2.components.TreePanel bean = new nc.ui.uif2.components.TreePanel();
  context.put("treePanel",bean);
  bean.setModel(getHModel());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.OrgPanel getViewa(){
 if(context.get("viewa")!=null)
 return (nc.ui.pubapp.uif2app.view.OrgPanel)context.get("viewa");
  nc.ui.pubapp.uif2app.view.OrgPanel bean = new nc.ui.pubapp.uif2app.view.OrgPanel();
  context.put("viewa",bean);
  bean.setModel(getHModel());
  bean.setDataManager(getHModelModelDataManager());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.ShowUpableBillForm getBillForm(){
 if(context.get("billForm")!=null)
 return (nc.ui.pubapp.uif2app.view.ShowUpableBillForm)context.get("billForm");
  nc.ui.pubapp.uif2app.view.ShowUpableBillForm bean = new nc.ui.pubapp.uif2app.view.ShowUpableBillForm();
  context.put("billForm",bean);
  bean.setModel(getHModel());
  bean.setNodekey("bt");
  bean.setShowOrgPanel(false);
  bean.setComponentValueManager(getBillFormComponentValueManager());
  bean.setComponentVisible(true);
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.value.BillCardPanelHeadVOValueAdapter getBillFormComponentValueManager(){
 if(context.get("billFormComponentValueManager")!=null)
 return (nc.ui.uif2.editor.value.BillCardPanelHeadVOValueAdapter)context.get("billFormComponentValueManager");
  nc.ui.uif2.editor.value.BillCardPanelHeadVOValueAdapter bean = new nc.ui.uif2.editor.value.BillCardPanelHeadVOValueAdapter();
  context.put("billFormComponentValueManager",bean);
  bean.setHeadVOName("nc.vo.docmng.doctype.DocType");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.TangramContainer getContainer(){
 if(context.get("container")!=null)
 return (nc.ui.uif2.TangramContainer)context.get("container");
  nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
  context.put("container",bean);
  bean.setTangramLayoutRoot(getHSNode_15c60fb());
  bean.setActions(getManagedList1());
  bean.setEditActions(getManagedList2());
  bean.setModel(getHModel());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.HSNode getHSNode_15c60fb(){
 if(context.get("nc.ui.uif2.tangramlayout.node.HSNode#15c60fb")!=null)
 return (nc.ui.uif2.tangramlayout.node.HSNode)context.get("nc.ui.uif2.tangramlayout.node.HSNode#15c60fb");
  nc.ui.uif2.tangramlayout.node.HSNode bean = new nc.ui.uif2.tangramlayout.node.HSNode();
  context.put("nc.ui.uif2.tangramlayout.node.HSNode#15c60fb",bean);
  bean.setLeft(getCNode_1d3f641());
  bean.setRight(getVSNode_121e0a0());
  bean.setDividerLocation(151.0f);
  bean.setName("");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1d3f641(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1d3f641")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1d3f641");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1d3f641",bean);
  bean.setComponent(getTreePanel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_121e0a0(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#121e0a0")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#121e0a0");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#121e0a0",bean);
  bean.setUp(getCNode_e41ef8());
  bean.setDown(getCNode_34f7b3());
  bean.setDividerLocation(75.0f);
  bean.setName("");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_e41ef8(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#e41ef8")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#e41ef8");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#e41ef8",bean);
  bean.setComponent(getViewa());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_34f7b3(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#34f7b3")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#34f7b3");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#34f7b3",bean);
  bean.setComponent(getBillForm());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList1(){  List list = new ArrayList();  list.add(getAddAction());  list.add(getEditAction());  list.add(getDeleteAction());  list.add(getRefreshAction());  return list;}

private List getManagedList2(){  List list = new ArrayList();  list.add(getSaveAction());  list.add(getCancelAction());  return list;}

public nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener getInitDataListener(){
 if(context.get("InitDataListener")!=null)
 return (nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener)context.get("InitDataListener");
  nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener bean = new nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener();
  context.put("InitDataListener",bean);
  bean.setModel(getHModel());
  bean.setContext(getContext());
  bean.setVoClassName("nc.vo.docmng.doctype.DocType");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.common.validateservice.ClosingCheck getClosingListener(){
 if(context.get("ClosingListener")!=null)
 return (nc.ui.pubapp.common.validateservice.ClosingCheck)context.get("ClosingListener");
  nc.ui.pubapp.common.validateservice.ClosingCheck bean = new nc.ui.pubapp.common.validateservice.ClosingCheck();
  context.put("ClosingListener",bean);
  bean.setModel(getHModel());
  bean.setSaveAction(getSaveAction());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.model.AppEventHandlerMediator getHModelEventMediator(){
 if(context.get("hModelEventMediator")!=null)
 return (nc.ui.pubapp.uif2app.model.AppEventHandlerMediator)context.get("hModelEventMediator");
  nc.ui.pubapp.uif2app.model.AppEventHandlerMediator bean = new nc.ui.pubapp.uif2app.model.AppEventHandlerMediator();
  context.put("hModelEventMediator",bean);
  bean.setModel(getHModel());
  bean.setHandlerGroup(getManagedList3());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList3(){  List list = new ArrayList();  list.add(getEventHandlerGroup_cb438b());  list.add(getEventHandlerGroup_447a92());  return list;}

private nc.ui.pubapp.uif2app.event.EventHandlerGroup getEventHandlerGroup_cb438b(){
 if(context.get("nc.ui.pubapp.uif2app.event.EventHandlerGroup#cb438b")!=null)
 return (nc.ui.pubapp.uif2app.event.EventHandlerGroup)context.get("nc.ui.pubapp.uif2app.event.EventHandlerGroup#cb438b");
  nc.ui.pubapp.uif2app.event.EventHandlerGroup bean = new nc.ui.pubapp.uif2app.event.EventHandlerGroup();
  context.put("nc.ui.pubapp.uif2app.event.EventHandlerGroup#cb438b",bean);
  bean.setEvent("nc.ui.pubapp.uif2app.event.OrgChangedEvent");
  bean.setHandler(getAceOrgChangeHandler_10bb1b6());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.docmng.doctype.ace.handler.AceOrgChangeHandler getAceOrgChangeHandler_10bb1b6(){
 if(context.get("nc.ui.docmng.doctype.ace.handler.AceOrgChangeHandler#10bb1b6")!=null)
 return (nc.ui.docmng.doctype.ace.handler.AceOrgChangeHandler)context.get("nc.ui.docmng.doctype.ace.handler.AceOrgChangeHandler#10bb1b6");
  nc.ui.docmng.doctype.ace.handler.AceOrgChangeHandler bean = new nc.ui.docmng.doctype.ace.handler.AceOrgChangeHandler();
  context.put("nc.ui.docmng.doctype.ace.handler.AceOrgChangeHandler#10bb1b6",bean);
  bean.setBillForm(getBillForm());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.event.EventHandlerGroup getEventHandlerGroup_447a92(){
 if(context.get("nc.ui.pubapp.uif2app.event.EventHandlerGroup#447a92")!=null)
 return (nc.ui.pubapp.uif2app.event.EventHandlerGroup)context.get("nc.ui.pubapp.uif2app.event.EventHandlerGroup#447a92");
  nc.ui.pubapp.uif2app.event.EventHandlerGroup bean = new nc.ui.pubapp.uif2app.event.EventHandlerGroup();
  context.put("nc.ui.pubapp.uif2app.event.EventHandlerGroup#447a92",bean);
  bean.setEvent("nc.ui.pubapp.uif2app.event.billform.AddEvent");
  bean.setHandler(getAceAddHandler_1f9a12());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.docmng.doctype.ace.handler.AceAddHandler getAceAddHandler_1f9a12(){
 if(context.get("nc.ui.docmng.doctype.ace.handler.AceAddHandler#1f9a12")!=null)
 return (nc.ui.docmng.doctype.ace.handler.AceAddHandler)context.get("nc.ui.docmng.doctype.ace.handler.AceAddHandler#1f9a12");
  nc.ui.docmng.doctype.ace.handler.AceAddHandler bean = new nc.ui.docmng.doctype.ace.handler.AceAddHandler();
  context.put("nc.ui.docmng.doctype.ace.handler.AceAddHandler#1f9a12",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.AddAction getAddAction(){
 if(context.get("addAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.AddAction)context.get("addAction");
  nc.ui.pubapp.uif2app.actions.AddAction bean = new nc.ui.pubapp.uif2app.actions.AddAction();
  context.put("addAction",bean);
  bean.setModel(getHModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.EditAction getEditAction(){
 if(context.get("editAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.EditAction)context.get("editAction");
  nc.ui.pubapp.uif2app.actions.EditAction bean = new nc.ui.pubapp.uif2app.actions.EditAction();
  context.put("editAction",bean);
  bean.setModel(getHModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.DeleteAction getDeleteAction(){
 if(context.get("deleteAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.DeleteAction)context.get("deleteAction");
  nc.ui.pubapp.uif2app.actions.DeleteAction bean = new nc.ui.pubapp.uif2app.actions.DeleteAction();
  context.put("deleteAction",bean);
  bean.setModel(getHModel());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.RefreshAction getRefreshAction(){
 if(context.get("refreshAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.RefreshAction)context.get("refreshAction");
  nc.ui.pubapp.uif2app.actions.RefreshAction bean = new nc.ui.pubapp.uif2app.actions.RefreshAction();
  context.put("refreshAction",bean);
  bean.setModel(getHModel());
  bean.setDataManager(getHModelModelDataManager());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.SaveAction getSaveAction(){
 if(context.get("saveAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.SaveAction)context.get("saveAction");
  nc.ui.pubapp.uif2app.actions.SaveAction bean = new nc.ui.pubapp.uif2app.actions.SaveAction();
  context.put("saveAction",bean);
  bean.setModel(getHModel());
  bean.setEditor(getBillForm());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.CancelAction getCancelAction(){
 if(context.get("cancelAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.CancelAction)context.get("cancelAction");
  nc.ui.pubapp.uif2app.actions.CancelAction bean = new nc.ui.pubapp.uif2app.actions.CancelAction();
  context.put("cancelAction",bean);
  bean.setModel(getHModel());
  bean.setEditor(getBillForm());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.DefaultExceptionHanler getExceptionHandler(){
 if(context.get("exceptionHandler")!=null)
 return (nc.ui.uif2.DefaultExceptionHanler)context.get("exceptionHandler");
  nc.ui.uif2.DefaultExceptionHanler bean = new nc.ui.uif2.DefaultExceptionHanler(getContainer());  context.put("exceptionHandler",bean);
  bean.setContext(getContext());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

}
