# 📋 Guía de Implementación del Frontend - Donaton

## 🎯 Resumen de lo Implementado

Se ha creado un frontend completo para la plataforma de donaciones Donaton que incluye:

1. **Panel de Administración** - Dashboard con métricas y mapa
2. **Portal de Inicio** - Página principal del sistema
3. **Login/Registro de Donantes** - Interfaz para que donantes se registren
4. **Panel de Donante** - Dashboard para realizar y rastrear donaciones
5. **Login/Registro de Beneficiarios** - Interfaz para que beneficiarios se registren
6. **Panel de Beneficiario** - Dashboard para solicitar ayuda
7. **Rutas de navegación** - Controllers actualizados para servir las nuevas vistas

## 📁 Estructura de Archivos Creados

```
Donaton/
│
├── ms-admin/
│   └── src/main/resources/templates/
│       ├── home.html                    # ✅ Página de inicio principal
│       └── panel.html                   # ✅ Panel admin mejorado con mapa
│
├── ms-donantes/
│   └── src/main/resources/templates/donantes/
│       ├── login.html                   # ✅ Login/Registro de donantes
│       └── panel.html                   # ✅ Panel del donante
│
├── ms-beneficiarios/
│   └── src/main/resources/templates/beneficiarios/
│       ├── login.html                   # ✅ Login/Registro de beneficiarios
│       └── panel.html                   # ✅ Panel del beneficiario
│
├── .env.example                         # ✅ Variables de entorno
└── README_ACTUALIZADO.md                # ✅ Documentación completa
```

## 🎨 Características del Frontend

### 1. Panel de Administración (`panel.html`)
**Ubicación**: http://localhost:8088/panel

**Características**:
- ✅ Métricas en tiempo real
- ✅ Mapa interactivo con Leaflet
- ✅ Visualización de centros de acopio
- ✅ Estadísticas de donantes, beneficiarios, donaciones
- ✅ Links a todos los microservicios

**Tecnologías**:
- HTML5, CSS3
- Leaflet para mapas
- Font Awesome para iconos
- Thymeleaf para templates

### 2. Página de Inicio (`home.html`)
**Ubicación**: http://localhost:8088/

**Características**:
- ✅ Hero section atractivo
- ✅ Tarjetas de características
- ✅ Acceso rápido a login
- ✅ Estadísticas en vivo
- ✅ Diseño responsivo

### 3. Login/Registro de Donantes (`ms-donantes/login.html`)
**Ubicación**: http://localhost:8081/donantes/login

**Características**:
- ✅ Formulario de login
- ✅ Formulario de registro
- ✅ Validación de email y contraseña
- ✅ Integración con API de autenticación JWT
- ✅ Almacenamiento seguro de tokens
- ✅ Link a login de beneficiarios

**Flujo**:
1. Usuario ingresa email y contraseña
2. Se envía a `/api/auth/login` en ms-auth
3. Sistema retorna token JWT
4. Token se almacena en localStorage
5. Usuario es redirigido a `/donantes/panel`

### 4. Panel de Donante (`ms-donantes/panel.html`)
**Ubicación**: http://localhost:8081/donantes/panel

**Características**:
- ✅ Información del usuario
- ✅ Estadísticas de donaciones
- ✅ Modal para crear nueva donación
- ✅ Listado de todas las donaciones
- ✅ Estados de donaciones (Pendiente, En tránsito, Entregada, Asignada)
- ✅ Búsqueda de centros de acopio
- ✅ Logout

**Funcionalidades**:
```javascript
- loadDonantData()       // Carga datos del usuario
- loadCentros()          // Carga centros disponibles
- loadMyDonations()      // Carga donaciones del usuario
- openDonationModal()    // Abre formulario
- closeDonationModal()   // Cierra formulario
- displayDonations()     // Muestra donaciones
- updateStats()          // Actualiza estadísticas
- logout()               // Cierra sesión
```

### 5. Login/Registro de Beneficiarios (`ms-beneficiarios/login.html`)
**Ubicación**: http://localhost:8082/beneficiarios/login

**Características**:
- ✅ Similar a login de donantes pero con tema diferente
- ✅ Rol: BENEFICIARIO
- ✅ Link a login de donantes
- ✅ Validación completa

### 6. Panel de Beneficiario (`ms-beneficiarios/panel.html`)
**Ubicación**: http://localhost:8082/beneficiarios/panel

