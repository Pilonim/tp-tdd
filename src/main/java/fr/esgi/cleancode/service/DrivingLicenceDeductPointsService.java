package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceDeductPointsService {

    private InMemoryDatabase database;

    private DrivingLicenceFinderService drivingLicenceFinderService;

    public DrivingLicence save(DrivingLicence drivingLicence){
        return database.save(drivingLicence.getId(),drivingLicence);
    }

    public DrivingLicence deductPoints(DrivingLicence drivingLicence, int nbPointsDeducted){
        return drivingLicence.withAvailablePoints(Math.max(drivingLicence.getAvailablePoints() - nbPointsDeducted, 0));
    }

    public DrivingLicence find(UUID drivingLicenceId){
        Optional<DrivingLicence> drivingLicenceFound = drivingLicenceFinderService.findById(drivingLicenceId);
        if(drivingLicenceFound.isPresent()){
            return drivingLicenceFound.get();
        }else{
            throw new ResourceNotFoundException("Driving Licence not found");
        }
    }

    public DrivingLicence findDeductAndSave(UUID drivingLicenceId, int nbPointsDeducted){
        return save(deductPoints(find(drivingLicenceId),nbPointsDeducted));
    }
}
