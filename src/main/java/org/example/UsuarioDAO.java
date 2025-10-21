package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final MongoCollection<Document> coleccion;

    public UsuarioDAO() {
        MongoDatabase db = ConexionMongo.obtenerBaseDatos();
        coleccion = db.getCollection("usuarios");
    }

    public void crearUsuario(Usuario usuario) {
        Document doc = new Document("nombre", usuario.getNombre())
                .append("edad", usuario.getEdad());
        coleccion.insertOne(doc);
        System.out.println("Usuario creado con ID: " + doc.getObjectId("_id"));
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            lista.add(new Usuario(
                    doc.getObjectId("_id").toHexString(),
                    doc.getString("nombre"),
                    doc.getInteger("edad")
            ));
        }
        return lista;
    }

    public void actualizarUsuario(String id, String nuevoNombre, int nuevaEdad) {
        coleccion.updateOne(
                new Document("_id", new ObjectId(id)),
                new Document("$set", new Document("nombre", nuevoNombre).append("edad", nuevaEdad))
        );
        System.out.println("Usuario actualizado.");
    }

    public void eliminarUsuario(String id) {
        coleccion.deleteOne(new Document("_id", new ObjectId(id)));
        System.out.println("Usuario eliminado.");
    }
}

