/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePedidos;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

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
    
    
    
    protected void cargarDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    protected void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestiondepedidos_bd", "pablo", "");
            comando = conexion.createStatement();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    protected void desconectar() {
        try {
            conexion.close();
            comando.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void eliminar(String codigo, String nombreTabla) {
        try {
            conectar();
            String sentencia = "DELETE FROM "+nombreTabla+" WHERE id = " + codigo;
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
            System.out.println(sentencia);
            comando.executeUpdate(sentencia);
            conexion.close();
            System.out.println("se registraron los datos");
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void registrarDato(String sentencia) {
        
        try {
            conectar();
            comando.executeUpdate(sentencia);
            conexion.close();
            JOptionPane.showMessageDialog(null, "La función se ejecutó exitosamente.");
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    public String[] consultarUser(String sentencia, String[] variables) {
        try {
            conectar();
            registro = comando.executeQuery(sentencia);
            if (registro.next() == true) {
                String[]resultado = new String[variables.length];
                for (int i = 0; i < variables.length; i++) {
                    resultado [i]= registro.getString(variables[i]);
                }
                desconectar();
                return resultado;
            } else {
                System.out.println("No existe un usuario con dicho código");
                desconectar();
                return null;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            desconectar();
            return null;
        }
    }
    
    public DefaultTableModel consultarTabla(String sentencia, String[] titulos) {
        DefaultTableModel modelo = new DefaultTableModel();
        int tamaño= titulos.length;
       
        try {
            conectar();
            registro = comando.executeQuery(sentencia);
            modelo.setColumnIdentifiers(titulos);
            while (registro.next()){
                Object[] datos = new Object[tamaño];
                for (int i = 0; i < tamaño; i++) {
                    datos[i]= registro.getString(titulos[i]);
                }
                modelo.addRow(datos);
                //modelo.addRow(new Object[]{registro.getString("id"),registro.getString("nombre"),registro.getString("tipo_documento"),registro.getString("numero_documento"),registro.getString("correo")});
            }
            
            return modelo;
        }catch (SQLException ex) {
            System.out.println(ex.toString());
            desconectar();
            return null;
        }
    }
    
    
    
    
    
    public String consultarId (String solicitud, String sentencia){
        String posicion;
        try {
            conectar();
            
            registro = comando.executeQuery(sentencia);
            if (registro.next() == true) {
                posicion = registro.getString(solicitud);
            } else {
                JOptionPane.showMessageDialog(null,"No existe un usuario con dicho documento");
                posicion = "Error";
            }
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            posicion = "Error";
        }
        
        return posicion;
    }
    
    public ArrayList consultarComboBox(String sentencia, String solicitud) {
        ArrayList<String> comboBox = new ArrayList<String>();
        try {
            conectar();
            registro = comando.executeQuery(sentencia);
            while (registro.next()){
                comboBox.add(registro.getString(solicitud));
            }
            
            return comboBox;
        }catch (SQLException ex) {
            System.out.println(ex.toString());
            desconectar();
            return null;
        }
    }
    
    
    
    public String consultarDocumento ( String solicitud, String sentencia){
        String respuesta;
        
        try {
            conectar();
            
            registro = comando.executeQuery(sentencia);
            if (registro.next() == true) {
                respuesta = registro.getString(solicitud);
            } else {
                JOptionPane.showMessageDialog(null,"No existe un usuario con dicho documento");
                respuesta = null;
            }
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            respuesta = null;
        }
        
        return respuesta;
    }
    
    
    public String cantidadTabla (String sentencia){
        String cantidad;
        
        try {
            conectar();
            
            registro = comando.executeQuery(sentencia);
            if (registro.next() == true) {
                cantidad = registro.getString("COUNT(*)");
            } else {
                JOptionPane.showMessageDialog(null,"No hay elementos en la tabla");
                cantidad = "Error";
            }
            desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            cantidad = "Error";
        }
        
        return cantidad;
    }
    
    
}
