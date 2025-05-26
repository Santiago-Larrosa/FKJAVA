# Furnace Knight Dungeon

## Integrantes del Grupo

- Santiago Larrosa  

## Descripción del Juego

*Furnace Knight Dungeon* es un juego de acción con elementos de roguelike en el que el jugador explora una serie de niveles interconectados dentro de un volcán activo. A medida que avanza, se enfrentará a enemigos cada vez más peligrosos, conseguira mejoras y descubrirá nuevos niveles. El jugador debe mejorar su personaje para poder enfrentarse contra los enemigos cada vez mas poderosos. El juego cuenta además con un modo multijugador cooperativo.

## Tecnologías Utilizadas

- [LibGDX](https://libgdx.com/) como framework principal de desarrollo.
- Lenguaje: Java
- Plataformas objetivo:
  - Escritorio (Windows/Linux/macOS)

## Cómo Compilar y Ejecutar

1. Clona el repositorio:
   (Abrir la terminal en su computadora, instalar git en caso de no tenerlo y seguir estos pasos)
   - git clone https://github.com/Santiago-Larrosa/FKJAVA
   - cd FurnaceKnightJAVA
   - ./gradlew lwjgl3:run
   - ./gradlew build
    ( Asegurese de tener instaldo Java 17 )

## Estructura del Proyecto

- `core/`: Contiene la lógica principal del juego, incluyendo las clases base y el juego en si.
- `lwjgl3/`: Módulo específico para la plataforma de escritorio, utilizando LWJGL3 para la implementación.
- `assets/`: Carpeta destinada a los recursos del juego, como imágenes, sonidos y otros archivos multimedia.
- `gradle/` y archivos relacionados (`gradlew`, `gradlew.bat`, `build.gradle`, etc.): Archivos y configuraciones necesarios para la construcción y gestión del proyecto mediante Gradle.

## Estado Actual del Proyecto

Configuración inicial y estructura del proyecto.


