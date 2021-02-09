package org.micronaut.coffinite.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="co_profile")
public class Profile {

    @Id
    @GeneratedValue
    private Long id;

    private String givenName;

    private String surName;

    private LocalDate birthDay;


}
