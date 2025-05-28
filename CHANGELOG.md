# Changelog

Este archivo sigue el formato de [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/) y documenta todos los cambios importantes realizados en el proyecto. Las versiones siguen el esquema [SemVer](https://semver.org/lang/es/).

## [Unreleased]
### Added
- Refactorizar el codigo.
- Nuevas animaciones y ajustes en los estados del jugador.

---

## [1.1.0] - 2025-05-17
### Added
- Sistema de animaciones para caminar, estar quieto, cargar salto, saltar, caer y atacar, tanto mirando a la derecha como a la izquierda.
- Estados de salto: `NONE`, `PASS`, `JUMPING`, `FALLING`.
- Lógica de ataque con duración limitada y control de interrupción de movimiento durante el ataque.
- Implementación de salto cargado manteniendo presionada la tecla `SPACE`.
- Carga y renderizado de `TextureRegion` desde spritesheets con `AnimationHandler`.

## [1.0.0] - 2025-05-14
### Added
- Configuración inicial del proyecto con LibGDX mediante el asistente **Liftoff**.
- Creación de archivos base: `README.md`, `CHANGELOG.md`.
- Configuración inicial de la [Wiki del repositorio](https://github.com/Santiago-Larrosa/FKJAVA/wiki) con la propuesta del proyecto.
