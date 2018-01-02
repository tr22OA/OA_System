package com.oa.controller.zmy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("nav")
	public String toNav(){
		return "nav";
	}
	
	@RequestMapping("index")
	public String toIndex(){
		return "systemSet";
	}
	
}
