package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.domain.model.User;
import com.oscar.ecomerce.backend.domain.port.IUserRepository;
import com.oscar.ecomerce.backend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository userCrudRepository;
    private final UserMapper userMapper;

    public UserCrudRepositoryImpl(
            IUserCrudRepository userCrudRepository,
            UserMapper userMapper
    ) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return userMapper.toUser(userCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(userCrudRepository.findById(id).orElse(null));
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User update(User user, Integer id) {
        return null;
    }
}
