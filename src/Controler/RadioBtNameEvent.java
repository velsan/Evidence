package Controler;

import Model.Kniha;
import Model.OrderList;
import Model.OrderList.NameCompare;
import Model.SeznamKnih;
import Model.WriteList;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Třída slouží jako reakce na událost RadioButton Name. Po selekci tohoto
 * radioButton dojde seřazení seznamu podle autora
 *
 * @see Model.OrderList
 * @author Suchý Vojtěch
 */
public class RadioBtNameEvent implements ItemListener {

    private final WriteList vypis = new WriteList();
    private final OrderList serad = new OrderList();
    private final NameCompare compareName = serad.getNameCompare();
    private final ArrayList<Kniha> seznam = SeznamKnih.getInstanceCopy();

    @Override
    public void itemStateChanged(ItemEvent ie) {
        Collections.sort(seznam, compareName);
        vypis.vypis();
    }
}
