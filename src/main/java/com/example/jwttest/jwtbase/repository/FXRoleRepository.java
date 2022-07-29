package com.example.jwttest.jwtbase.repository;

import com.example.jwttest.jwtbase.entity.FXRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FXRoleRepository extends JpaRepository<FXRole,Integer> {
}
