package com.example.demo.Cntroller;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserCntroller {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        List<User>userList=userService.getAllUser();
        return ResponseEntity.status(200).body(userList);

    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
       userService.addUser(user);
        return ResponseEntity.status(200).body("user add");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user,@PathVariable Integer id ,Errors errors) {
        if (errors.hasErrors()) {
         String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("message");
        }
        boolean isUpdate=userService.updateUser(id,user);
        if (isUpdate){
            return ResponseEntity.status(200).body("user update");
        }
        return ResponseEntity.status(400).body("user not found");
    }
    @DeleteMapping("/delete/{id}")
      public ResponseEntity deleteUser (@PathVariable Integer id, User user) {
        boolean isDelete=userService.updateUser(id,user);
        if (isDelete) {
            return ResponseEntity.status(200).body("delete user");
        }
        return ResponseEntity.status(400).body("not found");
    }
        @GetMapping("/get-email/{email}")
       public ResponseEntity getuserByEmail(@PathVariable String email){
        User user=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);

       }
       @GetMapping("/get-email-jpql/{email}")
        public ResponseEntity JPQLemail(@PathVariable String email){
        User users=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(users);

        }
    @GetMapping("/get-rol/{role}")
    public ResponseEntity findUserByRole(@PathVariable String role) {
       List <User> users = userService.findUserByRole(role);
        return ResponseEntity.status(200).body(users);
    }
        @GetMapping("/get-user/{username}/{password}")
    public ResponseEntity findUserUsernameAndPassword(@PathVariable String username,@PathVariable String password){
        User user=userService.findUserByUsernameAndPassword(username,password);
        return ResponseEntity.status(200).body(user);
        }

        @GetMapping("/get-by-age/{age}")
        public ResponseEntity findUserByGreaterThanEqal(@PathVariable Integer age){
         List<User> users=userService.findUserByAgeGreaterThanEqual(age);
        return ResponseEntity.status(200).body(users);
        }

      }


