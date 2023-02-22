package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import control.Controller;
import control.Format;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTable;

public class ViewDados extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDados frame = new ViewDados();
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
	public ViewDados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agenda", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 11, 388, 467);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setDocument(new Format(100, Format.TipoEntrada.NOME));
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNome.setBounds(20, 56, 344, 27);
		panel_1.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(20, 31, 46, 20);
		panel_1.add(lblNome);
		
		//asds
		try {
			textFieldTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		//textFieldTelefone.setDocument(new Format(20, Format.TipoEntrada.TELEFONE));
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(22, 132, 344, 27);
		panel_1.add(textFieldTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(22, 107, 60, 20);
		panel_1.add(lblTelefone);
		
		JLabel lblExcecao = new JLabel("  ");
		lblExcecao.setForeground(Color.RED);
		lblExcecao.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcecao.setBounds(20, 170, 344, 20);
		lblExcecao.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblExcecao);
		
		JButton btnAdc = new JButton("Adicionar");
		btnAdc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String telefone = textFieldTelefone.getText();
				try {
					Controller.entrarValores(nome, telefone);
					lblExcecao.setText("");
					JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
				}catch (RuntimeException e1){
					lblExcecao.setText(e1.getMessage());
				} catch (ClassNotFoundException e1) {
					lblExcecao.setText("Erro!");
				} catch (SQLException e1) {
					lblExcecao.setText("Contato já adicionado!");
				}
			} 
		});
		btnAdc.setBounds(22, 197, 342, 23);
		panel_1.add(btnAdc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(404, 11, 336, 467);
		contentPane.add(panel_2);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contatos", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 21, 316, 435);
		panel_2.add(table);
		
		
	}
}
