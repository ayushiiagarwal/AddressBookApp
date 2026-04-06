package com.addressbook.controller;

import com.addressbook.model.Contact;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private Map<String, List<Contact>> addressBooks = new HashMap<>();

    @PostMapping("/add/{bookName}")
    public String addContact(@PathVariable String bookName, @RequestBody Contact contact){
        List<Contact> contacts = addressBooks.computeIfAbsent(bookName, a -> new ArrayList<>());

        boolean isDuplicate = contacts.stream().anyMatch(existing -> existing.equals(contact));

        if(isDuplicate) return "Contact already exists in " + bookName;

        contacts.add(contact);
        return "Contact added to " + bookName + " address book successfully.";
    }

    @GetMapping("/{bookName}")
    public List<Contact> getAllContacts(@PathVariable String bookName) {
        return addressBooks.getOrDefault(bookName, new ArrayList<>());
    }

    @GetMapping("/search/{cityState}")
    public List<Contact> searchByCityState(@PathVariable String cityState){
        return addressBooks.values().stream()
                .flatMap(List::stream)
                .filter(contact ->
                        contact.getCity().equalsIgnoreCase(cityState) ||
                        contact.getState().equalsIgnoreCase(cityState)).toList();
    }

    @GetMapping("/all")
    public Map<String, List<Contact>> getAllBooks(){
        return addressBooks;
    }
}