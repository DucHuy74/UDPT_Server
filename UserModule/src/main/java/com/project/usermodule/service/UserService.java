package com.project.usermodule.service;

import com.project.usermodule.dto.request.UserCreationRequest;
import com.project.usermodule.dto.request.UserUpdateRequest;
import com.project.usermodule.entity.User;
import com.project.usermodule.exception.AppException;
import com.project.usermodule.exception.ErrorCode;
import com.project.usermodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        if(userRepository.existsByUserName(request.getUserName())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        return userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);

        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.delete(getUser(userId));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
