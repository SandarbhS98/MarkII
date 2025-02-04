package com.example.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datajpa.model.LoanDataDTO;

@Repository
public interface LoanRepository extends JpaRepository<LoanDataDTO, Integer> {

}
