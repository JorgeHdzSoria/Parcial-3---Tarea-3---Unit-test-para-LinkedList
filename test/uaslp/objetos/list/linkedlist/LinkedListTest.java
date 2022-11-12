package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import uaslp.objetos.list.Iterator;
//import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

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
    public void givenANewList_whenAddAtTailIfDataEqualNull_thenReturnNullNotAllowedException() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        Assertions.assertThrows(NullNotAllowedException.class, () -> lista.addAtTail (null));
        //lista.addAtTail(null);

        //Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        lista.addAtTail("Uno");

        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased() throws NullNotAllowedException, WrongIndexException {
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
    public void givenANewList_whenAddAtFrontIfDataEqualNull_thenReturnNullNotAllowedException() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        Assertions.assertThrows(NullNotAllowedException.class, () -> lista.addAtFront (null));
        //lista.addAtTail(null);

        //Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        lista.addAtFront("Uno");

        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased() throws NullNotAllowedException, WrongIndexException {
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
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When:
        Assertions.assertThrows (WrongIndexException.class, () -> lista.remove (-1));

        //Then:

    }

    @Test
    public void givenAListWithOneElement_whenRemoveHead_thenReturnTrue() throws WrongIndexException, NullNotAllowedException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When://
        lista.remove(0);

        //Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveHead_thenReturnTrue() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        //When:
        lista.remove(0);

        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    //Falta el coverage de removeTail en la funcion Remove
    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        //When:

        lista.remove(1);
        Assertions.assertThrows(WrongIndexException.class, () -> lista.getAt (1));


        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMiddle_thenReturnTrue() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        lista.remove(1);
        //2 3

        //Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertEquals(lista.getAt(1), "Tres");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero() throws NullNotAllowedException {
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
    public void givenList_whenSetAtIfDataEqualNull_thenReturnNullNotAllowedException() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");
        Assertions.assertThrows(NullNotAllowedException.class, () -> lista.setAt (1, null));
        //lista.addAtTail(null);

        //Then:
        Assertions.assertEquals(2, lista.getSize());
    }


    @Test
    public void givenAListWith3Elements_whenSetAtOne_thenSuccess() throws NullNotAllowedException, WrongIndexException {
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
    public void givenAListWith3Elements_whenSetAtLessThan0_thenReturnNull() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        //lista.setAt(-1, "Cuatro");
        Assertions.assertThrows(WrongIndexException.class, () -> lista.setAt (-1, "Cuatro"));
        // 2 1 3

        //Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_thenReturnNull() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        Assertions.assertThrows (WrongIndexException.class, () -> lista.setAt (3, "Cuatro"));
        lista.setAt(2, "Cuatro");
        // 2 1 3

        //Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Cuatro", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenGetAtLessThan0_thenReturnNull() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        Assertions.assertThrows (WrongIndexException.class, () -> lista.getAt (-1));
        //String result = lista.getAt(-1);
        // 2 1 3

        //Then:
        //Assertions.assertNull(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenGetAtGreaterThanSize_thenReturnNull() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        //String result = lista.getAt(3);
        Assertions.assertThrows(WrongIndexException.class, () -> lista.getAt (3));

        //Then:
        //Assertions.assertNull(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAnEmptyList_whenRemoveAllWithValue_thenIndexZeroMustBeNull() throws WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        //When:
        lista.removeAllWithValue("Uno");
        Assertions.assertThrows(WrongIndexException.class, () -> lista.getAt (0));

        //Then:
        Assertions.assertEquals(0, lista.getSize());
        //Assertions.assertNull(lista.getAt(0));
    }

    @Test
    public void givenAListWith5Elements_whenRemoveAllWithValue_thenDecreaseSize() throws NullNotAllowedException, WrongIndexException {
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
        Assertions.assertThrows(WrongIndexException.class, () -> lista.getAt (3));
        // 2 2 1

        //Then:
        Assertions.assertEquals(3, lista.getSize()); //Para que esto funcionara, tuve que agregar la disminucion del size en la funcion removeAllWithValue porque este no se estaba disminuyendo al borrar los valores
        Assertions.assertEquals("Uno", lista.getAt(2));
        Assertions.assertEquals("Dos", lista.getAt(0));
    }

    @Test
    public void givenAListWithNoCoincidences_whenRemoveAllWithValue_thenReturnTheSameList() throws NullNotAllowedException, WrongIndexException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 2 1 3 3

        //When:
        lista.removeAllWithValue("Cuatro");
        // 2 2 1 3 3, queda igual

        //Then:
        Assertions.assertEquals(5, lista.getSize()); //Para que esto funcionara, tuve que agregar la disminucion del size en la funcion removeAllWithValue porque este no se estaba disminuyendo al borrar los valores
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Tres", lista.getAt(4));
    }

    @Test
    public void givenAListWith5Elements_whenRemoveAllWithValueClearsTheList_thenSizeIsZero() throws NullNotAllowedException, WrongIndexException {
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
        Assertions.assertThrows(WrongIndexException.class, () -> lista.getAt (0));
        // 2 2 1

        //Then:
        Assertions.assertEquals(0, lista.getSize()); // Aqui la lista deberia quedar vacia, por tanto size es 0 directamente
        //Assertions.assertNull(lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenIterate_thenIterationIsSuccessfully() throws NullNotAllowedException {
        //Given:
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtFront("Tres");
        lista.addAtTail("Dos");
        lista.addAtTail("Uno");
        lista.addAtTail("Cuatro");
        // 3 2 1 4

        //When:
        Iterator<String> iterator = lista.getIterator();

        //Then:
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Tres", iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Dos", iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Uno", iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Cuatro", iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }

}
