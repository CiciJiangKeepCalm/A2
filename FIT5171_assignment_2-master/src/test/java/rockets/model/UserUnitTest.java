package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserUnitTest {
    private User target;

    @BeforeEach
    public void setUp() {
        target = new User();
    }

    @DisplayName("should throw exception when pass a empty first name to setFirstName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFirstNameToEmpty(String firstName) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setFirstName(firstName));
        assertEquals("first name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null first Name to setFirstName function")
    @Test
    public void shouldThrowExceptionWhenSetFirstNameToNull() {

        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFirstName(null));
        assertEquals("first name cannot be null or empty", exception.getMessage());
    }

    //cici edited
    @DisplayName("should throw exception when pass invalidated first Name to setFirstName function")
    @Test
    public void shouldThrowExceptionWhenSetFirstNameToInValidated() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setFirstName("aa232" ));
        assertEquals("First name should under 30 characters and contains only charaters", exception.getMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> target.setFirstName("aa///^&" ));
        assertEquals("First name should under 30 characters and contains only charaters", exception1.getMessage());

        // target.setFirstName("cccc");
        //assertEquals("cccc",target.getFirstName());
        target.setFirstName("cicigmail");
        assertEquals("cicigmail",target.getFirstName());
    }

    @DisplayName("should throw exception when pass invalidated last Name to setLastName function ")
    @Test
    public void shouldThrowExceptionWhenSetLastNameToInValidated() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setLastName("vvvvv54"));
        assertEquals("Last name should under 30 characters and contains only charaters", exception.getMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> target.setLastName("///__CC"));
        assertEquals("Last name should under 30 characters and contains only charaters", exception1.getMessage());

        target.setLastName("Cici");
        assertEquals("Cici",target.getLastName());

    }

    @DisplayName("should throw exception when pass null last Name to setLastName function")
    @Test
    public void shouldThrowExceptionWhenSetLastNameToNull() {

        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLastName(null));
        assertEquals("last name cannot be null or empty", exception.getMessage());
    }


    //cici edited
    @DisplayName("Email should be a valid email address ")
    @Test
    public void shouldThrowExceptionWhenSetEmailToInValidated() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setEmail("--I))CIGA@COM"));
        assertEquals("Email should be in a validated format", exception.getMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> target.setEmail("monashCOM"));
        assertEquals("Email should be in a validated format", exception1.getMessage());

        target.setEmail("cici@gmail.au");
        assertEquals("cici@gmail.au",target.getEmail());
    }

    @DisplayName("should throw exception when pass a empty last name to setLastName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLastNameToEmpty(String lastName) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setLastName(lastName));
        assertEquals("last name cannot be null or empty", exception.getMessage());
    }


    @DisplayName("should throw exception when pass a empty email address to setEmail function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetEmailToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setEmail(email));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setEmail function")
    @Test
    public void shouldThrowExceptionWhenSetEmailToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setEmail(null));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    //cici edited
    @DisplayName("should throw exceptions when pass an invalid password to setPassword function ")
    @Test
    public void shouldThrowExceptionWhenSetPasswordToInValidated() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setPassword("00888"));
        assertEquals("Password should be in a validated format", exception.getMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> target.setPassword("aabbbcc"));
        assertEquals("Password should be in a validated format", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> target.setPassword("12345678901234567789012"));
        assertEquals("Password should be in a validated format", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> target.setPassword("28402987"));
        assertEquals("Password should be in a validated format", exception3.getMessage());

        target.setPassword("aa78mnm");
        assertEquals("aa78mnm",target.getPassword());
    }

    @DisplayName("should throw exceptions when pass a null password to setPassword function")
    @Test
    public void shouldThrowExceptionWhenSetPasswordToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setPassword(null));
        assertEquals("password cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when two users have the same email")
    @Test
    public void shouldReturnTrueWhenUsersHaveSameEmail() {
        String email = "abc@example.com";
        target.setEmail(email);
        User anotherUser = new User();
        anotherUser.setEmail(email);
        assertTrue(target.equals(anotherUser));
    }


    @DisplayName("should return false when two users have different emails")
    @Test
    public void shouldReturnFalseWhenUsersHaveDifferentEmails() {
        target.setEmail("abc@example.com");
        User anotherUser = new User();
        anotherUser.setEmail("def@example.com");
        assertFalse(target.equals(anotherUser));
    }
}