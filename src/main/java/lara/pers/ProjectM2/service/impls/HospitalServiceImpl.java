package lara.pers.ProjectM2.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lara.pers.ProjectM2.dto.HospitalDTO;
import lara.pers.ProjectM2.entity.Hospital;
import lara.pers.ProjectM2.mapper.HospitalMapper;
import lara.pers.ProjectM2.repository.HospitalRepository;
import lara.pers.ProjectM2.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

    private HospitalMapper mapper;
    private HospitalRepository repository;

    @Autowired
    public HospitalServiceImpl(HospitalMapper mapper, HospitalRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<HospitalDTO> findAll(){
        List<Hospital> hospitals  = repository.findAll();
        return hospitals.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<HospitalDTO> findById(long id){
        return null;
    }

    public HospitalDTO save(HospitalDTO data){
        Hospital entity = mapper.toEntity(data);

        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, HospitalDTO data) throws Exception {
        Optional<Hospital> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("We can't found the hospital");
        }
    
        Hospital hospital = result.get();
    
        hospital.setName(data.getName());
    
        repository.save(hospital);
      }
    
      public void delete(long id) throws Exception {
        Optional<Hospital> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Hospital doesn't exist");
        }
    
        repository.deleteById(id);
      }    
    
}
