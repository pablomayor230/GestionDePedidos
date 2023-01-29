

import controlador.ControladorEmpresa;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo
 */
public class MenuPedidos extends javax.swing.JFrame {
    ControladorEmpresa controladorEmpresa;
    private boolean estadoCliente, estadoVendedor, estadoProveedor;
    
    

    /**
     * Creates new form MenuPedidos
     * @param opcion
     */
    
    public boolean isEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public boolean isEstadoVendedor() {
        return estadoVendedor;
    }

    public void setEstadoVendedor(boolean estadoVendedor) {
        this.estadoVendedor = estadoVendedor;
    }

    public boolean isEstadoProveedor() {
        return estadoProveedor;
    }
    
    public void setEstadoProveedor(boolean estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }
    public void comboBoxVendedores(){
        comboBoxVendedores_Pedido.removeAllItems();
        String[] vendedores = controladorEmpresa.listaVendedores();
        for (int i = 0; i < vendedores.length; i++) {
            comboBoxVendedores_Pedido.addItem(vendedores[i]);
        }
    }
    
    public void comboBoxProductos(){
        comboBoxItems_Pedido.removeAllItems();
        String[] productos = controladorEmpresa.listaProductos();
        for (int i = 0; i < productos.length; i++) {
            comboBoxItems_Pedido.addItem(productos[i]);
        }
    }
    
    public void codigoProducto_pedido(){
        String nombreProducto = comboBoxItems_Pedido.getSelectedItem().toString();
        String codigoProducto =""+ controladorEmpresa.getProducto().consultarCodigoProducto(nombreProducto);
        txtProductCode_Pedido.setText(codigoProducto);
    }
    
    public String[] titulos(String opcion, int espacios) {
        // Pedido, Cliente, Inventario, Proveedores, Producto, Paquete
        String[] titulos= new String[espacios];
        
        if ("Pedido".equals(opcion)||"pedido".equals(opcion)  ){
            String[] temp = {"Codigo Producto", "Nombre Item", "Cantidad Productos", " % Descuento", "Valor Total Item"};
            titulos = temp;
                
        }else if ("Cliente".equals(opcion)|| "cliente".equals(opcion) ){
            String[] temp = {"Id Cliente", "Nombre", "Tipo de Documento", "Numero de Documento", "Correo"};
            titulos = temp;
        }else if ("Inventario".equals(opcion)||"inventario".equals(opcion) ){
            String[] temp = {"Codigo Producto", "Nombre Producto", "Precio Unitario", "Cantidad en Inventario"};
            titulos = temp;
        }else if ("Proveedor".equals(opcion)||"proveedor".equals(opcion) ){
            String[] temp = {"Id Proveedor", "Nombre Proveedor", "Numero de Documento", "Telefono" };
            titulos = temp;
        }else if ("Producto".equals(opcion)||"producto".equals(opcion) ){
            String[] temp = {"Codigo Producto", "Nombre Producto", "Precio Unitario", "Cantidad en Inventario"};
            titulos = temp;
        }else if ("Paquete".equals(opcion)||"paquete".equals(opcion) ){
            String[] temp = {"Codigo Paquete", "Nombre Producto", "Precio Unitario", "Cantidad en Inventario"};
            titulos = temp;
        }else if ("Vendedor".equals(opcion)||"vendedor".equals(opcion) ){
            String[] temp = {"Id Vendedor", "Nombre", "Telefono", "Cantidad de Ventas"};
            titulos = temp;
        }
        return titulos;
    }
    
    public int indexDocumento(String documento){
        int doct;
        switch (documento){
            case "Cedula de Ciudadania":
                doct=0;
                break;
            case "Tarjeta de Identidad":
                doct=1;
                break;
            case "Cedula de Extranjeria":
                doct=2;
                break;
            case "Pasaporte":
                doct=3;
                break;
            default:
                doct=4;
                break;
            }
        return doct;
    }
    
    //Limpiar formulario Cliente
    public void limpiarFormulario(String clase){
        switch(clase){
            case "Cliente":
                txtNombreCliente_Clientes.setText("");
                txtIdCliente_Clientes.setText("");
                txtNumeroDocumento_Clientes.setText("");
                comboBoxTipoDocumento_Clientes.setSelectedIndex(0);
                txtFechaNacimiento_Cliente.setText("dd/mm/aaaa");
                txtCiudad_Clientes.setText("");
                txtDepartamentoCliente_Clientes.setText("");
                txtDireccionCliente_Clientes.setText("");
                txtDireccionCliente_Clientes.setText("");
                txtCorreoCliente_Clientes.setText("");
                txtTelefonoCliente_Clientes.setText("");
                txtCantCompras.setText("");
                break;
            case "Vendedor":
                txtNombreVendedor_Vendedores.setText("");
                comboBoxTipoDocumentoVendedor_Vendedores.setSelectedIndex(0);
                txtNumeroDocumentoVendedor_Vendedores.setText("");
                txtCiudadVendedor_Vendedores.setText("");
                txtDepartamentoVendedor_Vendedores.setText("");
                txtDireccionVendedor_Vendedores.setText("");
                txtCorreoVendedor_Vendedores.setText("");
                txtTelefonoVendedor_Vendedores.setText("");
                txtCantVentasVendedor_Vendedores.setText("");
                txtTotalVentasVendedor_vendedores.setText("");
                
                break;
            case "Proveedor":
                txtNombreProveedor_Proveedores.setText("");
                txtCorreoProveedor_Proveedores.setText("");
                txtTelefonoProveedor_Proveedores.setText("");
                txtCiudadProveedor_Proveedores.setText("");
                txtDepartamentoProveedor_Proveedores.setText("");
                txtDireccionProveedor_Proveedores.setText("");
                txtNumeroDocumento_Proveedores.setText("");
                break;
            case "Pedido":
                //Info pedido
                txtFechaPedido.setText("dd/mm/aaaa");
                comboBoxVendedores_Pedido.setName("");

                //Info Cliente
                txtNameCliente_Pedido.setText("");
                comboBoxTypeDocClient_Pedido.setName("");
                txtNumeroDocumentoCliente_Pedido.setText("");
                txtNumeroDocumentoCliente_Pedido.setText("");
                txtDireccionCliente_Pedido.setText("");
                txtEmailClient_Pedido.setText("");

                //Info Productos o Paquetes
                comboBoxItems_Pedido.setName("");
                txtProductCode_Pedido.setText("");
                txtProductUnitPrice_Pedido.setText("");
                txtCantidadProducto_Pedido.setText("");
                break;
            case "Producto":
                txtCodigoProducto_Productos.setText("");
                txtNombreProducto_Productos.setText("");
                comboBoxProveedorProducto_Productos.setSelectedIndex(-1);
                txtPrecioUnitario_Producto.setText("");
                txtCantidadInventario_Producto.setText("");
                txtAreaDescripcionProducto_Producto.setText("");
                break;
            case "Paquete":
                txtCodigoPaquete_Paquetes.setText("");
                txtNombrePaquete_Paquetes.setText("");
                txtPrecioUnitarioPaquete_Paquetes.setText("");
                txtDescuentoPaquete_Paquetes.setText("");
                txtAreaDescripcionPaquete_Paquetes.setText("");
                break;
                
        } 
        
        
        
        
        
    }
    
    
    public void mostrarTablaClientes(){
        String opcion = "Cliente";
        int espacios = 5;
        String [] titulos = titulos(opcion,espacios);
        DefaultTableModel matrizClientes = controladorEmpresa.consultarClientesTabla(titulos);
        matrizClientes.setColumnIdentifiers(titulos);
        //String [] titulos = {"Id Cliente", "Nombre", "Tipo de Documento", "Numero de Documento", "Correo" };
        tablaDatosCliente.setModel(matrizClientes);
    }
    
    public void mostrarTablaVendedores(){
        String opcion = "Vendedor";
        int espacios = 4;
        String [] titulos = titulos(opcion,espacios);
        DefaultTableModel matrizVendedores = controladorEmpresa.consultarVendedoresTabla(titulos);
        matrizVendedores.setColumnIdentifiers(titulos);
        tablaVendedores_Vendedores.setModel(matrizVendedores);
    }
    
