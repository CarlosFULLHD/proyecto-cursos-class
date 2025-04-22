package carlos.marcos.cursos.dto.res;

public class RespuestaCursoDTO {

    private String nombre;
    private String descripcion;
    private Long id;

    public RespuestaCursoDTO() {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RespuestaCursoDTO(String nombre, String descripcion, Long id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
    }
}
