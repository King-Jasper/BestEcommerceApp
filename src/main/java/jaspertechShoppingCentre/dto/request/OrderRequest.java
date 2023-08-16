package jaspertechShoppingCentre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private BigDecimal grandTotal;
    private String pickupCenterEmail;

    private  String emailAddress;

}
