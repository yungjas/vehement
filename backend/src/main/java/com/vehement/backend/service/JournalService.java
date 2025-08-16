package com.vehement.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.vehement.backend.repository.JournalRepository;
import com.vehement.backend.model.Journal;

@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepo;

    public List<Journal> getAllJournals(){
        return (List<Journal>) journalRepo.findAll();
    }

    public Journal getJournalById(String id){
        Optional<Journal> journal = journalRepo.findById(id);
        if(journal.isPresent()){
            return (Journal) journal.get();
        }
        return null;
    }
}
