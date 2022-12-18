package lara.pers.ProjectM2.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lara.pers.ProjectM2.dto.DoctorsDTO;
import lara.pers.ProjectM2.entity.Doctors;
import lara.pers.ProjectM2.mapper.DoctorsMapper;
import lara.pers.ProjectM2.repository.DoctorsRepository;
import lara.pers.ProjectM2.service.DoctorService;

@Service
public class DoctorsServiceImpl implements DoctorService {

    private DoctorsMapper mapper;
    private DoctorsRepository repository;

    @Autowired
    public DoctorsServiceImpl(DoctorsMapper mapper, DoctorsRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<DoctorsDTO> findAll(){
        List<Doctors> hospitals  = repository.findAll();
        return hospitals.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<DoctorsDTO> findById(long id){
        return null;
    }

    public DoctorsDTO save(DoctorsDTO data){
        Doctors entity = mapper.toEntity(data);

        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, DoctorsDTO  data) throws Exception {
        Optional<Doctors> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("We can't found the hospital");
        }
    
        Doctors hospital = result.get();
    
        hospital.setName(data.getName());
    
        repository.save(hospital);
      }
    
      public void delete(long id) throws Exception {
        Optional<Doctors> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Hospital doesn't exist");
        }
    
        repository.deleteById(id);
      }    
    
}
