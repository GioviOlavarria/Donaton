# 🏗️ Arquitectura del Sistema - Donaton

## 📊 Diagrama de Arquitectura General

```
┌─────────────────────────────────────────────────────────────────────────┐
│                         NAVEGADOR WEB (Cliente)                         │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                         │
│  http://localhost:8088/  (Página de inicio)                           │
│  http://localhost:8081/donantes/login  (Login Donante)               │
│  http://localhost:8082/beneficiarios/login  (Login Beneficiario)     │
│                                                                         │
└──────────────┬──────────────┬──────────────┬──────────────────────────┘
               │              │              │
               ▼              ▼              ▼
        ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
        │ ms-admin    │ │ ms-donantes │ │ ms-bene...  │
        │ :8088       │ │ :8081       │ │ :8082       │
        │             │ │             │ │             │
        │ Panel Admin │ │ Donantes    │ │ Beneficiarios
        │ Home        │ │ Login/Panel │ │ Login/Panel
        └──────┬──────┘ └──────┬──────┘ └──────┬──────┘
               │                │              │
               │                ▼              ▼
               │        ┌──────────────┐  ┌──────────────┐
               │        │ ms-auth:8087 │  │ ms-auth:8087 │
               │        │ Autenticación│  │ Autenticación│
               │        └──────┬───────┘  └──────┬───────┘
               │               │                │
               ▼               ▼                ▼
        ┌─────────────────────────────────────────────┐
        │      API REST - Microservicios de Negocio   │
        ├─────────────────────────────────────────────┤
        │                                             │
        │ ms-donantes:8081      - CRUD Donantes     │
        │ ms-beneficiarios:8082 - CRUD Beneficiarios│
        │ ms-centros:8083       - CRUD Centros      │
        │ ms-donaciones:8084    - CRUD Donaciones   │
        │ ms-comunas:8085       - CRUD Comunas      │
        │ ms-tipos:8086         - CRUD Tipos        │
        │ ms-auth:8087          - Autenticación     │
        │                                             │
        └──────────┬──────────────────────────┬──────┘
                   │                          │
                   ▼                          ▼
           ┌──────────────────┐       ┌──────────────────┐
           │  MySQL Donantes  │       │  MySQL Auth      │
           │      :3301       │  ...  │      :3310       │
           └──────────────────┘       └──────────────────┘
```

## 🔄 Flujo de Datos

### 1. Flujo de Inicio de Sesión de Donante

```
┌──────────────────────────┐
│ Usuario accede           │
│ /donantes/login          │
└────────┬─────────────────┘
         │
         ▼
┌──────────────────────────┐
│ Carga home.html          │
│ (Thymeleaf sirve HTML)   │
└────────┬─────────────────┘
         │
         ▼
┌──────────────────────────┐      ┌──────────────────────────┐
│ Usuario ingresa          │      │ Front-end validación:    │
│ email y contraseña       │───► │ • Email válido            │
│                          │      │ • Contraseña > 6 chars   │
└────────┬─────────────────┘      └──────────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ POST /api/auth/login (JavaScript AJAX)       │
│ Payload:                                      │
│ {                                             │
│   "correo": "donante@email.com",             │
│   "contraseña": "password123"                │
│ }                                             │
└────────┬─────────────────────────────────────┘
         │
         ▼ (Llamada HTTP a ms-auth:8087)
┌──────────────────────────────────────────────┐
│ ms-auth - AuthController.login()             │
│                                               │
│ 1. Buscar Usuario por correo                 │
│ 2. Validar contraseña (BCrypt)               │
│ 3. Generar JWT Token                         │
│ 4. Retornar respuesta con token              │
└────────┬─────────────────────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ Respuesta exitosa:                            │
│ {                                             │
│   "token": "eyJhbGciOiJIUzI1NiIsInR...",     │
│   "tipo": "Bearer",                           │
│   "usuarioId": 1,                             │
│   "correo": "donante@email.com",             │
│   "rol": "DONANTE",                           │
│   "referenciaId": 1,                          │
│   "expiraEnMs": 86400000                      │
│ }                                             │
└────────┬─────────────────────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ Front-end JavaScript:                        │
│ localStorage.setItem('token', token)         │
│ localStorage.setItem('role', 'DONANTE')      │
│ localStorage.setItem('userId', 1)            │
│ localStorage.setItem('referenciaId', 1)      │
└────────┬─────────────────────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ Redirigir a /donantes/panel                  │
└──────────────────────────────────────────────┘
```

### 2. Flujo de Crear Donación

