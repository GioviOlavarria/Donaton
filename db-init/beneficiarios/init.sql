SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS beneficiante (
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_beneficiante_id BIGINT       NOT NULL,
    centro_acopio_id     BIGINT       NOT NULL,
    rut                  VARCHAR(10)  NOT NULL UNIQUE,
    dv                   CHAR(1)      NOT NULL,
    nombre               VARCHAR(150) NOT NULL,
    razon                VARCHAR(500),
    tipo_siniestro       VARCHAR(100),
    fecha_siniestro      DATE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO beneficiante (id, tipo_beneficiante_id, centro_acopio_id, rut, dv, nombre, razon, tipo_siniestro, fecha_siniestro) VALUES
(1,  1, 1, '21000001', '1', 'Luis Soto',       'Ropa de invierno talla M y alimentos no perecibles',  'Incendio estructural',  '2025-06-12'),
(2,  3, 1, '21000002', '2', 'Ana Pérez',       'Medicamentos básicos y pañales talla M',              'Vulnerabilidad económica', NULL),
(3,  5, 2, '21000003', '3', 'Manuel Castro',   'Útiles escolares para 3 niños en edad escolar',       NULL,                    NULL),
(4,  4, 2, '21000004', '4', 'Rosa Díaz',       'Colchón y ropa de cama para familia de 4 personas',   'Inundación',             '2025-07-03'),
(5,  3, 3, '21000005', '5', 'Jorge Álvarez',   'Alimentos no perecibles y artículos de aseo',         'Vulnerabilidad económica', NULL),
(6,  7, 3, '21000006', '6', 'Patricia Reyes',  'Silla de ruedas y ayudas técnicas para movilidad',    'Discapacidad',          NULL),
(7,  4, 4, '21000007', '7', 'Héctor Vargas',   'Ropa para bebé recién nacido y leche en polvo',       'Terremoto',             '2025-03-20'),
(8,  3, 4, '21000008', '8', 'Carmen Jiménez',  'Útiles de aseo y productos de higiene personal',      'Vulnerabilidad económica', NULL),
(9,  2, 5, '21000009', '9', 'Roberto Medina',  'Alimentos para adulto mayor con diabetes',            'Adulto mayor sin red',  NULL),
(10, 4, 5, '21000010', 'k', 'Isabel Rojas',    'Ropa de invierno y frazadas para dos personas',       'Incendio forestal',     '2025-02-08'),
(11, 5, 6, '21000011', '1', 'Pablo Núñez',     'Material escolar y mochila para niña de 8 años',      NULL,                    NULL),
(12, 8, 6, '21000012', '2', 'Marcela Flores',  'Artículos de aseo y alimentos básicos',               'Violencia intrafamiliar', '2025-05-30');

-- ============================================================
-- TABLA: necesidad (solicitudes de donaciones de beneficiantes)
-- ============================================================
CREATE TABLE IF NOT EXISTS necesidad (
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    centro_acopio_id   BIGINT        NOT NULL,
    tipo_donacion_id   BIGINT        NOT NULL,
    beneficiante_id    BIGINT,
    cantidad_requerida DECIMAL(10,2) NOT NULL,
    cantidad_actual    DECIMAL(10,2) NOT NULL DEFAULT 0,
    estado             VARCHAR(50)   NOT NULL DEFAULT 'ACTIVA',
    fecha_creacion     DATE          NOT NULL DEFAULT (CURRENT_DATE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO necesidad (id, centro_acopio_id, tipo_donacion_id, beneficiante_id, cantidad_requerida, cantidad_actual, estado, fecha_creacion) VALUES
(1, 1, 2, 1,  5.00,  2.00, 'ACTIVA',   '2025-06-12'),
(2, 1, 3, 2,  3.00,  3.00, 'CUBIERTA', '2025-06-13'),
(3, 2, 4, 3,  10.00, 4.00, 'ACTIVA',   '2025-06-14'),
(4, 3, 1, 5,  8.00,  0.00, 'ACTIVA',   '2025-06-15'),
(5, 4, 2, 7,  4.00,  1.00, 'ACTIVA',   '2025-06-15'),
(6, 5, 1, 9,  6.00,  6.00, 'CUBIERTA', '2025-06-10'),
(7, 6, 4, 11, 2.00,  0.00, 'ACTIVA',   '2025-06-16');