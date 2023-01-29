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
public class Venta {
    private String facturaNumero;
    private int valorTotalPedido;
    private int totalVentas;
    private Pedido pedido;

    public Venta(String facturaNumero, int valorTotalPedido, int totalVentas, Pedido pedido) {
        this.facturaNumero = facturaNumero;
        this.valorTotalPedido = valorTotalPedido;
        this.totalVentas = totalVentas;
        this.pedido = pedido;
    }

    /**
     * @return the facturaNumero
     */
    public String getFacturaNumero() {
        return facturaNumero;
    }

    /**
     * @param facturaNumero the facturaNumero to set
     */
    public void setFacturaNumero(String facturaNumero) {
        this.facturaNumero = facturaNumero;
    }

    /**
     * @return the valorTotalPedido
     */
    public int getValorTotalPedido() {
        return valorTotalPedido;
    }

    /**
     * @param valorTotalPedido the valorTotalPedido to set
     */
    public void setValorTotalPedido(int valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    /**
     * @return the totalVentas
     */
    public int getTotalVentas() {
        return totalVentas;
    }

    /**
     * @param totalVentas the totalVentas to set
     */
    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
