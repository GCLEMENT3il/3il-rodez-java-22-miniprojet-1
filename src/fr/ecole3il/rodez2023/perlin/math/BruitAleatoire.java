package fr.ecole3il.rodez2023.perlin.math;

import java.util.Random;

/**
 * La classe RandomNoise étend la classe Noise2D et génère du bruit aléatoire en deux dimensions.
 * Elle utilise la classe Random de Java pour générer des valeurs aléatoires.
 * @param graine Graine pour initialiser le générateur de nombres aléatoires.
 * @param resolution Résolution du bruit.
 */
public class BruitAleatoire extends Bruit2D {
    private final Random randomGenerator; // Instance de la classe Random pour générer des nombres aléatoires
    public BruitAleatoire(long graine, double resolution) {
        super(graine, resolution); // Appel du constructeur de la classe parente Bruit2D
        randomGenerator = new Random(); // Initialisation de l'instance Random
    }

    /**
     * Génère du bruit aléatoire en deux dimensions.
     * @param x Coordonnée x pour laquelle obtenir le bruit.
     * @param y Coordonnée y pour laquelle obtenir le bruit.
     * @return
     */
    @Override // Permet de prendre un classe A et créer une classe B pour prendre la structure de la classe A pour ajouter d'autre variable
    public double bruit2D(double x, double y) {
        return randomGenerator.nextDouble(); // Retourne un nombre aléatoire de type double entre 0.0 (inclus) et 1.0 (exclus)
    }
}