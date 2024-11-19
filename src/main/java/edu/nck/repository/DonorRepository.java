package edu.nck.repository;

import edu.nck.entity.DonorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends CrudRepository<DonorEntity,String> {
    DonorEntity findByEmail(String email);
}
