package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

/**
 * Classe représentant une carte
 * @param nom le nom de la carte
 * @param largeur la largeur de la carte
 * @param hauteur la hauteur de la carte
 * @param terrains les terrains de la carte
 * @param generateurAleatoire le générateur aléatoire de la carte
 * @param generateurPerlin le générateur de Perlin de la carte 
 */
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
