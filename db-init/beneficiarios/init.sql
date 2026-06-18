SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

DROP TABLE IF EXISTS beneficiario;
CREATE TABLE beneficiario (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre           VARCHAR(100) NOT NULL,
    apellido         VARCHAR(100) NOT NULL,
    rut              VARCHAR(20)  NOT NULL UNIQUE,
    telefono         VARCHAR(20),
    necesidad        TEXT,
    centro_acopio_id BIGINT       NOT NULL,
    activo           TINYINT(1)   NOT NULL DEFAULT 1,
    creado_en        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO beneficiario (id, nombre, apellido, rut, telefono, necesidad, centro_acopio_id, activo, creado_en) VALUES
(1,  'Luis',    'Soto',      '21000001-1', '+56911110001', 'Ropa de invierno y alimentos no perecibles', 1, 1, NOW()),
(2,  'Ana',     'Pérez',     '21000002-2', '+56911110002', 'Medicamentos básicos y pañales',              1, 1, NOW()),
(3,  'Manuel',  'Castro',    '21000003-3', '+56911110003', 'Útiles escolares para 3 niños',              2, 1, NOW()),
(4,  'Rosa',    'Díaz',      '21000004-4', '+56911110004', 'Colchón y ropa de cama',                     2, 1, NOW()),
(5,  'Jorge',   'Álvarez',   '21000005-5', '+56911110005', 'Alimentos no perecibles y artículos de aseo',3, 1, NOW()),
(6,  'Patricia','Reyes',     '21000006-6', '+56911110006', 'Ayudas técnicas para movilidad',             3, 1, NOW()),
(7,  'Héctor',  'Vargas',    '21000007-7', '+56911110007', 'Ropa para bebé y leche en polvo',            4, 1, NOW()),
(8,  'Carmen',  'Jiménez',   '21000008-8', '+56911110008', 'Útiles de aseo e higiene personal',          4, 1, NOW()),
(9,  'Roberto', 'Medina',    '21000009-9', '+56911110009', 'Alimentos para adulto mayor con diabetes',   5, 1, NOW()),
(10, 'Isabel',  'Rojas',     '21000010-k', '+56911110010', 'Ropa de invierno y frazadas',                5, 1, NOW()),
(11, 'Pablo',   'Núñez',     '21000011-1', '+56911110011', 'Material escolar y mochila',                 6, 1, NOW()),
(12, 'Marcela', 'Flores',    '21000012-2', '+56911110012', 'Artículos de aseo y alimentos básicos',      6, 1, NOW());
