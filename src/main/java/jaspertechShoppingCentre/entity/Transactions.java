package jaspertechShoppingCentre.entity;

import jakarta.persistence.*;
import jaspertechShoppingCentre.enums.PaymentPurpose;
import jaspertechShoppingCentre.enums.TransactionStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Amount ;

    private String reference;

    @Enumerated(EnumType.STRING)
    private PaymentPurpose paymentPurpose;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private Wallet wallet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;
}
