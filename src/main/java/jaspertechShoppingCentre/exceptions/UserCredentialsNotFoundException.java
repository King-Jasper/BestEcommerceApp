package jaspertechShoppingCentre.exceptions;

public class UserCredentialsNotFoundException extends RuntimeException{
    public UserCredentialsNotFoundException(String message) {
        super(message);
    }
}
