/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import GestionDePedidos.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class ControladorEmpresa {
    private String nombre, direccion, telefono, correo,
            ciudad, departamento, tipoDocumento,nroDocumento;
    private int posicionListaCliente, numeracionVendedor, numeracionProveedor;
    private ConexionBD conexionBD;
    private Cliente cliente;
    private Vendedor vendedor;
    private Proveedor proveedor;
    private Paquete paquete;
    private Producto producto;
    private Inventario inventario;

    public ControladorEmpresa() {
        this.cliente = new Cliente(); 
        this.vendedor= new Vendedor();
        this.proveedor = new Proveedor();
        this.producto = new Producto();
        this.paquete = new Paquete();
        
    }

    
    
    public ControladorEmpresa(String nombre, String direccion, String telefono, String correo, String ciudad, String departamento, String tipoDocumento, String fechaNacimiento, String nroDocumento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.cliente = new Cliente(); 
        this.vendedor= new Vendedor();
        this.proveedor = new Proveedor();
        this.producto = new Producto();
        this.paquete = new Paquete();
        this.posicionListaCliente=0;
        this.numeracionVendedor = 0;
        this.numeracionProveedor =0;
        
    }
    
    
    
    //Confirmacion para borrar, retorna un booleano.
    public boolean delete(){
        boolean confirmacion = false;
        int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminar este elemento?");
        
        if (respuesta == 0){
            confirmacion = true;
                
        }
        return confirmacion;
    }
    
    //Fidelizacion cliente
    
    public String fidelizacion(String[] datosCliente, String fechaPedido){
        String descuento;
        String fechaNacimiento = datosCliente[8];       
        Cliente cliente = new Cliente();
        cliente.setFechaNacimiento(fechaNacimiento);
        
        if (cliente.aplicarFidelizacion(cliente, fechaPedido)){
            
            return descuento = "20";
        }else{
            descuento = "No aplica";
        return descuento;
        }
    }
    
     //Create Client
    public void crearCliente( String[] datosCliente) {
       
        String nombre = datosCliente[0];
        String tipoDocumento = datosCliente[1];
        String numeroDocumento = datosCliente[2];
        String correo = datosCliente[3];
        String direccion = datosCliente[4];
        String telefono = datosCliente[5]; 
        String ciudad = datosCliente[6];
        String departamento = datosCliente[7];
        String fechaNacimiento = datosCliente[8];
                
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setCiudad(ciudad);
        cliente.setDepartamento(departamento);
        cliente.setNumeroDocumento(numeroDocumento);
        cliente.setTipoDocumento(tipoDocumento);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.createClient(cliente);
       
    }
    
    
    //Read client Table
    public String[] consultarCliente(String documento){
        Cliente datosCliente = this.cliente.consultarCliente(documento);
        String[] datos = new String[11];
        
        datos[0]=""+datosCliente.getIdCliente();
        datos[1]= datosCliente.getNombre();
        datos[2]= datosCliente.getTipoDocumento();
        datos[3]= datosCliente.getNumeroDocumento();
        datos[4]= datosCliente.getDireccion();
        datos[5]= datosCliente.getTelefono();      
        datos[6]= datosCliente.getCiudad();
        datos[7]= datosCliente.getDepartamento();
        datos[8]= datosCliente.getCorreo();
        datos[9]= datosCliente.getFechaNacimiento();       
        datos[10]= ""+datosCliente.getCantidadCompras();
        
        return datos;
    }
    
    public DefaultTableModel consultarClientesTabla(String[] titulos){
        DefaultTableModel modelo;
        modelo = cliente.consultarClientesTabla(titulos);
        return modelo;
    }
    
    //Updace Client
    
    public void actualizarCliente(String[] datosCliente){
        //0 idCliente, nombre, tipoDocumento, 3 numeroDocumento, fechaNacimiento, direccion, 6 telefono,  ciudad, departamento, 9 correo, 10 cantidadCompras
        int idCliente = Integer.parseInt(datosCliente[0]);
        String nombre = datosCliente[1];
        String tipoDocumento = datosCliente[2];
        String numeroDocumento = datosCliente[3];
        String fechaNacimiento = datosCliente[4];
        String direccion = datosCliente[5];
        String telefono = datosCliente[6]; 
        String ciudad = datosCliente[7];
        String departamento = datosCliente[8];
        String correo = datosCliente[9];
        int cantidadCompras = Integer.parseInt(datosCliente[10]);
        
                
        Cliente clienteUp = new Cliente();
        clienteUp.setIdCliente(idCliente);
        clienteUp.setNombre(nombre);
        clienteUp.setCorreo(correo);
        clienteUp.setTelefono(telefono);
        clienteUp.setDireccion(direccion);
        clienteUp.setCiudad(ciudad);
        clienteUp.setDepartamento(departamento);
        clienteUp.setNumeroDocumento(numeroDocumento);
        clienteUp.setTipoDocumento(tipoDocumento);
        clienteUp.setFechaNacimiento(fechaNacimiento);
        clienteUp.setCantidadCompras(cantidadCompras);
        clienteUp.updateClient(clienteUp);
        
        
    }
    //Delete Client
    
    
    public void eliminarCliente(String documento){
        cliente.deleteClient(documento);
    }
    
    //Create Vendor
    public void crearVendedor( String[] datosVendedor) {
        //{nombre,tipoDocumento,numeroDocumento,direccion,correo,telefono, ciudad, departamento}
        
        String nombre = datosVendedor[0];
        String tipoDocumento = datosVendedor[1];
        String numeroDocumento = datosVendedor[2];
        String direccion = datosVendedor[3];
        String correo = datosVendedor[4];
        String telefono = datosVendedor[5]; 
        String ciudad = datosVendedor[6];
        String departamento = datosVendedor[7];
        
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre(nombre);
        vendedor.setDireccion(direccion);
        vendedor.setCorreo(correo);
        vendedor.setTelefono(telefono);
        vendedor.setCiudad(ciudad);
        vendedor.setDepartamento(departamento);
        vendedor.setNumeroDocumento(numeroDocumento);
        vendedor.setTipoDocumento(tipoDocumento);
        
        
        vendedor.crearVendedor(vendedor);
       
    }
    
    
    //Read Vendor
    public String[] consultarVendedor(String documento){
        Vendedor datosVendedor = this.vendedor.consultarVendedor(documento);
        String[] datos = new String[11];
        
        datos[0]=""+datosVendedor.getIdVendedor();
        datos[1]= datosVendedor.getNombre();
        datos[2]= datosVendedor.getTipoDocumento();
        datos[3]= datosVendedor.getNumeroDocumento();
        datos[4]= datosVendedor.getDireccion();
        datos[5]= datosVendedor.getTelefono();      
        datos[6]= datosVendedor.getCiudad();
        datos[7]= datosVendedor.getDepartamento();
        datos[8]= datosVendedor.getCorreo();
        datos[9]= ""+datosVendedor.getCantVentasRealizadas();       
        datos[10]= ""+datosVendedor.getTotalVentasRealizadas();
        
        return datos;
    }
    
    public DefaultTableModel consultarVendedoresTabla(String[] titulos){
        DefaultTableModel modelo;
        modelo = vendedor.consultarVendedoresTabla(titulos);
        return modelo;
    }
    
    public String[] listaVendedores(){
        String[] vendedores;
        String solicitud = "nombre";
        vendedores = vendedor.listaVendedores(solicitud);
        return vendedores;
    }
    
    //Update Vendor
    
    public void actualizarVendedor(String[] datosVendedor){
        //{nombre,tipoDocumento,numeroDocumento,direccion,correo,telefono, ciudad, departamento}
        String nombre = datosVendedor[0];
        String tipoDocumento = datosVendedor[1];
        String numeroDocumento = datosVendedor[2];
        String direccion = datosVendedor[3];
        String correo = datosVendedor[4];
        String telefono = datosVendedor[5]; 
        String ciudad = datosVendedor[6];
        String departamento = datosVendedor[7];
        int idVendedor = vendedor.consultarIdVendedor(numeroDocumento);
        
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(idVendedor);
        vendedor.setNombre(nombre);
        vendedor.setTipoDocumento(tipoDocumento);
        vendedor.setNumeroDocumento(numeroDocumento);
        vendedor.setDireccion(direccion);
        vendedor.setCorreo(correo);
        vendedor.setTelefono(telefono);
        vendedor.setCiudad(ciudad);
        vendedor.setDepartamento(departamento);
        
        vendedor.updateVendor(vendedor);
    }
    
    
    
    //Delete Vendor
    public void eliminarVendedor(String documento){
        vendedor.deleteVendor(documento);
    }
    //Create Provider
    public void crearProveedor( String[] datosProveedor) {
        //{nombre,numeroDocumento,direccion,correo,telefono, ciudad, departamento}
        String nombre = datosProveedor[0];
        String numeroDocumento = datosProveedor[1];
        String direccion = datosProveedor[2];
        String correo = datosProveedor[3];
        String telefono = datosProveedor[4];
        String ciudad = datosProveedor[5];
        String departamento = datosProveedor[6];
        
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        proveedor.setNumeroDocumento(numeroDocumento);
        proveedor.setDireccion(direccion);
        proveedor.setCorreo(correo);
        proveedor.setTelefono(telefono);
        proveedor.setCiudad(ciudad);
        proveedor.setDepartamento(departamento);
        
        proveedor.crearProveedor(proveedor);
        
       
    }
    
    
    
    //Read Provider
    
    
    public String[] consultarProveedor(String documento){
        Proveedor datosProveedor = this.proveedor.consultarProveedor(documento);
        String[] datos = new String[11];
        
        datos[0]=""+datosProveedor.getIdProveedor();
        datos[1]= datosProveedor.getNombre();
        datos[2]= datosProveedor.getTipoDocumento();
        datos[3]= datosProveedor.getNumeroDocumento();
        datos[4]= datosProveedor.getDireccion();
        datos[5]= datosProveedor.getTelefono();      
        datos[6]= datosProveedor.getCiudad();
        datos[7]= datosProveedor.getDepartamento();
        datos[8]= datosProveedor.getCorreo();
        
        return datos;
    }
    
    public String[] listaProveedores(){
        String[] proveedores;
        String solicitud = "nombre";
        proveedores = proveedor.listaProveedores(solicitud);
        return proveedores;
    }
    
    //Update Provider
    
    public void actualizarProveedor(String[] datosProveedor) {
        
        //nombre, numeroDocumento, correo, direccion, telefono, ciudad, departamento
        
        String nombre = datosProveedor[0];
        String numeroDocumento= datosProveedor[1];
        String correo= datosProveedor[2];
        String direccion= datosProveedor[3];
        String telefono= datosProveedor[4];
        String ciudad = datosProveedor[5];
        String departamento = datosProveedor[6];
        
        int idProveedor = proveedor.consultarIdProveedor(numeroDocumento);
        
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(idProveedor);
        proveedor.setNombre(nombre);
        proveedor.setTipoDocumento(tipoDocumento);
        proveedor.setNumeroDocumento(numeroDocumento);
        proveedor.setDireccion(direccion);
        proveedor.setTelefono(telefono);
        proveedor.setCiudad(ciudad);
        proveedor.setDepartamento(departamento);
        proveedor.setCorreo(correo);
        
        proveedor.updateProvider(proveedor);
    }
    
    
    
    
    
    //Delete  Provider
    public void eliminarProveedor(String documento){
        proveedor.deleteProvider(documento);
    }
    
    
    
    //Create Product
            
    public void crearProducto(String nombreProducto,String codigoProducto, String descripcion, int  precioUnitario, int Cantidad, String idProveedor){
        Producto producto = new Producto ();
        
        producto.setNombreProducto(nombreProducto);
        producto.setCodigoProducto(codigoProducto);
        producto.setDescripcion(descripcion);
        producto.setPrecioUnitario(precioUnitario);
        producto.setCantidadInventario(Cantidad);
        producto.setIdProveedor(Integer.parseInt(idProveedor));
        producto.crearProducto(producto);
    }
    
    //Read Product
    
    public DefaultTableModel consultarProductosTabla(String[] titulos){
        DefaultTableModel modelo;
        modelo = producto.consultarProductosTabla(titulos);
        return modelo;
    }
    
    public String[] consultarProducto(String codigo){
        Producto datosProducto = this.producto.consultarProducto(codigo);
        String[] datos = new String[11];
        // "id", "nombreProducto","descripcion","precio_unitario","cantidad_inventario","nombrePRoveedor"
        datos[0]=""+datosProducto.getCodigoProducto();
        datos[1]= datosProducto.getNombreProducto();
        datos[2]= datosProducto.getDescripcion();
        datos[3]= ""+datosProducto.getPrecioUnitario();
        datos[4]= ""+datosProducto.getCantidadInventario();
        datos[5]= ""+datosProducto.getNombreProveedor();      
        
        return datos;
    }
    
    public int consultarCodigoProducto(String nombreProducto){
        int id = this.producto.consultarIdProducto(nombreProducto);
        return id;
    }
    
    public String[] listaProductos(){
        String[] productos;
        String solicitud = "nombreProducto";
        productos = producto.listaProductos(solicitud);
        return productos;
    }
    
    //Update Product
    
    public void actualizarProducto(String[] datosProducto) {
        
        // nombreProducto","codigoProducto", "descripcion","precio_unitario","cantidad_inventario","id_proveedor"
        
        String nombreProducto = datosProducto[0];
        String codigoProducto = datosProducto [1];
        String descripcion= datosProducto[2];
        int precioUnitario= Integer.parseInt(datosProducto[3]);
        int cantidad_inventario= Integer.parseInt(datosProducto[4]);
        int idProveedor= Integer.parseInt(datosProducto[5]);
        int idProducto = producto.consultarIdProducto(codigoProducto);
        
        producto.setId(idProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setCodigoProducto(codigoProducto);
        producto.setDescripcion(descripcion);
        producto.setPrecioUnitario(precioUnitario);
        producto.setCantidadInventario(cantidad_inventario);
        producto.setIdProveedor(idProveedor);
        
        
        producto.updateProduct(producto);
    }
    
    //Eliminate Product
    
    
    
    
    
    //Create pack
    public void crearPaquete( int producto, int descuento, String idPaquete, String nombre, String descripcion, Producto[] productos) {
        
        Paquete paquete = new Paquete();
        paquete.setNombre(nombre);
        paquete.setDescuento(descuento);
        
        
        
       
    }
    
    
    
    //Read pack
    
    
    
    //Update pack
    
    
    
    
    
    //Delete pack
    public void eliminarPaquete(int posicion){
        String nombre = "tb_producto_paquete";
        String id= ""+posicion;
        conexionBD.eliminar(id, nombre);  
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the nroDocumento
     */
    public String getNroDocumento() {
        return nroDocumento;
    }

    /**
     * @param nroDocumento the nroDocumento to set
     */
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    
    /**
     * @param listaClientes the listaClientes to set
     */
    public void setListaClientes(Cliente[] listaClientes) {
        this.setListaClientes(listaClientes);
    }

    /**
     * @param proveedores the proveedores to set
     */
    public void setProveedores(Proveedor[] proveedores) {
        this.setProveedores(proveedores);
    }

    /**
     * @return the inventario
     */
    public Inventario getInventario() {
        return inventario;
    }

    /**
     * @param inventario the inventario to set
     */
    public void setInventario(Inventario inventario) {
        this.setInventario(inventario);
    }
    
    public int getPosicionListaCliente() {
        return posicionListaCliente;
    }

    public void setPosicionListaCliente(int posicionListaCliente) {
        this.posicionListaCliente = posicionListaCliente;
    }

    public int getNumeracionVendedor() {
        return numeracionVendedor;
    }

    public void setNumeracionVendedor(int numeracionVendedor) {
        this.numeracionVendedor = numeracionVendedor;
    }

    public int getNumeracionProveedor() {
        return numeracionProveedor;
    }

    public void setNumeracionProveedor(int numeracionProveedor) {
        this.numeracionProveedor = numeracionProveedor;
    }

    public ConexionBD getConexionBD() {
        return conexionBD;
    }

    public void setConexionBD(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    } 
}
