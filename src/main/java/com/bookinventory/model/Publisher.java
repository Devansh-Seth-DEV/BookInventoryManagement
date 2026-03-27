package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name="publisher")
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PublisherId")
	private Integer publisherId;
	
	@Column(
		name="Name", 
		nullable = false, 
		length=50
	)
	private String name;
	
	@Column(
			name="City",
			length=30
	)
	private String city;
	
    @ManyToOne
    @JoinColumn(name = "StateCode")
    private State stateCode;

	@OneToMany(mappedBy = "publisher")
	private List<Book> books;
    
    public Publisher() {}

    public Publisher(
    	Integer publisherId, 
    	String name, 
    	String city, 
    	State stateCode
    ) {
        this.publisherId = publisherId;
        this.name = name;
        this.city = city;
        this.stateCode = stateCode;
    }
    
	public Publisher(
		String name, 
		String city, 
		State stateCode
	) {
		this(0, name, city, stateCode); 
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return stateCode;
	}

	public void setState(State state) {
		this.stateCode = state;
	}
    
}	
