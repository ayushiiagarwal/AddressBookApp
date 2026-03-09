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
        Contact c1 = new Contact(01, "Olive", "9123658974");
        Contact c2 = new Contact(02, "Adam", "9854721451");

        return Arrays.asList(c1, c2);
    }
}
