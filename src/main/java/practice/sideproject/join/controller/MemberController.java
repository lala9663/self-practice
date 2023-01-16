package practice.sideproject.join.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        HashMap<String, Object> verified = ms.loginMember(params);
        if (verified != null) {
            String email = String.valueOf(verified.get("email"));
            session.setAttribute("email", email);
        }
        return "redirect:/";
    }

}
