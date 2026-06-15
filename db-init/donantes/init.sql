SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

-- La columna contrasena almacena un hash BCrypt. Todos los seeds usan la clave 'password'.
CREATE TABLE IF NOT EXISTS donante (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    correo     VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    nombre     VARCHAR(150) NOT NULL,
    rut        VARCHAR(10)  NOT NULL UNIQUE,
    dv         CHAR(1)      NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT IGNORE INTO donante (id, correo, contrasena, nombre, rut, dv) VALUES
(1,  'carlos.ramirez@gmail.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Carlos Ramírez',     '11111111', '1'),
(2,  'mj.fuentes@gmail.com',     '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'María José Fuentes', '12222222', '2'),
(3,  'andres.vega@outlook.com',  '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Andrés Vega',        '13333333', '3'),
(4,  'vale.morales@gmail.com',   '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Valentina Morales',   '14444444', '4'),
(5,  'ftorres@hotmail.com',      '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Felipe Torres',       '15555555', '5'),
(6,  'camila.esp@gmail.com',     '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Camila Espinoza',     '16666666', '6'),
(7,  'dherrera@gmail.com',       '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Diego Herrera',       '17777777', '7'),
(8,  'sofia.con@outlook.com',    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Sofía Contreras',    '18888888', '8'),
(9,  'rodrigo.piz@gmail.com',    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Rodrigo Pizarro',     '19999999', '9'),
(10, 'fmunoz@gmail.com',         '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'Francisca Muñoz',    '20000000', 'k');