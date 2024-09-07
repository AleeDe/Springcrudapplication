package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getEntry();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);

        return myEntry;

    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable String myId){
        return journalEntryService.getEntryById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable String myId){
        journalEntryService.deleteEntryById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public boolean editJournalEntryById(@PathVariable String myId, @RequestBody JournalEntry updated_entry){
        JournalEntry old = journalEntryService.getEntryById(myId).orElse(null);
        if(old != null){
            old.setTitle( updated_entry.getTitle() != null && !updated_entry.getTitle().equals("")? updated_entry.getTitle(): old.getTitle());
            old.setContent( updated_entry.getContent() != null && !updated_entry.getContent().equals("")? updated_entry.getContent(): old.getContent());
            old.setDate(LocalDateTime.now());
        }
        journalEntryService.saveEntry(old);
        return true;
    }

}
