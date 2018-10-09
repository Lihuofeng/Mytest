package com.bees360.service;

import com.bees360.common.pojo.EasyUIDataGridResult;
import com.bees360.common.utils.E3Result;
import com.bees360.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page,int rows);
	E3Result addItem(TbItem item,String desc);
}
