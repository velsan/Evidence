package Model;

/**
 * Instance této třídy slouží pro reprezentaci knihy
 *
 * @author Suchý Vojtěch
 */
public class Kniha {

    private String vydano;
    private String nazev;
    private String autor;

    /**
     * Returnuje datum vydání knihy.
     *
     * @return String obsahující datum vydání knihy
     */
    public String getVydano() {
        return this.vydano;
    }

    /**
     * Nataví atribut vydano
     *
     * @param vydano Obsahuje datum vydání
     */
    public void setVydano(String vydano) {
        this.vydano = vydano;
    }

    /**
     * Returnuje názve knihy
     *
     * @return String obsahující název knihy
     */
    public String getNazev() {
        return this.nazev;
    }

    /**
     * Nastaví atribut název knihy
     *
     * @param nazev Obsahuje název knihy
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Returnuje jméno autora
     *
     * @return String obsahující název autora
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * Nastaví jméno autora
     *
     * @param autor Obsahuje jméno autora
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
