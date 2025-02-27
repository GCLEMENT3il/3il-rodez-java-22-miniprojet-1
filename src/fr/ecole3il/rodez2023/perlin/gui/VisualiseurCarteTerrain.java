package fr.ecole3il.rodez2023.perlin.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.carte.ManipulateurCarte;
import fr.ecole3il.rodez2023.perlin.terrain.concrets.VisualiseurTerrainEnonce;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurAleatoire;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurPerlin;

/**
 * 
 * @author proussille
 * La classe VisualiseurCarteTerrain représente un visualiseur de carte de terrain
 * qui permet de charger, enregistrer et générer des cartes, ainsi que d'afficher leur représentation graphique.
 */
public class VisualiseurCarteTerrain extends JFrame {

    private static final long serialVersionUID = -4664266628089280746L;
    private final JPanel cartePanel;
    private Carte carte;
    private JLabel terrainLabel;
    private VisualiseurTerrainEnonce vte;

    /**
     * Dessine la carte sur le panneau graphique.
     * @param carte La carte à dessiner.
     * @param g L'objet Graphics pour dessiner.
     * @param panelWidth La largeur du panneau.
     * @param panelHeight La hauteur du panneau.
     */
    public void drawCarte(Carte carte, Graphics g, int panelWidth, int panelHeight) {
        vte = new VisualiseurTerrainEnonce(carte);
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();
        int tuileWidth = panelWidth / largeur;
        int tuileHeight = panelHeight / hauteur;

        for (int y = 0; y < hauteur; y++) { // For eight pour y exécute le code pour le paramètre x qui a lui même un for eight
            for (int x = 0; x < largeur; x++) {
                TypeTerrain type = vte.getTypeTerrain(x, y); // Quel type de terrain nous avons par rapport au paramètre (altitude, hydrométrie, température)
                BufferedImage image = type.getImage(); // Prendre l'image par rapport au nom du type de terrain
                g.drawImage(image, x * tuileWidth, y * tuileHeight, tuileWidth, tuileHeight, null); // Afficher l'image ou il faut dans l'application
            }
        }
    }

