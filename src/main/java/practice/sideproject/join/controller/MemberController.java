package practice.sideproject.join.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.sideproject.join.service.MemberService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MemberController {

    @Autowired
    MemberService ms;


    @PostMapping("/signup")
    public String insertMember(@RequestParam HashMap<String, String> params) {
        ms.insertMember(params);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginMember(@RequestParam HashMap<String, String> params, HttpSession session) {
        System.out.println("params.get(\"email\") = " + params.get("email"));
        System.out.println("params.get(\"password\") = " + params.get("password"));
        HashMap<String,Object> verified=ms.loginMember(params);
        System.out.println("verified.get(\"email\") = " + verified.get("USER_EMAIL"));
        System.out.println("verified.get(\"password\") = " + verified.get("USER_PW"));
        if(verified!=null){
            String email=String.valueOf(verified.get("USER_EMAIL"));
            session.setAttribute("email",email);
            System.out.println(session.getAttribute("email"));
            System.out.println("로그인성공");
            return "redirect:/";
        } else {
            System.out.println("로그인 실패");
            return "signup";
        }
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
            System.out.println("로그아웃");
        }
        return "redirect:/";
    }
}
