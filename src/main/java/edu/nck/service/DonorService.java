package edu.nck.service;

import edu.nck.model.Donor;
import org.hibernate.mapping.List;

import java.util.Set;

public interface DonorService {

    Donor get(String donorId);

    Set<Donor> getAll();

    void save(Donor donor);

    void update(Donor donor);

    void delete(String donorId);

    boolean register(String email, String password);

    String generateId();

}