	/**
	 * Constructeur de la classe VisualiseurCarteTerrain.
	 * Crée une fenêtre pour visualiser une carte de terrain.
	 */
	public VisualiseurCarteTerrain() {
		VisualiseurCarteTerrain monObjet = this;
		setTitle("Visualiseur de Carte");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel pour afficher la carte
		cartePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (carte != null) {
					monObjet.drawCarte(carte, g, getWidth(), getHeight());
				}
			}
		};
		cartePanel.setOpaque(true);

		cartePanel.addMouseMotionListener(new MouseAdapter() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
				if (carte==null) {
					return; // Permet de dire que quand pas de carte alors rien faire
				}
				vte = new VisualiseurTerrainEnonce(carte);
		        int tuileWidth = cartePanel.getWidth() / carte.getLargeur();
		        int tuileHeight = cartePanel.getHeight() / carte.getHauteur();

		        int x = e.getX() / tuileWidth;
		        int y = e.getY() / tuileHeight;

		        System.out.println("Coordonnées de la souris - X: " + x + ", Y: " + y);

		        if (x >= 0 && x < carte.getLargeur() && y >= 0 && y < carte.getHauteur()) {
		            TypeTerrain type = vte.getTypeTerrain(x, y);
		            terrainLabel.setText("Terrain: " + type.toString());
		        }
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        terrainLabel.setText("Terrain: "); // Efface le texte quand la souris quitte la zone de la carte
		    }
		});
		
		cartePanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int tuileWidth = cartePanel.getWidth() / carte.getLargeur();
		        int tuileHeight = cartePanel.getHeight() / carte.getHauteur();

		        int x = e.getX() / tuileWidth;
		        int y = e.getY() / tuileHeight;

		        if (x >= 0 && x < carte.getLargeur() && y >= 0 && y < carte.getHauteur()) {

		            // Crée le contenu à afficher dans la fenêtre modale
		            String contenu = "Altitude: " + vte.getAltitudeAffichage(carte.getTerrain(x,y).getAltitude()) + "\nHydrométrie: " + vte.getHydrometrieAffichage(carte.getTerrain(x,y).getHydrometrie())+ "\nTempérature: " + vte.getTemperatureAffichage(carte.getTerrain(x,y).getTemperature());

		            // Affiche une fenêtre modale avec les informations de la tuile
		            JOptionPane.showMessageDialog(cartePanel, contenu, "Informations de la tuile", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});
		add(cartePanel, BorderLayout.CENTER);

		// Barre de menu avec les options
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Carte");

		JMenuItem chargerItem = new JMenuItem("Charger une carte");
		chargerItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        int choix = fileChooser.showOpenDialog(VisualiseurCarteTerrain.this);

		        if (choix == JFileChooser.APPROVE_OPTION) {
		            File fichierSelectionne = fileChooser.getSelectedFile();
		            String cheminFichier = fichierSelectionne.getAbsolutePath();

		            // Charger la carte à partir du fichier sélectionné
		            carte = ManipulateurCarte.chargerCarte(cheminFichier);

		            // Repaint ou rafraîchir l'affichage
		            repaint();
		        }
		    }
		});

		JMenuItem enregistrerItem = new JMenuItem("Enregistrer la carte");
		enregistrerItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        int choix = fileChooser.showSaveDialog(VisualiseurCarteTerrain.this);

		        if (choix == JFileChooser.APPROVE_OPTION) {
		            File fichierSelectionne = fileChooser.getSelectedFile();
		            String cheminFichier = fichierSelectionne.getAbsolutePath();

		            // Enregistrer la carte dans le fichier sélectionné
		            ManipulateurCarte.enregistrerCarte(carte, cheminFichier);
		        }
		    }
		});


		JMenuItem genererItem = new JMenuItem("Générer une carte");
		genererItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				genererCarteDialogue();
			}
		});

		menu.add(chargerItem);
		menu.add(enregistrerItem);
		menu.add(genererItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		// Création du label pour afficher le type de terrain
        terrainLabel = new JLabel("Terrain: ");
        add(terrainLabel, BorderLayout.SOUTH); // Ajout du label en bas de la fenêtre
	}

	/**
	 * Affiche une fenêtre de dialogue pour générer une carte avec des paramètres choisis par l'utilisateur.
	 * Les paramètres sont la largeur, la hauteur, la graine aléatoire et le générateur de terrain.
	 * @param carte La carte à générer.
	 * @param g L'objet Graphics pour dessiner.
	 * @param panelWidth La largeur du panneau.
	 * @param panelHeight La hauteur du panneau.
	 * @param monObjet L'objet VisualiseurCarteTerrain.
	 */

	private void genererCarteDialogue() {
		JTextField largeurField = new JTextField(5);
		JTextField hauteurField = new JTextField(5);
		JTextField graineAlea = new JTextField(5);

		JPanel choixPanel = new JPanel();
		choixPanel.add(new JLabel("Largeur:"));
		choixPanel.add(largeurField);
		choixPanel.add(new JLabel("Hauteur:"));
		choixPanel.add(hauteurField);
		choixPanel.add(new JLabel("Graine aléatoire:"));
		choixPanel.add(graineAlea);
		graineAlea.setText(Long.toString(System.currentTimeMillis()));

		String[] generateurOptions = { "GenerateurPerlin", "GenerateurAleatoire" };
		JComboBox<String> generateurBox = new JComboBox<>(generateurOptions);

		JOptionPane.showMessageDialog(null, choixPanel, "Paramètres de génération", JOptionPane.QUESTION_MESSAGE);
		int result = JOptionPane.showConfirmDialog(null, generateurBox, "Choix du générateur",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			int largeur = Integer.parseInt(largeurField.getText());
			int hauteur = Integer.parseInt(hauteurField.getText());
			long graine = Long.parseLong(graineAlea.getText());
			String generateurSelectionne = (String) generateurBox.getSelectedItem();

			// Code pour générer la carte en fonction des paramètres choisis
			if (generateurSelectionne.equals("GenerateurPerlin")) {
				carte = new Carte("Nouvelle carte", largeur, hauteur, new GenerateurPerlin(graine));
			} else {
				carte = new Carte("Nouvelle carte", largeur, hauteur,
						new GenerateurAleatoire(graine));
			}

			repaint();
		}
	}

	/**
	 * Méthode principale pour lancer l'application.
	 * @param args Les arguments de la ligne de commande.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			VisualiseurCarteTerrain visualiseur = new VisualiseurCarteTerrain();
			visualiseur.setVisible(true);
		});
	}
}
