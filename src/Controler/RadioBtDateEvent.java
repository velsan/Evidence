package Controler;

import Model.Kniha;
import Model.OrderList;
import Model.OrderList.DateCompare;
import Model.SeznamKnih;
import Model.WriteList;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Třída slouží jako reakce na událost RadioButton Date Po selekci tohoto
 * radioButton dojde seřazení seznamu podle data vydání
 *
 * @see Model.OrderList
 * @author Suchý Vojtěch
 */
public class RadioBtDateEvent implements ItemListener {

    private final OrderList serad = new OrderList();
    private final ArrayList<Kniha> seznam = SeznamKnih.getInstanceCopy();
    private final DateCompare compareDate = serad.getDateCompare();
    private final WriteList vypis = new WriteList();

    @Override
    public void itemStateChanged(ItemEvent ie) {
        Collections.sort(seznam, compareDate);
        vypis.vypis();
    }
}
