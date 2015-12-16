package org.com.sources.pojo;

import java.sql.Timestamp;

import com.yyg.ServiceInterf.serviceImp;

/**
 * UIntrduction entity. @author MyEclipse Persistence Tools
 */

public class UIntrduction extends serviceImp implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UInformation UInformation;
	private String intrduction;
	private Timestamp CTime;

	// Constructors

	/** default constructor */
	public UIntrduction() {
	}

	/** full constructor */
	public UIntrduction(UInformation UInformation, String intrduction,
			Timestamp CTime) {
		this.UInformation = UInformation;
		this.intrduction = intrduction;
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

	public String getIntrduction() {
		return this.intrduction;
	}

	public void setIntrduction(String intrduction) {
		this.intrduction = intrduction;
	}

	public Timestamp getCTime() {
		return this.CTime;
	}

	public void setCTime(Timestamp CTime) {
		this.CTime = CTime;
	}

}