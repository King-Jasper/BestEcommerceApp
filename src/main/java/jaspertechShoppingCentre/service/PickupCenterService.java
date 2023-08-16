package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.PickupCenterRequest;
import jaspertechShoppingCentre.dto.response.PickupCenterResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PickupCenterService {
    PickupCenterResponse addNewPickupCenter(PickupCenterRequest pickupCenterRequest);

    List<PickupCenterResponse> findCenterByStateName(String name);

    PickupCenterResponse updatePickupCenter(Long centerId, PickupCenterRequest pickupCenterRequest);

    String  deleteCenter(Long centerId);

    Page<PickupCenterResponse> viewAllCenter(Integer pageNo, Integer pageSize, String sortBy);

}
