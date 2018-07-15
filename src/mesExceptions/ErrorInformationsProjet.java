/*
 * 180713 - Classe d'erreur pour la saisie des informations du projet.
 */
package mesExceptions;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class ErrorInformationsProjet  extends Exception{
    public ErrorInformationsProjet(String message){
        System.err.println(message);
    }
}
