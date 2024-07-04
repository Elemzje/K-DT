package com.minju.jul042;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minju.jul042.student.StudentDAO;
import com.minju.jul042.test.TestDAO;

@Controller
public class HomeController {
	
	@Autowired
	private StudentDAO sDAO;
	
	@Autowired
	private TestDAO tDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		sDAO.getAllStudent(req);
		tDAO.getAllTest(req);
		return "input";
	}
	
}
