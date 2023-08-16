package jaspertechShoppingCentre.dto.response;

import jaspertechShoppingCentre.entity.State;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PickupCenterResponse {
    private String name;
    private String location;
    private State state;
    private String email;
    private String phone;

    private String address;

    private  Double delivery;
}
