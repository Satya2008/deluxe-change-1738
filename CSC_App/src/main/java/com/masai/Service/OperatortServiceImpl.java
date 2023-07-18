package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Issue;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.IssueRepository;

@Service
public class OperatortServiceImpl implements operatorService{

	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private IssueRepository ir;
	
	@Override
	public Issue addCustomerIssue(Integer customerId, Issue issue) {
		// TODO Auto-generated method stub
		

		
		
		
		
		return null;
	}

}
