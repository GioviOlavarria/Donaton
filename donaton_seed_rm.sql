-- ============================================================
-- DONATON - Datos de Población
-- Región Metropolitana de Santiago
-- ============================================================

-- ============================================================
-- COMUNAS DE LA REGIÓN METROPOLITANA
-- (52 comunas oficiales)
-- ============================================================
INSERT INTO COMUNA (NOMBRE) VALUES
('Santiago'),
('Cerrillos'),
('Cerro Navia'),
('Conchalí'),
('El Bosque'),
('Estación Central'),
('Huechuraba'),
('Independencia'),
('La Cisterna'),
('La Florida'),
('La Granja'),
('La Pintana'),
('La Reina'),
('Las Condes'),
('Lo Barnechea'),
('Lo Espejo'),
('Lo Prado'),
('Macul'),
('Maipú'),
('Ñuñoa'),
('Pedro Aguirre Cerda'),
('Peñalolén'),
('Providencia'),
('Pudahuel'),
('Quilicura'),
('Quinta Normal'),
('Recoleta'),
('Renca'),
('San Joaquín'),
('San Miguel'),
('San Ramón'),
('Vitacura'),
('Puente Alto'),
('San Bernardo'),
('Buin'),
('Calera de Tango'),
('Paine'),
('Pirque'),
('San José de Maipo'),
('Colina'),
('Lampa'),
('Tiltil'),
('Melipilla'),
('Alhué'),
('Curacaví'),
('María Pinto'),
('San Pedro'),
('Talagante'),
('El Monte'),
('Isla de Maipo'),
('Padre Hurtado'),
('Peñaflor');

-- ============================================================
-- TIPOS DE DONACIÓN
-- ============================================================
INSERT INTO TIPO_DONACION (CLASIFICACION, DESCRIPCION) VALUES
('Alimentos no perecibles', 'Conservas, legumbres, cereales, azúcar, aceite y otros alimentos con larga vida útil'),
('Ropa y abrigo',           'Prendas de vestir en buen estado, frazadas, sacos de dormir y calzado'),
('Medicamentos',            'Medicamentos con fecha de vencimiento vigente, sin receta o de venta libre'),
('Útiles escolares',        'Cuadernos, lápices, mochilas, estuches y materiales educativos en general'),
('Muebles y enseres',       'Muebles en buen estado, electrodomésticos básicos y artículos del hogar'),
('Dinero',                  'Aportes monetarios para financiar operaciones, transporte y compras urgentes'),
('Artículos de higiene',    'Jabón, shampoo, papel higiénico, pasta dental, pañales y productos de aseo personal'),
('Juguetes',                'Juguetes en buen estado para niños y niñas de distintas edades');

-- ============================================================
-- TIPOS DE BENEFICIANTE
-- ============================================================
INSERT INTO TIPO_BENEFICIANTE (CATEGORIA) VALUES
('Familia damnificada por incendio'),
('Adulto mayor en situación de calle'),
('Persona en situación de vulnerabilidad económica'),
('Víctima de catástrofe natural'),
('Niño/a en sistema de protección'),
('Migrante en situación irregular'),
('Persona con discapacidad sin red de apoyo'),
('Familia afectada por violencia intrafamiliar');

-- ============================================================
-- CENTROS DE ACOPIO (10 centros en distintas comunas de la RM)
-- ============================================================
INSERT INTO CENTRO_ACOPIO (COMUNA_ID, NOMBRE, DIRECCION, CAPACIDAD, CAPACIDAD_ACTUAL) VALUES
-- La Pintana (12)
(12, 'Centro Comunitario La Pintana',       'Av. Gabriela Oriente 6250, La Pintana',          800,  340),
-- Maipú (19)
(19, 'Bodega Solidaria Maipú',              'Av. Pajaritos 3300, Maipú',                       1200, 510),
-- Pudahuel (24)
(24, 'Centro de Acopio Pudahuel Norte',     'Los Libertadores 890, Pudahuel',                  600,  200),
-- San Bernardo (34)
(34, 'Almacén Comunitario San Bernardo',    'Av. Portales 2145, San Bernardo',                 950,  420),
-- Puente Alto (33)
(33, 'Galpón Donaton Puente Alto',          'Av. Concha y Toro 1780, Puente Alto',             1500, 680),
-- Cerro Navia (3)
(3,  'Centro Social Cerro Navia',           'Av. Lo Boza 321, Cerro Navia',                    500,  150),
-- El Bosque (5)
(5,  'Punto de Acopio El Bosque',           'Av. Observatorio 1560, El Bosque',                700,  290),
-- Recoleta (27)
(27, 'Centro Solidario Recoleta',           'Av. Recoleta 2340, Recoleta',                     400,  180),
-- Peñalolén (22)
(22, 'Bodega Vecinal Peñalolén',            'Av. Tobalaba 12000, Peñalolén',                   650,  310),
-- Lampa (41)
(41, 'Punto de Acopio Lampa',              'Los Araucanos 450, Lampa',                         300,   90);

