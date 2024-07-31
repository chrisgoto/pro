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

import com.aixtw.pro.urlsetting.PayTypeUrl;
import com.aixtw.pro.entity.PayTypeEntity;
import com.aixtw.pro.service.PayTypeService;

@CrossOrigin
@Controller
public class PayTypeController {

	@Autowired
	PayTypeService payTypeService;

	private Logger logger = LogManager.getLogger(getClass());

	@GetMapping(PayTypeUrl.ROOT + "/" + PayTypeUrl.LIST)
	public String list(Model model) {

		Iterable<PayTypeEntity> it = payTypeService.findAll();

		model.addAttribute("datalist", it.iterator());

		return PayTypeUrl.ROOT + "/" + PayTypeUrl.LIST;
	}

	@PostMapping(PayTypeUrl.ROOT + "/" + PayTypeUrl.UPD)
	public String upd(Model model, @ModelAttribute PayTypeEntity entity) {

		Optional<PayTypeEntity> op = payTypeService.findOneById(entity.getId());

		try {

			if (op.isPresent()) {
				PayTypeEntity saveEntity = op.get();
				saveEntity.setType(entity.getType());
				saveEntity.setTypeName(entity.getTypeName());
				payTypeService.save(saveEntity);
			} else {
				payTypeService.save(entity);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error -> html page: itemkind/list , method: upd");
			logger.info(e.getMessage());
		}

		return PayTypeUrl.REDIRECT + "/" + PayTypeUrl.ROOT + "/" + PayTypeUrl.LIST;
	}

	@PostMapping(PayTypeUrl.ROOT + "/" + PayTypeUrl.ADD)
	public String add(Model model, @ModelAttribute PayTypeEntity entity) {
		
		return upd(model, entity);
	}

}
