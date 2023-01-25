package bada_bdbt_proj;
import java.util.Date;
public class Czlonek {
    public int NR_PARTNERA;
    public String NAZWA;
    public String STRONA_INTERNETOWA;
    public String SPOSOB_WSPOLPRACY;
    public int NR_KLUBU;

    public void setNR_PARTNERA(int NR_PARTNERA) {
        this.NR_PARTNERA = NR_PARTNERA;
    }

    public void setNAZWA(String NAZWA) {
        this.NAZWA = NAZWA;
    }

    public void setSTRONA_INTERNETOWA(String STRONA_INTERNETOWA) {
        this.STRONA_INTERNETOWA = STRONA_INTERNETOWA;
    }

    public void setSPOSOB_WSPOLPRACY(String SPOSOB_WSPOLPRACY) {
        this.SPOSOB_WSPOLPRACY = SPOSOB_WSPOLPRACY;
    }

    public void setNR_KLUBU(int NR_KLUBU) {
        this.NR_KLUBU = NR_KLUBU;
    }

    public int getNR_PARTNERA() {
        return NR_PARTNERA;
    }

    public String getNAZWA() {
        return NAZWA;
    }

    public String getSTRONA_INTERNETOWA() {
        return STRONA_INTERNETOWA;
    }

    public String getSPOSOB_WSPOLPRACY() {
        return SPOSOB_WSPOLPRACY;
    }

    public int getNR_KLUBU() {
        return NR_KLUBU;
    }
    public Czlonek(){};
    public Czlonek(int NR_PARTNERA, String NAZWA, String STRONA_INTERNETOWA, String SPOSOB_WSPOLPRACY, int NR_KLUBU) {
        this.NR_PARTNERA= NR_PARTNERA;
        this.NAZWA = NAZWA;
        this.STRONA_INTERNETOWA =STRONA_INTERNETOWA;
        this.SPOSOB_WSPOLPRACY = SPOSOB_WSPOLPRACY;
        this.NR_KLUBU = NR_KLUBU;

    }
    /*
    public int getNR_CZLONKA() {
        return NR_CZLONKA;
    }

    public String getIMIE() {
        return IMIE;
    }

    public String getNAZWISKO() {
        return NAZWISKO;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getNR_TELEFONU() {
        return NR_TELEFONU;
    }



    public void setNR_CZLONKA(int NR_CZLONKA) {
        this.NR_CZLONKA = NR_CZLONKA;
    }

    public void setIMIE(String IMIE) {
        this.IMIE = IMIE;
    }

    public void setNAZWISKO(String NAZWISKO) {
        this.NAZWISKO = NAZWISKO;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setNR_TELEFONU(String NR_TELEFONU) {
        this.NR_TELEFONU = NR_TELEFONU;
    }

    */
    @Override
    public String toString() {
        return "Czlonek{" +
                "NR_CZLONKA=" + NR_PARTNERA +
                ", IMIE='" + NAZWA + '\'' +
                ", NAZWISKO='" + STRONA_INTERNETOWA + '\'' +
                ", PESEL='" + SPOSOB_WSPOLPRACY + '\'' +
                ", NR_TELEFONU='" + NR_KLUBU + '\'' +
                '}';
    }
}
