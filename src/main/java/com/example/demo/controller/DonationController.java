package com.example.demo.controller;

import com.example.demo.model.Donor;
import com.example.demo.repository.DonorRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donors")
public class DonationController {

    @Autowired
    private DonorRepository donorRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerDonor(@RequestBody Donor donor, HttpSession session) {
     /*   if (session.getAttribute("user") == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Unauthorized! Please login."));
        }  */
        donorRepository.save(donor);
        return ResponseEntity.ok(Map.of("message", "Donor registered successfully!"));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDonors(HttpSession session) {
     /*   if (session.getAttribute("user") == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Unauthorized!"));
        }  */
        List<Donor> donors = donorRepository.findAll();
        return ResponseEntity.ok(donors);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDonor(@PathVariable Long id) {
        if (donorRepository.existsById(id)) {
            donorRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Donor record deleted successfully!"));
        }
        return ResponseEntity.status(404).body(Map.of("message", "Record not found!"));
    }


}
