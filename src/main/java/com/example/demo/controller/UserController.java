package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
  public User updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
    return userService.updateUser(id, user);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public void deleteUser(@PathVariable(value = "id") Long id) {
    userService.deleteUser(id);
  }

}
