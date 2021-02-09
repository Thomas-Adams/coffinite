package org.micronaut.coffinite.rest.commands;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Introspected
public class RoleUpdateCommand {

    @NotNull
    private Long id;

    @NotBlank
    private String name;


}
