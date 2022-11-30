package Projet_Collecte_Sang.dao_Utilisateur.vueUtilisateur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Projet_Collecte_Sang.dao_Utilisateur.controleurUtilisateur.ControleurUtilisateur;
import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.Utilisateur;

import java.util.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class FormulaireUser extends JFrame implements actionEvent {

	private JPanel contentPane;
	static JScrollPane scroll = new JScrollPane();

	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	private JTable table = new JTable();
	private JButton btnAjouter = new JButton();
	private JButton btnModifier = new JButton();
	private JButton btnLister = new JButton();
	private JButton btnSuprimer = new JButton();
	private JComboBox<String> cmbNom = new JComboBox<>();
	private ControleurUtilisateur ctrUtilisateur = ControleurUtilisateur.getControleurUtilisateur();

	public FormulaireUser() {
		action();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Mise à jour des utilisateurs");
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblTitre.setBounds(10, 10, 440, 50);
		contentPane.add(lblTitre);

		JPanel paneChamps = new JPanel();
		paneChamps.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneChamps.setBounds(10, 70, 350, 207);
		contentPane.add(paneChamps);
		paneChamps.setLayout(null);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 7, 117, 19);
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 12));
		paneChamps.add(lblNom);

		txtNom = new JTextField();
		txtNom.setBounds(142, 5, 198, 19);
		lblNom.setLabelFor(txtNom);
		paneChamps.add(txtNom);
		txtNom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPrenom.setBounds(20, 35, 117, 19);
		paneChamps.add(lblPrenom);

		txtPrenom = new JTextField();
		lblPrenom.setLabelFor(txtPrenom);
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(142, 33, 198, 19);
		paneChamps.add(txtPrenom);

		JLabel lblTel = new JLabel("Telephone");
		lblTel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTel.setBounds(20, 66, 117, 19);
		paneChamps.add(lblTel);

		txtTel = new JTextField();
		lblTel.setLabelFor(txtTel);
		txtTel.setColumns(10);
		txtTel.setBounds(142, 64, 198, 19);
		paneChamps.add(txtTel);

		JLabel lblEmail = new JLabel("Courriel");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(20, 99, 117, 19);
		paneChamps.add(lblEmail);

		txtEmail = new JTextField();
		lblEmail.setLabelFor(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setBounds(142, 97, 198, 19);
		paneChamps.add(txtEmail);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUserName.setBounds(20, 130, 117, 19);
		paneChamps.add(lblUserName);

		txtUserName = new JTextField();
		lblUserName.setLabelFor(txtUserName);
		txtUserName.setColumns(10);
		txtUserName.setBounds(142, 128, 198, 19);
		paneChamps.add(txtUserName);

		JLabel lblMotPasse = new JLabel("Mot de Passe");
		lblMotPasse.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMotPasse.setBounds(20, 161, 117, 19);
		paneChamps.add(lblMotPasse);

		passwordField = new JPasswordField();
		lblMotPasse.setLabelFor(passwordField);
		passwordField.setBounds(142, 157, 198, 19);
		paneChamps.add(passwordField);

		JPanel paneTable = new JPanel();
		paneTable.setBounds(370, 70, 545, 207);
		contentPane.add(paneTable);
		paneTable.setLayout(null);

		scroll = new JScrollPane(table);
		table.setBounds(10, 10, 525, 187);
		table.setModel(remplirTable("", ""));
		/*
		 * table.setModel(new DefaultTableModel(
		 * new Object[][] {
		 * {null, null},
		 * },
		 * new String[] {
		 * "User", "Mot de passe"
		 * }
		 * ));
		 */
		paneTable.add(table);

		JPanel panelBouton = new JPanel();
		panelBouton.setBounds(10, 287, 350, 50);
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
		btnLister.setBackground(new Color(0, 128, 255));
		btnLister.setBounds(757, 25, 158, 35);
		contentPane.add(btnLister);

		JLabel lblUtilisateur = new JLabel("Chercher un utilisateur");
		lblUtilisateur.setForeground(new Color(0, 0, 255));
		lblUtilisateur.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUtilisateur.setBounds(475, 29, 196, 28);
		contentPane.add(lblUtilisateur);

		cmbNom = new JComboBox<String>(getListeCBox("id"));
		cmbNom.setBounds(681, 25, 66, 35);
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
			modifierUtilisateur();

		} else if (ev.getSource() == btnSuprimer) {
			Suprimer();

		} else if (ev.getSource() == btnAjouter) {
			// String strCle = JOptionPane.showInputDialog(null, "Entrez le nom du
			// Utilisateur a ajouter");
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

	@Override
	public void action() {
		cmbNom.addItemListener(this::itemStateChanged);
		btnLister.addActionListener(this::actionBtn);
		btnAjouter.addActionListener(this::actionBtn);
		btnModifier.addActionListener(this::actionBtn);
		btnSuprimer.addActionListener(this::actionBtn);

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
		txtPrenom.setText("");
		txtTel.setText("");
		txtEmail.setText("");
		txtUserName.setText("");
		passwordField.setText("");

	}

	public DefaultTableModel remplirTable(String champs, String valeur) {
		ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();
		if (champs.equals("")) {
			listeUtilisateurs = (ArrayList<Utilisateur>) ctrUtilisateur.CtrUtilisateur_GetAll();

		} else {

			listeUtilisateurs = (ArrayList<Utilisateur>) ctrUtilisateur.CtrUtilisateur_GetByChamps(champs, valeur);

		}
		String[] column = { "Nom", "Prenom", "Telephone", "Courreil", "User Name", "Mot de passe" };
		DefaultTableModel model = new DefaultTableModel(column, 0);

		for (Utilisateur Utilisateur : listeUtilisateurs) {
			model.addRow(new Object[] { Utilisateur.getNom(), Utilisateur.getPrenom(), Utilisateur.getTelphone(),
					Utilisateur.getEmail(), Utilisateur.getUserName(), Utilisateur.getMotPasse() });
		}
		return model;

	}

	public String[] getListeCBox(String choix) {

		String[] retour = new String[1];
		ArrayList<String> listeTmp = new ArrayList<String>();
		for (Utilisateur Utilisateur : ctrUtilisateur.CtrUtilisateur_GetAll()) {
			if (choix.equals("id")) {
				listeTmp.add(String.valueOf(Utilisateur.getNom() + "_" + Utilisateur.getPrenom()));
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
			int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous suprimer:\n" + strCle, "SOUPRESSION",
					JOptionPane.YES_NO_OPTION);
			if (rep == 0) {
				int cle = ctrUtilisateur.CtrUtilisateur_GetByChamps("NOM", strCle).get(0).getId();
				ctrUtilisateur.CtrUtilisateur_Enlever(cle);

				DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
				cmbNom.removeAll();
				cmbNom.setModel(modelNum);

				// sauvgarder();
				// JOptionPane.showMessageDialog(null,"le Utilisateur "+ strCle + " est suprimer
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
			if (ctrUtilisateur.CtrUtilisateur_GetByChamps("NOM", strCle).size() != 0) {
				int rep = JOptionPane.showConfirmDialog(null,
						"le livre du numéro " + strCle + "  existe déjà!!\n Voulez-vous le modifier?", "AJOUT",
						JOptionPane.YES_NO_OPTION);
				if (rep == 0) {
					modifierUtilisateur();
				}
			} else {
				int cle = ctrUtilisateur.CtrUtilisateur_EnregistrerParRequete(
						"INSERT INTO Utilisateur(ID_Utilisateur,NOM) VALUES(0,?)", strCle);
				Utilisateur Utilisateur = new Utilisateur(cle, txtNom.getText(), txtPrenom.getText(), txtTel.getText(),
						txtEmail.getText(), txtUserName.getText(), passwordField.getText());

				ctrUtilisateur.CtrUtilisateur_Modifier(Utilisateur);

				DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
				cmbNom.removeAll();
				cmbNom.setModel(modelNum);

				// DefaultTableModel modelTable =
				// remplirTable("ID_Utilisateur",String.valueOf(cle));
				DefaultTableModel modelTable = remplirTable("", "");
				table.setModel(modelTable);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Remplir les champs !?");
		}
		viderChamps();

	}

	public void modifierUtilisateur() {
		if (!txtNom.getText().equals("") & txtNom.getText() != null) {
			String strCle = txtNom.getText();
			int rep = JOptionPane.showConfirmDialog(null,
					"Voulez-vous enregistrer les modifications portées sur :\n" + strCle, "MODIFICATION",
					JOptionPane.YES_NO_OPTION);
			Utilisateur utilisateur = ctrUtilisateur.CtrUtilisateur_GetByChamps("NOM", strCle).get(0);

			if (rep == JOptionPane.YES_OPTION) {

				Utilisateur utilisateurNew = new Utilisateur(utilisateur.getId(), txtNom.getText(), txtPrenom.getText(),
						txtTel.getText(), txtEmail.getText(), txtUserName.getText(), passwordField.getText());

				ctrUtilisateur.CtrUtilisateur_Modifier(utilisateurNew);

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

		/*
		 * String strCle = JOptionPane.showInputDialog(null,
		 * "Entrez le nom du Utilisateur a ajouter");
		 * if(ctrUtilisateur.CtrUtilisateur_GetByChamps("NOM", strCle).size() == 0){
		 * int rep = JOptionPane.showConfirmDialog(null, "le Utilisateur "+ strCle
		 * +" n' existe pas!!\n Voulez-vous l'ajouter ?","MODIFIER",
		 * JOptionPane.YES_NO_OPTION);
		 * if(rep==0){
		 * ajouter();
		 * }
		 * 
		 * }else{
		 * Utilisateur utilisateur = ctrUtilisateur.CtrUtilisateur_GetByChamps("NOM",
		 * strCle).get(0);
		 * txtNom.setText(utilisateur.getNom());
		 * txtPrenom.setText(utilisateur.getPrenom());
		 * txtTel.setText(utilisateur.getTelphone());
		 * txtEmail.setText(utilisateur.getEmail());
		 * txtUserName.setText(utilisateur.getUserName());
		 * passwordField.setText(utilisateur.getMotPasse());
		 * 
		 * Utilisateur utilisateurNew = new
		 * Utilisateur(utilisateur.getId(),txtNom.getText(),txtPrenom.getText(),txtTel.
		 * getText(),txtEmail.getText(),txtUserName.getText(),passwordField.getText());
		 * 
		 * ctrUtilisateur.CtrUtilisateur_Modifier(utilisateurNew);
		 * 
		 * DefaultComboBoxModel<String> modelNum = new
		 * DefaultComboBoxModel<>(getListeCBox("id"));
		 * cmbNom.removeAll();
		 * cmbNom.setModel(modelNum);
		 * 
		 * // DefaultTableModel modelTable =
		 * remplirTable("ID_Utilisateur",String.valueOf(cle));
		 * DefaultTableModel modelTable = remplirTable("","");
		 * table.setModel(modelTable);
		 * }
		 * 
		 * viderChamps();
		 */

	}

	public void remplirChamps(String nom) {
		Utilisateur utilisateur = ctrUtilisateur.CtrUtilisateur_GetByChamps("NOM", nom).get(0);
		txtNom.setText(utilisateur.getNom());
		txtPrenom.setText(utilisateur.getPrenom());
		txtTel.setText(utilisateur.getTelphone());
		txtEmail.setText(utilisateur.getEmail());
		txtUserName.setText(utilisateur.getUserName());
		passwordField.setText(utilisateur.getMotPasse());

	}
}