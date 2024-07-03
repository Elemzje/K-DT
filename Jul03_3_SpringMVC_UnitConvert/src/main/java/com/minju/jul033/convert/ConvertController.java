package com.minju.jul033.convert;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvertController {
	
	@RequestMapping(value = "unit.convert", method = RequestMethod.GET)
	public String convert(ConvertResult cr, HttpServletRequest req) {
		ConvertDAO.unitConverter(cr, req);
		
		return "output";
	}
}
