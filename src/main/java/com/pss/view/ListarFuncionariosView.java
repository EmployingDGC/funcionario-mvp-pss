package com.pss.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class ListarFuncionariosView extends BaseView {
    private JTable tabela;
    private DefaultTableModel tabelaModel;
    private TableColumnModel colunasModel;

    private JButton botaoEditar;
    private JButton botaoVisualizar;
    private JButton botaoExcluir;

    public ListarFuncionariosView() {
        super(new BorderLayout());

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
        this.tabela.getTableHeader().setReorderingAllowed(false);
        
        this.colunasModel = this.tabela.getColumnModel();
        this.tabelaModel = tableModel;

        JScrollPane scrollPane = new JScrollPane(tabela);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        this.botaoEditar = new JButton("Editar");
        this.botaoVisualizar = new JButton("Ver");
        this.botaoExcluir = new JButton("Excluir");

        botoesPanel.add(botaoEditar);
        botoesPanel.add(botaoVisualizar);
        botoesPanel.add(botaoExcluir);

        this.add(botoesPanel, BorderLayout.SOUTH);
    }

    public JTable getTabela() {
        return this.tabela;
    }

    public DefaultTableModel getTabelaModel() {
        return this.tabelaModel;
    }

    public TableColumnModel getColunasModel() {
        return this.colunasModel;
    }

    public JButton getBotaoEditar() {
        return this.botaoEditar;
    }

    public JButton getBotaoExcluir() {
        return this.botaoExcluir;
    }

    public JButton getBotaoVisualizar() {
        return this.botaoVisualizar;
    }
}
