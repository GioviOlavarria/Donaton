# 🚀 INSTRUCCIONES PASO A PASO - EJECUTAR DONATON AHORA

## ⏱️ Tiempo Total: 5 minutos

---

## 📍 PASO 1: Abrir Terminal PowerShell (30 segundos)

### En Windows:
1. Presiona `Windows + R`
2. Escribe `powershell`
3. Presiona Enter

### Alternativa: Desde Visual Studio Code
1. Abre VS Code
2. Menú: `Terminal` → `New Terminal`

---

## 📍 PASO 2: Navegar a la Carpeta del Proyecto (30 segundos)

```powershell
cd C:\Users\pv-alumno\IdeaProjects\Donaton
```

Verifica que estés en la carpeta correcta. Deberías ver:
```
PS C:\Users\pv-alumno\IdeaProjects\Donaton>
```

---

## 📍 PASO 3: Limpiar Docker (1-2 minutos)

⚠️ **IMPORTANTE**: Este paso borra datos viejos para que funcione correctamente

```powershell
docker-compose down -v
```

Espera a que termine. Deberías ver algo como:
```
Removing network donaton_donaton-network
```

---

## 📍 PASO 4: Reconstruir y Ejecutar (2-3 minutos)

```powershell
docker-compose up --build -d
```

Esto va a:
- Descargar imágenes
- Construir contenedores
- Iniciar todos los servicios

Verás algo como:
```
Creating donaton-db-centros...
Creating donaton-db-donantes...
...
Creating donaton-ms-admin...
```

Cuando termine, deberías ver `done` o el prompt volverá.

---

## 📍 PASO 5: Verificar que Todo está Corriendo (1 minuto)

```powershell
docker-compose ps
```

Deberías ver una tabla como esta:
```
NAME                      STATUS
donaton-db-centros        Up 40 seconds
donaton-db-donantes       Up 40 seconds
...
donaton-ms-admin          Up 20 seconds
donaton-ms-auth           Up 20 seconds
...
```

**✅ Si ves "Up" en todos: ¡Listo!**
**❌ Si ves "Restarting" o "Exit": Espera más, a veces tarda**

---

## 📍 PASO 6: Abrir en el Navegador (30 segundos)

### Abre una de estas URLs:

#### 🏠 **Landing Page (Recomendado)**
```
http://localhost:8088/
```
Aquí verás el nuevo dashboard con:
- Métricas en tiempo real
- Mapa de centros
- Porcentajes de donaciones
- Tabla de últimas donaciones

#### 💝 **Acceso Donantes**
```
http://localhost:8081/donantes/login
```

#### 🤝 **Acceso Beneficiarios**
```
http://localhost:8082/beneficiarios/login
```

#### 🔧 **Panel Admin**
```
http://localhost:8088/panel
```

---

## ✅ CASOS DE EXITO

### ✅ Caso 1: Dashboard Cargando Correctamente

```
Al abrir http://localhost:8088/:

1. Ves "Donaton" en el header
2. Ves 4 cards con números (Donantes, Beneficiarios, Centros, Donaciones)
3. Los números NO son cero
4. Ves un mapa con la región metropolitana
5. Ves gráficos de porcentaje
6. Los botones son azul, naranja y púrpura

✅ EXITO: El sistema está funcionando
```

### ✅ Caso 2: Registro de Donante Exitoso

```
1. Abre http://localhost:8088/
2. Haz clic en "Soy Donante" (azul)
3. Ve a http://localhost:8081/donantes/login ✓
4. Rellena: email@test.com y password123
5. Haz clic en "Crear cuenta"
6. Mensaje verde: "¡Cuenta creada!"
7. Inicia sesión con mismas credenciales
8. Mensaje verde: "¡Bienvenido! Redirigiendo..."
9. Vas a http://localhost:8081/donantes/panel

✅ EXITO: El registro y login funcionan
```

### ✅ Caso 3: Panel Admin Mostrando Datos

```
1. Abre http://localhost:8088/panel
2. Ve la pestaña "Donantes" activa
3. Ve una tabla con datos de donantes
4. Haz clic en "Beneficiarios"
5. Ve tabla con beneficiarios
6. Haz clic en "Centros de Acopio"
7. Ve tabla con centros

✅ EXITO: El admin está funcional
```

