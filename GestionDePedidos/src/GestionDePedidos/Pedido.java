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
public class Pedido {
    private String estadoPedido; 
    private int pedido;
    private int descuento;
    private Cliente cliente;
    private Vendedor vendedor;

public Pedido(String estadoPedido, int pedido, int descuento, Cliente cliente, Vendedor vendedor) {
    this.estadoPedido = estadoPedido;
    this.pedido = pedido;
    this.descuento = descuento;
    this.cliente = cliente;
    this.vendedor = vendedor;
}

    /**
     * @return the estadoPedido
     */
    public String getEstadoPedido() {
        return estadoPedido;
    }

    /**
     * @param estadoPedido the estadoPedido to set
     */
    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    /**
     * @return the pedido
     */
    public int getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(int pedido) {
        this.pedido = pedido;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vendedor
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    
}
