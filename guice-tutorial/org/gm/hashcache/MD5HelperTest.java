package org.gm.hashcache;

import static org.junit.Assert.*;

import org.gm.guicetutorial.MD5Helper;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MD5HelperTest {

	@Test
	public void testStandardImpl() throws Exception {

		Injector injector = Guice.createInjector();
		MD5Helper helper = injector.getInstance(MD5Helper.class);

		assertEquals("5d255e82ae2be1d1d54090bb20351106", helper
				.getMD5Hash("Hello guicy world!"));
	}

	@Test
	public void testFastImpl() throws Exception {

		Injector injector = Guice.createInjector(new ExampleModule());
		MD5Helper helper = injector.getInstance(MD5Helper.class);

		assertEquals("5d255e82ae2be1d1d54090bb20351106", helper
				.getMD5Hash("Hello guicy world!"));
	}
}
