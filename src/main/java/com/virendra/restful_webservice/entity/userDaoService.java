package com.virendra.restful_webservice.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class userDaoService {
    /*
    1.create jpa/hibernate database
    2.public List<> findAll()
    3.public User save(User user)
    4.public User findOne(int id)
     */


    //creating static data
    public static List<users> users = new ArrayList<>();
    private static int usersCount = 0;
    static{
        users.add(new users(++usersCount,"virendra", LocalDate.now().minusYears(30)));
        users.add(new users(++usersCount,"omkar", LocalDate.now().minusYears(25)));
        users.add(new users(++usersCount,"aditya", LocalDate.now().minusYears(45)));
    }

    public users save(users user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public List<users> findAll(){
        return users;
    }

    public users findOne(Integer id){
        Predicate<? super users> predicate = users->users.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

}
