package com.aixtw.pro.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aixtw.pro.entity.ItemKindEntity;
import com.aixtw.pro.service.ItemKindService;
import com.aixtw.pro.urlsetting.ItemKindUrl;

@CrossOrigin
@Controller
public class ItemKindController {

	@Autowired
	ItemKindService itemKindService;

	private Logger logger = LogManager.getLogger(getClass());

	@GetMapping(ItemKindUrl.ROOT + "/" + ItemKindUrl.LIST)
	public String list(Model model) {

		Iterable<ItemKindEntity> it = itemKindService.finall();

		System.out.println(it.iterator());

		model.addAttribute("datalist", it.iterator());

		return ItemKindUrl.ROOT + "/" + ItemKindUrl.LIST;
	}

	@PostMapping(ItemKindUrl.ROOT + "/" + ItemKindUrl.ADD)
	public String add(Model model, @ModelAttribute ItemKindEntity entity) {

		return upd(model, entity);
	}

	@PostMapping(ItemKindUrl.ROOT + "/" + ItemKindUrl.UPD)
	public String upd(Model model, @ModelAttribute ItemKindEntity entity) {

		try {
			itemKindService.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error -> html page: itemkind/list , method: upd");
			logger.info(e.getMessage());
		}

		return ItemKindUrl.REDIRECT + ItemKindUrl.LIST;
	}

}
