package org.micronaut.coffinite.rest.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.micronaut.coffinite.data.entities.Role;
import org.micronaut.coffinite.rest.commands.RoleCreateCommand;
import org.micronaut.coffinite.rest.commands.RoleUpdateCommand;
import org.micronaut.coffinite.services.api.RoleService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;

@ExecuteOn(TaskExecutors.IO)
@Controller("/roles")
public class RoleController {

    private final RoleService roleService;

    @Inject
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Get("/{name}")
    public Role show(String name) {
        return roleService.findByName(name)
                .orElse(null);
    }

    @Get("/id/{id}")
    public Role show(Long id) {
        return roleService.findById(id)
                .orElse(null);
    }

    @Post
    public HttpResponse<Role> create(@Body @Valid RoleCreateCommand cmd) {
        Role role = roleService.create(cmd);
        return HttpResponse
                .created(role)
                .headers(headers -> headers.location(location(role.getId())));
    }

    @Put
    public HttpResponse<Role> update(@Body @Valid RoleUpdateCommand cmd) {
        Role role = roleService.update(cmd);
        return HttpResponse
                .ok(role)
                .headers(headers -> headers.location(location(role.getId())));
    }


    protected URI location(Long id) {
        return URI.create("/roles/id/" + id);
    }

    protected URI location(Role role) {
        return location(role.getId());
    }

}
