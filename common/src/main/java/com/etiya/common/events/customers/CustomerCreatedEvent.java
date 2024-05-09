package com.etiya.common.events.customers;

public class CustomerCreatedEvent {

    private String id;
    private String firstName;

    public CustomerCreatedEvent() {
    }

    public CustomerCreatedEvent(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
