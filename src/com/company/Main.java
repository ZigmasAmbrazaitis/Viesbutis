package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int ACTION_0 = 0;
    private static final int ACTION_1 = 1;
    private static final int ACTION_2 = 2;
    private static final int ACTION_3 = 3;
    private static final int ACTION_4 = 4;
    private static final int ACTION_5 = 5;
    private List<Kambarys> Kambariai = new ArrayList<Kambarys>();

    public static void main(String[] args) {
        Main programa = new Main();
        programa.sukurkKambarius();
        programa.run();
    }

    public void rodykMeniu() {
        System.out.println("\n############################");
        System.out.println("1. Svečio registracija.");
        System.out.println("2. Svečio išregistravimas.");
        System.out.println("3. Kambarių užimtumo peržiūra.");
        System.out.println("4. Kambario istorija ir statusas.");
        System.out.println("0. Baigti darbą.");
        System.out.println("############################");
        System.out.println("Pasirinkite norimą veiksmą: ");
    }

    public void sukurkKambarius() {
        for (int i = 1; i <= 5; i++) {
            Kambarys kambarys = new Kambarys(i);
            Kambariai.add(kambarys);
        }
    }

    public void run() {

        // Pagrindinio meniu loop'as
        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        while (arTesti) {
            rodykMeniu();
            int pasirinkimas = sc.nextInt();
            switch (pasirinkimas) {
                case ACTION_0:
                    arTesti = false;
                    break;
                case ACTION_1:
                    registracija();
                    break;
                case ACTION_2:
                    isregistravimas();
                    break;
                case ACTION_3:
                    uzimtumoPerziura();
                    break;
                case ACTION_4:
                    istorijosPerziura();
                    break;
            }
        }
    }

    public void registracija() {
        boolean arYraLaisvuKambariu = false;
        int laisvoKambarioID = 0;
        Outerloop:
        for (int i = 0; i < 5; i++) {
            if (!Kambariai.get(i).getUzimtas()) {
                arYraLaisvuKambariu = true;
                laisvoKambarioID = Kambariai.get(i).getKambarioID();
                break Outerloop;
            }
        }
        if (arYraLaisvuKambariu) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Įveskite svečio vardą: ");
            String vardas = sc.nextLine();
            System.out.println("Įveskite svečio pavardę: ");
            String pavarde = sc.nextLine();
            Kambariai.get(laisvoKambarioID - 1).svecioRegistracija(vardas, pavarde);
            System.out.println("Svečias sėkmingai priregistruotas.");
        } else {
            System.out.println("Laisvų kambarių nėra.");
        }
    }

    public void isregistravimas() {
        Scanner sc = new Scanner(System.in);
        boolean arVisiLaisvi = true;
        System.out.println("Kurį svečią norite išregistruoti?");
        for (int i = 0; i < 5; i++) {
            if (Kambariai.get(i).getUzimtas()) {
                System.out.println((i + 1) + "-asis kambarys. Svečias- " + Kambariai.get(i).getSvecioVardas() + " " + Kambariai.get(i).getSvecioPavarde() + ".");
                arVisiLaisvi = false;
            }
        }
        if (arVisiLaisvi) {
            System.out.println("Išregistravimas negalimas- visi kambariai laisvi.");
        }
        int kurisKambarys = sc.nextInt();
        switch (kurisKambarys) {
            case ACTION_1:
                if (Kambariai.get(0).getUzimtas()) {
                    System.out.println("Svečias " + Kambariai.get(0).getSvecioVardas() + " " + Kambariai.get(0).getSvecioPavarde() + " iš 1-ojo kambario išregistruotas.");
                    Kambariai.get(0).svecioIsregistravimas();
                } else {
                    System.out.println("Išregistravimas negalimas, kambarys tuščias.");
                }
                break;
            case ACTION_2:
                if (Kambariai.get(1).getUzimtas()) {
                    System.out.println("Svečias " + Kambariai.get(1).getSvecioVardas() + " " + Kambariai.get(1).getSvecioPavarde() + " iš 2-ojo kambario išregistruotas.");
                    Kambariai.get(1).svecioIsregistravimas();
                } else {
                    System.out.println("Išregistravimas negalimas, kambarys tuščias.");
                }
                break;
            case ACTION_3:
                if (Kambariai.get(2).getUzimtas()) {
                    System.out.println("Svečias " + Kambariai.get(2).getSvecioVardas() + " " + Kambariai.get(2).getSvecioPavarde() + " iš 3-ojo kambario išregistruotas.");
                    Kambariai.get(2).svecioIsregistravimas();
                } else {
                    System.out.println("Išregistravimas negalimas, kambarys tuščias.");
                }
                break;
            case ACTION_4:
                if (Kambariai.get(3).getUzimtas()) {
                    System.out.println("Svečias " + Kambariai.get(3).getSvecioVardas() + " " + Kambariai.get(3).getSvecioPavarde() + " iš 4-ojo kambario išregistruotas.");
                    Kambariai.get(3).svecioIsregistravimas();
                } else {
                    System.out.println("Išregistravimas negalimas, kambarys tuščias.");
                }
                break;
            case ACTION_5:
                if (Kambariai.get(4).getUzimtas()) {
                    System.out.println("Svečias " + Kambariai.get(4).getSvecioVardas() + " " + Kambariai.get(4).getSvecioPavarde() + " iš 5-ojo kambario išregistruotas.");
                    Kambariai.get(4).svecioIsregistravimas();
                } else {
                    System.out.println("Išregistravimas negalimas, kambarys tuščias.");
                }
                break;
            default:
                System.out.println("Tokio kambario nėra.");
        }
    }

    public void uzimtumoPerziura() {
        boolean arYraLaisvu = true;
        System.out.println("Užimti kambariai:");
        for (int i = 0; i < 5; i++) {
            if (Kambariai.get(i).getUzimtas()) {
                System.out.println((i + 1) + "-asis kambarys užimtas. Svečias- " + Kambariai.get(i).getSvecioVardas() + " " + Kambariai.get(i).getSvecioPavarde() + ".");
                arYraLaisvu = false;
            }
        }
        if (arYraLaisvu) {
            System.out.println("Visi kambariai laisvi.");
        }
    }

    public void istorijosPerziura() {
        Scanner sc = new Scanner(System.in);
        int kambarioID = 0;
        System.out.println("Kurio kambario istoriją ir statusą norite matyti?");
        kambarioID = sc.nextInt();
        Outerloop:
        if (kambarioID < 1 || kambarioID > 5) {
            System.out.println("Tokio kambario nėra.");
            break Outerloop;
        } else {
            Kambariai.get(kambarioID - 1).rodytiIstorijaIrStatusa();
        }
    }
}
