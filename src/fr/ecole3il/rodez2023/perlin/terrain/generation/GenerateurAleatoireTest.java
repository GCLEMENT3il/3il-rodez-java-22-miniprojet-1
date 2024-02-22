package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour le générateur aléatoire.
 */

class GenerateurAleatoireTest {

    // Création d'un objet GenerateurAleatoire avec une graine arbitraire
    GenerateurAleatoire generateur = new GenerateurAleatoire(1234L);

    @Test
    void genererTerrainTest() {
        // Génération d'un terrain aléatoire avec des paramètres arbitraires
        Terrain terrain = generateur.genererTerrain(0, 0, 10, 10);

        // Récupération de l'altitude du terrain
        double altitude = terrain.getAltitude();

        // Vérification que l'altitude est bien comprise entre -1 et 1
        assertTrue(altitude >= -1 && altitude <= 1, "L'altitude doit être entre -1 et 1");
    }
}
