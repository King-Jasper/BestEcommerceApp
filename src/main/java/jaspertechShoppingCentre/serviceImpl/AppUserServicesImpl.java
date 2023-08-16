package jaspertechShoppingCentre.serviceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jaspertechShoppingCentre.dto.request.EditProfileRequest;
import jaspertechShoppingCentre.dto.request.LoginRequest;
import jaspertechShoppingCentre.dto.request.RegistrationRequest;
import jaspertechShoppingCentre.dto.response.EditProfileResponse;
import jaspertechShoppingCentre.dto.response.LoginResponse;
import jaspertechShoppingCentre.dto.response.RegistrationResponse;
import jaspertechShoppingCentre.dto.response.UserProfileResponse;
import jaspertechShoppingCentre.entity.AppUser;
import jaspertechShoppingCentre.entity.JwtToken;
import jaspertechShoppingCentre.entity.Role;
import jaspertechShoppingCentre.entity.Wallet;
import jaspertechShoppingCentre.enums.BaseCurrency;
import jaspertechShoppingCentre.enums.Gender;
import jaspertechShoppingCentre.event.RegistrationCompleteEvent;
import jaspertechShoppingCentre.exceptions.AppUserNotFoundException;
import jaspertechShoppingCentre.exceptions.UserCredentialsNotFoundException;
import jaspertechShoppingCentre.exceptions.UserDetailsNotFoundException;
import jaspertechShoppingCentre.repositories.AppUserRepository;
import jaspertechShoppingCentre.repositories.JwtTokenRepository;
import jaspertechShoppingCentre.repositories.RoleRepository;
import jaspertechShoppingCentre.repositories.WalletRepository;
import jaspertechShoppingCentre.security.JwtService;
import jaspertechShoppingCentre.service.AppUserService;
import jaspertechShoppingCentre.utils.EmailUtils;
import jaspertechShoppingCentre.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserServicesImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private  final PasswordEncoder passwordEncoder;

    private final ApplicationEventPublisher eventPublisher;

    private final JwtTokenRepository tokenRepository;

    private final WalletRepository walletRepository;

    private final RoleRepository roleRepository;

    private final JwtService jwtService;
    @Override
    public RegistrationResponse registerUser(RegistrationRequest registrationResquest, HttpServletRequest request) {
        AppUser appUser = mapToEntity(registrationResquest);

        Wallet wallet = Wallet.builder()
                .accountBalance(BigDecimal.ZERO)
                .baseCurrency(BaseCurrency.NAIRA)
                .appUser(appUser)
                .build();
        appUser.setWallet(wallet);
        walletRepository.save(wallet);
        var newAppUser = appUserRepository.save(appUser);
        eventPublisher.publishEvent(new RegistrationCompleteEvent(EmailUtils.applicationUrl(request),appUser));
        return RegistrationResponse.builder()
                .firstName(newAppUser.getFirstName())
                .lastName(newAppUser.getLastName())
                .message("successful")
                .build();
    }


    @Override
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        AppUser appUser = appUserRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->  new AppUserNotFoundException("user not found exception"));
        if(appUser.getIsEnabled().equals(true)){
            throw  new UserDetailsNotFoundException("User Account  not enabled");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), appUser.getPassword())){
            throw  new UserCredentialsNotFoundException("password does not match ");
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(appUser.getEmail(), appUser.getPassword());
        String  access_token = jwtService.generateAccessTokens(appUser);
        String  refresh_token = jwtService.generateRefreshTokens(appUser);

        JwtToken jwtToken = JwtToken.builder()
                .accessToken(access_token )
                .refreshToken(refresh_token)
                .appUser(appUser)
                .isExpired(false)
                .isRevoked(false)
                .build();
        jwtService.revokedAllUserToken(appUser);
        JwtToken token =    tokenRepository.save(jwtToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return  LoginResponse.builder()
                .accessToken(token.getAccessToken())
                .refreshToken(token.getRefreshToken())
                .userFullName(appUser.getFirstName() + " "+ appUser.getLastName())
                .message("successfully login")
                .build();
    }

    @Override
    public EditProfileResponse editProfile(EditProfileRequest editProfileRequest) {
       AppUser loginUser = appUserRepository.findByEmail(UserUtils.getUserEmailFromContext())
               .orElseThrow(()-> new AppUserNotFoundException("user not Found"));
       loginUser.setFirstName(editProfileRequest.getFirstName());
       loginUser.setEmail(editProfileRequest.getEmail());
       loginUser.setDate_of_birth(editProfileRequest.getDate_of_birth());
       loginUser.setPhone(editProfileRequest.getPhone());
       loginUser.setGender(editProfileRequest.getGender());
       var newUserProfile = appUserRepository.save(loginUser);
       return mapToEditProfileResponse(newUserProfile);
    }

    @Override
    public UserProfileResponse viewUserProfile() {
        AppUser loginUser = appUserRepository.findByEmail(UserUtils.getUserEmailFromContext())
                .orElseThrow(() -> new AppUserNotFoundException("User not found"));

        if (loginUser == null) {
            throw new AppUserNotFoundException("User not found");
        }

        return mapToUserProfileResponse(loginUser);
    }


    @Override
    public Page<UserProfileResponse> viewAllUserProfilesByPaginationAndSort(Integer pageNo,
                                                                            Integer pageSize,
                                                                            String sortBy) {
        List<AppUser> userPage = appUserRepository.findAll();
        List<UserProfileResponse> customerProfile =userPage.stream()
                .map(person-> UserProfileResponse.builder()
                        .firstName(person.getFirstName())
                        .lastName(person.getLastName())
                        .email(person.getEmail())
                        .phone(person.getPhone())
                        .date_of_birth(person.getDate_of_birth())
                        .gender(person.getGender())
                        .build())
                .collect(Collectors.toList());
        PageRequest pageRequest    =PageRequest.of(pageNo,pageSize, Sort.Direction.DESC, sortBy);
        int maxPage = Math.min(pageSize * (pageNo+1),customerProfile.size());
        return new PageImpl<>(customerProfile.subList(pageNo*pageSize,maxPage),pageRequest,customerProfile.size());


    }

    private UserProfileResponse mapToUserProfileResponse(AppUser loginUser) {
        return UserProfileResponse.builder()
                .firstName(loginUser.getFirstName())
                .lastName(loginUser.getLastName())
                .email(loginUser.getEmail())
                .phone(loginUser.getPhone())
                .date_of_birth(loginUser.getDate_of_birth())
                .gender(loginUser.getGender())
                .build();
    }

    private EditProfileResponse mapToEditProfileResponse(AppUser newUserProfile) {
        return EditProfileResponse.builder()
                .firstName(newUserProfile.getFirstName())
                .lastName(newUserProfile.getLastName())
                .email(newUserProfile.getEmail())
                .date_of_birth(newUserProfile.getDate_of_birth())
                .phone(newUserProfile.getPhone())
                .build();

    }

    private void saveUserToken(AppUser appUser, String accessToken, String refresh_token) {

        JwtToken jwtToken = JwtToken.builder()
                .accessToken(accessToken)
                .refreshToken(refresh_token)
                .appUser(appUser)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepository.save(jwtToken);
    }


    private AppUser mapToEntity(RegistrationRequest requesteqquest) {
        Role role = roleRepository.findRoleName("CUSTOMER");
        return AppUser.builder()
                .firstName(requesteqquest.getFirstName())
                .lastName(requesteqquest.getLastName())
                .phone(requesteqquest.getPhone())
                .password(passwordEncoder.encode(requesteqquest.getPassword()))
                .date_of_birth(requesteqquest.getDateOfBirth())
                .isEnabled(false)
                .role(role)
                .gender(Gender.MALE)
                .email(requesteqquest.getEmail())
                .build();
    }
}