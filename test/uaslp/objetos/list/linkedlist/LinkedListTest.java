package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LinkedListTest {
    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        int size = lista.getSize();

        //Then:
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        lista.addAtTail("Uno");

        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");

        //When:
        lista.addAtTail("Dos");

        //Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        lista.addAtFront("Uno");

        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When:
        lista.addAtFront("Dos");

        //Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When:
        boolean result = lista.remove(-1);

        //Then:
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWithOneElement_whenRemoveHead_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When:
        boolean result = lista.remove(0);

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveHead_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        //When:
        boolean result = lista.remove(0);

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    //Falta el coverage de removeTail en la funcion Remove
    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        //When:
        boolean result = lista.remove(1);

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertNull(lista.getAt(1));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMiddle_thenReturnTrue(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        boolean result = lista.remove(1);
        //2 3

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertEquals(lista.getAt(1), "Tres");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        lista.removeAll();

        //Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenSetAtOne_thenSuccess(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        lista.setAt(1, "Cuatro");
        // 2 4 3

        //Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Cuatro", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtLessThan0_thenReturnNull(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        boolean result = lista.setAt(-1, "Cuatro");
        // 2 1 3

        //Then:
        Assertions.assertFalse(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_thenReturnNull(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        boolean result = lista.setAt(3, "Cuatro");
        // 2 1 3

        //Then:
        Assertions.assertFalse(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenGetAtLessThan0_thenReturnNull(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        String result = lista.getAt(-1);
        // 2 1 3

        //Then:
        Assertions.assertNull(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenGetAtGreaterThanSize_thenReturnNull(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        String result = lista.getAt(3);

        //Then:
        Assertions.assertNull(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAnEmptyList_whenRemoveAllWithValue_thenIndexZeroMustBeNull(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        lista.removeAllWithValue("Uno");

        //Then:
        Assertions.assertEquals(0, lista.getSize());
        Assertions.assertNull(lista.getAt(0));
    }

    @Test
    public void givenAListWith5Elements_whenRemoveAllWithValue_thenDecreaseSize(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 2 1 3 3

        //When:
        lista.removeAllWithValue("Tres");
        // 2 2 1

        //Then:
        Assertions.assertEquals(3, lista.getSize()); //Para que esto funcionara, tuve que agregar la disminucion del size en la funcion removeAllWithValue porque este no se estaba disminuyendo al borrar los valores
        Assertions.assertEquals("Uno", lista.getAt(2));
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertNull(lista.getAt(3));
    }

    @Test
    public void givenAListWith5Elements_whenRemoveAllWithValueClearsTheList_thenSizeIsZero(){
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Tres");
        lista.addAtFront("Tres");
        lista.addAtTail("Tres");
        lista.addAtFront("Tres");
        lista.addAtTail("Tres");
        // 2 2 1 3 3

        //When:
        lista.removeAllWithValue("Tres");
        // 2 2 1

        //Then:
        Assertions.assertEquals(0, lista.getSize()); // Aqui la lista deberia quedar vacia, por tanto size es 0 directamente
        Assertions.assertNull(lista.getAt(0));
    }

    //Faltan los casos del Iterador

}
