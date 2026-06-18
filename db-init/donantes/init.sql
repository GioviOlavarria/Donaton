SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

DROP TABLE IF EXISTS donante;
CREATE TABLE donante (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(100) NOT NULL,
    apellido   VARCHAR(100) NOT NULL,
    email      VARCHAR(150) NOT NULL UNIQUE,
    telefono   VARCHAR(20),
    direccion  VARCHAR(255),
    activo     TINYINT(1)   NOT NULL DEFAULT 1,
    creado_en  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO donante (id, nombre, apellido, email, telefono, direccion, activo, creado_en) VALUES
(1,  'Carlos',    'Ramírez',    'carlos.ramirez@gmail.com', '+56911111111', 'Av. Providencia 100',    1, NOW()),
(2,  'María',     'Fuentes',    'mj.fuentes@gmail.com',     '+56922222222', 'Calle Las Rosas 200',    1, NOW()),
(3,  'Andrés',    'Vega',       'andres.vega@outlook.com',  '+56933333333', 'Pasaje El Sol 300',      1, NOW()),
(4,  'Valentina', 'Morales',    'vale.morales@gmail.com',   '+56944444444', 'Av. Recoleta 400',       1, NOW()),
(5,  'Felipe',    'Torres',     'ftorres@hotmail.com',      '+56955555555', 'Calle Los Pinos 500',    1, NOW()),
(6,  'Camila',    'Espinoza',   'camila.esp@gmail.com',     '+56966666666', 'Av. Italia 600',         1, NOW()),
(7,  'Diego',     'Herrera',    'dherrera@gmail.com',       '+56977777777', 'Calle Los Aromos 700',   1, NOW()),
(8,  'Sofía',     'Contreras',  'sofia.con@outlook.com',    '+56988888888', 'Pasaje Las Hortensias 8',1, NOW()),
(9,  'Rodrigo',   'Pizarro',    'rodrigo.piz@gmail.com',    '+56999999999', 'Av. Libertador 900',     1, NOW()),
(10, 'Francisca', 'Muñoz',      'fmunoz@gmail.com',         '+56900000000', 'Calle Las Américas 10',  1, NOW());
