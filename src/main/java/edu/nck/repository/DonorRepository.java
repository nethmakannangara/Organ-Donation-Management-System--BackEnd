package edu.nck.repository;

import edu.nck.entity.DonorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DonorRepository extends CrudRepository<DonorEntity,String> {
}
