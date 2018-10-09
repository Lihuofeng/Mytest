package com.bees360.content.service;

import java.util.List;

import com.bees360.common.utils.E3Result;
import com.bees360.pojo.TbContent;

public interface ContentService {
	E3Result addContent(TbContent content);
	List<TbContent> getContentListByCid(long cid);
}
