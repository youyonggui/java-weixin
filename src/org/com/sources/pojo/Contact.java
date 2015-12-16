package org.com.sources.pojo;

import java.sql.Timestamp;

import com.yyg.ServiceInterf.serviceImp;

/**
 * Contact entity. @author MyEclipse Persistence Tools
 */

public class Contact extends serviceImp implements java.io.Serializable {

	// Fields

	private Integer id;
	private UInformation UInformation;
	private Long phone;
	private Long qq;
	private String email;
	private Timestamp CTime;

	// Constructors

	/** default constructor */
	public Contact() {
	}

	/** full constructor */
	public Contact(UInformation UInformation, Long phone, Long qq,
			String email, Timestamp CTime) {
		this.UInformation = UInformation;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
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

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getQq() {
		return this.qq;
	}

	public void setQq(Long qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCTime() {
		return this.CTime;
	}

	public void setCTime(Timestamp CTime) {
		this.CTime = CTime;
	}

}