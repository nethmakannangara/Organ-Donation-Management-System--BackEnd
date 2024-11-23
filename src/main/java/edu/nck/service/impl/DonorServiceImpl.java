package edu.nck.service.impl;

import edu.nck.entity.DonorEntity;
import edu.nck.model.Donor;
import edu.nck.repository.DonorRepository;
import edu.nck.service.DonorService;
import edu.nck.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;
    private final EmailService emailService;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public Donor get(String donorEmail) {
        return mapper.map(donorRepository.findByEmail(donorEmail),Donor.class);
    }

    @Override
    public Set<Donor> getAll() {
        Iterable<DonorEntity> donorEntities = donorRepository.findAll();
        Set<Donor> donorList = new HashSet<>();
        donorEntities.forEach(donorEntity -> {
            donorList.add(mapper.map(donorEntity,Donor.class));
        });
        return donorList;
    }

    @Override
    public void save(Donor donor) {
        donorRepository.save(mapper.map(donor, DonorEntity.class));
    }

    @Override
    public void update(Donor donor) {
        donorRepository.save(mapper.map(donor,DonorEntity.class));
    }

    @Override
    public void delete(String donorId) {
        donorRepository.delete(mapper.map(donorId,DonorEntity.class));
    }

    //GENERATE_ID//
    public String generateId() {
        Set<Donor> allDonors = getAll();
        if (allDonors.isEmpty()) {
            return "D1001";
        }

        String lastId = null;
        for (Donor donor : allDonors) {
            lastId = donor.getDonorId();
        }

        if (lastId == null || lastId.isEmpty()) {
            return "D1001";
        }
        int lastNumber = Integer.parseInt(lastId.substring(1));

        int newNumber = lastNumber + 1;

        return "D" + String.format("%04d", newNumber);

    }

    @Override
    public boolean sendDonorInfoToHospital(String donorEmail, String donorFirstName, String donorLastName, String donorPhone, String donorBloodType, String patientFirstName, String patientLastName, String patientAge, String patientOrgan, String patientBloodType) {
        return  emailService.sendDonorInfoToHospital( donorEmail,  donorFirstName, donorLastName,  donorPhone,  donorBloodType,  patientFirstName,  patientLastName,  patientAge,  patientOrgan,  patientBloodType);
    }

}
