package carlos.marcos.cursos.dto.req;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class crearCursoConDTO {

    private String nombre;
    private String descripcion;

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

    public crearCursoConDTO() {
    }
}
