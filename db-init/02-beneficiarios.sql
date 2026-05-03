USE db_beneficiarios;
CREATE TABLE IF NOT EXISTS beneficiario (
                                            id               BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            nombre           VARCHAR(100) NOT NULL,
    apellido         VARCHAR(100) NOT NULL,
    rut              VARCHAR(20)  NOT NULL UNIQUE,
    telefono         VARCHAR(20),
    necesidad        TEXT,
    centro_acopio_id BIGINT       NOT NULL,
    activo           BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en        DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO beneficiario (nombre, apellido, rut, telefono, necesidad, centro_acopio_id, activo) VALUES
                                                                                                    ('Luis',      'Soto',      '12345678-9', '+56922220001', 'Ropa de invierno talla M y alimentos no perecibles', 1, true),
                                                                                                    ('Ana',       'Pérez',     '23456789-0', '+56922220002', 'Medicamentos básicos y pañales talla M',             1, true),
                                                                                                    ('Manuel',    'Castro',    '34567890-1', '+56922220003', 'Útiles escolares para 3 niños en edad escolar',      2, true),
                                                                                                    ('Rosa',      'Díaz',      '45678901-2', '+56922220004', 'Colchón y ropa de cama para familia de 4 personas',  2, true),
                                                                                                    ('Jorge',     'Álvarez',   '56789012-3', '+56922220005', 'Alimentos no perecibles y artículos de aseo',        3, true),
                                                                                                    ('Patricia',  'Reyes',     '67890123-4', '+56922220006', 'Silla de ruedas y ayudas técnicas para movilidad',   3, true),
                                                                                                    ('Héctor',    'Vargas',    '78901234-5', '+56922220007', 'Ropa para bebé recién nacido y leche en polvo',      4, true),
                                                                                                    ('Carmen',    'Jiménez',   '89012345-6', '+56922220008', 'Útiles de aseo y productos de higiene personal',     4, true),
                                                                                                    ('Roberto',   'Medina',    '90123456-7', '+56922220009', 'Alimentos para adulto mayor con diabetes',           5, true),
                                                                                                    ('Isabel',    'Rojas',     '01234567-8', '+56922220010', 'Ropa de invierno y frazadas para dos personas',      5, true),
                                                                                                    ('Pablo',     'Núñez',     '11234567-9', '+56922220011', 'Material escolar y mochila para niña de 8 años',     6, true),
                                                                                                    ('Marcela',   'Flores',    '22345678-0', '+56922220012', 'Artículos de aseo y alimentos básicos',              6, false);