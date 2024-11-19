package edu.nck.controller;

import edu.nck.model.Announcement;
import edu.nck.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("/all")
    public List<Announcement> getAll(){
        return announcementService.getAll();
    }

    @GetMapping("/{announcementId}")
    public Announcement get(@RequestParam String announcementId){
        return announcementService.get(announcementId);
    }

    @PostMapping
    public void create(@RequestBody Announcement announcement){
        announcementService.create(announcement);
    }

    @DeleteMapping
    public void delete(@RequestParam String announcementId){
        announcementService.delete(announcementId);
    }

    @PutMapping
    public void update(@RequestBody Announcement announcement){
        announcementService.update(announcement);
    }
}
