package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongo {
    private static final String URI = "mongodb://localhost:27017";
    private static final String NOMBRE_DB = "testdb";
    private static MongoClient cliente = null;

    private ConexionMongo() {
        // Constructor privado para evitar que se creen objetos
    }

    public static MongoDatabase obtenerBaseDatos() {
        if (cliente == null) {
            cliente = MongoClients.create(URI);
        }
        return cliente.getDatabase(NOMBRE_DB);
    }
}

