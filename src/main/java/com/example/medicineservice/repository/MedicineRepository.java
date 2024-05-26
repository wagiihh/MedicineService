package com.example.medicineservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicineservice.Models.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
    
}
