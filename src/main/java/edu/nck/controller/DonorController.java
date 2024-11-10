package edu.nck.controller;
import edu.nck.model.Donor;
import edu.nck.model.LoginInfo;
import edu.nck.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/donors")
@RequiredArgsConstructor
@CrossOrigin
public class DonorController {

    private final DonorService donorService;

    @GetMapping("/{donorEmail}")
    public Donor persist(@PathVariable String donorEmail){
        System.out.println(donorService.get(donorEmail));
        return donorService.get(donorEmail);
    }

    @GetMapping
    public Set<Donor> getAll(){
        return donorService.getAll();
    }

    @PostMapping("/register")
    public void register(@RequestBody Donor donor){
        donorService.save(donor);
    }

    //UPDATE//
    @PutMapping
    public void update(@RequestBody Donor donor){
        donorService.update(donor);
    }

    //DELETE//
    @DeleteMapping("/{donorId}")
    public void delete(@RequestParam String donorId) {
        donorService.delete(donorId);
    }

    //LOGIN_CONTROLLER//
    @PostMapping("login")
    public boolean loginRegister(@RequestBody LoginInfo loginInfo){
        return donorService.register(loginInfo.getEmail(),loginInfo.getPassword());
    }

    //GET_DONOR_ID//
    @GetMapping("/generate-id")
    public String generateId(){
        return donorService.generateId();
    }

}
