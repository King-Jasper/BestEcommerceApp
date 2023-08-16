package jaspertechShoppingCentre.dto.response;

import jaspertechShoppingCentre.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private Role role;
}