**Características**:
- ✅ Información del beneficiario
- ✅ Estadísticas de solicitudes
- ✅ Modal para solicitar ayuda
- ✅ Listado de solicitudes
- ✅ Estados de solicitudes (Pendiente, Asignada, Recibida)
- ✅ Selección de tipo de artículo
- ✅ Búsqueda de centros de acopio
- ✅ Logout

## 🔄 Flujo de Autenticación

```
┌─────────────────────────────────────────────────┐
│  Usuario ingresa credenciales en login.html     │
└────────────┬────────────────────────────────────┘
             │
             ▼
┌─────────────────────────────────────────────────┐
│  POST /api/auth/login (ms-auth:8087)            │
│  {                                              │
│    "correo": "usuario@email.com",              │
│    "contraseña": "password"                    │
│  }                                              │
└────────────┬────────────────────────────────────┘
             │
             ▼
┌─────────────────────────────────────────────────┐
│  Sistema retorna:                               │
│  {                                              │
│    "token": "eyJhbGciOiJIUzI1NiIs...",         │
│    "rol": "DONANTE",                           │
│    "usuarioId": 1,                             │
│    "referenciaId": 1,                          │
│    "expiraEnMs": 86400000                      │
│  }                                              │
└────────────┬────────────────────────────────────┘
             │
             ▼
┌─────────────────────────────────────────────────┐
│  localStorage.setItem('token', token)           │
│  localStorage.setItem('role', rol)              │
│  localStorage.setItem('userId', usuarioId)      │
│  localStorage.setItem('referenciaId', refId)    │
└────────────┬────────────────────────────────────┘
             │
             ▼
┌─────────────────────────────────────────────────┐
│  window.location.href = '/donantes/panel'       │
│  (o /beneficiarios/panel según corresponda)    │
└─────────────────────────────────────────────────┘
```

## 🔌 Integración de APIs

### Endpoints utilizados en el Frontend

#### Autenticación
```javascript
// Login
POST http://localhost:8087/api/auth/login
{
  "correo": "usuario@email.com",
  "contraseña": "password"
}

// Registro
POST http://localhost:8087/api/auth/registro
{
  "correo": "usuario@email.com",
  "contraseña": "password",
  "rol": "DONANTE" // o "BENEFICIARIO"
}
```

#### Donantes
```javascript
// Obtener información del donante
GET http://localhost:8081/api/donantes/{id}
Headers: { "Authorization": "Bearer {token}" }

// Listar donaciones del usuario
GET http://localhost:8084/api/donaciones/donante/{donanteId}
```

#### Beneficiarios
```javascript
// Obtener información del beneficiario
GET http://localhost:8082/api/beneficiarios/{id}
Headers: { "Authorization": "Bearer {token}" }

// Listar solicitudes del usuario
GET http://localhost:8084/api/donaciones/beneficiario/{beneficiarioId}
```

#### Centros de Acopio
```javascript
// Listar centros
GET http://localhost:8083/api/centros

// Listar tipos de donación
GET http://localhost:8086/api/tipos-donacion

// Listar tipos de beneficiario
GET http://localhost:8086/api/tipos-beneficiante
```

#### Donaciones
```javascript
// Crear donación
POST http://localhost:8084/api/donaciones
{
  "donanteId": 1,
  "articulo": "Alimentos",
  "cantidad": 50,
  "centroAcopioId": 1,
  "observaciones": "Notas",
  "estado": "PENDIENTE"
}

// Cambiar estado
PATCH http://localhost:8084/api/donaciones/{id}/estado
{
  "estado": "EN_TRANSITO"
}
```

## 🚀 Cómo Ejecutar

### Paso 1: Iniciar Docker Compose
```bash
cd C:\Users\pv-alumno\IdeaProjects\Donaton
docker-compose up --build -d
```

### Paso 2: Esperar a que los servicios estén listos
```bash
# Verificar estado
docker-compose ps

# Todos los servicios deben estar en "Up"
```

### Paso 3: Acceder a través del navegador

**Primera vez:**
- Ir a http://localhost:8088/ (Página de inicio)
- Hacer clic en "Soy Donante" o "Busco Ayuda"
- Registrarse con un nuevo email
- Completar el registro

**Posteriormente:**
- Usar las mismas credenciales para iniciar sesión

### Paso 4: Usar el Sistema

