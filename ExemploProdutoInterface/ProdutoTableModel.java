package ExemploProdutoInterface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Produto> dados = new ArrayList<>();
	
	private String[]colunas = {"Descrição", "Quantidade", "Valor R$"};
	
	public String getColumnName(int column) {
		return colunas[column];
	}
			

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub
		
		switch(coluna) {
		
		case 0:
		    return dados.get(linha).getDescricao();
		case 1:
		    return dados.get(linha).getQuantidade();	    
		case 2:
		    return dados.get(linha).getValor();	    
		}
		return null;
	}
	
	public void setValueat(Object valor, int linha, int coluna) {
		
		switch(coluna) {
		
		case 0:
		    dados.get(linha).setDescricao((String) valor);
		    break;
		case 1:
		    dados.get(linha).setQuantidade(Integer.parseInt((String) valor));   
		    break;
		case 2:
		    dados.get(linha).setValor(Double.parseDouble((String) valor));	 
		    break;
		}
		
		this.fireTableRowsUpdated(linha, coluna);
		
	}
	
    public void addRow(Produto p) {
    	this.dados.add(p);
    	fireTableDataChanged();
    }
    
    public void removeRow(int Linha) {
    	this.dados.remove(Linha);
    	this.fireTableRowsDeleted(Linha, Linha);
    }
}
