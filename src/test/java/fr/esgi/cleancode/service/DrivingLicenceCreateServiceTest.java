package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

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
    void should_save_and_return_a_driving_licence(){
        Optional<DrivingLicence> newDrivingLicence = service.createNewDrivingLicence("123456789123456");
        assertThat(newDrivingLicence).isPresent();
    }

    @Test
    void should_have_12_points(){
        Optional<DrivingLicence> newDrivingLicence = service.createNewDrivingLicence("123456789123456");
        newDrivingLicence.ifPresent(drivingLicence -> assertThat(drivingLicence.getAvailablePoints()).isEqualTo(12));
    }

}
