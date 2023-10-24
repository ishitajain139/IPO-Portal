package com.app.ipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.ipo.model.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName")
    Optional<UserEntity> findByName(@Param("userName") String userName);

    @Query("SELECT u FROM UserEntity u")
    List<UserEntity> findAll();
    
    @Query("SELECT u FROM UserEntity u WHERE u.userId = :userId")
    Optional<UserEntity> findByUserId(@Param("userId") Long userId);

    @Query("SELECT u FROM UserEntity u WHERE u.userPhoneno = :userPhoneno")
    Optional<UserEntity> findByPhoneno(@Param("userPhoneno") Long userPhoneno);

    @Query("SELECT u FROM UserEntity u WHERE u.userEmailId = :userEmailId")
    Optional<UserEntity> findByEmailId(@Param("userEmailId") String userEmailId);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userPassword = :userPassword")
    Optional<UserEntity> loginUser(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