-- ============================================================
-- DONANTES (20 donantes)
-- Contraseñas hasheadas con bcrypt (valor ficticio uniforme)
-- ============================================================
INSERT INTO DONANTE (CORREO, CONTRASENA, NOMBRE, RUT, DV) VALUES
('carlos.mora@gmail.com',        '$2b$12$KIXsamplehashvalue001', 'Carlos Andrés Mora Valdivia',      '12345678', '9'),
('ana.gutierrez@hotmail.com',    '$2b$12$KIXsamplehashvalue002', 'Ana María Gutiérrez Ríos',         '11234567', 'K'),
('pedro.silva@yahoo.com',        '$2b$12$KIXsamplehashvalue003', 'Pedro José Silva Castillo',        '10987654', '3'),
('lorena.vega@gmail.com',        '$2b$12$KIXsamplehashvalue004', 'Lorena Paz Vega Herrera',          '13456789', '2'),
('marco.reyes@outlook.com',      '$2b$12$KIXsamplehashvalue005', 'Marco Antonio Reyes Fuentes',      '14567890', '1'),
('claudia.nunez@gmail.com',      '$2b$12$KIXsamplehashvalue006', 'Claudia Fernanda Núñez Lagos',     '15678901', '5'),
('rodrigo.paredes@gmail.com',    '$2b$12$KIXsamplehashvalue007', 'Rodrigo Ignacio Paredes Leiva',    '16789012', '7'),
('patricia.rojas@gmail.com',     '$2b$12$KIXsamplehashvalue008', 'Patricia Isabel Rojas Medina',     '17890123', '6'),
('felipe.castro@icloud.com',     '$2b$12$KIXsamplehashvalue009', 'Felipe Esteban Castro Araya',      '18901234', '4'),
('javiera.morales@gmail.com',    '$2b$12$KIXsamplehashvalue010', 'Javiera Alejandra Morales Pinto',  '19012345', '8'),
('jose.henriquez@gmail.com',     '$2b$12$KIXsamplehashvalue011', 'José Miguel Henríquez Soto',       '12098765', '1'),
('alejandra.lara@hotmail.com',   '$2b$12$KIXsamplehashvalue012', 'Alejandra Beatriz Lara Contreras', '11109876', '3'),
('pablo.espinoza@gmail.com',     '$2b$12$KIXsamplehashvalue013', 'Pablo Sebastián Espinoza Tapia',   '10876543', 'K'),
('daniela.cerda@outlook.com',    '$2b$12$KIXsamplehashvalue014', 'Daniela Constanza Cerda Rojas',    '13876543', '5'),
('gonzalo.palma@gmail.com',      '$2b$12$KIXsamplehashvalue015', 'Gonzalo Eduardo Palma Vera',       '14765432', '2'),
('carolina.bravo@gmail.com',     '$2b$12$KIXsamplehashvalue016', 'Carolina Andrea Bravo Muñoz',      '15654321', '9'),
('ignacio.vargas@gmail.com',     '$2b$12$KIXsamplehashvalue017', 'Ignacio Hernán Vargas Molina',     '16543210', '4'),
('valentina.rios@icloud.com',    '$2b$12$KIXsamplehashvalue018', 'Valentina Sofía Ríos Pizarro',     '17432109', '6'),
('sebastian.mena@gmail.com',     '$2b$12$KIXsamplehashvalue019', 'Sebastián Álvaro Mena Ibáñez',     '18321098', '7'),
('francisca.campos@gmail.com',   '$2b$12$KIXsamplehashvalue020', 'Francisca Ignacia Campos Díaz',    '19210987', 'K');

