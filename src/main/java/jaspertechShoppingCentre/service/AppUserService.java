package jaspertechShoppingCentre.service;

import jakarta.servlet.http.HttpServletRequest;
import jaspertechShoppingCentre.dto.request.EditProfileRequest;
import jaspertechShoppingCentre.dto.request.LoginRequest;
import jaspertechShoppingCentre.dto.request.RegistrationRequest;
import jaspertechShoppingCentre.dto.response.EditProfileResponse;
import jaspertechShoppingCentre.dto.response.LoginResponse;
import jaspertechShoppingCentre.dto.response.RegistrationResponse;
import jaspertechShoppingCentre.dto.response.UserProfileResponse;
import org.springframework.data.domain.Page;

public interface AppUserService {
    RegistrationResponse registerUser(RegistrationRequest registrationResquest, HttpServletRequest request);

    LoginResponse authenticateUser(LoginRequest loginRequest);

    EditProfileResponse editProfile(EditProfileRequest editProfileRequest);

    UserProfileResponse viewUserProfile();

    Page<UserProfileResponse> viewAllUserProfilesByPaginationAndSort(Integer pageNo, Integer pageSize, String sortBy);




}
