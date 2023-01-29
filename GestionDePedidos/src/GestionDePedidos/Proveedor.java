/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePedidos;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Proveedor extends DatosBasicos {
    private int idProveedor;
    private ConexionBD connect;

    public Proveedor(int idProveedor, String nombre, String tipoDocumento, String numeroDocumento, String direccion, String telefono, String ciudad, String departamento, String correo) {
        super(nombre, tipoDocumento, numeroDocumento, direccion, telefono, ciudad, departamento, correo);
        this.idProveedor = idProveedor;
    }

    public Proveedor() {
        this.connect = new ConexionBD();
        setTipoDocumento("NIT");
    }
    
    //CREATE
    public void crearProveedor(Proveedor proveedor){
        String nombre = "'"+proveedor.getNombre()+"',";
        String tipoDocumento ="'"+proveedor.getTipoDocumento()+"',";
        String numeroDocumento ="'"+proveedor.getNumeroDocumento()+"',";
        String direccion ="'"+proveedor.getDireccion()+"',";
        String telefono ="'"+proveedor.getTelefono()+"',";
        String ciudad ="'"+proveedor.getCiudad()+"',";
        String departamento ="'"+proveedor.getDepartamento()+"',";
        String correo ="'"+proveedor.getCorreo()+"'";
        
        String valores = " VALUES ("+nombre + tipoDocumento + numeroDocumento + direccion + telefono + ciudad + departamento + correo+")";
        String sentencia = "INSERT INTO `tb_proveedores`( `nombre`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `ciudad`, `departamento`, `correo`)"+ valores;
        System.out.println(sentencia);
        connect.registrarDato(sentencia);
    }
    
    //Rear Provider
    
    public Proveedor consultarProveedor(String documento){
        int id = consultarIdProveedor(documento);
        String valoresReq = "WHERE id ="+id;
        String sentencia = "SELECT `id`, `nombre`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `ciudad`, `departamento`, `correo` FROM `tb_proveedores`" + valoresReq;
        String[] variables = {"id", "nombre","tipo_documento","numero_documento","direccion","telefono","ciudad","departamento","correo"};
        String [] resultado = connect.consultarUser(sentencia, variables);
        Proveedor datosProveedor = new Proveedor();
        datosProveedor.setIdProveedor(Integer.parseInt(resultado[0]));
        datosProveedor.setNombre(resultado[1]);
        datosProveedor.setTipoDocumento(resultado[2]);
        datosProveedor.setNumeroDocumento(resultado[3]);
        datosProveedor.setDireccion(resultado[4]);
        datosProveedor.setTelefono(resultado[5]);
        datosProveedor.setCiudad(resultado[6]);
        datosProveedor.setDepartamento(resultado[7]);
        datosProveedor.setCorreo(resultado[8]);
        
        return datosProveedor;
        
    }
    
    public int consultarIdProveedor(String documento){
        String sentencia = "SELECT `id` FROM `tb_proveedores` WHERE `numero_documento` = " + documento;
        String solicitud = "id";
        String identificacion = connect.consultarId(solicitud, sentencia);
        int id = Integer.parseInt(identificacion);
        
        return id;
    }
    
    public int consultarIdProveedorNombre(String nombre){
        String sentencia = "SELECT `id` FROM `tb_proveedores` WHERE `nombre` = '"+ nombre+"'";
        String solicitud = "id";
        String identificacion = connect.consultarId(solicitud, sentencia);
        int id = Integer.parseInt(identificacion);
        return id;
    }
    
    //Consulta los proveedores
    public String[] listaProveedores(String solicitud){
        String sentencia = "SELECT `nombre` FROM `tb_proveedores` WHERE 1";
        ArrayList proveedores = connect.consultarComboBox(sentencia, solicitud);
        String[] listaProveedores = new String[proveedores.size()];
        
        
        for (int i = 0; i < proveedores.size(); i++) {
            String temp = ""+proveedores.get(i);
            listaProveedores[i] = temp;
        }
        
        return listaProveedores;
    }
    
    //Update Provider
    
    public void updateProvider(Proveedor proveedor){
        
        int id = proveedor.getIdProveedor();
        String nombre = "'"+proveedor.getNombre()+"'";
        String tipoDocumento ="'"+proveedor.getTipoDocumento()+"'";
        String numeroDocumento ="'"+proveedor.getNumeroDocumento()+"'";
        String direccion ="'"+proveedor.getDireccion()+"'";
        String telefono ="'"+proveedor.getTelefono()+"'";
        String ciudad ="'"+proveedor.getCiudad()+"'";
        String departamento ="'"+proveedor.getDepartamento()+"'";
        String correo ="'"+proveedor.getCorreo()+"'";
        
        String sentencia = "UPDATE `tb_proveedores` SET `nombre`="+nombre+",`tipo_documento`="+tipoDocumento+",`numero_documento`="+numeroDocumento
                            +",`direccion`="+ direccion +",`telefono`="+ telefono +",`ciudad`="+ ciudad +",`departamento`="+ departamento +",`correo`="+correo
                            +" WHERE `id` = "+id;
        connect.registrarDato(sentencia);
        }
    
    //Delete Provider
    
    public void deleteProvider(String documento) {
        
        String id = ""+consultarIdProveedor(documento);
        String sentencia = "DELETE FROM `tb_proveedores` WHERE `id`="+id;
        connect.registrarDato(sentencia);
    }
    
    
    /**
     * @return the idProveedor
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
    
    
    
}
