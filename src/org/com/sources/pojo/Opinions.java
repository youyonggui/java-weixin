package org.com.sources.pojo;

import java.sql.Timestamp;

import com.yyg.ServiceInterf.serviceImp;

/**
 * Opinions entity. @author MyEclipse Persistence Tools
 */

public class Opinions extends serviceImp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String openid;
	private String content;
	private Timestamp CTime;
	private String status;

	// Constructors

	/** default constructor */
	public Opinions() {
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"openid\":\"" + openid + "\",\"content\":\""
				+ content + "\",\"CTime\":\"" + CTime + "\",\"status\":\"" + status + "\"}";
	}

	/** full constructor */
	public Opinions(String openid, String content, Timestamp CTime,
			String status) {
		this.openid = openid;
		this.content = content;
		this.CTime = CTime;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCTime() {
		return this.CTime;
	}

	public void setCTime(Timestamp CTime) {
		this.CTime = CTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}