# intellij
Le daremos a abrir la ruta /tft-overlay-application-source - sino vemos las carpetas hacemos ->
File -> Project Structure -> Modules -> + -> Import module -> C:\00PortablesBasicos\tft-overlay-application\tft-overlay-application-source\tft-overlay-core
File -> Project Structure -> Modules -> + -> Import module -> C:\00PortablesBasicos\tft-overlay-application\tft-overlay-application-source\appLoader

Ir a File -> Project Structure -> Modules -> y marcar ->
Module -> tft-overlay-core -> src -> main -> java
Resources -> tft-overlay-core -> src -> main -> resources 
Module -> appLoader -> src -> main -> java 
Resources -> appLoader -> src -> main -> -> resources

# app-loader
app-loader -> app para la gestión y que se auto actualice del GIT
Para lanzar / debugear la aplicación ejecutamos AppLoader.java en appLoader
Para generar el artefacto ->
File - project structure -> Artifacts -> + -> JAR -> appLoader:jar    
-> C:\00PortablesBasicos\tft-overlay-application\tft-overlay-application-source\out\artifacts\appLoader_jar
Vamos a Build -> Build Artifacts -> appLoader:jar -> Build
Si queremos generar otro, asegurarse de borrar la carpeta /out antes para evitar posibles problemas

# tft-overlay-core
tft-overlay-core -> el core de la aplicacion
iconos de tamaño 64 x 64
Para lanzar / debugear la aplicación ejecutamos Application.java en tft-overlay-core
Para generar el artefacto ->
File - project structure -> Artifacts -> + -> JAR -> tft-overlay-core:jar    
   -> C:\00PortablesBasicos\tft-overlay-application\tft-overlay-application-source\out\artifacts\tft_overlay_core_jar
Vamos a Build -> Build Artifacts -> tft-overlay-core:jar -> Build
Si queremos generar otro, asegurarse borrar el anterior primero para prevenir

# Forma de crear ejecutable de app-loader
1- Debemos descargar una JRE de java 1.8 como minimo.
2- Lo bundleamos a mano creando un zip con la estructura
/appLoader
/appLoader/jre1.8.0_201/bin
/appLoader/jre1.8.0_201/lib
/appLoader/appLoader.jar
/appLoader/launch.bat     ->      
jre1.8.0_201\bin\java.exe -jar appLoader.jar (si queremos podemos añadir el comando "pause" en el bat para que se pare y ver que ha lanzado)

# Forma de actualizar el core
1- Debemos descargar una JRE de java 1.8 como minimo.
2- Lo bundleamos a mano creando un zip con la estructura
/tft-overlay-app
/tft-overlay-app/jre1.8.0_201/bin
/tft-overlay-app/jre1.8.0_201/lib
/tft-overlay-app/tft-overlay-core.jar
/tft-overlay-app/launch.bat     ->  
start %LOCALAPPDATA%\tft-overlay-app\tft-overlay-app\jre1.8.0_201\bin\javaw.exe -jar %LOCALAPPDATA%\tft-overlay-app\tft-overlay-app\tft-overlay-core.jar
exit
The javaw command is identical to java, except that javaw has no associated console window.

# release
/tft-overlay-app/release es la carpeta release, de ahi se descargará la aplicación comprobando la versión en el fichero /release/version.txt
el fichero .zip es la aplicacion tft-overlay-core, pero a nivel usuario debemos lanzar appLoader ya que es la que gestiona las versiones

# Overlay made for Teamfight Tactics.
- It helps you with item building and meta comps without having to alt tab or check a second monitor.
- It's made with hover because if you click you would have fps drops since you would be changing applications
- It also self-update so you don't have to bother doing so.

![img1](https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/readme-img/app-img.png)

![img1](https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/readme-img/app-img-2.png)
