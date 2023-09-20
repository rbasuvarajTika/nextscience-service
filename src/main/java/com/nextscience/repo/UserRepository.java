package com.nextscience.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String email);

	Optional<User> findByUserId(int id);

	User findByUserMail(String email);

	boolean existsByUserName(String userName);

	boolean existsByUserMail(String email);

	@Query(nativeQuery = true, value = "SELECT * from DIM_USER ORDER BY USER_ID DESC")
	Page<User> findAllCustom(PageRequest page);

}
