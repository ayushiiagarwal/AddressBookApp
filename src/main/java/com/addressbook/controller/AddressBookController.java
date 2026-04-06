package com.addressbook.controller;

import com.addressbook.model.Contact;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/view/{type}")
    public Map<String, List<Contact>> view(@PathVariable String type){
        return addressBooks.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(contact -> {
                    if(type.equalsIgnoreCase("city")) return contact.getCity();
                    else if(type.equalsIgnoreCase("state")) return contact.getState();
                    else throw new IllegalArgumentException("Invalid type");
                }));
    }

    @GetMapping("/count/{type}")
    public Map<String, Long> count(@PathVariable String type){
        return addressBooks.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        contact -> {
                            if(type.equalsIgnoreCase("city")) return contact.getCity();
                            else if(type.equalsIgnoreCase("state")) return contact.getState();
                            else throw new IllegalArgumentException("Invalid type");
                        },
                        Collectors.counting()));
    }

    @GetMapping("/all")
    public Map<String, List<Contact>> getAllBooks(){
        return addressBooks;
    }
}