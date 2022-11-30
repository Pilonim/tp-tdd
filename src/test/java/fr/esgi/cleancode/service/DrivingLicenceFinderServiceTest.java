package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DrivingLicenceFinderServiceTest {

    @InjectMocks
    private DrivingLicenceFinderService service;

    @Mock
    private InMemoryDatabase database;

    @Mock
    DrivingLicenceCreateService drivingLicenceCreateService;

    @Test
    void should_find() {
        UUID newUUID = UUID.randomUUID();
        final DrivingLicence drivingLicenceCreated = DrivingLicence.builder().id(newUUID).driverSocialSecurityNumber("123456789123456").build();
        when(service.findById(newUUID)).thenReturn(Optional.of(drivingLicenceCreated));
        final Optional<DrivingLicence> drivingLicenceFound = service.findById(newUUID);
        assertThat(drivingLicenceFound)
                .isNotEmpty()
                .isEqualTo(Optional.of(drivingLicenceCreated));
    }

    @Test
    void should_not_find() {
        final Optional<DrivingLicence> drivingLicenceFound = service.findById(UUID.randomUUID());
        assertThat(drivingLicenceFound).isEmpty();
    }
}