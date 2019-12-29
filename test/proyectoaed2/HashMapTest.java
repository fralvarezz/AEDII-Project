package proyectoaed2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import proyectoaed2.HashMap;
import proyectoaed2.Mapa;
import static org.junit.Assert.*;


public class HashMapTest {
    
@Test(expected = IllegalArgumentException.class)
public void testIllegalCapacity() {
    HashMap hashMap = new HashMap(-5);
}
    
@Test
public void testTamañoVacio() {
    HashMap instance = new HashMap();
    int expResult = 0;
    int result = instance.getNumElem();
    assertEquals(expResult, result);
}

@Test
public void testTamaño() {
    HashMap<String,String> instance = new HashMap<>();
    instance.insertar("c1", "v1");
    instance.insertar("c2", "v2");
    int expResult = 2;
    int result = instance.getNumElem();
    assertEquals(expResult, result);
}

@Test
public void testGetAndInsertar() {
    String clave = "clave1";
    String valor = "valor1";
    HashMap<String, String> instance = new HashMap<>();
    instance.insertar(clave, valor);
    instance.insertar("c2", "v2");
    String expResult = valor;
    String result = instance.get(clave);
    assertEquals(expResult, result);
}

@Test
public void testGetNonExistent() {
    HashMap<String, String> instance = new HashMap<>();
    instance.insertar("c2", "v2");
    String expResult = null;
    String result = instance.get("clave1");
    assertEquals(expResult, result);
}

public void testEliminar() {
    String clave = "c2";
    String valor = "v2";
    HashMap<String, String> instance = new HashMap<>();
    instance.insertar(clave, valor);
    String expResult = valor;
    String result = instance.eliminar(clave);
    assertEquals(expResult, result);
}

@Test
public void testEliminarNonExistent() {
    String clave = "c2";
    HashMap<String, String> instance = new HashMap<>();
    String expResult = null;
    String result = instance.eliminar(clave);
    assertEquals(expResult, result);
}

@Test
public void testGetValores() {
    Mapa<String, String> instance = new HashMap<>();
    String v1 = "v1";
    String v2 = "v2";
    String v3 = "v3";
    instance.insertar("c1", v1);
    instance.insertar("c2", v2);
    instance.insertar("c3", v3);
    List<String> expResult = new ArrayList<>();
    expResult.add(v1);
    expResult.add(v2);
    expResult.add(v3);
    Iterator<String> it = instance.listaValores().iterator();
    List<String> result = new ArrayList<>();
    while (it.hasNext()) {
        result.add(it.next());
    }
    assertArrayEquals(expResult.toArray(new String[0]), result.toArray(new String[0]));
    }

@Test
public void testGetClaves() {
    HashMap<String, String> instance = new HashMap<>();
    String c1 = "c1";
    String c2 = "c2";
    String c3 = "c3";
    instance.insertar(c1, "v1");
    instance.insertar(c2, "v2");
    instance.insertar(c3, "v3");
    List<String> expResult = new ArrayList<>();
    expResult.add(c1);
    expResult.add(c2);
    expResult.add(c3);
    Iterator<String> it = instance.listaClaves().iterator();
    List<String> result = new ArrayList<>();
    while (it.hasNext()) {
        result.add(it.next());
    }
    assertArrayEquals(expResult.toArray(new String[0]), result.toArray(new String[0]));
}    
    
}
