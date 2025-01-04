package com.oscar.ecomerce.backend.domain.port;

import com.oscar.ecomerce.backend.domain.model.User;

public interface IUserRepository {
    Iterable<User> findAll();
    User save(User user);
    User findById(Integer id);
    User findByEmail(String email);
    User update(User user, Integer id);
}
