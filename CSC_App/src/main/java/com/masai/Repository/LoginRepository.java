package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
