package com.jpa.conteoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.dao.UserDAO;
import com.jpa.model.Model;


	
	@Controller
	public class UserController {
	
	
		@Autowired
		UserDAO userdao;   // object connection here (depedency injection )
		
		@RequestMapping("/index")
				
		public String cust()
		{
			return "index.jsp";
		
		
	}
		
		
		@RequestMapping("addUser")
		
		public String addUser (Model cust)
		
		{
			userdao.save(cust);
			return "index.jsp";
			
			
		}
		
		
		
		@RequestMapping("getUser")
		public ModelAndView cust (@RequestParam int id)
		{
			ModelAndView mav = new ModelAndView("showUser.jsp");
			Model cust = userdao.findById(id).orElse(new Model());
			mav.addObject(cust);
			
			return mav;
		
		}
			
			
			@RequestMapping("deleteUser")
			
			public ModelAndView deleteUser(@RequestParam int id)
			{
				ModelAndView mav = new ModelAndView("deleteUser.jsp");
				Model cust = userdao.findById(id).orElse(new Model());
				userdao.deleteById(id);
				mav.addObject(cust);
				
				return mav; 
				
			}				
				
				
				@RequestMapping("updateUser")
				
				public ModelAndView updateUser(Model cust)
				{
					ModelAndView mav = new ModelAndView("updateUser.jsp");
					cust = userdao.findById(cust.getId()).orElse(new Model());
					userdao.deleteById(cust.getId());
					mav.addObject(cust);
					
					return mav;
			
		
	}
		

	}
	
	
	


	
	
	
	
	
