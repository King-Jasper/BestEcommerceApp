package jaspertechShoppingCentre.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateRequest {
    private Long stateId;

    private String stateName;
}
