package carlos.marcos.cursos.api;



import carlos.marcos.cursos.entity.cursoEntity;
import carlos.marcos.cursos.services.cursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/cursos")
@Tag(name ="API - Gestión de cursos", description = "Endpoint par el manejo de cursos")
public class cursoApi {

    private final cursoService cursoService;

    public cursoApi(cursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Operation(
            summary = "Obtener un listado de cursos",
            description = "Obtiene cursos ordenados dl 1 al 10," +
                    "1. Servicio conidiconales" +
                    "2. Respotiorio orden"
    )
    @GetMapping
    public ResponseEntity<Object> obtenerCursos() {
        Object response = cursoService.listarcursos();
        return ResponseEntity.ok(response);
    }
//api/v1/cursos/7

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerCursoPorId_Service(@PathVariable Long id) {
        Optional<Object> curso = Optional.ofNullable(cursoService.obtenerCursoPorId_Service(id));

        return curso.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //api/v1/cursos/contraseña1234

    @PostMapping
    public ResponseEntity<cursoEntity> crearCurso(@RequestBody cursoEntity curso) {
        return ResponseEntity.ok(cursoService.crearCurso(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<cursoEntity> modificarCurso(@PathVariable Long id, @RequestBody cursoEntity cursoActualizando) {
        Optional<cursoEntity> curso = cursoService.actualizarCurso(id, cursoActualizando);
        return curso.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();

    }

}
