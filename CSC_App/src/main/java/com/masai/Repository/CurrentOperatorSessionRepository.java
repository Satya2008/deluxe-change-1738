package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Call;
import com.masai.Entity.CurrentOperatorSession;
import com.masai.Entity.Operator;

public interface CurrentOperatorSessionRepository extends JpaRepository<CurrentOperatorSession, Integer> {

	public CurrentOperatorSession findByToken(String token);
	
}
