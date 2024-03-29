package jaspertechShoppingCentre.dto.response;

import jaspertechShoppingCentre.entity.PickupCenter;
import lombok.*;

import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StateResponse {
    private Long id;

    private String stateName;

    private Set<PickupCenter> pickupCenterSet;

}
