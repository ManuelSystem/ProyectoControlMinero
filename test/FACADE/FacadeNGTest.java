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
public class FacadeNGTest {
    
    public FacadeNGTest() {
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
     * Test of iniciarSesion method, of class Facade.
     */
    @Test
    public void testIniciarSesion() {
        System.out.println("iniciarSesion");
        String usuario = "";
        String clave = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.iniciarSesion(usuario, clave);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarPersona method, of class Facade.
     */
    @Test
    public void testAgregarPersona() {
        System.out.println("agregarPersona");
        String tipoDocumento = "";
        String numCedula = "";
        String nombres = "";
        String apellidos = "";
        String telefono = "";
        String email = "";
        String direccion = "";
        String generoSexo = "";
        String edad = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarPersona(tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosAuxiliar method, of class Facade.
     */
    @Test
    public void testObtenerDatosAuxiliar_0args() {
        System.out.println("obtenerDatosAuxiliar");
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosAuxiliar();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarIdPersona method, of class Facade.
     */
    @Test
    public void testBuscarIdPersona() {
        System.out.println("buscarIdPersona");
        String cedula = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.buscarIdPersona(cedula);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarUsuarioAuxi method, of class Facade.
     */
    @Test
    public void testAgregarUsuarioAuxi() {
        System.out.println("agregarUsuarioAuxi");
        String descripcion = "";
        String fechaRegistro = "";
        String id = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarUsuarioAuxi(descripcion, fechaRegistro, id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarPersona method, of class Facade.
     */
    @Test
    public void testActualizarPersona() {
        System.out.println("actualizarPersona");
        String tipoDocumento = "";
        String numCedula = "";
        String nombres = "";
        String apellidos = "";
        String telefono = "";
        String email = "";
        String direccion = "";
        String generoSexo = "";
        String edad = "";
        String usuario = "";
        String password = "";
        String idPersona = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarPersona(tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad, usuario, password, idPersona);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarAuxiliar method, of class Facade.
     */
    @Test
    public void testActualizarAuxiliar() {
        System.out.println("actualizarAuxiliar");
        String descripcion = "";
        String fechaRegistro = "";
        String id = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarAuxiliar(descripcion, fechaRegistro, id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosPersona method, of class Facade.
     */
    @Test
    public void testObtenerDatosPersona() {
        System.out.println("obtenerDatosPersona");
        String cedula = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosPersona(cedula);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosAuxiliar method, of class Facade.
     */
    @Test
    public void testObtenerDatosAuxiliar_String_String() {
        System.out.println("obtenerDatosAuxiliar");
        String idPersona = "";
        String idAuxiliar = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosAuxiliar(idPersona, idAuxiliar);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAuxiliar method, of class Facade.
     */
    @Test
    public void testEliminarAuxiliar() {
        System.out.println("eliminarAuxiliar");
        String idAuxiliar = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarAuxiliar(idAuxiliar);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPersona method, of class Facade.
     */
    @Test
    public void testEliminarPersona() {
        System.out.println("eliminarPersona");
        String idPersona = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarPersona(idPersona);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarAdmin method, of class Facade.
     */
    @Test
    public void testActualizarAdmin() {
        System.out.println("actualizarAdmin");
        String nombre = "";
        String apellido = "";
        String TipoDocumento = "";
        String cedula = "";
        String telefono = "";
        String email = "";
        String direccion = "";
        String sexo = "";
        String edad = "";
        String usuario = "";
        String contraseña = "";
        String idPersona = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarAdmin(nombre, apellido, TipoDocumento, cedula, telefono, email, direccion, sexo, edad, usuario, contraseña, idPersona);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarVehiculo method, of class Facade.
     */
    @Test
    public void testAgregarVehiculo() {
        System.out.println("agregarVehiculo");
        String marcaVehi = "";
        String modelo = "";
        String color = "";
        String chasis = "";
        String seguro = "";
        String tecnomecanica = "";
        String fechaRegis = "";
        String imagen = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarVehiculo(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, imagen);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarSiExisteUnVehiculo method, of class Facade.
     */
    @Test
    public void testValidarSiExisteUnVehiculo() {
        System.out.println("validarSiExisteUnVehiculo");
        String chasis = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.validarSiExisteUnVehiculo(chasis);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosVehiculo method, of class Facade.
     */
    @Test
    public void testObtenerDatosVehiculo_0args() {
        System.out.println("obtenerDatosVehiculo");
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosVehiculo();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosVehiculo method, of class Facade.
     */
    @Test
    public void testObtenerDatosVehiculo_String() {
        System.out.println("obtenerDatosVehiculo");
        String idVehiculo = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosVehiculo(idVehiculo);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarVehiculo method, of class Facade.
     */
    @Test
    public void testActualizarVehiculo() {
        System.out.println("actualizarVehiculo");
        String marcaVehi = "";
        String modelo = "";
        String color = "";
        String chasis = "";
        String seguro = "";
        String tecnomecanica = "";
        String fechaRegis = "";
        String idVehiculo = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarVehiculo(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, idVehiculo);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarVehiculo method, of class Facade.
     */
    @Test
    public void testEliminarVehiculo() {
        System.out.println("eliminarVehiculo");
        String iVehiculo = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarVehiculo(iVehiculo);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarConductor method, of class Facade.
     */
    @Test
    public void testAgregarConductor() {
        System.out.println("agregarConductor");
        String tipoDocumento = "";
        String numCedula = "";
        String telefono = "";
        String nombres = "";
        String apellidos = "";
        String email = "";
        String direccion = "";
        String generoSexo = "";
        String edad = "";
        String licencia = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarConductor(tipoDocumento, numCedula, telefono, nombres, apellidos, email, direccion, generoSexo, edad, licencia);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosConductor method, of class Facade.
     */
    @Test
    public void testObtenerDatosConductor_0args() {
        System.out.println("obtenerDatosConductor");
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosConductor();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosConductor method, of class Facade.
     */
    @Test
    public void testObtenerDatosConductor_String() {
        System.out.println("obtenerDatosConductor");
        String idConductor = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosConductor(idConductor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarSiExisteUnConductor method, of class Facade.
     */
    @Test
    public void testValidarSiExisteUnConductor() {
        System.out.println("validarSiExisteUnConductor");
        String cedula = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.validarSiExisteUnConductor(cedula);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarConductor method, of class Facade.
     */
    @Test
    public void testActualizarConductor() {
        System.out.println("actualizarConductor");
        String tipoDocumento = "";
        String numCedula = "";
        String telefono = "";
        String nombres = "";
        String apellidos = "";
        String email = "";
        String direccion = "";
        String generoSexo = "";
        String edad = "";
        String licencia = "";
        String idConductor = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarConductor(tipoDocumento, numCedula, telefono, nombres, apellidos, email, direccion, generoSexo, edad, licencia, idConductor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarConductor method, of class Facade.
     */
    @Test
    public void testEliminarConductor() {
        System.out.println("eliminarConductor");
        String idConductor = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarConductor(idConductor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarSiExisteFalla method, of class Facade.
     */
    @Test
    public void testValidarSiExisteFalla() {
        System.out.println("validarSiExisteFalla");
        String chasisVehi = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.validarSiExisteFalla(chasisVehi);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarFalla method, of class Facade.
     */
    @Test
    public void testAgregarFalla() {
        System.out.println("agregarFalla");
        String chasisVehi = "";
        String conductor = "";
        String fechaRegistro = "";
        String descriFalla = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarFalla(chasisVehi, conductor, fechaRegistro, descriFalla);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosFalla method, of class Facade.
     */
    @Test
    public void testObtenerDatosFalla_0args() {
        System.out.println("obtenerDatosFalla");
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosFalla();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosFalla method, of class Facade.
     */
    @Test
    public void testObtenerDatosFalla_String() {
        System.out.println("obtenerDatosFalla");
        String idFalla = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosFalla(idFalla);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarFalla method, of class Facade.
     */
    @Test
    public void testActualizarFalla() {
        System.out.println("actualizarFalla");
        String chasisVehi = "";
        String conductor = "";
        String fechaRegistro = "";
        String descriFalla = "";
        String idFalla = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarFalla(chasisVehi, conductor, fechaRegistro, descriFalla, idFalla);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarFalla method, of class Facade.
     */
    @Test
    public void testEliminarFalla() {
        System.out.println("eliminarFalla");
        String idFalla = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarFalla(idFalla);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarSiExisteUnAccidente method, of class Facade.
     */
    @Test
    public void testValidarSiExisteUnAccidente() {
        System.out.println("validarSiExisteUnAccidente");
        String chasisVehicu = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.validarSiExisteUnAccidente(chasisVehicu);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAccidente method, of class Facade.
     */
    @Test
    public void testAgregarAccidente() {
        System.out.println("agregarAccidente");
        String chasisVehicu = "";
        String cedulaCondu = "";
        String nombreCondu = "";
        String fechaaccidente = "";
        String descripcionAcci = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarAccidente(chasisVehicu, cedulaCondu, nombreCondu, fechaaccidente, descripcionAcci);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosAccidente method, of class Facade.
     */
    @Test
    public void testObtenerDatosAccidente_0args() {
        System.out.println("obtenerDatosAccidente");
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosAccidente();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosAccidente method, of class Facade.
     */
    @Test
    public void testObtenerDatosAccidente_String() {
        System.out.println("obtenerDatosAccidente");
        String idAccidente = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosAccidente(idAccidente);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarAccidente method, of class Facade.
     */
    @Test
    public void testAtualizarAccidente() {
        System.out.println("atualizarAccidente");
        String idAccidente = "";
        String chasisVehicu = "";
        String cedulaCondu = "";
        String nombreCondu = "";
        String fechaaccidente = "";
        String descripcionAcci = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.atualizarAccidente(idAccidente, chasisVehicu, cedulaCondu, nombreCondu, fechaaccidente, descripcionAcci);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAccidente method, of class Facade.
     */
    @Test
    public void testEliminarAccidente() {
        System.out.println("eliminarAccidente");
        String idAccidente = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarAccidente(idAccidente);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarSiExisteMaterial method, of class Facade.
     */
    @Test
    public void testValidarSiExisteMaterial() {
        System.out.println("validarSiExisteMaterial");
        String nombreMaterial = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.validarSiExisteMaterial(nombreMaterial);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarMaterial method, of class Facade.
     */
    @Test
    public void testAgregarMaterial() {
        System.out.println("agregarMaterial");
        String tipoMaterial = "";
        String nombreMaterial = "";
        String descripcion = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarMaterial(tipoMaterial, nombreMaterial, descripcion);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosMaterial method, of class Facade.
     */
    @Test
    public void testObtenerDatosMaterial_0args() {
        System.out.println("obtenerDatosMaterial");
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosMaterial();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosMaterial method, of class Facade.
     */
    @Test
    public void testObtenerDatosMaterial_String() {
        System.out.println("obtenerDatosMaterial");
        String idMaterial = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosMaterial(idMaterial);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarMaterial method, of class Facade.
     */
    @Test
    public void testActualizarMaterial() {
        System.out.println("actualizarMaterial");
        String idMaterial = "";
        String tipoMaterial = "";
        String nombreMaterial = "";
        String descripcion = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarMaterial(idMaterial, tipoMaterial, nombreMaterial, descripcion);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMaterial method, of class Facade.
     */
    @Test
    public void testEliminarMaterial() {
        System.out.println("eliminarMaterial");
        String idMaterial = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarMaterial(idMaterial);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarSiExisteUnPatio method, of class Facade.
     */
    @Test
    public void testValidarSiExisteUnPatio() {
        System.out.println("validarSiExisteUnPatio");
        String nomPatio = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.validarSiExisteUnPatio(nomPatio);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarPatioDescargue method, of class Facade.
     */
    @Test
    public void testAgregarPatioDescargue() {
        System.out.println("agregarPatioDescargue");
        String departamento = "";
        String municipio = "";
        String nomPatio = "";
        String distancia = "";
        String descripcion = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.agregarPatioDescargue(departamento, municipio, nomPatio, distancia, descripcion);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosPatio method, of class Facade.
     */
    @Test
    public void testObtenerDatosPatio_0args() {
        System.out.println("obtenerDatosPatio");
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosPatio();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosPatio method, of class Facade.
     */
    @Test
    public void testObtenerDatosPatio_String() {
        System.out.println("obtenerDatosPatio");
        String idPatio = "";
        Facade instance = new Facade();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerDatosPatio(idPatio);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarPatio method, of class Facade.
     */
    @Test
    public void testActualizarPatio() {
        System.out.println("actualizarPatio");
        String idPatio = "";
        String departamento = "";
        String municipio = "";
        String nomPatio = "";
        String distancia = "";
        String descripcion = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.actualizarPatio(idPatio, departamento, municipio, nomPatio, distancia, descripcion);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPatio method, of class Facade.
     */
    @Test
    public void testEliminarPatio() {
        System.out.println("eliminarPatio");
        String idPatio = "";
        Facade instance = new Facade();
        boolean expResult = false;
        boolean result = instance.eliminarPatio(idPatio);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
