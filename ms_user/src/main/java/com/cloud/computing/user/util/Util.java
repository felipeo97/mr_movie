package com.cloud.computing.user.util;

import com.cloud.computing.user.entity.UserEntity;
import com.cloud.computing.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public UserEntity convertUserToEntity(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());

        return userEntity;
    }

    public User convertUserEntityToUser(UserEntity userEntity){
        User user = new User();

        user.setIdUser(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());

        return user;
    }

}
