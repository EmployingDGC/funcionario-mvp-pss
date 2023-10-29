package com.pss.view;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class PainelBaseView {
    private PrincipalView telaPrincipal;
    private JPanel painel;
    
    public PainelBaseView(PrincipalView telaPrincipal, LayoutManager layout) {
        this.telaPrincipal = telaPrincipal;
        this.painel = new JPanel(layout);
    }

    public JPanel getPainel() {
        return this.painel;
    }

    public PrincipalView getTelaPrincipal() {
        return this.telaPrincipal;
    }
}
