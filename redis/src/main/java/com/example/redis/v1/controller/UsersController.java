//package com.example.redis.v1.controller;
//
//
//import com.example.redis.jwt.JwtTokenProvider;
//import com.example.redis.v1.dto.ResponseDto;
//import com.example.redis.lib.Helper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.validation.Errors;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import static com.example.redis.v1.dto.ResponseDto.success;
//
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/users")
//@RestController
//public class UsersController {
//    private final JwtTokenProvider jwtTokenProvider;
//    private final UsersService usersService;
//
//
////    @PostMapping("/sign-up")
////    public ResponseDto<?> signUp(@Validated @RequestBody UserRequestDto.SignUp signUp, Errors errors) {
////        // validation check
////        if (errors.hasErrors()) {
////            return new ResponseDto<>(Helper.refineErrors(errors));
////        }
////        return usersService.signUp(signUp);
////    }
//    @PostMapping("/login")
//    public ResponseDto<?> login(@Validated @RequestBody UserRequestDto.Login login, Errors errors) {
//        // validation check
//        if (errors.hasErrors()) {
//            return new ResponseDto<>(Helper.refineErrors(errors));
//        }
//        return usersService.login(login);
//    }
//    @PostMapping("/reissue")
//    public ResponseDto<?> reissue(@Validated @RequestBody UserRequestDto.Reissue reissue, Errors errors) {
//        // validation check
//        if (errors.hasErrors()) {
//            return new ResponseDto<>(Helper.refineErrors(errors));
//        }
//        return usersService.reissue(reissue);
//    }
//
//    @PostMapping("/logout")
//    public ResponseDto<? extends Object> logout(@Validated @RequestBody UserRequestDto.Logout logout, Errors errors) {
//        // validation check
//        if (errors.hasErrors()) {
//            return new ResponseDto<>(Helper.refineErrors(errors));
//        }
//        return usersService.logout(logout);
//    }
//
//    @GetMapping("/authority")
//    public ResponseDto<?> authority() {
//        log.info("ADD ROLE_ADMIN");
//        return usersService.authority();
//    }
//
//    @GetMapping("/userTest")
//    public ResponseDto<?> userTest() {
//        log.info("ROLE_USER TEST");
//        return new ResponseDto<>(success());
//    }
//
//    @GetMapping("/adminTest")
//    public ResponseDto<?> adminTest() {
//        log.info("ROLE_ADMIN TEST");
//        return new ResponseDto<>(success());
//    }
//}
