package org.micronaut.coffinite.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "co_role")
public class Role {


    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 50, unique = true)
    private String name;

    @OneToMany(mappedBy="role", cascade=CascadeType.ALL)
    private List<UserRole> userRoles = new ArrayList<>();

}
