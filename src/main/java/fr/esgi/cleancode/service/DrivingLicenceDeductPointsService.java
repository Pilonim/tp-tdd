package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceDeductPointsService {

    private InMemoryDatabase database;

    public DrivingLicence save(DrivingLicence drivingLicence){
        throw new NotImplementedException();
    }

    public DrivingLicence deductPoints(Optional<DrivingLicence> drivingLicence, int nbPointsDeducted){
        throw new NotImplementedException();
    }

    public Optional<DrivingLicence> find(UUID drivingLicenceId){
        throw new NotImplementedException();
    }

    public DrivingLicence findDeductAndSave(UUID drivingLicenceId, int nbPointsDeducted){
        throw new NotImplementedException();
    }
}
