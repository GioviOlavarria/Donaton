SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS donante (
                                       id        BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nombre    VARCHAR(100) NOT NULL,
    apellido  VARCHAR(100) NOT NULL,
    email     VARCHAR(150) NOT NULL UNIQUE,
    telefono  VARCHAR(20),
    direccion VARCHAR(255),
    activo    BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO donante (nombre, apellido, email, telefono, direccion, activo) VALUES
('Carlos',    'Ramírez',   'carlos.ramirez@gmail.com',  '+56911110001', 'Av. Apoquindo 100, Las Condes',       true),
('María José','Fuentes',   'mj.fuentes@gmail.com',      '+56911110002', 'Calle Los Boldos 22, Ñuñoa',          true),
('Andrés',    'Vega',      'andres.vega@outlook.com',   '+56911110003', 'Pasaje El Roble 5, Maipú',            true),
('Valentina', 'Morales',   'vale.morales@gmail.com',    '+56911110004', 'Av. Grecia 450, Macul',               true),
('Felipe',    'Torres',    'ftorres@hotmail.com',       '+56911110005', 'Calle Zenteno 88, Santiago Centro',   true),
('Camila',    'Espinoza',  'camila.esp@gmail.com',      '+56911110006', 'Av. Vicuña Mackenna 200, La Florida', true),
('Diego',     'Herrera',   'dherrera@gmail.com',        '+56911110007', 'Pasaje Los Cipreses 3, Pudahuel',     true),
('Sofía',     'Contreras', 'sofia.con@outlook.com',     '+56911110008', 'Calle Los Álamos 77, Peñalolén',      true),
('Rodrigo',   'Pizarro',   'rodrigo.piz@gmail.com',     '+56911110009', 'Av. Departamental 340, San Miguel',   true),
('Francisca', 'Muñoz',     'fmunoz@gmail.com',          '+56911110010', 'Calle Huérfanos 123, Santiago',       false);