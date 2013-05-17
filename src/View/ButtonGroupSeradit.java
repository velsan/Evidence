package View;

import javax.swing.ButtonGroup;

/**
 * Tato třída reprezentuje skupinu "radio tlačítek" Pomocí instance této třídy
 * dojde k vybrání atributu, podle kterého se Seznam seřadí. Takže reakce na
 * událost této třídy je zavolání příslušné metody ze třídy SeradSeznam.
 *
 * @author Suchý Vojtěch
 */
public class ButtonGroupSeradit {

    private static ButtonGroup btGroup = null;

    private ButtonGroupSeradit() {
    }

    public static ButtonGroup getInstance() {
        if (btGroup == null) {
            btGroup = new ButtonGroup();
            btGroup.add(RadioButtonName.getInstance());
            btGroup.add(RadioButtonAutor.getInstance());
            btGroup.add(RadioButtonDate.getInstance());
            nastavGroup();
            return btGroup;
        } else {
            return btGroup;
        }
    }

    /**
     * Přidá tlačítka do skupiny
     */
    private static void nastavGroup() {
        btGroup.add(RadioButtonName.getInstance());
        btGroup.add(RadioButtonAutor.getInstance());
        btGroup.add(RadioButtonDate.getInstance());

    }
}
