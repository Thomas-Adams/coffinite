package org.micronaut.coffinite.data.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "co_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Email
    @Column(length = 100, unique = true)
    private String email;

    @Size(min = 6, max = 40)
    @Column(length = 40)
    private String password;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<UserRole> userRoles = new ArrayList<>();


}
