package com.helperproject.interestservice.service;

import com.helperproject.interestservice.model.UserInterest;
import com.helperproject.interestservice.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInterestService {

    @Autowired
    private InterestRepository interestRepository;



    public String getUserInterests(String username){
        UserInterest userInterest = interestRepository.findByUsername(username);
        return userInterest == null? null : userInterest.getInterest();
    }

    public UserInterest saveUserInterest(String username, String tag) {

        Optional<UserInterest> userInterest = Optional.ofNullable(interestRepository.findByUsername(username));
        if (userInterest.isEmpty()){
            UserInterest newUserInterest = new UserInterest(username, tag);
            return interestRepository.save(newUserInterest);
        }
        UserInterest existingUserInterest = userInterest.get();
        existingUserInterest.setInterest(tag);
        return interestRepository.save(existingUserInterest);
    }
}
