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

    public AltitudeAffichee getAltitudeAffichage(double altitude) {
        return AltitudeAffichee.determinerAltitudeAffichee(altitude);
    }

    public HydrometrieAffichee getHydrometrieAffichage(double hydrometrie) {
        return HydrometrieAffichee.determinerHydrometrieAffichee(hydrometrie);
    }

    public TemperatureAffichee getTemperatureAffichage(double temperature) {
        return TemperatureAffichee.determinerTemperatureAffichee(temperature);
    }

    public TypeTerrain getTypeTerrain (int x,int y){
        Terrain terrain = carte.getTerrain(x,y);
        return terrain.getTypeTerrain(determineurTerrain);
    }
}
