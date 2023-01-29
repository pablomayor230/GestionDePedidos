/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author af_mc
 */
public class ConexionBD {

    Connection conexion;
    Statement comando;
    ResultSet registro;
    String sentencia;

    /**
     * @param args the command line arguments
     */
    public ConexionBD() {
        cargarDriver();
    }

    private void cargarDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
            comando = conexion.createStatement();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void desconectar() {
        try {
            conexion.close();
            comando.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void eliminar(String codigo) {
        try {
            conectar();
            String sentencia = "DELETE FROM usuario WHERE id = " + codigo;
            int res = comando.executeUpdate(sentencia);
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void modificar(String codigo, String nombre, String apellido) {
        try {
            conectar();
            String sentencia = "UPDATE usuario SET nombres = '"+nombre+"', apellidos = '"+apellido+"' WHERE id = " + codigo;
            int res = comando.executeUpdate(sentencia);
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void consultar(String codigo) {
        try {
            conectar();
            String sentencia = "SELECT * FROM usuario WHERE id = " + codigo;
            registro = comando.executeQuery(sentencia);
            if (registro.next() == true) {
                System.out.println(registro.getString("nombres"));
                System.out.println(registro.getString("apellidos"));
            } else {
                System.out.println("No existe un usuario con dicho código");
            }
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void Registrar() {
        try {
            conectar();
            String sentencia = "INSERT INTO `usuario`(`nombres`, `apellidos`, `tipo_documento`, `num_documento`, `email`, `celular`, `telefono`) VALUES ('Paula','Mejia','2','31142563','a@a.a', '1542365896', '8842160')";
            //System.out.println(sentencia);
            comando.executeUpdate(sentencia);
            conexion.close();
            System.out.println("se registraron los datos");
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        ConexionBD c = new ConexionBD();
        c.Registrar();
        c.consultar("3");
        c.modificar("3","Marcos","Pinto");
        c.consultar("3");
        c.eliminar("3");
        c.consultar("3");
    }

}
