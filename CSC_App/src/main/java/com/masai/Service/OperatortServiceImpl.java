package com.masai.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.Issue;
import com.masai.Exception.CustomerException;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.IssueRepository;

@Service
public class OperatortServiceImpl implements operatorService{

	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private IssueRepository ir;
	
	@Override
	public Issue addCustomerIssue(Integer customerId, Issue issue) throws CustomerException {
		// TODO Auto-generated method stub
		Customer customer = cr.findById(customerId).orElseThrow(()->new CustomerException("Customer Not Found"));
		List<Issue> li = customer.getIssues();
		li.add(issue);
		customer.setIssues(li);
		issue.setCustomer(customer);
		cr.save(customer);
		return ir.save(issue);
	}
	
	

}
