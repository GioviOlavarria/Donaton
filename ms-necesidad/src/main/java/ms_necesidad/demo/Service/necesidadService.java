package ms_necesidad.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_necesidad.demo.Model.Necesidad;
import ms_necesidad.demo.Repository.necesidadRepository;

@Service
public class necesidadService {
    @Autowired
    private necesidadRepository NecesidadRepository;

    public List<Necesidad> getNecesidades(){
        return NecesidadRepository.findAll();
    }

    public Necesidad saveNecesidad(Necesidad necesidad){
        return NecesidadRepository.save(necesidad);
    }

    public Necesidad getNecesidadById(Long id){
        return NecesidadRepository.findById(id).orElse(null);
    }

    public void deleteNecesidad(Long id){
        NecesidadRepository.deleteById(id);
    }

    public List<Necesidad> getNecesidadesByCentroAcopioId(Long centroAcopioId) {
        return NecesidadRepository.findByCentroAcopioId(centroAcopioId);
    }

    public List<Necesidad> getNecesidadesByBeneficianteId(Long beneficianteId) {
        return NecesidadRepository.findByBeneficianteId(beneficianteId);
    }

    
}
