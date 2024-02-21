package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurAleatoire;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurPerlin;

public class Carte {
    private int largeur;
    private int hauteur;
    private String nom;
    private Terrain[][] terrains;
    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurAleatoire) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.nom = nom;
        terrains = generateurAleatoire.genererCarte(largeur, hauteur);
    }

    public Carte(String nom) {
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Terrain getTerrain(int x, int y){
        return terrains[x][y];
    }

    public String getNom() {
        return nom;
    }

}
