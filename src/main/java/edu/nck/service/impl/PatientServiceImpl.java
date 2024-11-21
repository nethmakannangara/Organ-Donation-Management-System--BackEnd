package edu.nck.service.impl;

import edu.nck.entity.PatientEntity;
import edu.nck.model.Patient;
import edu.nck.repository.PatientRepository;
import edu.nck.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public Set<Patient> getAll() {
        Iterable<PatientEntity> patientEntities = patientRepository.findAll();
        Set<Patient> patientList = new HashSet<>();

        patientEntities.forEach(patientEntity -> {
            patientList.add(mapper.map(patientEntity,Patient.class));
        });
        return patientList;
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(mapper.map(patient, PatientEntity.class));
    }

    @Override
    public Patient get(String patientId) {
        return mapper.map(patientRepository.findById(patientId),Patient.class);
    }
}
