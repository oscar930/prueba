CREATE TABLE  ticket (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estatus VARCHAR(10) CHECK (estatus IN ('abierto', 'cerrado')) NOT NULL
);