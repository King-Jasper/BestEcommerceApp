package jaspertechShoppingCentre.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletInfoRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String walletBalance;
    private String baseCurrency;
}
