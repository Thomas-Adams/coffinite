package org.micronaut.coffinite.services.impl;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.micronaut.coffinite.data.entities.User;
import org.micronaut.coffinite.data.repository.UserRepository;
import org.micronaut.coffinite.services.api.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class UserServiceImpl implements UserService {

    protected final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public Page<User> findUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

}
