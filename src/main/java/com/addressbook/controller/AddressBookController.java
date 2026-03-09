package com.addressbook.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AddressBookController {
    
    @GetMapping("/addressbook")
    public String welcomeMessage() {
        return "Welcome to Address Book Program";
    }
}
