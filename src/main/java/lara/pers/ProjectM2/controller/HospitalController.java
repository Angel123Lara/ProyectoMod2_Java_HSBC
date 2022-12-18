package lara.pers.ProjectM2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lara.pers.ProjectM2.dto.HospitalDTO;
import lara.pers.ProjectM2.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private HospitalService service;

    @Autowired
    public HospitalController(HospitalService service){
        this.service = service;
    }

    @GetMapping
    public String start(){
        return "This is the Hospital directory";
    }

    @GetMapping("/all")
    public List<HospitalDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HospitalDTO save(@RequestBody HospitalDTO data){
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody HospitalDTO data) throws Exception {

        service.update(id, data);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
    }
}
