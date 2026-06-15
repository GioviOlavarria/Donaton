package ms_necesidad.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ms_necesidad.demo.Model.Necesidad;
import ms_necesidad.demo.Service.necesidadService;

@RestController
public class necesidadController {

    @Autowired
    private necesidadService NecesidadService;

    @GetMapping("/necesidades")
    public ResponseEntity<List<Necesidad>> getNecesidades() {
        List<Necesidad> necesidades = NecesidadService.getNecesidades();
        if(necesidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(necesidades);
    }

    @GetMapping("/necesidades/{id}")
    public ResponseEntity<Necesidad> getNecesidadById(@PathVariable Long id) {
        Necesidad necesidad = NecesidadService.getNecesidadById(id);
        if (necesidad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(necesidad);
    }

    @GetMapping("/necesidades/{centroAcopioId}")
    public ResponseEntity<List<Necesidad>> getNecesidadesByCentroAcopioId(@PathVariable Long centroAcopioId) {
        List<Necesidad> necesidades = NecesidadService.getNecesidadesByCentroAcopioId(centroAcopioId);
        if(necesidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(necesidades);
    }

    @GetMapping("/necesidades/{beneficianteId}")
    public ResponseEntity<List<Necesidad>> getNecesidadesByBeneficianteId(@PathVariable Long beneficianteId) {
        List<Necesidad> necesidades = NecesidadService.getNecesidadesByBeneficianteId(beneficianteId);
        if(necesidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(necesidades);
    }

    @PutMapping("/necesidades/{id}")
    public ResponseEntity<Necesidad> updateNecesidad(@PathVariable Long id, @RequestBody Necesidad necesidad) {
        try{

            Necesidad necesidad1 = NecesidadService.getNecesidadById(id);
            
            necesidad1.setCantidadRequerida(necesidad.getCantidadRequerida());
            necesidad1.setCantidadActual(necesidad.getCantidadActual());
            necesidad1.setEstado(necesidad.getEstado());
            necesidad1.setFechaCreacion(necesidad.getFechaCreacion());
            necesidad1.setCentroAcopioId(necesidad.getCentroAcopioId());
            necesidad1.setTipoDonacionId(necesidad.getTipoDonacionId());
            necesidad1.setBeneficianteId(necesidad.getBeneficianteId());

            Necesidad necesidadActualizada = NecesidadService.saveNecesidad(necesidad1);
            return ResponseEntity.ok(necesidadActualizada);

        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/necesidades/{id}")
    public ResponseEntity<Void> deleteNecesidad(@PathVariable Long id) {
        try {
            NecesidadService.deleteNecesidad(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}