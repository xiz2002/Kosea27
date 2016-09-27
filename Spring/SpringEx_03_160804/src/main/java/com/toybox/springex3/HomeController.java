package com.toybox.springex3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		return "home";
	}

	@RequestMapping(value = "/action.do", method = RequestMethod.POST)
	public void actionView(Model model, 
			HttpServletRequest request,
			@RequestParam("name") String name,
			@RequestParam Map<String, String> commandMap,
			@RequestBody String str) throws Exception {
		System.out.println("Action");
		// String name = requset.getParameter("name");
		// requset.setCharacterEncoding("EUC-KR") // POST 한글 처리

		model.addAttribute("param1", name);
		request.setAttribute("param2", name);
		model.addAttribute("param3", commandMap.get("name"));
		System.out.println("Stirng : " + str);
		model.addAttribute("param4", str.split("=")[1]); // 값을 잘라서 보낸다.
//		model.addAttribute("param5", member.getName());
	}

}
