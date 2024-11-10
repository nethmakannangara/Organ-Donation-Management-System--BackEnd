package edu.nck.repository;

import edu.nck.entity.AnnouncementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface AnnouncementRepository extends CrudRepository<AnnouncementEntity,String> {
}
