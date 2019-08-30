package com.vapasi.justcinemas.validator;

import com.vapasi.justcinemas.model.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static junit.framework.TestCase.*;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginDataValidatorTest {

    @Test
    public void testValidateForNoErrors()
    {
        User userDataFromView = mock(User.class);
        User userDataFromDB = mock(User.class);
        UserLoginDataValidator userLoginDataValidator = new UserLoginDataValidator(userDataFromView,userDataFromDB);

        when(userDataFromView.getPassword()).thenReturn("12345678");
        when(userDataFromDB.getPassword()).thenReturn("12345678");

        userLoginDataValidator.validate();

        assertNull(userLoginDataValidator.getErrorMessage());
    }

    @Test
    public void testValidateSetsPasswordLengthErrorMessage()
    {
        User userDataFromView = mock(User.class);
        User userDataFromDB = mock(User.class);
        UserLoginDataValidator userLoginDataValidator = new UserLoginDataValidator(userDataFromView,userDataFromDB);

        when(userDataFromView.getPassword()).thenReturn("123456");

        userLoginDataValidator.validate();

        assertEquals("Password must be atleast 8 characters long",userLoginDataValidator.getErrorMessage());
    }

    @Test
    public void testValidateSetsEmailNotFoundErrorMessage()
    {
        User userDataFromView = mock(User.class);
        User userDataFromDB = null;
        UserLoginDataValidator userLoginDataValidator = new UserLoginDataValidator(userDataFromView,userDataFromDB);

        when(userDataFromView.getPassword()).thenReturn("12345678");

        userLoginDataValidator.validate();

        assertEquals("Email does not exist",userLoginDataValidator.getErrorMessage());
    }

    @Test
    public void testValidateSetsEmailandPasswordDoNotMatch()
    {
        User userDataFromView = mock(User.class);
        User userDataFromDB = mock(User.class);
        UserLoginDataValidator userLoginDataValidator = new UserLoginDataValidator(userDataFromView,userDataFromDB);

        when(userDataFromView.getPassword()).thenReturn("12345678");
        when(userDataFromDB.getPassword()).thenReturn("12345678910");

        userLoginDataValidator.validate();

        assertEquals("Email and password do not match",userLoginDataValidator.getErrorMessage());
    }
}
