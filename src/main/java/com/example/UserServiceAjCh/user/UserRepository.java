package com.example.UserServiceAjCh.user;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository <UserEntity, Long> {
}
