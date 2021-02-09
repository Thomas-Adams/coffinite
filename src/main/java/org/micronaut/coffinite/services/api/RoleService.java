package org.micronaut.coffinite.services.api;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.transaction.annotation.ReadOnly;
import org.micronaut.coffinite.data.entities.Role;
import org.micronaut.coffinite.rest.commands.RoleCreateCommand;
import org.micronaut.coffinite.rest.commands.RoleUpdateCommand;

import javax.transaction.Transactional;
import java.util.Optional;


public interface RoleService {

    @ReadOnly
    Optional<Role> findByName(String name);

    @Transactional
    Role create(RoleCreateCommand cmd);

    @Transactional
    Role update(RoleUpdateCommand cmd);

    @ReadOnly
    Page<Role> findAll(Pageable pageable);

    @ReadOnly
    Optional<Role> findById(Long id);

}
