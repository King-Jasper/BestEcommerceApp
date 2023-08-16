package jaspertechShoppingCentre.exceptions;

public class AppUserNotFoundException extends RuntimeException {
    public AppUserNotFoundException(String email) {
        super(email+ "already Registered");
    }
}
