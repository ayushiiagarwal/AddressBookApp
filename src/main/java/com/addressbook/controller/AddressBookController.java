package com.addressbook.controller;

import com.addressbook.model.Contact;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private List<Contact> contacts = new ArrayList<>();

    @PostMapping("/add")
    public String createContact(@RequestBody Contact contact){
        return "Contact added successfully.";
    }

    @GetMapping("/allContacts")
    public List<Contact> getAllContacts() {
        return contacts;
    }

    @PutMapping("/edit/{firstName}")
    public String editContact(@PathVariable String firstName, @RequestBody Contact contact) {
        for(Contact c : contacts){
            if(c.getFirstName().equalsIgnoreCase(firstName)){
                c.setLastName(contact.getLastName());
                c.setAddress(contact.getAddress());
                c.setCity(contact.getCity());
                c.setState(contact.getState());
                c.setZip(contact.getZip());
                c.setPhone(contact.getPhone());

                return "Contact edited successfully!";
            }
        }

        return "Contact not found!";
    }
}
