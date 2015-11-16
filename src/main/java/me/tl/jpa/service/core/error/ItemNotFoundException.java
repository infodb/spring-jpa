package me.tl.jpa.service.core.error;

/**
 * Created by thierry on 16/11/2015.
 */
public class ItemNotFoundException extends Exception {
    private static final long serialVersionUID = 9008400246961495673L;

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
