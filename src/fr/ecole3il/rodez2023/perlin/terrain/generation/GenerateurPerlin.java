package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

/**
 * Classe représentant le GenerateurPerlin.
 * @param graine la graine pour la génération aléatoire
 * @param largeur la largeur de la carte
 * @param hauteur la hauteur de la carte
 */
public class GenerateurPerlin extends GenerateurCarte{
    public GenerateurPerlin(long graine) {
        super(graine);
    }

    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        return null;
    }
}
