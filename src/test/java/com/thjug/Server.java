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
package com.thjug;

import javax.ejb.embeddable.EJBContainer;

/**
 *
 * @author @nuboat
 */
public class Server {

	private static EJBContainer container;

	public static Object lookup(final String jndi)
		throws Exception {
		if (container == null) {
			container = EJBContainer.createEJBContainer();
		}
		return container.getContext().lookup(jndi);
	}



}
