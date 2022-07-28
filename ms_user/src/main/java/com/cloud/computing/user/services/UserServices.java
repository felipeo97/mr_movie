package com.cloud.computing.user.services;

import com.cloud.computing.user.entity.UserEntity;
import com.cloud.computing.user.model.User;
import com.cloud.computing.user.repository.IUserRepository;
import com.cloud.computing.user.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    public UserServices(IUserRepository userRepository, Util util) {
        this.userRepository = userRepository;
        this.util = util;
    }

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private Util util;

    public ResponseEntity<List<User>> getUser(){

        Iterable<UserEntity> userEntityIterable = userRepository.findAll();

        List<User> userList = new ArrayList<>();

        for (UserEntity iterator: userEntityIterable) {
            userList.add(util.convertUserEntityToUser(iterator));
        }

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    public ResponseEntity createUser(User user){

        UserEntity userEntity = util.convertUserToEntity(user);

        UserEntity userEntityResponse = userRepository.save(userEntity);

        return new ResponseEntity(userEntityResponse, HttpStatus.OK);
    }

    public ResponseEntity deleteUser(long idUser){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(idUser);

        //TODO: No se puede eliminar un usuario si tiene reservas asociadas
        userRepository.delete(userEntity);

        return new ResponseEntity<>("Eliminado el usuario con el ID ".concat(String.valueOf(idUser)),HttpStatus.OK);
    }
}
