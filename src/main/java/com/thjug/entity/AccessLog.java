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
package com.thjug.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author @nuboat
 */
@Entity
@Table(name = "ACCESSLOG")
@NamedQueries({
    @NamedQuery(name = AccessLog.FindById, query = "SELECT a FROM AccessLog a WHERE a.id = ?1")
})
public class AccessLog implements Serializable {

    private static final long serialVersionUID = 1L;

	public static final String FindById = "AccessLog.findById";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
	@Column(name = "ACCOUNTID")
    private Integer accountid;
	@Column(name = "ACCESSTIME")
	private Timestamp accesstime;

    public AccessLog() {
    }

    public AccessLog(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(final Integer accountid) {
		this.accountid = accountid;
	}

	public Timestamp getAccesstime() {
		return accesstime;
	}

	public void setAccesstime(final Timestamp accesstime) {
		this.accesstime = accesstime;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessLog)) {
            return false;
        }
        final AccessLog other = (AccessLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccessLog[ id=" + id + " ]";
    }

}
