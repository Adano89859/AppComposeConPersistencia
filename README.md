# 📱 AppComposeConPersistencia

**Autores:** Adán Romero, Sara Alonso  
**Fecha:** 22/11/2025  
**Temática:** Notas de cosas a hacer 

---

## 🧩 Descripción del proyecto  
**AppComposeConPersistencia** es una aplicación Android desarrollada en **Kotlin** y construida con **Jetpack Compose**, que demuestra cómo guardar y recuperar datos de forma persistente.  
La aplicación permite al usuario ingresar información en una interfaz moderna hecha con Compose y almacenarla de manera duradera mediante un sistema de persistencia como **DataStore (Preferences)**.  
Gracias a esto, los datos se mantienen incluso si la app se cierra o el dispositivo se reinicia.

---

## ⚙️ Tecnología elegida y justificación  
- **Lenguaje:** Kotlin — moderno, seguro y recomendado oficialmente para Android.  
- **Interfaz de usuario:** Jetpack Compose — diseño declarativo, reactivo y sin XML.  
- **Persistencia:** DataStore (Preferences) — alternativa moderna a SharedPreferences, basada en Coroutines y Flow.  
- **Entorno de desarrollo:** Android Studio — integración total con Compose y herramientas de preview.

---

## 💻 Configuración del entorno y ejecución  
1. Clona este repositorio:  
```bash
git clone https://github.com/Adano89859/AppComposeConPersistencia.git
   ```
2. Abre el proyecto en **Android Studio**.
3. Sincroniza el proyecto con Gradle
4. Ejecuta la app en un dispositivo físico o un emulador.
5. Introduce datos, guardalos y reinicia la app para comprobar la persistencia.

---

## 🗂️ Estructura del proyecto
 ```bash
AppComposeConPersistencia/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/ / kotlin/
│   │   │   │   ├── ui/             # Pantallas y composables
│   │   │   │   ├── data/           # DataStore, repositorio
│   │   │   │   └── viewmodel/      # Lógica y manejo de estado
│   │   │   ├── res/                # Recursos
│   │   │   └── AndroidManifest.xml
├── build.gradle.kts
└── settings.gradle.kts
   ```
## 🚀 Funcionamiento de la app

1. El usuario introduce un valor en un campo de texto.
2. Al pulsar un botón, la app guarda ese valor mediante DataStore.
3. Cada vez que se abre la app, se recupera automáticamente el dato almacenado y se muestra en la interfaz.
4. La interfaz Compose se actualiza de forma reactiva gracias al uso de Flow o StateFlow.

---

## 🌟 Funcionalidades implementadas y detalles extra

- Uso de Flow para observar los cambios en los valores persistidos.
- Guardado seguro con DataStore.edit {}.
- UI declarativa que refleja automáticamente los cambios de los datos.
- Arquitectura simple con repositorio + ViewModel.
- Persistencia de valores clave-valor de manera eficiente y moderna.

---

## 📸 Capturas de pantalla

Vista inicial de la app:

<img width="635" height="1389" alt="image" src="https://github.com/user-attachments/assets/02860f5a-abd0-478e-b647-8459474307e4" />

Creación de la nota:

<img width="607" height="1351" alt="image" src="https://github.com/user-attachments/assets/75f320f8-7218-43a7-9d1a-70670ae54c89" />

Nos aparece la nota, podemos marcarla como urgente o no; eliminarla, y si clikeamos en ella la podremos modificar:

<img width="606" height="1341" alt="image" src="https://github.com/user-attachments/assets/6126304b-4e63-43d0-a16f-4d84b8700a30" />

---

## 🧠 Conclusión y aprendizajes

### Aprendizajes principales

-Correcta organización del proyecto en múltiples capas: ui, data, viewmodel.

-Mejor comprensión del mapeo de clases, transformaciones y cómo interactúan dentro de la app.

-Gestión y resolución de errores de versiones y dependencias en Gradle.

-Trabajo en equipo y división eficiente de tareas.

-Investigación sobre la implementación de DataStore, ViewModel y arquitectura moderna en Android.

### Limitaciones y retos

-Problemas para elegir y aplicar versiones correctas de dependencias (por ejemplo, compatibilidad con Room).

-Conflictos de dependencias que requirieron ajustes manuales e investigación.

-Necesidad de profundizar en la comprensión de la función de cada archivo dentro del proyecto.

-Poco tiempo disponible debido a otros proyectos y exámenes, lo que limitó la planificación previa.
