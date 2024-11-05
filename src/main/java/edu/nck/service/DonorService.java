package edu.nck.service;

import edu.nck.model.Donor;
import org.hibernate.mapping.List;

public interface DonorService {

    Donor get(String donorEmail);

    List getAll();

    void save(Donor donor);

    void update(Donor donor);

    void delete(String donorId);
}
