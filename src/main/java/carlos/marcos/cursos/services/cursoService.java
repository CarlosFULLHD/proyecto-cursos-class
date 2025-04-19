package carlos.marcos.cursos.services;

import carlos.marcos.cursos.entity.cursoEntity;
import carlos.marcos.cursos.repository.cursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class cursoService {


    private final cursoRepository cursoRepository;

    public cursoService(cursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Object listarcursos(){
        return cursoRepository.findAll();
    }

    public Optional<cursoEntity> obtenerCursoPorId_Service(Long id) {
        return cursoRepository.findById(id);

    }

    public cursoEntity crearCurso(cursoEntity curso) {
        return cursoRepository.save(curso);

    }

    public Optional<cursoEntity> actualizarCurso(Long id, cursoEntity cursoActualizado) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(cursoActualizado.getNombre());
            curso.setDescripcion(cursoActualizado.getDescripcion());
            curso.setFecha_de_inicio(cursoActualizado.getFecha_de_inicio());
            curso.setFecha_de_fin(cursoActualizado.getFecha_de_fin());
            return cursoRepository.save(curso);
        });
    }


    public void eliminarCurso(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }
}
