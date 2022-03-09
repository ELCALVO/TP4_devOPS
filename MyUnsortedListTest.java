package datastruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnsortedListTest {

    static MyUnsortedList<Integer> liste1;
    static MyUnsortedList<Integer> liste2;
    static MyUnsortedList<Integer> liste3;

    @BeforeEach
    private void init() {
        liste1 = MyUnsortedList.of();
        liste2 = MyUnsortedList.of(4);
        liste3 = MyUnsortedList.of(4,11,7,13,7);
    }

    @Test
    void empty_init() {
        assertTrue(liste1.isEmpty(), "Liste non vide alors qu'elle a ete cree vide");
        assertFalse(liste2.isEmpty(), "Liste  vide alors qu'elle a ete cree non vide");

    }

    @Test
    void empty_list() {
        liste1.append(10);
        assertFalse(liste1.isEmpty(), "Liste vide apres l'ajout d'un element");
        liste1.pop();
        assertTrue(liste1.isEmpty(), "Liste non vide apres la suppresion de son seul element");
    }

    @Test
    void empty_pop() {
        liste3.pop();
        assertFalse(liste3.isEmpty(), "Liste vide apres le pop d'un element");
        liste3.pop();
        liste3.pop();
        liste3.pop();
        liste3.pop();
        assertTrue(liste3.isEmpty(), "Liste non vide apres la suppresion de tous les element");
    }

    @Test
    void empty_popLast() {
        liste3.popLast();
        assertFalse(liste3.isEmpty(), "Liste vide apres le poplast d'un element");
        liste3.popLast();
        liste3.popLast();
        liste3.popLast();
        liste3.popLast();
        assertTrue(liste3.isEmpty(), "Liste non vide apres la suppresion de tous les element");
    }

    @Test
    void empty_prepend() {
        liste1.prepend(1);
        if(!liste1.equals(MyUnsortedList.of(1)))
            fail("les deux listes ne sont pas égales");
    }

    @Test
    void empty_append() {
        liste1.prepend(1);
        if(!liste1.equals(MyUnsortedList.of(1)))
            fail("les deux listes ne sont pas égales");
    }

    @Test
    void equalsTest() {
        liste1.append(4);
        if(!liste1.equals(liste2))
            fail("les deux listes ne sont pas égales");
    }

    @Test
    void size_test() {
        assertEquals(liste1.size(), 0, "Liste de mauvaise taille à l'initialisation");
        assertEquals(liste2.size(), 1, "Liste de mauvaise taille à l'initialisation");
        assertEquals(liste3.size(), 5, "Liste de mauvaise taille à l'initialisation");

        liste3.append(17);
        assertEquals(liste3.size(), 6, "append");
        liste3.prepend(17);
        assertEquals(liste3.size(), 7, "prepend");
        liste3.pop();
        assertEquals(liste3.size(), 6, "pop");
        liste3.popLast();
        assertEquals(liste3.size(), 5, "popLast");
        liste3.insert(11, 3);
        assertEquals(liste3.size(), 6, "insert");
        liste3.remove(3);
        assertEquals(liste3.size(), 5, "remove");
    }

    @Test
    void removeOOB1() {
        try {
            liste1.remove(0);
            fail("Remove OOB");
        } catch(IndexOutOfBoundsException e) {
        }
    }

    @Test
    void removeOOB2() {
        try {
            liste3.remove(-1);
            fail("Remove OOB");
        } catch(IndexOutOfBoundsException e) {
        }
    }

    @Test
    void insertOOB1() {
        try {
            liste1.insert(1,1);
            fail("Insert OOB");
        } catch(IndexOutOfBoundsException e) {
        }
    }

    @Test
    void insertOOB2() {
        try {
            liste3.insert(1,-1);
            fail("Insert OOB");
        } catch(IndexOutOfBoundsException e) {
        }
    }

    @Test
    void popInEmpty() {
        try {
            liste1.pop();
            fail("pop dans liste1 vide réussi");
        } catch(EmptyListException e) {
        }
    }

    @Test
    void popLastInEmpty() {
        try {
            liste1.popLast();
            fail("popLast dans liste1 vide réussi");
        } catch(EmptyListException e) {
        }
    }

}
