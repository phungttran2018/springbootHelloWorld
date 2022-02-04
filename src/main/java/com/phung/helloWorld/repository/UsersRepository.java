package com.phung.helloWorld.repository;

import com.phung.helloWorld.model.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
