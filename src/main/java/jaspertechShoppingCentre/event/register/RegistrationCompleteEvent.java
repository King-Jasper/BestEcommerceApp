package jaspertechShoppingCentre.event.register;

import jaspertechShoppingCentre.entity.AppUser;
import jaspertechShoppingCentre.entity.VerificationToken;
import jaspertechShoppingCentre.service.VerificationTokenService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private String applicationUrl;
    private AppUser appUser;
    public RegistrationCompleteEvent(String applicationUrl, AppUser appUser){
        super(appUser);
        this.applicationUrl = applicationUrl;
        //AppUser = appUser;
    }


    }


