package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

/**
 * This interface defines a contract for determining the type of terrain based on its
 * altitude, hydrometrie, and temperature values.
 */
public interface DetermineurTerrain {

    TypeTerrain getTypeTerrain(Terrain terrain);

    /**
     * Determines the type of terrain based on the given altitude, hydrometrie, and
     * temperature values.
     *
     * @param altitude The altitude of the terrain.
     * @param hydrometrie The hydrometrie of the terrain.
     * @param temperature The temperature of the terrain.
     * @return The type of terrain.
     */
    TypeTerrain determinerTerrain(double altitude, double hydrometrie, double temperature);
}
