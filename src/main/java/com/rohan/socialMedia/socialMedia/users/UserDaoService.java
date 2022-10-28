package com.rohan.socialMedia.socialMedia.users;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    private static Integer count = 0;

    static{
        users.add(new User(++count,"Adam1", LocalDate.now().minusYears(30)));
        users.add(new User(++count,"Adam2", LocalDate.now().minusYears(31)));
        users.add(new User(++count,"Adam3", LocalDate.now().minusYears(32)));
    }
    public List<User> findAll() { return users;}
    public User save(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }

    public User findOne(int id ){
        return users.get(id);
    }

    public void deleteById(int  id){
        users.get(id);
    }
}