-- ============================================================
-- BENEFICIANTES (15 beneficiantes)
-- ============================================================
INSERT INTO BENEFICIANTE (TIPO_BENEFICIANTE_ID, CENTRO_ACOPIO_ID, RUT, DV, NOMBRE, RAZON, TIPO_SINIESTRO, FECHA_SINIESTRO) VALUES
(1, 1, '20100001', '1', 'Rosa Elena Mamani Quispe',   'Pérdida total de vivienda tras incendio en pasaje Las Dalias', 'Incendio', '2026-03-12'),
(1, 5, '20100002', '2', 'Luis Alberto Flores Riquelme','Familia de 4 integrantes sin hogar por incendio en villa El Roble', 'Incendio', '2026-04-02'),
(2, 8, '20100003', '3', 'Ernesto del Carmen Jara',    'Adulto mayor de 72 años sin domicilio fijo, requiere abrigo y alimentos', NULL, NULL),
(3, 2, '20100004', '4', 'Familia Contreras Sepúlveda','Familia con 3 hijos menores, padre cesante hace 8 meses', NULL, NULL),
(3, 6, '20100005', '5', 'María de los Ángeles Torres','Madre soltera con 2 hijos, reside en campamento Pudahuel Sur', NULL, NULL),
(4, 4, '20100006', '6', 'Jorge Enrique Bustos Navarro','Damnificado por aluvión en quebrada de Macul 2024', 'Aluvión', '2024-08-15'),
(5, 1, '20100007', '7', 'Niño/a Anonimizado – Exp. 2024-883','Menor bajo tutela SENAME, requiere útiles y ropa', NULL, NULL),
(6, 3, '20100008', '8', 'Yolanda Bautista Mamani',   'Migrante venezolana con 2 hijos, sin permiso de residencia vigente', NULL, NULL),
(6, 9, '20100009', '9', 'Jean Pierre Kouassi',        'Migrante haitiano, llegó hace 6 meses, sin trabajo formal', NULL, NULL),
(7, 7, '20100010', 'K', 'Amanda Rosa Fuentes Leiva',  'Adulta mayor con movilidad reducida, sin red familiar de apoyo', NULL, NULL),
(8, 2, '20100011', '1', 'Camila Andrea Soto Vidal',   'Mujer víctima de VIF, refugiada con sus 2 hijos en casa de acogida', NULL, NULL),
(1, 10,'20100012', '2', 'Rubén Darío Moreno Castillo','Propietario de local siniestrado en incendio en Lampa centro', 'Incendio', '2026-01-20'),
(3, 5, '20100013', '3', 'Familia Araya Bustamante',   'Familia de 5 con ingresos inferiores a la línea de pobreza', NULL, NULL),
(4, 4, '20100014', '4', 'Carmen Gloria Rojas Peña',   'Afectada por sismo de 6,2 grados que dañó su vivienda', 'Sismo', '2025-11-03'),
(5, 6, '20100015', '5', 'Niño/a Anonimizado – Exp. 2025-112','Menor en programa de acogida familiar, requiere artículos básicos', NULL, NULL);

