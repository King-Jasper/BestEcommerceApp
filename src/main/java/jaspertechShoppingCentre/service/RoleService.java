package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.RoleRequest;
import jaspertechShoppingCentre.dto.response.RoleResponse;

public interface RoleService {
    RoleResponse addRoles(RoleRequest roleRequest);
}
