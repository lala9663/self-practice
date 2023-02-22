package practice.sideproject.basket.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "members")
public class Members {

    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_pw")
    private String pw;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_age")
    private int age;

    @Column(name = "member_gender")
    private char gender;

    @Column(name = "member_phone")
    private String phone;

    @Column(name = "member_salary")
    private int salary;
}
