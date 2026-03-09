package com.addressbook.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.model.Contact;

@RestController
public class AddressBookController {
    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        Contact c1 = new Contact("Adam", "Connor", "NY-101", "New York City", "New York", "4555184", "9587463256");
        Contact c2 = new Contact("Olive", "Smith", "PR-154", "Paris", "France", "5544475", "7458963214");

        return Arrays.asList(c1, c2);
    }
}
