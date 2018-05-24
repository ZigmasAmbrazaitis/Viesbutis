package com.company;

import java.util.ArrayList;
import java.util.List;

public class Kambarys {

    List<String> kambarioIstorija = new ArrayList<String>();
    private int kambarioID = -1;
    private boolean uzimtas = false;
    private String svecioVardas = null;
    private String svecioPavarde = null;

    Kambarys(int kambarioID) {
        this.kambarioID = kambarioID;
    }

    public boolean getUzimtas() {
        return uzimtas;
    }

    public void setUzimtas(boolean x) {
        this.uzimtas = x;
    }

    public int getKambarioID() {
        return kambarioID;
    }

    public String getSvecioVardas() {
        return svecioVardas;
    }

    public void setSvecioVardas(String vardas) {
        this.svecioVardas = vardas;
    }

    public String getSvecioPavarde() {
        return svecioPavarde;
    }

    public void setSvecioPavarde(String pavarde) {
        this.svecioPavarde = pavarde;
    }

    public void svecioRegistracija(String vardas, String pavarde) {
        this.svecioVardas = vardas;
        this.svecioPavarde = pavarde;
        this.uzimtas = true;
        kambarioIstorija.add(vardas + " " + pavarde);
    }

    public void svecioIsregistravimas() {
        this.uzimtas = false;
        this.svecioVardas = null;
        this.svecioPavarde = null;
    }

    public void rodytiIstorijaIrStatusa() {
        System.out.println("Pateikiama kambario istorija: ");
        for (String s : kambarioIstorija) {
            System.out.println(s);
        }
        if (this.uzimtas) {
            System.out.println("\nKambario statusas: užimtas.");
        } else {
            System.out.println("\nKambario statusas: laisvas.");
        }
    }
}
