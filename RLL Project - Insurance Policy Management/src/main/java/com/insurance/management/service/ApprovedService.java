package com.insurance.management.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Approved;
import com.insurance.management.repository.ApprovedRepository;


@Service
public class ApprovedService {
	@Autowired
	ApprovedRepository approvedRepository;

	public List<Approved> getAllApproved() {
		return approvedRepository.findAll();
	}

	public Optional<Approved> getApproved(String userName) {
		return approvedRepository.findById(userName);
	}

	public String addApproved(Approved approved) {
         Date date=new Date();
         String status="approved";
		 approved.setDate(date);
		 approved.setStatus(status);
		approvedRepository.save(approved);
		return "added";
	}
}
