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
package com.thjug.facade;

import com.thjug.Log;
import com.thjug.Server;
import com.thjug.facade.result.ResultObj;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author @nuboat
 */
public class AuthenticationFacadeNGTest {

	AuthenticationFacade authenticationFacade;

	public AuthenticationFacadeNGTest() {
		Log.info("AuthenticationFacadeNGTest");
	}

	@BeforeTest
	public void beforeTest()
			throws Exception {
		authenticationFacade = (AuthenticationFacade) Server.lookup("java:global/classes/AuthenticationFacade");
	}

	@Test
	public void testAuthen1() throws Exception {
		try {
			ResultObj resultObj;

			resultObj = authenticationFacade.authenByUsernamePassword("blank", "");
			assertEquals("0001", resultObj.getStatus());
		} catch (Exception e) {
			fail(e.getMessage(), e);
		}
	}

	@Test
	public void testAuthen2() throws Exception {
		try {
			ResultObj resultObj;

			resultObj = authenticationFacade.authenByUsernamePassword("tomz", "password");
			assertEquals("0001", resultObj.getStatus());
		} catch (Exception e) {
			fail(e.getMessage(), e);
		}
	}

	@Test
	public void testAuthen3() throws Exception {
		try {
			ResultObj resultObj;

			resultObj = authenticationFacade.authenByUsernamePassword("nuboat", "password");
			assertEquals("0000", resultObj.getStatus());
		} catch (Exception e) {
			fail(e.getMessage(), e);
		}
	}

}
