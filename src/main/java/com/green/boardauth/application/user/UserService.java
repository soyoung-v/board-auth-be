package com.green.boardauth.application.user;

import com.green.boardauth.application.model.UserGetOneRes;
import com.green.boardauth.application.model.UserSignInReq;
import com.green.boardauth.application.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public int sigUp(UserSignUpReq req){
        String hashedPw = passwordEncoder.encode(req.getUpw());
        log.info("pw: {}", hashedPw);
        req.setUpw(hashedPw);
        return userMapper.signUp(req);
    }
    public int sigIn(UserSignInReq req){
        UserGetOneRes res = userMapper.findByUid(req.getUid());
        log.info("res: {}", res);
        if(!passwordEncoder.matches(req.getUpw(),res.getUpw())){
            return 0;
        }
        return 1;
    }
}
