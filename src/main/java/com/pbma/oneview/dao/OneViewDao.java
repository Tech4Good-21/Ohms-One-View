package com.pbma.oneview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pbma.oneview.entity.Trainee;

public interface OneViewDao extends JpaRepository<Trainee, Integer> {
	
	

}