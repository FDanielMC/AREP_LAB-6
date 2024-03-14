package com.example.areplab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Esta clase facilita la invocación de servicios de registro remotos mediante una lista de URLs. Utiliza un método
 * round-robin para distribuir las solicitudes entre estos servicios.
 *
 * @author Daniel Fernando Moreno Cerón
 * @version 1.0
 */
public class RLSInvoker {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String[] get_URL = null;
    private static int instancia = 0;

    /**
     * Genera un nuevo objeto RemoteLogServiceInvoker utilizando la lista de URLs de los servicios de registro.
     *
     * @param invokerUrls Lista de URLs de los servicios de registro.
     */
    public RLSInvoker(String[] invokerUrls) {
        get_URL = invokerUrls;
    }

    /**
     * Invoca un servicio de registro con el mensaje especificado.
     *
     * @param msg Mensaje a registrar.
     * @return Respuesta del servicio de registro.
     * @throws IOException Si ocurre un error al realizar la solicitud HTTP.
     */
    public static String invoke(String msg) throws IOException {
        URL obj = new URL(get_URL[instancia] + msg);
        if (instancia == get_URL.length - 1) instancia = 0;
        else instancia++;
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) response.append(inputLine);
            in.close();
        } else System.out.println("GET request not worked");
        System.out.println(response);
        System.out.println("GET DONE");
        return response.toString();
    }
}