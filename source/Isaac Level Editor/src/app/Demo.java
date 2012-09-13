package app;

import java.util.ArrayList;
import moduls.Soubor;

public class Demo {
    public static void main(String[] args) {
        ArrayList arra = new ArrayList();
        arra.add("aaa");
        arra.add("bbb");
        arra.add("ccc");
        System.out.println("objektu po inicializaci: " + arra.size());
        Soubor<ArrayList> data = new Soubor<ArrayList>();
        data.uloz(arra, "demo_test.dat");
        arra.clear();
        System.out.println("objektu po clear(): " + arra.size());
        arra = data.nacti(arra, "demo_test.dat");
        System.out.println("objektu po nacteni: " + arra.size());
    }
}

// záver je takovej že je špatnej save/loader, asi špatně zkopírovaný soubor

/*
 * TODO dodělat loadovani a ukladani
 */