package jaspertechShoppingCentre.exceptions;

public class CustomerOrderNotFoundException extends RuntimeException{
    public CustomerOrderNotFoundException(String message) {
        super(message);
    }
}
