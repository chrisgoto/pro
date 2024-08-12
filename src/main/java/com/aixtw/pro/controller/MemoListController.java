package com.aixtw.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.aixtw.pro.entity.ItemEntity;
import com.aixtw.pro.entity.ItemKindEntity;
import com.aixtw.pro.entity.MemoListEntity;
import com.aixtw.pro.repostory.ItemRepostory;
import com.aixtw.pro.repostory.MemoListRepostory;
import com.aixtw.pro.urlsetting.MemoListUrl;

@CrossOrigin
@Controller
public class MemoListController {

	@Autowired
	MemoListRepostory<MemoListEntity> memoListRepostory;

	@Autowired
	ItemRepostory<ItemEntity> itemRepostory;

	@GetMapping(MemoListUrl.ROOT + "/" + MemoListUrl.LIST)
	public String list(Model model) {

		Iterable<MemoListEntity> it = memoListRepostory.findAll();
		
		model.addAttribute("datalist", it.iterator());
		
		return MemoListUrl.ROOT + "/" + MemoListUrl.LIST;
	}
	
	
	@GetMapping(MemoListUrl.ROOT + "/" + MemoListUrl.DAYLIST)
	public String daylist(Model model) {

		Iterable<MemoListEntity> it = memoListRepostory.findAll();
		System.out.println("it is daylist");
		model.addAttribute("datalist", it.iterator());
		
		return MemoListUrl.ROOT + "/" + MemoListUrl.DAYLIST;
	}

}
