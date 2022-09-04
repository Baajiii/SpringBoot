package com.Quiz.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz.main.repository.QuestionRepo;
import com.Quiz.main.repository.ResultRepo;

@RestController
public class AdminController {

	@Autowired
	private QuestionRepo Qrep;

	@Autowired
	private ResultRepo Rrep;

	@RequestMapping("/Admin")
	public String Login() {
		return "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>ADMIN Login</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "		<div align=\"center\">\r\n"
				+ "		<h2>WELCOME TO LOGIN PAGE</h2>\r\n"
				+ "		<form action=\"Adminlogin\" method=\"post\">\r\n"
				+ "		<fieldset>\r\n"
				+ "		Email <input type=\"email\" name=\"adminemail\" id=\"adminemail\"><br><br>\r\n"
				+ "		Password <input type=\"password\" name=\"adminpassword\" id=\"adminpassword\"><br><br>\r\n"
				+ "		<input type=\"submit\" value=\"Login\">\r\n"
				+ "		</fieldset>\r\n"
				+ "		</form>\r\n"
				+ "		</div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
	}
	
	
	@RequestMapping("/Adminlogin")
	public String AdminLogin(@RequestParam("adminemail") String Email, @RequestParam("adminpassword") String Pass) {
		if (Email.equals("admin@gmail.com") && Pass.equals("123456")) {
			return "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>QUIZ PORTAL</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<br>\r\n"
					+ "	<div align=\"center\">\r\n"
					+ "	<h1>WELCOME TO ONLINE QUIZ PORTAL MAIN MENU</h1><br><br><br>\r\n"
					+ "	<h3>QUESTIONS DETAILS</h3>\r\n"
					+ "  <br>Add Question<br>\r\n"
					+ "<a href=\"Quiz/allquestions\">View Question</a><br>\r\n"
					+ "<h4>Delete Question</h4>\r\n"
					+ "<div align=\"center\">\r\n"
					+ "		<form action=\"/Quiz/id\" method=\"get\">\r\n"
					+ "			<p>Enter the question ID to be delete: <input type=\"number\" name=\"ID\" /></p>\r\n"
					+ "			<p><input type=\"submit\" value=\"DELETE\" />\r\n"
					+ "		</form>\r\n"
					+ "	</div>"
					+ "	<h3>USERS DETAILS</h3>\r\n"
					+ "  <br>View User<br>\r\n"
					+ "	<h3>RESULTS DETAILS</h3>\r\n"
					+ "  <br>View Question<br> <br><br><br>\r\n"
					+ "	<a href=\"Admin\">LOGOUT</a>\r\n"
					+ "	\r\n"
					+ "	</div>\r\n"
					+ "</body>\r\n"
					+ "</html>";
		}else

		return "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n" + "<title>ADMIN Login</title>\r\n"
				+ "</head>\r\n" + "<body>\r\n" + "		<div align=\"center\">\r\n"
				+ "		<h2>WELCOME TO LOGIN PAGE</h2>\r\n" + "		<form action=\"Adminlogin\" method=\"post\">\r\n"
				+ "		<fieldset>\r\n"
				+ "		Email <input type=\"email\" name=\"adminemail\" id=\"adminemail\"><br><br>\r\n"
				+ "		Password <input type=\"password\" name=\"adminpassword\" id=\"adminpassword\"><br><br>\r\n"
				+ "		<input type=\"submit\" value=\"Login\">\r\n" + "		</fieldset>\r\n" + "		</form>\r\n"
						+ "<h3>Enter the correct user ID and password</h3>"
				+ "		</div>\r\n" + "</body>\r\n" + "</html>";

	}
}
