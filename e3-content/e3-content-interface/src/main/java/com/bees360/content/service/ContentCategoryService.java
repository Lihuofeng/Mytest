package com.bees360.content.service;

import java.util.List;

import com.bees360.common.pojo.EasyUITreeNode;
import com.bees360.common.utils.E3Result;

public interface ContentCategoryService {
 List<EasyUITreeNode> getContentCategoryList(Long parentId);
 E3Result addContentCategory(long parentId,String name);
}
