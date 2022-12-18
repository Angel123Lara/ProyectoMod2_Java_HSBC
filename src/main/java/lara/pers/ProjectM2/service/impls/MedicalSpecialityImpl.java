package lara.pers.ProjectM2.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lara.pers.ProjectM2.dto.MedicalSpecialityDTO;
import lara.pers.ProjectM2.entity.MedicalSpeciality;
import lara.pers.ProjectM2.mapper.MedicalSpecialityMapper;

import lara.pers.ProjectM2.repository.MedicalSpecialRepository;
import lara.pers.ProjectM2.service.MedicalSpecialityService;


@Service
public class MedicalSpecialityImpl implements MedicalSpecialityService {

    private MedicalSpecialityMapper mapper;
    private MedicalSpecialRepository repository;

    @Autowired
    public MedicalSpecialityImpl (MedicalSpecialityMapper mapper, MedicalSpecialRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<MedicalSpecialityDTO> findAll(){
        List<MedicalSpeciality> medicalSpeciality  = repository.findAll();
        return medicalSpeciality.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<MedicalSpecialityDTO> findById(long id){
        return null;
    }

    public MedicalSpecialityDTO save(MedicalSpecialityDTO data){
        MedicalSpeciality entity = mapper.toEntity(data);

        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, MedicalSpecialityDTO data) throws Exception {
        Optional<MedicalSpeciality> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("We can't found the hospital");
        }
    
        MedicalSpeciality hospital = result.get();
    
        hospital.setName(data.getName());
    
        repository.save(hospital);
      }
    
      public void delete(long id) throws Exception {
        Optional<MedicalSpeciality> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Hospital doesn't exist");
        }
    
        repository.deleteById(id);
      }    
    
}
