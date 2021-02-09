package org.micronaut.coffinite.rest.commands;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Introspected
public class UserRegisterCommand {

    @NotBlank
    @Email
    private String email;

    @Size(min = 6, max = 40)
    @NotBlank
    private String password;

    private String confirmPassword;
}
