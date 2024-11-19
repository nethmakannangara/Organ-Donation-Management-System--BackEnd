package edu.nck.repository;

import edu.nck.entity.AnnouncementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AnnouncementRepository extends CrudRepository<AnnouncementEntity,String> {
}
