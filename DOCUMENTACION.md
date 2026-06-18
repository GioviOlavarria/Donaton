# DOCUMENTACION - PROYECTO DONATON

## Tabla de Contenidos

1. [Descripcion General](#descripcion-general)
2. [Arquitectura del Sistema](#arquitectura-del-sistema)
3. [Microservicios](#microservicios)
4. [Base de Datos](#base-de-datos)
5. [Tecnologias](#tecnologias)
6. [Instalacion y Configuracion](#instalacion-y-configuracion)
7. [Ejecucion del Proyecto](#ejecucion-del-proyecto)
8. [Estructura de Directorios](#estructura-de-directorios)
9. [Guia de Desarrollo](#guia-de-desarrollo)

---

## Descripcion General

DONATON es una plataforma de gestión integral de donaciones diseñada para la región metropolitana de Santiago, Chile. El sistema facilita la coordinación entre donantes y beneficiarios a través de centros de acopio, permitiendo un registro y rastreo eficiente de donaciones en diferentes estados.

### Objetivos Principales

- Conectar donantes con beneficiarios que necesitan ayuda
- Centralizar la gestión de donaciones por tipo y categoría
- Registrar y rastrear donaciones en diferentes estados de entrega
- Organizar beneficiarios según sus necesidades específicas
- Gestionar centros de acopio como puntos de distribución en las comunas

### Usuarios Objetivo

- Donantes: personas que desean hacer donaciones
- Beneficiarios: personas que requieren asistencia
- Administradores de centros de acopio
- Administradores del sistema

---

## Arquitectura del Sistema

DONATON implementa una arquitectura de microservicios con base de datos independiente por servicio (Database-per-Service Pattern). Esta arquitectura proporciona:

- **Escalabilidad**: cada servicio puede escalar independientemente
- **Resiliencia**: el fallo de un servicio no derriba los demás
- **Flexibilidad**: cada equipo puede trabajar en su servicio de forma independiente
- **Mantenibilidad**: código modular y fácil de mantener

### Diagrama de Arquitectura

```
[Frontend Web]                [Frontend Admin]
       |                              |
       +-----------+-------------------+
                   |
         [API Gateway / ms-admin]
                   |
       +-----------+-----------+-----------+-----------+
       |           |           |           |           |
   [ms-donantes] [ms-benefi] [ms-centros] [ms-donaciones]
       |           |           |           |
    [DB]        [DB]        [DB]        [DB]
       
       +-----------+-----------+-----------+-----------+
       |           |           |           |           |
   [ms-comunas] [ms-tipos] [ms-auth] [ms-necesidad]
       |           |           |           |
    [DB]        [DB]        [DB]        [DB]
```

---

## Microservicios

El proyecto consta de 10 microservicios independientes, cada uno responsable de un dominio específico del negocio.

### 1. ms-donantes (Puerto 8081)

**Responsabilidad**: Gestión completa del registro y perfiles de donantes.

**Funcionalidades**:
- Crear, leer, actualizar y eliminar perfiles de donantes
- Registrar información: nombre, apellido, email, teléfono, dirección
- Mantener estado activo/inactivo del donante
- Rastrear fecha de creación de cada donante

**Base de Datos**: db-donantes
**Tabla Principal**: donante

---

### 2. ms-beneficiarios (Puerto 8082)

**Responsabilidad**: Administración de beneficiarios y sus necesidades específicas.

**Funcionalidades**:
- Registrar y mantener perfiles de beneficiarios
- Asociar beneficiarios con sus necesidades
- Asignar beneficiarios a centros de acopio específicos
- Validar información mediante RUT
- Gestionar estado activo/inactivo

**Base de Datos**: db-beneficiarios
**Tabla Principal**: beneficiario

**Información de Beneficiario**:
- RUT (único)
- Nombre y apellido
- Teléfono
- Necesidad principal
- Centro de acopio asignado
- Fecha de registro

---

### 3. ms-centros-acopio (Puerto 8083)

**Responsabilidad**: Gestión de centros de distribución y recolección de donaciones.

**Funcionalidades**:
- Registrar y mantener información de centros
- Especificar ubicación, teléfono y email
- Asociar centros con comunas
- Gestionar capacidad y estado operativo

**Base de Datos**: db-centros
**Tabla Principal**: centro_acopio

**Información de Centro**:
- Nombre único
- Dirección
- Comuna
- Teléfono
- Email
- Estado activo/inactivo

---

### 4. ms-donaciones (Puerto 8084)

**Responsabilidad**: Rastreo y gestión del ciclo de vida de las donaciones.

**Funcionalidades**:
- Registrar nuevas donaciones
- Vincular donante, beneficiario y centro de acopio
- Rastrear estado de entrega de donaciones
- Registrar observaciones y cambios de estado
- Mantener historial de cada donación

**Base de Datos**: db-donaciones
**Tabla Principal**: donacion

**Estados de Donacion**:
- PENDIENTE: donación registrada pero no procesada
- EN_TRANSITO: en camino al centro de acopio o beneficiario
- ENTREGADA: entregada al beneficiario
- CANCELADA: donación cancelada

**Información de Donacion**:
- Referencias a donante, beneficiario y centro
- Artículo/descripción
- Cantidad
- Estado actual
- Observaciones
- Fecha de creación y actualización

---

### 5. ms-comunas (Puerto 8085)

**Responsabilidad**: Mantener catálogo de comunas de la región metropolitana.

**Funcionalidades**:
- Proporcionar lista de comunas válidas
- Servir como referencia para otros servicios
- Validación de ubicaciones

**Base de Datos**: db-comunas
**Tabla Principal**: comuna

**Cobertura**: 52 comunas de Santiago (Santiago, Maipú, Las Condes, La Pintana, Pudahuel, Renca, Quinta Normal, San Bernardo, etc.)

---

### 6. ms-tipos (Puerto 8086)

**Responsabilidad**: Mantener catálogos de clasificaciones y categorías.

**Funcionalidades**:
- Proporcionar tipos de donaciones disponibles
- Proporcionar categorías de beneficiarios
- Servir como referencia para validaciones

**Base de Datos**: db-tipos
**Tablas Principales**: tipo_donacion, tipo_beneficiante

**Tipos de Donacion**:
- Alimentos
- Ropa
- Medicamentos
- Útiles escolares
- Muebles
- Dinero
- Higiene
- Juguetes

**Categorias de Beneficiarios**:
- Familias damnificadas
- Adultos mayores
- Migrantes
- Personas con discapacidad
- Menores en situación de riesgo
- Enfermos terminales
- Personas en situación de calle
- Víctimas de violencia

---

### 7. ms-auth (Puerto 8087)

**Responsabilidad**: Servicio de autenticación y autorización (en desarrollo).

**Funcionalidades Planificadas**:
- Autenticación de usuarios
- Gestión de roles y permisos
- Control de acceso a funcionalidades

**Base de Datos**: db-auth

**Estado**: Implementación inicial, requiere desarrollo completo

---

### 8. ms-admin (Puerto 8088)

**Responsabilidad**: Orquestación y panel de administración.

**Funcionalidades**:
- Integración con todos los demás servicios
- Panel de control administrativo
- Reportes consolidados
- Gestión global del sistema

**Base de Datos**: No posee base de datos propia (servicios independientes)

**Nota**: Este servicio actúa como gateway API principal y coordina operaciones que involucran múltiples servicios.

---

### 9. ms-frontend (Puerto 80/3000)

**Responsabilidad**: Interfaz web pública para donantes y beneficiarios.

**Tecnologias**: HTML5, CSS, Nginx

**Funcionalidades**:
- Interfaz para donantes
- Interfaz para beneficiarios
- Búsqueda de centros de acopio
- Visualización de información pública

---

### 10. ms-necesidad (Puerto aplicación - datos en DB)

**Responsabilidad**: Gestión de necesidades específicas de beneficiarios.

**Funcionalidades**:
- Registrar necesidades de beneficiarios
- Rastrear cantidad requerida vs cantidad recibida
- Actualizar estado de satisfacción de necesidades

**Base de Datos**: db-necesidad
**Tabla Principal**: necesidad

**Información de Necesidad**:
- Referencia a beneficiario
- Descripción de necesidad
- Cantidad requerida
- Cantidad actual (recibida)
- Estado (no satisfecha, parcialmente satisfecha, satisfecha)

---

## Base de Datos

### Arquitectura de Datos

El proyecto utiliza MySQL 8.0 con una base de datos independiente por cada microservicio. Esta separación permite:

- Evolución independiente del esquema de cada servicio
- Escalabilidad horizontal de cada servicio
- Fallos aislados que no afecten toda la aplicación

### Esquemas de Bases de Datos

#### db-donantes

```sql
Tabla: donante
- id (INT, PK, AUTO_INCREMENT)
- nombre (VARCHAR(100), NOT NULL)
- apellido (VARCHAR(100), NOT NULL)
- email (VARCHAR(100), UNIQUE, NOT NULL)
- telefono (VARCHAR(20))
- direccion (VARCHAR(255))
- activo (BOOLEAN, DEFAULT 1)
- creado_en (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
```

#### db-beneficiarios

```sql
Tabla: beneficiario
- id (INT, PK, AUTO_INCREMENT)
- nombre (VARCHAR(100), NOT NULL)
- apellido (VARCHAR(100), NOT NULL)
- rut (VARCHAR(12), UNIQUE, NOT NULL)
- telefono (VARCHAR(20))
- necesidad (VARCHAR(255), NOT NULL)
- centro_acopio_id (INT, FK -> db-centros.centro_acopio)
- activo (BOOLEAN, DEFAULT 1)
- creado_en (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
```

#### db-centros

```sql
Tabla: centro_acopio
- id (INT, PK, AUTO_INCREMENT)
- nombre (VARCHAR(150), NOT NULL, UNIQUE)
- direccion (VARCHAR(255), NOT NULL)
- comuna (VARCHAR(100), NOT NULL)
- telefono (VARCHAR(20))
- email (VARCHAR(100))
- activo (BOOLEAN, DEFAULT 1)
- creado_en (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
```

#### db-donaciones

```sql
Tabla: donacion
- id (INT, PK, AUTO_INCREMENT)
- donante_id (INT, FK -> db-donantes.donante)
- beneficiario_id (INT, FK -> db-beneficiarios.beneficiario)
- centro_acopio_id (INT, FK -> db-centros.centro_acopio)
- articulo (VARCHAR(255), NOT NULL)
- cantidad (INT, NOT NULL)
- estado (ENUM('PENDIENTE', 'EN_TRANSITO', 'ENTREGADA', 'CANCELADA'))
- observaciones (TEXT)
- creado_en (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
- actualizado_en (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)
```

#### db-comunas

```sql
Tabla: comuna
- id (INT, PK, AUTO_INCREMENT)
- nombre (VARCHAR(100), NOT NULL, UNIQUE)
```

52 comunas de la región metropolitana: Santiago, Maipú, Las Condes, La Pintana, Pudahuel, Renca, Quinta Normal, San Bernardo, Melipilla, Talagante, Curicó, Linares, Talca, Chillan, Los Angeles, Lebu, Arauco, Concepción, Tomé, Penco, Lota, Coronel, etc.

#### db-tipos

```sql
Tabla: tipo_donacion
- id (INT, PK, AUTO_INCREMENT)
- nombre (VARCHAR(100), NOT NULL, UNIQUE)

Tabla: tipo_beneficiante
- id (INT, PK, AUTO_INCREMENT)
- nombre (VARCHAR(100), NOT NULL, UNIQUE)
```

#### db-auth

Estructura pendiente de definición según requisitos de seguridad.

#### db-necesidad

```sql
Tabla: necesidad
- id (INT, PK, AUTO_INCREMENT)
- beneficiario_id (INT, FK -> db-beneficiarios.beneficiario)
- tipo_necesidad (VARCHAR(100), NOT NULL)
- cantidad_requerida (INT, NOT NULL)
- cantidad_actual (INT, DEFAULT 0)
- estado (ENUM('NO_SATISFECHA', 'PARCIALMENTE_SATISFECHA', 'SATISFECHA'))
- creado_en (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
- actualizado_en (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)
```

### Inicializacion de Base de Datos

Cada base de datos se inicializa automáticamente desde scripts SQL ubicados en `db-init/<servicio>/init.sql`. Los scripts:

- Crean el esquema de la base de datos
- Definen todas las tablas necesarias
- Insertan datos iniciales de catálogos (comunas, tipos)
- Establecen relaciones y constraints

El archivo `docker-compose.yml` monta estos directorios como volúmenes de inicialización.

---

## Tecnologias

### Backend - Microservicios

**Framework**: Spring Boot 4.0.6
- spring-boot-starter-actuator: monitoreo y health checks
- spring-boot-starter-data-jpa: acceso a datos
- spring-boot-starter-web: APIs REST
- spring-boot-starter-validation: validación de datos
- spring-boot-starter-thymeleaf: vistas server-side

**Lenguaje**: Java 17 (LTS)

**ORM**: Hibernate (a través de Spring Data JPA)

**Build**: Maven 4.0.6

**Dependencias Adicionales**:
- MySQL Connector/J: driver JDBC para MySQL
- Lombok: generación automática de getters/setters
- Spring Boot DevTools: hot-reload en desarrollo
- Spring Boot Test: framework para tests automatizados

**Configuracion por Servicio**:
- `application.properties`: configuración de BD, puerto, perfiles
- Inyección de variables de entorno desde docker-compose

### Frontend

**Tecnologia**: HTML5 + CSS
- Archivos estáticos servidos por Nginx
- Responsive design para acceso desde móviles y escritorio
- Interfaz intuitiva para donantes y beneficiarios

**Servidor Web**: Nginx
- Reverse proxy
- Manejo de peticiones HTTP/HTTPS
- Compresión de contenido

### Infraestructura

**Contenedorizacion**: Docker
- Dockerfile para cada microservicio
- Imagen base: OpenJDK para Java
- Imagen oficial de MySQL 8.0
- Imagen oficial de Nginx

**Orquestacion**: Docker Compose
- Definición de 17 servicios en docker-compose.yml
- Red personalizada: donaton-network
- Health checks para sincronización de inicio
- Volúmenes persistentes para datos
- Variables de entorno configurables

**Entorno de Desarrollo**:
- Spring Boot DevTools para reload automático
- Configuración de perfiles (dev, prod)
- Actuator endpoints para monitoreo

---

## Instalacion y Configuracion

### Requisitos Previos

- Docker 20.10+
- Docker Compose 2.0+
- Git
- (Opcional) Java 17+ para desarrollo local
- (Opcional) Maven 4.0.6 para build local

### Instalacion en Linux

1. **Clonar el repositorio**:
```bash
git clone <url-repositorio>
cd Donaton
```

2. **Verificar estructura de directorios**:
```bash
ls -la
# Debe mostrar: docker-compose.yml, README.md, db-init/, ms-*, etc.
```

3. **Configurar variables de entorno (opcional)**:

Crear archivo `.env` en la raíz del proyecto para personalizar puertos y credenciales:
```
MYSQL_ROOT_PASSWORD=root_password_segura
DONANTES_DB_PASSWORD=donantes_pass
BENEFICIARIOS_DB_PASSWORD=beneficiarios_pass
# ... una variable por cada servicio
```

Si no se crea `.env`, Docker Compose usará valores por defecto seguros.

### Instalacion en Windows

1. **Clonar el repositorio**:
```powershell
git clone <url-repositorio>
cd Donaton
```

2. **Configurar variables de entorno (opcional)**:

Crear archivo `.env` en la raíz del proyecto con variables en formato Windows.


---

## Ejecucion del Proyecto

### Iniciar los Servicios

**Comando básico**:
```bash
docker compose up --build -d
```

### Verificar Estado de Servicios

```bash
docker compose ps
```

Mostrará estado de cada contenedor. Todos deben mostrar "Up".

```bash
docker compose logs
```

Ver logs de todos los servicios. Usar `--follow` para ver en tiempo real.

### Acceder a Aplicaciones

Una vez iniciados todos los servicios:

- **Frontend Público**: http://localhost
- **Panel Administrativo**: http://localhost/panel.html
- **API ms-donantes**: http://localhost:8081
- **API ms-beneficiarios**: http://localhost:8082
- **API ms-centros-acopio**: http://localhost:8083
- **API ms-donaciones**: http://localhost:8084
- **API ms-comunas**: http://localhost:8085
- **API ms-tipos**: http://localhost:8086
- **API ms-auth**: http://localhost:8087
- **API ms-admin**: http://localhost:8088

### Health Check

Verificar que un servicio está operativo:
```bash
curl http://localhost:8081/actuator/health
```

Respuesta esperada:
```json
{"status":"UP"}
```

### Detener los Servicios

```bash
docker compose down
```

Detiene todos los contenedores (preserva volúmenes de datos).

```bash
docker compose down -v
```

Detiene contenedores y elimina volúmenes (borra datos).

### Logs de Servicios Específicos

```bash
docker compose logs ms-donantes
docker compose logs ms-beneficiarios
```

### Reiniciar un Servicio

```bash
docker compose restart ms-donantes
```

---

## Estructura de Directorios

```
Donaton/
├── README.md                          # Documentación principal
├── DOCUMENTACION.md                   # Esta documentación
├── docker-compose.yml                 # Orquestación de servicios
├── donaton_ddl_rm.sql                # Dump de estructura
├── donaton_seed_rm.sql               # Dump de datos iniciales
│
├── db-init/                           # Scripts de inicialización
│   ├── auth/
│   │   └── init.sql
│   ├── beneficiarios/
│   │   └── init.sql
│   ├── centros/
│   │   └── init.sql
│   ├── comunas/
│   │   └── init.sql
│   ├── donaciones/
│   │   └── init.sql
│   ├── donantes/
│   │   └── init.sql
│   ├── necesidad/
│   │   └── init.sql
│   └── tipos/
│       └── init.sql
│
├── ms-donantes/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/
│           └── resources/
│               └── application.properties
│
├── ms-beneficiarios/
│   ├── Dockerfile
│   ├── pom.xml
│   ├── mvnw / mvnw.cmd
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   └── resources/
│       │       └── application.properties
│       └── test/
│           └── java/
│
├── ms-centros-acopio/
│   ├── Dockerfile
│   ├── HELP.md
│   ├── pom.xml
│   ├── mvnw / mvnw.cmd
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   └── resources/
│       │       └── application.properties
│       └── test/
│           └── java/
│
├── ms-comunas/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│       └── main/
│
├── ms-donaciones/
│   ├── Dockerfile
│   ├── pom.xml
│   ├── mvnw / mvnw.cmd
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   └── resources/
│       │       └── application.properties
│       └── test/
│           └── java/
│
├── ms-donantes/ (alternativa)
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│
├── ms-necesidad/
│   ├── Dockerfile
│   ├── pom.xml
│   ├── mvnw / mvnw.cmd
│   └── src/
│
├── ms-tipos/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│
├── ms-auth/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│
├── ms-admin/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│
└── ms-frontend/
    ├── Dockerfile
    ├── nginx.conf
    ├── index.html
    └── panel.html
```

### Descripcion de Archivos Clave

**docker-compose.yml**: Orquestación de todos los servicios, configuración de red, volúmenes y variables de entorno.

**pom.xml**: Archivo de configuración Maven de cada microservicio con dependencias y plugins.

**Dockerfile**: Especificación de cómo construir la imagen Docker para cada servicio.

**application.properties**: Configuración de Spring Boot (puerto, conexión a BD, etc.).

**init.sql**: Scripts de inicialización de base de datos para cada servicio.

**nginx.conf**: Configuración del servidor web Nginx (rutas, reverse proxy, etc.).

**index.html / panel.html**: Interfaz web en HTML estático.

---

## Guia de Desarrollo

### Estructura de un Microservicio Java

Cada microservicio sigue la estructura estándar de Spring Boot:

```
ms-servicio/
├── src/main/java/
│   └── com/
│       └── donaton/
│           └── <servicio>/
│               ├── controller/        # Controllers REST
│               ├── service/           # Lógica de negocio
│               ├── repository/        # Acceso a datos (JPA)
│               ├── model/             # Entidades JPA
│               ├── dto/               # Data Transfer Objects
│               ├── exception/         # Excepciones personalizadas
│               ├── config/            # Configuración
│               └── Application.java   # Clase principal
├── src/main/resources/
│   ├── application.properties
│   └── templates/                     # Vistas Thymeleaf (si aplica)
└── src/test/java/                    # Tests unitarios e integración
```

### Agregar Nuevas Dependencias

1. Actualizar `pom.xml` del servicio con la nueva dependencia
2. Ejecutar `mvn clean install`
3. Reconstruir la imagen Docker: `docker compose up --build ms-servicio`

### Testing

Ejecutar tests de un servicio:
```bash
cd ms-donantes
mvn test
```

Ejecutar tests con cobertura:
```bash
mvn test jacoco:report
```

### Build Manual de Imagen Docker

Para un servicio específico:
```bash
cd ms-donantes
docker build -t donaton/ms-donantes:1.0 .
```

### Monitoreo y Salud

Verificar estado general del sistema:
```bash
for port in 8081 8082 8083 8084 8085 8086 8087 8088; do
  echo "Puerto $port:"
  curl http://localhost:$port/actuator/health
done
```

---

## Notas Importantes

1. **Backups**: Realizar backups regulares de los volúmenes de datos Docker:
```bash
docker compose exec db-donantes mysqldump -u root -p dbname > backup.sql
```

2. **Actualizaciones**: Para actualizar una imagen sin perder datos:
```bash
docker compose pull
docker compose up --build -d
```
---

## Recursos Adicionales

- Spring Boot Documentation: https://spring.io/projects/spring-boot
- MySQL 8.0 Documentation: https://dev.mysql.com/doc/
- Docker Documentation: https://docs.docker.com/
- Docker Compose Reference: https://docs.docker.com/compose/compose-file/
- Hibernate JPA: https://hibernate.org/

---

**Versión del Proyecto**: 1.0.0
