package edu.nck.service.impl;

import edu.nck.entity.LoginInfoEntity;
import edu.nck.model.LoginInfo;
import edu.nck.repository.LoginRepository;
import edu.nck.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public boolean register(LoginInfo loginInfo) {
        if(checkValidEmail(loginInfo.getEmail())){
            LoginInfoEntity savedEntity = loginRepository.save(mapper.map(loginInfo,LoginInfoEntity.class));

            if (savedEntity != null && savedEntity.getEmail() != null) {
                return true;
            }
        }
        return false;
    }

    //CHECK_VALID_EMAIL//
    private boolean checkValidEmail(String email){
        int atIndex = email.indexOf('@');
        int dotIndex = email.indexOf('.', atIndex);
        if (atIndex == -1 || dotIndex == -1) return false;

        return true;
    }
}
