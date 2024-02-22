package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

/**
 * Cette classe représente le visualiseur de terrain.
 * Elle permet de visualiser les différents éléments de la carte.
 * @param carte la carte à visualiser
 * @param determineurTerrain le détermineur de terrain
 * @param getAltitudeAffichage la méthode pour obtenir l'altitude affichée
 * @param getHydrometrieAffichage la méthode pour obtenir l'hydrométrie affichée
 * @param getTemperatureAffichage la méthode pour obtenir la température affichée
 * @param getTypeTerrain la méthode pour obtenir le type de terrain
 * @return le visualiseur de terrain
 */
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
