INSERT INTO curso (nombre, descripcion, fecha_de_inicio, fecha_de_fin)
VALUES
    ('Java desde Cero', 'Curso introductorio a la programación en Java', '2024-05-01 08:00:00', '2024-06-01 08:00:00'),
    ('Spring Boot Avanzado', 'Desarrollo de API REST con Spring Boot y JPA', '2024-06-05 08:00:00', '2024-07-05 08:00:00'),
    ('Base de Datos con PostgreSQL', 'Modelado y consultas SQL en PostgreSQL', '2024-05-10 09:00:00', '2024-06-10 09:00:00');


INSERT INTO estudiante (nombre_completo, correo_electronico)
VALUES
    ('Juan Pérez', 'juan.perez@gmail.com'),
    ('María Gómez', 'maria.gomez@hotmail.com'),
    ('Carlos Ramos', 'carlos.ramos@outlook.com');


INSERT INTO inscripcion (id_curso, id_estudiante)
VALUES
    (1, 1), -- Juan en Java
    (2, 1), -- Juan en Spring
    (2, 2), -- María en Spring
    (3, 3); -- Carlos en PostgreSQL


