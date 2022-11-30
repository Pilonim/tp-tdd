package fr.esgi.cleancode.service;

import fr.esgi.cleancode.model.DrivingLicence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.when;

public class DrivingLicenceDeductPointsServiceTest {

    DrivingLicenceDeductPointsService service = new DrivingLicenceDeductPointsService();

    @Test
    void should_throw_an_exception_when_driving_licence_not_found(){
        assertThatException().isThrownBy(() -> service.find(UUID.randomUUID()));
    }

    @Test
    void should_find_driving_licence(){
        UUID newUUID = UUID.randomUUID();
        DrivingLicence drivingLicence = DrivingLicence.builder().id(newUUID).driverSocialSecurityNumber("123456789123456").build();
        when(service.find(newUUID)).thenReturn(Optional.of(drivingLicence));
        assertThatNoException().isThrownBy(() -> service.find(newUUID));
    }

    @Test
    void should_save_and_return_a_driving_licence(){
        UUID newUUID = UUID.randomUUID();
        DrivingLicence drivingLicence = DrivingLicence.builder().id(newUUID).driverSocialSecurityNumber("123456789123456").build();
        when(service.save(drivingLicence)).thenReturn(drivingLicence);
        service.save(drivingLicence);
        assertThat(drivingLicence).isEqualTo(drivingLicence);
    }

    @Test
    void should_deduct_2_points(){
        UUID newUUID = UUID.randomUUID();
        DrivingLicence drivingLicence = DrivingLicence.builder().id(newUUID).driverSocialSecurityNumber("123456789123456").build();
        drivingLicence = service.deductPoints(Optional.of(drivingLicence),2);
        assertThat(drivingLicence.getAvailablePoints()).isEqualTo(10);

    }

    @Test
    void should_not_go_under_0_points(){
        UUID newUUID = UUID.randomUUID();
        DrivingLicence drivingLicence = DrivingLicence.builder().id(newUUID).availablePoints(1).driverSocialSecurityNumber("123456789123456").build();
        drivingLicence = service.deductPoints(Optional.of(drivingLicence),2);
        assertThat(drivingLicence.getAvailablePoints()).isEqualTo(0);
    }


}
