/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePedidos;
//Libreria para obtener la fecha actual

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 * Clase Cliente que hereda de la clase Datos Basicos
 * @author Pablo Mayor
 */
public class Cliente extends DatosBasicos {

    //Se crean los atributos de la clase
    
    private String fechaNacimiento;
    private int idCliente, cantidadCompras;
    private boolean fidelizacion, estadoCliente;
    private ConexionBD conect;

    //Se crea el constructor de la clase

    public Cliente(String nombre, String tipoDocumento,String numeroDocumento, String fechaNacimiento, String direccion, String telefono, String ciudad, String departamento, String correo) {
        super(nombre, tipoDocumento, numeroDocumento, direccion, telefono, ciudad, departamento, correo);
        
        this.fechaNacimiento = fechaNacimiento;
        this.cantidadCompras = 0;
        this.fidelizacion = false;
        this.estadoCliente = true;
        
        
    }
    public Cliente(){
        this.cantidadCompras = 0;
        this.fidelizacion = false;
        this.estadoCliente = true;
        this.conect = new ConexionBD();
    }
    
    //Se crean los metodos
    
    //CREATE
    public void createClient(Cliente cliente){
        String nombre = "'"+cliente.getNombre()+"',";
        String tipoDocumento ="'"+cliente.getTipoDocumento()+"',";
        String numeroDocumento ="'"+cliente.getNumeroDocumento()+"',";
        String direccion ="'"+cliente.getDireccion()+"',";
        String telefono ="'"+cliente.getTelefono()+"',";
        String ciudad ="'"+cliente.getCiudad()+"',";
        String departamento ="'"+cliente.getDepartamento()+"',";
        String correo ="'"+cliente.getCorreo()+"',";
        String fechaNacimiento ="'"+cliente.getFechaNacimiento()+"',";
        String cantidadCompras ="'"+cliente.getCantidadCompras()+"')";
        
        String valores = " VALUES ("+nombre + tipoDocumento + numeroDocumento + direccion + telefono + ciudad + departamento + correo + fechaNacimiento + cantidadCompras;
        String sentencia = "INSERT INTO `tb_clientes`(`nombre`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `ciudad`, `departamento`, "
                + "`correo`, `fechaNacimiento`, `cantidad_compras`)"+ valores;
        conect.registrarDato(sentencia);
    }
    
    //READ
    
    public Cliente consultarCliente(String documento){
        int id = consultarIdCliente(documento);
        String valoresReq = "WHERE id ="+id;
        String sentencia = "SELECT `id`, `nombre`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `ciudad`, `departamento`, `correo`, `fechaNacimiento`, `cantidad_compras` FROM `tb_clientes`" + valoresReq;
        String[] variables = {"id", "nombre","tipo_documento","numero_documento","direccion","telefono","ciudad","departamento","correo","fechaNacimiento","cantidad_compras"};
        String [] resultado = conect.consultarUser(sentencia, variables);
        Cliente datosCliente = new Cliente();
        datosCliente.setIdCliente(Integer.parseInt(resultado[0]));
        datosCliente.setNombre(resultado[1]);
        datosCliente.setTipoDocumento(resultado[2]);
        datosCliente.setNumeroDocumento(resultado[3]);
        datosCliente.setDireccion(resultado[4]);
        datosCliente.setTelefono(resultado[5]);
        datosCliente.setCiudad(resultado[6]);
        datosCliente.setDepartamento(resultado[7]);
        datosCliente.setCorreo(resultado[8]);
        datosCliente.setFechaNacimiento(resultado[9]);
        datosCliente.setCantidadCompras(Integer.parseInt(resultado[10]));
        
        return datosCliente;
        
    }
    
    public int consultarIdCliente(String documento){
        String sentencia = "SELECT `id` FROM `tb_clientes` WHERE `numero_documento` = " + documento;
        String solicitud = "id";
        String identificacion = conect.consultarId(solicitud, sentencia);
        int id = Integer.parseInt(identificacion);
        return id;
    }
    
