-- 1. Tabla curso
CREATE TABLE curso (
id_curso SERIAL PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
descripcion TEXT NOT NULL,
fecha_de_inicio TIMESTAMP NOT NULL,
fecha_de_fin TIMESTAMP NOT NULL
);

-- 2. Tabla estudiante
CREATE TABLE estudiante (
id_estudiante SERIAL PRIMARY KEY,
nombre_completo VARCHAR(100) NOT NULL,
correo_electronico VARCHAR(100) UNIQUE NOT NULL
);

-- 3. Tabla inscripcion
CREATE TABLE inscripcion (
id_inscripcion SERIAL PRIMARY KEY,
id_curso INTEGER NOT NULL REFERENCES curso(id_curso) ON DELETE CASCADE,
id_estudiante INTEGER NOT NULL REFERENCES estudiante(id_estudiante) ON DELETE CASCADE,
fecha_inscripcion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
