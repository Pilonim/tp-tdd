package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenceCreateServiceTest {

    @InjectMocks
    DrivingLicenceCreateService service;

    @Mock
    private InMemoryDatabase database;

    @Mock
    private SocialSecurityNumberValidatorService socialSecurityNumberValidatorService;

    @Test
    void should_throw_an_exception_create_a_driving_licence_without_social_security_number(){
        assertThatNoException().isThrownBy(() -> service.createNewDrivingLicence(null));
    }

    @Test
    void should_return_a_driving_licence(){
        DrivingLicence newDrivingLicence = service.createNewDrivingLicence("123456789123456");
        assertThat(newDrivingLicence).isNotNull();
    }

    @Test
    void should_save_a_driving_licence(){
        DrivingLicence drivingLicence = service.createNewDrivingLicence("123456789123456");
        when(service.uploadInDataBase(drivingLicence)).thenReturn(drivingLicence);
        DrivingLicence uploadedDrivingLicence = service.uploadInDataBase(drivingLicence);

        assertThat(uploadedDrivingLicence).isEqualTo(drivingLicence);
    }

    @Test
    void should_have_12_points(){
        DrivingLicence drivingLicence = service.createNewDrivingLicence("123456789123456");
        assertThat(drivingLicence.getAvailablePoints()).isEqualTo(12);
    }

}
