package com.bees360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bees360.common.utils.E3Result;
import com.bees360.content.service.ContentService;
import com.bees360.pojo.TbContent;

@Controller
public class ContentController {
 @Autowired
 private ContentService contentService;
 @RequestMapping("/content/save")
 @ResponseBody
 public E3Result addContent(TbContent content){
	 E3Result e3Result = contentService.addContent(content);
	 return e3Result;
 }
}
