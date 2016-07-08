package com.user.exception;

/**
 * Created by m481262 on 1/4/16.
 */
public class UserProfileException extends RuntimeException {
    private String message;

    public UserProfileException(String message, Throwable exception){
        super(exception);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
