package practice.sideproject.basket.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(name = "b_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Products.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "p_id")
    private Products products;  // 상품 번호

    @ManyToOne(targetEntity = Members.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "m_id")
    private Members members;    // 유저 번호
}
