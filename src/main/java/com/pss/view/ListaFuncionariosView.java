package com.pss.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pss.model.Funcionario;
import com.pss.model.FuncionarioCollection;
import com.pss.presenter.InformacoesFuncionarioPresenter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

public class ListaFuncionariosView extends PainelBaseView {
    private JTable tabela;
    private DefaultTableModel tabelaModel;

    public ListaFuncionariosView(PrincipalView telaPrincipal) {
        super(telaPrincipal, new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Cargo");

        this.tabela = new JTable(tableModel);
        this.tabelaModel = (DefaultTableModel) this.tabela.getModel();
        this.tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        this.getPainel().add(scrollPane, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(clickBotaoEditar());

        JButton botaoVisualizar = new JButton("Ver");
        botaoVisualizar.addActionListener(this.clickBotaoVisualizar());
        
        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(clickBotaoExcluir());

        botoesPanel.add(botaoEditar);
        botoesPanel.add(botaoVisualizar);
        botoesPanel.add(botaoExcluir);

        this.getPainel().add(botoesPanel, BorderLayout.SOUTH);
    }

    public JTable getTabela() {
        return this.tabela;
    }

    private Funcionario getFuncionarioSelecionado() {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            return null;
        }

        Funcionario funcionario = FuncionarioCollection.getInstance().get(linhaSelecionada);

        return funcionario;
    }

    private final ActionListener clickBotaoEditar() {
        ListaFuncionariosView thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario funcionario = thisObject.getFuncionarioSelecionado();

                if (funcionario == null) {
                    return;
                }

                System.out.println("Editou");
            }
        };
    }

    private final ActionListener clickBotaoExcluir() {
        ListaFuncionariosView thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario funcionario = thisObject.getFuncionarioSelecionado();

                if (funcionario == null) {
                    return;
                }

                InformacoesFuncionarioPresenter.excluirFuncionario(funcionario);

                thisObject.atualizarTabela();
            }
        };
    }

    private final ActionListener clickBotaoVisualizar() {
        // InformacoesFuncionarioView thisObject = this;
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("viu");
            }
        };
    }

    public void limparTabela() {
        while (this.tabelaModel.getRowCount() > 0) {
            this.tabelaModel.removeRow(0);
        }

        this.getTelaPrincipal().revalidate();
    }

    public void atualizarTabela() {
        FuncionarioCollection funcionarios = FuncionarioCollection.getInstance();
        
        if (this.tabelaModel.getRowCount() > 0) {
            this.limparTabela();
        }
        
        Integer i = 0;
        for (Funcionario f : funcionarios.getFuncionarios()) {
            Vector<Object> rowData = new Vector<>(this.tabelaModel.getColumnCount());
            
            rowData.add(i + 1);
            rowData.add(f.getNome());
            rowData.add(f.getCargo());

            this.tabelaModel.addRow(rowData);

            i += 1;
        }
    }
}
