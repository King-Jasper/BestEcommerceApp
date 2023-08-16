package jaspertechShoppingCentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "order_items")
public class CartItems extends BaseEntity{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String productName;
    private String imageUrl;
    private Integer orderQty;
    private Double unitPrice;
    private Double subTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

}
