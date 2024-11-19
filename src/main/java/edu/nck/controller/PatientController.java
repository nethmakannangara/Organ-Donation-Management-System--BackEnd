package edu.nck.controller;

import edu.nck.model.Patient;
import edu.nck.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/all")
    public Patient getAll(){
        return patientService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Patient patient){
        patientService.save(patient);
    }
}
