/*
 * 180713 - Classe d'erreur pour la saisie des informations de l'employé.
 */
package mesExceptions;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class ErrorEmploye  extends Exception{
    public ErrorEmploye(String message){
        System.err.println(message);
    }
}
