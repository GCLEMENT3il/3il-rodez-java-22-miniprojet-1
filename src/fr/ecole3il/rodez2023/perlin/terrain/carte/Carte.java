package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurAleatoire;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurPerlin;

public class Carte {
    private int largeur;
    private int hauteur;
    public Carte(String nouvelleCarte, int largeur, int hauteur, GenerateurPerlin generateurAleatoire) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public Carte(String nouvelleCarte, int largeur, int hauteur, GenerateurAleatoire generateurAleatoire) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public Carte(String s) {
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Terrain getTerrain(int x, int y) {
        return null;
    }

    public int getNom() {
        return 0;
    }
}
