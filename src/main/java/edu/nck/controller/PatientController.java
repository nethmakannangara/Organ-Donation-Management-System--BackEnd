package edu.nck.controller;

import edu.nck.model.Patient;
import edu.nck.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("patient")
@CrossOrigin
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/all")
    public Set<Patient> getAll(){
        return patientService.getAll();
    }

    @GetMapping("/{patientId}")
    public Patient get(@PathVariable String patientId){
        return patientService.get(patientId);
    }

    @PostMapping
    public void save(@RequestBody Patient patient){
        patientService.save(patient);
    }
}
