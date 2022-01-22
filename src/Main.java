import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtLib;
	private JTextField txtPrix;
	private JTable table;
	private JTextField txtaCode;
	private JTextField txtaLib;
	private JTextField txtaPrix;
	ModelArticle model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ajouter Article", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 460, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCode = new JLabel("Code : ");
		lblCode.setBounds(10, 25, 98, 14);
		panel.add(lblCode);
		
		txtCode = new JTextField();
		txtCode.setBounds(10, 50, 98, 20);
		panel.add(txtCode);
		txtCode.setColumns(10);
		
		txtLib = new JTextField();
		txtLib.setColumns(10);
		txtLib.setBounds(125, 50, 185, 20);
		panel.add(txtLib);
		
		JLabel lblLibelle = new JLabel("Libelle :");
		lblLibelle.setBounds(125, 25, 98, 14);
		panel.add(lblLibelle);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setBounds(342, 25, 98, 14);
		panel.add(lblPrix);
		
		txtPrix = new JTextField();
		txtPrix.setColumns(10);
		txtPrix.setBounds(342, 50, 98, 20);
		panel.add(txtPrix);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Article a = new Article();
				
				
				a.setCode(Integer.valueOf(txtCode.getText()));
				a.setLib(txtLib.getText());
				a.setPrix(Double.valueOf(txtPrix.getText()));
				
				model.addArticle(a);
				model.fireTableRowsInserted(model.articles.size()-1, model.articles.size()-1);
				
			}
		});
		btnAjouter.setBounds(351, 89, 89, 23);
		panel.add(btnAjouter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 460, 148);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 304, 460, 123);
		contentPane.add(panel_1);
		
		JLabel lblCode_1 = new JLabel("Code : ");
		lblCode_1.setBounds(10, 25, 98, 14);
		panel_1.add(lblCode_1);
		
		txtaCode = new JTextField();
		txtaCode.setEnabled(false);
		txtaCode.setColumns(10);
		txtaCode.setBounds(10, 50, 98, 20);
		panel_1.add(txtaCode);
		
		txtaLib = new JTextField();
		txtaLib.setEnabled(false);
		txtaLib.setColumns(10);
		txtaLib.setBounds(125, 50, 185, 20);
		panel_1.add(txtaLib);
		
		JLabel lblLibelle_1 = new JLabel("Libelle :");
		lblLibelle_1.setBounds(125, 25, 98, 14);
		panel_1.add(lblLibelle_1);
		
		JLabel lblPrix_1 = new JLabel("Prix :");
		lblPrix_1.setBounds(342, 25, 98, 14);
		panel_1.add(lblPrix_1);
		
		txtaPrix = new JTextField();
		txtaPrix.setEnabled(false);
		txtaPrix.setColumns(10);
		txtaPrix.setBounds(342, 50, 98, 20);
		panel_1.add(txtaPrix);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				
				model.removeArticle(row);
				
				model.fireTableRowsDeleted(row, row);
			}
		});
		btnSupprimer.setBounds(351, 89, 89, 23);
		panel_1.add(btnSupprimer);
		
		model = new ModelArticle();
		table.setModel(model);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				
				if(row >=0) {
				txtaCode.setText(String.valueOf(model.getValueAt(row, 0)));
				txtaLib.setText(String.valueOf(model.getValueAt(row, 1)));
				txtaPrix.setText(String.valueOf(model.getValueAt(row, 2).toString()));
				}
				
			}
		});
	}
}
