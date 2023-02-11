package practice.sideproject.basket.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
public class Products {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_brand")
    private String brand;

    @Column(name = "product_logo")
    private String logo;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_rate")
    private String rate;

    @Column(name = "product_phone")
    private String phone;

    @Column(name = "detail")
    private String detail;
}
