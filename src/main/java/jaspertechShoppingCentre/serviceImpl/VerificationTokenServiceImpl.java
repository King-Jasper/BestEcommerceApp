package jaspertechShoppingCentre.serviceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jaspertechShoppingCentre.entity.AppUser;
import jaspertechShoppingCentre.entity.VerificationToken;
import jaspertechShoppingCentre.event.RegistrationCompleteEvent;
import jaspertechShoppingCentre.exceptions.AppUserNotFoundException;
import jaspertechShoppingCentre.exceptions.TokenNotFoundException;
import jaspertechShoppingCentre.repositories.AppUserRepository;
import jaspertechShoppingCentre.repositories.VerificationTokenRepository;
import jaspertechShoppingCentre.service.VerificationTokenService;
import jaspertechShoppingCentre.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@RequiredArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {
    private  final VerificationTokenRepository verificationTokenRepository;

    private  final AppUserRepository appUserRepository;

    private  final ApplicationEventPublisher publisher;

    @Override
    public void saveConfirmationToken(VerificationToken verificationToken) {
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String verifyUser(String token, HttpServletRequest request) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token)
                .orElseThrow(()->  new TokenNotFoundException("token not found "));
        AppUser user = verificationToken.getAppUser();
        if(user.getIsEnabled().equals(true)){
            return "User already verified, Proceed to login";
        }
        if(verificationToken.getExpiration().before(new Date())){
            verificationTokenRepository.delete(verificationToken);
            return "Verification link closed " +
                    " Please click on the link to get a new  verification link " +
                    EmailUtils.applicationUrl(request)+"/api/v1/auth/new-verification-link?email="
                    +  user.getEmail();

        }
        user.setIsEnabled(true);
        appUserRepository.save(user);
        return  "USER VERIFIED PROCEED TO LOGIN";
    }

    @Override
    public String sendUserVerificationMail(String email, HttpServletRequest request) {
        AppUser user = appUserRepository.findByEmail(email)
                .orElseThrow(()->new AppUserNotFoundException("user email not found"));
        if(user.getIsEnabled().equals(true)){
            return "User already verified, Proceed to login";
        }
        if(verificationTokenRepository.existsByAppUser(user)){
            verificationTokenRepository.delete(verificationTokenRepository.findByAppUser(user));
        }
        publisher.publishEvent(new RegistrationCompleteEvent( EmailUtils.applicationUrl(request),user));
        return "please check your email for verification link";
    }

}
