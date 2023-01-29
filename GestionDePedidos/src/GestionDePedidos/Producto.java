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
public class Producto {
    private int id;
    private String nombreProducto;
    private String codigoProducto;
    private String descripcion;
    private int precioUnitario;
    private int cantidadInventario;
    private int idProveedor;
    private String nombreProveedor;
    private ConexionBD conect;

    public Producto(String producto, String idProducto, String descripcion, int precioUnitario, int cantidadInventario) {
        this.nombreProducto = producto;
        this.codigoProducto = idProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidadInventario = cantidadInventario;
    }

    public Producto() {
        conect = new ConexionBD();
    }
    
    //Create product
    
    public void crearProducto(Producto producto){
        String nombre = "'"+producto.getNombreProducto()+"',";
        String codigo = "'"+producto.getCodigoProducto()+"',";
        String descripcion ="'"+producto.getDescripcion()+"',";
        String precioUnitario ="'"+producto.getPrecioUnitario()+"',";
        String cantidadInventario ="'"+producto.getCantidadInventario()+"',";
        String idProveedor ="'"+producto.getIdProveedor()+"'";
        String valores = " VALUES ("+nombre + codigo + descripcion + precioUnitario + cantidadInventario + idProveedor+")";
        String sentencia = "INSERT INTO `tb_producto`( `nombreProducto`, `pro_codigo`, `descripcion`, `precio_unitario`, `cantidad_inventario`, `id_proveedor`) "+ valores;
        conect.registrarDato(sentencia);
    }
    
    //Read product
    
    public Producto consultarProducto(String codigoProducto){
        int id = consultarIdProducto(codigoProducto);
        String valoresReq = "WHERE tb_producto.id = "+id;
        String sentencia = "SELECT tb_producto.pro_codigo, tb_producto.nombreProducto, tb_producto.descripcion, tb_producto.precio_unitario, tb_producto.cantidad_inventario , tb_proveedores.nombre FROM tb_producto INNER JOIN tb_proveedores ON tb_producto.id_proveedor = tb_proveedores.id " + valoresReq;
        String[] variables = {"pro_codigo", "nombreProducto","descripcion","precio_unitario","cantidad_inventario","nombre"};
        String [] resultado = conect.consultarUser(sentencia, variables);
        Producto datosProducto = new Producto();
        datosProducto.setCodigoProducto(resultado[0]);
        datosProducto.setNombreProducto(resultado[1]);
        datosProducto.setDescripcion(resultado[2]);
        datosProducto.setPrecioUnitario(Integer.parseInt(resultado[3]));
        datosProducto.setCantidadInventario(Integer.parseInt(resultado[4]));
        datosProducto.setNombreProveedor(resultado[5]);
        
        return datosProducto;
        
    }
    
    public int consultarIdProducto(String codigoProducto){
        String sentencia = "SELECT `id` FROM `tb_producto` WHERE `pro_codigo` = " + codigoProducto;
        String solicitud = "id";
        String identificacion = conect.consultarId(solicitud, sentencia);
        int id = Integer.parseInt(identificacion);
        
        return id;
    }
    
    public int consultarCodigoProducto(String nombreProducto){
        String sentencia = "SELECT `pro_codigo` FROM `tb_producto` WHERE `nombreProducto` = " + "'"+nombreProducto+"'";
        String solicitud = "pro_codigo";
        String identificacion = conect.consultarId(solicitud, sentencia);
        int id = Integer.parseInt(identificacion);
        
        return id;
    }
    
    
    public DefaultTableModel consultarProductosTabla(String[] titulos){
        DefaultTableModel modelo = new DefaultTableModel();
        String sentencia = "SELECT `pro_codigo`, `nombreProducto`, `descripcion`, `precio_unitario`, `cantidad_inventario` FROM `tb_producto` WHERE 1";
        String[] variables = {"pro_codigo", "nombreProducto","precio_unitario","cantidad_inventario"};
        modelo = conect.consultarTabla(sentencia,variables);
        return modelo;
    }
    
    public String[] listaProductos(String solicitud){
        String sentencia = "SELECT `nombreProducto` FROM `tb_producto` WHERE 1";
        ArrayList<String> productos =conect.consultarComboBox(sentencia, solicitud);
        String[] listaVendedores = new String[productos.size()];
        
        for (int i = 0; i < productos.size(); i++) {
            String temp = ""+productos.get(i);
            listaVendedores[i] = temp;
        }
        return listaVendedores;
    }
    
    
    //Update Product
    
    public void updateProduct(Producto producto){
        
        int id = producto.getId();
        String nombre = "'"+producto.getNombreProducto()+"'";
        String codigoProducto ="'"+producto.getCodigoProducto()+"'";
        String descripcion ="'"+producto.getDescripcion()+"'";
        String precioUnitario ="'"+producto.getPrecioUnitario()+"'";
        String cantidadInventario ="'"+producto.getCantidadInventario()+"'";
        String idProveedor ="'"+producto.getIdProveedor()+"'";
        
        String sentencia = "UPDATE `tb_producto` SET `nombreProducto`="+nombre+",`pro_codigo`="+codigoProducto+",`descripcion`="+descripcion
                            +",`precio_unitario`="+ precioUnitario +",`cantidad_inventario`="+ cantidadInventario +",`id_proveedor`="+ idProveedor 
                            +" WHERE `id` = "+id;
        conect.registrarDato(sentencia);
        }
    
    
    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param producto the nombreProducto to set
     */
    public void setNombreProducto(String producto) {
        this.nombreProducto = producto;
    }

    /**
     * @return the codigoProducto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precioUnitario
     */
    public int getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the cantidadInventario
     */
    public int getCantidadInventario() {
        return cantidadInventario;
    }

    /**
     * @param cantidadInventario the cantidadInventario to set
     */
    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public ConexionBD getConect() {
        return conect;
    }

    public void setConect(ConexionBD conect) {
        this.conect = conect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    
    
}
