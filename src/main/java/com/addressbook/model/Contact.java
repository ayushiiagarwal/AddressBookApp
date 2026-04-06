package com.addressbook.model;

import java.util.Objects;

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
    public void setFirstName(String firstName){ this.firstName = firstName; }

    public String getLastName(){ return lastName; }
    public void setLastName(String lastName){ this.lastName = lastName; }

    public String getAddress(){ return address; }
    public void setAddress(String address){ this.address = address; }

    public String getCity(){ return city; }
    public void setCity(String city){ this.city = city; }

    public String getState(){ return state; }
    public void setState(String state){ this.state = state; }

    public String getZip(){ return zip; }
    public void setZip(String zip){ this.zip = zip; }

    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone = phone; }

    public String toString(){
        return firstName + " " + lastName + "\n" + address + "\n" + city + 
        ", " + state + ", " + zip + phone;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        return firstName.equalsIgnoreCase(contact.firstName) &&
                lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }
}
