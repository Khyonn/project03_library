package fr.nmocs.library.webapp.actions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import fr.nmocs.library.webapp.webservice.LibraryWebserviceException_Exception;
import fr.nmocs.library.webapp.webservice.User;
import fr.nmocs.library.webapp.webservice.UserService;

@SuppressWarnings("serial")
public class SignupAction extends LibraryAbstractAction {

	@Autowired
	private UserService userService;

	private User user;

	// ===== OUTPUTS
	public User getUser() {
		return user;
	}

	// ===== INPUTS
	public void setUser(User user) {
		this.user = user;
	}

	public String verifPassword;

	public String verifEmail;

	// ========= ACTIONS

	public String doSignup() {
		if (user == null || !StringUtils.equals(user.getPassword(), verifPassword)
				|| !StringUtils.equals(user.getEmail(), verifEmail)) {
			if (user != null && !StringUtils.equals(user.getPassword(), verifPassword)) {
				addActionError("Passwords don't match");
			}
			if (user != null && !StringUtils.equals(user.getEmail(), verifEmail)) {
				addActionError("Emails don't match");
			}
			return INPUT;
		}
		try {
			userService.createUser(user);
		} catch (LibraryWebserviceException_Exception e) {
			addActionError(e.getFaultInfo().getMessage());
			return INPUT;
		}
		return LOGIN;
	}

}
