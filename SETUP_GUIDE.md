# 🛠️ Guía de Setup - Caos Total V3

## 📦 Requisitos

- **Java**: 21 o superior
- **Minecraft**: 1.21.1
- **Fabric**: Loader 0.15.11+
- **Fabric API**: 0.91.0+
- **Git**: Para clonar el repositorio

## 🔧 Instalación para Jugar

### 1. Descargar el MOD compilado
```bash
# El JAR estará en GitHub Releases
https://github.com/Feyonor/CaosTotalV3/releases
```

### 2. Instalar el MOD
```bash
# Windows
Copiar el JAR a: %appdata%/.minecraft/mods/

# Linux
Copiar el JAR a: ~/.minecraft/mods/

# macOS
Copiar el JAR a: ~/Library/Application Support/minecraft/mods/
```

### 3. Verificar Fabric está instalado
- Abre Minecraft Launcher
- Crea un perfil con Fabric 0.15.11+
- Instala Fabric API en mods/

### 4. ¡A jugar!
- Inicia Minecraft con Fabric
- Crea un mundo nuevo (Single Player o Servidor)
- ¡Disfruta del CAOS!

## 👨‍💻 Instalación para Desarrolladores

### 1. Clonar repositorio
```bash
git clone https://github.com/Feyonor/CaosTotalV3.git
cd CaosTotalV3
```

### 2. Preparar ambiente
```bash
./gradlew genSources
```

### 3. Compilar el MOD
```bash
./gradlew build
```

### 4. El JAR estará en
```
build/libs/caostaotal-1.0.0.jar
```

### 5. Abrir en IDE (IntelliJ IDEA recomendado)
```bash
./gradlew idea
```

Luego abre el proyecto en IntelliJ.

## 🐛 Troubleshooting

### Error: "No se puede encontrar Java 21"
```bash
# Instala Java 21
# Windows: Descarga desde oracle.com
# Linux: sudo apt install openjdk-21-jdk
# macOS: brew install openjdk@21
```

### Error: "Gradle build failed"
```bash
# Limpia el cache
./gradlew clean
./gradlew build
```

### El MOD no aparece en el juego
- Verifica que Fabric API esté instalado
- Revisa que el JAR esté en la carpeta mods/
- Reinicia el juego completamente

## 📚 Estructura del Proyecto

```
CaosTotalV3/
├── src/main/java/com/feyonor/caostaotal/
│   ├── CaosTotalMod.java           (Main)
│   ├── command/                    (Comandos)
│   ├── config/                     (Configuración)
│   ├── dimension/                  (Dimensión)
│   ├── events/                     (Eventos)
│   ├── item/                       (Items)
│   ├── mixin/                      (Modificaciones)
│   └── util/                       (Utilidades)
├── src/main/resources/
│   ├── fabric.mod.json             (Metadatos)
│   ├── data/                       (Datos)
│   └── assets/                     (Texturas)
└── build.gradle.kts                (Config Gradle)
```

## 🚀 Compilación y Distribución

### Compilar versión final
```bash
./gradlew build -x test
```

### Cambiar versión
Edita `gradle.properties`:
```ini
mod_version=1.1.0
```

### Distribuir
- Sube el JAR de `build/libs/` a GitHub Releases
- Comparte con tus amigos
- ¡Que disfruten el CAOS!

---

**¡Si tienes problemas, revisa el README.md principal!**
