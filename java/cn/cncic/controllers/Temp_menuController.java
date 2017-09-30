package cn.cncic.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Apply;
import cn.cncic.service.ApplyService;
import cn.cncic.service.Temp_menuService;


@RestController
public class Temp_menuController {
	@Autowired
	private Temp_menuService temp_menuService;
	
	
}
