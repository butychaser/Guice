package org.gm.guicetutorial;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HelperStandardImpl implements MD5Helper {

	public MD5HelperStandardImpl() {
		System.out.println("Constructing MD5HelperStandardImpl.");
	}

	@Override
	public String getMD5Hash(String input) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(input.getBytes());
			return new BigInteger(1, messageDigest).toString(16);

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}
}
