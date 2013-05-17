package Controler;

import Model.Kniha;
import Model.OrderList;
import Model.OrderList.AutorCompare;
import Model.SeznamKnih;
import Model.WriteList;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Třída slouží jako reakce na událost Radio Button Autor Po selekce tohoto
 * radioButton dojde seřazení seznamu podle autora
 *
 * @see Model.OrderList
 * @author Suchý Vojtěch
 */
public class RadioBtAutorEvent implements ItemListener {

    private final OrderList serad = new OrderList();
    private final AutorCompare compareAutor = serad.getAutorCompare();
    private final ArrayList<Kniha> seznam = SeznamKnih.getInstanceCopy();
    private final WriteList vypis = new WriteList();

    @Override
    public void itemStateChanged(ItemEvent ie) {
        Collections.sort(seznam, compareAutor);
        vypis.vypis();
    }
}
