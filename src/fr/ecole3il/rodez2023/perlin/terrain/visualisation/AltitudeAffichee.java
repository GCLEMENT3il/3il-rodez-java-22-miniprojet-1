package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

/**
 * Enumération représentant les différentes altitudes affichées sur la carte.
 * Les altitudes sont classées en 4 catégories : basse, moyenne, élevée et fond marin.
 * La catégorie est déterminée en fonction de la valeur de l'altitude.
 */
public enum AltitudeAffichee {

    BASSE,
    MOYENNE,
    ELEVEE,
    FOND_MARIN;

    public static AltitudeAffichee determinerAltitudeAffichee(double altitude) {
        if (altitude < 0) {
            return FOND_MARIN;
        } else if (altitude < 0.33) {
            return BASSE;
        } else if (altitude < 0.66) {
            return MOYENNE;
        } else {
            return ELEVEE;
        }
    }
}
