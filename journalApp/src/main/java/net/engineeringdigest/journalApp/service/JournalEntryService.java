package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    JournalEntryRepository journalEntryRepository;


    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getEntry(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(String myId){
        return journalEntryRepository.findById(myId);
    }

    public void deleteEntryById(String myId){
        journalEntryRepository.deleteById(myId);

    }
}
