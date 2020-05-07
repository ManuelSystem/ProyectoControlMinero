/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Manuel
 */
public class TestGestionarConductor {
     public TestGestionarConductor() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    /**
     * Test of agregarVehiculo method, of class Facade.
     */
     /**
     * Test of agregarConductor method, of class Facade.
     */
    @Test
    public void testAgregarConductor() {
        System.out.println("agregarConductor");
        String tipoDocumento = "c";
        String numCedula = "sc";
        String telefono = "545";
        String nombres = "";
        String apellidos = "manuel";
        String email = "";
        String direccion = "av 10";
        String generoSexo = "f";
        String edad = "34";
        String licencia = "en linea";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarConductor(tipoDocumento, numCedula, telefono, nombres, apellidos, email, direccion, generoSexo, edad, licencia);
        assertEquals(result, expResult);
       
         if(result == false){
            fail("Falla al registrar el conductor.");
        }else{
            System.out.println("Datos almacenados correctamente");
        }
    }
}
