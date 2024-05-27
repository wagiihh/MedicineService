package com.example.medicineservice.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    MedicineRepository medicineRepository;
    
      @GetMapping("")
    public ResponseEntity getMedicines(){
        List<Medicine> medicines= this.medicineRepository.findAll(); 
        return new ResponseEntity(medicines, HttpStatus.OK);
    }

  @PostMapping("/add")
    public ResponseEntity createPost(@RequestBody Map<String,String> body){
        Medicine medicine=new Medicine();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###########################################" +body);
        medicine.setName(body.get("name"));
        System.out.println(body);
        this.medicineRepository.save(medicine);
        return new ResponseEntity(medicine, HttpStatus.CREATED);
    }

}
