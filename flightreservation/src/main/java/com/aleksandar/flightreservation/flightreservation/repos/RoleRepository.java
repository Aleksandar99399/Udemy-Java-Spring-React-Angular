package com.aleksandar.flightreservation.flightreservation.repos;

import com.aleksandar.flightreservation.flightreservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
