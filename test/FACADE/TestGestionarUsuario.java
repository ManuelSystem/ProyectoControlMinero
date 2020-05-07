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
public class TestGestionarUsuario {
      public TestGestionarUsuario() {
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
    public void testAgregarPersona() {
        System.out.println("agregarPersona");
        String tipoDocumento = "Cedula";
        String numCedula = "10231241";
        String nombres = "Lidia";
        String apellidos = "Milagros";
        String telefono = "3125037340";
        String email = "ld@mail.com";
        String direccion = "bariio centenario";
        String generoSexo = "femenino";
        String edad = "23";
        Facade instance = new Facade();
        boolean expResult = true;
        boolean result = instance.agregarPersona(tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        if(result == true){
            System.out.println("Se a podido agregar la persona correctament");
        }else{
            fail("fallo el registro");
        }
        
    }

    /**
     * Test of buscarIdPersona method, of class Facade.
     */
    @Test
    public void testBuscarIdPersona() {
        System.out.println("buscarIdPersona");
        String cedula = "1";
        Facade instance = new Facade();
        ArrayList expResult = instance.buscarIdPersona(cedula);
        ArrayList result = instance.buscarIdPersona(cedula);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of agregarUsuarioAuxi method, of class Facade.
     */
    @Test
    public void testAgregarUsuarioAuxi() {
        System.out.println("agregarUsuarioAuxi");
        String descripcion = "Operario de maquina";
        String fechaRegistro = "2020-04-06";
        String id = "1";
        Facade instance = new Facade();
        boolean expResult = true;
        boolean result = instance.agregarUsuarioAuxi(descripcion, fechaRegistro, id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
         if(expResult == true){
            fail("Registro auxiliar exitoso");
        }else{
            System.out.println("No se pudo registrar auxiliar"+expResult);
        }
        
    }
    
     
}
