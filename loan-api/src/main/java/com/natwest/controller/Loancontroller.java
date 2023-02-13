package com.natwest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

import com.natwest.exception.ApplicantAlreadyExist;
import com.natwest.model.Loanprofile;
import com.natwest.service.Loanservice;


@RestController
@RequestMapping("/api/applicant")
public class Loancontroller {
	
	@Autowired
	private Loanservice loanserv;
	
	@PostMapping("/application")
	public ResponseEntity<?> saveApplicant(@RequestBody Loanprofile applicant)throws ApplicantAlreadyExist{
		 Loanprofile applicant1;
		 try {
		 applicant1 = loanserv.addApplicant(applicant);
			 return new ResponseEntity<Loanprofile>(applicant1, HttpStatus.CREATED);
		 } catch(ApplicantAlreadyExist e) {
			 return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		 }
	 }
	@GetMapping("/loanapplication")
	public ResponseEntity<List<Loanprofile>> getApplicantList() {
		List<Loanprofile> applicants = loanserv.applicantlist();
		return new ResponseEntity<List<Loanprofile>>(applicants,HttpStatus.OK);
      }
	@PutMapping("/updateApplication/{username}")
	public ResponseEntity<String> updateApplicant(@PathVariable String username, @RequestBody Loanprofile applicant) {
		
//		Loanprofile obj = loanserv.updateApplicant(applicant); //retrieve the applicant you want to update
//		
//	    obj.setStatus(applicant.getStatus());
		
	    loanserv.updateApplicant(applicant);//update the user. with the updated values
		
		return new ResponseEntity<String>("Application updated",HttpStatus.ACCEPTED);
	}
	
}