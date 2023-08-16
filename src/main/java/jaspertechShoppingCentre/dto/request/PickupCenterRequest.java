package jaspertechShoppingCentre.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PickupCenterRequest {
    private String name;
    private String location;
    private Long stateId;
    private String email;
    private String phone;

    private String address;

    private  Double delivery;
}
