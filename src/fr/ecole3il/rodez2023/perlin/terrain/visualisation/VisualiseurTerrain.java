package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public class VisualiseurTerrain {

    private final Carte carte;
    private final DetermineurTerrain determineurTerrain;

    public VisualiseurTerrain(Carte carte, DetermineurTerrain determineurTerrain) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    public String getAffichage(int x, int y) {
        Terrain terrain = carte.getTerrain(x, y);
        TypeTerrain typeTerrain = determineurTerrain.determinerTerrain(terrain.getAltitude(), terrain.getHydrometrie(), terrain.getTemperature());
        return "[" + typeTerrain.getSymbole() + " " + getAltitudeAffichage(terrain.getAltitude()) + " " + getHydrometrieAffichage(terrain.getHydrometrie()) + " " + getTemperatureAffichage(terrain.getTemperature()) + "]";
    }

    private String getAltitudeAffichage(double altitude) {
        return AltitudeAffichee.determinerAltitudeAffichee(altitude).name();
    }

    private String getHydrometrieAffichage(double hydrometrie) {
        return HydrometrieAffichee.determinerHydrometrieAffichee(hydrometrie).name();
    }

    private String getTemperatureAffichage(double temperature) {
        return TemperatureAffichee.determinerTemperatureAffichee(temperature).name();
    }
}
