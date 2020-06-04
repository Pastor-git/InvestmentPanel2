package com.cschoolproject.InvestmentPanel2.Entity;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	public User findByEmailAddress(String emailAddress);
	public User findOneById(Long id);
	
}
