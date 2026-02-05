package com.green.boardauth.application.user;

import com.green.boardauth.application.model.UserSignInReq;
import com.green.boardauth.application.model.UserSignUpReq;
import com.green.boardauth.configuration.model.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResultResponse<Integer> sigUp(@RequestBody UserSignUpReq req){
        log.info("p: {}", req);
        int result = userService.sigUp(req);
        return  new ResultResponse<>("회원가입 성공", result);
    }

    @PostMapping("/signin")
    public ResultResponse<Integer> SignIn(@RequestBody UserSignInReq req){
        log.info("req: {}", req);
        int result = userService.sigIn(req);
        return new ResultResponse<>(result ==1 ? "로그인 성공" : "로그인 실패", result);
    }

}
