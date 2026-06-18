package ms_necesidad.demo.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Necesidad")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Necesidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad_requerida", nullable = false)
    private Integer cantidadRequerida;

    @Column(name = "cantidad_actual", nullable = false)
    private Integer cantidadActual;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "centro_acopio_id", nullable = false)
    private Long centroAcopioId;

    @Column(name = "tipo_donacion_id", nullable = false)
    private Long tipoDonacionId;

    @Column(name = "beneficiante_id", nullable = false)
    private Long beneficianteId;

}
