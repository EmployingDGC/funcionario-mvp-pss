package com.pss.presenter;

import com.pss.collection.FuncionarioCollection;
import com.pss.error.DuplicatedLoginException;
import com.pss.model.Funcionario;
import com.pss.view.FuncionarioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FuncionarioPresenter extends BasePresenter {
    private Funcionario funcionario;
    private Funcionario funcionarioAnterior;

    public FuncionarioPresenter(PrincipalPresenter paiPresenter) {
        super(new FuncionarioView(), paiPresenter);

        this.setEstadoPadrao();

        FuncionarioView fv = this.getFilhoView();

        fv.getBotaoSalvar().addActionListener(this.clickBotaoSalvar());
        fv.getBotaoLimpar().addActionListener(this.clickBotaoLimpar());
        fv.getBotaoCadastrar().addActionListener(this.clickBotaoCadastrar());
    }

    @Override
    public FuncionarioView getFilhoView() {
        return (FuncionarioView) super.getFilhoView();
    }

    public Funcionario getFuncionarioDaView() {
        FuncionarioView fv = this.getFilhoView();

        return new Funcionario(
            fv.getCampoNome().getText(),
            fv.getCampoLogin().getText(),
            new String(fv.getCampoSenha().getPassword()),
            fv.getCampoCargo().getText(),
            Double.parseDouble(fv.getCampoSalario().getText().replace(',', '.'))
        );
    }

    public void setFuncionarioNaView(Funcionario f) {
        FuncionarioView fv = this.getFilhoView();

        fv.getCampoNome().setText(f.getNome());
        fv.getCampoLogin().setText(f.getLogin());
        fv.getCampoSenha().setText(f.getSenha(false));
        fv.getCampoCargo().setText(f.getCargo());
        fv.getCampoSalario().setText(String.format("%.2f", f.getSalario()));
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario f) {
        this.funcionarioAnterior = this.funcionario;
        this.funcionario = f;
    }

    public Funcionario getFuncionarioAnterior() {
        return this.funcionarioAnterior;
    }

    private void limparCampos() {
        FuncionarioView fv = this.getFilhoView();

        fv.getCampoNome().setText(null);
        fv.getCampoLogin().setText(null);
        fv.getCampoSenha().setText(null);
        fv.getCampoCargo().setText(null);
        fv.getCampoSalario().setText(null);
    }

    public void setEstadoPadrao() {
        FuncionarioView fv = this.getFilhoView();
        
        fv.getBotaoSalvar().setVisible(false);
        fv.getBotaoLimpar().setVisible(false);
        fv.getBotaoCadastrar().setVisible(false);

        fv.getCampoNome().setEditable(false);
        fv.getCampoLogin().setEditable(false);
        fv.getCampoSenha().setEditable(false);
        fv.getCampoCargo().setEditable(false);
        fv.getCampoSalario().setEditable(false);
        
        this.limparCampos();

        this.funcionario = null;
        this.funcionarioAnterior = null;
    }

    public void setEstadoEditavel() {
        this.setEstadoPadrao();
        
        FuncionarioView fv = this.getFilhoView();

        fv.getBotaoSalvar().setVisible(true);

        fv.getCampoNome().setEditable(true);
        fv.getCampoCargo().setEditable(true);
        fv.getCampoSalario().setEditable(true);
    }

    public void setEstadoCadastrar() {
        this.setEstadoPadrao();
        
        FuncionarioView fv = this.getFilhoView();

        fv.getBotaoCadastrar().setVisible(true);
        fv.getBotaoLimpar().setVisible(true);

        fv.getCampoNome().setEditable(true);
        fv.getCampoLogin().setEditable(true);
        fv.getCampoSenha().setEditable(true);
        fv.getCampoCargo().setEditable(true);
        fv.getCampoSalario().setEditable(true);
    }

    public void setEstadoVisualizar(Funcionario f) {
        this.setEstadoPadrao();
        this.setFuncionario(f);
        this.setFuncionarioNaView(f);
    }

    private JFrame getJanela() {
        BasePresenter janela = this;

        while (janela.getPaiPresenter() != null) {
            janela = janela.getPaiPresenter();
        }

        return (JFrame) (((PrincipalPresenter) janela).getJanela());
    }

    private ActionListener clickBotaoSalvar() {
        FuncionarioPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario f = null;
                JFrame j = thisObject.getJanela();

                try {
                    f = thisObject.getFuncionarioDaView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(j, "Dados Inválidos");

                    return;
                }

                thisObject.funcionario.update(f);

                JOptionPane.showMessageDialog(
                    j,
                    String.format(
                        "Dados do funcionário cujo login é '%s' foram atualizados",
                        f.getLogin()
                    )
                );
            }
        };
    }

    private ActionListener clickBotaoLimpar() {
        FuncionarioPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.limparCampos();
            }
        };
    }

    private ActionListener clickBotaoCadastrar() {
        FuncionarioPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario f = null;

                try {
                    f = thisObject.getFuncionarioDaView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                        thisObject.getJanela(),
                        "Dados Inválidos"
                    );

                    return;
                }

                try {
                    FuncionarioCollection.getInstancia().add(f);
                } catch (DuplicatedLoginException ex) {
                    JOptionPane.showMessageDialog(
                        thisObject.getJanela(),
                        String.format(
                            "Funcionário com login '%s' já existe no sistema",
                            f.getLogin()
                        )
                    );

                    return;
                }

                JOptionPane.showMessageDialog(
                    thisObject.getJanela(),
                    String.format(
                        "Funcionário '%s' Cadastrado com sucesso",
                        f.getLogin()
                    )
                );

                thisObject.limparCampos();
            }
        };
    }
}
