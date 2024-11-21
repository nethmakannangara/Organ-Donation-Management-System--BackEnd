package edu.nck.service;

import edu.nck.entity.LoginInfoEntity;
import edu.nck.model.LoginInfo;
import org.springframework.data.repository.CrudRepository;

public interface LoginService {
    boolean register(LoginInfo loginInfo);
}
