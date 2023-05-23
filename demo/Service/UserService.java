package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {
        User oldUser = userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setPassword(user.getPassword());

        userRepository.save(oldUser);
        return true;

    }

    public boolean deleteUser(Integer id) {
        User oldUser = userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }
        userRepository.delete(oldUser);
        return true;
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("email not found");
        }
        return user;
    }

    public List<User> findUserByRole(String role) {
        List<User> users= userRepository.findUserByRole(role);
        return users;

    }
    public List<User>findUserByAgeGreaterThanEqual(Integer age) {
        List<User> users = userRepository.findUserByAgeGreaterThanEqual(age);
        return users;
    }
    public User findUserByUsernameAndPassword(String username, String password){
        User user=userRepository.findUserByUsernameAndPassword(username,password);
        if (user == null) {
            throw new ApiException("user,password not found");
        }
            return user;
        }
        public User JPQLemail(String email){
            User user = userRepository.findUserByEmail(email);
            if (email == null) {
                throw new ApiException("email not found");
            }
                return user;
            }


        }
