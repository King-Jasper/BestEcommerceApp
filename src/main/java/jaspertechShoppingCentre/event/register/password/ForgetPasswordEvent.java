package jaspertechShoppingCentre.event.register.password;

import jaspertechShoppingCentre.entity.AppUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class ForgetPasswordEvent extends ApplicationEvent {
private  String eventUrl;
private AppUser appUser;

public ForgetPasswordEvent(String eventUrl, AppUser appUser){
    super(appUser);
    this.eventUrl=eventUrl;
    this.appUser = appUser;
}



}
