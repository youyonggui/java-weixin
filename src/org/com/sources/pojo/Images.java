package org.com.sources.pojo;

import java.sql.Timestamp;

import com.yyg.ServiceInterf.serviceImp;

/**
 * Images entity. @author MyEclipse Persistence Tools
 */

public class Images extends serviceImp implements java.io.Serializable {

	// Fields

	private Integer id;
	private News news;
	private UInformation UInformation;
	private Project project;
	private String vals;
	private Timestamp CTime;

	// Constructors

	/** default constructor */
	public Images() {
	}

	/** full constructor */
	public Images(News news, UInformation UInformation, Project project,
			String vals, Timestamp CTime) {
		this.news = news;
		this.UInformation = UInformation;
		this.project = project;
		this.vals = vals;
		this.CTime = CTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public UInformation getUInformation() {
		return this.UInformation;
	}

	public void setUInformation(UInformation UInformation) {
		this.UInformation = UInformation;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getVals() {
		return this.vals;
	}

	public void setVals(String vals) {
		this.vals = vals;
	}

	public Timestamp getCTime() {
		return this.CTime;
	}

	public void setCTime(Timestamp CTime) {
		this.CTime = CTime;
	}

}