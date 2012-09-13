package app;

import forms.Main;

public class App {

    private final Main main;

    public App() {
        main = new Main();
        main.setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
