package jaspertechShoppingCentre.service;

import jakarta.servlet.http.HttpServletRequest;
import jaspertechShoppingCentre.entity.VerificationToken;
import org.springframework.stereotype.Service;

@Service
public interface VerificationTokenService {

    void saveConfirmationToken(VerificationToken verificationToken);


    String verifyUser(String token, HttpServletRequest request);

    String sendUserVerificationMail(String email, HttpServletRequest request);
}
