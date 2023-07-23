package com.masai.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issueId;

    @NotNull(message = "issueType should not be empty!")
    private String issueType; // make it enum if required

    @NotNull(message = "issueDescription should not be empty!")
    private String issueDescription;

    @NotNull(message = "issueStatus should not be empty!")
    private IssueStatus issueStatus = IssueStatus.OPEN;
 

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToOne(mappedBy = "issue", cascade = CascadeType.ALL)
    private Solution solution;

    public Issue(@NotNull(message = "issueType should not be empty!") String issueType,
            @NotNull(message = "issueDescription should not be empty!") String issueDescription,
            @NotNull(message = "issueStatus should not be empty!") IssueStatus issueStatus, Customer customer,
            Solution solution) {
        super();
        this.issueType = issueType;
        this.issueDescription = issueDescription;
        this.customer = customer;
        this.solution = solution;
    }
}
