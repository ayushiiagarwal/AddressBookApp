package com.addressbook.model;

public class Contact {
    private String firstName, lastName, address, 
    city, state, zip, phone;

    public Contact(String firstName, String lastName, String address, String city,
        String state, String zip, String phone){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public String getFirstName(){ return firstName; }

    public String getLastName(){ return lastName; }

    public String getAddress(){ return address; }

    public String getCity(){ return city; }

    public String getState(){ return state; }

    public String getZip(){ return zip; }

    public String getPhone(){ return phone; }
}
