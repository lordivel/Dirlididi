package main.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.User;
import main.java.exception.BlankSpaceException;
import main.java.repositories.UserRepository;

@Service
public class UserService {
	
	public UserService() {}

	@Autowired
	private UserRepository userRepository;

	public String getErrorsUser(User user) throws BlankSpaceException {
		if (!isValidEmail(user.getEmail()) || !isValidPassword(user.getPass())) {
			return "Email or Password invalid";
		} else if (!correctPermition(user.getType())) {
			return "You don't have any valid permition";
		}
		return null;
	}

	private boolean isValidEmail(String email) throws BlankSpaceException {
		return filledSpaces(email) && userRepository.findOneByEmail(email) == null;
	}
	
	private boolean isValidPassword(String password) throws BlankSpaceException {
		return filledSpaces(password);
	}
	
	private boolean filledSpaces(String str) throws BlankSpaceException {
		try {
			if (str != null && !str.equals("")) {
				return true;
			} else {
				throw new BlankSpaceException("It cannot have blank spaces.");
			}
		} catch (BlankSpaceException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	private boolean correctPermition(User.UserType type) {
		return type != null;
	}
}