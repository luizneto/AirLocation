package pt.ua.es.labProject.controller;

import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ua.es.labProject.dao.UserDao;
import pt.ua.es.labProject.model.UserModel;

@Controller
@RequestMapping("/airplane")
public class LoginController {
		
	@Autowired
	private UserDao repositorio;
	
	@RequestMapping(method=RequestMethod.GET, value={"/logout",})
	public String logout(ModelMap map, HttpSession session){
		session.invalidate();
		map.addAttribute("user", new UserModel());
		return "airplaneList";
	}
	
	public UserModel efetuarLogin(String login, String senha){
		Query query = repositorio.createQuery("select u from User u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<UserModel> users  = query.getResultList();
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

	@RequestMapping(method=RequestMethod.POST, value="/efetuarLogin")
	public String login(@ModelAttribute("user") @Valid UserModel user, ModelMap map, HttpSession session, BindingResult result){
		if(result.hasErrors()){
			map.addAttribute("user", user);
			return "airplaneList";
		}
		
				efetuarLogin(user.getLogin(), user.getSenha());
		

		session.setAttribute("user", user);
		return "/user/userList";
	}



}