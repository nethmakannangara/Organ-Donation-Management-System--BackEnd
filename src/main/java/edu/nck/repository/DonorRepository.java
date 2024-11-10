package edu.nck.repository;

import edu.nck.entity.DonorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DonorRepository extends CrudRepository<DonorEntity,String> {
    DonorEntity findByEmail(String email);
}
