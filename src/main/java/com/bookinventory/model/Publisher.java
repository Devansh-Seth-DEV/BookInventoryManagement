package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a book publishing house.
 * Maps to the 'publisher' table and provides organizational 
 * details used for inventory sourcing and catalog filtering.
 */
@Entity
@Table(name="publisher")
public class Publisher {

    /**
     * Unique internal identifier for the publisher, 
     * automatically incremented for sequence integrity.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PublisherId")
	private Integer publisherId;
	
    /**
     * The official business name of the publishing house. 
     * Required field with a 50-character limit for database optimization.
     */
	@Column(
		name="Name", 
		nullable = false, 
		length=50
	)
	private String name;
	
    /**
     * The city where the publisher's headquarters or main office is located.
     */
	@Column(
			name="City",
			length=30
	)
	private String city;
	
    /**
     * The regional jurisdiction or state associated with the publisher's location.
     * Established via a Many-to-One relationship to the State entity.
     */
    @ManyToOne
    @JoinColumn(name = "StateCode")
    private State stateCode;
    
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
