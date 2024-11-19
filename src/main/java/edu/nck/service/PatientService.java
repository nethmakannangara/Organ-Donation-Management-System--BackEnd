package edu.nck.service;

import edu.nck.model.Patient;

public interface PatientService {
    Patient getAll();

    void save(Patient patient);
}
