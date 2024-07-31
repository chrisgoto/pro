package com.aixtw.pro.controller;

import java.util.Optional;

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

		model.addAttribute("datalist", it.iterator());

		return ItemKindUrl.ROOT + "/" + ItemKindUrl.LIST;
	}

	@PostMapping(ItemKindUrl.ROOT + "/" + ItemKindUrl.ADD)
	public String add(Model model, @ModelAttribute ItemKindEntity entity) {

		return upd(model, entity);
	}

	@PostMapping(ItemKindUrl.ROOT + "/" + ItemKindUrl.UPD)
	public String upd(Model model, @ModelAttribute ItemKindEntity entity) {

		Optional<ItemKindEntity> op = itemKindService.findById(entity.getId());

		try {

			if (op.isPresent()) {
				ItemKindEntity saveEntity = op.get();
				saveEntity.setKindName(entity.getKindName());
				itemKindService.save(saveEntity);
			} else {
				itemKindService.save(entity);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error -> html page: itemkind/list , method: upd");
			logger.info(e.getMessage());
		}

		return ItemKindUrl.REDIRECT + "/" + ItemKindUrl.ROOT + "/" + ItemKindUrl.LIST;
	}

}
