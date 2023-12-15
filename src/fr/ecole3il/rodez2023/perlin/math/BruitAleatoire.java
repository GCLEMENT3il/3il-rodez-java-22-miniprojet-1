package fr.ecole3il.rodez2023.perlin.math;

import java.util.Random;

/**
 * La classe RandomNoise étend la classe Noise2D et génère du bruit aléatoire en deux dimensions.
 * Elle utilise la classe Random de Java pour générer des valeurs aléatoires.
 */
public class BruitAleatoire extends Bruit2D {
    protected Random randomGenerator; // Instance de la classe Random pour générer des nombres aléatoires
    public BruitAleatoire(long graine, double resolution) {
        super(graine, resolution); // Appel du constructeur de la classe parente Bruit2D
        randomGenerator = new Random(graine); // Initialisation de l'instance Random avec la graine
    }

    @Override
    public double bruit2D(double x, double y) {
        return randomGenerator.nextDouble(); // Retourne un nombre aléatoire de type double entre 0.0 (inclus) et 1.0 (exclus)
    }
}
