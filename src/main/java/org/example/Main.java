package org.example;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // Crear
        dao.crearUsuario(new Usuario(null, "Ana", 30));

        // Leer
        dao.obtenerUsuarios().forEach(u ->
                System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getEdad())
        );

        // Actualizar (reemplaza con un ID real)
        // dao.actualizarUsuario("ID_AQUI", "Ana María", 31);

        // Eliminar (reemplaza con un ID real)
        // dao.eliminarUsuario("ID_AQUI");
    }
}
