package com.vehement.backend.controller;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.vehement.backend.service.JournalService;
import com.vehement.backend.model.Journal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



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

    @PostMapping("create")
    public ResponseEntity<Journal> createJournal(@RequestBody Journal journal) {
        Journal createdJournal = journalService.createJournal(journal);

        if(createdJournal == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }

        return new ResponseEntity<>(createdJournal, HttpStatus.OK);
    }
    
    @PutMapping("update-journal/{id}")
    public ResponseEntity<Journal> putMethodName(@PathVariable String id, @RequestBody Journal updateJournal) {
        Journal updatedJournal = journalService.updateJournal(id, updateJournal);
        
        if(updatedJournal == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }

        return new ResponseEntity<>(updatedJournal, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Journal> deleteJournalById(@PathVariable String id){
        Boolean isDeleted = journalService.deleteJournalById(id);

        if(isDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
