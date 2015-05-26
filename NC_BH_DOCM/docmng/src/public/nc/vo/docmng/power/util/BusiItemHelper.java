package nc.vo.docmng.power.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import nc.vo.docmng.busipoweritem.BusiPowerItem;
import nc.vo.uap.rbac.constant.IRespFunctionCont;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class BusiItemHelper {
	public static BusiPowerItem[] subtract(BusiPowerItem[] sourceItems , BusiPowerItem[] targetItems){
		if(ArrayUtils.isEmpty(sourceItems) || ArrayUtils.isEmpty(targetItems))
			return sourceItems;
		//抓取带过滤BusiPowerItem数组的<busipk,itemVO>
		HashMap<String, BusiPowerItem> target_busipk_itemVO_map = extractBusipk_ItemVO_map(targetItems);
		
		//结果List
		ArrayList<BusiPowerItem> resultList = new ArrayList<BusiPowerItem>();
		
		//基于sourceItems由业务活动到顶级菜单排好序的情况
		for(BusiPowerItem item : sourceItems){
			if(target_busipk_itemVO_map.get(item.getPk_busipower()) == null){
				//不需要过滤掉，则加入到结果集中
				resultList.add(item);
			}	
		}
		
		//删除没有任何功能节点的菜单
		return resultList.toArray(new BusiPowerItem[0]);
	}
	
	
	public static HashMap<String,BusiPowerItem> extractBusipk_ItemVO_map(BusiPowerItem[] items){
		if(ArrayUtils.isEmpty(items))
			return null;
		
		HashMap<String, BusiPowerItem> busipk_itemVO_map = new HashMap<String, BusiPowerItem>();
		for(BusiPowerItem item : items){
			if(StringUtils.isNotEmpty(item.getPk_busipower()))
				busipk_itemVO_map.put(item.getPk_busipower(), item);
		}
		
		return busipk_itemVO_map;
	}

}
