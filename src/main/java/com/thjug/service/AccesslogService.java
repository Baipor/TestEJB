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

import com.thjug.entity.AccessLog;
import com.thjug.entity.Account;
import com.thjug.facade.result.ResultObj;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author @nuboat
 */
@Stateless
public class AccesslogService extends AbstractService<AccessLog> {

	private static final Logger LOG = Logger.getLogger(AccesslogService.class.getName());

	public AccesslogService() {
        super(AccessLog.class);
    }

	public void persistLog(final ResultObj resultObj, final Account id) {
		// TODO
	}

}
