package com.natwest.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.dao.LoanRepo;
import com.natwest.exception.ApplicantAlreadyExist;
import com.natwest.model.Loanprofile;

@Service
public class LoanServiceImpl implements Loanservice {

	@Autowired
	private LoanRepo loanrepo;
	
	@Override
	public Loanprofile addApplicant(Loanprofile applicant)throws ApplicantAlreadyExist {
		Optional<Loanprofile> applicant1 = loanrepo.findById(applicant.getEmail());
		if(applicant1.isPresent())  {
			throw new ApplicantAlreadyExist("Sorry, Application is already recevied for the same user");
		}
		else {
		Loanprofile temp = loanrepo.save(applicant);
		return temp;
	}

}

	@Override
	public List<Loanprofile> applicantlist() {
		List<Loanprofile> applicantlist = (List<Loanprofile>) loanrepo.findAll();
		return applicantlist;
	}

	@Override
	public Loanprofile updateApplicant(Loanprofile applicant) {
		Loanprofile updatedApplicant = loanrepo.save(applicant);
		return updatedApplicant;
	}
	
	
}