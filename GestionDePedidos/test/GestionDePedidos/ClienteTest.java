/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePedidos;

import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pablo
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createClient method, of class Cliente.
     */
    

    /**
     * Test of consultarDocumentoCliente method, of class Cliente.
     */
    @Test
    public void testConsultarDocumentoCliente() {
        System.out.println("consultarDocumentoCliente");
        String id = "1";
        Cliente instance = new Cliente();
        String expResult = "132";
        String result = instance.consultarDocumentoCliente(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of aplicarFidelizacion method, of class Cliente.
     */
    @Test
    public void testAplicarFidelizacion() {
        System.out.println("aplicarFidelizacion");
        Cliente cliente = null;
        String fechaPedido = "11/08/2021";
        Cliente instance = new Cliente();
        instance.setCantidadCompras(100);
        instance.setFechaNacimiento("05/08/1990");
        boolean expResult = true;
        boolean result = instance.aplicarFidelizacion(instance, fechaPedido);
        assertEquals(expResult, result);
    }

   
}
