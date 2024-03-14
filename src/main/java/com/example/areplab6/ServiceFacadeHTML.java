package com.example.areplab6;

import static spark.Spark.*;

/**
 * Esta clase simplifica el acceso a varios servicios remotos de registro, distribuyendo las solicitudes entre ellos usando
 * URLs proporcionadas en el entorno.
 * @author Daniel Fernando Moreno Cerón
 * @version 1.0
 */
public class ServiceFacadeHTML {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        String[] logServices = getLogServicesURLS(System.getenv("LOG_SERVICES").split(";"));
        RLSInvoker invoker = new RLSInvoker(logServices);
        staticFiles.location("/public");
        port(getPort());
        get("/logservicefacade", (req, res) -> {
            res.type("application/json");
            System.out.println(req.queryParams("msg"));
            return invoker.invoke(req.queryParams("msg").replace(" ", "%20"));
        });
    }

    /**
     * Obtiene el puerto en el que se ejecutará el servidor web local.
     *
     * @return El puerto en el que se ejecutará el servidor web local.
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) return Integer.parseInt(System.getenv("PORT"));
        return 4567;
    }

    /**
     * Obtiene las URLs de los servicios de registro remotos.
     *
     * @param logServices Lista de nombres de los servicios de registro remotos.
     * @return Las URLs de cada servicio de registro remoto.
     */
    public static String[] getLogServicesURLS(String[] logServices) {
        String[] logServicesURLS = new String[logServices.length];
        for (int i = 0; i < logServicesURLS.length; i++) {
            logServicesURLS[i] = "http://" + logServices[i] + ":35000/logservice?msg=";
        }
        return logServicesURLS;
    }
}
