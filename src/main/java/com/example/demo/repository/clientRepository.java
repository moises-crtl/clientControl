package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.clientModel;

@Repository
public interface clientRepository extends JpaRepository<clientModel, Long>{
	

}
