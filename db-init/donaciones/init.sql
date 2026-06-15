SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS donacion (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    donante_id       BIGINT        NOT NULL,
    tipo_donacion_id BIGINT        NOT NULL,
    nombre           VARCHAR(150)  NOT NULL,
    cantidad         DECIMAL(10,2) NOT NULL,
    fecha            DATE          NOT NULL DEFAULT (CURRENT_DATE),
    descripcion      VARCHAR(500),
    estado           VARCHAR(50)   NOT NULL DEFAULT 'PENDIENTE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO donacion (id, donante_id, tipo_donacion_id, nombre, cantidad, fecha, descripcion, estado) VALUES
(1,  1,  1, 'Ropa de invierno talla M', 3.00,  '2025-05-10', 'Entregado en buen estado',        'DISTRIBUIDA'),
(2,  2,  3, 'Pañales talla M',          2.00,  '2025-05-12', 'Paquetes de 40 unidades',         'RECIBIDA'),
(3,  3,  5, 'Cuadernos y lápices',      10.00, '2025-05-15', 'Kit completo por niño',           'DISTRIBUIDA'),
(4,  4,  4, 'Frazadas',                 4.00,  '2025-05-18', 'En camino al centro',             'EN_TRANSITO'),
(5,  5,  1, 'Arroz y fideos',           5.00,  '2025-05-20', 'Pendiente de retiro',             'PENDIENTE'),
(6,  6,  7, 'Silla de ruedas',          1.00,  '2025-05-21', 'Coordinado con médico',           'RECIBIDA'),
(7,  7,  4, 'Ropa para bebé',           1.00,  '2025-05-22', 'Set completo 0-3 meses',          'DISTRIBUIDA'),
(8,  8,  6, 'Shampoo y jabón',          6.00,  '2025-05-24', 'Productos de primera necesidad',  'DISTRIBUIDA'),
(9,  9,  2, 'Alimentos sin azúcar',     4.00,  '2025-05-26', 'Coordinar entrega con familia',   'PENDIENTE'),
(10, 10, 4, 'Frazadas dobles',          2.00,  '2025-05-28', 'Donante no pudo entregar',        'CANCELADA'),
(11, 1,  5, 'Mochila escolar',          1.00,  '2025-05-29', 'Con útiles incluidos',            'RECIBIDA'),
(12, 2,  2, 'Medicamentos vitamínicos', 2.00,  '2025-05-30', 'En tránsito desde farmacia',      'EN_TRANSITO'),
(13, 3,  1, 'Aceite y legumbres',       3.00,  '2025-06-01', NULL,                              'PENDIENTE'),
(14, 4,  2, 'Avena y leche en polvo',   5.00,  '2025-06-02', 'Para dieta del adulto mayor',     'DISTRIBUIDA'),
(15, 5,  5, 'Mochila y colores',        1.00,  '2025-06-03', 'Lista para inicio de clases',     'RECIBIDA');

-- ============================================================
-- TABLA: donacion_acopio (recepción de donaciones en centros)
-- ============================================================
CREATE TABLE IF NOT EXISTS donacion_acopio (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    donacion_id      BIGINT      NOT NULL,
    centro_acopio_id BIGINT      NOT NULL,
    fecha_recepcion  DATE        NOT NULL DEFAULT (CURRENT_DATE),
    estado           VARCHAR(50) NOT NULL DEFAULT 'RECIBIDA'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO donacion_acopio (id, donacion_id, centro_acopio_id, fecha_recepcion, estado) VALUES
(1,  1,  1, '2025-05-11', 'DISTRIBUIDA'),
(2,  2,  1, '2025-05-13', 'RECIBIDA'),
(3,  3,  2, '2025-05-16', 'DISTRIBUIDA'),
(4,  6,  3, '2025-05-22', 'PROCESADA'),
(5,  7,  4, '2025-05-23', 'DISTRIBUIDA'),
(6,  8,  4, '2025-05-25', 'DISTRIBUIDA'),
(7,  11, 6, '2025-05-30', 'RECIBIDA'),
(8,  14, 5, '2025-06-03', 'DISTRIBUIDA'),
(9,  15, 2, '2025-06-04', 'PROCESADA');