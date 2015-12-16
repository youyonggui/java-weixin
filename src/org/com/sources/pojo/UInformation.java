package org.com.sources.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.yyg.ServiceInterf.serviceImp;

/**
 * UInformation entity. @author MyEclipse Persistence Tools
 */

public class UInformation extends serviceImp implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long schoolId;
	private String name;
	private String sexy;
	private Timestamp birthday;
	private Timestamp CTime;
	private Integer status;
	private Set imageses = new HashSet(0);
	private Set loginusers = new HashSet(0);
	private Set contacts = new HashSet(0);
	private Set UIntrductions = new HashSet(0);

	// Constructors

	/** default constructor */
	public UInformation() {
	}

	@Override
	public String toString() {
		Iterator<Images> imgs = imageses.iterator();
		String img = "";
		if(imgs.hasNext()){img = imgs.next().getVals();}
		Iterator<UIntrduction> ui = UIntrductions.iterator();
		String in = "";
		if(ui.hasNext()){in = ui.next().getIntrduction();}
		return "{\"id\":" + id + ",\"schoolId\":\"" + schoolId + "\",\"name\":\""
				+ name + "\",\"sexy\":\"" + sexy + "\",\"birthday\":\"" + birthday
				+ "\",\"CTime\":\"" + CTime + "\",\"status\":" + status + ",\"image\":\""
				+ img + "\",\"UIntrduction\":\"" + in + "\"}";
	}

	/** minimal constructor */
	public UInformation(String name) {
		this.name = name;
	}

	/** full constructor */
	public UInformation(Long schoolId, String name, String sexy,
			Timestamp birthday, Timestamp CTime, Integer status, Set imageses,
			Set loginusers, Set contacts, Set UIntrductions) {
		this.schoolId = schoolId;
		this.name = name;
		this.sexy = sexy;
		this.birthday = birthday;
		this.CTime = CTime;
		this.status = status;
		this.imageses = imageses;
		this.loginusers = loginusers;
		this.contacts = contacts;
		this.UIntrductions = UIntrductions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSexy() {
		return this.sexy;
	}

	public void setSexy(String sexy) {
		this.sexy = sexy;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCTime() {
		return this.CTime;
	}

	public void setCTime(Timestamp CTime) {
		this.CTime = CTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getImageses() {
		return this.imageses;
	}

	public void setImageses(Set imageses) {
		this.imageses = imageses;
	}

	public Set getLoginusers() {
		return this.loginusers;
	}

	public void setLoginusers(Set loginusers) {
		this.loginusers = loginusers;
	}

	public Set getContacts() {
		return this.contacts;
	}

	public void setContacts(Set contacts) {
		this.contacts = contacts;
	}

	public Set getUIntrductions() {
		return this.UIntrductions;
	}

	public void setUIntrductions(Set UIntrductions) {
		this.UIntrductions = UIntrductions;
	}

}