package edu.nck.service;

import edu.nck.model.Patient;

import java.util.Set;

public interface PatientService {
    Set<Patient> getAll();

    void save(Patient patient);

    Patient get(String patientId);

}
