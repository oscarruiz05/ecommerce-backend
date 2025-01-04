package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
}
