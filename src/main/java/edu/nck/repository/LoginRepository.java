package edu.nck.repository;

import edu.nck.entity.LoginInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginInfoEntity,String> {
}
