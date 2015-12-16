package org.com.sources.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.yyg.ServiceInterf.serviceImp;


/**
 * Project entity. @author MyEclipse Persistence Tools
 */

public class Project extends serviceImp  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String content;
     private Timestamp CTime;
     private Set imageses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Project() {
    }

    
    @Override
	public String toString() {
		return "{\"id\":" + id + ",\"content\":\"" + content + "\",\"CTime\":\""
				+ CTime + "\"}";
	}


	/** full constructor */
    public Project(String content, Timestamp CTime, Set imageses) {
        this.content = content;
        this.CTime = CTime;
        this.imageses = imageses;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

    public Set getImageses() {
        return this.imageses;
    }
    
    public void setImageses(Set imageses) {
        this.imageses = imageses;
    }
   








}