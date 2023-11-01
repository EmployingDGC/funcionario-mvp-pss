package com.pss.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalView extends JFrame {
    private JMenuBar barraMenu;
    private JMenuItem itemMenuInicio;

    public PrincipalView(String titulo, int largura, int altura) {
        this.setTitle(titulo);
        this.setSize(largura, altura);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.barraMenu = new JMenuBar();
        this.itemMenuInicio = new JMenuItem("Inicio");
    }

    public JMenuBar getBarraMenu() {
        return this.barraMenu;
    }

    public JMenuItem getItemMenuInicio() {
        return this.itemMenuInicio;
    }
}
