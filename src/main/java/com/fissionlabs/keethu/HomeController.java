package com.fissionlabs.keethu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fissionlabs.keethu.dao.StudentDao;
import com.fissionlabs.keethu.dao.StudentDaoImpl;
import com.fissionlabs.keethu.model.Student;
import com.fissionlabs.keethu.HomeController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private StudentDao studentDao;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}




	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String save(@RequestParam("name")String name,@RequestParam("password")String password) {
		Student stu=new Student();
		stu.setName(name);
		stu.setPassword(password);
		
		studentDao.save(stu);
		logger.info("successfully saved");
		
		return "registersuccess";
	}
	@RequestMapping(value="/student",method=RequestMethod.GET)
	public String login(@RequestParam("name")String name,@RequestParam("password")String password)
	{
		logger.info("successfully logged in");
		if(studentDao.search(name, password))
			return "loginsuccess";
		else 
			return "loginerror";
			
	}
	@RequestMapping(value="/student1",method=RequestMethod.POST)
	public String edit(@RequestParam("password")String password,@RequestParam("name")String name)
	{
		studentDao.update(password,name);
		logger.info("successfully edited details");
		return "editsuccess";
		
		
	}
	@RequestMapping(value="/student2",method=RequestMethod.GET)
	public String delete(@RequestParam("password")String password,@RequestParam("name")String name)
	{
		logger.info("successfully deleted");
		studentDao.delete(password,name);
		return "deletesuccess"
				+ "";
		
		
	}
	
	
	
}
