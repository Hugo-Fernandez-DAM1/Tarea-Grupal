CREATE TABLE autores (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    nacionalidad TEXT
);

-- TODO: Completar la creación de la tabla 'libros' con los siguientes campos:
-- id (PK), titulo, idAutor (FK hacia autores.id), anioPublicacion
-- Sugerencia: definir restricción de clave foránea.
