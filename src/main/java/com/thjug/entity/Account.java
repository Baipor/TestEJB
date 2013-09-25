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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author @nuboat
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
    @NamedQuery(name = Account.FindById, query = "SELECT a FROM Account a WHERE a.id = ?1"),
	@NamedQuery(name = Account.FindByUsername, query = "SELECT a FROM Account a WHERE a.username = ?1"),
})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

	public static final String FindById = "Account.findById";
	public static final String FindByUsername = "Account.findByUsername";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
	@Size(max = 256)
    @Column(name = "USERNAME")
    private String username;
	@Size(max = 256)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TYPEID")
    private char typeid;
    @Size(max = 256)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 256)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 256)
    @Column(name = "BIO")
    private String bio;
    @Size(max = 256)
    @Column(name = "AVATARPATH")
    private String avatarpath;

    public Account() {
    }

    public Account(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

    public char getTypeid() {
        return typeid;
    }

    public void setTypeid(final char typeid) {
        this.typeid = typeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(final String bio) {
        this.bio = bio;
    }

    public String getAvatarpath() {
        return avatarpath;
    }

    public void setAvatarpath(final String avatarpath) {
        this.avatarpath = avatarpath;
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
        if (!(object instanceof Account)) {
            return false;
        }
        final Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account[ id=" + id + " ]";
    }

}
