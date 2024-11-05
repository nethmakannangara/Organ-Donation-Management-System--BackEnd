package edu.nck.controller;

import edu.nck.entity.DonorEntity;
import edu.nck.model.Donor;
import edu.nck.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @GetMapping("/donor?donorEmail")
    public Donor persist(@RequestParam String donorEmail){
        return donorService.get(donorEmail);
    }

    @GetMapping("/donors")
    public List<Donor> getAll(){
//        return donorService.getAll();
        return null;
    }

    @PostMapping
    public void save(@RequestBody Donor donor){
        donorService.save(donor);
    }

    @PutMapping
    public void update(@RequestBody Donor donor){
        donorService.update(donor);
    }

    @DeleteMapping("/donor?donorId")
    public void delete(@RequestParam String donorId) {
        donorService.delete(donorId);
    }
}
