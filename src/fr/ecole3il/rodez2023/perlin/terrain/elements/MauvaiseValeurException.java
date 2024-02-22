package fr.ecole3il.rodez2023.perlin.terrain.elements;

public class MauvaiseValeurException extends IllegalArgumentException {

    /**
     * @param message le message d'erreur
     */
    public MauvaiseValeurException(String message) {
        super(message);
    }

}