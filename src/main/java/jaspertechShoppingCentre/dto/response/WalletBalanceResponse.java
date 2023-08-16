package jaspertechShoppingCentre.dto.response;

import lombok.*;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WalletBalanceResponse {
    private BigDecimal currentBalance;
}
