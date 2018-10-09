package com.bees360.service;

import java.util.List;

import com.bees360.common.pojo.EasyUITreeNode;
import com.bees360.pojo.TbItemCat;

public interface ItemCatService {
	List<EasyUITreeNode> getItemCatList(long parentId);
}
