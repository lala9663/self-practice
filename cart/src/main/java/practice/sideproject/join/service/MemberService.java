package practice.sideproject.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.sideproject.join.repository.MemberRepository;

import java.util.HashMap;

@Service
public class MemberService {

    @Autowired
    MemberRepository repo;

    public int insertMember(HashMap<String, String> member) {
        return repo.insertMember(member);
    }

    public HashMap<String, Object> loginMember(HashMap<String, String> member) {
        return repo.loginMember(member);
    }
}
