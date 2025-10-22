# Examen práctico - Acceso a Datos (RA 2)

**Duración:** 2 horas  
**Tipo:** Prueba práctica individual  
**Módulo:** Acceso a datos (DAM, 2º curso)  
**RA:** 2 - Desarrolla aplicaciones que gestionan información almacenada en bases de datos relacionales.

---

## 🧩 Objetivo

Completar la aplicación **de consola** que realiza operaciones CRUD sobre una base de datos relacional.  
La base de datos se compone de dos tablas: `clientes` y `pedidos`.  

Deberás implementar el código marcado con `// TODO:` en las clases DAO y Service.  
Se valorará la aplicación correcta de los patrones **DAO** y **Singleton**,  
la separación en **3 capas**, y la inclusión de una **consulta multitabla (JOIN)**.

---

## 🗃️ Esquema de base de datos

```sql
CREATE TABLE clientes (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL,
  email TEXT NOT NULL
);

CREATE TABLE pedidos (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  cliente_id INTEGER NOT NULL,
  fecha TEXT NOT NULL,
  importe REAL NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE
);
```

Puedes crear la base de datos ejecutando el script **solucion.sql** antes de iniciar la aplicación.

---

## 🚀 Ejecución

1. Asegúrate de tener **Java 17+** y el **driver JDBC de SQLite** disponible (en `classpath` o integrado con IDE).
2. Ejecuta el script `solucion.sql` en SQLite (puedes usar `DB Browser for SQLite`).
3. Ejecuta `Main.java` desde tu entorno de desarrollo.
4. Prueba las operaciones del menú.

---

## 🧠 Requisitos mínimos

- CRUD completo para `clientes` y `pedidos`.
- Validación básica de datos (nombre no vacío, email con formato válido).
- Uso de `PreparedStatement` para evitar inyección SQL.
- Capa de acceso a datos con patrón **DAO**.
- Clase `ConnectionManager` con patrón **Singleton**.
- **Consulta JOIN**: pedidos con datos del cliente.
- Manejo correcto de recursos (`try-with-resources`).
- Uso de transacciones donde proceda.

---

## 🌟 Requisitos nivel experto

- Consulta multitabla (JOIN) implementada correctamente.
- Manejo de transacciones (commit/rollback).
- Aplicación del modelo en **3 capas**.
- Detección y corrección de **malos olores** (duplicación, nombres pobres, etc.).
- Refactorizaciones simples documentadas.
- README con breve justificación de decisiones técnicas.

---

## 📄 Entregables

- Proyecto completo con código funcional.
- Archivo `solucion.sql` actualizado si has modificado la estructura.
- Archivo `README.md` con tus observaciones.

---

**¡Suerte!**
