package org.micronaut.coffinite.data.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import org.micronaut.coffinite.data.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
