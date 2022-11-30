package Projet_Collecte_Sang.dao_LieuCollecte.vueLieuCollecte;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Projet_Collecte_Sang.actionEvent;
import Projet_Collecte_Sang.dao_LieuCollecte.controleurLieuCollecte.ControleurLieuCollecte;
import Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte.LieuCollecte;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.*;
import java.util.ArrayList;

public class VueLieuCollecte extends JFrame implements actionEvent {
	private ControleurLieuCollecte ctrLieuCollecte = ControleurLieuCollecte.getControleurLieuCollecte();
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtAdresse;
	private JTextField txtTypelieu;
	private JTable table;

	JButton btnAjouter = new JButton();
	JButton btnModifier = new JButton();
	JButton btnSuprimer = new JButton();
	JButton btnLister = new JButton();
	JComboBox<String> cmbNom = new JComboBox<>();

	public VueLieuCollecte() {
		action();
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Mise à jour des Lieux de Collecte");
		lblTitre.setBackground(new Color(0, 128, 255));
		lblTitre.setForeground(new Color(255, 255, 0));
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblTitre.setBounds(10, 10, 350, 50);
		contentPane.add(lblTitre);

		JPanel paneChamps = new JPanel();
		paneChamps.setBackground(new Color(0, 128, 255));
		paneChamps.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneChamps.setBounds(10, 70, 350, 180);
		contentPane.add(paneChamps);
		paneChamps.setLayout(null);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 10, 117, 25);
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 12));
		paneChamps.add(lblNom);

		txtNom = new JTextField();
		txtNom.setBounds(140, 10, 198, 25);
		lblNom.setLabelFor(txtNom);
		paneChamps.add(txtNom);
		txtNom.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAdresse.setBounds(20, 70, 117, 25);
		paneChamps.add(lblAdresse);

		txtAdresse = new JTextField();
		lblAdresse.setLabelFor(txtAdresse);
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(140, 70, 198, 25);
		paneChamps.add(txtAdresse);

		JLabel lblTypelieu = new JLabel("Type du Lieu");
		lblTypelieu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTypelieu.setBounds(20, 130, 117, 25);
		paneChamps.add(lblTypelieu);

		txtTypelieu = new JTextField();
		lblTypelieu.setLabelFor(txtTypelieu);
		txtTypelieu.setColumns(10);
		txtTypelieu.setBounds(140, 130, 198, 25);
		paneChamps.add(txtTypelieu);

		JPanel paneTable = new JPanel();
		paneTable.setBackground(new Color(0, 128, 255));
		paneTable.setBounds(370, 60, 545, 234);
		contentPane.add(paneTable);
		paneTable.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 525, 220);
		paneTable.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null },
				},
				new String[] {
						"Nom", "Adresse", "Type_Lieu"
				}));
		table.getColumnModel().getColumn(2).setPreferredWidth(90);

		JPanel panelBouton = new JPanel();
		panelBouton.setBackground(new Color(0, 128, 255));
		panelBouton.setBounds(10, 250, 545, 50);
		contentPane.add(panelBouton);
		panelBouton.setLayout(null);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(255, 128, 0));
		btnAjouter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnAjouter.setBounds(132, 5, 85, 35);
		panelBouton.add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnModifier.setBackground(new Color(255, 128, 0));
		btnModifier.setBounds(238, 5, 102, 35);
		panelBouton.add(btnModifier);

		btnSuprimer = new JButton("Suprimer");
		btnSuprimer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnSuprimer.setBackground(new Color(255, 128, 0));
		btnSuprimer.setBounds(10, 5, 95, 35);
		panelBouton.add(btnSuprimer);

		btnLister = new JButton("Afficher tout");
		btnLister.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnLister.setBackground(new Color(255, 128, 64));
		btnLister.setBounds(757, 25, 158, 35);
		contentPane.add(btnLister);

		JLabel lblLieuCollecte = new JLabel("Chercher un Lieu");
		lblLieuCollecte.setBackground(new Color(0, 128, 255));
		//lblLieuCollecte.setForeground(new Color(255, 255, 0));
		lblLieuCollecte.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLieuCollecte.setBounds(470, 25, 196, 28);
		contentPane.add(lblLieuCollecte);

		cmbNom = new JComboBox<>(getListeCBox("id"));
		cmbNom.setBounds(588, 31, 159, 21);
		contentPane.add(cmbNom);
	}

	/*
	 * =============================================================================
	 * ================================
	 */
	/* Ecouetuers */
	/*
	 * =============================================================================
	 * ================================
	 */

	public void actionBtn(ActionEvent ev) {
		if (ev.getSource() == btnLister) {
			table.setModel(remplirTable("", ""));
			viderChamps();

		} else if (ev.getSource() == btnModifier) {
			modifierLieuCollecte();

		} else if (ev.getSource() == btnSuprimer) {
			Suprimer();

		} else if (ev.getSource() == btnAjouter) {
			ajouter();

		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbNom) {
			String nom = (String) cmbNom.getSelectedItem();
			nom = nom.split("_")[0];
			DefaultTableModel model = remplirTable("NOM", nom);
			table.setModel(model);
			remplirChamps(nom);

		}
	}

	/*
	 * =============================================================================
	 * ================================
	 */
	/* Fonctions */
	/*
	 * =============================================================================
	 * ================================
	 */
	public void viderChamps() {
		txtNom.setText("");
		txtAdresse.setText("");
		txtTypelieu.setText("");
	}

	public DefaultTableModel remplirTable(String champs, String valeur) {
		ArrayList<LieuCollecte> listeLieu = new ArrayList<>();

		if (champs.equals("")) {
			listeLieu = (ArrayList<LieuCollecte>) ctrLieuCollecte.CtrLieuCollecte_GetAll();

		} else {

			listeLieu = (ArrayList<LieuCollecte>) ctrLieuCollecte.CtrLieuCollecte_GetByChamps(champs, valeur);

		}
		String[] column = { "Nom", "Adresse", "Type_Lieu" };
		DefaultTableModel model = new DefaultTableModel(column, 0);

		for (LieuCollecte lieu : listeLieu) {
			model.addRow(new Object[] { lieu.getNom(), lieu.getAddresse(), lieu.getTypelieu() });
		}
		return model;

	}

	public String[] getListeCBox(String choix) {

		String[] retour = new String[1];
		ArrayList<String> listeTmp = new ArrayList<String>();
		for (LieuCollecte Lieu : ctrLieuCollecte.CtrLieuCollecte_GetAll()) {
			if (choix.equals("id")) {
				listeTmp.add(String.valueOf(Lieu.getNom()));
			}
		}
		retour = new String[listeTmp.size()];
		for (int i = 0; i < listeTmp.size(); i++) {
			retour[i] = listeTmp.get(i);
		}

		return retour;

	}

	/*
	 * =============================================================================
	 * ================================
	 */
	/* S-A-R */
	/*
	 * =============================================================================
	 * ================================
	 */
	public void Suprimer() {
		if (!txtNom.getText().equals("") & txtNom.getText() != null) {
			String strCle = txtNom.getText();
			int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous suprimer:\n" + strCle, "SUPPRESSION",
					JOptionPane.YES_NO_OPTION);
			if (rep == 0) {
				int cle = ctrLieuCollecte.CtrLieuCollecte_GetByChamps("NOM", strCle).get(0).getId();
				ctrLieuCollecte.CtrLieuCollecte_Enlever(cle);

				DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
				cmbNom.removeAll();
				cmbNom.setModel(modelNum);

				// sauvgarder();
				// JOptionPane.showMessageDialog(null,"le Donneur "+ strCle + " est suprimer
				// avec succès");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Choisissez d'abord le nom!?");
		}
		DefaultTableModel modelTable = remplirTable("", "");
		table.setModel(modelTable);
		viderChamps();
	}

	public void ajouter() {
		if (!txtNom.getText().equals("") & txtNom.getText() != null) {
			String strCle = txtNom.getText();
			if (ctrLieuCollecte.CtrLieuCollecte_GetByChamps("NOM", strCle).size() != 0) {
				int rep = JOptionPane.showConfirmDialog(null,
						"le lieu de collecte " + strCle + "  existe déjà!!\n Voulez-vous le modifier?", "AJOUT",
						JOptionPane.YES_NO_OPTION);
				if (rep == 0) {
					modifierLieuCollecte();
				}
			} else {

				LieuCollecte lieu = new LieuCollecte(txtNom.getText(), txtAdresse.getText(), txtTypelieu.getText());
				ctrLieuCollecte.CtrLieuCollecte_Enregistrer(lieu);

				DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
				cmbNom.removeAll();
				cmbNom.setModel(modelNum);

				DefaultTableModel modelTable = remplirTable("", "");
				table.setModel(modelTable);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Remplir les champs !?");
		}
		viderChamps();

	}

	public void modifierLieuCollecte() {
		if (!txtNom.getText().equals("") & txtNom.getText() != null) {
			String strCle = txtNom.getText();
			int rep = JOptionPane.showConfirmDialog(null,
					"Voulez-vous enregistrer les modifications portées sur :\n" + strCle, "MODIFICATION",
					JOptionPane.YES_NO_OPTION);
			LieuCollecte lieu = ctrLieuCollecte.CtrLieuCollecte_GetByChamps("NOM", strCle).get(0);

			if (rep == JOptionPane.YES_OPTION) {

				LieuCollecte lieuNew = new LieuCollecte(lieu.getId(), txtNom.getText(), txtAdresse.getText(),
						txtTypelieu.getText());

				ctrLieuCollecte.CtrLieuCollecte_Modifier(lieuNew);

				DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
				cmbNom.removeAll();
				cmbNom.setModel(modelNum);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Choisissez d'abord le nom!?");
		}
		DefaultTableModel modelTable = remplirTable("", "");
		table.setModel(modelTable);
		viderChamps();

	}

	public void remplirChamps(String nom) {
		LieuCollecte lieu = ctrLieuCollecte.CtrLieuCollecte_GetByChamps("NOM", nom).get(0);
		txtNom.setText(lieu.getNom());
		txtAdresse.setText(lieu.getAddresse());
		txtTypelieu.setText(lieu.getTypelieu());

	}

	@Override
	public void action() {
		cmbNom.addItemListener(this::itemStateChanged);
		btnLister.addActionListener(this::actionBtn);
		btnAjouter.addActionListener(this::actionBtn);
		btnModifier.addActionListener(this::actionBtn);
		btnSuprimer.addActionListener(this::actionBtn);

	}
}