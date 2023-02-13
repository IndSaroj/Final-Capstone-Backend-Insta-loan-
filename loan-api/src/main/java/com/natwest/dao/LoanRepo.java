package com.natwest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.model.Loanprofile;

@Repository
public interface LoanRepo extends JpaRepository<Loanprofile, String>{
	

	
	

}
