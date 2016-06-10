package br.com.alura.horas.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.alura.horas.modelos.Usuario;



// para ser session scoped, precissa implementar a interface serializable do java
@SessionScoped
@Named
public class UsuarioLogado implements Serializable{

	private Usuario usuario;
	
	// logado
	public void fazlogin(Usuario usuario){
		this.usuario = usuario;
	}
	
	// deslogado
	public void desloga (){
		this.usuario = null;
	}
	
	public Usuario getUsuario() {
        return this.usuario;
    }
	
	// saber se o usuario esta logado
	public boolean isLogado(){
		return this.usuario != null;
	}
}

