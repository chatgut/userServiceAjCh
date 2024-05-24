package com.example.UserServiceAjCh.user;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository <UserEntity, Long> {
    Optional<UserEntity> findByUserName(String userName);
}
