package jaspertechShoppingCentre.serviceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jaspertechShoppingCentre.dto.request.ResetPasswordRequest;
import jaspertechShoppingCentre.entity.AppUser;
import jaspertechShoppingCentre.entity.VerificationToken;
import jaspertechShoppingCentre.event.register.password.ForgetPasswordEvent;
import jaspertechShoppingCentre.exceptions.AppUserNotFoundException;
import jaspertechShoppingCentre.exceptions.SamePasswordException;
import jaspertechShoppingCentre.repositories.AppUserRepository;
import jaspertechShoppingCentre.repositories.VerificationTokenRepository;
import jaspertechShoppingCentre.service.PasswordService;
import jaspertechShoppingCentre.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private final AppUserRepository appUserRepository;
    private final ApplicationEventPublisher publisher;
    private HttpServletRequest request;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;



    @Override
    public String forgetPassword(String email, HttpServletRequest request) {
       AppUser appUser = appUserRepository.findByEmail(email)
               .orElseThrow(()->new AppUserNotFoundException("user not found Exception"));
        VerificationToken token = verificationTokenRepository.findByAppUser(appUser);
        if(token==null){
            verificationTokenRepository.delete(token);
        }

     publisher.publishEvent(new ForgetPasswordEvent(EmailUtils.forgetPasswordUrl(request), appUser));
        return "Please check your mail for password Reset Link";
    }

    @Override
    public String resetPassword(ResetPasswordRequest request) {
        AppUser appUser = appUserRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new AppUserNotFoundException("user not found exception"));
        if(passwordEncoder.matches(appUser.getPassword(), request.getPassword())){
            throw new SamePasswordException("Please choose a different Password");
        }
        appUser.setPassword(request.getPassword());
        appUserRepository.save(appUser);
        return "password is successfully changed";
    }
}
