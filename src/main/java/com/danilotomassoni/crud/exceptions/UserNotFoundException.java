package com.danilotomassoni.crud.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String email) {
        super("User Not Found EMAIL: " + email);
    }
}
