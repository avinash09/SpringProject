package com.mkyong.web.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.web.service.TestService;

@Controller
public class HelloController {
	
	@Autowired
	public TestService testservice;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
	
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		testservice.executetest(name);
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", "Welcom in spring MVC :: "+name);

		return model;

	}
	@RequestMapping(value = "/output", method = RequestMethod.GET)
	
	public @ResponseBody String jsonprocess() {
		JSONObject object = new JSONObject();
		object.put("output", "hello in spring rest");
		return object.toString();
		
	}
	
	@RequestMapping(value = "/jsonoutput", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String handleAllUserRequest(HttpServletRequest request) throws IOException {
		

		JSONObject object =  new JSONObject(new JSONTokener(request.getReader()));
		testservice.saveEmployee(object);
		object.put("output", "Save Successfully");
		return object.toString();
		
	}
	
	@RequestMapping(value = "/employeedata", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getEmployeeData() {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("records", testservice.getEmployeeAll());
		return jsonobject.toString();
		
	}
	public static void sendmail() {
		
		final String username = "avinashjbs@gmail.com";
		final String password = "!avilonkar09";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("avinashjbs@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("avinashjbs@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
