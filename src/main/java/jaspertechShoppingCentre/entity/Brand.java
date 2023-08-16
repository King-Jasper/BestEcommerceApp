package jaspertechShoppingCentre.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Brand")
public class Brand extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String brandName;

    private String brandDescription;

    private String logoUrl;

    private LocalDateTime establishedDate;

    @OneToMany(mappedBy = "brand")

    private List<Product> products;
}
