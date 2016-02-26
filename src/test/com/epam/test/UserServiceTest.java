package com.epam.test;

import com.epam.domain.User;
import com.epam.exception.MovieException;
import com.epam.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Olga Bogutska on 26.02.2016.
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void testContext() {
        assertNotNull(service);
    }

    @Test
    public void testGetByName() throws MovieException {
        String name = "Olga";
        User user = service.getUserByName(name);
        assertNotNull(user);
        assertEquals(user.getName(), name);
    }

    @Test(expected = MovieException.class)
    public void testGetByEmptyName() throws MovieException {
        String name = "";
        service.getUserByName(name);
    }

    @Test
    public void testGetById() {
        int id = 1;
        User user = service.getById(id);
        assertNotNull(user);
        assertEquals(user.getId(), id);
    }

    @Test
    public void testGetByEmail() throws MovieException {
        String email = "olga_bogu@mail.com";
        User user = service.getUserByEmail(email);
        assertNotNull(user);
        assertEquals(user.getEmail(), email);
    }

    @Test(expected = MovieException.class)
    public void testGetByEmptyEmail() throws MovieException {
        String email = "";
        service.getUserByEmail(email);
    }
}