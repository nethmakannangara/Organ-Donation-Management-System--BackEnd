package edu.nck.service.impl;

import edu.nck.entity.AnnouncementEntity;
import edu.nck.model.Announcement;
import edu.nck.repository.AnnouncementRepository;
import edu.nck.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private ModelMapper mapper = new ModelMapper();


    @Override
    public List<Announcement> getAll() {
        Iterable<AnnouncementEntity> announcementEntities = announcementRepository.findAll();
        List<Announcement> announcementList = new ArrayList<>();
        announcementEntities.forEach(announcement -> {
            announcementList.add(mapper.map(announcement,Announcement.class));
        });
        return announcementList;
    }

    @Override
    public void create(Announcement announcement) {
        announcementRepository.save(mapper.map(announcement,AnnouncementEntity.class));
    }
}
