package org.com.sources.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yyg.ServiceInterf.serviceImp;



/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News extends serviceImp implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String title;
     private String content;
     private String author;
     private Timestamp CTime;
     private Integer status;
     private Set imageses = new HashSet(0);


    // Constructors

    /** default constructor */
    public News() {
    }

	@Override
	public String toString() {
		Iterator<Images> it = imageses.iterator();
		String img = "";
		if(it.hasNext()){
			img = it.next().getVals();
		}
		String ret = "{\"id\":\"" + id + "\",\"title\":\"" + title + "\",\"content\":\"" + content
				+ "\",\"author\":\"" + author +"\",\"image\":\""+img+ "\",\"CTime\":\"" + CTime + "\",\"status\":\""
				+ status + "\"}";
		//定义正则式 ret.replace("\t","");
		Pattern p = Pattern.compile("\\s|\t|\r\n|\r|\n");
        Matcher m = p.matcher(ret);
		return m.replaceAll("");
	}

	/** minimal constructor */
    public News(String title, String author, Timestamp CTime) {
        this.title = title;
        this.author = author;
        this.CTime = CTime;
    }
    
    /** full constructor */
    public News(String title, String content, String author, Timestamp CTime, Integer status, Set imageses) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.CTime = CTime;
        this.status = status;
        this.imageses = imageses;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
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
   








}