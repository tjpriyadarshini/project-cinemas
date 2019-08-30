package com.vapasi.justcinemas.controller;

import com.vapasi.justcinemas.model.domain.Movie;
import com.vapasi.justcinemas.model.domain.User;
import com.vapasi.justcinemas.service.UserValidation;
import com.vapasi.justcinemas.service.UserValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTest {

    @Mock
    UserValidationService userValidationServiceMock;
    @Mock
    Model modelMock;
    @Mock
    HttpSession sessionMock;

    @InjectMocks
    AuthenticationController authenticationController;

    @Test
    public void testGetLoginReturnLoginWithModelAttributeUserName() {
        assertEquals("login", authenticationController.getLogin(modelMock));
        verify(modelMock).addAttribute(eq("user"),eq(new User()));
    }
    @Test
    public void testLoginFormReturnMovieOnSuccessfulLogin() {
        User user1 = new User();
        user1.setUserName("abcd");
        UserValidation userValidation = new UserValidation(true,null, user1);
        User user = new User();
        List<Movie> moviesList = new ArrayList<>();
        when(userValidationServiceMock.validateUser(user)).thenReturn(userValidation);
        assertEquals("redirect:/", authenticationController.loginValidation(user,modelMock,sessionMock));
        verify(sessionMock).setAttribute(eq("user"),eq(userValidation.getUser()));
    }
    @Test
    public void testLoginFormReturnLoginOnErrors() {
        UserValidation userValidation = new UserValidation(false,null,null);
        User user = new User();
        List<Movie> moviesList = new ArrayList<>();
        when(userValidationServiceMock.validateUser(user)).thenReturn(userValidation);
        assertEquals("login", authenticationController.loginValidation(user,modelMock,sessionMock));
        verify(modelMock).addAttribute(eq("userValidation"), eq(userValidation));
    }
    @Test
    public void testLogoff()
    {
        assertEquals("redirect:/", authenticationController.logoff(sessionMock,modelMock));
        verify(sessionMock).removeAttribute("user");
    }



}
