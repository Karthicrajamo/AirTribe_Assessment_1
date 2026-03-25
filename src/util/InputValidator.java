package util;

import exception.InvalidInputException;

public class InputValidator {

    public static void requireValidEmail(String email) throws InvalidInputException{
        if(email == null || !email.contains("@") || !email.contains(".")){
            throw new InvalidInputException("Invalid Email");
        }
    }

    public static void requireNonBlank(String value,String fieldName) throws InvalidInputException {
        if(value == null || value.trim().isEmpty()){
            throw new InvalidInputException(fieldName+" cannot be blank");
        }
    }
}
