package pt.ua.es.labProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.ua.es.labProject.dao.UserDao;
import pt.ua.es.labProject.model.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao repositorio;

	@RequestMapping("/index")
	@ResponseBody
	public String index(){
		return "index";
	}

	@RequestMapping(path="/form", method=RequestMethod.GET)	
	public String form(Model model) {
		model.addAttribute("user", new UserModel());
		return "/user/userform";
	}

	@RequestMapping(path="/consultar",method=RequestMethod.GET)
	@ResponseBody
	public String consultar(
			@PathVariable(name="id") int id){		
		
		Optional<UserModel> user = repositorio.findById(id);
		if(user!=null) 
			return user.toString();
		
		return "Sem resultado";
	}
	
	@RequestMapping(path="/remover/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String remover(
			@PathVariable(name="id") int id){				
		repositorio.deleteById(id);		
		return "Sucesso";
	}
	
	@RequestMapping("/incluir")
	@ResponseBody
	public String incluir(UserModel user){
		repositorio.save(user);
		return "Sucesso";
	}
	
	@RequestMapping(path={"/listar","/"} , method=RequestMethod.GET)
	public List<UserModel> listar(){
		List<UserModel> lista = repositorio.findAll();
		return lista;
	}
	
	public UserDao getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(UserDao repositorio) {
		this.repositorio = repositorio;
	}



}