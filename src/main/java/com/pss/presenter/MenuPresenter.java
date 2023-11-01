package com.pss.presenter;

import com.pss.view.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPresenter extends BasePresenter {
    public MenuPresenter(PrincipalPresenter paiPresenter) {
        super(new MenuView(), paiPresenter);

        MenuView menuView = (MenuView) this.getFilhoView();

        menuView.getBotaoCadastrar().addActionListener(this.clickBotaoCadastrar());
        menuView.getBotaoConsultar().addActionListener(this.clickBotaoConsultar());
    }

    private ActionListener clickBotaoCadastrar() {
        MenuPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrincipalPresenter p = (PrincipalPresenter) thisObject.getPaiPresenter();
                
                p.vaParaCadastrarFuncionario();
            }
        };
    }

    private ActionListener clickBotaoConsultar() {
        MenuPresenter thisObject = this;

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrincipalPresenter p = (PrincipalPresenter) thisObject.getPaiPresenter();

                p.vaParaConsultarFuncionarios();
            }
        };
    }
}
