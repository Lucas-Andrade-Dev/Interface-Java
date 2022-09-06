package ExemploProdutoInterface;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;

public class JfExemploProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JLabel lblDescricao;
	private JLabel lblQuantidade;
	private JLabel lblvalor;
	private JScrollPane jsScrollpane;
	private JTable tableProduto;
	private JTextField txtQuantidade;
	private JTextField txtValor;
	private JTextField txtDescricao;

	ProdutoTableModel tableModel = new ProdutoTableModel();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| javax.swing.UnsupportedLookAndFeelException ex) {
			// TODO: handle exception
			System.err.println(ex);

		}

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {

				try {

					JfExemploProduto frame = new JfExemploProduto();
					frame.setVisible(true);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		});

	}
	
	public JfExemploProduto() {
		initialize();
	}

	public void initialize() {
		
		setTitle("Cadastro Produto");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setName("frmProduto");
		setResizable(false);//se for false não é possivel alterar a dimensao da tela
		getContentPane().setLayout(null);
		setSize(new java.awt.Dimension(719,391));
		//setLocationRelativeTo(null);
		
		btnEditar = new JButton("Editar");
		btnExcluir = new JButton("Excluir");
		btnSalvar = new JButton("Salvar");
		lblDescricao = new JLabel();
		lblQuantidade = new JLabel();
		lblvalor = new JLabel();
		txtDescricao = new JTextField();
		txtQuantidade = new JTextField();
		txtValor = new JTextField();
		jsScrollpane = new JScrollPane();
		tableProduto = new JTable();
		
		jsScrollpane.setBounds(20, 190, 650, 150);
		txtDescricao.setBounds(30, 70, 200, 35);
		lblDescricao.setBounds(32, 40, 200, 35);
		txtQuantidade.setBounds(260,70,200,35);
		lblQuantidade.setBounds(265, 40, 200, 35);
		txtValor.setBounds(470, 70, 200, 35);
		lblvalor.setBounds(475, 40, 200, 35);
		btnEditar.setBounds(430, 150, 100, 35);
		btnExcluir.setBounds(570, 150, 100, 35);
		btnSalvar.setBounds(290, 150, 100, 35);
				
		lblDescricao.setText("Descrição");
		txtQuantidade.setName("txtQuantidade");
		lblQuantidade.setText("Quantidade");
		txtValor.setName("txtValor");
		lblvalor.setText("Valor R$");
		lblvalor.setName("");
		
		getContentPane().add(txtDescricao);
		getContentPane().add(lblDescricao);
		getContentPane().add(txtQuantidade);
		getContentPane().add(lblQuantidade);
		getContentPane().add(txtValor);
		getContentPane().add(lblvalor);
		getContentPane().add(jsScrollpane);
		getContentPane().add(tableProduto);
		getContentPane().add(btnEditar);
		getContentPane().add(btnExcluir);
		getContentPane().add(btnSalvar);
		
		tableProduto.setModel(tableModel);
		jsScrollpane.setViewportView(tableProduto);
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tableProduto.getSelectedRow() != -1) {
					tableModel.setValueat(txtDescricao.getText(), tableProduto.getSelectedRow(), 0);
					tableModel.setValueat(txtQuantidade.getText(), tableProduto.getSelectedRow(), 1);
					tableModel.setValueat(txtValor.getText(), tableProduto.getSelectedRow(), 2);
				}
				
			}
		});
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Produto p = new Produto();
				
				p.setDescricao(txtDescricao.getText());
				p.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				p.setValor(Double.parseDouble(txtValor.getText()));
				
				tableModel.addRow(p);
				
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(tableProduto.getSelectedRow() != -1) {
					tableModel.removeRow(tableProduto.getSelectedRow());
				}
				
			}
		});
		
		
	}

}
