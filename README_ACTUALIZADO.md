# Donaton - Sistema de Donaciones Centralizado

Sistema integral de donaciones para la región metropolitana de Santiago que conecta donantes, beneficiarios y centros de acopio.

## 🚀 Características

- **Panel de Administración**: Dashboard con métricas en tiempo real y mapa interactivo
- **Sistema de Autenticación**: JWT para Donantes, Beneficiarios y Administradores
- **Gestión de Donaciones**: Plataforma completa para registrar y rastrear donaciones
- **Centros de Acopio**: Ubicación de centros en mapa interactivo
- **API REST**: Microservicios independientes para cada módulo
- **Arquitectura de Microservicios**: 8 microservicios con MySQL independiente

## 📋 Requisitos

- Docker y Docker Compose
- Git
- Navegador web moderno

## 🏗️ Estructura del Proyecto

```
Donaton/
├── ms-admin/              # Panel de administración (Puerto 8088)
├── ms-auth/               # Autenticación JWT (Puerto 8087)
├── ms-donantes/           # Gestión de donantes (Puerto 8081)
├── ms-beneficiarios/      # Gestión de beneficiarios (Puerto 8082)
├── ms-centros-acopio/     # Gestión de centros (Puerto 8083)
├── ms-donaciones/         # Gestión de donaciones (Puerto 8084)
├── ms-comunas/            # Gestión de comunas (Puerto 8085)
├── ms-tipos/              # Gestión de tipos (Puerto 8086)
├── db-init/               # Scripts de inicialización de BD
└── docker-compose.yml     # Orquestación de servicios
```

## 🔧 Instalación y Ejecución

### 1. Clonar el repositorio
```bash
git clone <repository-url>
cd Donaton
```

### 2. Construir e iniciar los servicios
```bash
docker-compose up --build -d
```

Este comando:
- Construye las imágenes Docker
- Inicia 8 microservicios (aplicaciones)
- Inicia 8 bases de datos MySQL
- Configura la red de comunicación

### 3. Esperar a que los servicios estén listos
El proceso puede tomar 1-2 minutos. Verifica el estado:
```bash
docker-compose ps
```

## 🌐 Acceso al Sistema

Una vez que los servicios están en línea, accede a través de:

### Portal Principal (Página de Inicio)
- **URL**: http://localhost:8088/
- **Descripción**: Página de bienvenida con enlaces a todos los sistemas

### 📊 Panel de Administración
- **URL**: http://localhost:8088/panel
- **Características**:
  - Métricas en tiempo real
  - Mapa de centros de acopio
  - Estadísticas generales

### 💳 Donantes
- **Login/Registro**: http://localhost:8081/donantes/login
- **Panel**: http://localhost:8081/donantes/panel
- **Listado**: http://localhost:8081/donantes
- **Funciones**:
  - Registrarse como donante
  - Realizar donaciones
  - Ver historial de donaciones
  - Rastrear estado de entregas

### 🤝 Beneficiarios
- **Login/Registro**: http://localhost:8082/beneficiarios/login
- **Panel**: http://localhost:8082/beneficiarios/panel
- **Listado**: http://localhost:8082/beneficiarios
- **Funciones**:
  - Registrarse como beneficiario
  - Solicitar ayuda
  - Ver solicitudes activas
  - Rastrear entregas

### 📍 Centros de Acopio
- **API**: http://localhost:8083/api/centros
- **Vista**: http://localhost:8083/centros

### 📦 Donaciones
- **API**: http://localhost:8084/api/donaciones
- **Vista**: http://localhost:8084/donaciones

### 📚 APIs Disponibles

#### Autenticación (Puerto 8087)
```
POST /api/auth/registro          - Registrar usuario
POST /api/auth/login             - Iniciar sesión
POST /api/auth/validar           - Validar token
```

#### Donantes (Puerto 8081)
```
GET  /api/donantes               - Listar donantes
GET  /api/donantes/activos       - Listar activos
GET  /api/donantes/{id}          - Obtener por ID
POST /api/donantes               - Crear donante
PUT  /api/donantes/{id}          - Actualizar
DELETE /api/donantes/{id}        - Eliminar
```

#### Beneficiarios (Puerto 8082)
```
GET  /api/beneficiarios          - Listar beneficiarios
GET  /api/beneficiarios/activos  - Listar activos
GET  /api/beneficiarios/{id}     - Obtener por ID
POST /api/beneficiarios          - Crear beneficiario
PUT  /api/beneficiarios/{id}     - Actualizar
DELETE /api/beneficiarios/{id}   - Eliminar
```

#### Centros de Acopio (Puerto 8083)
```
GET  /api/centros                - Listar centros
GET  /api/centros/activos        - Listar activos
GET  /api/centros/{id}           - Obtener por ID
POST /api/centros                - Crear centro
PUT  /api/centros/{id}           - Actualizar
DELETE /api/centros/{id}         - Eliminar
```

#### Donaciones (Puerto 8084)
```
GET  /api/donaciones             - Listar todas
GET  /api/donaciones/{id}        - Obtener por ID
GET  /api/donaciones/donante/{id}       - Por donante
GET  /api/donaciones/beneficiario/{id}  - Por beneficiario
GET  /api/donaciones/centro/{id}        - Por centro
GET  /api/donaciones/estado/{estado}    - Por estado
POST /api/donaciones             - Crear
PUT  /api/donaciones/{id}        - Actualizar
PATCH /api/donaciones/{id}/estado       - Cambiar estado
DELETE /api/donaciones/{id}      - Eliminar
```

