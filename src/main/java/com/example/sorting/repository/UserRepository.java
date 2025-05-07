package com.example.sorting.repository;
import com.example.sorting.model.UserSort;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserSort, Long> {
    UserSort findByUsername(String username);
    boolean existsByUsername(String username);
    UserSort findByPassword(String password);
    UserSort findByUsernameAndPassword(String username, String password);
}

