package com.pss.view;

import java.awt.Insets;
import java.awt.Container;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FuncionarioView extends BaseView {
    private JTextField campoNome;
    private JTextField campoLogin;
    private JTextField campoCargo;
    private JTextField campoSalario;

    private JButton botaoLimpar;
    private JButton botaoCadastrar;

    private JButton botaoSalvar;
    
    private JPasswordField campoSenha;

    public FuncionarioView() {
        super(new BorderLayout());

        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
        this.addComponent(painelFormulario, labelNome, constraints, 0, 0);

        this.campoNome = new JTextField(20);
        this.addComponent(painelFormulario, this.campoNome, constraints, 1, 0);
        
        JLabel labelLogin = new JLabel("Login:");
        labelLogin.setHorizontalAlignment(SwingConstants.RIGHT);
        this.addComponent(painelFormulario, labelLogin, constraints, 0, 1);

        this.campoLogin = new JTextField(20);
        this.addComponent(painelFormulario, this.campoLogin, constraints, 1, 1);
        
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setHorizontalAlignment(SwingConstants.RIGHT);
        this.addComponent(painelFormulario, labelSenha, constraints, 0, 2);

        this.campoSenha = new JPasswordField(20);
        this.addComponent(painelFormulario, this.campoSenha, constraints, 1, 2);
        
        JLabel labelCargo = new JLabel("Cargo:");
        labelCargo.setHorizontalAlignment(SwingConstants.RIGHT);
        this.addComponent(painelFormulario, labelCargo, constraints, 0, 3);

        this.campoCargo = new JTextField(20);
        this.addComponent(painelFormulario, this.campoCargo, constraints, 1, 3);
        
        JLabel labelSalario = new JLabel("Salário:");
        labelSalario.setHorizontalAlignment(SwingConstants.RIGHT);
        this.addComponent(painelFormulario, labelSalario, constraints, 0, 4);
        
        this.campoSalario = new JTextField(20);
        this.addComponent(painelFormulario, this.campoSalario, constraints, 1, 4);

        JPanel painelBotoes = new JPanel();

        this.botaoLimpar = new JButton("Limpar");
        this.botaoCadastrar = new JButton("Cadastrar");

        this.botaoSalvar = new JButton("Salvar");

        painelBotoes.add(this.botaoCadastrar);
        painelBotoes.add(this.botaoLimpar);

        painelBotoes.add(this.botaoSalvar);

        this.add(painelFormulario, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public JTextField getCampoNome() {
        return this.campoNome;
    }

    public JTextField getCampoLogin() {
        return this.campoLogin;
    }

    public JTextField getCampoCargo() {
        return this.campoCargo;
    }

    public JTextField getCampoSalario() {
        return this.campoSalario;
    }

    public JPasswordField getCampoSenha() {
        return this.campoSenha;
    }

    public JButton getBotaoLimpar() {
        return this.botaoLimpar;
    }

    public JButton getBotaoCadastrar() {
        return this.botaoCadastrar;
    }

    public JButton getBotaoSalvar() {
        return this.botaoSalvar;
    }
    
    private void addComponent(
        Container container,
        Component component,
        GridBagConstraints constraints,
        int gridx,
        int gridy
    ) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        container.add(component, constraints);
    }
}
