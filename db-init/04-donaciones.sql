USE db_donaciones;
CREATE TABLE IF NOT EXISTS donacion (
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
    );

INSERT INTO donacion (donante_id, beneficiario_id, centro_acopio_id, articulo, cantidad, estado, observaciones) VALUES
                                                                                                                    (1,  1,  1, 'Ropa de invierno talla M',        3,  'ENTREGADA',   'Entregado en buen estado'),
                                                                                                                    (2,  2,  1, 'Pañales talla M',                 2,  'ASIGNADA',    'Paquetes de 40 unidades'),
                                                                                                                    (3,  3,  2, 'Cuadernos y lápices',             10, 'ENTREGADA',   'Kit completo por niño'),
                                                                                                                    (4,  4,  2, 'Frazadas',                        4,  'EN_TRANSITO', 'En camino al centro'),
                                                                                                                    (5,  5,  3, 'Arroz y fideos',                  5,  'PENDIENTE',   'Pendiente de retiro'),
                                                                                                                    (6,  6,  3, 'Silla de ruedas',                 1,  'ASIGNADA',    'Coordinado con médico'),
                                                                                                                    (7,  7,  4, 'Ropa para bebé',                  1,  'ENTREGADA',   'Set completo 0-3 meses'),
                                                                                                                    (8,  8,  4, 'Shampoo y jabón',                 6,  'ENTREGADA',   'Productos de primera necesidad'),
                                                                                                                    (9,  9,  5, 'Alimentos sin azúcar',            4,  'PENDIENTE',   'Coordinar entrega con familia'),
                                                                                                                    (10, 10, 5, 'Frazadas dobles',                 2,  'CANCELADA',   'Donante no pudo entregar'),
                                                                                                                    (1,  11, 6, 'Mochila escolar',                 1,  'ASIGNADA',    'Con útiles incluidos'),
                                                                                                                    (2,  1,  1, 'Medicamentos vitamínicos',        2,  'EN_TRANSITO', 'En tránsito desde farmacia'),
                                                                                                                    (3,  5,  3, 'Aceite y legumbres',              3,  'PENDIENTE',   NULL),
                                                                                                                    (4,  9,  5, 'Avena y leche en polvo',          5,  'ENTREGADA',   'Para dieta del adulto mayor'),
                                                                                                                    (5,  3,  2, 'Mochila y colores',               1,  'ASIGNADA',    'Lista para inicio de clases');