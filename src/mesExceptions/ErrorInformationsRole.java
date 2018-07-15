/*
 * 180713 - Classe d'erreur pour la saisie du rôle
 */
package mesExceptions;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class ErrorInformationsRole  extends Exception{
    public ErrorInformationsRole(String message){
        System.err.println(message);
    }
}
