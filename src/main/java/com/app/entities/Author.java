package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
   
    private String country;
    @OneToMany(mappedBy = "author",targetEntity =Publication.class,fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<Publication> publications;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
     

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
    
    
}
