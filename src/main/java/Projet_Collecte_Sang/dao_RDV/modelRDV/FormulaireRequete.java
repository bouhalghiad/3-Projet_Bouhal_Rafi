package Projet_Collecte_Sang.dao_RDV.modelRDV;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class FormulaireRequete extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitre;
	private JPanel panel;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblAnnee;
	private JTextField txtAnnee;
	private JLabel lblPages;
	private JTextField txtPages;
	private JLabel lblAuteur;
	private JComboBox comboBox;
	//private final Action action = new SwingAction();


	/**
	 * Create the frame.
	 */
	public FormulaireRequete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(31, 5, 454, 126);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNumero = new JLabel("Numero Livre");
		lblNumero.setForeground(new Color(0, 0, 255));
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		panel.add(txtNumero);
		lblNumero.setLabelFor(txtTitre);
		
		JLabel lblTitre = new JLabel("Titre Livre");
		lblTitre.setForeground(new Color(0, 0, 255));
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblTitre);
		
		txtTitre = new JTextField();
		panel.add(txtTitre);
		txtTitre.setColumns(10);
		
		lblAuteur = new JLabel("Numero Auteur");
		lblAuteur.setForeground(Color.BLUE);
		lblAuteur.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblAuteur);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		panel.add(comboBox);
		
		lblAnnee = new JLabel("Annee");
		lblAnnee.setForeground(Color.BLUE);
		lblAnnee.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblAnnee);
		
		txtAnnee = new JTextField();
		txtAnnee.setColumns(10);
		panel.add(txtAnnee);
		
		lblPages = new JLabel("Nombre des pages");
		lblPages.setForeground(Color.BLUE);
		lblPages.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblPages);
		
		txtPages = new JTextField();
		txtPages.setColumns(10);
		panel.add(txtPages);
		
		JLabel lblCathegorie = new JLabel("Cathegorie Livre");
		lblCathegorie.setForeground(Color.BLUE);
		lblCathegorie.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblCathegorie);
		
		JPanel paneCathegorie = new JPanel();
		paneCathegorie.setBackground(new Color(0, 128, 255));
		paneCathegorie.setBounds(31, 141, 454, 70);
		contentPane.add(paneCathegorie);
		paneCathegorie.setLayout(new GridLayout(0, 3, 0, 0));
		
		JRadioButton rdbtnVide = new JRadioButton("Vide");
		rdbtnVide.setForeground(new Color(255, 255, 255));
		rdbtnVide.setBackground(new Color(0, 128, 255));
		rdbtnVide.setSelected(true);
		paneCathegorie.add(rdbtnVide);
		
		JRadioButton rdbtnRoman = new JRadioButton("Roman");
		rdbtnRoman.setForeground(new Color(255, 255, 255));
		rdbtnRoman.setBackground(new Color(0, 128, 255));
		paneCathegorie.add(rdbtnRoman);
		
		JRadioButton rdbtnSuspense = new JRadioButton("Suspense");
		rdbtnSuspense.setForeground(new Color(255, 255, 255));
		rdbtnSuspense.setBackground(new Color(0, 128, 255));
		paneCathegorie.add(rdbtnSuspense);
		
		JRadioButton rdbtnDessin = new JRadioButton("Dessins animés");
		rdbtnDessin.setForeground(new Color(255, 255, 255));
		rdbtnDessin.setBackground(new Color(0, 128, 255));
		paneCathegorie.add(rdbtnDessin);
		
		JRadioButton rdbtnNuouvelle = new JRadioButton("Nuouvelle");
		rdbtnNuouvelle.setForeground(new Color(255, 255, 255));
		rdbtnNuouvelle.setBackground(new Color(0, 128, 255));
		paneCathegorie.add(rdbtnNuouvelle);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(31, 221, 85, 21);
		contentPane.add(btnOk);
	}
}
