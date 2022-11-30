package fr.esgi.cleancode.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class SocialSecurityNumberValidatorServiceTest {

    SocialSecurityNumberValidatorService service = new SocialSecurityNumberValidatorService();
    @Test
    void should_be_valid_social_security_number(){
        assertThatNoException().isThrownBy(() -> service.isValidDriverSocialSecurityNumber("123456789123456"));
    }

    @Test
    void should_not_be_valid_social_security_number_without_only_numbers() {
        assertThatException().isThrownBy(() -> service.isValidDriverSocialSecurityNumber("1234567e9123456"));
    }

    @Test
    void should_not_be_valid_social_security_number_with_a_lenght_under_15() {
        assertThatException().isThrownBy(() -> service.isValidDriverSocialSecurityNumber("1234569123456"));
    }

    @Test
    void should_not_be_valid_social_security_number_with_a_lenght_above_15() {
        assertThatException().isThrownBy(() -> service.isValidDriverSocialSecurityNumber("12345674545459123456"));
    }

    @Test
    void should_not_be_valid_social_security_number_with_null_social_number() {
        assertThatException().isThrownBy(() -> service.isValidDriverSocialSecurityNumber(null));
    }

}
