package com.pss.presenter;

import com.pss.model.Funcionario;
import com.pss.view.ListarFuncionariosView;

import com.pss.collection.FuncionarioCollection;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarFuncionariosPresenter extends BasePresenter {
    public ListarFuncionariosPresenter(PrincipalPresenter paiPresenter) {
        super(new ListarFuncionariosView(), paiPresenter);

        this.getFilhoView().getBotaoEditar().addActionListener(this.clickBotaoEditar());
        this.getFilhoView().getBotaoVisualizar().addActionListener(this.clickBotaoVisualizar());
        this.getFilhoView().getBotaoExcluir().addActionListener(this.clickBotaoExcluir());
        this.getFilhoView().getBotaoPesquisar().addActionListener(this.clickBotaoPesquisar());

        this.getFilhoView().getCampoPesquisa().addKeyListener(this.pesquisarEnter());
    }

    @Override
    public ListarFuncionariosView getFilhoView() {
        return (ListarFuncionariosView) super.getFilhoView();
    }

    private Funcionario getFuncionarioSelecionado() {
        int id = this.getFilhoView().getTabela().getSelectedRow();

        if (id == -1) {
            return null;
        }

        return FuncionarioCollection.getInstancia().get(id);
    }

    private PrincipalPresenter getPrincipalPresenter() {
        BasePresenter p = this;

        while (p.getPaiPresenter() != null) {
            p = p.getPaiPresenter();
        }

        return (PrincipalPresenter) p;
    }

    private final ActionListener clickBotaoEditar() {
        ListarFuncionariosPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario f = thisObject.getFuncionarioSelecionado();

                if (f != null) {
                    thisObject.getPrincipalPresenter().vaParaEditarFuncionario(f);
                }
            }
        };
    }

    private final ActionListener clickBotaoVisualizar() {
        ListarFuncionariosPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario f = thisObject.getFuncionarioSelecionado();

                if (f != null) {
                    thisObject.getPrincipalPresenter().vaParaVisualizarFuncionario(f);
                }
            }
        };
    }

    private final ActionListener clickBotaoExcluir() {
        ListarFuncionariosPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario f = thisObject.getFuncionarioSelecionado();

                if (f == null) {
                    return;
                }

                PrincipalPresenter pv = thisObject.getPrincipalPresenter();

                int r = JOptionPane.showConfirmDialog(
                    pv.getJanela(),
                    String.format(
                        "Deseja excluir o funcionário cujo login é '%s'?",
                        f.getLogin()
                    ),
                    "Verificação",
                    JOptionPane.YES_NO_OPTION
                );

                if (r == JOptionPane.YES_OPTION) {
                    FuncionarioCollection.getInstancia().remove(f);
                    pv.vaParaConsultarFuncionarios();
                }
            }
        };
    }

    private final void filtrarFuncionarios() {
        ArrayList<Funcionario> funcionarios = FuncionarioCollection.getInstancia().getFuncionarios();
        ArrayList<Funcionario> funcionariosFiltrados = new ArrayList<>();

        String filtro = (
            String.format(
                ".*%s.*",
                this.getFilhoView().getCampoPesquisa().getText().trim().toLowerCase()
            )
        );

        for (Funcionario f : funcionarios) {
            if ((f.getNome() + f.getCargo()).matches(filtro)) {
                funcionariosFiltrados.add(f);
            }
        }

        this.atualizarTabela(funcionariosFiltrados);
    }

    private final ActionListener clickBotaoPesquisar() {
        ListarFuncionariosPresenter thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisObject.filtrarFuncionarios();
            }
        };
    }

    private final KeyListener pesquisarEnter() {
        ListarFuncionariosPresenter thisObject = this;
        
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    thisObject.filtrarFuncionarios();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        };
    }

    public void limparTabela() {
        DefaultTableModel dtm = this.getFilhoView().getTabelaModel();

        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        this.getPrincipalPresenter().getJanela().revalidate();
    }

    public void atualizarTabela(ArrayList<Funcionario> funcionarios) {
        DefaultTableModel dtm = this.getFilhoView().getTabelaModel();

        if (funcionarios == null) {
            funcionarios = FuncionarioCollection.getInstancia().getFuncionarios();
        }
        
        if (dtm.getRowCount() > 0) {
            this.limparTabela();
        }
        
        Integer i = 0;
        for (Funcionario f : funcionarios) {
            Vector<Object> rowData = new Vector<>(dtm.getColumnCount());
            
            rowData.add(i + 1);
            rowData.add(f.getNome());
            rowData.add(f.getCargo());

            dtm.addRow(rowData);

            i += 1;
        }
    }
}
