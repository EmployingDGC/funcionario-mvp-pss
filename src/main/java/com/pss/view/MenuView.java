package com.pss.view;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends PainelBaseView {
    public MenuView(PrincipalView telaPrincipal) {
        super(telaPrincipal, new GridBagLayout());

        JButton botaoCadastrar = new JButton("Cadastrar Funcionário");
        botaoCadastrar.addActionListener(this.clickBotaoCadastrar());

        JButton botaoConsultar = new JButton("Consultar Funcionário");
        botaoConsultar.addActionListener(this.clickBotaoConsultar());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        gbc.gridy = 0;
        this.getPainel().add(botaoCadastrar, gbc);

        gbc.gridy += 1;
        this.getPainel().add(botaoConsultar, gbc);
    }

    private ActionListener clickBotaoCadastrar() {
        MenuView thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.getTelaPrincipal().vaParaPainelCadastrarFuncionario();
            }
        };
    }

    private ActionListener clickBotaoConsultar() {
        MenuView thisObject = this;

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.getTelaPrincipal().vaParaPainelListaFuncionarios();
            }
        };
    }
}
