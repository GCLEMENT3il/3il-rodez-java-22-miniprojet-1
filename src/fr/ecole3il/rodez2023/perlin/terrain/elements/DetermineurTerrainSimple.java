package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class DetermineurTerrainSimple implements DetermineurTerrain { // Permet de dire en focntion des paramètre (Hydrometrie, Température et Altitude) de choisir le biome

    @Override
    public TypeTerrain getTypeTerrain(Terrain terrain) {
        double altitude = terrain.getAltitude();
        double hydrometrie = terrain.getHydrometrie();
        double temperature = terrain.getTemperature();

        if (altitude > 0.5) {
            return TypeTerrain.MONTAGNE;
        } else if (altitude > 0) {
            if (hydrometrie > 0.5) {
                return TypeTerrain.FORET_FEUILLUS;
            } else {
                return TypeTerrain.PLAINE;
            }
        } else if (altitude > -0.5) {
            if (hydrometrie > 0.5) {
                return TypeTerrain.MARAIS;
            } else if (temperature > 0.5) {
                return TypeTerrain.DESERT;
            } else {
                return TypeTerrain.COLLINES;
            }
        } else {
            return TypeTerrain.OCEAN;
        }
    }

    @Override
    public TypeTerrain determinerTerrain(double altitude, double hydrometrie, double temperature) {
        return null;
    }
}