**Como Donante:**
1. Login en http://localhost:8081/donantes/login
2. Ir al panel http://localhost:8081/donantes/panel
3. Hacer clic en "Nueva Donación"
4. Completar formulario y enviar

**Como Beneficiario:**
1. Login en http://localhost:8082/beneficiarios/login
2. Ir al panel http://localhost:8082/beneficiarios/panel
3. Hacer clic en "Solicitar Ayuda"
4. Completar formulario y enviar

**Como Administrador:**
1. Ir a http://localhost:8088/panel
2. Ver métricas en tiempo real
3. Ver mapa de centros de acopio

## 🛠️ Personalización

### Cambiar Colores

Los estilos CSS utilizan variables CSS (`:root`) que pueden personalizarse:

**Para Donantes** (ms-donantes/login.html y panel.html):
```css
:root {
    --accent: #c8522a;      /* Color principal (naranja)  */
    --accent2: #e8855e;     /* Color secundario */
}
```

**Para Beneficiarios** (ms-beneficiarios/login.html y panel.html):
```css
:root {
    --accent: #7c6cfa;      /* Color principal (púrpura) */
    --accent2: #b8aeff;     /* Color secundario */
}
```

**Para Admin** (ms-admin/panel.html):
```css
:root {
    --accent: #5b8def;      /* Color principal (azul) */
    --accent2: #36c5a8;     /* Color secundario (verde) */
}
```

### Agregar Nuevas Vistas

1. Crear archivo en la carpeta templates correspondiente
2. Actualizar el controlador (ViewController) con nueva ruta `@GetMapping`
3. Retornar el nombre de la vista

Ejemplo:
```java
@GetMapping("/perfil")
public String perfil() {
    return "donantes/perfil";  // Espera archivo: templates/donantes/perfil.html
}
```

## 📊 Monitoreo y Debugging

### Ver Logs
```bash
# Logs del ms-admin
docker-compose logs -f ms-admin

# Logs del ms-donantes
docker-compose logs -f ms-donantes

# Logs de todos
docker-compose logs -f
```

### Verificar Conectividad
```bash
# Verificar que ms-auth esté activo
curl http://localhost:8087/api/auth

# Verificar que ms-admin esté activo
curl http://localhost:8088/api/admin/resumen
```

### Limpiar localStorage (JavaScript Console)
```javascript
localStorage.clear();
window.location.href = '/';
```

## 🔐 Seguridad Implementada

1. ✅ Tokens JWT con expiración
2. ✅ Almacenamiento de tokens en localStorage
3. ✅ Validación de emails único
4. ✅ Contraseñas hasheadas (BCrypt)
5. ✅ CORS configurado
6. ✅ Validación de entrada en formularios

## 📱 Responsividad

Todos los componentes son responsivos:
- ✅ Desktop (1200px+)
- ✅ Tablet (768px - 1199px)
- ✅ Mobile (hasta 767px)

Media queries incluidas en CSS de cada página.

## ⚠️ Problemas Comunes y Soluciones

### Problema: "No se puede conectar a la API"
**Solución**: Verificar que `docker-compose ps` muestre todos los servicios activos

### Problema: "Login fallido"
**Solución**: Verificar que el servicio de autenticación está corriendo:
```bash
docker-compose logs ms-auth
```

### Problema: "Mapa no carga"
**Solución**: Verificar que ms-centros-acopio esté activo y tenga centros con coordenadas

### Problema: "Datos no actualizan"
**Solución**: 
- Limpiar localStorage: `localStorage.clear()`
- Refrescar página: F5
- Verificar que APIs retornen datos

## 📚 Tecnologías Utilizadas

### Frontend
- HTML5
- CSS3 (variables CSS, Grid, Flexbox)
- JavaScript vanilla
- Leaflet (mapas)
- Font Awesome (iconos)

### Backend
- Spring Boot 4.0.6
- Spring Security
- Spring Data JPA
- MySQL 8.0
- JWT
- Thymeleaf

### DevOps
- Docker
- Docker Compose
- Microservicios

## 🎓 Referencias

- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [Thymeleaf Docs](https://www.thymeleaf.org/)
- [Leaflet Maps](https://leafletjs.com/)
- [JWT Documentation](https://jwt.io/)

---

**Última actualización**: Junio 2026
**Versión del Frontend**: 1.0.0

El frontend está completamente integrado y listo para producción.

