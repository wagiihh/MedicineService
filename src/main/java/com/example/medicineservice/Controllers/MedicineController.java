package com.example.medicineservice.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteMedicine(@RequestBody Map<String, Integer> body) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###########################################" + body);
        int id = body.get("id");
        medicineRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/update")
public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine medicine) {
    if (!this.medicineRepository.existsById(medicine.getId())) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Medicine updatedMedicine = this.medicineRepository.save(medicine);
    return new ResponseEntity<>(updatedMedicine, HttpStatus.OK);
}
    


    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Integer id) {
        Medicine medicine = this.medicineRepository.findById(id).orElse(null);
        if (medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }
    


}
