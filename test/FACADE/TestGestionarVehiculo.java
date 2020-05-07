/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import java.util.ArrayList;
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
public class TestGestionarVehiculo {
     public TestGestionarVehiculo() {
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
  
    @Test
    public void testAgregarVehiculo() {
        System.out.println("agregarVehiculo");
        String marcaVehi = "Ford";
        String modelo = "|992";
        String color = "Verde";
        String chasis = "etrr342s232";
        String seguro = "En linea";
        String tecnomecanica = "Vencido";
        String fechaRegis = "2020-04-13";
        String imagen = "foto.png";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarVehiculo(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, imagen);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        if(result == true){
            fail("The test case is a prototype.");
        }else{
            System.out.println("Datos almacenados correctamente");
        }
        
    }
    

}
