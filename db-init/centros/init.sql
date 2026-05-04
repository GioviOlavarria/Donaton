SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS centro_acopio (
                                             id        BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             nombre    VARCHAR(150) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    comuna    VARCHAR(100),
    telefono  VARCHAR(20),
    email     VARCHAR(150),
    activo    BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO centro_acopio (nombre, direccion, comuna, telefono, email, activo) VALUES
('Centro Esperanza',         'Av. Libertador 1234',      'Santiago Centro', '+56912345001', 'esperanza@donaton.cl',    true),
('Acopio Las Américas',      'Calle Las Rosas 456',      'Pudahuel',        '+56912345002', 'americas@donaton.cl',     true),
('Hogar Solidario Sur',      'Pasaje El Sol 789',        'La Pintana',      '+56912345003', 'solidariosur@donaton.cl', true),
('Centro Comunitario Norte', 'Av. Recoleta 321',         'Recoleta',        '+56912345004', 'ccnorte@donaton.cl',      true),
('Fundación Manos Unidas',   'Calle Los Pinos 654',      'Maipú',           '+56912345005', 'manosunidas@donaton.cl',  true),
('Acopio Providencia',       'Av. Italia 987',           'Providencia',     '+56912345006', 'providencia@donaton.cl',  true),
('Centro Familiar Oriente',  'Calle Los Aromos 111',     'Peñalolén',       '+56912345007', 'familiar@donaton.cl',     true),
('Red de Apoyo Poniente',    'Pasaje Las Hortensias 22', 'Cerro Navia',     '+56912345008', 'apoyo@donaton.cl',        false);