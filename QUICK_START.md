# ⚡ GUÍA RÁPIDA - DONATON

## 🚀 Comienzo en 5 minutos

### Paso 1: Iniciar Docker (1 minuto)
```bash
cd C:\Users\pv-alumno\IdeaProjects\Donaton
docker-compose up --build -d
```

### Paso 2: Esperar (2 minutos)
```bash
# Verificar que todo esté UP
docker-compose ps

# Todos deben mostrar "Up"
```

### Paso 3: Abrir en navegador (1 minuto)

Haz clic en los siguientes enlaces:

| Rol | Enlace |
|-----|--------|
| 🏠 **Inicio** | http://localhost:8088/ |
| 📊 **Admin** | http://localhost:8088/panel |
| 💝 **Donante** | http://localhost:8081/donantes/login |
| 🤝 **Beneficiario** | http://localhost:8082/beneficiarios/login |

### Paso 4: Usar (1 minuto)

**Como Donante:**
1. Haz clic en "Registrarse"
2. Ingresa email y contraseña
3. Haz clic en "Crear cuenta"
4. Inicia sesión
5. Haz clic en "Nueva Donación"
6. Completa el formulario y envía

**Como Beneficiario:**
1. Haz clic en "Registrarse"
2. Ingresa email y contraseña
3. Haz clic en "Crear cuenta"
4. Inicia sesión
5. Haz clic en "Solicitar Ayuda"
6. Completa el formulario y envía

## 📍 URLs de Acceso

```
🌐 INICIO Y ADMIN:
   http://localhost:8088/          (Página de inicio)
   http://localhost:8088/panel     (Panel de administración)

💳 DONANTES:
   http://localhost:8081/donantes/login   (Login/Registro)
   http://localhost:8081/donantes/panel   (Panel del donante)
   http://localhost:8081/donantes         (Listado de donantes)

🤝 BENEFICIARIOS:
   http://localhost:8082/beneficiarios/login   (Login/Registro)
   http://localhost:8082/beneficiarios/panel   (Panel de beneficiario)
   http://localhost:8082/beneficiarios         (Listado de beneficiarios)

📦 OTROS SERVICIOS:
   http://localhost:8083/centros     (Centros de acopio)
   http://localhost:8084/donaciones  (Donaciones)
```

## 🔑 Credenciales de Prueba

**No hay credenciales predefinidas.**

El sistema permite auto-registro:
- Email: `prueba@email.com`
- Contraseña: `password123` (cualquier contraseña > 6 caracteres)

## 📊 Funcionalidades Principales

### Como Donante
✅ Registrarse  
✅ Hacer donaciones  
✅ Ver historial de donaciones  
✅ Rastrear estados  
✅ Ver centros de acopio  

### Como Beneficiario
✅ Registrarse  
✅ Solicitar ayuda  
✅ Ver solicitudes activas  
✅ Rastrear entregas  
✅ Seleccionar tipos de artículos  

### Como Administrador
✅ Ver métricas en tiempo real  
✅ Ver mapa de centros  
✅ Ver estadísticas  
✅ Acceder a todos los servicios  

## 🛑 Detener el Sistema

```bash
# Parar servicios
docker-compose down

# Parar y borrar datos
docker-compose down -v
```

## 🐛 Problemas Comunes

### "No se puede conectar"
→ Esperar 1-2 minutos y refrescar la página (F5)

### "Registro fallido"
→ Usar otro email (cada email debe ser único)

### "Página en blanco"
→ Limpiar caché: Ctrl+Shift+Del (seleccionar todo) → Limpiar

### "Login fallido después de registro"
→ Esperar 10 segundos antes de intentar login

## 📚 Documentación Completa

- 📖 **README_ACTUALIZADO.md** - Documentación completa
- 🎨 **FRONTEND_IMPLEMENTATION.md** - Guía del frontend
- 🏗️ **ARQUITECTURA.md** - Diagramas y arquitectura
- ⚡ **RESUMEN_IMPLEMENTACION.txt** - Resumen ejecutivo

## 🎯 Checklist Rápido

```
[ ] Docker instalado y corriendo
[ ] Ejecuté docker-compose up --build -d
[ ] Espéré 1-2 minutos
[ ] Accedí a http://localhost:8088/
[ ] Vi la página de inicio
[ ] Hice clic en "Soy Donante"
[ ] Me registré con un email
[ ] Inicié sesión
[ ] Accedí a mi panel
[ ] Creé una donación
[ ] ¡Listo!
```

## 🎓 Video Tutorial (si aplica)

Si necesitas más ayuda, sigue estos pasos visualmente:

1. Ir a http://localhost:8088/
2. Leer las instrucciones en pantalla
3. Hacer clic en cualquiera de las opciones
4. Seguir el flujo indicado

## 💡 Tips Útiles

**Múltiples pestañas:**
- Abre una pestaña como Donante (8081)
- Abre otra como Beneficiario (8082)
- Abre otra como Admin (8088)
- ¡Prueba todo en paralelo!

**Pruebas rápidas:**
```bash
# Ver logs en tiempo real
docker-compose logs -f

# Ver estado de servicios
docker-compose ps

# Reiniciar un servicio
docker-compose restart ms-donantes
```

## 🌐 URLs de APIs (para desarrolladores)

```
POST   http://localhost:8087/api/auth/login
POST   http://localhost:8087/api/auth/registro
GET    http://localhost:8081/api/donantes
GET    http://localhost:8082/api/beneficiarios
GET    http://localhost:8083/api/centros
GET    http://localhost:8084/api/donaciones
GET    http://localhost:8088/api/admin/resumen
```

## 📞 Soporte Rápido

**Si no funciona → Haz esto:**

```bash
# 1. Verifica que Docker corra
docker-compose ps

# 2. Si algo falla, reconstruye
docker-compose down -v
docker-compose up --build -d

# 3. Ve los logs
docker-compose logs -f ms-admin

# 4. Limpia el navegador
# Ctrl+Shift+Del → Selecciona TODO → Limpiar

# 5. Intenta en otra pestaña/navegador
```

## ✨ Que esperar

### 1️⃣ Página de Inicio
- Hermosa interfaz
- Enlaces a todos los sistemas
- Estadísticas en vivo

### 2️⃣ Login de Donante
- Formulario limpio
- Auto-registro
- Tema naranja

### 3️⃣ Panel de Donante
- Tus donaciones
- Estadísticas
- Botón para nueva donación
- Modal para crear

### 4️⃣ Panel de Beneficiario
- Tus solicitudes
- Estadísticas
- Botón para solicitar ayuda
- Modal para crear

### 5️⃣ Panel Admin
- Métricas generales
- Mapa interactivo
- Información del sistema

## 🎉 ¡Disfruta!

El sistema está completo y funcional.

**¿Listo? ¡Vamos!**

```bash
docker-compose up --build -d
```

Abre http://localhost:8088/ en tu navegador en 2 minutos.

---

**Última actualización**: Junio 2026  
**Versión**: 1.0.0  
**Estado**: ✅ COMPLETO Y FUNCIONAL

