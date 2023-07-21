package com.masai.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Operator;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;
import com.masai.Service.AdminService;

@RestController
public class Controller {
	// Add Operator
	AdminService adminService;
	@PostMapping("/operators")
	public ResponseEntity<Operator> addOperator(@RequestBody Operator operator) throws LoginException {
	    Operator savedOperator = adminService.addOperator(operator);
	    return new ResponseEntity<>(savedOperator, HttpStatus.CREATED);
	}

	// Remove Operator by ID
	@DeleteMapping("/operators/{id}")
	public ResponseEntity<Operator> removeOperator(@PathVariable int id) throws OperatorException, Exception {
	    Operator removedOperator = adminService.removeOperatorById(id);
	    return new ResponseEntity<Operator>(removedOperator, HttpStatus.OK);
	}

	// Modify Operator
	@PutMapping("/operators/{id}")
	public ResponseEntity<Operator> modifyOperator(@PathVariable int id, @RequestBody Operator operator) throws OperatorException, LoginException {
	    Operator modifiedOperator = adminService.modifyOperator(id);
	    return new ResponseEntity<Operator>(modifiedOperator, HttpStatus.OK);
	}

	// Find Operator by ID
	@GetMapping("/operators/{id}")
	public ResponseEntity<Operator> findOperatorById(@PathVariable int id) throws OperatorException, LoginException {
	    Operator operator = adminService.findOperatorById(id);
	    return new ResponseEntity<>(operator, HttpStatus.OK);
	}

	// Get All Operators
	@GetMapping("/operators")
	public ResponseEntity<List<Operator>> getAllOperators() throws LoginException {
	    List<Operator> allOperators = adminService.getAllOperators();
	    return new ResponseEntity<>(allOperators, HttpStatus.OK);
	}

}
