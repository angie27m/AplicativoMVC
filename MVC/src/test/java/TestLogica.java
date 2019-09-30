
import com.ucundinamarca.modelo.Logica;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angie Manrique, Alisson Celeita
 */
public class TestLogica {
      
    public TestLogica() {
    }

    /**
     * Testeo del método llenar
     */
    @Test
    public void testRandom() {
        Logica logica = new Logica("pepita");
        String nombre = logica.llenar("prueba");
        assertNotNull(nombre);
    }
}
