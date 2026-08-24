````markdown
# 🎮 CAOS TOTAL V3 - MANUAL COMPLETO PARA JUGAR

**Versión**: 1.0.0  
**Minecraft**: 1.21.1  
**Autor**: Feyonor  
**Última actualización**: 24/08/2026

---

## 📋 TABLA DE CONTENIDOS

1. [Requisitos](#requisitos)
2. [Instalación](#instalación)
3. [Cómo Jugar](#cómo-jugar)
4. [Acceder a la Dimensión del Caos](#acceder-a-la-dimensión-del-caos)
5. [Items y Crafteos](#items-y-crafteos)
6. [Comandos](#comandos)
7. [Estrategias](#estrategias)
8. [Solución de Problemas](#solución-de-problemas)

---

## 🔧 REQUISITOS

Antes de instalar, verifica que tengas:

### Software necesario:
- ✅ **Java 21** o superior
  - Windows: [Descargar Java 21](https://www.oracle.com/java/technologies/downloads/)
  - Linux: `sudo apt install openjdk-21-jdk`
  - macOS: `brew install openjdk@21`

- ✅ **Minecraft Java Edition**
  - Versión: **1.21.1**
  - Launcher oficial o compatible

- ✅ **Fabric Loader 0.15.11+**
  - [Descargar Fabric](https://fabricmc.net/use/installer/)

### Especificaciones PC:
- RAM: Mínimo 4GB (recomendado 8GB+)
- CPU: Cualquier CPU moderna
- GPU: No requerida (mejor rendimiento con GPU)
- Almacenamiento: 500MB libres

---

## 📥 INSTALACIÓN

### PASO 1️⃣: Descargar el MOD

**Opción A - Descarga Directa** (Más fácil):
1. Ve a: https://github.com/Feyonor/CaosTotalV3/releases
2. Descarga el archivo `caostaotal-1.0.0.jar`
3. Guárdalo en una carpeta segura

**Opción B - Compilar desde código** (Para desarrolladores):
```bash
git clone https://github.com/Feyonor/CaosTotalV3.git
cd CaosTotalV3
./gradlew build
# El JAR estará en: build/libs/caostaotal-1.0.0.jar
```

### PASO 2️⃣: Instalar Fabric

1. Descarga el **Fabric Installer** desde: https://fabricmc.net/use/installer/
2. Abre el instalador
3. Selecciona:
   - Game Version: **1.21.1**
   - Loader Version: **Latest** (0.15.11+)
4. Haz click en "Install Client"
5. Espera a que termine

### PASO 3️⃣: Instalar Fabric API

1. Descarga **Fabric API 1.21.1** desde:
   - https://www.modrinth.com/mod/fabric-api
   - O https://www.curseforge.com/minecraft/mods/fabric-api

2. Abre tu carpeta de mods:
   - **Windows**: `%appdata%/.minecraft/mods/`
   - **Linux**: `~/.minecraft/mods/`
   - **macOS**: `~/Library/Application Support/minecraft/mods/`

3. Pega el JAR de Fabric API aquí

### PASO 4️⃣: Instalar Caos Total V3

1. Copia el archivo `caostaotal-1.0.0.jar` a la carpeta de mods (paso 2)
2. La carpeta debe verse así:
```
mods/
├── fabric-api-0.91.0.jar
└── caostaotal-1.0.0.jar
```

### PASO 5️⃣: Verificar instalación

1. Abre **Minecraft Launcher**
2. Selecciona el perfil **Fabric**
3. Haz click en **Play**
4. En la pantalla de carga, busca este mensaje:
```
[MOD] ¡Iniciando Caos Total V3!
[MOD] Caos Total V3 cargado correctamente!
```

¡Si ves estos mensajes, ¡la instalación fue exitosa! ✅

---

## 🎮 CÓMO JUGAR

### Crear un Mundo

1. En el menú principal, haz click en **Singleplayer**
2. Haz click en **Create New World**
3. Configura según prefieras:
   - **Name**: Ej: "Caos Total Con Amigos"
   - **Game Mode**: Survival (recomendado)
   - **Difficulty**: Hard (para más caos)
   - **Allow Cheats**: Si (para comandos)

4. Haz click en **Create New World**
5. ¡Listo! Espera a que genere el mundo

### Primeras acciones

Al aparecer en el mundo:

1. **Obtén recursos básicos**
   - Mina madera para crafts básicos
   - Consigue carbón o usa flores para antorcha
   - Mina piedra para mejores herramientas

2. **Busca diamantes**
   - Cava hasta la altura Y: -30
   - Los diamantes son azules
   - Necesitarás pico de hierro mínimo

3. **Localiza a tus amigos**
   - Press `T` para chatear
   - Usa comandos: `/home set base` para marcar ubicación

---

## 🌍 ACCEDER A LA DIMENSIÓN DEL CAOS

### ¿Qué es la Dimensión del Caos?

Es un mundo alternativo dentro de Minecraft donde:
- ✨ Todo brilla misteriosamente
- 💎 Hay recursos valiosos (Diamante, Netherita)
- 💥 Los eventos caóticos son más frecuentes
- 👹 Los mobs son más fuertes
- ⚡ ¡Es PURO CAOS!

### Construcción del Portal

#### PASO 1: Consigue 9 Bloques de Diamante

```
Necesitas:
- 9 Bloques de Diamante (63 diamantes totales)
```

Para fabricar bloques de diamante:
1. Abre el inventario (Press `E`)
2. Ve a la pestaña de crafts
3. Craftea: 9 diamantes = 1 bloque de diamante
4. Repite 9 veces

#### PASO 2: Construye el Portal

En tu base, construye esta estructura:

```
Vista desde arriba (3x3):
    
    D D D
    D . D    (D = Diamante, . = Centro)
    D D D

Vista en 3D:
    ╔════════════════════╗
    ║ D D D              ║
    ║ D   D              ║
    ║ D D D              ║
    ╚════════════════════╝
```

**Instrucciones paso a paso:**

1. Encuentra un lugar plano
2. Coloca bloques de diamante en este patrón:
   ```
   Fila 1: Diamante, Diamante, Diamante
   Fila 2: Diamante, [VACÍO], Diamante  
   Fila 3: Diamante, Diamante, Diamante
   ```
3. El centro debe estar completamente vacío
4. Verifica que sea exactamente 3x3

**¡Deberías ver un efecto visual morado!** ✨

#### PASO 3: Craftea el Mechero del Caos

Receta:
```
Ingredientes:
- 1 Flint and Steel (sílex y acero)
- 1 Redstone Block (9 redstone)

En la mesa de crafts:
    [F&S] [ ] [RB]
    [ ]   [ ] [ ]
    [ ]   [ ] [ ]

Resultado: 1 Chaos Lighter (Mechero del Caos)
```

¿Dónde conseguir?
- **Flint and Steel**: Crafts básicos (sílex + acero)
- **Redstone Block**: 
  - Encuentra redstone en profundidad (Y: -40)
  - Craft: 9 redstone = 1 bloque redstone

#### PASO 4: Activa el Portal

1. Sostén el **Mechero del Caos** en tu mano
2. Haz click derecho en cualquier bloque de diamante del portal
3. Verás efectos especiales (fuego del alma)
4. ¡Se abrirá una puerta de luz!
5. Salta al centro del portal

**¡BIENVENIDO A LA DIMENSIÓN DEL CAOS!** ⚡

---

## 📦 ITEMS Y CRAFTEOS

### Items Principales

#### 1. 🔥 CHAOS LIGHTER (Mechero del Caos)

**Función**: Activa portales de diamante para entrar a la Dimensión del Caos

**Craft**:
```
Flint and Steel + Redstone Block = Chaos Lighter

En mesa de crafts:
    [F&S] [ ] [RB]
    [ ]   [ ] [ ]
    [ ]   [ ] [ ]
```

**Cómo usar**:
- Sostén en la mano
- Haz click derecho en portal de diamante
- ¡Teleportación activada!

---

#### 2. 💣 CHAOS GRENADE (Granada del Caos)

**Función**: Lanza una explosión devastadora

**Craft**:
```
TNT + Redstone + Diamante = Chaos Grenade

En mesa de crafts:
    [ ] [TNT] [ ]
    [RS] [ ] [D]
    [ ]  [ ] [ ]
```

**Ingredientes**:
- **TNT**: Crafts básicos (5 pólvora + 4 arena)
- **Redstone**: Mina en profundidad
- **Diamante**: Mina a Y: -59

**Cómo usar**:
- Click derecho para lanzar
- Explota al impactar
- Causa daño a jugadores y estructuras

---

#### 3. 🚀 ROCKET LAUNCHER (Lanzacohetes)

**Función**: Dispara cohetes explosivos potentes

**Craft**:
```
Hierro + Redstone + TNT = Rocket Launcher

En mesa de crafts:
    [ ] [I] [ ]
    [RS] [ ] [TNT]
    [ ]  [ ] [ ]
```

**Ingredientes**:
- **Hierro**: Abundante, mina en cualquier altura
- **Redstone**: Profundidad (Y: -40)
- **TNT**: Crafts básicos

**Munición**:
- Usa cohetes de fuegos artificiales como munición
- Crafts: Papel + pólvora + estrella de fuegos artificiales

---

#### 4. 💥 BAZOOKA (Bazuca)

**Función**: El arma más destructiva, causa explosiones enormes

**Craft**:
```
Hierro + Diamante + TNT = Bazooka

En mesa de crafts:
    [ ] [I] [ ]
    [D]  [ ] [TNT]
    [ ]  [ ] [ ]
```

**Ingredientes**:
- **Hierro**: Ubicuo
- **Diamante**: Profundidad (Y: -59)
- **TNT**: Crafts básicos

**Potencia**: 3x más fuerte que Granada del Caos

---

#### 5. 🎁 SURPRISE BOX (Caja Sorpresa)

**Función**: Abre y obtén items aleatorios

**Craft**:
```
Redstone + Hierro + Cofre = Surprise Box

En mesa de crafts:
    [ ] [RS] [ ]
    [I]  [ ] [I]
    [ ] [CHEST] [ ]
```

**Posibles contenidos**:
- TNT (frecuente)
- Wither (¡peligroso!)
- Creepers (¡peligroso!)
- Diamantes
- Netherita
- Armadura del Caos (¡raro!)

**Cómo usar**:
- Coloca en el piso
- Haz click derecho
- ¡Sorpresa! 🎉

---

### Armaduras y Accesorios

#### Armadura Antiexplosiones

**Función**: Te protege de daño por explosiones

**Craft**:
```
4 Bloques de Diamante = Armadura Antiexplosión

Para cada pieza:
- Casco: 5 diamantes
- Pechera: 8 diamantes
- Pantalones: 7 diamantes
- Botas: 4 diamantes
```

**Defensa**: 80% de resistencia a explosiones

---

## ⚙️ COMANDOS

### Comandos de Jugador

#### /home set <nombre>
Guarda tu ubicación actual como punto de spawn

```
Uso: /home set base
Resultado: ✓ Home 'base' guardado en X: 100, Y: 64, Z: -200

Máximo: 5 homes por jugador
```

#### /home <nombre>
Te teletransporta a tu home guardado

```
Uso: /home base
Resultado: ✓ Teletransportado a 'base'

Funciona desde cualquier dimensión
```

#### /home delete <nombre>
Elimina un home

```
Uso: /home delete base
Resultado: ✓ Home 'base' eliminado
```

#### /home list
Muestra todos tus homes guardados

```
Uso: /home list
Resultado: 
  Tus homes: base, arena, caos, spawn
  Total: 4/5 homes
```

---

### Comandos de Administrador (Nivel 2+)

> ⚠️ Nota: Solo el host del servidor puede usar estos

#### /caosadmin tntrain
¡LLUVIA DE TNT!

```
Uso: /caosadmin tntrain
Efecto: TNT cae del cielo durante 30 segundos
Daño: Alto
Diversión: ¡MÁXIMA!
```

#### /caosadmin invade
¡INVASIÓN DE MOBS!

```
Uso: /caosadmin invade
Efecto: Creepers y esqueletos aparecen alrededor
Dificultad: Alta
Recomendación: Agrúpense y usen armas
```

#### /caosadmin meteorite
¡METEORITOS CAYENDO!

```
Uso: /caosadmin meteorite
Efecto: Meteoritos destruyen el terreno
Daño: Extremo
Precaución: Busca refugio inmediatamente
```

#### /caosadmin summonking
¡REY CREEPER INVOCADO!

```
Uso: /caosadmin summonking
Efecto: Aparece el Rey Creeper (¡JEFE!)
Vida: 500 HP
Ataques: Explosión masiva, invoca mini-creepers
Dificultad: IMPOSIBLE solo
Consejo: Lucha en grupo con las mejores armas
```

---

## 🎯 ESTRATEGIAS DE JUEGO

### 🏆 OBJETIVO PRINCIPAL

**¡SER EL ÚLTIMO EN PIE EN LA DIMENSIÓN DEL CAOS!**

---

### 📍 Mapa Mental del Juego

```
MUNDO NORMAL
    ↓
  Portal de Diamante
    ↓
DIMENSIÓN DEL CAOS
    ├→ Plataformas de Netherita
    ├→ Diamantes abundantes
    ├→ TNT flotante
    ├→ Mobs potenciados
    └→ ¡CAOS TOTAL!
```

---

### 💡 ESTRATEGIA OFENSIVA (Ataque)

#### Fase 1: Recolección Rápida
```
Duración: 5-10 minutos

1. Crafts: Pico de piedra mínimo
2. Mina: Busca diamantes (Y: -59)
3. Mina: Busca redstone (Y: -40)
4. Mina: Busca hierro (cualquier altura)
5. Objetivo: 64 diamantes, 16 redstone, 32 hierro
```

#### Fase 2: Crafting de Armas
```
Duración: 3-5 minutos

Craftea PRIMERO:
- 2 Chaos Grenades
- 1 Rocket Launcher
- 1 Mechero del Caos

Guarda lo mejor para Dimensión del Caos
```

#### Fase 3: Preparación del Portal
```
Duración: 5 minutos

1. Recolecta 9 bloques de diamante
2. Construye portal 3x3
3. Activa con Mechero del Caos
```

#### Fase 4: Batalla en el Caos
```
Duración: ¡Indefinida!

TIPS OFENSIVOS:
- Usa Grenadas en grupos
- Lanza Rockets desde distancia
- No te acerques a Creepers
- Si ves el Rey Creeper, CORRE
- Usa la altura a tu favor (construye torres)
- Ataca de noche (menos visibilidad = ventaja)
```

---

### 🛡️ ESTRATEGIA DEFENSIVA (Defensa)

#### Fase 1: Base Segura
```
Ubicación: Lejos de otros jugadores

Construcción:
- Paredes de 5 bloques de altura
- Puerta con lava
- Armería con armas de respaldo
- Almacén de recursos
```

#### Fase 2: Provisiones
```
Necesario:
- 30 comida (carne, pan)
- 20 bloques de diamante
- 10 arcos + flechas
- 3 armaduras de diamante completas
- Pociones de regeneración
- Escudo de diamante
```

#### Fase 3: Fortificación
```
Defensa:
- Torre de vigilancia (15 bloques alto)
- Foso con agua
- Puertas de hierro
- Pared frontal con aspilleras
- Sala de spawn segura subterránea
```

#### Fase 4: Contraataque
```
TIPS DEFENSIVOS:
- Monitorea desde torres
- Avisa en chat sobre enemigos
- Usa arcos para atacar desde distancia
- No abandones la base en grupo
- Mantén vías de escape
- Si te rodean, retírate a túneles subterráneos
```

---

### 🎲 EVENTOS ALEATORIOS

Durante la sesión, pueden ocurrir:

#### ☔ LLUVIA DE TNT (Comandado)
```
Frecuencia: Cada 30-60 minutos
Duración: 30 segundos
Peligro: EXTREMO

QUÉ HACER:
✅ Busca refugio subterráneo
✅ Salta dentro de agua
✅ Usa Armadura Antiexplosión
❌ NO subas a estructuras altas
❌ NO quedes al descubierto
```

#### ⚔️ INVASIÓN DE MOBS (Comandado)
```
Frecuencia: Aleatorio
Duración: 3-5 minutos
Enemigos: Creepers, Esqueletos, Zombis potenciados
Peligro: ALTO

QUÉ HACER:
✅ Agrúpate con aliados
✅ Usa armas caóticas
✅ Busca terreno elevado
✅ Construye barricadas rápidas
❌ NO corras solo
❌ NO bajes la guardia
```

#### ☄️ METEORITOS (Comandado)
```
Frecuencia: Cada 45 minutos
Duración: 1 minuto
Daño: CATASTRÓFICO
Peligro: EXTREMO

QUÉ HACER:
✅ CORRE AL REFUGIO SUBTERRÁNEO
✅ Profundidad mínima 30 bloques
✅ Deja que pase
✅ Revisa si otros sobrevivieron
❌ NUNCA quedes en superficie
❌ NO intentes luchar
```

#### 👑 REY CREEPER (Comandado)
```
Vida: 500 HP (¡MASIVO!)
Ataques: 
  - Explosiones de área
  - Invoca mini-creepers
  - Teletransportación
Peligro: CASI IMPOSIBLE SOLO
Recompensa: Items legendarios

QUÉ HACER:
✅ AVISA EN CHAT AL VERLO
✅ Llama a todos los jugadores
✅ Únanse en grupo (mínimo 4 personas)
✅ Usa todas las armas caóticas
✅ Ataca desde distancia
✅ Si invoca mini-creepers, ignóralos
❌ NUNCA lo enfrentes solo
❌ NO te acerques sin armas
```

---

### 👥 DINÁMICAS DE GRUPO

#### Alianzas
```
VENTAJAS:
- Defensa mutua
- Compartir recursos
- Combate en grupo
- Diversión multiplicada

DESVENTAJA:
- El traidor es el más peligroso
- Recursos limitados para compartir
```

#### Competencia Amistosa
```
REGLAS SUGERIDAS:
- Muertes legales en combate
- No robar de cofres ajenos
- Avisar antes de atacar base
- Revancha en arena de PvP

PUNTUACIÓN:
- +1 punto por matar a jugador
- +2 puntos por derrotar Rey Creeper (grupo)
- +1 punto por supervivencia (30 minutos)
- -2 puntos por morir
```

#### Misiones Grupales
```
EJEMPLO 1: Misión de Recolección
- Objetivo: Conseguir 100 diamantes en grupo
- Tiempo: 30 minutos
- Recompensa: Acceso al cofre de tesoros

EJEMPLO 2: Defensa de Base
- Objetivo: Defender base contra ataque de mobs
- Duración: Lluvia de TNT + Invasión
- Recompensa: Armas nuevas
```

---

## 🐛 SOLUCIÓN DE PROBLEMAS

### El MOD no aparece en el juego

**Solución 1: Verifica la instalación**
```
1. Cierra Minecraft completamente
2. Abre la carpeta mods
3. Cuenta que esté:
   - fabric-api-*.jar ✓
   - caostaotal-1.0.0.jar ✓
4. Si falta algo, descárgalo nuevamente
5. Reinicia Minecraft
```

**Solución 2: Actualiza Fabric**
```
1. Descarga Fabric Installer 0.15.11+
2. Ejecuta el instalador
3. Selecciona Game Version: 1.21.1
4. Haz click Install Client
5. Confirma que actualiza correctamente
```

**Solución 3: Limpia caché**
```
Windows:
- Presiona WIN + R
- Escribe: %appdata%/.minecraft/
- Elimina carpeta "shaderpacks"
- Elimina carpeta "resourcepacks"
- Reinicia

Linux:
- rm -rf ~/.minecraft/shaderpacks
- rm -rf ~/.minecraft/resourcepacks
```

---

### El juego se congela al entrar a la Dimensión del Caos

**Causa**: Generación de chunks pesada

**Solución**:
```
1. Espera 2-3 minutos (está generando)
2. No presiones botones
3. Si no mejora después de 5 minutos:
   - Presiona ALT + F4
   - Reinicia el juego
   - Vuelve a intentar
4. Si persiste, reduce distancia de render:
   - Opciones > Gráficos > Distancia de Render: 8
```

---

### Error: "Cannot find Java 21"

**Solución**:
```
1. Descarga Java 21:
   - Visita: https://www.oracle.com/java/technologies/downloads/
   - Descarga JDK 21
   
2. Instala siguiendo las instrucciones

3. En Minecraft Launcher:
   - Presiona "Editar"
   - Ve a "Más opciones"
   - Ejecutable Java: Busca java.exe en carpeta de Java 21
   - Confirma
```

---

### El portal no se activa

**Causas y soluciones**:

**Causa 1: Portal no es 3x3 exacto**
```
Solución:
- Destruye y reconstruye
- Verifica: 3 bloques ancho, 3 bloques largo
- Centro debe estar vacío
```

**Causa 2: No tienes Mechero del Caos**
```
Solución:
- Crafts: Flint and Steel + Redstone Block
- Verifica que esté en tu inventario
- Sostén en la mano (no en hotbar)
```

**Causa 3: No estás en el bloque de diamante**
```
Solución:
- Haz click derecho EN los bloques
- No en el aire del centro
- Debe escuchar sonido de activación
```

---

### El servidor es muy lento

**Soluciones de rendimiento**:

```
1. Reduce distancia de render:
   Opciones > Gráficos > Distancia de Render: 6-8

2. Reduce partículas:
   Opciones > Gráficos > Partículas: Mínimo

3. Apaga smoothing:
   Opciones > Gráficos > Smooth Lighting: OFF

4. Cierra otros programas pesados

5. Si todo falla, reinicia el servidor
```

---

### ¿Por qué muero por nada?

**Respuestas**:
```
✓ Eventos aleatorios activos (lluvia TNT, meteoritos)
✓ Rey Creeper cercano
✓ Otro jugador te atacó
✓ Caíste al vacío en Dimensión del Caos
✓ ¡Es parte del CAOS! 😄
```

---

## 📊 ESTADÍSTICAS Y LOGROS

### Sistema de Contador de Muertes

El juego registra cuántas veces ha muerto cada jugador:

```
Ver contador:
- Aparece en el chat al morir
- Se guarda en servidor
- Se resetea con comando admin
```

### Logros Sugeridos

Crea tus propios objetivos:

```
🥇 LOGRO ORO: Sobrevivir 1 hora en Dimensión del Caos
🥈 LOGRO PLATA: Derrotar Rey Creeper con grupo
🥉 LOGRO BRONCE: Conseguir todas las armas caóticas

RETO EXTREMO: Permanecer 30 minutos en modo supervivencia contra mobs
RETO IMPOSIBLE: Derrotar Rey Creeper solo
```

---

## 🎬 EJEMPLO DE SESIÓN DE JUEGO

### Hora 0:00 - Inicio

```
Feyonor se conecta
"Hola! A jugar Caos Total V3 😎"

Juan se conecta
"Yo voy! Necesito diamantes"

María se conecta
"¡Vamos a construir una base!"
```

### Hora 0:15 - Recolección

```
Feyonor: "Encontré 15 diamantes!"
Juan: "Yo tengo redstone abundante"
María: "¿Ayuda con la base? Necesito hierro"

[Trabajan juntos minando]
```

### Hora 0:30 - Preparación del Portal

```
Feyonor: "¡Ya tengo 9 bloques de diamante!"
Juan: "¡Yo también! Construyamos el portal"
María: "¡Esperen! Voy con provisiones"

[Construyen portal 3x3 juntos]
```

### Hora 0:45 - Activación

```
Feyonor: "¡Mechero del Caos listo!"
Juan: "¡Actívalo!"

[Se escucha sonido épico de portal]

María: "¡¡VAMOS!!"

[Se teletransportan al Caos]
```

### Hora 1:00 - Exploración del Caos

```
Feyonor: "¡INCREÍBLE! Miren eso! 🤯"
Juan: "Hay diamantes EVERYWHERE"
María: "¡Plataformas flotantes! ¡BELLAS!"

[Minando y explorando]
```

### Hora 1:30 - Primer Evento

```
[LLUVIA DE TNT COMIENZA]

Feyonor: "¡¡¡CORRE!!!"
Juan: "¿¿¿QUÉ????"
María: "¡¡AL REFUGIO!!"

[Se refugian bajo tierra]

[Terminan de explorar después]
```

### Hora 2:00 - Combate PvP

```
Feyonor: "¿Y si luchamos por los últimos diamantes?"
Juan: "¡VAS! ¡Tengo Grenades!"
María: "¡¡Batalla 1v1!!"

[Batalla épica de 20 minutos]

Feyonor gana: "¡¡¡CAMPEÓN!!!"
Juan: "Rematch rematch!"
María: "¡Alguien videos!"
```

### Hora 2:30 - Rey Creeper

```
Feyonor: "¿Vieron ese mob gigante?"
Juan: "¡¡¡ESO ES EL REY CREEPER!!!"
María: "¡¡¡TODOS JUNTOS!!!"

[30 minutos de batalla épica]

[Lo derrotan juntos]

"¡¡¡GANAMOS!!! 🏆"
"¡Mejor sesión ever!"
"¿Mañana más?"
```

---

## 📞 CONTACTO Y SOPORTE

### Si tienes problemas:

1. **Revisa este manual** (99% de respuestas están aquí)

2. **GitHub Issues**: 
   - https://github.com/Feyonor/CaosTotalV3/issues

3. **Discord del Servidor**:
   - Próximamente

4. **Email de Soporte**:
   - feyonor@minecraft.dev (temporal)

---

## 🎉 TIPS FINALES PARA DIVERSIÓN MÁXIMA

1. **Graba video**: Tu primera batalla en el Caos
2. **Crea desafíos**: "¿Quién sobrevive más?"
3. **Team up**: Las alianzas hacen el juego mejor
4. **Construye épico**: No solo mina, construye
5. **Broma amistosa**: Activa lluvia de TNT por sorpresa
6. **Celebra victorias**: El Rey Creeper merece una fiesta
7. **Experimenta**: Prueba nuevas estrategias
8. **Disfruta**: ¡Es solo un juego para pasarlo bien!

---

## 📋 CHECKLIST PRE-JUEGO

Antes de empezar, verifica:

- ✅ Java 21 instalado
- ✅ Minecraft 1.21.1
- ✅ Fabric 0.15.11+
- ✅ Fabric API descargado
- ✅ Caos Total V3 JAR en mods/
- ✅ Mundo creado en Survival
- ✅ Allow Cheats: ON (para comandos)
- ✅ Amigos listos
- ✅ Micrófono/Chat preparado
- ✅ ¡DIVERSIÓN MÁXIMA GARANTIZADA! 🎮

---

## 🚀 ¡A JUGAR!

```
¡¡¡ BIENVENIDO A CAOS TOTAL V3 !!!

Recuerda:
- El caos es impredecible
- La diversión es la prioridad
- Juega en equipo
- Domina la Dimensión del Caos
- ¡SÉ LEYENDA!

¡QUE COMIENCE EL CAOS! ⚡💥🔥
```

---

**Manual hecho con ❤️ por Feyonor**  
**Última versión: 24/08/2026**  
**Para Caos Total V3 - Versión 1.0.0**

````
