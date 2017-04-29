package DAOs;

import app.ConectorDB;
import app.Nomina;
import pojos.Ciudad;
import pojos.Nominanorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by laptop-server on 22/04/17.
 */
public class NominaNormDAO
{
    public static Collection<Nominanorm> findAll() {
        //Creo las variables necesarias para interactuar con el API de JDBC mediante las interfaces (Connection,PreparedStatement,ResultSet)
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        // Este proceso puede tener fallas en su ejecucion, por eso se obliga a implementarlo en un try..catch
        try {
            //Obtengo la conexion con la base de datos
            con = ConectorDB.getConection();
            String query = "SELECT * FROM db_avanzadas.NominaNorm;";
            //
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            // Creo una coleccion de la entidad que necesito
            Vector<Nominanorm> ret = new Vector<Nominanorm>();
            // creo una variable del la clase que necesito para poder asignar dinamicamente los valores obtenidos por la consulta
            Nominanorm tmp = null;
            while (rs.next()) { //Mientras existan registros obtenidos por la consulta...
                tmp = new Nominanorm();
                tmp.setCodigo(rs.getLong("codigo"));
                tmp.setNombre1(rs.getString("nombre1"));
                tmp.setNombre2(rs.getString("nombre2"));
                tmp.setApellido1(rs.getString("apellido1"));
                tmp.setApellido2(rs.getString("apellido2"));
                tmp.setTiposangre(rs.getString("tipoSangre"));
                tmp.setAltura(rs.getDouble("altura"));
                tmp.setPeso(rs.getDouble("peso"));
                tmp.setNumerocalzado(rs.getDouble("numeroCalzado"));
                tmp.setFechanace(rs.getTimestamp("fechaNace"));
                tmp.setZurdodiestro(rs.getString("zurdoDiestro"));
                tmp.setCiudadid(rs.getLong("ciudadId"));
                tmp.setColorojosid(rs.getLong("colorOjosId"));
                tmp.setEstadocivilid(rs.getLong("estadoCivilId"));
                tmp.setEpsid(rs.getLong("EPSId"));
                tmp.setFondopensionid(rs.getLong("fondoPensionId"));
                tmp.setProfesionid(rs.getLong("profesionId"));
                tmp.setDivisionid(rs.getLong("divisionId"));
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

    public static Nominanorm create(Nominanorm nuevo) {
        try {
            Connection con = ConectorDB.getConection();
            PreparedStatement pstm = null;
            String query = "INSERT INTO db_avanzadas.NominaNorm " +
                    "(codigo, nombre1, nombre2, apellido1, apellido2, tiposangre, altura," +
                    " peso, numerocalzado, fechanace, zurdodiestro, ciudadid, colorojosid," +
                    " estadocivilid, epsid, fondopensionid, profesionid, divisionid)" +
                    "    VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            pstm = con.prepareStatement(query);
            pstm.setLong(1, nuevo.getCodigo());
            pstm.setString(2,nuevo.getNombre1());
            pstm.setString(3,nuevo.getNombre2());
            pstm.setString(4,nuevo.getApellido1());
            pstm.setString(5,nuevo.getApellido2());
            pstm.setString(6,nuevo.getTiposangre());
            pstm.setDouble(7,nuevo.getAltura());
            pstm.setDouble(8,nuevo.getPeso());
            pstm.setDouble(9,nuevo.getNumerocalzado());
            pstm.setTimestamp(10,nuevo.getFechanace());
            pstm.setString(11,nuevo.getZurdodiestro());
            pstm.setLong(12,nuevo.getCiudadid());
            pstm.setLong(13,nuevo.getColorojosid());
            pstm.setLong(14,nuevo.getEstadocivilid());
            pstm.setLong(15,nuevo.getEpsid());
            pstm.setLong(16,nuevo.getFondopensionid());
            pstm.setLong(17,nuevo.getProfesionid());
            pstm.setLong(18,nuevo.getDivisionid());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Retorno el nuevo Objeto buscado directamente desde la DB
        return findbyObject(nuevo);
    }

    public static Nominanorm update(Nominanorm actualizar) {
        try {
            Connection con = ConectorDB.getConection();
            PreparedStatement pstm = null;
            String query = "UPDATE db_avanzadas.NominaNorm SET nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, tiposangre = ?, altura=?, peso=?, numerocalzado=?, fechanace = ?, zurdodiestro = ?, ciudadid = ?, colorojosid = ?, estadocivilid = ?, epsid = ?, fondopensionid = ?, profesionid = ?, divisionid = ?" +
                    " WHERE codigo = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1,actualizar.getNombre1());
            pstm.setString(2,actualizar.getNombre2());
            pstm.setString(3,actualizar.getApellido1());
            pstm.setString(4,actualizar.getApellido2());
            pstm.setString(5,actualizar.getTiposangre());
            pstm.setDouble(6,actualizar.getAltura());
            pstm.setDouble(7,actualizar.getPeso());
            pstm.setDouble(8,actualizar.getNumerocalzado());
            pstm.setTimestamp(9,actualizar.getFechanace());
            pstm.setString(10,actualizar.getZurdodiestro());
            pstm.setLong(11,actualizar.getCiudadid());
            pstm.setLong(12,actualizar.getColorojosid());
            pstm.setLong(13,actualizar.getEstadocivilid());
            pstm.setLong(14,actualizar.getEpsid());
            pstm.setLong(15,actualizar.getFondopensionid());
            pstm.setLong(16,actualizar.getProfesionid());
            pstm.setLong(17,actualizar.getDivisionid());
            pstm.setLong(18,actualizar.getCodigo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Retorno el Objeto actualizado, buscadolo directamente desde la DB
        return findbyObject(actualizar);
    }

    public static Nominanorm findbyObject(Nominanorm objeto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Nominanorm tmp = new Nominanorm();
        try {
            con = ConectorDB.getConection();
            String query = "SELECT codigo, nombre1, nombre2, apellido1, apellido2, tiposangre," +
                    " altura, peso, numerocalzado, fechanace, zurdodiestro, ciudadid, colorojosid," +
                    " estadocivilid, epsid, fondopensionid, profesionid, divisionid" +
                    " FROM db_avanzadas.NominaNorm" +
                    " WHERE codigo = ?";
            pstm = con.prepareStatement(query);
            pstm.setLong(1, objeto.getCodigo());
            rs = pstm.executeQuery();
            while (rs.next()) {
                tmp.setCodigo(rs.getLong("codigo"));
                tmp.setNombre1(rs.getString("nombre1"));
                tmp.setNombre2(rs.getString("nombre2"));
                tmp.setApellido1(rs.getString("apellido1"));
                tmp.setApellido2(rs.getString("apellido2"));
                tmp.setTiposangre(rs.getString("tipoSangre"));
                tmp.setAltura(rs.getDouble("altura"));
                tmp.setPeso(rs.getDouble("peso"));
                tmp.setNumerocalzado(rs.getDouble("numeroCalzado"));
                tmp.setFechanace(rs.getTimestamp("fechaNace"));
                tmp.setZurdodiestro(rs.getString("zurdoDiestro"));
                tmp.setCiudadid(rs.getLong("ciudadId"));
                tmp.setColorojosid(rs.getLong("colorOjosId"));
                tmp.setEstadocivilid(rs.getLong("estadoCivilId"));
                tmp.setEpsid(rs.getLong("EPSId"));
                tmp.setFondopensionid(rs.getLong("fondoPensionId"));
                tmp.setProfesionid(rs.getLong("profesionId"));
                tmp.setDivisionid(rs.getLong("divisionId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public static Nominanorm delete(Nominanorm objeto) {
        Connection con = ConectorDB.getConection();
        PreparedStatement pstm = null;
        Nominanorm objetoSeguro = findbyObject(objeto);
        try {
            String query = "DELETE FROM db_avanzadas.NominaNorm WHERE codigo = ?;";
            pstm = con.prepareStatement(query);
            pstm.setLong(1, objetoSeguro.getCodigo());
            pstm.executeUpdate();
            return objetoSeguro;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Significa que ocurrio un error
        return null;
    }
}


