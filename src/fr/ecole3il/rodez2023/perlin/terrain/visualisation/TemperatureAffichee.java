package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

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
