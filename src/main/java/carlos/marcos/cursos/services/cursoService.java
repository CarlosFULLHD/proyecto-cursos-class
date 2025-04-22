package carlos.marcos.cursos.services;

import carlos.marcos.cursos.dto.res.MensajeRespuestaDTO;
import carlos.marcos.cursos.dto.req.crearCursoConDTO;
import carlos.marcos.cursos.dto.res.RespuestaCursoDTO;
import carlos.marcos.cursos.entity.cursoEntity;
import carlos.marcos.cursos.repository.cursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
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

    //Usamos el DTO respuesta, despues se le pasa el DTO con el nombre y descripcion, igual a la clase API
    public MensajeRespuestaDTO crearCurso(crearCursoConDTO cursoDTO) {
        //Creamos el Objeto Entity
        cursoEntity cursoEntity = new cursoEntity();
        //Get para el nombre y descripcion
        cursoEntity.setNombre(cursoDTO.getNombre());
        cursoEntity.setDescripcion(cursoDTO.getDescripcion());

        //Para fecha de inicio y fin, hacemos nuestra logica de:
        // Fecha_de_inicio inicia desde ahora (now)
        // Fecha_de_fin sera dentro de (now) + 30 dias
        cursoEntity.setFecha_de_inicio(LocalDateTime.now());
        cursoEntity.setFecha_de_fin(LocalDateTime.now().plusDays(30));

        //Guardamos esta logica personalizada en el repository, en nuestra Base de datos con el .save
        //Y tambien lo guardamos dentro de cursoGuardado para usarlo despues
        cursoEntity cursoGuardado = cursoRepository.save(cursoEntity);


        // Creamos el DTO de respuesta usando el mismo DTO que usamos al inicio para personalizar la respuesta
        RespuestaCursoDTO respuesta = new RespuestaCursoDTO();
        respuesta.setNombre(cursoGuardado.getNombre());
        respuesta.setDescripcion(cursoGuardado.getDescripcion());
        respuesta.setId(cursoGuardado.getId());

        // Al final para el DTO respuesta decimos, "mensaje" , "crearCursoConDTO o sea los datos que al inicio pasamos"
        return new MensajeRespuestaDTO("El registro Curso fue creado con exito",
                200,
                "C:\\Main\\projects\\cursos\\cursos\\src\\main\\java\\carlos\\marcos\\cursos\\services\\cursoService.java",
                LocalDateTime.now(),
                respuesta);
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

//    public Optional<MensajeRespuestaDTO> actualizarCurso(Long id, crearCursoConDTO cursoDTO) {
//        return cursoRepository.findById(id).map(curso -> {
//            curso.setNombre(cursoDTO.getNombre());
//            curso.setDescripcion(cursoDTO.getDescripcion());
//
//            // Mantener fechas anteriores o modificarlas si deseas lógica dinámica
//            curso.setFecha_de_inicio(LocalDateTime.now()); // O mantener: curso.getFecha_de_inicio()
//            curso.setFecha_de_fin(LocalDateTime.now().plusDays(30));
//
//            cursoEntity actualizado = cursoRepository.save(curso);
//
//            crearCursoConDTO respuesta = new crearCursoConDTO();
//            respuesta.setNombre(actualizado.getNombre());
//            respuesta.setDescripcion(actualizado.getDescripcion());
//
//            return new MensajeRespuestaDTO("200 - Curso actualizado correctamente", respuesta);
//        });
//    }




    public void eliminarCurso(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }
}
