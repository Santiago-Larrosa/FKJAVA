# Furnace Knight Dungeon

## Integrantes del Grupo

- Santiago Larrosa  

## Descripción del Juego

*Furnace Knight Dungeon* es un juego de acción con elementos de roguelike en el que el jugador explora una serie de niveles interconectados dentro de un volcán activo. A medida que avanza, se enfrentará a enemigos cada vez más peligrosos, conseguira mejoras y descubrirá nuevos niveles. El jugador debe mejorar su personaje para poder enfrentarse contra los enemigos cada vez mas poderosos. El juego cuenta además con un modo multijugador cooperativo.

## Tecnologías Utilizadas

- [LibGDX](https://libgdx.com/) como framework principal de desarrollo.
- Lenguaje: Java
- IDE: Eclipse
- Plataformas objetivo:
  - Escritorio (Windows/Linux/macOS)

## Cómo Compilar y Ejecutar

1. Clona el repositorio:
   - (Abrir la terminal en su computadora, instalar git en caso de no tenerlo y seguir estos pasos)
   - git clone https://github.com/Santiago-Larrosa/FKJAVA
   - cd FKJAVA
2. Ejecuta el juego (modo desarrollo):
   - ./gradlew lwjgl3:run
3. (Opcional) Compila el proyecto completo:
   - ./gradlew build

   ### Desde Eclipse

1. Abre Eclipse y selecciona un workspace.

2. Importa el proyecto:
   - Ve a `Archivo > Importar > Gradle > Existing Gradle Project`.
   - Selecciona la carpeta del repositorio clonado (`FKJAVA`).

3. Espera a que Eclipse sincronice y configure el proyecto automáticamente con Gradle.

4. Ejecuta el proyecto:
   - Dirígete al módulo `lwjgl3` y ejecuta la clase principal (`Lwjgl3Launcher` o similar).

## Estructura del Proyecto

- `core/`: Contiene la lógica principal del juego, incluyendo las clases base y el juego en sí.
- `lwjgl3/`: Módulo específico para la plataforma de escritorio, utilizando LWJGL3 para la implementación.
- `assets/`: Carpeta destinada a los recursos del juego, como imágenes, sonidos y otros archivos multimedia.
- `gradle/` y archivos relacionados (`gradlew`, `gradlew.bat`, `build.gradle`, etc.): Archivos y configuraciones necesarios para la construcción y gestión del proyecto mediante Gradle.

## Estado Actual del Proyecto

Configuración inicial y estructura del proyecto.

## Enlace a la Wiki del Proyecto

Consulta la propuesta y documentación del proyecto en la [Wiki del repositorio](https://github.com/Santiago-Larrosa/FKJAVA/wiki).



