package com.oa.controller.qh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveController {
	@RequestMapping("/to_Leave")
	public String to_Leave() {
		return "Leave";
	}
}
