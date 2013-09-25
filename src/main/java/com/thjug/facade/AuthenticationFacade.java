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

import com.thjug.entity.Account;
import com.thjug.facade.result.ResultObj;
import com.thjug.service.AccesslogService;
import com.thjug.service.AccountService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author @nuboat
 */
@Stateless
public class AuthenticationFacade {

	private static final Logger LOG = Logger.getLogger(AuthenticationFacade.class.getName());

	@EJB
	private AccountService accountService;

	@EJB
	private AccesslogService accesslogService;

	public ResultObj authenByUsernamePassword(
			final String username, final String password)
		throws Exception {
		LOG.log(Level.FINE, "Authenticate with U:{0} P:{1}", new Object[] {username, password} );

		final Account account = accountService.getAccountbyUsername(username);

		final ResultObj resultObj = authen(account, password);

		accesslogService.persistLog(resultObj, account);

		return resultObj;
	}

	/**
	 *
	 * FIXME
	 * @param account
	 * @return
	 */
	public ResultObj authen(final Account account, final String password) {
		if (account == null) {
			return new ResultObj("0001", "Fail");
		}

		if (!password.equals(account.getPassword())) {
			return new ResultObj("0001", "Fail");
		}

		return new ResultObj("0000", "Success");
	}

}
