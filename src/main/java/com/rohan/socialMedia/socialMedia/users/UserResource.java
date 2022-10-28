package com.rohan.socialMedia.socialMedia.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private final UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();
    }

    @PostMapping("/users")
    public List<User>  createUser(@Valid @RequestBody  User user){
        userDaoService.save(user);
        return userDaoService.findAll();
    }
}
