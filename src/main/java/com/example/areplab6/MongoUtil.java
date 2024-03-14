package com.example.areplab6;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Esta clase ofrece funciones estáticas para la interacción con una base de datos de MongoDB. Se encarga de establecer
 * una conexión a la base de datos utilizando la cadena de conexión y el nombre de la base de datos que se han especificado.
 *
 * @author Daniel Fernando Moreno Cerón
 * @version 1.0
 */
public class MongoUtil {
    private static final String CONNECTION_STRING = "mongodb://MongoDB:27017";
    private static final String DATABASE_NAME = "Lab6DB";

    /**
     * Obtiene una conexión a la base de datos de MongoDB.
     *
     * @return Una conexión a la base de datos de MongoDB.
     */
    public static MongoDatabase getDB() {
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        return client.getDatabase(DATABASE_NAME);
    }
}
