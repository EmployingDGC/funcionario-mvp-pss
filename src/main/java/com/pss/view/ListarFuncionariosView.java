package com.pss.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class ListarFuncionariosView extends BaseView {
    private JTable tabela;
    private DefaultTableModel tabelaModel;
    private TableColumnModel colunasModel;

    private JTextField campoPesquisa;

    private JButton botaoEditar;
    private JButton botaoVisualizar;
    private JButton botaoExcluir;
    private JButton botaoPesquisar;

    public ListarFuncionariosView() {
        super(new BorderLayout());

        JPanel painelPesquisa = new JPanel(new BorderLayout());
        this.campoPesquisa = new JTextField(20);
        this.campoPesquisa.setPreferredSize(new Dimension(300, 30));
        painelPesquisa.add(this.campoPesquisa, BorderLayout.CENTER);

        this.botaoPesquisar = new JButton("Pesquisar");
        painelPesquisa.add(this.botaoPesquisar, BorderLayout.EAST);

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
        
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        this.botaoEditar = new JButton("Editar");
        this.botaoEditar.setPreferredSize(new Dimension(100, 30));

        this.botaoVisualizar = new JButton("Ver");
        this.botaoVisualizar.setPreferredSize(new Dimension(100, 30));

        this.botaoExcluir = new JButton("Excluir");
        this.botaoExcluir.setPreferredSize(new Dimension(100, 30));
        
        botoesPanel.add(botaoEditar);
        botoesPanel.add(botaoVisualizar);
        botoesPanel.add(botaoExcluir);
        
        this.add(painelPesquisa, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
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

    public JTextField getCampoPesquisa() {
        return this.campoPesquisa;
    }

    public JButton getBotaoPesquisar() {
        return this.botaoPesquisar;
    }
}
