package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

@RequiredArgsConstructor
public class DrivingLicenceCreateService {

    private final InMemoryDatabase database;

    private final SocialSecurityNumberValidatorService socialSecurityNumberValidatorService;

    public Optional<DrivingLicence> createNewDrivingLicence(String driverSocialSecurityNumber){
        throw new NotImplementedException();
    }
}
