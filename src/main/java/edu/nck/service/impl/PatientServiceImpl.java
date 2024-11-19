package edu.nck.service.impl;

import edu.nck.entity.PatientEntity;
import edu.nck.model.Patient;
import edu.nck.repository.PatientRepository;
import edu.nck.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public Patient getAll() {
        return mapper.map(patientRepository.findAll(),Patient.class);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(mapper.map(patient, PatientEntity.class));
    }
}