    public void mostrarTablaProductos(){
        String opcion = "Producto";
        int espacios = 4;
        String [] titulos = titulos(opcion,espacios);
        DefaultTableModel matrizProductos = controladorEmpresa.consultarProductosTabla(titulos);
        matrizProductos.setColumnIdentifiers(titulos);
        tablaProductos_Producto.setModel(matrizProductos);
    }
    public void borrarTablaProducto_pedido(){
        
        try {
            String opcion = "Pedido";
            int espacios = 5;
            String [] titulos = titulos(opcion,espacios);
            DefaultTableModel dfl = (DefaultTableModel) tablaProductos_Pedidos.getModel();
            int filas=dfl.getRowCount();
            for (int i = 0;filas>i; i++) {
                dfl.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
        
    public void agregarProducto_pedido(){
        DefaultTableModel dfl = (DefaultTableModel) tablaProductos_Pedidos.getModel();
        String [] producto = new String [5];
        String fechaPedido = txtFechaPedido.getText();
        String documento = txtNumeroDocumentoCliente_Pedido.getText();
        String[] datosCliente = controladorEmpresa.consultarCliente(documento);
        String fidelizacion = controladorEmpresa.fidelizacion(datosCliente , fechaPedido);
        int cantidad = Integer.parseInt(txtCantidadProducto_Pedido.getText());
        
        producto[0] = txtProductCode_Pedido.getText();
        producto[1] = ""+ comboBoxItems_Pedido.getSelectedItem();
        producto[2] = ""+ cantidad;
        producto[3] = fidelizacion;
        int precio = Integer.parseInt(txtProductUnitPrice_Pedido.getText());
        producto[4] = ""+(cantidad*precio);
        dfl.addRow(producto);
    }
    
    
    
    
    
    
    public MenuPedidos() {
        controladorEmpresa = new ControladorEmpresa();
        initComponents();
        comboBoxVendedores();
        comboBoxProductos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tabbedPaneMenu_Pedidos = new javax.swing.JTabbedPane();
        panelPedidos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaProductos_Pedidos = new javax.swing.JTable();
        labelTituloModuloPEdidos = new javax.swing.JLabel();
        labelTituloProductosDelPedido_Pedido = new javax.swing.JLabel();
        botonCrearPedido = new javax.swing.JButton();
        labelNameClient = new javax.swing.JLabel();
        labelIdDocClient_Pedido = new javax.swing.JLabel();
        txtNameCliente_Pedido = new javax.swing.JTextField();
        txtDireccionCliente_Pedido = new javax.swing.JTextField();
        labelAddressClient = new javax.swing.JLabel();
        labelCorreoCliente = new javax.swing.JLabel();
        txtNumeroDocumentoCliente_Pedido = new javax.swing.JTextField();
        comboBoxTypeDocClient_Pedido = new javax.swing.JComboBox<>();
        txtEmailClient_Pedido = new javax.swing.JTextField();
        buttonBuscarCliente_Pedidos = new javax.swing.JButton();
        añadirProducto_Pedido = new javax.swing.JButton();
        labelCliente_Pedido = new javax.swing.JLabel();
        labelTituloProductos_Pedido = new javax.swing.JLabel();
        labelCodigoProducto_Pedido = new javax.swing.JLabel();
        labelProducto_Pedido = new javax.swing.JLabel();
        txtProductCode_Pedido = new javax.swing.JTextField();
        labelPrecioProducto_Pedido = new javax.swing.JLabel();
        txtProductUnitPrice_Pedido = new javax.swing.JTextField();
        labelCantidadProducto_Pedido = new javax.swing.JLabel();
        txtCantidadProducto_Pedido = new javax.swing.JTextField();
        comboBoxVendedores_Pedido = new javax.swing.JComboBox<>();
        lavelNombreVendedor_Pedido = new javax.swing.JLabel();
        txtFechaPedido = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        comboBoxItems_Pedido = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        botonConsultarPedido = new javax.swing.JButton();
        botonEditarPedido = new javax.swing.JButton();
        botonCancelarPedido = new javax.swing.JButton();
        botonEliminarItemPedido = new javax.swing.JButton();
        buttonLimpiarFormulario_Pedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        labelIdVendedor_Pedidos = new javax.swing.JLabel();
        txtIdVendedor_pedido = new javax.swing.JTextField();
        panelClientes = new javax.swing.JPanel();
        buttonEliminarCliente_Clientes = new javax.swing.JButton();
        buttonGuardarDatosCliente_Clientes = new javax.swing.JButton();
        buttonBuscarCliente_Clientes = new javax.swing.JButton();
        buttonCrearCliente_Clientes = new javax.swing.JButton();
        labelNombreCliente_Clientes = new javax.swing.JLabel();
        labelCorreoElectronicoCliente_Clientes = new javax.swing.JLabel();
        labelTelefonoCliente_Clientes = new javax.swing.JLabel();
        txtNombreCliente_Clientes = new javax.swing.JTextField();
        txtCorreoCliente_Clientes = new javax.swing.JTextField();
        txtTelefonoCliente_Clientes = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDatosCliente = new javax.swing.JTable();
        labelTipoDocumento_Clientes = new javax.swing.JLabel();
        txtNumeroDocumento_Clientes = new javax.swing.JTextField();
        comboBoxTipoDocumento_Clientes = new javax.swing.JComboBox<>();
        labelNumeroDocumento = new javax.swing.JLabel();
        labelFechaNacimientoCliente_Clientes = new javax.swing.JLabel();
        txtFechaNacimiento_Cliente = new javax.swing.JTextField();
        labelDireccionCliente_Clientes = new javax.swing.JLabel();
        txtDireccionCliente_Clientes = new javax.swing.JTextField();
        labelCiudadCliente_Cliente = new javax.swing.JLabel();
        txtCiudad_Clientes = new javax.swing.JTextField();
        labelDepartamentoCliente_Cliente = new javax.swing.JLabel();
        txtDepartamentoCliente_Clientes = new javax.swing.JTextField();
        labelNumComprasCliente_Clientes = new javax.swing.JLabel();
        txtCantCompras = new javax.swing.JTextField();
        labelTituloModuloClientes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonLimpiarFormularioCliente_Clientes = new javax.swing.JButton();
        txtIdCliente_Clientes = new javax.swing.JTextField();
        labelIdCliente_Clientes = new javax.swing.JLabel();
        buttonActualizarTabla_Clientes = new javax.swing.JButton();
        panelInventario = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaInventarioProductos_Inventario = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        buttonActualizarLista__Inventario = new javax.swing.JButton();
        buttonEliminarItem_Inventario = new javax.swing.JButton();
        buttonAgregarInventario_Inventario = new javax.swing.JButton();
        paneProducto = new javax.swing.JPanel();
        labelCodProducto_Productos = new javax.swing.JLabel();
        labelNombreProducto_Productos = new javax.swing.JLabel();
        labelPrecioUnitario_Producto = new javax.swing.JLabel();
        labelCantidadInventario_Producto = new javax.swing.JLabel();
        labelDescripcionProducto_Producto = new javax.swing.JLabel();
        txtCodigoProducto_Productos = new javax.swing.JTextField();
        txtNombreProducto_Productos = new javax.swing.JTextField();
        txtPrecioUnitario_Producto = new javax.swing.JTextField();
        txtCantidadInventario_Producto = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaDescripcionProducto_Producto = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        buttonCrearProducto_productos = new javax.swing.JButton();
        buttonBuscarrProducto_productos = new javax.swing.JButton();
        buttonGuardarProducto_productos = new javax.swing.JButton();
        buttonEliminarProducto_productos = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaProductos_Producto = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        labelProveedor_Producto = new javax.swing.JLabel();
        comboBoxProveedorProducto_Productos = new javax.swing.JComboBox<>();
        buttonLimpiarFormularioProducto_Productos = new javax.swing.JButton();
        labelIdProveedor_productos = new javax.swing.JLabel();
        txtIdProveedor_productos = new javax.swing.JTextField();
        buttonActualizarListaProductos_Productos = new javax.swing.JButton();
        panePaquete = new javax.swing.JPanel();
        labelCodPaquete_Paquetes = new javax.swing.JLabel();
        labelNombrePaquete_Paquetes = new javax.swing.JLabel();
        labelPrecioPaquete_Paquetes = new javax.swing.JLabel();
        labelDescuentoPaquete_Paquetes = new javax.swing.JLabel();
        labelDescripcionPaquete_Paquetes = new javax.swing.JLabel();
        txtCodigoPaquete_Paquetes = new javax.swing.JTextField();
        txtNombrePaquete_Paquetes = new javax.swing.JTextField();
        txtPrecioUnitarioPaquete_Paquetes = new javax.swing.JTextField();
        txtDescuentoPaquete_Paquetes = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtAreaDescripcionPaquete_Paquetes = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        buttonAgregarProducto_Paquetes = new javax.swing.JButton();
        buttonBuscarPaquete_Paquetes = new javax.swing.JButton();
        buttonGuardarPaquete_Paquetes = new javax.swing.JButton();
        buttonEliminarPaquete_Paquetes = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaPaquete_Paquetes = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        buttonLimpiarFormularioPaquete_Paquetes = new javax.swing.JButton();
        buttonCrearPaquete_Paquetes = new javax.swing.JButton();
        paneProveedores = new javax.swing.JPanel();
        labelNombreProveedor_Proveedores = new javax.swing.JLabel();
        txtNombreProveedor_Proveedores = new javax.swing.JTextField();
        labelNitProveedor_Proveedores = new javax.swing.JLabel();
        txtNumeroDocumento_Proveedores = new javax.swing.JTextField();
        txtDepartamentoProveedor_Proveedores = new javax.swing.JTextField();
        txtCiudadProveedor_Proveedores = new javax.swing.JTextField();
        labelCiudadProveedor_Proveedores = new javax.swing.JLabel();
        labelDepartamentoProveedor_Proveedores = new javax.swing.JLabel();
        labelDireccionProveedor_Proveedores = new javax.swing.JLabel();
        txtDireccionProveedor_Proveedores = new javax.swing.JTextField();
        labelCorreoProveedor_Proveedores = new javax.swing.JLabel();
        txtCorreoProveedor_Proveedores = new javax.swing.JTextField();
        labelTelefonoProveedor_Proveedores = new javax.swing.JLabel();
        txtTelefonoProveedor_Proveedores = new javax.swing.JTextField();
        buttonEliminarProveedor_Proveedores = new javax.swing.JButton();
        buttonGuardarProveedor_Proveedores = new javax.swing.JButton();
        buttonBuscarProveedor_Proveedores = new javax.swing.JButton();
        buttonCrearProveedor_Proveedores = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaProveedores_Proveedores = new javax.swing.JTable();
        botonMostrarProveedores_Proveedores = new javax.swing.JButton();
        botonLimpiarFormularioProveedores_Proveedores1 = new javax.swing.JButton();
        paneVendedores = new javax.swing.JPanel();
        labelnombreVendedor_Vendedores = new javax.swing.JLabel();
        txtNombreVendedor_Vendedores = new javax.swing.JTextField();
        labelTipoDocumentoVendedor_Vendedores = new javax.swing.JLabel();
        comboBoxTipoDocumentoVendedor_Vendedores = new javax.swing.JComboBox<>();
        labelNumDocVendedor_Vendedores = new javax.swing.JLabel();
        txtNumeroDocumentoVendedor_Vendedores = new javax.swing.JTextField();
        txtDepartamentoVendedor_Vendedores = new javax.swing.JTextField();
        txtCiudadVendedor_Vendedores = new javax.swing.JTextField();
        labelCiudadVendedor_Vendedores = new javax.swing.JLabel();
        labelDepartamentoVendedor_Vendedores = new javax.swing.JLabel();
        labelDireccionVendedor_Vendedores = new javax.swing.JLabel();
        txtDireccionVendedor_Vendedores = new javax.swing.JTextField();
        labelCorreoVendedor_Vendedores = new javax.swing.JLabel();
        txtCorreoVendedor_Vendedores = new javax.swing.JTextField();
        labelTelefonoVendedor_Vendedores = new javax.swing.JLabel();
        txtTelefonoVendedor_Vendedores = new javax.swing.JTextField();
        labelCantVentasVendedor_Vendedores = new javax.swing.JLabel();
        txtCantVentasVendedor_Vendedores = new javax.swing.JTextField();
        buttonEliminarVendedor_Vendedores = new javax.swing.JButton();
        buttonGuardarVendedor_Vendedores = new javax.swing.JButton();
        buttonBuscarVendedor_Vendedores = new javax.swing.JButton();
        buttonCrearVendedor_Vendedores = new javax.swing.JButton();
        labelTituloGestorVendores_Vendedores = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaVendedores_Vendedores = new javax.swing.JTable();
        buttonActualizarListaVendedores_Vendedores = new javax.swing.JButton();
        labelTotalVentas = new javax.swing.JLabel();
        txtTotalVentasVendedor_vendedores = new javax.swing.JTextField();
        botonLimpiarFormularioVendedores_Vendedores = new javax.swing.JButton();
        paneDatosEmpresa = new javax.swing.JPanel();
        labelNombreEmpresa_Empresa = new javax.swing.JLabel();
        txtNombreEmpresa_Empresa = new javax.swing.JTextField();
        labelNitEmpresa_Empresa = new javax.swing.JLabel();
        txtNumeroDocumentoEmpresa_Empresa = new javax.swing.JTextField();
        txtDepartamentoEmpresa_Empresa = new javax.swing.JTextField();
        txtCiudadEmpresa_Empresa = new javax.swing.JTextField();
        labelCiudadEmpresa_Empresa = new javax.swing.JLabel();
        labelDepartamentoEmpresa_Empresa = new javax.swing.JLabel();
        labelDireccionEmpresa_Empresa = new javax.swing.JLabel();
        txtDireccionEmpresa_Empresa = new javax.swing.JTextField();
        labelCorreoEmpresa_Empresa = new javax.swing.JLabel();
        txtCorreoEmpresa_Empresa = new javax.swing.JTextField();
        labelTelefonoEmpresa_Empresa = new javax.swing.JLabel();
        txtTelefonoEmpresa_Empresa = new javax.swing.JTextField();
        buttonEliminarEmpresa_Empresa = new javax.swing.JButton();
        buttonGuardarEmpresa_Empresa = new javax.swing.JButton();
        buttonBuscarEmpresa_Empresa = new javax.swing.JButton();
        buttonCrearEmpresa_Empresa = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jToggleButton1.setText("jToggleButton1");

        jFormattedTextField1.setText("jFormattedTextField1");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTOR DE PEDIDOS");

        tabbedPaneMenu_Pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneMenu_PedidosMouseClicked(evt);
            }
        });
        tabbedPaneMenu_Pedidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabbedPaneMenu_PedidosKeyPressed(evt);
            }
        });

        tablaProductos_Pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre Item", "Cantidad productos", "% Descuento", "Valor Total Item"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaProductos_Pedidos);

        labelTituloModuloPEdidos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTituloModuloPEdidos.setText("GESTION DE PEDIDOS");

        labelTituloProductosDelPedido_Pedido.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        labelTituloProductosDelPedido_Pedido.setText("PRODUCTOS DEL PEDIDO");

        botonCrearPedido.setText("Crear");

        labelNameClient.setText("Nombre Cliente");

        labelIdDocClient_Pedido.setText("NumeroDocumento");

        labelAddressClient.setText("Dirección:");

        labelCorreoCliente.setText("Correo Electronico:");

        comboBoxTypeDocClient_Pedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Cedula de Ciudadania", "Tarjeta de Identidad", "Cedula de Extranjeria", "Pasaporte" }));
        comboBoxTypeDocClient_Pedido.setFocusable(false);

        buttonBuscarCliente_Pedidos.setText("Buscar Cliente");
        buttonBuscarCliente_Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarCliente_PedidosActionPerformed(evt);
            }
        });

        añadirProducto_Pedido.setText("Añadir Producto / Paquete");
        añadirProducto_Pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                añadirProducto_PedidoMouseClicked(evt);
            }
        });
        añadirProducto_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirProducto_PedidoActionPerformed(evt);
            }
        });

        labelCliente_Pedido.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        labelCliente_Pedido.setText("Información del Cliente");

        labelTituloProductos_Pedido.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        labelTituloProductos_Pedido.setText(" Productos o Paquetes");

        labelCodigoProducto_Pedido.setText("Codigo:");

        labelProducto_Pedido.setText("Nombre:");

        txtProductCode_Pedido.setEditable(false);
        txtProductCode_Pedido.setFocusable(false);

        labelPrecioProducto_Pedido.setText("Precio Por Unidad:");

        labelCantidadProducto_Pedido.setText("Cantidad:");

        comboBoxVendedores_Pedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        comboBoxVendedores_Pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxVendedores_PedidoMouseClicked(evt);
            }
        });
        comboBoxVendedores_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVendedores_PedidoActionPerformed(evt);
            }
        });

        lavelNombreVendedor_Pedido.setText("Vendedor:");

        txtFechaPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaPedido.setText("dd/mm/aaaa");
        txtFechaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaPedidoActionPerformed(evt);
            }
        });

        labelFecha.setText("Fecha del Pedido");

        comboBoxItems_Pedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxItems_Pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxItems_PedidoMouseClicked(evt);
            }
        });

        botonConsultarPedido.setText("Consultar");
        botonConsultarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarPedidoActionPerformed(evt);
            }
        });

        botonEditarPedido.setText("Editar");

        botonCancelarPedido.setText("Cancelar Pedido");
        botonCancelarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarPedidoMouseClicked(evt);
            }
        });

        botonEliminarItemPedido.setText("Eliminar item Seleccionado");

        buttonLimpiarFormulario_Pedido.setText("Limpar Formulario");
        buttonLimpiarFormulario_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimpiarFormulario_PedidoActionPerformed(evt);
            }
        });

        jLabel2.setText("TOTAL:");

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.setAutoscrolls(false);
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.setVerifyInputWhenFocusTarget(false);

        labelIdVendedor_Pedidos.setText("Id vendedor:");

        txtIdVendedor_pedido.setEditable(false);
        txtIdVendedor_pedido.setFocusable(false);

        javax.swing.GroupLayout panelPedidosLayout = new javax.swing.GroupLayout(panelPedidos);
        panelPedidos.setLayout(panelPedidosLayout);
        panelPedidosLayout.setHorizontalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNameClient)
                    .addComponent(labelAddressClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNameCliente_Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtDireccionCliente_Pedido))
                .addGap(11, 11, 11)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosLayout.createSequentialGroup()
                        .addComponent(labelCliente_Pedido)
                        .addContainerGap(281, Short.MAX_VALUE))
                    .addComponent(labelTituloProductos_Pedido)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosLayout.createSequentialGroup()
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addComponent(lavelNombreVendedor_Pedido)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxVendedores_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(labelIdVendedor_Pedidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdVendedor_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelCorreoCliente)
                                    .addComponent(labelIdDocClient_Pedido))
                                .addGap(18, 18, 18)
                                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosLayout.createSequentialGroup()
                                        .addComponent(txtNumeroDocumentoCliente_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboBoxTypeDocClient_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEmailClient_Pedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(labelTituloProductosDelPedido_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addComponent(labelFecha)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addComponent(labelCodigoProducto_Pedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addComponent(txtProductCode_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelProducto_Pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxItems_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(añadirProducto_Pedido))
                        .addGap(18, 18, 18)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addComponent(labelPrecioProducto_Pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProductUnitPrice_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelCantidadProducto_Pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadProducto_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonLimpiarFormulario_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(labelTituloModuloPEdidos)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(buttonBuscarCliente_Pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(botonCrearPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botonConsultarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botonEditarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botonCancelarPedido)
                        .addComponent(botonEliminarItemPedido)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        panelPedidosLayout.setVerticalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloModuloPEdidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lavelNombreVendedor_Pedido)
                            .addComponent(comboBoxVendedores_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIdVendedor_Pedidos)
                            .addComponent(txtIdVendedor_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelCliente_Pedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxTypeDocClient_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroDocumentoCliente_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIdDocClient_Pedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmailClient_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFecha))
                        .addGap(46, 46, 46)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNameClient)
                            .addComponent(txtNameCliente_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDireccionCliente_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelCorreoCliente))
                            .addComponent(labelAddressClient))))
                .addGap(14, 14, 14)
                .addComponent(buttonBuscarCliente_Pedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTituloProductos_Pedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigoProducto_Pedido)
                    .addComponent(labelProducto_Pedido)
                    .addComponent(txtProductCode_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecioProducto_Pedido)
                    .addComponent(txtProductUnitPrice_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCantidadProducto_Pedido)
                    .addComponent(txtCantidadProducto_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxItems_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadirProducto_Pedido)
                    .addComponent(buttonLimpiarFormulario_Pedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTituloProductosDelPedido_Pedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCrearPedido)
                    .addComponent(botonConsultarPedido)
                    .addComponent(botonEditarPedido)
                    .addComponent(botonCancelarPedido)
                    .addComponent(botonEliminarItemPedido))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabbedPaneMenu_Pedidos.addTab("Pedido", panelPedidos);

        buttonEliminarCliente_Clientes.setText("Eliminar");
        buttonEliminarCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarCliente_ClientesActionPerformed(evt);
            }
        });

        buttonGuardarDatosCliente_Clientes.setText("Guardar");
        buttonGuardarDatosCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarDatosCliente_ClientesActionPerformed(evt);
            }
        });

        buttonBuscarCliente_Clientes.setText("Buscar");
        buttonBuscarCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarCliente_ClientesActionPerformed(evt);
            }
        });

        buttonCrearCliente_Clientes.setText("Crear");
        buttonCrearCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearCliente_ClientesActionPerformed(evt);
            }
        });

        labelNombreCliente_Clientes.setText("Nombre completo:");

        labelCorreoElectronicoCliente_Clientes.setText("Correo electronico:");

        labelTelefonoCliente_Clientes.setText("Telefono:");

        tablaDatosCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Tipo Documento", "Numero Doc.", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaDatosCliente.setColumnSelectionAllowed(true);
        tablaDatosCliente.setDragEnabled(true);
        jScrollPane3.setViewportView(tablaDatosCliente);
        tablaDatosCliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaDatosCliente.getColumnModel().getColumnCount() > 0) {
            tablaDatosCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaDatosCliente.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        labelTipoDocumento_Clientes.setText("Tipo de documento:");

        txtNumeroDocumento_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDocumento_ClientesActionPerformed(evt);
            }
        });

        comboBoxTipoDocumento_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de Ciudadania", "Tarjeta de Identidad", "Cedula de Extranjeria", "Pasaporte", "" }));
        comboBoxTipoDocumento_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoDocumento_ClientesActionPerformed(evt);
            }
        });

        labelNumeroDocumento.setText("Numero  del Documento:");

        labelFechaNacimientoCliente_Clientes.setText("Fecha de Nacimiento:");

        txtFechaNacimiento_Cliente.setText("dd/mm/aaaa");

        labelDireccionCliente_Clientes.setText("Direccion:");

        txtDireccionCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionCliente_ClientesActionPerformed(evt);
            }
        });

        labelCiudadCliente_Cliente.setText("Ciudad:");

        labelDepartamentoCliente_Cliente.setText("Departamento:");

        txtDepartamentoCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoCliente_ClientesActionPerformed(evt);
            }
        });

        labelNumComprasCliente_Clientes.setText("Compras realizadas en el mes:");

        txtCantCompras.setEditable(false);
        txtCantCompras.setRequestFocusEnabled(false);

        labelTituloModuloClientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTituloModuloClientes.setText("GESTOR DE CLIENTES");

        buttonLimpiarFormularioCliente_Clientes.setText("Limpiar formulario");
        buttonLimpiarFormularioCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimpiarFormularioCliente_ClientesActionPerformed(evt);
            }
        });

        txtIdCliente_Clientes.setEditable(false);
        txtIdCliente_Clientes.setToolTipText("");
        txtIdCliente_Clientes.setFocusable(false);
        txtIdCliente_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCliente_ClientesActionPerformed(evt);
            }
        });

        labelIdCliente_Clientes.setText("ID Cliente:");

        buttonActualizarTabla_Clientes.setText("Actualizar tabla");
        buttonActualizarTabla_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarTabla_ClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelClientesLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombreCliente_Clientes)
                                    .addGroup(panelClientesLayout.createSequentialGroup()
                                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelTipoDocumento_Clientes)
                                            .addComponent(labelFechaNacimientoCliente_Clientes)
                                            .addComponent(labelDireccionCliente_Clientes)
                                            .addComponent(labelTelefonoCliente_Clientes))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombreCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelClientesLayout.createSequentialGroup()
                                                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(panelClientesLayout.createSequentialGroup()
                                                        .addComponent(comboBoxTipoDocumento_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(16, 16, 16))
                                                    .addGroup(panelClientesLayout.createSequentialGroup()
                                                        .addComponent(txtFechaNacimiento_Cliente)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(labelCiudadCliente_Cliente)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(panelClientesLayout.createSequentialGroup()
                                                        .addComponent(txtCiudad_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(labelDepartamentoCliente_Cliente)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtDepartamentoCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panelClientesLayout.createSequentialGroup()
                                                        .addComponent(labelNumeroDocumento)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txtNumeroDocumento_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(panelClientesLayout.createSequentialGroup()
                                                                .addComponent(labelIdCliente_Clientes)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtIdCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                            .addGroup(panelClientesLayout.createSequentialGroup()
                                                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtTelefonoCliente_Clientes)
                                                    .addComponent(txtDireccionCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelClientesLayout.createSequentialGroup()
                                                        .addComponent(labelCorreoElectronicoCliente_Clientes)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtCorreoCliente_Clientes))
                                                    .addGroup(panelClientesLayout.createSequentialGroup()
                                                        .addComponent(labelNumComprasCliente_Clientes)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtCantCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))))))
                                    .addComponent(labelTituloModuloClientes)))
                            .addGroup(panelClientesLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(buttonCrearCliente_Clientes)
                                .addGap(18, 18, 18)
                                .addComponent(buttonBuscarCliente_Clientes)
                                .addGap(18, 18, 18)
                                .addComponent(buttonGuardarDatosCliente_Clientes)
                                .addGap(18, 18, 18)
                                .addComponent(buttonEliminarCliente_Clientes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonLimpiarFormularioCliente_Clientes)))
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelClientesLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1))))
                .addContainerGap())
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(buttonActualizarTabla_Clientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloModuloClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreCliente_Clientes)
                    .addComponent(txtNombreCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdCliente_Clientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoDocumento_Clientes)
                    .addComponent(txtNumeroDocumento_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTipoDocumento_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumeroDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCiudadCliente_Cliente)
                    .addComponent(txtCiudad_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDepartamentoCliente_Cliente)
                    .addComponent(txtDepartamentoCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFechaNacimientoCliente_Clientes)
                    .addComponent(txtFechaNacimiento_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccionCliente_Clientes)
                    .addComponent(txtDireccionCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorreoElectronicoCliente_Clientes)
                    .addComponent(txtCorreoCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefonoCliente_Clientes)
                    .addComponent(txtTelefonoCliente_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumComprasCliente_Clientes)
                    .addComponent(txtCantCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCrearCliente_Clientes)
                    .addComponent(buttonBuscarCliente_Clientes)
                    .addComponent(buttonGuardarDatosCliente_Clientes)
                    .addComponent(buttonEliminarCliente_Clientes)
                    .addComponent(buttonLimpiarFormularioCliente_Clientes))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(buttonActualizarTabla_Clientes)
                .addGap(28, 28, 28))
        );

        tabbedPaneMenu_Pedidos.addTab("Clientes", panelClientes);

        tablaInventarioProductos_Inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Precio Unitario", "Cantidad"
            }
        ));
        jScrollPane7.setViewportView(tablaInventarioProductos_Inventario);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("CONSULTA DE INVENTARIO");

        buttonActualizarLista__Inventario.setText("Actualizar Lista");

        buttonEliminarItem_Inventario.setText("Eliminar");

        buttonAgregarInventario_Inventario.setText("Agregar inventario");

        javax.swing.GroupLayout panelInventarioLayout = new javax.swing.GroupLayout(panelInventario);
        panelInventario.setLayout(panelInventarioLayout);
        panelInventarioLayout.setHorizontalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(buttonActualizarLista__Inventario)
                        .addGap(75, 75, 75)
                        .addComponent(buttonAgregarInventario_Inventario)
                        .addGap(79, 79, 79)
                        .addComponent(buttonEliminarItem_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelInventarioLayout.setVerticalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonActualizarLista__Inventario)
                    .addComponent(buttonEliminarItem_Inventario)
                    .addComponent(buttonAgregarInventario_Inventario))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        tabbedPaneMenu_Pedidos.addTab("Inventario", panelInventario);

        labelCodProducto_Productos.setText("Codigo Producto:");

        labelNombreProducto_Productos.setText("Nombre Producto:");

        labelPrecioUnitario_Producto.setText("Precio Unitario:");

        labelCantidadInventario_Producto.setText("Cantidad");

        labelDescripcionProducto_Producto.setText("Descripción:");

        txtCantidadInventario_Producto.setToolTipText("");

        txtAreaDescripcionProducto_Producto.setColumns(20);
        txtAreaDescripcionProducto_Producto.setRows(5);
        jScrollPane4.setViewportView(txtAreaDescripcionProducto_Producto);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("CONSULTA Y GESTION DE PRODUCTOS");

        buttonCrearProducto_productos.setText("Crear");
        buttonCrearProducto_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearProducto_productosActionPerformed(evt);
            }
        });

        buttonBuscarrProducto_productos.setText("Buscar");
        buttonBuscarrProducto_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarrProducto_productosActionPerformed(evt);
            }
        });

        buttonGuardarProducto_productos.setText("Guardar");
        buttonGuardarProducto_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarProducto_productosActionPerformed(evt);
            }
        });

        buttonEliminarProducto_productos.setText("Eliminar");
        buttonEliminarProducto_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarProducto_productosActionPerformed(evt);
            }
        });

        tablaProductos_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Producto", "Nombre Producto", "Precio Unitario", "Cantidad en Inventario"
            }
        ));
        jScrollPane6.setViewportView(tablaProductos_Producto);
        if (tablaProductos_Producto.getColumnModel().getColumnCount() > 0) {
            tablaProductos_Producto.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos_Producto.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaProductos_Producto.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos_Producto.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaProductos_Producto.getColumnModel().getColumn(3).setResizable(false);
        }

        labelProveedor_Producto.setText("Proveedor:");

        comboBoxProveedorProducto_Productos.setToolTipText("");
        comboBoxProveedorProducto_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxProveedorProducto_ProductosMouseClicked(evt);
            }
        });
        comboBoxProveedorProducto_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProveedorProducto_ProductosActionPerformed(evt);
            }
        });

        buttonLimpiarFormularioProducto_Productos.setText("Limpiar formulario");
        buttonLimpiarFormularioProducto_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimpiarFormularioProducto_ProductosActionPerformed(evt);
            }
        });

        labelIdProveedor_productos.setText("Id:");

        txtIdProveedor_productos.setEditable(false);
        txtIdProveedor_productos.setFocusable(false);

        buttonActualizarListaProductos_Productos.setText("Actualizar lista");
        buttonActualizarListaProductos_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarListaProductos_ProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneProductoLayout = new javax.swing.GroupLayout(paneProducto);
        paneProducto.setLayout(paneProductoLayout);
        paneProductoLayout.setHorizontalGroup(
            paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneProductoLayout.createSequentialGroup()
                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneProductoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneProductoLayout.createSequentialGroup()
                                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(paneProductoLayout.createSequentialGroup()
                                        .addComponent(labelProveedor_Producto)
                                        .addGap(23, 23, 23)
                                        .addComponent(comboBoxProveedorProducto_Productos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(paneProductoLayout.createSequentialGroup()
                                        .addComponent(labelCodProducto_Productos)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtCodigoProducto_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(labelIdProveedor_productos)
                                .addGap(18, 18, 18)
                                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneProductoLayout.createSequentialGroup()
                                        .addComponent(txtIdProveedor_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(labelPrecioUnitario_Producto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrecioUnitario_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelCantidadInventario_Producto)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCantidadInventario_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(paneProductoLayout.createSequentialGroup()
                                        .addComponent(labelNombreProducto_Productos)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombreProducto_Productos))))
                            .addGroup(paneProductoLayout.createSequentialGroup()
                                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(paneProductoLayout.createSequentialGroup()
                                        .addComponent(labelDescripcionProducto_Producto)
                                        .addGap(19, 19, 19)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneProductoLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
            .addGroup(paneProductoLayout.createSequentialGroup()
                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneProductoLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(buttonCrearProducto_productos)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscarrProducto_productos)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGuardarProducto_productos)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEliminarProducto_productos)
                        .addGap(18, 18, 18)
                        .addComponent(buttonLimpiarFormularioProducto_Productos))
                    .addGroup(paneProductoLayout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(buttonActualizarListaProductos_Productos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneProductoLayout.setVerticalGroup(
            paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(26, 26, 26)
                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneProductoLayout.createSequentialGroup()
                        .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodProducto_Productos)
                            .addComponent(txtCodigoProducto_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombreProducto_Productos))
                        .addGap(18, 18, 18)
                        .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelProveedor_Producto)
                            .addComponent(comboBoxProveedorProducto_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIdProveedor_productos)
                            .addComponent(txtIdProveedor_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneProductoLayout.createSequentialGroup()
                        .addComponent(txtNombreProducto_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCantidadInventario_Producto)
                            .addComponent(txtCantidadInventario_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioUnitario_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPrecioUnitario_Producto))))
                .addGap(29, 29, 29)
                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcionProducto_Producto)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(paneProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCrearProducto_productos)
                    .addComponent(buttonBuscarrProducto_productos)
                    .addComponent(buttonGuardarProducto_productos)
                    .addComponent(buttonEliminarProducto_productos)
                    .addComponent(buttonLimpiarFormularioProducto_Productos))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonActualizarListaProductos_Productos)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        tabbedPaneMenu_Pedidos.addTab("Producto", paneProducto);

        labelCodPaquete_Paquetes.setText("Codigo Producto:");

        labelNombrePaquete_Paquetes.setText("Nombre Paquete:");

        labelPrecioPaquete_Paquetes.setText("Precio Unitario:");

        labelDescuentoPaquete_Paquetes.setText("Descuento:              %");

        labelDescripcionPaquete_Paquetes.setText("Descripción:");

        txtPrecioUnitarioPaquete_Paquetes.setEditable(false);
        txtPrecioUnitarioPaquete_Paquetes.setFocusable(false);

        txtDescuentoPaquete_Paquetes.setToolTipText("");

        txtAreaDescripcionPaquete_Paquetes.setColumns(20);
        txtAreaDescripcionPaquete_Paquetes.setRows(5);
        jScrollPane10.setViewportView(txtAreaDescripcionPaquete_Paquetes);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("CONSULTA Y GESTION DE PAQUETES PROMOCIONALES");

        buttonAgregarProducto_Paquetes.setText("Agregar al Paquete");

        buttonBuscarPaquete_Paquetes.setText("Buscar");

        buttonGuardarPaquete_Paquetes.setText("Guardar");

        buttonEliminarPaquete_Paquetes.setText("Eliminar");

        tablaPaquete_Paquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Producto", "Nombre Producto", "Precio Unitario", "Cantidad en Inventario"
            }
        ));
        jScrollPane11.setViewportView(tablaPaquete_Paquetes);
        if (tablaPaquete_Paquetes.getColumnModel().getColumnCount() > 0) {
            tablaPaquete_Paquetes.getColumnModel().getColumn(0).setResizable(false);
            tablaPaquete_Paquetes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaPaquete_Paquetes.getColumnModel().getColumn(2).setResizable(false);
            tablaPaquete_Paquetes.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaPaquete_Paquetes.getColumnModel().getColumn(3).setResizable(false);
        }

        buttonLimpiarFormularioPaquete_Paquetes.setText("Limpiar formulario");
        buttonLimpiarFormularioPaquete_Paquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimpiarFormularioPaquete_PaquetesActionPerformed(evt);
            }
        });

        buttonCrearPaquete_Paquetes.setText("Crear");

        javax.swing.GroupLayout panePaqueteLayout = new javax.swing.GroupLayout(panePaquete);
        panePaquete.setLayout(panePaqueteLayout);
        panePaqueteLayout.setHorizontalGroup(
            panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panePaqueteLayout.createSequentialGroup()
                .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panePaqueteLayout.createSequentialGroup()
                        .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panePaqueteLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panePaqueteLayout.createSequentialGroup()
                                        .addComponent(labelDescripcionPaquete_Paquetes)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panePaqueteLayout.createSequentialGroup()
                                            .addComponent(labelPrecioPaquete_Paquetes)
                                            .addGap(37, 37, 37)
                                            .addComponent(txtPrecioUnitarioPaquete_Paquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelDescuentoPaquete_Paquetes)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDescuentoPaquete_Paquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panePaqueteLayout.createSequentialGroup()
                                            .addComponent(labelCodPaquete_Paquetes)
                                            .addGap(27, 27, 27)
                                            .addComponent(txtCodigoPaquete_Paquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(64, 64, 64)
                                            .addComponent(labelNombrePaquete_Paquetes)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombrePaquete_Paquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panePaqueteLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel18)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panePaqueteLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11)
                            .addGroup(panePaqueteLayout.createSequentialGroup()
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(42, 42, 42))
            .addGroup(panePaqueteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(buttonAgregarProducto_Paquetes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCrearPaquete_Paquetes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscarPaquete_Paquetes)
                .addGap(18, 18, 18)
                .addComponent(buttonGuardarPaquete_Paquetes)
                .addGap(18, 18, 18)
                .addComponent(buttonEliminarPaquete_Paquetes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLimpiarFormularioPaquete_Paquetes)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panePaqueteLayout.setVerticalGroup(
            panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePaqueteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(26, 26, 26)
                .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCodPaquete_Paquetes)
                        .addComponent(txtCodigoPaquete_Paquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombrePaquete_Paquetes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelNombrePaquete_Paquetes)))
                .addGap(18, 18, 18)
                .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDescuentoPaquete_Paquetes)
                        .addComponent(txtDescuentoPaquete_Paquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPrecioPaquete_Paquetes))
                    .addComponent(txtPrecioUnitarioPaquete_Paquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcionPaquete_Paquetes)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panePaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLimpiarFormularioPaquete_Paquetes)
                    .addComponent(buttonAgregarProducto_Paquetes)
                    .addComponent(buttonBuscarPaquete_Paquetes)
                    .addComponent(buttonGuardarPaquete_Paquetes)
                    .addComponent(buttonEliminarPaquete_Paquetes)
                    .addComponent(buttonCrearPaquete_Paquetes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        tabbedPaneMenu_Pedidos.addTab("Paquetes", panePaquete);

        labelNombreProveedor_Proveedores.setText("Nombre proveedor:");

        labelNitProveedor_Proveedores.setText("NIT:");

        txtNumeroDocumento_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDocumento_ProveedoresActionPerformed(evt);
            }
        });

        txtDepartamentoProveedor_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoProveedor_ProveedoresActionPerformed(evt);
            }
        });

        labelCiudadProveedor_Proveedores.setText("Ciudad:");

        labelDepartamentoProveedor_Proveedores.setText("Departamento:");

        labelDireccionProveedor_Proveedores.setText("Direccion:");

        txtDireccionProveedor_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionProveedor_ProveedoresActionPerformed(evt);
            }
        });

        labelCorreoProveedor_Proveedores.setText("Correo electronico:");

        labelTelefonoProveedor_Proveedores.setText("Telefono:");

        buttonEliminarProveedor_Proveedores.setText("Eliminar");
        buttonEliminarProveedor_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarProveedor_ProveedoresActionPerformed(evt);
            }
        });

        buttonGuardarProveedor_Proveedores.setText("Guardar");
        buttonGuardarProveedor_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarProveedor_ProveedoresActionPerformed(evt);
            }
        });

        buttonBuscarProveedor_Proveedores.setText("Buscar");
        buttonBuscarProveedor_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarProveedor_ProveedoresActionPerformed(evt);
            }
        });

        buttonCrearProveedor_Proveedores.setText("Crear");
        buttonCrearProveedor_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearProveedor_ProveedoresActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("GESTION DE PROVEEDORES");

        tablaProveedores_Proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Proveedor", "Nombre Proveedor", "Numero NIT", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tablaProveedores_Proveedores);

        botonMostrarProveedores_Proveedores.setText("Mostrar lista proveedores");
        botonMostrarProveedores_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarProveedores_ProveedoresActionPerformed(evt);
            }
        });

        botonLimpiarFormularioProveedores_Proveedores1.setText("Limpiar Formulario");
        botonLimpiarFormularioProveedores_Proveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarFormularioProveedores_Proveedores1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneProveedoresLayout = new javax.swing.GroupLayout(paneProveedores);
        paneProveedores.setLayout(paneProveedoresLayout);
        paneProveedoresLayout.setHorizontalGroup(
            paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProveedoresLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addGroup(paneProveedoresLayout.createSequentialGroup()
                        .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneProveedoresLayout.createSequentialGroup()
                                .addComponent(labelNombreProveedor_Proveedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneProveedoresLayout.createSequentialGroup()
                                .addGap(358, 358, 358)
                                .addComponent(labelNitProveedor_Proveedores)
                                .addGap(24, 24, 24)
                                .addComponent(txtNumeroDocumento_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneProveedoresLayout.createSequentialGroup()
                        .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneProveedoresLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelDireccionProveedor_Proveedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneProveedoresLayout.createSequentialGroup()
                                .addComponent(labelTelefonoProveedor_Proveedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneProveedoresLayout.createSequentialGroup()
                                        .addComponent(buttonCrearProveedor_Proveedores)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonBuscarProveedor_Proveedores))
                                    .addComponent(txtTelefonoProveedor_Proveedores))))
                        .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneProveedoresLayout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(labelCiudadProveedor_Proveedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCiudadProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelDepartamentoProveedor_Proveedores)
                                .addGap(18, 18, 18)
                                .addComponent(txtDepartamentoProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneProveedoresLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(labelCorreoProveedor_Proveedores)
                                .addGap(18, 18, 18)
                                .addComponent(txtCorreoProveedor_Proveedores))
                            .addGroup(paneProveedoresLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(buttonGuardarProveedor_Proveedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonEliminarProveedor_Proveedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonLimpiarFormularioProveedores_Proveedores1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(79, 79, 79))
            .addGroup(paneProveedoresLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(botonMostrarProveedores_Proveedores)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneProveedoresLayout.setVerticalGroup(
            paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProveedoresLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel26)
                .addGap(29, 29, 29)
                .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreProveedor_Proveedores)
                    .addComponent(txtNombreProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNitProveedor_Proveedores)
                    .addComponent(txtNumeroDocumento_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccionProveedor_Proveedores)
                    .addComponent(txtDireccionProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCiudadProveedor_Proveedores)
                    .addComponent(txtCiudadProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDepartamentoProveedor_Proveedores)
                    .addComponent(txtDepartamentoProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefonoProveedor_Proveedores)
                    .addComponent(txtTelefonoProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorreoProveedor_Proveedores)
                    .addComponent(txtCorreoProveedor_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCrearProveedor_Proveedores)
                    .addComponent(buttonBuscarProveedor_Proveedores)
                    .addComponent(buttonGuardarProveedor_Proveedores)
                    .addComponent(buttonEliminarProveedor_Proveedores)
                    .addComponent(botonLimpiarFormularioProveedores_Proveedores1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonMostrarProveedores_Proveedores)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        tabbedPaneMenu_Pedidos.addTab("Proveedores", paneProveedores);

        paneVendedores.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                paneVendedoresAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        labelnombreVendedor_Vendedores.setText("Nombre completo:");

        txtNombreVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreVendedor_VendedoresActionPerformed(evt);
            }
        });

        labelTipoDocumentoVendedor_Vendedores.setText("Tipo de documento:");

        comboBoxTipoDocumentoVendedor_Vendedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de Ciudadania", "Tarjeta de Identidad", "Cedula de Extranjeria", "Pasaporte", "" }));
        comboBoxTipoDocumentoVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoDocumentoVendedor_VendedoresActionPerformed(evt);
            }
        });

        labelNumDocVendedor_Vendedores.setText("Numero  del Documento:");

        txtNumeroDocumentoVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDocumentoVendedor_VendedoresActionPerformed(evt);
            }
        });

        txtDepartamentoVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoVendedor_VendedoresActionPerformed(evt);
            }
        });

        labelCiudadVendedor_Vendedores.setText("Ciudad:");

        labelDepartamentoVendedor_Vendedores.setText("Departamento:");

        labelDireccionVendedor_Vendedores.setText("Direccion:");

        txtDireccionVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionVendedor_VendedoresActionPerformed(evt);
            }
        });

        labelCorreoVendedor_Vendedores.setText("Correo electronico:");

        labelTelefonoVendedor_Vendedores.setText("Telefono:");

        labelCantVentasVendedor_Vendedores.setText("Ventas del mes:");

        txtCantVentasVendedor_Vendedores.setEditable(false);
        txtCantVentasVendedor_Vendedores.setFocusable(false);

        buttonEliminarVendedor_Vendedores.setText("Eliminar");
        buttonEliminarVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarVendedor_VendedoresActionPerformed(evt);
            }
        });

        buttonGuardarVendedor_Vendedores.setText("Guardar");
        buttonGuardarVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarVendedor_VendedoresActionPerformed(evt);
            }
        });

        buttonBuscarVendedor_Vendedores.setText("Buscar");
        buttonBuscarVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarVendedor_VendedoresActionPerformed(evt);
            }
        });

        buttonCrearVendedor_Vendedores.setText("Crear");
        buttonCrearVendedor_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearVendedor_VendedoresActionPerformed(evt);
            }
        });

        labelTituloGestorVendores_Vendedores.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTituloGestorVendores_Vendedores.setText("GESTOR DE VENDEDORES");

        tablaVendedores_Vendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Vendedor", "Nombre Vendedor", "Telefono", "Ventas Realizadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tablaVendedores_Vendedores);

        buttonActualizarListaVendedores_Vendedores.setText("Actualizar lista");
        buttonActualizarListaVendedores_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarListaVendedores_VendedoresActionPerformed(evt);
            }
        });

        labelTotalVentas.setText("Tota: $");

        txtTotalVentasVendedor_vendedores.setEditable(false);
        txtTotalVentasVendedor_vendedores.setFocusable(false);

        botonLimpiarFormularioVendedores_Vendedores.setText("Limpiar Formulario");
        botonLimpiarFormularioVendedores_Vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarFormularioVendedores_VendedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneVendedoresLayout = new javax.swing.GroupLayout(paneVendedores);
        paneVendedores.setLayout(paneVendedoresLayout);
        paneVendedoresLayout.setHorizontalGroup(
            paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneVendedoresLayout.createSequentialGroup()
                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneVendedoresLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelnombreVendedor_Vendedores)
                            .addGroup(paneVendedoresLayout.createSequentialGroup()
                                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTipoDocumentoVendedor_Vendedores)
                                    .addComponent(labelDireccionVendedor_Vendedores)
                                    .addComponent(labelTelefonoVendedor_Vendedores)
                                    .addComponent(labelCiudadVendedor_Vendedores))
                                .addGap(18, 18, 18)
                                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(paneVendedoresLayout.createSequentialGroup()
                                        .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxTipoDocumentoVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCiudadVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(paneVendedoresLayout.createSequentialGroup()
                                                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(labelNumDocVendedor_Vendedores)
                                                    .addComponent(labelDepartamentoVendedor_Vendedores))
                                                .addGap(18, 18, 18)
                                                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtNumeroDocumentoVendedor_Vendedores, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                    .addComponent(txtDepartamentoVendedor_Vendedores)))
                                            .addGroup(paneVendedoresLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(labelCorreoVendedor_Vendedores)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCorreoVendedor_Vendedores, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                                    .addGroup(paneVendedoresLayout.createSequentialGroup()
                                        .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDireccionVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(paneVendedoresLayout.createSequentialGroup()
                                                .addComponent(txtTelefonoVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelCantVentasVendedor_Vendedores)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCantVentasVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelTotalVentas)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalVentasVendedor_vendedores, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                    .addComponent(txtNombreVendedor_Vendedores)))
                            .addComponent(labelTituloGestorVendores_Vendedores)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)))
                    .addGroup(paneVendedoresLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(buttonActualizarListaVendedores_Vendedores))
                    .addGroup(paneVendedoresLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(buttonCrearVendedor_Vendedores)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscarVendedor_Vendedores)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGuardarVendedor_Vendedores)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEliminarVendedor_Vendedores)
                        .addGap(18, 18, 18)
                        .addComponent(botonLimpiarFormularioVendedores_Vendedores)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        paneVendedoresLayout.setVerticalGroup(
            paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneVendedoresLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelTituloGestorVendores_Vendedores)
                .addGap(18, 18, 18)
                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnombreVendedor_Vendedores)
                    .addComponent(txtNombreVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoDocumentoVendedor_Vendedores)
                    .addComponent(txtNumeroDocumentoVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTipoDocumentoVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumDocVendedor_Vendedores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCiudadVendedor_Vendedores)
                    .addComponent(txtCiudadVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDepartamentoVendedor_Vendedores)
                    .addComponent(txtDepartamentoVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCorreoVendedor_Vendedores)
                    .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDireccionVendedor_Vendedores)
                        .addComponent(txtDireccionVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCorreoVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefonoVendedor_Vendedores)
                    .addComponent(txtTelefonoVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCantVentasVendedor_Vendedores)
                    .addComponent(txtCantVentasVendedor_Vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalVentas)
                    .addComponent(txtTotalVentasVendedor_vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCrearVendedor_Vendedores)
                    .addComponent(buttonBuscarVendedor_Vendedores)
                    .addComponent(buttonGuardarVendedor_Vendedores)
                    .addComponent(buttonEliminarVendedor_Vendedores)
                    .addComponent(botonLimpiarFormularioVendedores_Vendedores))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonActualizarListaVendedores_Vendedores)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        tabbedPaneMenu_Pedidos.addTab("Vendedores", paneVendedores);

        labelNombreEmpresa_Empresa.setText("Nombre Empresa:");

        labelNitEmpresa_Empresa.setText("NIT:");

        txtNumeroDocumentoEmpresa_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDocumentoEmpresa_EmpresaActionPerformed(evt);
            }
        });

        txtDepartamentoEmpresa_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoEmpresa_EmpresaActionPerformed(evt);
            }
        });

        labelCiudadEmpresa_Empresa.setText("Ciudad:");

        labelDepartamentoEmpresa_Empresa.setText("Departamento:");

        labelDireccionEmpresa_Empresa.setText("Direccion:");

        txtDireccionEmpresa_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEmpresa_EmpresaActionPerformed(evt);
            }
        });

        labelCorreoEmpresa_Empresa.setText("Correo electronico:");

        labelTelefonoEmpresa_Empresa.setText("Telefono:");

        buttonEliminarEmpresa_Empresa.setText("Eliminar");

        buttonGuardarEmpresa_Empresa.setText("Guardar");
        buttonGuardarEmpresa_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarEmpresa_EmpresaActionPerformed(evt);
            }
        });

        buttonBuscarEmpresa_Empresa.setText("Buscar");
        buttonBuscarEmpresa_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarEmpresa_EmpresaActionPerformed(evt);
            }
        });

        buttonCrearEmpresa_Empresa.setText("Crear");
        buttonCrearEmpresa_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearEmpresa_EmpresaActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("DATOS DE LA EMPRESA");

        javax.swing.GroupLayout paneDatosEmpresaLayout = new javax.swing.GroupLayout(paneDatosEmpresa);
        paneDatosEmpresa.setLayout(paneDatosEmpresaLayout);
        paneDatosEmpresaLayout.setHorizontalGroup(
            paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                            .addComponent(labelNombreEmpresa_Empresa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                            .addGap(358, 358, 358)
                            .addComponent(labelNitEmpresa_Empresa)
                            .addGap(24, 24, 24)
                            .addComponent(txtNumeroDocumentoEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel27)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDatosEmpresaLayout.createSequentialGroup()
                            .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                                    .addComponent(labelTelefonoEmpresa_Empresa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefonoEmpresa_Empresa))
                                .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(labelDireccionEmpresa_Empresa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDireccionEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDatosEmpresaLayout.createSequentialGroup()
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(labelCiudadEmpresa_Empresa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCiudadEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelDepartamentoEmpresa_Empresa)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDepartamentoEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(labelCorreoEmpresa_Empresa)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCorreoEmpresa_Empresa)))))
                    .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(buttonCrearEmpresa_Empresa)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscarEmpresa_Empresa)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGuardarEmpresa_Empresa)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEliminarEmpresa_Empresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        paneDatosEmpresaLayout.setVerticalGroup(
            paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDatosEmpresaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel27)
                .addGap(29, 29, 29)
                .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreEmpresa_Empresa)
                    .addComponent(txtNombreEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNitEmpresa_Empresa)
                    .addComponent(txtNumeroDocumentoEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccionEmpresa_Empresa)
                    .addComponent(txtDireccionEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCiudadEmpresa_Empresa)
                    .addComponent(txtCiudadEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDepartamentoEmpresa_Empresa)
                    .addComponent(txtDepartamentoEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefonoEmpresa_Empresa)
                    .addComponent(txtTelefonoEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorreoEmpresa_Empresa)
                    .addComponent(txtCorreoEmpresa_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCrearEmpresa_Empresa)
                    .addComponent(buttonBuscarEmpresa_Empresa)
                    .addComponent(buttonGuardarEmpresa_Empresa)
                    .addComponent(buttonEliminarEmpresa_Empresa))
                .addContainerGap(317, Short.MAX_VALUE))
        );

        tabbedPaneMenu_Pedidos.addTab("Datos de la Empresa", paneDatosEmpresa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel1)
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneMenu_Pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabbedPaneMenu_Pedidos)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCrearCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearCliente_ClientesActionPerformed
        // TODO add your handling code here:
        //String telefono;
        String nombre = txtNombreCliente_Clientes.getText();
        String tipoDocumento = comboBoxTipoDocumento_Clientes.getSelectedItem().toString();
        String numeroDocumento = txtNumeroDocumento_Clientes.getText();
        String correo = txtCorreoCliente_Clientes.getText();
        String telefono = txtTelefonoCliente_Clientes.getText();
        String ciudad = txtCiudad_Clientes.getText();
        String departamento = txtDepartamentoCliente_Clientes.getText();
        String direccion = txtDireccionCliente_Clientes.getText();
        String fechaNacimiento = txtFechaNacimiento_Cliente.getText();
        
        String[] datosCliente = {nombre,tipoDocumento , numeroDocumento, correo, direccion, telefono, ciudad, departamento,fechaNacimiento};
        
        controladorEmpresa.crearCliente(datosCliente);
        //mostrarTablaClientes();
    }//GEN-LAST:event_buttonCrearCliente_ClientesActionPerformed

    private void buttonBuscarCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarCliente_ClientesActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tablaDatosCliente.getModel();
        String documento = txtNumeroDocumento_Clientes.getText();
        if ( !"".equals(documento)){
            limpiarFormulario("Cliente");
          //0 nombre ,1 ID, 2 Type doct, 3 No. Doct, 4 Fecha N, 5 Ciudad, 6 Departamento, 7 Direccion, 8 Correo,9 Telefono, 10 Cantidad Compras
            String [] matrizCliente = controladorEmpresa.consultarCliente(documento);
            //Cedula de Ciudadania, Tarjeta de Identidad, Cedula de Extranjeria, Pasaporte, 
            int doct = indexDocumento(matrizCliente [2]);
            
            txtIdCliente_Clientes.setText(matrizCliente [0]);
            txtNombreCliente_Clientes.setText(matrizCliente [1]);
            comboBoxTipoDocumento_Clientes.setSelectedIndex(doct);
            txtNumeroDocumento_Clientes.setText(matrizCliente [3]);
            txtDireccionCliente_Clientes.setText(matrizCliente [4]);
            txtTelefonoCliente_Clientes.setText(matrizCliente [5]);
            txtCiudad_Clientes.setText(matrizCliente [6]);
            txtDepartamentoCliente_Clientes.setText(matrizCliente [7]);
            txtCorreoCliente_Clientes.setText(matrizCliente [8]);
            txtFechaNacimiento_Cliente.setText(matrizCliente [9]);
            txtCantCompras.setText(matrizCliente [10]);
        
        }else if (dtm.getValueAt(tablaDatosCliente.getSelectedRow(), 0)!=""){
            // 0 nombre ,1 ID, 2 Type doct, 3 No. Doct, 4 Fecha N, 5 Ciudad, 6 Departamento, 7 Direccion, 8 Correo,9 Telefono, 10 Cantidad Compras
            limpiarFormulario("Cliente");
            String codigo = (String) dtm.getValueAt(tablaDatosCliente.getSelectedRow(), 0);
            String doc = controladorEmpresa.getCliente().consultarDocumentoCliente(codigo);
            String [] matrizCliente = controladorEmpresa.consultarCliente(doc);
            int doct = indexDocumento(matrizCliente [2]);
            
            txtIdCliente_Clientes.setText(matrizCliente [0]);
            txtNombreCliente_Clientes.setText(matrizCliente [1]);
            comboBoxTipoDocumento_Clientes.setSelectedIndex(doct);
            txtNumeroDocumento_Clientes.setText(matrizCliente [3]);
            txtDireccionCliente_Clientes.setText(matrizCliente [4]);
            txtTelefonoCliente_Clientes.setText(matrizCliente [5]);
            txtCiudad_Clientes.setText(matrizCliente [6]);
            txtDepartamentoCliente_Clientes.setText(matrizCliente [7]);
            txtCorreoCliente_Clientes.setText(matrizCliente [8]);
            txtFechaNacimiento_Cliente.setText(matrizCliente [9]);
            txtCantCompras.setText(matrizCliente [10]);
        }
        
    }//GEN-LAST:event_buttonBuscarCliente_ClientesActionPerformed
    
    private void buttonGuardarDatosCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarDatosCliente_ClientesActionPerformed
        // TODO add your handling code here:
        
        int idCliente = Integer.parseInt(txtIdCliente_Clientes.getText());
        String nombre = txtNombreCliente_Clientes.getText();
        String correo = txtCorreoCliente_Clientes.getText();
        String telefono = txtTelefonoCliente_Clientes.getText();
        String ciudad = txtCiudad_Clientes.getText();
        String numeroDocumento = txtNumeroDocumento_Clientes.getText();
        String tipoDocumento = comboBoxTipoDocumento_Clientes.getSelectedItem().toString();
        String fechaNacimiento = txtFechaNacimiento_Cliente.getText();
        String direccion = txtDireccionCliente_Clientes.getText();
        String departamento = txtDepartamentoCliente_Clientes.getText();
        int cantidadCompras = Integer.parseInt(txtCantCompras.getText());
        
        String[] datosCliente = {""+idCliente, nombre, tipoDocumento, numeroDocumento, fechaNacimiento, direccion, telefono, ciudad, departamento, correo, ""+cantidadCompras};
        
        controladorEmpresa.actualizarCliente(datosCliente); 
        //mostrarTablaClientes();   
    }//GEN-LAST:event_buttonGuardarDatosCliente_ClientesActionPerformed

    private void txtNumeroDocumento_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDocumento_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDocumento_ClientesActionPerformed

    private void txtDireccionCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionCliente_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionCliente_ClientesActionPerformed

    private void txtDepartamentoCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoCliente_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoCliente_ClientesActionPerformed

    private void comboBoxTipoDocumento_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoDocumento_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoDocumento_ClientesActionPerformed

    private void comboBoxTipoDocumentoVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoDocumentoVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoDocumentoVendedor_VendedoresActionPerformed

    private void txtNumeroDocumentoVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDocumentoVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDocumentoVendedor_VendedoresActionPerformed

    private void txtDepartamentoVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoVendedor_VendedoresActionPerformed

    private void txtDireccionVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionVendedor_VendedoresActionPerformed

    private void buttonGuardarVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
        
        String nombre = txtNombreVendedor_Vendedores.getText();
        String tipoDocumento = comboBoxTipoDocumentoVendedor_Vendedores.getSelectedItem().toString();
        String numeroDocumento = txtNumeroDocumentoVendedor_Vendedores.getText();
        String correo = txtCorreoVendedor_Vendedores.getText();
        String telefono = txtTelefonoVendedor_Vendedores.getText();
        String ciudad = txtCiudadVendedor_Vendedores.getText();
        String departamento = txtDepartamentoVendedor_Vendedores.getText();
        String direccion = txtDireccionVendedor_Vendedores.getText();
        
        
        String [] datosVendedor = {nombre,tipoDocumento,numeroDocumento,direccion,correo,telefono, ciudad, departamento};
        

        controladorEmpresa.actualizarVendedor(datosVendedor);
        
        
        
        
    }//GEN-LAST:event_buttonGuardarVendedor_VendedoresActionPerformed
        
    private void buttonBuscarVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dtm = (DefaultTableModel) tablaVendedores_Vendedores.getModel();
        String documento = txtNumeroDocumentoVendedor_Vendedores.getText();
        if (!"".equals(documento)){
          //1 nombre , 2 Type doct, 3 No. Doct, 4 Ciudad, 5 Departamento, 6 Direccion, 7 Correo, 8 Telefono,  9 Cantidad Ventas, 10 Total Ventas
            limpiarFormulario("Vendedor");
            String [] matrizVendedor = controladorEmpresa.consultarVendedor(documento);
            int doct = indexDocumento(matrizVendedor [2]);
            
            txtNombreVendedor_Vendedores.setText(matrizVendedor [1]);
            comboBoxTipoDocumentoVendedor_Vendedores.setSelectedIndex(doct);
            txtNumeroDocumentoVendedor_Vendedores.setText(matrizVendedor [3]);
            txtDireccionVendedor_Vendedores.setText(matrizVendedor [4]);
            txtTelefonoVendedor_Vendedores.setText(matrizVendedor [5]);
            txtCiudadVendedor_Vendedores.setText(matrizVendedor [6]);
            txtDepartamentoVendedor_Vendedores.setText(matrizVendedor [7]);
            txtCorreoVendedor_Vendedores.setText(matrizVendedor [8]);
            txtCantVentasVendedor_Vendedores.setText(matrizVendedor [9]);
            txtTotalVentasVendedor_vendedores.setText(matrizVendedor [10]);
            
        
        }else if (dtm.getValueAt(tablaVendedores_Vendedores.getSelectedRow(), 0)!=""){
            //1 nombre , 2 Type doct, 3 No. Doct, 4 Ciudad, 5 Departamento, 6 Direccion, 7 Correo, 8 Telefono,  9 Cantidad Ventas, 10 Total Ventas
            limpiarFormulario("Vendedor");
            String id = (String) dtm.getValueAt(tablaVendedores_Vendedores.getSelectedRow(), 0);
            String doc = controladorEmpresa.getVendedor().consultarDocumentoVendedor(id);
            String [] matrizVendedor = controladorEmpresa.consultarVendedor(doc);
            int doct = indexDocumento(matrizVendedor [2]);
            txtNombreVendedor_Vendedores.setText(matrizVendedor [1]);
            comboBoxTipoDocumentoVendedor_Vendedores.setSelectedIndex(doct);
            txtNumeroDocumentoVendedor_Vendedores.setText(matrizVendedor [3]);
            txtDireccionVendedor_Vendedores.setText(matrizVendedor [4]);
            txtTelefonoVendedor_Vendedores.setText(matrizVendedor [5]);
            txtCiudadVendedor_Vendedores.setText(matrizVendedor [6]);
            txtDepartamentoVendedor_Vendedores.setText(matrizVendedor [7]);
            txtCorreoVendedor_Vendedores.setText(matrizVendedor [8]);
            txtCantVentasVendedor_Vendedores.setText(matrizVendedor [9]);
            txtTotalVentasVendedor_vendedores.setText(matrizVendedor [10]);
        }
        
        
        
    }//GEN-LAST:event_buttonBuscarVendedor_VendedoresActionPerformed

    private void buttonCrearVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombreVendedor_Vendedores.getText();
        String correo = txtCorreoVendedor_Vendedores.getText();
        String telefono = txtTelefonoVendedor_Vendedores.getText();
        String ciudad = txtCiudadVendedor_Vendedores.getText();
        String departamento = txtDepartamentoVendedor_Vendedores.getText();
        String numeroDocumento = txtNumeroDocumentoVendedor_Vendedores.getText();
        String tipoDocumento = comboBoxTipoDocumentoVendedor_Vendedores.getSelectedItem().toString();
        String direccion = txtDireccionVendedor_Vendedores.getText();
        
        
        String [] datosVendedor = {nombre,tipoDocumento,numeroDocumento,direccion,correo,telefono, ciudad, departamento};
        

        controladorEmpresa.crearVendedor(datosVendedor);
    }//GEN-LAST:event_buttonCrearVendedor_VendedoresActionPerformed
    
    private void txtNumeroDocumento_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDocumento_ProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDocumento_ProveedoresActionPerformed

    private void txtDepartamentoProveedor_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoProveedor_ProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoProveedor_ProveedoresActionPerformed

    private void txtDireccionProveedor_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionProveedor_ProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionProveedor_ProveedoresActionPerformed

    private void buttonGuardarProveedor_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarProveedor_ProveedoresActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombreProveedor_Proveedores.getText();
        String numeroDocumento = txtNumeroDocumento_Proveedores.getText();
        String correo = txtCorreoProveedor_Proveedores.getText();
        String telefono = txtTelefonoProveedor_Proveedores.getText();
        String ciudad = txtCiudadProveedor_Proveedores.getText();
        String departamento = txtDepartamentoProveedor_Proveedores.getText();
        String direccion = txtDireccionProveedor_Proveedores.getText();
        
        String[] datosProveedor = {nombre, numeroDocumento, correo, direccion, telefono, ciudad, departamento};
        
        controladorEmpresa.actualizarProveedor(datosProveedor);
    }//GEN-LAST:event_buttonGuardarProveedor_ProveedoresActionPerformed

    private void buttonBuscarProveedor_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarProveedor_ProveedoresActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dtm = (DefaultTableModel) tablaProveedores_Proveedores.getModel();
        String documento=txtNumeroDocumento_Proveedores.getText();
        if (!"".equals(documento)){
          //0 id Proveedor,1 nombre,  3 tipoDocumento, 4 numeroDocumento, 5 ciudad, 6 departamento, 7 direccion, 8 correo, 9 telefono
          limpiarFormulario("Proveedor");
          String [] matrizProveedor = controladorEmpresa.consultarProveedor(documento);
            txtNombreProveedor_Proveedores.setText(matrizProveedor [1]);
            txtNumeroDocumento_Proveedores.setText(matrizProveedor [3]);
            txtDireccionProveedor_Proveedores.setText(matrizProveedor[4]);
            txtTelefonoProveedor_Proveedores.setText(matrizProveedor [5]);
            txtCiudadProveedor_Proveedores.setText(matrizProveedor [6]);
            txtDepartamentoProveedor_Proveedores.setText(matrizProveedor [7]);
            txtCorreoProveedor_Proveedores.setText(matrizProveedor [8]);
            
            
        }else if (dtm.getValueAt(tablaProveedores_Proveedores.getSelectedRow(), 0)!=""){
            limpiarFormulario("Proveedor");
            String codigo = (String) dtm.getValueAt(tablaProveedores_Proveedores.getSelectedRow(), 0);
            System.out.println(""+codigo);
            String [] matrizProveedor = controladorEmpresa.consultarProveedor(codigo);
            
            txtNombreProveedor_Proveedores.setText(matrizProveedor [1]);
            txtNumeroDocumento_Proveedores.setText(matrizProveedor [3]);
            txtDireccionProveedor_Proveedores.setText(matrizProveedor[4]);
            txtTelefonoProveedor_Proveedores.setText(matrizProveedor [5]);
            txtCiudadProveedor_Proveedores.setText(matrizProveedor [6]);
            txtDepartamentoProveedor_Proveedores.setText(matrizProveedor [7]);
            txtCorreoProveedor_Proveedores.setText(matrizProveedor [8]);
        
        }else{
            
            JOptionPane.showInputDialog("Debe de llenar el campo de Identificación del Cliente correctamente o Seleccionar un elemento de la tabla");
        }
        
    }//GEN-LAST:event_buttonBuscarProveedor_ProveedoresActionPerformed

    private void buttonCrearProveedor_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearProveedor_ProveedoresActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombreProveedor_Proveedores.getText();
        String direccion = txtDireccionProveedor_Proveedores.getText();
        String correo = txtCorreoProveedor_Proveedores.getText();
        String telefono = txtTelefonoProveedor_Proveedores.getText();
        String ciudad = txtCiudadProveedor_Proveedores.getText();
        String departamento = txtDepartamentoProveedor_Proveedores.getText();
        String numeroDocumento = txtNumeroDocumento_Proveedores.getText();
        
        String[] datosProveedor = {nombre,numeroDocumento,direccion,correo,telefono, ciudad, departamento};
        controladorEmpresa.crearProveedor(datosProveedor);
    }//GEN-LAST:event_buttonCrearProveedor_ProveedoresActionPerformed

    private void paneVendedoresAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_paneVendedoresAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_paneVendedoresAncestorMoved

    private void txtNombreVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreVendedor_VendedoresActionPerformed

    private void buttonLimpiarFormularioCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarFormularioCliente_ClientesActionPerformed
        // TODO add your handling code here:
        
        limpiarFormulario("Cliente");
        
    }//GEN-LAST:event_buttonLimpiarFormularioCliente_ClientesActionPerformed

    private void botonMostrarProveedores_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarProveedores_ProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMostrarProveedores_ProveedoresActionPerformed

    private void txtNumeroDocumentoEmpresa_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDocumentoEmpresa_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDocumentoEmpresa_EmpresaActionPerformed

    private void txtDepartamentoEmpresa_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoEmpresa_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoEmpresa_EmpresaActionPerformed

    private void txtDireccionEmpresa_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEmpresa_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionEmpresa_EmpresaActionPerformed

    private void buttonGuardarEmpresa_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarEmpresa_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGuardarEmpresa_EmpresaActionPerformed

    private void buttonBuscarEmpresa_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarEmpresa_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBuscarEmpresa_EmpresaActionPerformed

    private void buttonCrearEmpresa_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearEmpresa_EmpresaActionPerformed
        // TODO add your handling code here:
        controladorEmpresa.setNombre(txtNombreEmpresa_Empresa.getText());
        controladorEmpresa.setNroDocumento(txtNumeroDocumentoEmpresa_Empresa.getText());
        controladorEmpresa.setDireccion(txtDireccionEmpresa_Empresa.getText());
        controladorEmpresa.setCiudad(txtCiudadEmpresa_Empresa.getText());
        controladorEmpresa.setDepartamento(txtDepartamentoEmpresa_Empresa.getText());
        controladorEmpresa.setTelefono(txtTelefonoEmpresa_Empresa.getText());
        controladorEmpresa.setCorreo(txtCorreoEmpresa_Empresa.getText());
        
    }//GEN-LAST:event_buttonCrearEmpresa_EmpresaActionPerformed

    private void buttonBuscarCliente_PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarCliente_PedidosActionPerformed
        // TODO add your handling code here:
        String documento = txtNumeroDocumentoCliente_Pedido.getText();
        
        //0 nombre ,1 ID, 2 Type doct, 3 No. Doct, 4 Fecha N, 5 Ciudad, 6 Departamento, 7 Direccion, 8 Correo,9 Telefono, 10 Cantidad Compras
        String [] matrizCliente = controladorEmpresa.consultarCliente(documento);
        int doct = indexDocumento(matrizCliente [2]);
        
        txtNameCliente_Pedido.setText(matrizCliente [1]);
        comboBoxTypeDocClient_Pedido.setSelectedIndex(doct);
        txtNumeroDocumentoCliente_Pedido.setText(matrizCliente [3]);
        txtDireccionCliente_Pedido.setText(matrizCliente [4]);
        txtEmailClient_Pedido.setText(matrizCliente [8]);
        
    }//GEN-LAST:event_buttonBuscarCliente_PedidosActionPerformed

    private void botonConsultarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonConsultarPedidoActionPerformed

    private void txtIdCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCliente_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCliente_ClientesActionPerformed

    private void buttonLimpiarFormulario_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarFormulario_PedidoActionPerformed
        // TODO add your handling code here:
        
        limpiarFormulario("Pedido");
        
        comboBoxVendedores();
        comboBoxProductos();
    }//GEN-LAST:event_buttonLimpiarFormulario_PedidoActionPerformed

    private void botonLimpiarFormularioProveedores_Proveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarFormularioProveedores_Proveedores1ActionPerformed
        // TODO add your handling code here:
        limpiarFormulario("Proveedor");
    }//GEN-LAST:event_botonLimpiarFormularioProveedores_Proveedores1ActionPerformed

    private void buttonEliminarCliente_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarCliente_ClientesActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tablaDatosCliente.getModel();
        String documento=txtNumeroDocumento_Clientes.getText();
        if ( "" != documento){
            String documentoCliente = txtNumeroDocumento_Clientes.getText();
            
            if (controladorEmpresa.delete()){
            controladorEmpresa.eliminarCliente(documentoCliente);
            }
            limpiarFormulario("Cliente");
        }
        
    }//GEN-LAST:event_buttonEliminarCliente_ClientesActionPerformed

    private void buttonActualizarTabla_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarTabla_ClientesActionPerformed
        // TODO add your handling code here:
        
       mostrarTablaClientes();
       
    }//GEN-LAST:event_buttonActualizarTabla_ClientesActionPerformed

    private void txtFechaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaPedidoActionPerformed

    private void buttonCrearProducto_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearProducto_productosActionPerformed
        // TODO add your handling code here:
        String codigo = txtCodigoProducto_Productos.getText();
        String nombreProducto = txtNombreProducto_Productos.getText();
        String descripcion = txtAreaDescripcionProducto_Producto.getText();
        int precioUnitario = Integer.parseInt(txtPrecioUnitario_Producto.getText());
        int cantidad = Integer.parseInt(txtCantidadInventario_Producto.getText());
        String proveedor = txtIdProveedor_productos.getText();
        controladorEmpresa.crearProducto(nombreProducto, codigo, descripcion, precioUnitario, cantidad, proveedor);
        
    }//GEN-LAST:event_buttonCrearProducto_productosActionPerformed

    private void tabbedPaneMenu_PedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMenu_PedidosMouseClicked
        // TODO add your handling code here:
        comboBoxVendedores();
        comboBoxProductos();
        limpiarFormulario("Producto");
        comboBoxProveedorProducto_Productos.removeAllItems();
        String[] proveedores = controladorEmpresa.listaProveedores();
        for (int i = 0; i < proveedores.length; i++) {
            comboBoxProveedorProducto_Productos.addItem(proveedores[i]);
        }
        
        
        
        
    }//GEN-LAST:event_tabbedPaneMenu_PedidosMouseClicked

    private void botonLimpiarFormularioVendedores_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarFormularioVendedores_VendedoresActionPerformed
        // TODO add your handling code here:
        limpiarFormulario("Vendedor");
    }//GEN-LAST:event_botonLimpiarFormularioVendedores_VendedoresActionPerformed

    private void buttonLimpiarFormularioProducto_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarFormularioProducto_ProductosActionPerformed
        // TODO add your handling code here:
        limpiarFormulario("Producto");
        
    }//GEN-LAST:event_buttonLimpiarFormularioProducto_ProductosActionPerformed

    private void buttonLimpiarFormularioPaquete_PaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarFormularioPaquete_PaquetesActionPerformed
        // TODO add your handling code here:
        
        limpiarFormulario("Paquete");
        
    }//GEN-LAST:event_buttonLimpiarFormularioPaquete_PaquetesActionPerformed

    private void buttonEliminarProducto_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarProducto_productosActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_buttonEliminarProducto_productosActionPerformed

    private void buttonEliminarProveedor_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarProveedor_ProveedoresActionPerformed
        // TODO add your handling code here:
        String documento = txtNumeroDocumento_Proveedores.getText();
        
        if ( "" != documento){
            String documentoProveedor = txtNumeroDocumento_Proveedores.getText();
            
            if (controladorEmpresa.delete()){
            controladorEmpresa.eliminarProveedor(documentoProveedor);
            }
            limpiarFormulario("Proveedor");
        }
        limpiarFormulario("Proveedor");
    }//GEN-LAST:event_buttonEliminarProveedor_ProveedoresActionPerformed

    private void buttonEliminarVendedor_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarVendedor_VendedoresActionPerformed
        // TODO add your handling code here:
        String documento = txtNumeroDocumentoVendedor_Vendedores.getText();
        if ( "" != documento){
            String documentoVendedor = txtNumeroDocumentoVendedor_Vendedores.getText();
            
            if (controladorEmpresa.delete()){
            controladorEmpresa.eliminarVendedor(documentoVendedor);
            }
            limpiarFormulario("Vendedor");
        }
        limpiarFormulario("Vendedor");
                               
        
        
        
    }//GEN-LAST:event_buttonEliminarVendedor_VendedoresActionPerformed

    private void comboBoxProveedorProducto_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProveedorProducto_ProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProveedorProducto_ProductosActionPerformed

    private void tabbedPaneMenu_PedidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabbedPaneMenu_PedidosKeyPressed
        // TODO add your handling code here:
        limpiarFormulario("Pedido");
        comboBoxVendedores();
    }//GEN-LAST:event_tabbedPaneMenu_PedidosKeyPressed

    private void comboBoxVendedores_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVendedores_PedidoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_comboBoxVendedores_PedidoActionPerformed

    private void comboBoxVendedores_PedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxVendedores_PedidoMouseClicked
        // TODO add your handling code here:
       
        String nombreVendedor = comboBoxVendedores_Pedido.getSelectedItem().toString();
        int idVendedor = controladorEmpresa.getVendedor().consultarIdVendedorNombre(nombreVendedor);
        txtIdVendedor_pedido.setText(""+idVendedor); 
       
    }//GEN-LAST:event_comboBoxVendedores_PedidoMouseClicked

    private void buttonActualizarListaVendedores_VendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarListaVendedores_VendedoresActionPerformed
        // TODO add your handling code here:
        mostrarTablaVendedores();
    }//GEN-LAST:event_buttonActualizarListaVendedores_VendedoresActionPerformed

    private void comboBoxProveedorProducto_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxProveedorProducto_ProductosMouseClicked
        // TODO add your handling code here:
        
        String nombreProveedor = comboBoxProveedorProducto_Productos.getSelectedItem().toString();
        String idProveedor = ""+controladorEmpresa.getProveedor().consultarIdProveedorNombre(nombreProveedor);
        txtIdProveedor_productos.setText(idProveedor);
        
    }//GEN-LAST:event_comboBoxProveedorProducto_ProductosMouseClicked

    private void buttonActualizarListaProductos_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarListaProductos_ProductosActionPerformed
        // TODO add your handling code here:
        mostrarTablaProductos();
    }//GEN-LAST:event_buttonActualizarListaProductos_ProductosActionPerformed

    private void buttonBuscarrProducto_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarrProducto_productosActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dtm = (DefaultTableModel) tablaProductos_Producto.getModel();
        String codigoProducto=txtCodigoProducto_Productos.getText();
        if (!"".equals(codigoProducto)){
          //0 id Proveedor,1 nombre,  3 tipoDocumento, 4 numeroDocumento, 5 ciudad, 6 departamento, 7 direccion, 8 correo, 9 telefono
          limpiarFormulario("Producto");
            String [] matrizProducto = controladorEmpresa.consultarProducto(codigoProducto);
            // "id", "nombreProducto","descripcion","precio_unitario","cantidad_inventario","id_proveedor"
            txtCodigoProducto_Productos.setText(matrizProducto [0]);
            txtNombreProducto_Productos.setText(matrizProducto [1]);
            txtAreaDescripcionProducto_Producto.setText(matrizProducto[2]);
            txtPrecioUnitario_Producto.setText(matrizProducto [3]);
            txtCantidadInventario_Producto.setText(matrizProducto [4]);
            comboBoxProveedorProducto_Productos.setSelectedItem(matrizProducto [5]);
            String nombreProveedor = comboBoxProveedorProducto_Productos.getSelectedItem().toString();
            String idProveedor = ""+controladorEmpresa.getProveedor().consultarIdProveedorNombre(nombreProveedor);
            txtIdProveedor_productos.setText(idProveedor);
            
            
            
        }else if (dtm.getValueAt(tablaProductos_Producto.getSelectedRow(), 0)!=""){
            limpiarFormulario("Producto");
            String codigo = (String) dtm.getValueAt(tablaProductos_Producto.getSelectedRow(), 0);
            String [] matrizProducto = controladorEmpresa.consultarProducto(codigo);
            
            txtCodigoProducto_Productos.setText(matrizProducto [0]);
            txtNombreProducto_Productos.setText(matrizProducto [1]);
            txtAreaDescripcionProducto_Producto.setText(matrizProducto[2]);
            txtPrecioUnitario_Producto.setText(matrizProducto [3]);
            txtCantidadInventario_Producto.setText(matrizProducto [4]);
            comboBoxProveedorProducto_Productos.setSelectedItem(matrizProducto [5]);
            String nombreProveedor = comboBoxProveedorProducto_Productos.getSelectedItem().toString();
            String idProveedor = ""+controladorEmpresa.getProveedor().consultarIdProveedorNombre(nombreProveedor);
            txtIdProveedor_productos.setText(idProveedor);
        
        }else{
            
            JOptionPane.showInputDialog("Debe de llenar el campo de Identificación del Cliente correctamente o Seleccionar un elemento de la tabla");
        }
        
        
    }//GEN-LAST:event_buttonBuscarrProducto_productosActionPerformed

    private void buttonGuardarProducto_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarProducto_productosActionPerformed
        // TODO add your handling code here:
        String[] datosProducto = new String[6];
        String codigo = txtCodigoProducto_Productos.getText();
        String nombreProducto = txtNombreProducto_Productos.getText();
        String descripcion = txtAreaDescripcionProducto_Producto.getText();
        String precioUnitario = txtPrecioUnitario_Producto.getText();
        String cantidad = txtCantidadInventario_Producto.getText();
        String proveedor = txtIdProveedor_productos.getText();
        
        datosProducto[0]= nombreProducto;
        datosProducto[1]= codigo;
        datosProducto[2]= descripcion;
        datosProducto[3]= precioUnitario;
        datosProducto[4]= cantidad;
        datosProducto[5]= proveedor;
        
        controladorEmpresa.actualizarProducto(datosProducto);
        
    }//GEN-LAST:event_buttonGuardarProducto_productosActionPerformed

    private void comboBoxItems_PedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxItems_PedidoMouseClicked
        // TODO add your handling code here:
        codigoProducto_pedido();
        String codigoProducto = txtProductCode_Pedido.getText();
        String[] datosProducto = controladorEmpresa.consultarProducto(codigoProducto);
         txtProductUnitPrice_Pedido.setText("");
        txtProductUnitPrice_Pedido.setText(datosProducto[3]);
        
    }//GEN-LAST:event_comboBoxItems_PedidoMouseClicked

    private void añadirProducto_PedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_añadirProducto_PedidoMouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_añadirProducto_PedidoMouseClicked

    private void añadirProducto_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirProducto_PedidoActionPerformed
        // TODO add your handling code here:
        agregarProducto_pedido();
    }//GEN-LAST:event_añadirProducto_PedidoActionPerformed

    private void botonCancelarPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarPedidoMouseClicked
        // TODO add your handling code here:
        if (controladorEmpresa.delete()){
            borrarTablaProducto_pedido();
        }
        
        
    }//GEN-LAST:event_botonCancelarPedidoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirProducto_Pedido;
    private javax.swing.JButton botonCancelarPedido;
    private javax.swing.JButton botonConsultarPedido;
    private javax.swing.JButton botonCrearPedido;
    private javax.swing.JButton botonEditarPedido;
    private javax.swing.JButton botonEliminarItemPedido;
    private javax.swing.JButton botonLimpiarFormularioProveedores_Proveedores1;
    private javax.swing.JButton botonLimpiarFormularioVendedores_Vendedores;
    private javax.swing.JButton botonMostrarProveedores_Proveedores;
    private javax.swing.JButton buttonActualizarListaProductos_Productos;
    private javax.swing.JButton buttonActualizarListaVendedores_Vendedores;
    private javax.swing.JButton buttonActualizarLista__Inventario;
    private javax.swing.JButton buttonActualizarTabla_Clientes;
    private javax.swing.JButton buttonAgregarInventario_Inventario;
    private javax.swing.JButton buttonAgregarProducto_Paquetes;
    private javax.swing.JButton buttonBuscarCliente_Clientes;
    private javax.swing.JButton buttonBuscarCliente_Pedidos;
    private javax.swing.JButton buttonBuscarEmpresa_Empresa;
    private javax.swing.JButton buttonBuscarPaquete_Paquetes;
    private javax.swing.JButton buttonBuscarProveedor_Proveedores;
    private javax.swing.JButton buttonBuscarVendedor_Vendedores;
    private javax.swing.JButton buttonBuscarrProducto_productos;
    private javax.swing.JButton buttonCrearCliente_Clientes;
    private javax.swing.JButton buttonCrearEmpresa_Empresa;
    private javax.swing.JButton buttonCrearPaquete_Paquetes;
    private javax.swing.JButton buttonCrearProducto_productos;
    private javax.swing.JButton buttonCrearProveedor_Proveedores;
    private javax.swing.JButton buttonCrearVendedor_Vendedores;
    private javax.swing.JButton buttonEliminarCliente_Clientes;
    private javax.swing.JButton buttonEliminarEmpresa_Empresa;
    private javax.swing.JButton buttonEliminarItem_Inventario;
    private javax.swing.JButton buttonEliminarPaquete_Paquetes;
    private javax.swing.JButton buttonEliminarProducto_productos;
    private javax.swing.JButton buttonEliminarProveedor_Proveedores;
    private javax.swing.JButton buttonEliminarVendedor_Vendedores;
    private javax.swing.JButton buttonGuardarDatosCliente_Clientes;
    private javax.swing.JButton buttonGuardarEmpresa_Empresa;
    private javax.swing.JButton buttonGuardarPaquete_Paquetes;
    private javax.swing.JButton buttonGuardarProducto_productos;
    private javax.swing.JButton buttonGuardarProveedor_Proveedores;
    private javax.swing.JButton buttonGuardarVendedor_Vendedores;
    private javax.swing.JButton buttonLimpiarFormularioCliente_Clientes;
    private javax.swing.JButton buttonLimpiarFormularioPaquete_Paquetes;
    private javax.swing.JButton buttonLimpiarFormularioProducto_Productos;
    private javax.swing.JButton buttonLimpiarFormulario_Pedido;
    private javax.swing.JComboBox<String> comboBoxItems_Pedido;
    private javax.swing.JComboBox<String> comboBoxProveedorProducto_Productos;
    private javax.swing.JComboBox<String> comboBoxTipoDocumentoVendedor_Vendedores;
    private javax.swing.JComboBox<String> comboBoxTipoDocumento_Clientes;
    private javax.swing.JComboBox<String> comboBoxTypeDocClient_Pedido;
    private javax.swing.JComboBox<String> comboBoxVendedores_Pedido;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelAddressClient;
    private javax.swing.JLabel labelCantVentasVendedor_Vendedores;
    private javax.swing.JLabel labelCantidadInventario_Producto;
    private javax.swing.JLabel labelCantidadProducto_Pedido;
    private javax.swing.JLabel labelCiudadCliente_Cliente;
    private javax.swing.JLabel labelCiudadEmpresa_Empresa;
    private javax.swing.JLabel labelCiudadProveedor_Proveedores;
    private javax.swing.JLabel labelCiudadVendedor_Vendedores;
    private javax.swing.JLabel labelCliente_Pedido;
    private javax.swing.JLabel labelCodPaquete_Paquetes;
    private javax.swing.JLabel labelCodProducto_Productos;
    private javax.swing.JLabel labelCodigoProducto_Pedido;
    private javax.swing.JLabel labelCorreoCliente;
    private javax.swing.JLabel labelCorreoElectronicoCliente_Clientes;
    private javax.swing.JLabel labelCorreoEmpresa_Empresa;
    private javax.swing.JLabel labelCorreoProveedor_Proveedores;
    private javax.swing.JLabel labelCorreoVendedor_Vendedores;
    private javax.swing.JLabel labelDepartamentoCliente_Cliente;
    private javax.swing.JLabel labelDepartamentoEmpresa_Empresa;
    private javax.swing.JLabel labelDepartamentoProveedor_Proveedores;
    private javax.swing.JLabel labelDepartamentoVendedor_Vendedores;
    private javax.swing.JLabel labelDescripcionPaquete_Paquetes;
    private javax.swing.JLabel labelDescripcionProducto_Producto;
    private javax.swing.JLabel labelDescuentoPaquete_Paquetes;
    private javax.swing.JLabel labelDireccionCliente_Clientes;
    private javax.swing.JLabel labelDireccionEmpresa_Empresa;
    private javax.swing.JLabel labelDireccionProveedor_Proveedores;
    private javax.swing.JLabel labelDireccionVendedor_Vendedores;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFechaNacimientoCliente_Clientes;
    private javax.swing.JLabel labelIdCliente_Clientes;
    private javax.swing.JLabel labelIdDocClient_Pedido;
    private javax.swing.JLabel labelIdProveedor_productos;
    private javax.swing.JLabel labelIdVendedor_Pedidos;
    private javax.swing.JLabel labelNameClient;
    private javax.swing.JLabel labelNitEmpresa_Empresa;
    private javax.swing.JLabel labelNitProveedor_Proveedores;
    private javax.swing.JLabel labelNombreCliente_Clientes;
    private javax.swing.JLabel labelNombreEmpresa_Empresa;
    private javax.swing.JLabel labelNombrePaquete_Paquetes;
    private javax.swing.JLabel labelNombreProducto_Productos;
    private javax.swing.JLabel labelNombreProveedor_Proveedores;
    private javax.swing.JLabel labelNumComprasCliente_Clientes;
    private javax.swing.JLabel labelNumDocVendedor_Vendedores;
    private javax.swing.JLabel labelNumeroDocumento;
    private javax.swing.JLabel labelPrecioPaquete_Paquetes;
    private javax.swing.JLabel labelPrecioProducto_Pedido;
    private javax.swing.JLabel labelPrecioUnitario_Producto;
    private javax.swing.JLabel labelProducto_Pedido;
    private javax.swing.JLabel labelProveedor_Producto;
    private javax.swing.JLabel labelTelefonoCliente_Clientes;
    private javax.swing.JLabel labelTelefonoEmpresa_Empresa;
    private javax.swing.JLabel labelTelefonoProveedor_Proveedores;
    private javax.swing.JLabel labelTelefonoVendedor_Vendedores;
    private javax.swing.JLabel labelTipoDocumentoVendedor_Vendedores;
    private javax.swing.JLabel labelTipoDocumento_Clientes;
    private javax.swing.JLabel labelTituloGestorVendores_Vendedores;
    private javax.swing.JLabel labelTituloModuloClientes;
    private javax.swing.JLabel labelTituloModuloPEdidos;
    private javax.swing.JLabel labelTituloProductosDelPedido_Pedido;
    private javax.swing.JLabel labelTituloProductos_Pedido;
    private javax.swing.JLabel labelTotalVentas;
    private javax.swing.JLabel labelnombreVendedor_Vendedores;
    private javax.swing.JLabel lavelNombreVendedor_Pedido;
    private javax.swing.JPanel paneDatosEmpresa;
    private javax.swing.JPanel panePaquete;
    private javax.swing.JPanel paneProducto;
    private javax.swing.JPanel paneProveedores;
    private javax.swing.JPanel paneVendedores;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelInventario;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JTabbedPane tabbedPaneMenu_Pedidos;
    private javax.swing.JTable tablaDatosCliente;
    private javax.swing.JTable tablaInventarioProductos_Inventario;
    private javax.swing.JTable tablaPaquete_Paquetes;
    private javax.swing.JTable tablaProductos_Pedidos;
    private javax.swing.JTable tablaProductos_Producto;
    private javax.swing.JTable tablaProveedores_Proveedores;
    private javax.swing.JTable tablaVendedores_Vendedores;
    private javax.swing.JTextArea txtAreaDescripcionPaquete_Paquetes;
    private javax.swing.JTextArea txtAreaDescripcionProducto_Producto;
    private javax.swing.JTextField txtCantCompras;
    private javax.swing.JTextField txtCantVentasVendedor_Vendedores;
    private javax.swing.JTextField txtCantidadInventario_Producto;
    private javax.swing.JTextField txtCantidadProducto_Pedido;
    private javax.swing.JTextField txtCiudadEmpresa_Empresa;
    private javax.swing.JTextField txtCiudadProveedor_Proveedores;
    private javax.swing.JTextField txtCiudadVendedor_Vendedores;
    private javax.swing.JTextField txtCiudad_Clientes;
    private javax.swing.JTextField txtCodigoPaquete_Paquetes;
    private javax.swing.JTextField txtCodigoProducto_Productos;
    private javax.swing.JTextField txtCorreoCliente_Clientes;
    private javax.swing.JTextField txtCorreoEmpresa_Empresa;
    private javax.swing.JTextField txtCorreoProveedor_Proveedores;
    private javax.swing.JTextField txtCorreoVendedor_Vendedores;
    private javax.swing.JTextField txtDepartamentoCliente_Clientes;
    private javax.swing.JTextField txtDepartamentoEmpresa_Empresa;
    private javax.swing.JTextField txtDepartamentoProveedor_Proveedores;
    private javax.swing.JTextField txtDepartamentoVendedor_Vendedores;
    private javax.swing.JTextField txtDescuentoPaquete_Paquetes;
    private javax.swing.JTextField txtDireccionCliente_Clientes;
    private javax.swing.JTextField txtDireccionCliente_Pedido;
    private javax.swing.JTextField txtDireccionEmpresa_Empresa;
    private javax.swing.JTextField txtDireccionProveedor_Proveedores;
    private javax.swing.JTextField txtDireccionVendedor_Vendedores;
    private javax.swing.JTextField txtEmailClient_Pedido;
    private javax.swing.JTextField txtFechaNacimiento_Cliente;
    private javax.swing.JTextField txtFechaPedido;
    private javax.swing.JTextField txtIdCliente_Clientes;
    private javax.swing.JTextField txtIdProveedor_productos;
    private javax.swing.JTextField txtIdVendedor_pedido;
    private javax.swing.JTextField txtNameCliente_Pedido;
    private javax.swing.JTextField txtNombreCliente_Clientes;
    private javax.swing.JTextField txtNombreEmpresa_Empresa;
    private javax.swing.JTextField txtNombrePaquete_Paquetes;
    private javax.swing.JTextField txtNombreProducto_Productos;
    private javax.swing.JTextField txtNombreProveedor_Proveedores;
    private javax.swing.JTextField txtNombreVendedor_Vendedores;
    private javax.swing.JTextField txtNumeroDocumentoCliente_Pedido;
    private javax.swing.JTextField txtNumeroDocumentoEmpresa_Empresa;
    private javax.swing.JTextField txtNumeroDocumentoVendedor_Vendedores;
    private javax.swing.JTextField txtNumeroDocumento_Clientes;
    private javax.swing.JTextField txtNumeroDocumento_Proveedores;
    private javax.swing.JTextField txtPrecioUnitarioPaquete_Paquetes;
    private javax.swing.JTextField txtPrecioUnitario_Producto;
    private javax.swing.JTextField txtProductCode_Pedido;
    private javax.swing.JTextField txtProductUnitPrice_Pedido;
    private javax.swing.JTextField txtTelefonoCliente_Clientes;
    private javax.swing.JTextField txtTelefonoEmpresa_Empresa;
    private javax.swing.JTextField txtTelefonoProveedor_Proveedores;
    private javax.swing.JTextField txtTelefonoVendedor_Vendedores;
    private javax.swing.JTextField txtTotalVentasVendedor_vendedores;
    // End of variables declaration//GEN-END:variables

    
}
