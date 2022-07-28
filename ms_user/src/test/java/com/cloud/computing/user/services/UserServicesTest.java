package com.cloud.computing.user.services;

import com.cloud.computing.user.entity.UserEntity;
import com.cloud.computing.user.model.User;
import com.cloud.computing.user.repository.IUserRepository;
import com.cloud.computing.user.util.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServicesTest {

    @InjectMocks
    private UserServices userServices;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private Util util;

    private Iterable<UserEntity> userEntityIterable;
    private User user;
    private UserEntity userEntity;

    @Before
    public void init() {
        userEntityIterable = new ArrayList<>();
        userServices = new UserServices(userRepository, util);

        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Prueba Name");
        userEntity.setLastName("Prueba");

        user = new User();
        user.setName("Pruba Name");
        user.setLastName("Prueba");
    }

    @Test
    public void whenCorrectDataIsSentTheUsersConsultedCorrectly(){

        Mockito.when(userRepository.findAll()).thenReturn(userEntityIterable);

        ResponseEntity<List<User>> responseEntity = userServices.getUser();

        assertEquals(responseEntity.getStatusCodeValue(),200);
    }

    @Test
    public void whenCorrectDataIsSentTheUsersCreateCorrectly(){

        Mockito.when(util.convertUserToEntity(user)).thenReturn(userEntity);
        Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

        ResponseEntity<List<User>> responseEntity = userServices.createUser(user);

        assertEquals(responseEntity.getStatusCodeValue(),200);
    }
}