package com.nhoclahola.bt2511_springsecurityjwt_demo3.repositories;

import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
