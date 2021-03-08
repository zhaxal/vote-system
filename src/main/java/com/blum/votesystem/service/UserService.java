package com.blum.votesystem.service;



import com.blum.votesystem.models.User;
import com.blum.votesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.concurrent.CompletableFuture;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;





    @Async
    @Transactional
    public void userUpdate(String firstname, String lastname, String groupname, int age, String interests, String email){
        User user = userRepo.findByEmail(email);
        Long id = user.getId();


        if (firstname != ""){
            userRepo.updateFirstname(id,firstname);
        }
        if (lastname != ""){
            userRepo.updateLastname(id,lastname);
        }
        if (groupname != ""){
            userRepo.updateGroupName(id,groupname);
        }
        if (age != 0){
            userRepo.updateAge(id, age);
        }
        if (interests != ""){
            userRepo.updateInterests(id,interests);
        }


    }

    @Async
    public CompletableFuture<User> getUser(String email){
        User user = userRepo.findByEmail(email);
        return CompletableFuture.completedFuture(user);
    }




}
