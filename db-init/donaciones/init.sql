SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

DROP TABLE IF EXISTS donacion;
CREATE TABLE donacion (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    donante_id       BIGINT       NOT NULL,
    beneficiario_id  BIGINT       NOT NULL,
    centro_acopio_id BIGINT       NOT NULL,
    articulo         VARCHAR(255) NOT NULL,
    cantidad         INT          NOT NULL,
    estado           VARCHAR(20)  NOT NULL DEFAULT 'PENDIENTE',
    observaciones    TEXT,
    creado_en        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en   DATETIME
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO donacion (id, donante_id, beneficiario_id, centro_acopio_id, articulo, cantidad, estado, observaciones, creado_en) VALUES
(1,  1, 1,  1, '[Ropa] Ropa de invierno talla M',     3,  'ENTREGADA',   'Entregado en buen estado',       NOW()),
(2,  2, 2,  1, '[Higiene] Pañales talla M',            2,  'ENTREGADA',   'Paquetes de 40 unidades',        NOW()),
(3,  3, 3,  2, '[Educación] Cuadernos y lápices',      10, 'ENTREGADA',   'Kit completo por niño',          NOW()),
(4,  4, 4,  2, '[Hogar] Frazadas',                     4,  'EN_TRANSITO', 'En camino al centro',            NOW()),
(5,  5, 5,  3, '[Alimentos] Arroz y fideos',           5,  'PENDIENTE',   'Pendiente de retiro',            NOW()),
(6,  6, 6,  3, '[Salud] Silla de ruedas',              1,  'ENTREGADA',   'Coordinado con médico',          NOW()),
(7,  7, 7,  4, '[Ropa] Ropa para bebé',                1,  'ENTREGADA',   'Set completo 0-3 meses',         NOW()),
(8,  8, 8,  4, '[Higiene] Shampoo y jabón',            6,  'ENTREGADA',   'Productos de primera necesidad', NOW()),
(9,  9, 9,  5, '[Alimentos] Alimentos sin azúcar',     4,  'PENDIENTE',   'Coordinar entrega con familia',  NOW()),
(10, 10,10, 5, '[Hogar] Frazadas dobles',              2,  'CANCELADA',   'Donante no pudo entregar',       NOW()),
(11, 1, 11, 6, '[Educación] Mochila escolar',          1,  'ENTREGADA',   'Con útiles incluidos',           NOW()),
(12, 2, 12, 6, '[Salud] Medicamentos vitamínicos',     2,  'EN_TRANSITO', 'En tránsito desde farmacia',     NOW());
