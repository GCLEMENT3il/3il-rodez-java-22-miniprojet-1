package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public interface DetermineurTerrain {

    TypeTerrain getTypeTerrain(Terrain terrain);

    public TypeTerrain determinerTerrain(double altitude, double hydrometrie, double temperature);


}
