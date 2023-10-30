package com.pss.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalView extends JFrame {
    private PainelBaseView painelAtual;
    private MenuView painelMenu;
    private ListaFuncionariosView painelListaFuncionarios;
    private InformacoesFuncionarioView painelCadastrarFuncionario;
    private InformacoesFuncionarioView painelVerFuncionario;

    public PrincipalView() {
        this.setTitle("Gestão de Funcionários");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        JMenuBar barraMenu = new JMenuBar();
        JMenuItem itemMenuVoltar = new JMenuItem("Voltar");

        itemMenuVoltar.setIcon(new ImageIcon("./src/main/resource/icon/home_16.png"));
        itemMenuVoltar.addActionListener(this.clickMenuVoltar());

        barraMenu.add(itemMenuVoltar);

        this.setJMenuBar(barraMenu);

        this.painelMenu = new MenuView(this);
        this.painelListaFuncionarios = new ListaFuncionariosView(this);
        this.painelCadastrarFuncionario = new InformacoesFuncionarioView(this);
        this.painelVerFuncionario = new InformacoesFuncionarioView(this);

        this.vaParaPainelMenu();

        this.setLocationRelativeTo(null);
    }
    
    public void vaParaPainelMenu() {
        this.vaPara(this.painelMenu);
    }

    public void vaParaPainelCadastrarFuncionario() {
        this.vaPara(this.painelCadastrarFuncionario);
    }

    public void vaParaPainelVerFuncionario() {
        this.vaPara(this.painelVerFuncionario);
    }

    public void vaParaPainelListaFuncionarios() {
        this.painelListaFuncionarios.atualizarTabela();
        this.vaPara(this.painelListaFuncionarios);
    }

    private ActionListener clickMenuVoltar() {
        PrincipalView thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.vaParaPainelMenu();
            }
        };
    }
    
    private void vaPara(PainelBaseView painel) {
        if (painel == this.painelAtual) {
            return;
        }

        this.setContentPane(painel.getPainel());
        this.revalidate();

        this.painelAtual = painel;
    }
}
