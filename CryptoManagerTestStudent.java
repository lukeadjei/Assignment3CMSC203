package assignment3Package;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("LUKEISMYNAMEANDITSLONG"));
		assertTrue(CryptoManager.isStringInBounds("DILLMD"));
		assertFalse(CryptoManager.isStringInBounds("low"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("low", 3));
		assertEquals("K=;J=;LOGJ<", CryptoManager.caesarEncryption("SECRECTWORD", 120));
		assertEquals("$/.44%,,!.9/.%", CryptoManager.caesarEncryption("DONTTELLANYONE", 96));
		
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("SECRECTWORD", CryptoManager.caesarDecryption("K=;J=;LOGJ<", 120));
		assertEquals("DONTTELLANYONE", CryptoManager.caesarDecryption("$/.44%,,!.9/.%", 96));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("&JZ) F%", CryptoManager.bellasoEncryption("REGULAR", "TEST"));
		assertEquals(" ^ME_W[[]EM)T", CryptoManager.bellasoEncryption("NOLAIVEINDISS", "ROADVAV"));
		assertEquals("^XJW]UW^XM UK", CryptoManager.bellasoEncryption("LIFETSHLIINLI", "RODRIBO"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("REGULAR", CryptoManager.bellasoDecryption("&JZ) F%", "TEST"));
		assertEquals("NOLAIVEINDISS", CryptoManager.bellasoDecryption(" ^ME_W[[]EM)T", "ROADVAV"));
		assertEquals("LIFETSHLIINLI", CryptoManager.bellasoDecryption("^XJW]UW^XM UK", "RODRIBO"));

	}

}
