package com.furkan.thyrestapi.controllers;

import java.util.List;
import java.util.Optional;

import com.furkan.thyrestapi.models.PageRepository;
import com.furkan.thyrestapi.models.data.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ResponseBody;


//@Controller
@RestController
@RequestMapping(path = "/pages", produces = "application/json")
@CrossOrigin(origins = "*")
public class PagesController {

    /*@GetMapping
    public @ResponseBody String Pages() {

        return "hello";
    }*/

    @Autowired
    PageRepository pageRepository;

    @GetMapping("/all")
    public Iterable<Page> pages() {
        
        List<Page> pages = pageRepository.findAllByOrderBySortingAsc();
        
        return pages;
    }

    /*@GetMapping("/{slug}")
    public Page page(@PathVariable String slug) {
        
        Page page = pageRepository.findBySlug(slug);
        if (page == null) return null;
        return page;
    }*/

    @GetMapping("/{slug}")
    public ResponseEntity<Page> page(@PathVariable String slug) {

        /*Page page = pageRepository.findBySlug(slug);
        if (page == null) return null;
        return page;*/
        
        
        Optional<Page> optPage = pageRepository.findBySlug(slug);

        if (optPage.isPresent()) {
            return new ResponseEntity<>(optPage.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
