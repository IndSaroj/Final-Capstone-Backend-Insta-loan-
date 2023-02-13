package com.natwest.service;


import java.util.List;

import com.natwest.exception.ApplicantAlreadyExist;
import com.natwest.model.Loanprofile;

public interface Loanservice {
	
	public Loanprofile addApplicant(Loanprofile applicant)throws ApplicantAlreadyExist;
	public Loanprofile updateApplicant(Loanprofile applicant);
	public List<Loanprofile> applicantlist();

}
