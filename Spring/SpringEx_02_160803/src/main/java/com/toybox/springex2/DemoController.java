package com.toybox.springex2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	@RequestMapping(value="demo1.do", method=RequestMethod.GET)
	public String DemoView1(Model model) {
		System.out.println("demo1");
		model.addAttribute("TEST", "TESTTESTTESTTESTTESTTESTTES");
		return "demo1";
	}
}
