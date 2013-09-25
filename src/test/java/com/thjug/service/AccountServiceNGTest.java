/*
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 */
package com.thjug.service;

import com.thjug.Log;
import com.thjug.Server;
import com.thjug.entity.Account;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author @nuboat
 */
public class AccountServiceNGTest {

	private AccountService accountService;

	public AccountServiceNGTest() {
		Log.info("AccountServiceNGTest");
	}

	@BeforeTest
	public void beforeTest()
			throws Exception {
		accountService = (AccountService) Server.lookup("java:global/classes/AccountService");
	}

	@Test
	public void testGetAccountbyUsername1() {
		Account account = accountService.getAccountbyUsername("nuboat");
		assertEquals("nuboat", account.getUsername());
	}

	@Test
	public void testGetAccountbyUsername2() {
		Account account = accountService.getAccountbyUsername("blank");
		assertNull(account);
	}

}
