package pt.ua.es.labProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author luizn
 *
 */

@Entity
@Table(name="tb_user")
public class UserModel implements Serializable{
	
	private static final long serialVersionUID = -6379565374078483214L;
	
	@Id
	@GeneratedValue
	private int id;	
	
	@Column(name="login", nullable=false)
	private String login;	
	
	@Column(name="senha", nullable  =true)
	private String senha;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", login=" + login + ", senha=" + senha +"]";
	}
	
}
