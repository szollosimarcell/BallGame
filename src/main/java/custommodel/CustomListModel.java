/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractListModel;


/**
 * Saját, rendezhető listamodell. 
 *
 * @param <T>
 */
public class CustomListModel<T extends Comparable<T>> extends AbstractListModel {

    private List<T> modell = new ArrayList<>();

    private boolean sorted = false;

    @Override
    public T getElementAt(int index) {
        return modell.get(index);
    }

    @Override
    public int getSize() {
        return modell.size();
    }

    /**
     * Ha utólag akarjuk rendezni a modellt, akkor ezt a metódust kell hívni, de
     * csak akkor hajtódik végre, ha még nincs rendezve. A rendezés után jelzi, hogy megváltozott a
     * tartalma, ezt a hozzárendelt JList kezeli majd.
     */
    public void sort() {
        if (!sorted) {
            Collections.sort(modell);
            this.fireContentsChanged(this, 0, modell.size() - 1);
        }
    }

    /**
     * a modell adott indexű helyére szúr be egy elemet, és jelzi, hogy ez meg
     * is történt.
     *
     * @param item
     * @param index
     */
    public void addElement(T item, int index) {
        modell.add(index, item);
        this.fireIntervalAdded(this, index, index);
    }

    /**
     * a modell végére szúr be egy elemet, és jelzi, hogy ez meg is történt.
     *
     * @param item
     */
    public void addElement(T item) {
        this.addElement(item, modell.size());
        this.fireIntervalAdded(item, modell.size() - 1, modell.size() - 1);
    }

    /**
     * A rendezésre figyelve szúrja be az adott elemet.
     *
     * Ha a rendezve értéke false, akkor a modell végére teszi az új elemet, és
     * jelzi, hogy a modell nem rendezett.
     *
     * Ha a rendezve értéke true, akkor már eleve rendezetten rakja be az
     * elemet. Ha az eddig berakottakat elemek nem rendezetten szerepelnek a
     * modellben, akkor előbb ezeket is rendezi, és az ennek megfelelő helyre
     * rakja az újat. A hely megkereséséhez a bináris rendezést használja.
     *
     * @param element
     * @param sorted
     */
    public void addElement(T element, boolean sorted) {

        if (!sorted) {
            this.addElement(element);
            sorted = false;
        } 
        else {
            if (!sorted) {
                sort();
            }
            int index = Collections.binarySearch(modell, element);


            if (index < 0) {
                addElement(element, -index - 1);
            } else {
                addElement(element, index);
            }
            sorted = true;
        }
    }

    /**
     * Lekérdezhető, hogy rendezett-e a modell
     *
     * @return true, ha rendezett, false, ha nem
     */
    public boolean isSorted() {
        return sorted;
    }

    /**
     * Beállítható, hogy rendezettnek tekintjük-e a modellt.
     *
     * @param sorted
     */
    public void setRendezett(boolean sorted) {
        this.sorted = sorted;
    }

    public boolean contains(T element) {
        return modell.contains(element);
    }

    public void removeElement(T element) {
        int index = modell.indexOf(element);
        modell.remove(element);
        this.fireIntervalRemoved(element, index, index);
    }
}
