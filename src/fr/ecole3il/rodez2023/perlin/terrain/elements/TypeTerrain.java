package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

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

    private final String nomImage;

    private BufferedImage image;

    TypeTerrain(String nomImage) {
        this.nomImage = nomImage;
    }

    public BufferedImage getImage() {
        if (image == null) {
            image = Utils.chargerTuile(nomImage);
        }
        return image;
    }

    @Override
    public String toString() {
        return switch (this) {
            case OCEAN -> "Océan";
            case PLAINE -> "Plaine";
            case FORET_FEUILLUS -> "Forêt de feuillus";
            case TOUNDRA -> "Toundra";
            case FORET_CONIFÈRES -> "Forêt de conifères";
            case MONTAGNE -> "Montagne";
            case DESERT -> "Désert";
            case COLLINES -> "Collines";
            case MARAIS -> "Marais";
        };
    }
}
