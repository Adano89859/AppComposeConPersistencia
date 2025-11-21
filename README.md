# 📱 AppComposeConPersistencia

**Autores:** Adán Romero, Sara Alonso  
**Fecha:** 21/11/2025  
**Versión de Android:** API mínima dependiente del proyecto  
**Versión del proyecto:** 1.0  

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

## 🧠 Conclusión y aprendizajes

### Aprendizajes principales

### Limitaciones y retos
