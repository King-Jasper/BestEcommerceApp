package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.AddressRequest;
import jaspertechShoppingCentre.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {
    AddressResponse addNewAddress(AddressRequest addressRequest);

    AddressResponse viewAddress(Long addressId);

    AddressResponse updateAddress(Long addressId, AddressRequest addressRequest);

    List<  AddressResponse> viewAllAddresses();

    String deleteAddress(Long addressId);
}
