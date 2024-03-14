# Laboratorio 6: PATRONES ARQUITECTURALES

Se ha desarrollado una aplicación web utilizando el micro-framework Spark Java, que incluye un cliente web, un servicio REST y un servicio MongoDB. Para cada componente, se han creado contenedores de Docker. El servicio REST implementa un algoritmo de balanceo de carga Round Robin, distribuyendo las solicitudes entre tres instancias del servicio LogService.

## Primeros Pasos

### PREREQUISITOS

* [Java (desde la 17 para delante)](https://www.oracle.com/co/java/technologies/downloads/) 
* [Maven](https://maven.apache.org/download.cgi) 
* [Git](https://git-scm.com/downloads)
* [Docker Desktop](https://www.docker.com/products/docker-desktop/)

### Instalar y crear las imágenes.

1. Asegúrate de tener Docker instalado en su máquina y que se esté ejecutando.
2. Clona el repositorio:
    ```
    git clone https://github.com/FDanielMC/AREP_LAB-6.git
    ```
3. Ve a la carpeta del proyecto donde clonaste el repositorio:
    ```
    cd AREP_LAB-6
    ```
4. Construye el proyecto usando Maven:
    ```
    mvn clean install 
    ```
5. Arranca los servicios definidos en el archivo docker-compose.yml con:
    ```
    docker-compose up -d
    ```
6. Verifica que las imágenes se haya creado correctamente ejecutando el siguiente comando:
    ```
    docker images
    ```
![image](https://github.com/FDanielMC/AREP_LAB-6/assets/123689924/e963c935-9b7d-4a93-b276-a15c58a95b30)

7. De igual forma, asegúrate que los contenedores estén corriendo:
    ```
    docker ps
    ```
![image](https://github.com/FDanielMC/AREP_LAB-6/assets/123689924/1abbb028-adea-467d-989a-721c3618a4f4)

8. Abre un navegador web y accede a la aplicación en http://localhost:38000/phrases.html.
