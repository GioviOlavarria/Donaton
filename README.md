# Donaton
Proyecto Donaton para Fullstack 3.


# Ejecutar el proyecto

docker compose up --build -d



# Inserción de datos
docker exec -i donaton-db-centros mysql \
-u centros_user -pcentros_pass db_centros \
< ./db-init/03-centros-acopio.sql

docker exec -i donaton-db-donantes mysql \
-u donantes_user -pdonantes_pass db_donantes \
< ./db-init/01-donantes.sql

docker exec -i donaton-db-beneficiarios mysql \
-u beneficiarios_user -pbeneficiarios_pass db_beneficiarios \
< ./db-init/02-beneficiarios.sql


docker exec -i donaton-db-donaciones mysql \
-u donaciones_user -pdonaciones_pass db_donaciones \
< ./db-init/04-donaciones.sql