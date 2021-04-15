package com.demisco.project.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.demisco.project.model.User;

import java.util.Optional;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Integer> {
    //Recovery Profile By Members Email
    User findByEmailAndUserType(String email, String userType);

    Optional<User> findByUserNameAndPasswordAndUserType(String userName, String password, String userType);
}