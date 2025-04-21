package carlos.marcos.cursos.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "inscripcion")
@Table(name = "inscripcion")
public class inscripcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private cursoEntity curso;


    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDateTime fechaInscripcion = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private estudianteEntity estudiante;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public estudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(estudianteEntity estudiante) {
        this.estudiante = estudiante;
    }

    public cursoEntity getCurso() {
        return curso;
    }

    public void setCurso(cursoEntity curso) {
        this.curso = curso;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
