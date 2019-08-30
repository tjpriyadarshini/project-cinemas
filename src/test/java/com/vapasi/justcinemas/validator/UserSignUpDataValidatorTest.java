package com.vapasi.justcinemas.validator;

import com.vapasi.justcinemas.model.view.NewUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserSignUpDataValidatorTest {

    @Test
    public void testValidateForNoErrors()
    {
        NewUser newUser = mock(NewUser.class);
        when(newUser.getUserName()).thenReturn("someone");
        when(newUser.getEmail()).thenReturn("someone@abc.com");
        when(newUser.getPassword()).thenReturn("12345678");
        when(newUser.getConfirmPassword()).thenReturn("12345678");

        UserSignUpDataValidator userSignUpDataValidator = new UserSignUpDataValidator(newUser);
        userSignUpDataValidator.validate();

        assertNull(userSignUpDataValidator.getErrorMessage());
    }

    @Test
    public void testValidateSetsNameFieldMissingErrorMessage() {
        NewUser newUser = mock(NewUser.class);
        when(newUser.getUserName()).thenReturn(null);

        UserSignUpDataValidator userSignUpDataValidator = new UserSignUpDataValidator(newUser);
        userSignUpDataValidator.validate();

        assertEquals("Name field is missing", userSignUpDataValidator.getErrorMessage());
    }

    @Test
    public void testValidateSetsEmailFieldMissingErrorMessage() {
        NewUser newUser = mock(NewUser.class);
        when(newUser.getUserName()).thenReturn("someone");
        when(newUser.getEmail()).thenReturn(null);

        UserSignUpDataValidator userSignUpDataValidator = new UserSignUpDataValidator(newUser);
        userSignUpDataValidator.validate();

        assertEquals("Email is missing", userSignUpDataValidator.getErrorMessage());
    }

    @Test
    public void testValidateSetsPasswordLengthErrorMessage()
    {
        NewUser newUser = mock(NewUser.class);
        when(newUser.getUserName()).thenReturn("someone");
        when(newUser.getEmail()).thenReturn("someone@abc.com");
        when(newUser.getPassword()).thenReturn("1234");

        UserSignUpDataValidator userSignUpDataValidator = new UserSignUpDataValidator(newUser);
        userSignUpDataValidator.validate();

        assertEquals("Password must be atleast 8 characters long",userSignUpDataValidator.getErrorMessage());
    }

    @Test
    public void testValidateSetsPasswordMismatchError()
    {
        NewUser newUser = mock(NewUser.class);
        when(newUser.getUserName()).thenReturn("someone");
        when(newUser.getEmail()).thenReturn("someone@abc.com");
        when(newUser.getPassword()).thenReturn("12345678");
        when(newUser.getPassword()).thenReturn("12345678900");

        UserSignUpDataValidator userSignUpDataValidator = new UserSignUpDataValidator(newUser);
        userSignUpDataValidator.validate();

        assertEquals("Password and Confirm Password do not match",userSignUpDataValidator.getErrorMessage());
    }
}
