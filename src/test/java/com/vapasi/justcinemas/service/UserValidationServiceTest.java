package com.vapasi.justcinemas.service;


import com.vapasi.justcinemas.model.domain.User;
import com.vapasi.justcinemas.repository.UserRepository;
import com.vapasi.justcinemas.validator.UserLoginDataValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserValidationServiceTest {
    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserValidationService userValidationService;

    @Test
    public void testValidateUserIsSuccessful()
    {
        User userDataFromView = mock(User.class);
        User userDataFromDB = mock(User.class);
        when(userDataFromView.getEmail()).thenReturn("someone@abc.com");
        when(userDataFromView.getPassword()).thenReturn("1234567890");
        when(userDataFromDB.getPassword()).thenReturn("1234567890");
        when(userDataFromDB.getUserName()).thenReturn("someone");

        when(userRepositoryMock.findByEmail(userDataFromView.getEmail())).thenReturn(userDataFromDB);

        UserValidation validationResult = userValidationService.validateUser(userDataFromView);

        verify(userRepositoryMock).findByEmail(userDataFromView.getEmail());
        assertTrue(validationResult.isValidationSuccessful());
        assertNull(validationResult.getErrorMessage());
        assertNotNull(validationResult.getUserName());
    }

    @Test
    public void testValidationFailedWithErrorMessage() {
        User userDataFromView = mock(User.class);
        when(userDataFromView.getEmail()).thenReturn("someone@abc.com");
        when(userDataFromView.getPassword()).thenReturn("1234567890");
        when(userRepositoryMock.findByEmail(userDataFromView.getEmail())).thenReturn(null);

        UserValidation validationResult = userValidationService.validateUser(userDataFromView);

        verify(userRepositoryMock).findByEmail(userDataFromView.getEmail());
        assertFalse(validationResult.isValidationSuccessful());
        assertEquals("Email does not exist", validationResult.getErrorMessage());
    }
}
