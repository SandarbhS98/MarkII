package com.example.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datajpa.model.UserDTO;
import com.example.datajpa.pojo.loanDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer> {

	loanDTO save(loanDTO dtos);

}
