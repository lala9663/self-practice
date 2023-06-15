package practice.sideproject.join.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {

    public int insertMember(HashMap<String, String> USER_TB);

    public HashMap<String, Object> loginMember(HashMap<String, String> USER_TB);

}
