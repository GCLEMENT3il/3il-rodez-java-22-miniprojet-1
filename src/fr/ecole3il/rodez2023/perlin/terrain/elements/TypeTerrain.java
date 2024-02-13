package fr.ecole3il.rodez2023.perlin.terrain.elements;

import java.awt.image.BufferedImage;

public enum TypeTerrain { // Enum car permet d'optimiser, cela permet de ne pas avoir une classe par valeur et permet de faire juste par exemple terrain.marais

    OCEAN, PLAINE, FORET_FEUILLUS, TOUNDRA, FORET_CONIFÈRES, MONTAGNE, DESERT, COLLINES, MARAIS;

    public BufferedImage getImage() {

        return null;
    }
}
