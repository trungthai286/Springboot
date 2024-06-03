package org.example.movieapp.respository;

import org.apache.catalina.User;
import org.example.movieapp.entity.Users;
import org.example.movieapp.model.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    List<Users> findByUserRole(Role role);

    Page<Users> findByUserRole(Role role, Pageable pageable);

    List<Users> findByUsernameContainingIgnoreCase(String keyword);

    //5
    List<Users> findByAvatarNotNull();

    //6.
    List<Users> findByUserRoleOrderByUsernameDesc(Role role);

    List<Users> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    //8.
    Page<Users> findByUserRoleOrderByUsernameDesc(Role role, Pageable pageable);

    //9.
    long countByUserRole(Role role);
    //10.
    boolean existsByEmail(String email);



}
