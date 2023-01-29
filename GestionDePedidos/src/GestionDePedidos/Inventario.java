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
public class Inventario {
    private String idInventario;
    private Producto[] listaProductos;
    private Venta[] pedidos;
    private Paquete[] paquetes;

    public Inventario(String idInventario, Producto[] listaProductos, Venta[] pedidos, Paquete[] paquetes) {
        this.idInventario = idInventario;
        this.listaProductos = listaProductos;
        this.pedidos = pedidos;
        this.paquetes = paquetes;
        
    }

    /**
     * @return the idInventario
     */
    public String getIdInventario() {
        return idInventario;
    }

    /**
     * @param idInventario the idInventario to set
     */
    public void setIdInventario(String idInventario) {
        this.idInventario = idInventario;
    }

    /**
     * @return the listaProductos
     */
    public Producto[] getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(Producto[] listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * @return the pedidos
     */
    public Venta[] getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(Venta[] pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the paquetes
     */
    public Paquete[] getPaquetes() {
        return paquetes;
    }

    /**
     * @param paquetes the paquetes to set
     */
    public void setPaquetes(Paquete[] paquetes) {
        this.paquetes = paquetes;
    }

        
}
