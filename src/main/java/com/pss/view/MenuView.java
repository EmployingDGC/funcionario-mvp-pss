package com.pss.view;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MenuView extends BaseView {
    private JButton botaoCadastrar;
    private JButton botaoConsultar;

    public MenuView() {
        super(new GridBagLayout());

        this.botaoCadastrar = new JButton("Cadastrar Funcionário");
        this.botaoConsultar = new JButton("Consultar Funcionário");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        gbc.gridy = 0;
        this.add(botaoCadastrar, gbc);

        gbc.gridy += 1;
        this.add(botaoConsultar, gbc);
    }

    public JButton getBotaoCadastrar() {
        return this.botaoCadastrar;
    }

    public JButton getBotaoConsultar() {
        return this.botaoConsultar;
    }
}
