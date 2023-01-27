package bada_bdbt_proj;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;



@JsonInclude(JsonInclude.Include.ALWAYS)
public class Student implements Serializable {

    public int ID_STUDENTA;
    public String IMIE;
    public String NAZWISKO;
    public int PESEL;
    public int TELEFON;



    @Autowired
    public Student( ) {

    }
    @Autowired
    public Student(int ID_STUDENTA, String IMIE, String NAZWISKO, int PESEL, int TELEFON) {
        this.ID_STUDENTA = ID_STUDENTA;
        this.IMIE = IMIE;
        this.NAZWISKO = NAZWISKO;
        this.PESEL = PESEL;
        this.TELEFON = TELEFON;
    }

    public void setID_STUDENTA(int ID_STUDENTA) {
        this.ID_STUDENTA = ID_STUDENTA;
    }

    public void setIMIE(String IMIE) {
        this.IMIE = IMIE;
    }

    public void setNAZWISKO(String NAZWISKO) {
        this.NAZWISKO = NAZWISKO;
    }

    public void setPESEL(int PESEL) {
        this.PESEL = PESEL;
    }

    public void setTELEFON(int TELEFON) {
        this.TELEFON = TELEFON;
    }

    public int getID_STUDENTA() {
        return ID_STUDENTA;
    }

    public String getIMIE() {
        return IMIE;
    }

    public String getNAZWISKO() {
        return NAZWISKO;
    }

    public int getPESEL() {
        return PESEL;
    }

    public int getTELEFON() {
        return TELEFON;
    }
//    public Student(int id_studenta, String stach, String pach, int i, int telefon){};



    @Override
    public String toString() {
        return "STUDENT{" +
                "ID_STUDENTA=" + ID_STUDENTA +
                ", IMIE='" + IMIE + '\'' +
                ", NAZWISKO='" + NAZWISKO + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", TELEFON='" + TELEFON + '\'' +
                '}';
    }
}
