package com.bookinventory.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a regional jurisdiction or state.
 * Maps to the 'state' table and provides standardized geographical 
 * data for addresses and logistics.
 */
@Entity
@Table(name = "state")
public class State {

    /**
     * The unique 2-character abbreviation for the state (e.g., 'NY', 'DL').
     * Serves as the natural primary key for the entity.
     */
    @Id
    @Column(name = "StateCode", length = 2)
    private String stateCode;

    /**
     * The full, official name of the state (e.g., 'New York', 'Delhi').
     * Limited to 50 characters for standardized data entry and display.
     */
    @Column(name = "StateName", length = 50)
    private String stateName;

    public State() {
    }

    public State(String stateCode, String stateName) {
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