     public String consultarDocumentoCliente(String id){
        String sentencia = "SELECT `numero_documento` FROM `tb_clientes` WHERE `id` = " + id;
        String solicitud = "numero_documento";
        String documento = conect.consultarDocumento(solicitud, sentencia);
        return documento;
    }
    
    
    public DefaultTableModel consultarClientesTabla(String[] titulos){
        DefaultTableModel modelo = new DefaultTableModel();
        String sentencia = "SELECT `id`, `nombre`, `tipo_documento`, `numero_documento`, `correo` FROM `tb_clientes` WHERE 1";
        String[] variables = {"id", "nombre","tipo_documento","numero_documento","correo"};
        modelo = conect.consultarTabla(sentencia,variables);
        return modelo;
    }
    
    public int elementosTabla(){
        String sentencia = "SELECT COUNT(*) FROM tb_clientes";
        int cantidad = Integer.parseInt(conect.cantidadTabla(sentencia));
        return cantidad;
    }
    
    
    
    //UPDATE
    
    public void updateClient(Cliente cliente){
        
        int id = cliente.getIdCliente();
        String nombre = "'"+cliente.getNombre()+"'";
        String tipoDocumento ="'"+cliente.getTipoDocumento()+"'";
        String numeroDocumento ="'"+cliente.getNumeroDocumento()+"'";
        String direccion ="'"+cliente.getDireccion()+"'";
        String telefono ="'"+cliente.getTelefono()+"'";
        String ciudad ="'"+cliente.getCiudad()+"'";
        String departamento ="'"+cliente.getDepartamento()+"'";
        String correo ="'"+cliente.getCorreo()+"'";
        String fechaNacimiento ="'"+cliente.getFechaNacimiento()+"'";
        String cantidadCompras ="'"+cliente.getCantidadCompras()+"'";
        
        String sentencia = "UPDATE `tb_clientes` SET `nombre`="+nombre+",`tipo_documento`="+tipoDocumento+",`numero_documento`="+numeroDocumento
                            +",`direccion`="+ direccion +",`telefono`="+ telefono +",`ciudad`="+ ciudad +",`departamento`="+ departamento +",`correo`="+correo
                            + ",`fechaNacimiento`="+ fechaNacimiento +",`cantidad_compras`="+ cantidadCompras +" WHERE `id` = "+id;
        conect.registrarDato(sentencia);
        }
    
    //DELETE
    
    public void deleteClient(String documento) {
        
        String id = ""+consultarIdCliente(documento);
        String sentencia = "DELETE FROM `tb_clientes` WHERE `id`="+id;
        conect.registrarDato(sentencia);
    }

    public boolean aplicarFidelizacion(Cliente cliente, String fechaPedido ) {
        String fechaCumpleaños = getFechaNacimiento();
        String mesPedido = fechaPedido.substring(3, 4);
        String mesCumpleaños = fechaCumpleaños.substring(3, 4);
        int cantCompras = cliente.getCantidadCompras();

        // Obtienes el nombre del mes
        
        if (mesPedido.equals(mesCumpleaños)&& cantCompras>=100) {
            this.setFidelizacion(true);
            return this.fidelizacion;
        }
        return this.fidelizacion;
    }   

    public void registrarCompra() {
        
        this.setCantidadCompras(this.getCantidadCompras() + 1);
    }
    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        
        this.idCliente = id ;
        
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }

    public boolean isFidelizacion() {
        return fidelizacion;
    }

    public void setFidelizacion(boolean fidelizacion) {
        this.fidelizacion = fidelizacion;
    }

    public boolean isEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void cambioMes(){
        setCantidadCompras(0);
        setFidelizacion(false);
    } 

    public ConexionBD getConect() {
        return conect;
    }

    public void setConect(ConexionBD conect) {
        this.conect = conect;
    }
            
}
