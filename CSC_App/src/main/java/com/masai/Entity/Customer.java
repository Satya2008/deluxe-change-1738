package com.masai.Entity;


import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
	@NotNull(message = "name should not be empty!")
    private String firstName;
    private String lastName;
    
    @Column(unique = true)
    @Email(message = "email should be formatted!")
    @NotNull(message = "email should not be empty!")
    private String email;
    @NotNull(message = "mobile should not be empty!")
    private String mobile;
    private String city;
     
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Issue> issues;

	public Customer(String firstName, String lastName, String email, String mobile, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
	}

}
