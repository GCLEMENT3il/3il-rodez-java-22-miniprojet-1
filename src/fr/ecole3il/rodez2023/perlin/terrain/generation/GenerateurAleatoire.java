package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.math.BruitAleatoire;

import java.util.Random;

public class GenerateurAleatoire extends GenerateurCarte {

    /**
     * Constructeur du générateur de carte.
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurAleatoire(long graine) {
        super(graine);
    }

    /**
     * Méthode pour générer un terrain aléatoire pour une case spécifique.
     * @param i       La position horizontale de la case.
     * @param j       La position verticale de la case.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     * @return Le terrain généré pour la case spécifique.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
            // Initialisation d'un générateur de bruit aléatoire avec la graine du générateur
            // La résolution est fixée à 1.0
            BruitAleatoire bruitAleatoire = new BruitAleatoire(this.getGraine(), 1.0);

            // Utilisation du bruit aléatoire pour générer l'altitude, l'hydrométrie et la température
            //double altitude = Double.parseDouble("-0.5");
            double altitude = new Random().nextFloat(-1,1);

            double hydrometrie = new Random().nextFloat(0,1);
            double temperature = new Random().nextFloat(0,1);
            return new Terrain(altitude, hydrometrie, temperature);
    }

    /**
     * Méthode pour générer un terrain aléatoire.
     * Cette méthode est héritée de la classe GenerateurCarte.
     * Elle ne sera pas utilisée dans cette implémentation.
     * @return null car non utilisée dans cette implémentation.
     */
}
