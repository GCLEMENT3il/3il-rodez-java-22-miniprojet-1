package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

/**
 * Cette énumération représente les différentes températures affichées sur la carte.
 * Elle permet de déterminer la température affichée en fonction de la température réelle.
 */
public enum TemperatureAffichee {

    FROID,
    TEMPERE,
    CHAUDE;

    public static TemperatureAffichee determinerTemperatureAffichee(double temperature) {
        if (temperature < 0) {
            throw new IllegalArgumentException("La temperature ne peut pas être négative");
        } else if (temperature < 0.33) {
            return FROID;
        } else if (temperature < 0.66) {
            return TEMPERE;
        } else {
            return CHAUDE;
        }
    }
}
