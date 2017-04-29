package app;
// Librerias necesarias para gestion de conexion con la DB
import java.sql.Connection;
import java.sql.DriverManager;
// Importo resourceBundle para poder cargar archivos de configuracion
import java.util.ResourceBundle;


/**
 *
 * @author server-laptop
 */
public class ConectorDB {

    private static Connection con = null;
    public static Connection getConection() {
        try {
            // Si no existe un objeto con, significa que aun no se ha establecido
            // conexion con la DB, entonces prepara el programa para crear uno
            if(con == null) {
                // Enlazamos a la rutina del programa un evento personalizado para el cierre de la maquina virtual
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());

                // Traemos el archivo de configuracion gracias a la clase ResourceBundle
                ResourceBundle rb = ResourceBundle.getBundle("jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String password = rb.getString("password");
                String user = rb.getString("user");

                // Cargo la clase del driver
                Class.forName(driver);
                //asigno la conexion a la variable de clase que me servira de consulta en este mismo metodo
                con = DriverManager.getConnection(url, user, password);
            }
            return con;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexion con la DB", ex);
        }
    }

    static class MiShDwnHook extends Thread {
        // Justo antes de finalizar el programa, la maquiva virtual de java,
        // invocara este metodo que finalizara la conexion
        public void run() {
            try {
                Connection con = ConectorDB.getConection();
                con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }

}
