package com.example.redis.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@Table(name = "member")
@Setter
public class Member extends BaseTime implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_pw")
    private String memberPassword;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "member_phone")
    private String memberPhone;

    // localdate 로 바꾸기
    @Column(name = "member_birth")
    private String memberBirthDate;

    @Column(name = "member_grade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Grade memberGrade = Grade.NORMAL;

    @Column(name = "member_authority", nullable = false)
    private Boolean memberAuthority = false;

    @Column(name = "member_deleteCheck", nullable = false)
    private Boolean memberDeleteCheck = false;

    @Column(name = "member_hobby")
    @Enumerated(EnumType.STRING)
    private Hobby memberHobby;

    @Column
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public Member(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super();
    }

    @Builder
    public Member(String memberEmail, String memberPassword, String memberName, String memberNickname, String memberPhone, String memberBirthDate, Hobby memberHobby, List<String> roles) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberPhone = memberPhone;
        this.memberBirthDate = memberBirthDate;
        this.memberHobby = memberHobby;
        this.roles = roles;
    }

    public Member() {
        super();
    }
    //    @OneToMany(mappedBy = "member")
//    private List<Order> orders = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return memberPassword;
    }

    @Override
    public String getUsername() {
        return memberEmail;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
