package practice.sideproject.join.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.sideproject.join.mapper.MemberMapper;

import java.util.HashMap;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mapper;

    public int insertMember(HashMap<String,String> member) {
        return mapper.insertMember(member);
    }

    public HashMap<String, Object> loginMember(HashMap<String, String> member) {
        return mapper.loginMember(member);
    }

}
