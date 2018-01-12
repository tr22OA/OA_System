package com.oa.controller.hlg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/toTest")
	public String toTest(){
		return "test";
	}
}
