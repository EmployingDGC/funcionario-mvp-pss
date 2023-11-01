package com.pss.presenter;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.pss.view.PrincipalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pss.model.Funcionario;
import com.pss.view.BaseView;

public class PrincipalPresenter extends BasePresenter {
    private PrincipalView janela;
    private MenuPresenter menuPresenter;
    private FuncionarioPresenter funcionarioPresenter;
    private ListarFuncionariosPresenter listarFuncionariosPresenter;

    public PrincipalPresenter() {
        super(null, null);

        this.janela = new PrincipalView(
            "Gestão de Funcionários",
            800,
            600
        );

        JMenuBar barraMenu = this.janela.getBarraMenu();
        JMenuItem itemMenuInicio = this.janela.getItemMenuInicio();

        itemMenuInicio.setIcon(new ImageIcon("./src/main/resource/icon/home_16.png"));
        itemMenuInicio.addActionListener(this.clickMenuInicio());

        barraMenu.add(itemMenuInicio);

        this.janela.setJMenuBar(barraMenu);
        this.janela.setLocationRelativeTo(null);

        this.menuPresenter = new MenuPresenter(this);
        this.funcionarioPresenter = new FuncionarioPresenter(this);
        this.listarFuncionariosPresenter = new ListarFuncionariosPresenter(this);

        this.vaParaMenu();
    }

    public PrincipalView getJanela() {
        return this.janela;
    }

    public void vaParaMenu() {
        this.vaPara(this.menuPresenter.getFilhoView());
    }

    public void vaParaEditarFuncionario(Funcionario f) {
        FuncionarioPresenter fp = this.funcionarioPresenter;
        fp.setEstadoEditavel();
        fp.setFuncionario(f);
        fp.setFuncionarioNaView(f);
        this.vaPara(fp.getFilhoView());
    }

    public void vaParaVisualizarFuncionario(Funcionario f) {
        FuncionarioPresenter fp = this.funcionarioPresenter;
        fp.setEstadoVisualizar(f);
        this.vaPara(fp.getFilhoView());
    }
    
    public void vaParaCadastrarFuncionario() {
        FuncionarioPresenter fp = this.funcionarioPresenter;
        fp.setEstadoCadastrar();
        this.vaPara(fp.getFilhoView());
    }
    
    public void vaParaConsultarFuncionarios() {
        ListarFuncionariosPresenter lfp = this.listarFuncionariosPresenter;
        lfp.atualizarTabela(null);
        this.vaPara(lfp.getFilhoView());
    }

    private ActionListener clickMenuInicio() {
        PrincipalPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.vaParaMenu();
            }
        };
    }
    
    private void vaPara(BaseView view) {
        if (view == this.getFilhoView()) {
            return;
        }

        this.janela.setContentPane(view);
        this.janela.revalidate();

        this.setFilhoView(view);
    }
}
