package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

public class VisualiseurTerrainEnonce extends VisualiseurTerrain {
	public VisualiseurTerrainEnonce(Carte c) {
		super(c, new DetermineurTerrainEnonce());
	}

    public TypeTerrain getTypeTerrain(int x, int y) {
		return null;
    }

	public String getAltitudeAffichee(int x, int y) {
		return null;
	}

	public String getHydrometrieAffichee(int x, int y) {
		return null;
	}

	public String getTemperatureAffichee(int x, int y) {
		return null;
	}
}
