package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Entity.*;

public interface IssueRepository extends JpaRepository<Issue, Integer>{


}
