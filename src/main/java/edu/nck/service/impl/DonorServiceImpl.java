package edu.nck.service.impl;

import edu.nck.model.Donor;
import edu.nck.repository.DonorRepository;
import edu.nck.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public Donor get(String donorEmail) {
//        return mapper.map(donorRepository.findByEmail(donorEmail),Donor.class);
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Donor donor) {

    }

    @Override
    public void update(Donor donor) {

    }

    @Override
    public void delete(String donorId) {

    }
}