```
┌──────────────────────────────┐
│ Donante hace clic en:        │
│ "Nueva Donación"             │
└────────┬──────────────────────┘
         │
         ▼
┌──────────────────────────────┐
│ Se abre Modal HTML           │
│ Forma vacía lista            │
└────────┬──────────────────────┘
         │
         ▼
┌──────────────────────────────┐
│ JavaScript carga             │
│ GET /api/centros             │
│ GET /api/tipos-donacion      │
└────────┬──────────────────────┘
         │
         ▼ (Llamadas paralelas)
┌──────────────────────────────┐
│ Opciones se rellenan en      │
│ selectores HTML              │
└────────┬──────────────────────┘
         │
         ▼
┌──────────────────────────────┐
│ Usuario completa:            │
│ • Artículo                   │
│ • Cantidad                   │
│ • Centro                     │
│ • Observaciones (opcional)   │
└────────┬──────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ POST /api/donaciones                         │
│ Headers: {Authorization: Bearer {token}}     │
│ Payload:                                      │
│ {                                             │
│   "donanteId": 1,                            │
│   "articulo": "Alimentos no perecederos",    │
│   "cantidad": 50,                             │
│   "centroAcopioId": 1,                       │
│   "observaciones": "Primera donación",       │
│   "estado": "PENDIENTE"                      │
│ }                                             │
└────────┬─────────────────────────────────────┘
         │
         ▼ (Llamada HTTP a ms-donaciones:8084)
┌──────────────────────────────────────────────┐
│ ms-donaciones - DonacionController.crear()   │
│                                               │
│ 1. Validar datos                             │
│ 2. Guardar en BD (MySQL)                     │
│ 3. Retornar objeto creado                    │
└────────┬─────────────────────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ Respuesta exitosa (HTTP 200):                │
│ {                                             │
│   "id": 1,                                    │
│   "donanteId": 1,                            │
│   "articulo": "Alimentos no perecederos",    │
│   "cantidad": 50,                             │
│   "centroAcopioId": 1,                       │
│   "estado": "PENDIENTE",                     │
│   "creadoEn": "2026-06-17T10:30:00",         │
│   "observaciones": "Primera donación"        │
│ }                                             │
└────────┬─────────────────────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ Front-end:                                   │
│ • Mostrar alerta de éxito                    │
│ • Cerrar modal                                │
│ • Recargar lista de donaciones               │
│   (llamada GET /api/donaciones/donante/1)    │
└────────┬─────────────────────────────────────┘
         │
         ▼
┌──────────────────────────────────────────────┐
│ Panel actualiza con nueva donación           │
│ • Contador se incrementa                     │
│ • Nueva fila aparece en lista                │
└──────────────────────────────────────────────┘
```

## 🗄️ Estructura de Bases de Datos

```
┌──────────────────────────────────────────────────────────────┐
│              MySQL 8.0 (8 instancias independientes)         │
├──────────────────────────────────────────────────────────────┤
│                                                               │
│ donaton_auth (Puerto 3310)                                  │
│ ├── usuario (id, correo, contraseña_hash, rol, ...)        │
│                                                               │
│ donaton_donantes (Puerto 3301)                              │
│ ├── donante (id, nombre, apellido, email, ...)             │
│                                                               │
│ donaton_beneficiarios (Puerto 3302)                         │
│ ├── beneficiario (id, nombre, rut, necesidad, ...)         │
│                                                               │
│ donaton_centros (Puerto 3303)                               │
│ ├── centro_acopio (id, nombre, direccion, ...)             │
│                                                               │
│ donaton_donaciones (Puerto 3304)                            │
│ ├── donacion (id, donanteId, articulo, estado, ...)        │
│                                                               │
│ donaton_comunas (Puerto 3305)                               │
│ ├── comuna (id, nombre)                                     │
│                                                               │
│ donaton_tipos (Puerto 3306)                                 │
│ ├── tipo_donacion (id, clasificacion, descripcion)         │
│ ├── tipo_beneficiante (id, categoria)                      │
│                                                               │
└──────────────────────────────────────────────────────────────┘
```

## 🔌 Puertos del Sistema

| Servicio | Puerto | Tipo | Descripción |
|----------|--------|------|------------|
| ms-admin | 8088 | HTTP | Panel de administración + Home |
| ms-auth | 8087 | HTTP | Autenticación JWT |
| ms-donantes | 8081 | HTTP | APIs y vistas de donantes |
| ms-beneficiarios | 8082 | HTTP | APIs y vistas de beneficiarios |
| ms-centros | 8083 | HTTP | APIs y vistas de centros |
| ms-donaciones | 8084 | HTTP | APIs y vistas de donaciones |
| ms-comunas | 8085 | HTTP | APIs de comunas |
| ms-tipos | 8086 | HTTP | APIs de tipos |
| MySQL Auth | 3310 | TCP | BD Autenticación |
| MySQL Donantes | 3301 | TCP | BD Donantes |
| MySQL Beneficiarios | 3302 | TCP | BD Beneficiarios |
| MySQL Centros | 3303 | TCP | BD Centros |
| MySQL Donaciones | 3304 | TCP | BD Donaciones |
| MySQL Comunas | 3305 | TCP | BD Comunas |
| MySQL Tipos | 3306 | TCP | BD Tipos |

