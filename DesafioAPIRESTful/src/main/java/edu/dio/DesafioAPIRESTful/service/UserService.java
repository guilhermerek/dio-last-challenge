package edu.dio.DesafioAPIRESTful.service;

import edu.dio.DesafioAPIRESTful.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User user);

}
