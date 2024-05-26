package com.example.medicineservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicineservice.Models.Medicine;
import com.example.medicineservice.repository.MedicineRepository;

@RestController
@RequestMapping("/feedback")
public class MedicineController {

    @Autowired
    MedicineRepository feedbackRepository;
    
      @GetMapping("")
    public ResponseEntity getFeedbacks(){
        List<Medicine> feedbacks= this.feedbackRepository.findAll(); 
        return new ResponseEntity(feedbacks, HttpStatus.OK);
    }



}
