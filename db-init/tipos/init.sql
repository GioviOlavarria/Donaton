SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS tipo_donacion (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    clasificacion VARCHAR(100) NOT NULL,
    descripcion   VARCHAR(300)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS tipo_beneficiante (
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO tipo_donacion (id, clasificacion, descripcion) VALUES
(1, 'Alimentos no perecibles', 'Conservas, legumbres, cereales, azúcar, aceite y otros alimentos con larga vida útil'),
(2, 'Ropa y abrigo',           'Prendas de vestir en buen estado, frazadas, sacos de dormir y calzado'),
(3, 'Medicamentos',            'Medicamentos con fecha de vencimiento vigente, sin receta o de venta libre'),
(4, 'Útiles escolares',        'Cuadernos, lápices, mochilas, estuches y materiales educativos en general'),
(5, 'Muebles y enseres',       'Muebles en buen estado, electrodomésticos básicos y artículos del hogar'),
(6, 'Dinero',                  'Aportes monetarios para financiar operaciones, transporte y compras urgentes'),
(7, 'Artículos de higiene',    'Jabón, shampoo, papel higiénico, pasta dental, pañales y productos de aseo personal'),
(8, 'Juguetes',                'Juguetes en buen estado para niños y niñas de distintas edades');

INSERT IGNORE INTO tipo_beneficiante (id, categoria) VALUES
(1, 'Familia damnificada por incendio'),
(2, 'Adulto mayor en situación de calle'),
(3, 'Persona en situación de vulnerabilidad económica'),
(4, 'Víctima de catástrofe natural'),
(5, 'Niño/a en sistema de protección'),
(6, 'Migrante en situación irregular'),
(7, 'Persona con discapacidad sin red de apoyo'),
(8, 'Familia afectada por violencia intrafamiliar');