#### Comunas (Puerto 8085)
```
GET  /api/comunas                - Listar comunas
GET  /api/comunas/{id}           - Obtener por ID
POST /api/comunas                - Crear
PUT  /api/comunas/{id}           - Actualizar
DELETE /api/comunas/{id}         - Eliminar
```

#### Tipos (Puerto 8086)
```
GET  /api/tipos-donacion         - Listar tipos de donación
GET  /api/tipos-beneficiante     - Listar tipos de beneficiante
```

#### Admin (Puerto 8088)
```
GET  /api/admin/resumen          - Resumen del sistema
```

## 🔐 Autenticación

El sistema utiliza **JWT (JSON Web Tokens)**. Para hacer requests autenticados:

```bash
# 1. Registrarse
curl -X POST http://localhost:8087/api/auth/registro \
  -H "Content-Type: application/json" \
  -d '{"correo":"usuario@email.com","contraseña":"password","rol":"DONANTE"}'

# 2. Iniciar sesión
curl -X POST http://localhost:8087/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"correo":"usuario@email.com","contraseña":"password"}'

# Respuesta incluye token JWT
# {"token":"eyJhbGciOiJIUzI1NiIs...","rol":"DONANTE","usuarioId":1,"referenciaId":1}

# 3. Usar token en headers
curl -H "Authorization: Bearer <token>" http://localhost:8081/api/donantes
```

## 📊 Estados de Donaciones

- **PENDIENTE**: Donación registrada, awaiting processing
- **EN_TRANSITO**: En camino al centro de acopio
- **ASIGNADA**: Asignada a beneficiario
- **ENTREGADA**: Donación completada
- **CANCELADA**: Donación cancelada

## 🗄️ Bases de Datos

Cada microservicio tiene su propia base de datos MySQL:

| Servicio | Base de Datos | Puerto |
|----------|--------------|--------|
| Auth | donaton_auth | 3310 |
| Donantes | donaton_donantes | 3301 |
| Beneficiarios | donaton_beneficiarios | 3302 |
| Centros | donaton_centros | 3303 |
| Donaciones | donaton_donaciones | 3304 |
| Comunas | donaton_comunas | 3305 |
| Tipos | donaton_tipos | 3306 |

**Credenciales por defecto**:
- Usuario: `usuario`
- Contraseña: `password123`
- Root: `root` / `rootpassword`

## 📝 Ejemplos de Uso

### Como Donante

1. Ir a http://localhost:8081/donantes/login
2. Registrarse o iniciar sesión
3. Acceder a http://localhost:8081/donantes/panel
4. Hacer clic en "Nueva Donación"
5. Completar formulario:
   - Artículo a donar
   - Cantidad
   - Centro de acopio
   - Observaciones (opcional)
6. Ver historial de donaciones

### Como Beneficiario

1. Ir a http://localhost:8082/beneficiarios/login
2. Registrarse o iniciar sesión
3. Acceder a http://localhost:8082/beneficiarios/panel
4. Hacer clic en "Solicitar Ayuda"
5. Completar formulario:
   - Tipo de artículo
   - Cantidad necesaria
   - Descripción
   - Centro de acopio más cercano
6. Ver estado de solicitudes

### Panel de Administración

1. Ir a http://localhost:8088/panel
2. Ver métricas en tiempo real
3. Visualizar mapa con centros de acopio
4. Acceder a URLs de los microservicios

## 🛑 Detener los Servicios

```bash
docker-compose down
```

Para eliminar volúmenes (borrar datos):
```bash
docker-compose down -v
```

## 📋 Monitoreo

Ver logs de un servicio específico:
```bash
docker-compose logs -f ms-admin
docker-compose logs -f ms-donantes
docker-compose logs -f ms-beneficiarios
```

Ver logs de todos:
```bash
docker-compose logs -f
```

## 🐛 Solución de Problemas

### Los servicios no inician
```bash
docker-compose down -v
docker-compose up --build -d
```

### Error de puerto ya en uso
```bash
# Liberar puerto (ejemplo puerto 8088)
# En Linux/Mac
lsof -i :8088 | grep LISTEN | awk '{print $2}' | xargs kill -9

# En Windows
netstat -ano | findstr :8088
taskkill /PID <PID> /F
```

### No puede conectarse a BD
- Esperar 30 segundos después de iniciar
- Verificar: `docker-compose ps`
- Ver logs: `docker-compose logs mysql`

## 🔍 Endpoints Útiles para Pruebas

### Crear una donación
```bash
curl -X POST http://localhost:8084/api/donaciones \
  -H "Content-Type: application/json" \
  -d '{
    "donanteId": 1,
    "articulo": "Alimentos no perecederos",
    "cantidad": 50,
    "centroAcopioId": 1,
    "estado": "PENDIENTE",
    "observaciones": "Donación de alimentos"
  }'
```

### Listar donaciones de un donante
```bash
curl http://localhost:8084/api/donaciones/donante/1
```

### Cambiar estado de donación
```bash
curl -X PATCH http://localhost:8084/api/donaciones/1/estado \
  -H "Content-Type: application/json" \
  -d '{"estado": "EN_TRANSITO"}'
```

## 📚 Documentación Adicional

- Spring Boot: https://spring.io/projects/spring-boot
- Docker: https://docs.docker.com/
- MySQL: https://dev.mysql.com/doc/
- JWT: https://jwt.io/

## 👥 Contribuyentes

Proyecto Fullstack 3 - Donaton

## 📄 Licencia

Proyecto educativo

---

**Última actualización**: Junio 2026
**Versión**: 1.0.0

