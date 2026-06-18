package ms_necesidad.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ms_necesidad.demo.Model.Necesidad;

@Repository
public interface necesidadRepository extends JpaRepository<Necesidad, Long> {

    List<Necesidad> findByCentroAcopioId(Long centroAcopioId);

    List<Necesidad> findByBeneficianteId(Long beneficianteId);
}
