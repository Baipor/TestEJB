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

import com.thjug.entity.Account;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author @nuboat
 */
@Stateless
public class AccountService extends AbstractService<Account> {

	private static final Logger LOG = Logger.getLogger(AccountService.class.getName());

	public AccountService() {
        super(Account.class);
    }

	public Account getAccountbyUsername(final String username) {
		try {
			return findOne(Account.FindByUsername, username);
		} catch(final NoResultException e) {
			return null;
		}
	}

}
