# Donaton
Proyecto Donaton para Fullstack 3.

# Requisitos Previos

    Docker 20.10+
    Docker Compose 2.0+
    Git
    (Opcional) Java 17+ para desarrollo local
    (Opcional) Maven 4.0.6 para build local

# Instalacion en Linux

    Clonar el repositorio:

git clone <url-repositorio>
cd Donaton

# Instalacion en Windows

    Clonar el repositorio:

git clone <url-repositorio>
cd Donaton



# Ejecutar el proyecto

docker compose up --build -d

# Dar de baja 

docker compose down -v 

# Puertos y enlaces a las vistas.


http://localhost:3000/ -> Landing page


http://localhost:3000/panel.html -> Panel Administrador


# Ejecutar pruebas Unitarias


docker compose -f docker-compose.test.yml run --rm test-runner 

# Dar de baja las pruebas unitarias


docker compose -f docker-compose.test.yml down -v  

# Acceder a Aplicaciones

Una vez iniciados todos los servicios:

    Frontend Público: http://localhost
    Panel Administrativo: http://localhost/panel.html
    API ms-donantes: http://localhost:8081
    API ms-beneficiarios: http://localhost:8082
    API ms-centros-acopio: http://localhost:8083
    API ms-donaciones: http://localhost:8084
    API ms-comunas: http://localhost:8085
    API ms-tipos: http://localhost:8086
    API ms-auth: http://localhost:8087
    API ms-admin: http://localhost:8088


