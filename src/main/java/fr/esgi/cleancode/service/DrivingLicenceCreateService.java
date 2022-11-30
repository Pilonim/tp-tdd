package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class DrivingLicenceCreateService {

    private final InMemoryDatabase database;

    private final SocialSecurityNumberValidatorService socialSecurityNumberValidatorService;

    public DrivingLicence createNewDrivingLicence(String driverSocialSecurityNumber){
        DrivingLicenceIdGenerationService idGenerationService = new DrivingLicenceIdGenerationService();
        this.socialSecurityNumberValidatorService.isValidDriverSocialSecurityNumber(driverSocialSecurityNumber);

        return DrivingLicence.builder().id(idGenerationService.generateNewDrivingLicenceId()).driverSocialSecurityNumber(driverSocialSecurityNumber).build();
    }

    public DrivingLicence uploadInDataBase(DrivingLicence drivingLicence){
        return database.save(drivingLicence.getId(), drivingLicence);
    }
}
