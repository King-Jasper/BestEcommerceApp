package jaspertechShoppingCentre.serviceImpl;

import jaspertechShoppingCentre.dto.request.AddressRequest;
import jaspertechShoppingCentre.dto.response.AddressResponse;
import jaspertechShoppingCentre.entity.Address;
import jaspertechShoppingCentre.entity.AppUser;
import jaspertechShoppingCentre.entity.State;
import jaspertechShoppingCentre.exceptions.AddressNotFoundException;
import jaspertechShoppingCentre.exceptions.AppUserNotFoundException;
import jaspertechShoppingCentre.exceptions.StateNotFoundException;
import jaspertechShoppingCentre.repositories.AddressRepository;
import jaspertechShoppingCentre.repositories.AppUserRepository;
import jaspertechShoppingCentre.repositories.StateRepository;
import jaspertechShoppingCentre.service.AddressService;
import jaspertechShoppingCentre.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    private final StateRepository stateRepository;

    private final AppUserRepository appUserRepository;
    @Override
    public AddressResponse addNewAddress(AddressRequest addressRequest) {
        AppUser appUser = appUserRepository.findByEmail(UserUtils.getUserEmailFromContext())
                .orElseThrow(()-> new AppUserNotFoundException("user not found"));

        State state = stateRepository.findById(addressRequest.getStateId())
                .orElseThrow(()-> new StateNotFoundException("state not found"));
        Address address = mapToAddress(addressRequest,appUser);
        address.setState (state);
        appUser.setAddress(address);
        appUserRepository.save(appUser);

        var newAddress = addressRepository.save(address);

        return mapToAddressResponse(newAddress);

    }

    @Override
    public AddressResponse viewAddress(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new AppUserNotFoundException("Address not found "));

        return  mapToAddressResponse(address);
    }

    @Override
    public AddressResponse updateAddress(Long addressId, AddressRequest addressRequest) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new AddressNotFoundException("Address not found "));
        address.setCountry (address.getCountry());
        address.setFullName(addressRequest.getFullName());
        address.setEmailAddress(addressRequest.getEmailAddress());
        address.setPhone(addressRequest.getPhone());
        address.setStreet(addressRequest.getStreet());
        addressRepository.save(address);
        return mapToAddressResponse(address);
    }

    @Override
    public List<AddressResponse> viewAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(this::mapToAddressResponse).collect(Collectors.toList());
    }

    @Override
    public String deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new AddressNotFoundException("Address not found "));
        addressRepository.delete(address);
        return " Address successfully , deleted";
    }


    private AddressResponse mapToAddressResponse(Address newAddress) {
        return AddressResponse.builder()

                .fullName(newAddress.getFullName())
                .phone(newAddress.getPhone())
                .emailAddress(newAddress.getEmailAddress())
                .street(newAddress.getStreet())
                .state(State.builder()
                        .id(newAddress.getState().getId())
                        .name(newAddress.getState().getName())
                        .build())
                .country(newAddress.getCountry())
                .build();
    }

    private Address mapToAddress(AddressRequest addressRequest,AppUser appUser) {
        return Address.builder()
                .fullName(addressRequest.getFullName())
                .phone(addressRequest.getPhone())
                .emailAddress(addressRequest.getEmailAddress())
                .street(addressRequest.getStreet())
                .country(addressRequest.getCountry())
                .user(appUser)
                .build();



    }
}


