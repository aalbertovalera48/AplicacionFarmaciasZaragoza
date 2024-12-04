# Aplicacion-Farmacias-Zaragoza

Aplicacion-Farmacias-Zaragoza es una aplicación de Android que muestra una lista de farmacias y sus ubicaciones en un mapa utilizando OpenStreetMap (OSMDroid) y Firebase para el almacenamiento de datos.

## Clases y Métodos Importantes

### `MainActivity`

La actividad principal de la aplicación que muestra una lista de farmacias y un botón para ver el mapa.

- `onCreate(Bundle?)`: Inicializa la actividad, configura el RecyclerView y obtiene la lista de farmacias desde Firebase.

### `MapaActivity`

Una actividad que muestra el mapa con marcadores para cada farmacia.

- `onCreate(Bundle?)`: Inicializa la actividad, configura el mapa y muestra las farmacias en el mapa.
- `mostrarFarmaciasEnMapa(List<Farmacia>)`: Agrega marcadores al mapa para cada farmacia en la lista.

### `Farmacia`

Una clase de datos que representa una farmacia.

- `nombre`: El nombre de la farmacia.
- `telefono`: El número de teléfono de la farmacia.
- `latitud`: La latitud de la ubicación de la farmacia.
- `longitud`: La longitud de la ubicación de la farmacia.

### `FarmaciaAdapter`

Un adaptador para mostrar la lista de farmacias en un RecyclerView.

- `submitList(List<Farmacia>)`: Actualiza la lista de farmacias mostrada por el adaptador.
- `onCreateViewHolder(ViewGroup, int)`: Infla el diseño para cada elemento en la lista.
- `onBindViewHolder(FarmaciaViewHolder, int)`: Vincula los datos a cada elemento en la lista.

### `FirebaseHelper`

Una clase auxiliar para interactuar con Firebase y obtener la lista de farmacias.

- `obtenerFarmacias((List<Farmacia>) -> Unit)`: Obtiene la lista de farmacias desde Firebase y la pasa al callback proporcionado.

## Dependencias

- OSMDroid: Para mostrar el mapa.
- Firebase: Para almacenar y recuperar la lista de farmacias.
- Gson: Para convertir objetos a JSON y viceversa.
