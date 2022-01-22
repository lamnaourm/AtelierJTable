import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModelArticle extends AbstractTableModel {

	String[] cols = {"code", "Libelle", "Prix"};
	ArrayList<Article> articles;
	
	public ModelArticle() {
		articles = new ArrayList<>();
	}
	
	public void removeArticle(int i) {
		articles.remove(i);
	}
	public void addArticle(Article a) {
		articles.add(a);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.length;
	}

	@Override
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		return cols[c];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return articles.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null, String.valueOf(row));
		Article a = articles.get(row);
		
		switch (col) {
		case 0: return a.getCode();
		case 1: return a.getLib();
		case 2: return a.getPrix();
		}
		
		return null;
	}

}
