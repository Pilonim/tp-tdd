package fr.esgi.cleancode.service;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SocialSecurityNumberValidatorService {

    public void isValidDriverSocialSecurityNumber(String driverSocialSecurityNumber){
        if(driverSocialSecurityNumber == null){
            throw new InvalidDriverSocialSecurityNumberException("Security number is null");
        }else if(driverSocialSecurityNumber.length() != 15){
            throw new InvalidDriverSocialSecurityNumberException("Invalid length");
        }else if(!driverSocialSecurityNumber.matches("\\d+")){
            throw new InvalidDriverSocialSecurityNumberException("Not only numbers");
        }
    }
}
