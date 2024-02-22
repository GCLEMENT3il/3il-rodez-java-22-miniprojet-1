package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;


/**
 * Enumération des types de terrain
 * @param nomImage le nom de l'image
 * @return l'image correspondante
 * @throws IOException si l'image n'est pas trouvée
 * @throws IllegalArgumentException si le nom de l'image est incorrect
 */


public enum TypeTerrain {

    OCEAN("ocean.png"),
    PLAINE("plain.png"),
    FORET_FEUILLUS("deciduous_forest.png"),
    TOUNDRA("tundra.png"),
    FORET_CONIFÈRES("coniferous_forest.png"),
    MONTAGNE("mountain.png"),
    DESERT("desert.png"),
    COLLINES("hills.png"),
    MARAIS("marsh.png");

    private String nomImage;

    TypeTerrain(String nomImage) {
        this.nomImage = nomImage;
    }

    public BufferedImage getImage() {
        return Utils.chargerTuile(nomImage);
    }
}
