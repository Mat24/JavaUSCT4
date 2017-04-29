package DAOs;

import app.ConectorDB;
import pojos.Ciudad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by laptop-server on 22/04/17.
 */
public class CiudadesDAO
{
    public static Collection<Ciudad> findAll() {
        //Creo las variables necesarias para interactuar con el API de JDBC mediante las interfaces (Connection,PreparedStatement,ResultSet)
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        // Este proceso puede tener fallas en su ejecucion, por eso se obliga a implementarlo en un try..catch
        try {
            //Obtengo la conexion con la base de datos
            con = ConectorDB.getConection();
            String query = "SELECT codigo,nombre FROM db_avanzadas.Ciudad;";
            //
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            // Creo una coleccion de la entidad que necesito
            Vector<Ciudad> ret = new Vector<Ciudad>();
            // creo una variable del la clase que necesito para poder asignar dinamicamente los valores obtenidos por la consulta
            Ciudad tmp = null;
            while (rs.next()) { //Mientras existan registros obtenidos por la consulta...
                tmp = new Ciudad();
                tmp.setCodigo(rs.getLong("codigo"));
                tmp.setNombre(rs.getString("nombre"));
                // Agrego el objeto previamente seteado a mi coleccion generica
                ret.add(tmp);
            }
            return ret;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
