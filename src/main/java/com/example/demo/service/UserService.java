package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User updateUser(Long id, User user) {
    User currentUser = userRepository.findById(id).get();
    currentUser.setName(user.getName());
    currentUser.setEmail(user.getEmail());
    return userRepository.save(currentUser);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

}
