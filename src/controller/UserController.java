package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.*;
import pojo.*;
import service.*;

@SessionAttributes("loginUser")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(String userName, String password, ModelMap map){
		System.out.println("login");
		User user = userService.findUserByName(userName);
		if(user != null){
			if(user.getPassword().equals(password)){
				//–¥»Îsession
				map.put("loginUser", user);
			}
			else{
				map.put("error", "password is invalidate!!");
				return "../../index";
			}
		}
		else{
			map.put("error", "username is invalidate!!");
			return "../../index";
		}
		return "index";
	}
	
	
	@RequestMapping("leftNav")
	public String re(){
		return "leftNav";
	}
	
	@RequestMapping("top")
	public String top(){
		return "top";
	}
	
	@RequestMapping("bottom")
	public String bottom(){
		return "bottom";
	}
	
	@RequestMapping("main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("swich")
	public String sw(){
		return "swich";
	}
}
