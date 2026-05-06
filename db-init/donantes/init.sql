SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS donante (
                                       id        BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nombre    VARCHAR(100) NOT NULL,
    apellido  VARCHAR(100) NOT NULL,
    email     VARCHAR(150) NOT NULL UNIQUE,
    telefono  VARCHAR(20),
    direccion VARCHAR(255),
    centro_acopio_id BIGINT NOT NULL,
    activo    BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO donante (nombre, apellido, email, telefono, direccion, centro_acopio_id, activo) VALUES
('Carlos',    'Ramírez',   'carlos.ramirez@gmail.com',  '+56911110001', 'Av. Apoquindo 100, Las Condes',       1, true),
('María José','Fuentes',   'mj.fuentes@gmail.com',      '+56911110002', 'Calle Los Boldos 22, Ñuñoa',          1, true),
('Andrés',    'Vega',      'andres.vega@outlook.com',   '+56911110003', 'Pasaje El Roble 5, Maipú',            2, true),
('Valentina', 'Morales',   'vale.morales@gmail.com',    '+56911110004', 'Av. Grecia 450, Macul',               2, true),
('Felipe',    'Torres',    'ftorres@hotmail.com',       '+56911110005', 'Calle Zenteno 88, Santiago Centro',   3, true),
('Camila',    'Espinoza',  'camila.esp@gmail.com',      '+56911110006', 'Av. Vicuña Mackenna 200, La Florida', 3, true),
('Diego',     'Herrera',   'dherrera@gmail.com',        '+56911110007', 'Pasaje Los Cipreses 3, Pudahuel',     4, true),
('Sofía',     'Contreras', 'sofia.con@outlook.com',     '+56911110008', 'Calle Los Álamos 77, Peñalolén',      4, true),
('Rodrigo',   'Pizarro',   'rodrigo.piz@gmail.com',     '+56911110009', 'Av. Departamental 340, San Miguel',   5, true),
('Francisca', 'Muñoz',     'fmunoz@gmail.com',          '+56911110010', 'Calle Huérfanos 123, Santiago',       5, false);