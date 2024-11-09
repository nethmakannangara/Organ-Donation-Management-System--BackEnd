package edu.nck.service.impl;

import edu.nck.entity.DonorEntity;
import edu.nck.model.Donor;
import edu.nck.repository.DonorRepository;
import edu.nck.service.DonorService;
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
    private ModelMapper mapper = new ModelMapper();

    @Override
    public Donor get(String donorId) {
        return mapper.map(donorRepository.findById(donorId),Donor.class);
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

    }

    @Override
    public void delete(String donorId) {

    }

    //LOGIN-SERVICE//
    @Override
    public boolean register(String email, String password) {
        return checkValidEmail(email);
    }

    //CHECK_VALID_EMAIL//
    private boolean checkValidEmail(String email){
        Pattern emailPattern = Pattern.compile("[\\W]+");
        Matcher matcher = emailPattern.matcher(email);

        while (matcher.find()){
            if(matcher.group().equals("@")){
                while (matcher.find()){
                    if (matcher.group().equals("."))return true;
                }
            }
        }
        return false;
    }

    //GENERATE_DONOR-ID//
    public String generateId(){
        String lastId;
        Iterator<Donor> iterator = getAll().iterator();
        Set<Donor> allDonors = getAll();
        lastId = iterator.next().getDonorId();
        return String.valueOf(Integer.parseInt(lastId)+ 1);
    }
}
