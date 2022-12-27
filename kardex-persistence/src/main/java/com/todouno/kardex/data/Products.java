package com.todouno.kardex.data;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "products")
public class Products {
	
	@Id
    @Column(nullable = false)
	private String id;
	@Basic(optional = false)
    @Column(nullable = false)
	private String name;
	@Basic(optional = false)
    @Column(nullable = false)
	private String description;
	@Basic(optional = false)
    @Column(nullable = false)
	private Date creationDate;
	@Basic(optional = false)
    @Column(nullable = false)
	private String creationUser;
	@Column(nullable = false)
	private String barCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreationUser() {
		return creationUser;
	}
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	
}
