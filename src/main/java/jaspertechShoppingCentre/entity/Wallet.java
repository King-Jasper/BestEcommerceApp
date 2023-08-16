package jaspertechShoppingCentre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jaspertechShoppingCentre.enums.BaseCurrency;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    private BigDecimal accountBalance;

    private BaseCurrency baseCurrency;

    @OneToOne(mappedBy = "wallet", cascade = CascadeType.ALL)
    private AppUser appUser;

    @JsonIgnore
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Transactions> transactions;


}
