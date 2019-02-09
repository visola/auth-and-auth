package org.visola.authandauth.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.visola.authandauth.User;
import org.visola.authandauth.data.UserDao;

@RestController
@RequestMapping("${api.base}/users")
public class UsersController {

  private final UserDao userDao;

  public UsersController(UserDao userDao) {
    this.userDao = userDao;
  }

  @RequestMapping(method = RequestMethod.POST)
  public User createUser(@RequestBody User user) {
    userDao.create(user);
    return user;
  }

}
