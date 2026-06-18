CREATE DATABASE IF NOT EXISTS db_necesidad;
USE db_necesidad;

CREATE TABLE IF NOT EXISTS Necesidad (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  cantidad_requerida INT NOT NULL,
  cantidad_actual INT NOT NULL,
  estado VARCHAR(50) NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  centro_acopio_id BIGINT NOT NULL,
  tipo_donacion_id BIGINT NOT NULL,
  beneficiante_id BIGINT NOT NULL
);
