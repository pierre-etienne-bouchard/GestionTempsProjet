/*
 * 180713 - Classe d'erreur pour la saisie des informations du client
 */
package mesExceptions;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class ErrorClient  extends Exception{
    public ErrorClient(String message){
        System.err.println(message);
    }
}
