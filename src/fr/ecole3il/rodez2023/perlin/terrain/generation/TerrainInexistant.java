package fr.ecole3il.rodez2023.perlin.terrain.generation;
import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;

public class TerrainInexistant extends Throwable {

    private String message;

    public TerrainInexistant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

