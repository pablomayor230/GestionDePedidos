/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePedidos;

/**
 *
 * @author Pablo
 */
public class Paquete {
    private int precio;
    private int descuento;
    private int idPaquete;
    private String nombre;
    private String descripcion;
    private int[] idProductos;

    public Paquete() {
    }

    public Paquete(int precio, int descuento, int idPaquete, String nombre, String descripcion, int[] idproductos) {
        this.precio = precio;
        this.descuento = descuento;
        this.idPaquete = idPaquete;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idProductos = idproductos;
    }
  
    

    /**
     * @return the precio
     */
    public int getProducto() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the descuento
     */
    public int getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the idPaquete
     */
    public int getIdPaquete() {
        return idPaquete;
    }

    /**
     * @param idPaquete the idPaquete to set
     */
    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the idProducts
     */
    public int[] getIdProductos() {
        return idProductos;
    }

    /**
     * @param idProductos the idProductos to set
     */
    public void setIdProductos(int[] idProductos) {
        this.idProductos = idProductos;
    }
    
    
        
    
    
}
