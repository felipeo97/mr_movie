package com.cloud.computing.user.repository;

import com.cloud.computing.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity, Long> {
}
