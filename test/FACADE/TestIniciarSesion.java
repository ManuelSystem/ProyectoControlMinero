/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Manuel
 */
public class TestIniciarSesion {
     public TestIniciarSesion() {
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
     * Test of iniciarSesion method sucessful, of class Facade.
     */
    
    @Test
   
      public void testIniciarSesion() {
        System.out.println("iniciarSesion");
        String usuario = "1091811138";
        String clave = "1091811138";
        Facade instance = new Facade();
        ArrayList expResult = instance.iniciarSesion(usuario, clave);
        ArrayList result = instance.iniciarSesion(usuario, clave);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
        if(result.isEmpty()){
            fail("Falló, no son los valores de entrada");
        }else{
            System.out.println("Los datos del usuario para iniciar sesión Son correctos"+expResult);
        }
    }
   /**
     * Test of iniciarSesion method failed, of class Facade.
     */
   @Test
   
      public void testIniciarSesionIncorrectamente() {
        System.out.println("iniciarSesion");
        String usuario = "1091811138";
        String clave = "00hj";
        Facade instance = new Facade();
        ArrayList expResult = instance.iniciarSesion(usuario, clave);
        ArrayList result = instance.iniciarSesion(usuario, clave);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
        if(result.isEmpty()){
            fail("Falló, no son los datos de usuario para iniciar sesión");
        }else{
            System.out.println("Los datos del usuario para iniciar sesión Son correctos"+expResult);
        }
    }
   
}
