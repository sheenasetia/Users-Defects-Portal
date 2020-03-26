package com.sheena.defectapiproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sheena.defectapiproject.models.*;
public interface UsersRepository extends JpaRepository<Users, Integer>{

	Object findByEmailAndPassword(String email, String password);

	Users findByUsername(String username);

}
