# WildLife2
 Proyecto Java con HTML, CSS y Conexión a MySQL
## Descripción
El proyecto “WildLife2” tiene como objetivo desarrollar una página web para el refugio de animales “WildLife”. En este refugio, nos enfocaremos en rescatar y cuidar a perros, gatos, tortugas, cabras y alpacas. La aplicación web permitirá gestionar la información de los animales y facilitar su adopción.

## Funcionalidades del Formulario CRUD

- **Registro de Entrada de Animales**:
    Los usuarios podrán registrar la entrada de un nuevo animal al refugio. Deberán proporcionar detalles como el nombre, peso, edad y especie del animal.

- **Dar de Baja un Animal**:
    Cuando un animal encuentre una nueva familia de acogida, se podrá dar de baja en el sistema. Esto actualizará su estado y lo marcará como adoptado.

- **Modificación de Datos de Animales Registrados**:
    Los administradores podrán modificar la información de los animales ya registrados. Por ejemplo, actualizar su peso, edad o especie.

## Estructura de la Base de Datos "bd_wild_life"

### Tabla "Animales"
- `id`: Identificador único del animal.
- `nombre`: Nombre del animal.
- `peso`: Peso del animal.
- `edad`: Edad del animal.
- `FK_especie`: Clave foránea que relaciona al animal con su especie correspondiente.

### Tabla "Especies"
- `id`: Identificador único de la especie.
- `especie`: Nombre de la especie (por ejemplo, "Perro", "Gato", "Tortuga", etc.).
