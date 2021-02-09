package org.micronaut.coffinite.services.impl;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.micronaut.coffinite.data.entities.Role;
import org.micronaut.coffinite.data.repository.RoleRepository;
import org.micronaut.coffinite.rest.commands.RoleCreateCommand;
import org.micronaut.coffinite.rest.commands.RoleUpdateCommand;
import org.micronaut.coffinite.services.api.RoleService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Inject
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role create(RoleCreateCommand cmd) {
        Role role = new Role();
        role.setName(cmd.getName());
        return roleRepository.save(role);
    }

    public Role update(RoleUpdateCommand cmd) {
        Optional<Role> role = this.roleRepository.findById(cmd.getId());
        if (role.isPresent()) {
            Role updated = role.get();
            updated.setName(cmd.getName());
            return roleRepository.save(updated);
        } else {
            return null;
        }
    }

    public Page<Role> findAll(Pageable pageable) {
        return this.roleRepository.findAll(pageable);
    }

    public Optional<Role> findByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public Optional<Role> findById(Long id) {
        return this.roleRepository.findById(id);
    }

}
