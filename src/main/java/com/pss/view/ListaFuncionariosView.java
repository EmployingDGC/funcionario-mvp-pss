package com.pss.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pss.model.Funcionario;
import com.pss.model.FuncionarioCollection;

import java.awt.BorderLayout;

import java.util.Vector;

public class ListaFuncionariosView extends PainelBaseView {
    private JTable tabela;
    private DefaultTableModel tabelaModel;

    public ListaFuncionariosView(PrincipalView telaPrincipal) {
        super(telaPrincipal, new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Salário");

        this.tabela = new JTable(tableModel);
        this.tabelaModel = (DefaultTableModel) this.tabela.getModel();

        JScrollPane scrollPane = new JScrollPane(tabela);
        this.getPainel().add(scrollPane, BorderLayout.CENTER);
    }

    public JTable getTabela() {
        return this.tabela;
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
            rowData.add(f.getSalario());

            this.tabelaModel.addRow(rowData);

            i += 1;
        }
    }
}
