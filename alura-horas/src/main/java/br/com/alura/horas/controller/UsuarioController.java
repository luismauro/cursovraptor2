package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.UsuarioDao;
import br.com.alura.horas.modelos.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {
	
	private UsuarioDao usuarioDao;
	private Result result;
	private Validator validator;
	
	@Inject
	public UsuarioController(UsuarioDao usuarioDao, Result result, Validator validator){
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.validator = validator;
	}
	
	public UsuarioController(){
		
	}
	
	
	public void form(){
		
	}
	
	// para o validation funcionar, é precisso cria arquivo /META-INF/validation.xml
	@IncludeParameters
	@Post
	public void adiciona(@Valid Usuario usuario){
		validator.onErrorRedirectTo(this).form();
		usuarioDao.adiciona(usuario);
		result.redirectTo(this).lista();
	}
	
	
	public void lista(){
		List<Usuario> usuarios = usuarioDao.lista();
		result.include("usuarios", usuarios);
	}

}
