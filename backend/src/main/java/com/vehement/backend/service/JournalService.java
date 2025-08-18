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

    //TODO: get journal by a particular user

    public Journal getJournalById(String id){
        Optional<Journal> journal = journalRepo.findById(id);
        if(journal.isPresent()){
            return (Journal) journal.get();
        }
        return null;
    }

    //TODO: CREATE
    public Journal createJournal(Journal journal){
        journalRepo.save(journal);
        return journal;
    }

    //TODO: UPDATE
    public Journal updateJournalById(String id, Journal updateJournal){
        Optional<Journal> journal = journalRepo.findById(id);
        Journal journalData = null;

        if(journal.isPresent()){
            journalData = journal.get();
            journalData.setTitle(updateJournal.getTitle());
            journalData.setDesc(updateJournal.getDesc());
            journalData.setAuthorUsername(updateJournal.getAuthorUsername());
            journalData.setDatePublished(updateJournal.getDatePublished());
            journalData.setDateEdited(updateJournal.getDateEdited());

            journalRepo.save(journalData);
        }

        return journalData;
    }

    public Boolean deleteJournalById(String id){
        Optional<Journal> journal = journalRepo.findById(id);
        if(journal.isPresent()){
            journalRepo.deleteById(id);
            return true;
        }
        return false;
    }
    
}
