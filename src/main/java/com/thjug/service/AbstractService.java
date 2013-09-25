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

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author @nuboat
 */
public abstract class AbstractService<T> {

    private transient final Class<T> entityClass;

	@PersistenceContext
	private EntityManager em;

    public AbstractService(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(final T entity) {
        em.persist(entity);
    }

    public void edit(final T entity) {
        em.merge(entity);
    }

    public void remove(final T entity) {
        em.remove(em.merge(entity));
    }

    public T find(final Object id) {
        return em.find(entityClass, id);
    }

	public <S> S findOne(final String namequery, final Object...param) {
        final Query q = em.createNamedQuery(namequery);
        for (int i=0; i<param.length; i++) {
            q.setParameter(i+1, param[i]);
        }
        return (S) q.getSingleResult();
    }

    public List<T> findAll(final String namequery, final Object...param) {
        final Query q = em.createNamedQuery(namequery);
        for (int i=0; i<param.length; i++) {
            q.setParameter(i+1, param[i]);
        }
        return q.getResultList();
    }

    public List<T> findRange(final String namequery, final int offset, final int limit, final Object...param) {
        final Query q = em.createNamedQuery(namequery);
        for (int i=0; i<param.length; i++) {
            q.setParameter(i+1, param[i]);
        }
        q.setMaxResults(limit);
        q.setFirstResult(offset);
        return q.getResultList();
    }

}
