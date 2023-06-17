# Building project
app-loader -> app para la gestión y que se auto actualice del GIT
Para lanzar / debugear la aplicación ejecutamos AppLoader.java en appLoader


tft-overlay-core -> app en cuestión
Para lanzar / debugear la aplicación ejecutamos Application.java en tft-overlay-core
Para generar el artefacto ->
File - project structure -> Artifacts -> + -> JAR -> tft-overlay-core:jar    
   -> C:\00PortablesBasicos\tft-overlay-application\tft-overlay-application-source\out\artifacts\tft_overlay_core_jar
Vamos a Build -> Build Artifacts -> tft-overlay-core:jar -> Build
Si queremos generar otro, asegurarse borrar el anterior primero para prevenir
Este JAR lo copiaremos al zip de bin/tft-overlay-core.zip


/bin es la carpeta release, de ahi se descargará la aplicación comprobando la versión en el fichero /bin/version.txt


# Overlay made for Teamfight Tactics.
- It helps you with item building and meta comps without having to alt tab or check a second monitor.
- It's made with hover because if you click you would have fps drops since you would be changing applications
- It also self-update so you don't have to bother doing so.

![img1](https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/readme-img/app-img.png)

![img1](https://raw.githubusercontent.com/kotololeuw/tft-overlay-app/master/readme-img/app-img-2.png)
