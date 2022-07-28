package com.cloud.computing.user.api;

import com.cloud.computing.user.model.User;
import com.cloud.computing.user.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController implements IUserApi{

    private final HttpServletRequest request;

    @Autowired
    private UserServices userServices;

    @org.springframework.beans.factory.annotation.Autowired
    public UserController(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<List<User>> user() {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return userServices.getUser();
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> createUser(User user) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return userServices.createUser(user);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return userServices.deleteUser(id);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
