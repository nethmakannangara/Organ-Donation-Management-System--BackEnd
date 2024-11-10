package edu.nck.service;

import edu.nck.model.Announcement;

import java.util.List;

public interface AnnouncementService {

    List<Announcement> getAll();

    void create(Announcement announcement);
}
