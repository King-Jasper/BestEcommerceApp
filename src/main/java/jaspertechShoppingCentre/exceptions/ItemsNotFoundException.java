package jaspertechShoppingCentre.exceptions;

public class ItemsNotFoundException extends RuntimeException{
    public ItemsNotFoundException(String message) {
        super(message);
    }
}
