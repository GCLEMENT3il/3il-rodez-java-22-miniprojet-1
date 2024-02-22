package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

/**
* Classe représentant un visualiseur de terrain en utilisant la classe DetermineurTerrainEnonce.
* @param c la carte à visualiser
*/

public class VisualiseurTerrainEnonce extends VisualiseurTerrain {
	public VisualiseurTerrainEnonce(Carte c) {
		super(c, new DetermineurTerrainEnonce());
	}
}