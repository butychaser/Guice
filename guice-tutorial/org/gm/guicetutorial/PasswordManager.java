package org.gm.guicetutorial;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

public class PasswordManager {

	@Inject
	private MD5Helper helper;

	private Map<String, String> passwordHashes;

	public PasswordManager() {
		passwordHashes = new HashMap<String, String>();
		passwordHashes.put("peter", "5ebe2294ecd0e0f08eab7690d2a6ee69");
	}

	public boolean passwordMatches(String userName, String enteredPassword) {
		return passwordHashes.containsKey(userName)
				&& helper.getMD5Hash(enteredPassword).equals(
						passwordHashes.get(userName));
	}
}
