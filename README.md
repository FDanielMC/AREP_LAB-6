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

### EJECUTAR PRUEBAS

Para ejecutar las pruebas ingrese el siguiente comando en la línea de comandos:
```
mvn test
```

## ARQUITECTURA

La aplicación web está compuesta por tres servicios: ServiceFacadeHTML, LogService y MongoDB. 
* **ServiceFacadeHTML:** La aplicación consta de un cliente web y un servicio REST. El cliente web presenta un campo de entrada y un botón. Cada vez que el usuario envía un mensaje, este se transmite al servicio REST. El servicio REST, a su vez, emplea un algoritmo de balanceo de carga Round Robin, delegando el procesamiento del mensaje y la respuesta a cada una de las tres instancias del servicio LogService. 
* **LogService:** Este servicio REST recibe una cadena, la guarda en la base de datos MongoDB y devuelve un objeto JSON con las 10 últimas cadenas guardadas junto con la fecha en que fueron almacenadas.
* **MongoDB:** Es una instancia de MongoDB que opera dentro de un contenedor Docker en una máquina virtual de EC2.

La interfaz de usuario web permite al usuario ingresar un mensaje y visualizar los últimos 10 mensajes almacenados en la base de datos. Esta interfaz se comunica con el servicio REST ServiceFacadeHTML a través de una conexión HTTP.

En resumen, la arquitectura del taller incluye una aplicación web que emplea un algoritmo de balanceo de carga Round Robin para distribuir las solicitudes entre tres instancias de un servicio REST. Este servicio, a su vez, se conecta a una base de datos MongoDB. La aplicación web se despliega en un contenedor Docker dentro de una instancia EC2 en AWS, con un balanceador de carga Round Robin para manejar el tráfico de Internet.

## Casos de Prueba

### Vídeo Desplegando el Programa

[![Video de YouTube](https://github.com/FDanielMC/AREP_LAB-6/assets/123689924/c01454fa-eb15-4988-98c9-fadc24a3b4d3)
](https://youtu.be/4f9CwJMC-M8)

## Authors

* Daniel Fernando Moreno Cerón
