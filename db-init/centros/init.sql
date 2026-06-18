SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

DROP TABLE IF EXISTS centro_acopio;
CREATE TABLE centro_acopio (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(100) NOT NULL,
    direccion  VARCHAR(100) NOT NULL,
    comuna     VARCHAR(100),
    telefono   VARCHAR(12)  NOT NULL,
    email      VARCHAR(150),
    activo     TINYINT(1)   NOT NULL DEFAULT 1,
    creado_en  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO centro_acopio (id, nombre, direccion, comuna, telefono, email, activo, creado_en) VALUES
(1, 'Centro Esperanza',          'Av. Libertador 1234',      'Santiago Centro', '+56912345678', 'esperanza@donaton.cl',   1, NOW()),
(2, 'Acopio Las Américas',       'Calle Las Rosas 456',      'Pudahuel',        '+56923456789', 'americas@donaton.cl',    1, NOW()),
(3, 'Hogar Solidario Sur',       'Pasaje El Sol 789',        'La Pintana',      '+56934567890', 'solidsur@donaton.cl',    1, NOW()),
(4, 'Centro Comunitario Norte',  'Av. Recoleta 321',         'Recoleta',        '+56945678901', 'ccnorte@donaton.cl',     1, NOW()),
(5, 'Fundación Manos Unidas',    'Calle Los Pinos 654',      'Maipú',           '+56956789012', 'manos@donaton.cl',       1, NOW()),
(6, 'Acopio Providencia',        'Av. Italia 987',           'Providencia',     '+56967890123', 'providencia@donaton.cl', 1, NOW()),
(7, 'Centro Familiar Oriente',   'Calle Los Aromos 111',     'Peñalolén',       '+56978901234', 'familiar@donaton.cl',    1, NOW()),
(8, 'Red de Apoyo Poniente',     'Pasaje Las Hortensias 22', 'Cerro Navia',     '+56989012345', 'apoyo@donaton.cl',       1, NOW());
