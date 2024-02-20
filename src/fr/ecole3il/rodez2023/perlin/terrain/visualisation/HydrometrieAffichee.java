package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

public enum HydrometrieAffichee {

    SEC,
    MOYENNE,
    HUMIDE;

    public static HydrometrieAffichee determinerHydrometrieAffichee(double hydrometrie) {
        if (hydrometrie < 0) {
            throw new IllegalArgumentException("L'hydrométrie ne peut pas être négative");
        } else if (hydrometrie < 0.33) {
            return SEC;
        } else if (hydrometrie < 0.66) {
            return MOYENNE;
        } else {
            return HUMIDE;
        }
    }
}
