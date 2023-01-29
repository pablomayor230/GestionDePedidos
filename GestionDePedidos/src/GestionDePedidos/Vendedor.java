/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePedidos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class Vendedor extends DatosBasicos {

    //Se crean los atributos de la clase
    
    String mesVentas;
    private int idVendedor, cantVentasRealizadas; 
    private float totalVentasRealizadas;
    private ConexionBD conect;
    //metodo constructor

    public Vendedor() {
        this.cantVentasRealizadas = 0;
        this.totalVentasRealizadas = 0;
        conect = new ConexionBD();
    }
    
    
    
    public Vendedor(int idVendedor, String nombre, String tipoDocumento, String numeroDocumento, String direccion, String telefono, String ciudad, String departamento, String correo) {
        super(nombre, tipoDocumento, numeroDocumento, direccion, telefono, ciudad, departamento, correo);
        this.idVendedor = idVendedor;
        this.cantVentasRealizadas = 0;
        this.totalVentasRealizadas = 0;
        
    }
    

    /**
     * Metodo para registrat una venta
     * @param venta, ingresa el total de la venta por parametro
     */
    
    //Create client
    //CREATE
    
    public void crearVendedor(Vendedor vendedor){
        String nombre = "'"+vendedor.getNombre()+"',";
        String tipoDocumento ="'"+vendedor.getTipoDocumento()+"',";
        String numeroDocumento ="'"+vendedor.getNumeroDocumento()+"',";
        String direccion ="'"+vendedor.getDireccion()+"',";
        String telefono ="'"+vendedor.getTelefono()+"',";
        String ciudad ="'"+vendedor.getCiudad()+"',";
        String departamento ="'"+vendedor.getDepartamento()+"',";
        String correo ="'"+vendedor.getCorreo()+"',";
        String cantidadVentas ="'"+vendedor.getCantVentasRealizadas()+"',";
        String totalVentas ="'"+vendedor.getTotalVentasRealizadas()+"')";
        
        String valores = " VALUES ("+nombre + tipoDocumento + numeroDocumento + direccion + telefono + ciudad + departamento + correo + cantidadVentas + totalVentas;
        String sentencia = "INSERT INTO `tb_vendedores`(`nombre`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `ciudad`,"
                            + " `departamento`, `correo`, `cantidad_ventas`, `total_ventas`)"+ valores;
       
        conect.registrarDato(sentencia);
    }
    
    
    protected void registrarVenta(float venta) {
        this.setCantVentasRealizadas(this.getCantVentasRealizadas() + 1);
        this.setTotalVentasRealizadas(getTotalVentasRealizadas() + venta);
        
    }
    
    //Read Vendor
    public Vendedor consultarVendedor(String documento){
        int id = consultarIdVendedor(documento);
        String valoresReq = "WHERE id ="+id;
        String sentencia = "SELECT `id`, `nombre`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `ciudad`, `departamento`, `correo`, `cantidad_ventas`, `total_ventas`  FROM `tb_vendedores` " + valoresReq;
        String[] variables = {"id", "nombre","tipo_documento","numero_documento","direccion","telefono","ciudad","departamento","correo","cantidad_ventas","total_ventas"};
        String [] resultado = conect.consultarUser(sentencia, variables);
        Vendedor datosVendedor = new Vendedor();
        datosVendedor.setIdVendedor(Integer.parseInt(resultado[0]));
        datosVendedor.setNombre(resultado[1]);
        datosVendedor.setTipoDocumento(resultado[2]);
        datosVendedor.setNumeroDocumento(resultado[3]);
        datosVendedor.setDireccion(resultado[4]);
        datosVendedor.setTelefono(resultado[5]);
        datosVendedor.setCiudad(resultado[6]);
        datosVendedor.setDepartamento(resultado[7]);
        datosVendedor.setCorreo(resultado[8]);
        datosVendedor.setCantVentasRealizadas(Integer.parseInt(resultado[9]));
        datosVendedor.setTotalVentasRealizadas(Integer.parseInt(resultado[10]));
        
        return datosVendedor;
        
    }
    
    public int consultarIdVendedor(String documento){
        String sentencia = "SELECT `id` FROM `tb_vendedores` WHERE `numero_documento` =" + documento;
        String solicitud = "id";
        String identificacion = conect.consultarId(solicitud, sentencia);
        int id = Integer.parseInt(identificacion);
        return id;
    }
    
    public int consultarIdVendedorNombre(String nombre){
        String sentencia = "SELECT `id` FROM `tb_vendedores` WHERE `nombre` =" +"'"+ nombre+"'";
        String solicitud = "id";
        String identificacion = conect.consultarId(solicitud, sentencia);
        int id = Integer.parseInt(identificacion);
        return id;
    }
    
    public String consultarDocumentoVendedor(String id){
        String sentencia = "SELECT `numero_documento` FROM `tb_vendedores` WHERE `id` = " + id;
        String solicitud = "numero_documento";
        String documento = conect.consultarDocumento(solicitud, sentencia);
        return documento;
    }
    
    public String[] listaVendedores(String solicitud){
        String sentencia = "SELECT `nombre` FROM `tb_vendedores` WHERE 1";
        ArrayList<String> vendedores =conect.consultarComboBox(sentencia, solicitud);
        String[] listaVendedores = new String[vendedores.size()];
        
        for (int i = 0; i < vendedores.size(); i++) {
            String temp = ""+vendedores.get(i);
            listaVendedores[i] = temp;
        }
        return listaVendedores;
    }
    
    public DefaultTableModel consultarVendedoresTabla(String[] titulos){
        DefaultTableModel modelo = new DefaultTableModel();
        String sentencia = "SELECT `id`, `nombre`, `telefono`, `cantidad_ventas` FROM `tb_vendedores` WHERE 1";
        String[] variables = {"id", "nombre","telefono","cantidad_ventas"};
        modelo = conect.consultarTabla(sentencia,variables);
        return modelo;
    }
    
    //Update Vendor
    
    public void updateVendor(Vendedor vendedor){
        
        int id = vendedor.getIdVendedor();
        String nombre = "'"+vendedor.getNombre()+"'";
        String tipoDocumento ="'"+vendedor.getTipoDocumento()+"'";
        String numeroDocumento ="'"+vendedor.getNumeroDocumento()+"'";
        String direccion ="'"+vendedor.getDireccion()+"'";
        String telefono ="'"+vendedor.getTelefono()+"'";
        String ciudad ="'"+vendedor.getCiudad()+"'";
        String departamento ="'"+vendedor.getDepartamento()+"'";
        String correo ="'"+vendedor.getCorreo()+"'";
        
        String sentencia = "UPDATE `tb_vendedores` SET `nombre`="+nombre+",`tipo_documento`="+tipoDocumento+",`numero_documento`="+numeroDocumento
                            +",`direccion`="+ direccion +",`telefono`="+ telefono +",`ciudad`="+ ciudad +",`departamento`="+ departamento +",`correo`="+correo
                            + " WHERE `id` = "+id;
        conect.registrarDato(sentencia);
        }
    //Delete vendor
    
    public void deleteVendor(String documento) {
        
        String id = ""+consultarIdVendedor(documento);
        String sentencia = "DELETE FROM `tb_vendedores` WHERE `id`="+id;
        conect.registrarDato(sentencia);
    }
    
    
    
    /**
     * @return the idVendedor
     */
    public int getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the ventasRealizadas
     */
    public int getCantVentasRealizadas() {
        return cantVentasRealizadas;
    }

    /**
     * @param ventasRealizadas the ventasRealizadas to set
     */
    public void setCantVentasRealizadas(int ventasRealizadas) {
        this.cantVentasRealizadas = ventasRealizadas;
    }

    public float getTotalVentasRealizadas() {
        return totalVentasRealizadas;
    }

    public void setTotalVentasRealizadas(float totalVentasRealizadas) {
        this.totalVentasRealizadas = totalVentasRealizadas;
    }

    public String getMesVentas() {
        return mesVentas;
    }

    public void setMesVentas(String mesVentas) {
        this.mesVentas = mesVentas;
    }
    
    public void cambioMes(){
        setCantVentasRealizadas(0);
        setTotalVentasRealizadas(0);
    }
}
