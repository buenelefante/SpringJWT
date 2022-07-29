package com.example.jwttest.jwtbase.repository;

import com.example.jwttest.jwtbase.entity.FXUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FXUserRoleRepository extends JpaRepository<FXUserRole,FXUserRole> {

    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO fx_user_role VALUES((SELECT USER_ID from fx_user where USER_NAME=?1),(SELECT ROLE_ID FROM fx_role WHERE ROLE_NAME=?2));")
    void save(String userName,String roleName);
}
