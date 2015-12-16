package org.com.sources.pojo;

import java.sql.Timestamp;

import com.yyg.ServiceInterf.serviceImp;

/**
 * Loginuser entity. @author MyEclipse Persistence Tools
 */

public class Loginuser extends serviceImp implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UInformation UInformation;
	private String name;
	private Integer primary;
	private String password;
	private Timestamp CTime;

	// Constructors

	/** default constructor */
	public Loginuser() {
	}

	/** minimal constructor */
	public Loginuser(UInformation UInformation, String name, String password,
			Timestamp CTime) {
		this.UInformation = UInformation;
		this.name = name;
		this.password = password;
		this.CTime = CTime;
	}

	/** full constructor */
	public Loginuser(UInformation UInformation, String name, Integer primary,
			String password, Timestamp CTime) {
		this.UInformation = UInformation;
		this.name = name;
		this.primary = primary;
		this.password = password;
		this.CTime = CTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UInformation getUInformation() {
		return this.UInformation;
	}

	public void setUInformation(UInformation UInformation) {
		this.UInformation = UInformation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrimary() {
		return this.primary;
	}

	public void setPrimary(Integer primary) {
		this.primary = primary;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCTime() {
		return this.CTime;
	}

	public void setCTime(Timestamp CTime) {
		this.CTime = CTime;
	}

}