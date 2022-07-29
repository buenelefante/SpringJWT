package com.example.jwttest.jwtbase.repository;

import com.example.jwttest.jwtbase.entity.FXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FXUserRepository extends JpaRepository<FXUser,Integer> {
    FXUser findByName(String userName);

    @Query(nativeQuery = true,value ="SELECT ROLE_NAME from fx_role WHERE ROLE_ID in (select ROLE_ID from fx_user_role where USER_ID = (select USER_ID from fx_user where USER_NAME= ?1));")
    List<String> getRolesByUserName(String userName);
}
