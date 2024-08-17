package com.email.proveider.infra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.proveider.core.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
