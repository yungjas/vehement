package com.vehement.backend.repository;

import com.vehement.backend.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;


@Repository
public interface JournalRepository extends MongoRepository<Journal, String> {
    Optional<Journal> findByJournalId(String journalId);
    Optional<Journal> findByAuthorUsername(String authorUsername);
    Optional<Journal> findByTitle(String title);
}
