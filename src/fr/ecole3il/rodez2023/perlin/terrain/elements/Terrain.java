package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

/**
 * Classe représentant les valeurs acceptables pour les variables température, hydrométrie et altitude
 * @param temperature la température
 * @param hydrometrie l'hydrométrie
 * @param altitude l'altitude
 */

public class Terrain {

    private final double temperature;
    private final double hydrometrie;
    private final double altitude;


    public Terrain( double altitude, double hydrometrie, double temperature) throws MauvaiseValeurException {
        if (hydrometrie < 0 || hydrometrie > 1) {
            throw new MauvaiseValeurException("Hydrométrie invalide : " + hydrometrie);
        }
        if (temperature < 0 || temperature > 1) {
            throw new MauvaiseValeurException("Température invalide : " + temperature);
        }
        if (altitude < -1 || altitude > 1) {
            throw new MauvaiseValeurException("Altitude invalide : " + altitude);
        }
        this.hydrometrie = hydrometrie;
        this.temperature = temperature;
        this.altitude = altitude;
    }

    public double getHydrometrie() {
        return hydrometrie;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getAltitude() {
        return altitude;
    }
    public TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(altitude,hydrometrie,temperature);
    }
}
