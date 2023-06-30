package com.pbma.oneview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbma.oneview.entity.Trainee;

@Repository
public interface OneViewDao extends JpaRepository<Trainee, Integer> {
	
	

}