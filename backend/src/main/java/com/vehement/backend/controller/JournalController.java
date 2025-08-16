package com.vehement.backend.controller;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.vehement.backend.service.JournalService;
import com.vehement.backend.model.Journal;

@RestController
@CrossOrigin
@RequestMapping(path="api/journals")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping("all")
    public ResponseEntity<List<Journal>> getAllJournals(){
        List<Journal> allJournals = journalService.getAllJournals();
        if(allJournals.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allJournals, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable String id){
        Journal journal = journalService.getJournalById(id);

        if(journal == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }

        return new ResponseEntity<>(journal, HttpStatus.OK);
    }
}
