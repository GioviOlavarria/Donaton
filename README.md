# Donaton
Proyecto Donaton para Fullstack 3.


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

