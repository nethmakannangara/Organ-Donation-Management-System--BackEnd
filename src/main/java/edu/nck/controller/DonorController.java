package edu.nck.controller;

import edu.nck.entity.DonorEntity;
import edu.nck.model.Donor;
import edu.nck.model.LoginInfo;
import edu.nck.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")
@RequiredArgsConstructor
@CrossOrigin
public class DonorController {

    private final DonorService donorService;

    @GetMapping("/get")
    public Donor persist(){
        System.out.println("D001");
        return donorService.get("D001");
    }

    @GetMapping("/donors")
    public List<Donor> getAll(){
        return (List<Donor>) donorService.getAll();
    }

    @GetMapping
    public String test(){
        return "API Working";
    }

    @PostMapping("/register")
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

    //LOGIN_CONTROLLER//
    @PostMapping("login")
    public boolean loginRegister(@RequestBody LoginInfo loginInfo){
        return donorService.register(loginInfo.getEmail(),loginInfo.getPassword());
    }

    //GENERATE_ID//
    @GetMapping("/generateId")
    public void generateId(){
        donorService.generateId();
    }
}
