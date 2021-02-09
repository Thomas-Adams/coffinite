package org.micronaut.coffinite.services.impl;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.micronaut.coffinite.data.entities.UserRole;
import org.micronaut.coffinite.data.repository.UserRoleRepository;
import org.micronaut.coffinite.services.api.UserRoleService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Inject
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public Page<UserRole> findUsers(Pageable pageable) {
        return this.userRoleRepository.findAll(pageable);
    }

}
