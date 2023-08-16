package jaspertechShoppingCentre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private String fullName;
    private String phone;
    private String emailAddress;
    private String street;

    private Long stateId;
    private String country;
}
