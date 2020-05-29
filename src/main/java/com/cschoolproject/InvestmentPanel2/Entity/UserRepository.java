package com.cschoolproject.InvestmentPanel2.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmailAddress(String emailAddress);
}