-- ============================================================
-- DONACIONES (30 donaciones)
-- ============================================================
INSERT INTO DONACION (DONANTE_ID, TIPO_DONACION_ID, NOMBRE, CANTIDAD, FECHA, DESCRIPCION, ESTADO) VALUES
(1,  1, 'Cajas de conservas surtidas',       24,   '2026-04-10', 'Atún, tomates, choclo y frejoles en conserva',              'DISTRIBUIDA'),
(2,  2, 'Frazadas de polar doble',            10,   '2026-04-11', 'Frazadas 1,5 plaza en buen estado',                         'DISTRIBUIDA'),
(3,  7, 'Kit de higiene personal',            30,   '2026-04-12', 'Jabón, shampoo, pasta dental y cepillo',                    'RECIBIDA'),
(4,  1, 'Arroz grano largo 5kg',              50,   '2026-04-14', '50 bolsas de 5kg de arroz grano largo',                     'EN_TRANSITO'),
(5,  6, 'Aporte monetario campaña invierno',  150000,'2026-04-15','Transferencia para compra de frazadas y alimentos',          'RECIBIDA'),
(6,  3, 'Medicamentos básicos',               80,   '2026-04-16', 'Paracetamol, ibuprofeno, antiácidos y vendas',               'RECIBIDA'),
(7,  4, 'Cuadernos y lápices',                100,  '2026-04-18', '100 cuadernos 100 hojas + sets de lápices de colores',       'DISTRIBUIDA'),
(8,  2, 'Ropa de invierno adulto',            45,   '2026-04-19', 'Parkas, chaquetas y pantalones talla M-L-XL',                'RECIBIDA'),
(9,  1, 'Aceite y legumbres',                 36,   '2026-04-20', '12 botellas aceite + 24 bolsas de legumbres variadas',       'DISTRIBUIDA'),
(10, 5, 'Colchones individuales',             5,    '2026-04-21', 'Colchones 1 plaza en buen estado, sin manchas',              'RECIBIDA'),
(11, 7, 'Pañales talla M y G',               200,  '2026-04-22', 'Pañales desechables para menores de 2 años',                 'DISTRIBUIDA'),
(12, 8, 'Juguetes para niños',               35,   '2026-04-23', 'Muñecas, autos, rompecabezas y juegos de mesa',              'RECIBIDA'),
(13, 1, 'Fideos y arroz',                    60,   '2026-04-24', '30 kg de fideos + 30 kg de arroz',                           'PENDIENTE'),
(14, 2, 'Calcetines y ropa interior',         80,   '2026-04-25', 'Calcetines térmicos y ropa interior tallas surtidas',        'PENDIENTE'),
(15, 6, 'Aporte campaña útiles escolares',   75000,'2026-04-26', 'Para compra de mochilas y útiles para menores en SENAME',    'RECIBIDA'),
(16, 3, 'Vitaminas y suplementos',            40,   '2026-04-27', 'Vitamina C, D y multivitamínico para adultos mayores',       'RECIBIDA'),
(17, 4, 'Mochilas escolares',                 20,   '2026-04-28', 'Mochilas de distintos tamaños para escolares',               'DISTRIBUIDA'),
(18, 1, 'Azúcar y harina',                   40,   '2026-04-29', '20 kg de azúcar + 20 kg de harina sin polvos',               'RECIBIDA'),
(19, 7, 'Artículos de limpieza del hogar',   50,   '2026-04-30', 'Detergente, cloro, esponjas y desengrasante',                'PENDIENTE'),
(20, 5, 'Silla de ruedas usada',              1,    '2026-05-01', 'Silla de ruedas con frenos en buen estado',                  'RECIBIDA'),
(1,  2, 'Ropa de niños tallas 4-10',          30,   '2026-05-03', 'Pijamas, poleras y pantalones para niños en buen estado',    'EN_TRANSITO'),
(2,  1, 'Leche en polvo y cereales',          25,   '2026-05-05', '25 kg entre leche en polvo y cereales variados',             'RECIBIDA'),
(3,  6, 'Aporte para transporte de donaciones',50000,'2026-05-06','Financiamiento de fletes entre centros',                     'RECIBIDA'),
(4,  7, 'Kit dental comunitario',             60,   '2026-05-08', 'Cepillos, pasta y enjuague bucal para adultos y niños',      'RECIBIDA'),
(5,  8, 'Juguetes de madera didácticos',      15,   '2026-05-09', 'Bloques, puzzles y juguetes de estimulación temprana',       'PENDIENTE'),
(6,  1, 'Conservas de frutas y verduras',     48,   '2026-05-10', 'Duraznos, peras, porotos verdes y tomates en conserva',      'PENDIENTE'),
(7,  3, 'Cremas y protectores solares',       35,   '2026-05-12', 'Para adultos mayores con piel sensible expuestos al frío',   'RECIBIDA'),
(8,  4, 'Diccionarios y libros de texto',     20,   '2026-05-13', 'Diccionarios, atlas y libros de ciencias para escolares',    'RECIBIDA'),
(9,  2, 'Sacos de dormir',                    8,    '2026-05-14', 'Sacos de dormir para temperaturas bajo cero',                'DISTRIBUIDA'),
(10, 6, 'Aporte campaña invierno 2026',      200000,'2026-05-15','Donación destinada a compra de alimentos no perecibles',     'RECIBIDA');

