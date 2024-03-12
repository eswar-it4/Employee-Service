package com.example.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.PhoneNumber;

@Repository
public interface PhoneNumberRep extends JpaRepository<PhoneNumber, Integer> {

}
