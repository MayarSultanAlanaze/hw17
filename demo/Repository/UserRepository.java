package com.example.demo.Repository;

import com.example.demo.model.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUsernameAndPassword(String username, String password);
    User deleteUserById(Integer id);

   User findUserByEmail (String email);


    List<User> findUserByRole(String role);

    List<User>findUserByAgeGreaterThanEqual(Integer age);

    @Query("select s from User s where  s.email=?1")
    User JPQLemil(String email);


}



