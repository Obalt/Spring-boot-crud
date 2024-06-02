package com.Obalt.Spring_boot_crud.repository;

import com.Obalt.Spring_boot_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