---

## ❌ SOLUCION DE PROBLEMAS

### ❌ Problema: "Connection refused" o "Cannot reach"

```
❌ Ver: Error de conexión

✅ Solución:
1. Espera 2 minutos más (Docker está inicializando)
2. Refresca la página: F5
3. Si persiste: docker-compose logs -f
```

### ❌ Problema: Métricas muestran 0

```
❌ Ver: 
  Donantes: 0
  Beneficiarios: 0
  Centros: 0

✅ Solución:
1. Espera 1 minuto más
2. Refresca (F5)
3. Si persiste: docker-compose restart ms-admin
```

### ❌ Problema: Mapa no aparece

```
❌ Ver: Área blanca vacía donde debería estar el mapa

✅ Solución:
1. Abre consola: F12 → Console
2. Verifica si hay errores rojos
3. Refresca la página
4. Si persiste: Los centros no tienen coordenadas (es normal)
```

### ❌ Problema: "Error 404" o "Página no encontrada"

```
❌ Ver: Whitelabel Error Page o Not Found

✅ Solución:
1. Verifica la URL: ¿está completa?
2. Prueba con http (no https)
3. Prueba con localhost (no 127.0.0.1)
4. Verifica el puerto: ¿es 8088, 8081, 8082?
```

### ❌ Problema: "puerto ya en uso"

```
❌ Ver: Error "Address already in use"

✅ Solución:
# Parar todo
docker-compose down

# Esperar 10 segundos

# Reiniciar
docker-compose up --build -d
```

---

## 🔄 ACCIONES COMUNES

### Ver Logs en Tiempo Real
```powershell
docker-compose logs -f
```
Presiona `Ctrl + C` para salir

### Ver Logs de Un Servicio Específico
```powershell
docker-compose logs -f ms-admin
docker-compose logs -f ms-donantes
docker-compose logs -f ms-auth
```

### Reiniciar Todo
```powershell
docker-compose restart
```

### Parar Todo (sin borrar datos)
```powershell
docker-compose down
```

### Parar Todo y Borrar Datos
```powershell
docker-compose down -v
```

### Reconstruir Todo
```powershell
docker-compose up --build -d
```

---

## 📋 CHECKLIST FINAL

```
Antes de reportar un problema, verifica:

☐ Ejecuté: docker-compose down -v
☐ Ejecuté: docker-compose up --build -d
☐ Esperé 2-3 minutos
☐ Ejecuté: docker-compose ps
☐ Todos los servicios muestran "Up"
☐ Intenté refrescar la página (F5)
☐ Limpié caché: Ctrl+Shift+Del (en Chrome)
☐ Probé en una ventana privada/incógnito
☐ Probé en otro navegador
☐ Probé http en lugar de https
☐ Verifiqué que no hay otra instancia de Docker corriendo
```

---

## 🎯 RESUMEN RÁPIDO

| Acción | Comando |
|--------|---------|
| **Limpiar** | `docker-compose down -v` |
| **Ejecutar** | `docker-compose up --build -d` |
| **Ver Estado** | `docker-compose ps` |
| **Ver Logs** | `docker-compose logs -f` |
| **Parar** | `docker-compose down` |
| **Restart** | `docker-compose restart` |

---

## 🌐 URLS PRINCIPALES

| Página | URL |
|--------|-----|
| **Home Dashboard** | http://localhost:8088/ |
| **Panel Admin** | http://localhost:8088/panel |
| **Login Donantes** | http://localhost:8081/donantes/login |
| **Panel Donantes** | http://localhost:8081/donantes/panel |
| **Login Beneficiarios** | http://localhost:8082/beneficiarios/login |
| **Panel Beneficiarios** | http://localhost:8082/beneficiarios/panel |

---

## 📞 SOPORTE RÁPIDO

Si algo falla:

1. 📖 Lee **CAMBIOS_REALIZADOS.md**
2. 📖 Lee **RESUMEN_SOLUCION.md**
3. 📊 Ejecuta `docker-compose ps`
4. 📊 Ejecuta `docker-compose logs -f`
5. 🔄 Intenta `docker-compose down -v && docker-compose up --build -d`

---

**¡Listo! El sistema debería estar corriendo correctamente ahora.** ✅

**Disfruta usando Donaton** 🚀

