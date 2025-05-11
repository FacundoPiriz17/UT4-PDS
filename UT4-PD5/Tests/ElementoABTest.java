import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class ElementoABTest {

    private IArbolBB<Integer> arbol;

    @BeforeEach
    void init() {
        arbol = new ArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        arbol.insertar(20, 20);
        arbol.insertar(40, 40);
        arbol.insertar(60, 60);
        arbol.insertar(80, 80);
    }

    @AfterEach
    void teardown() {
        arbol = null;
    }

    @Test
    void obtenerMenorClave() {
        Assertions.assertEquals(20, arbol.obtenerMenorClave());
    }

    @Test
    void obtenerMayorClave() {
        Assertions.assertEquals(80, arbol.obtenerMayorClave());
    }

    @Test
    void cantidadNodosPorNivel() {
        Assertions.assertEquals(1, arbol.cantidadNodosPorNivel(0));
        Assertions.assertEquals(2, arbol.cantidadNodosPorNivel(1));
        Assertions.assertEquals(4, arbol.cantidadNodosPorNivel(2));
    }

    @Test
    void obtenerClaveAnterior() {
        Assertions.assertEquals(50, arbol.obtenerClaveAnterior(60));
        Assertions.assertEquals(20, arbol.obtenerClaveAnterior(30));
        Assertions.assertEquals(null, arbol.obtenerClaveAnterior(20));
    }

    @Test
    void listarHojasConNivel() {
        List<String> lista = arbol.listarHojasConNivel();
        Assertions.assertEquals("20 (nivel 2)", lista.get(0));
        Assertions.assertEquals("40 (nivel 2)", lista.get(1));
        Assertions.assertEquals("60 (nivel 2)", lista.get(2));
        Assertions.assertEquals("80 (nivel 2)", lista.get(3));
    }

    @Test
    void esDeBusqueda() {
        Assertions.assertEquals(true, arbol.esDeBusqueda());
    }
}