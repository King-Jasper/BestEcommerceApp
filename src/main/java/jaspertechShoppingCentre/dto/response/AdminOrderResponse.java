package jaspertechShoppingCentre.dto.response;

import jaspertechShoppingCentre.enums.PickupStatus;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrderResponse {
    private String firstName;
    private String lastName;
    private String phone;
    private Double grandTotal;
    private String status;
    private PickupStatus pickupStatus;
    private String pickupCenterName;
    private String pickupCenterAddress;
}
