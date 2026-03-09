package com.addressbook.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.model.Contact;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @PostMapping("/create")
    public Contact createContact(@RequestBody Contact contact){
        return contact;
    }
}