-- ============================================================
-- DONACION_ACOPIO (asignación de donaciones a centros)
-- ============================================================
INSERT INTO DONACION_ACOPIO (DONACION_ID, CENTRO_ACOPIO_ID, FECHA_RECEPCION, ESTADO) VALUES
(1,  5, '2026-04-10', 'DISTRIBUIDA'),
(2,  1, '2026-04-11', 'DISTRIBUIDA'),
(3,  3, '2026-04-12', 'PROCESADA'),
(4,  2, '2026-04-15', 'RECIBIDA'),
(5,  4, '2026-04-15', 'PROCESADA'),
(6,  8, '2026-04-16', 'PROCESADA'),
(7,  1, '2026-04-18', 'DISTRIBUIDA'),
(8,  6, '2026-04-19', 'PROCESADA'),
(9,  4, '2026-04-20', 'DISTRIBUIDA'),
(10, 9, '2026-04-21', 'PROCESADA'),
(11, 1, '2026-04-22', 'DISTRIBUIDA'),
(12, 7, '2026-04-23', 'RECIBIDA'),
(15, 1, '2026-04-26', 'PROCESADA'),
(16, 8, '2026-04-27', 'RECIBIDA'),
(17, 5, '2026-04-28', 'DISTRIBUIDA'),
(18, 2, '2026-04-29', 'RECIBIDA'),
(20, 9, '2026-05-01', 'RECIBIDA'),
(22, 3, '2026-05-05', 'RECIBIDA'),
(24, 7, '2026-05-08', 'RECIBIDA'),
(27, 8, '2026-05-12', 'RECIBIDA'),
(28, 1, '2026-05-13', 'RECIBIDA'),
(29, 6, '2026-05-14', 'DISTRIBUIDA'),
(30, 2, '2026-05-15', 'RECIBIDA');

-- ============================================================
-- NECESIDADES (15 necesidades activas y cubiertas)
-- ============================================================
INSERT INTO NECESIDAD (CENTRO_ACOPIO_ID, TIPO_DONACION_ID, BENEFICIANTE_ID, CANTIDAD_REQUERIDA, CANTIDAD_ACTUAL, ESTADO, FECHA_CREACION) VALUES
(1,  1, 1,  50,  24,  'ACTIVA',    '2026-03-15'),
(1,  2, 7,  20,  10,  'ACTIVA',    '2026-03-15'),
(2,  1, 4,  80,  50,  'ACTIVA',    '2026-03-20'),
(2,  8, 11, 10,  10,  'CUBIERTA',  '2026-04-01'),
(3,  7, 8,  60,  30,  'ACTIVA',    '2026-04-05'),
(4,  6, 6,  100000, 75000, 'ACTIVA','2026-04-10'),
(4,  1, 14, 40,  36,  'ACTIVA',    '2026-04-10'),
(5,  1, 2,  100, 100, 'CUBIERTA',  '2026-04-03'),
(5,  4, 13, 50,  17,  'ACTIVA',    '2026-04-15'),
(6,  2, 5,  30,  0,   'ACTIVA',    '2026-04-20'),
(6,  7, 15, 40,  0,   'ACTIVA',    '2026-04-20'),
(7,  3, 10, 30,  35,  'CUBIERTA',  '2026-03-28'),
(8,  2, 3,  15,  8,   'ACTIVA',    '2026-04-12'),
(9,  5, NULL,8,  1,   'ACTIVA',    '2026-04-22'),
(10, 1, 12, 30,  0,   'ACTIVA',    '2026-01-25');
