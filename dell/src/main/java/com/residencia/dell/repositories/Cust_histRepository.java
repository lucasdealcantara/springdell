package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Cust_hist;



@Repository
public interface Cust_histRepository extends JpaRepository<Cust_hist, Integer> {
 
}

