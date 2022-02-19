package com.helperproject.interestservice.repository;

import com.helperproject.interestservice.model.UserInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends CrudRepository<UserInterest, Long> {

    UserInterest findByUsername(String username);

}
