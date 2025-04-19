package carlos.marcos.cursos.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
@Component
@Entity(name="curso")
@Table(name="curso")
public class cursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_curso", nullable=false)
    private Long id;

    @Column(name="nombre", nullable=false, length=50)
    private String nombre;

    @Column(name="descripcion", nullable=false, length=100)
    private String descripcion;


    @Column(name="fecha_de_inicio", nullable=false, updatable=false)
    private LocalDateTime fecha_de_inicio;

    @Column(name="fecha_de_fin", nullable=false, updatable=false)
    private LocalDateTime fecha_de_fin;

    /* ALT+ INSERT   */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha_de_inicio() {
        return fecha_de_inicio;
    }

    public void setFecha_de_inicio(LocalDateTime fecha_de_inicio) {
        this.fecha_de_inicio = fecha_de_inicio;
    }

    public LocalDateTime getFecha_de_fin() {
        return fecha_de_fin;
    }

    public void setFecha_de_fin(LocalDateTime fecha_de_fin) {
        this.fecha_de_fin = fecha_de_fin;
    }

    public cursoEntity(Long id, String nombre, String descripcion, LocalDateTime fecha_de_inicio, LocalDateTime fecha_de_fin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_de_inicio = fecha_de_inicio;
        this.fecha_de_fin = fecha_de_fin;
    }

    public cursoEntity() {
    }
}
