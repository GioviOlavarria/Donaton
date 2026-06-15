SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS centro_acopio (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    comuna_id        BIGINT       NOT NULL,
    nombre           VARCHAR(150) NOT NULL,
    direccion        VARCHAR(300) NOT NULL,
    capacidad        INT          NOT NULL,
    capacidad_actual INT          NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO centro_acopio (id, comuna_id, nombre, direccion, capacidad, capacidad_actual) VALUES
(1, 1,  'Centro Esperanza',         'Av. Libertador 1234',      1000, 250),
(2, 24, 'Acopio Las Américas',      'Calle Las Rosas 456',      800,  120),
(3, 12, 'Hogar Solidario Sur',      'Pasaje El Sol 789',        600,  300),
(4, 27, 'Centro Comunitario Norte', 'Av. Recoleta 321',         750,  90),
(5, 19, 'Fundación Manos Unidas',   'Calle Los Pinos 654',      1200, 500),
(6, 23, 'Acopio Providencia',       'Av. Italia 987',           500,  60),
(7, 22, 'Centro Familiar Oriente',  'Calle Los Aromos 111',     650,  150),
(8, 3,  'Red de Apoyo Poniente',    'Pasaje Las Hortensias 22', 400,  0);