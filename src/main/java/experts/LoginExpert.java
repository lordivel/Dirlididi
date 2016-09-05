package main.java.experts;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import main.java.User;
import main.java.exception.BlankSpaceException;

@ManagedBean
@SessionScoped
public class LoginExpert implements Serializable {

	private static final String LOGIN_SUCESS = "login_sucesso";
	private static final String LOGIN_FAIL = "login_falha";
	private static final String SESSAO_INEXISTENT = "sessao_invalida";
	private static final String OUTCOME_LOGOUT = "logout";
	private static final String USUARIO_SESSION = "usuario";

	private User user;
	private AcessControlExpert acessControl;

	/**
	 * Default login
	 */
	public LoginExpert() {
	}

	/**
	 * Inicialize one Anonimous login
	 */
	@PostConstruct
	public void inicialize() {
		user = new User();
		acessControl = new AcessControlExpert(null);
		// TODO
		// Logger.getLogger(LoginExpert.class).log(Level.INFO," > Iniciating one Annonimous login");
	}

	public String doLogin(String login, String pass) throws BlankSpaceException {

		if (filledSpaces(login, pass) && !isUsuarioLogado()) {
			if (loginService(login, pass)) {

			}

			// doLogin(login,pass);
			return LOGIN_SUCESS;
		}
		return LOGIN_FAIL;
	}

	private boolean isUsuarioLogado() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean loginService(String login, String pass) {
		// FIXME
		try {
			String uPass = "";
			/*
			 * SELECT t_login, t_pass INTO u_login, u_pass FROM USERS WHERE
			 * t_login = login
			 */
			if (pass.equals(uPass)) {
				SessionExpert.newSession(login);
				return true;
			}
			return false;
		} catch (Exception e) {

		}
		return false;
	}

	/*
	 * Detects if there were any blank spaces in login/password return True, if
	 * there were everything filled correctly
	 */
	private boolean filledSpaces(String login, String pass)
			throws BlankSpaceException {
		try {
			if (login != null && pass != null && !login.equals("")
					&& !pass.equals("")) {
				return true;
			} else {
				throw new BlankSpaceException("It cannot have blank spaces.");
			}
		} catch (BlankSpaceException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean userAlreadyLogged() {
		return false;
	}

}
