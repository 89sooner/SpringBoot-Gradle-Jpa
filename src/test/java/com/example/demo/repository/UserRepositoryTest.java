package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setName("kimkildong");
        user.setEmail("test2@gmail.com");
        user.setPhoneNumber("010-3333-2222");
        user.setRegDt(LocalDateTime.now());
        user.setRegUser("kil0981");

        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            System.out.println("user: "+selectUser);
        });
    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.setUserAccount("modUser1");
            selectUser.setEmail("modUser1@gmail.com");
            selectUser.setModDt(LocalDateTime.now());
            selectUser.setModUser("89sooner");
            User newUser = userRepository.save(selectUser);
            System.out.println("user: "+newUser);
        });
    }

//    @Test
//    @Transactional
//    public void delete(){
//        Optional<User> user = userRepository.findById(1L);
//
//        Assert.assertTrue(user.isPresent());    // true
//        user.ifPresent(selectUser ->{
//            userRepository.delete(selectUser);
//        });
//
//        Optional<User> deleteUser = userRepository.findById(1L);
//
//        Assert.assertFalse(deleteUser.isPresent());    // false
//    }

}