package br.com.alura.horas.controller;


import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.UsuarioDao;
import br.com.alura.horas.modelos.Usuario;
import br.com.alura.horas.seguranca.Open;
import br.com.alura.horas.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {
	
	private UsuarioDao usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;
	
	public LoginController(){
		
	}
	
	@Inject
    public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado, Result result, Validator validator){
    	this.usuarioDao = usuarioDao;
    	this.usuarioLogado = usuarioLogado;
    	this.result = result;
		this.validator = validator;
    }
	// annotation do java pra que todos possam acessar o login, para nao ficar em loop infinito de ficar tentando loga
	@Open
	public void form(){
		
	}
	
	
	@IncludeParameters
	@Open
	@Post
	// autentica usuario
	public void autentica(@Valid String login,@Valid String senha){
		Usuario usuario = usuarioDao.busca(login,senha);
		if(usuario != null){
			usuarioLogado.fazlogin(usuario);
			result.redirectTo(UsuarioController.class).lista();
		}else{
			// validacao formulario
			validator.add(new SimpleMessage("login_invalido", "Login ou senha incorretos"));
			validator.onErrorRedirectTo(LoginController.class).form();
		}
	}
	
	@Open
	// desloga usuario
	public void desloga(){
		usuarioLogado.desloga();
		result.redirectTo(LoginController.class).form();
	}
}

