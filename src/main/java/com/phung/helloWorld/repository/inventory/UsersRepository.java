package com.phung.helloWorld.repository.inventory;

import com.phung.helloWorld.model.inventory.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
