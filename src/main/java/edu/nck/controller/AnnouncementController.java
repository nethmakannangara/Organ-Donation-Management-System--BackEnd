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

    @GetMapping
    public List<Announcement> getAll(){
        return announcementService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Announcement announcement){
        announcementService.create(announcement);
    }
}