## 🔐 Flujo de Seguridad

```
┌─────────────────────────────────────┐
│ Credenciales del Usuario            │
│ email + contraseña                  │
└────────┬────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────┐
│ ms-auth recibe solicitud            │
└────────┬────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────┐
│ Busca usuario en BD                 │
└────────┬────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────┐
│ Compara contraseña con hash (BCrypt)│
│ Contraseña NO se almacena en texto  │
└────────┬────────────────────────────┘
         │
    ┌────┴────┐
    │         │
    ▼         ▼
   SI        NO
    │         │
    │         ▼
    │     Retorna error 401
    │
    ▼
┌─────────────────────────────────────┐
│ Genera JWT con:                     │
│ • usuarioId (payload)               │
│ • rol (payload)                     │
│ • expiraEnMs (payload)              │
│ • firma secreta (header)            │
└────────┬────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────┐
│ Front-end almacena token en         │
│ localStorage (navegador)            │
└────────┬────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────┐
│ En próximas solicitudes:            │
│ Authorization: Bearer {token}       │
│ (se valida firma y expiración)      │
└─────────────────────────────────────┘
```

## 📱 Vistas del Sistema

```
┌────────────────────────────────────────────────────────────┐
│                   INICIO (Home)                            │
│                 http://localhost:8088                      │
│  Hero + Features + Links a Login + Estadísticas           │
└────┬───────────────────────────────┬──────────────────────┘
     │                               │
     ▼                               ▼
┌─────────────────────────┐  ┌──────────────────────────────┐
│  LOGIN DONANTE          │  │  LOGIN BENEFICIARIO         │
│  :8081/donantes/login   │  │  :8082/beneficiarios/login  │
│                         │  │                              │
│  • Registro             │  │  • Registro                 │
│  • Login                │  │  • Login                    │
│  • Validación           │  │  • Validación               │
└────┬────────────────────┘  └──────┬──────────────────────┘
     │                              │
     ▼                              ▼
┌──────────────────────┐  ┌──────────────────────────────┐
│  PANEL DONANTE       │  │  PANEL BENEFICIARIO         │
│  :8081/donantes/panel│  │  :8082/beneficiarios/panel  │
│                      │  │                              │
│  • Mi perfil         │  │  • Mi perfil                │
│  • Estadísticas      │  │  • Estadísticas             │
│  • Nueva donación    │  │  • Solicitar ayuda          │
│  • Mis donaciones    │  │  • Mis solicitudes          │
│  • Estado entregas   │  │  • Estado solicitudes       │
└──────────────────────┘  └──────────────────────────────┘

┌────────────────────────────────────────────────────────────┐
│              PANEL ADMIN                                   │
│           http://localhost:8088/panel                      │
│                                                            │
│  • Métricas en tiempo real                               │
│  • Mapa interactivo con centros de acopio                │
│  • Estadísticas generales                                │
│  • Links a todos los microservicios                      │
└────────────────────────────────────────────────────────────┘
```

## 🔄 Ciclo de Vida de una Donación

```
1. CREACIÓN (PENDIENTE)
   └─ Donante crea donación
      • Especifica artículo
      • Indica cantidad
      • Selecciona centro de acopio
      • Estado: PENDIENTE

2. PROCESAMIENTO (EN_TRANSITO)
   └─ Administrador procesa
      • Asigna a beneficiario
      • Actualiza estado
      • Estado: EN_TRANSITO

3. ASIGNACIÓN (ASIGNADA)
   └─ Sistema asigna
      • Vincula a beneficiario específico
      • Notifica al beneficiario
      • Estado: ASIGNADA

4. ENTREGA (ENTREGADA)
   └─ Donación completada
      • Centro confirma entrega
      • Beneficiario recibe
      • Estado: ENTREGADA

Opciones:
5. CANCELACIÓN (CANCELADA)
   └─ Donación cancelada por cualquier razón
      • Estado: CANCELADA
```

## 📈 Escalabilidad

La arquitectura permite:
- ✅ Agregar más centros de acopio
- ✅ Escalar cada microservicio independientemente
- ✅ Cambiar BD sin afectar otros servicios
- ✅ Agregar nuevas funcionalidades (ej: reportes, notificaciones)
- ✅ Integrar pagos
- ✅ Agregar movilidad (apps móviles)

---

**Última actualización**: Junio 2026
**Versión**: 1.0.0

