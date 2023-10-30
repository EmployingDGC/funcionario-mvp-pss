package com.pss.view;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;
import java.awt.Component;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.pss.model.Funcionario;
import com.pss.presenter.InformacoesFuncionarioPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformacoesFuncionarioView extends PainelBaseView {
    private JTextField campoNome;
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JTextField campoCargo;
    private JTextField campoSalario;

    public InformacoesFuncionarioView(PrincipalView telaPrincipal) {
        super(telaPrincipal, new BorderLayout());

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

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(this.clickBotaoCadastrar());

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(this.clickBotaoLimpar());

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoLimpar);

        this.getPainel().add(painelFormulario, BorderLayout.CENTER);
        this.getPainel().add(painelBotoes, BorderLayout.SOUTH);
    }

    public Funcionario getFuncionario() {
        return new Funcionario(
            this.campoNome.getText(),
            this.campoLogin.getText(),
            this.campoSenha.getPassword().toString().trim(),
            this.campoCargo.getText(),
            Double.parseDouble(this.campoSalario.getText().replace(',', '.'))
        );
    }

    public void setFuncionario(Funcionario funcionario) {
        this.campoNome.setText(funcionario.getNome());
        this.campoLogin.setText(funcionario.getLogin());
        this.campoSenha.setText(funcionario.getSenha(false));
        this.campoCargo.setText(funcionario.getCargo());
        this.campoSalario.setText(String.format("%.2f", funcionario.getSalario()));
    }
    
    private void addComponent(Container container, Component component, GridBagConstraints constraints, int gridx, int gridy) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        container.add(component, constraints);
    }

    private void limparCampos() {
        this.campoNome.setText(null);
        this.campoLogin.setText(null);
        this.campoSenha.setText(null);
        this.campoCargo.setText(null);
        this.campoSalario.setText(null);
    }

    private final ActionListener clickBotaoCadastrar() {
        InformacoesFuncionarioView thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario funcionario = null;

                try {
                    funcionario = thisObject.getFuncionario();
                    InformacoesFuncionarioPresenter.cadastrarFuncionario(funcionario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                        thisObject.getPainel(),
                        "Dados Inválidos"
                    );

                    return;
                }

                JOptionPane.showMessageDialog(
                    thisObject.getPainel(),
                    String.format(
                        "Funcionário '%s' cadastrado com sucesso.",
                        funcionario.getNome()
                    )
                );

                thisObject.limparCampos();
            }
        };
    }

    private final ActionListener clickBotaoLimpar() {
        InformacoesFuncionarioView thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.limparCampos();
            }
        };
    }
}
