package com.addressbook.controller;

import com.addressbook.model.Contact;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

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
}
