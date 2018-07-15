/*
 * 180713 - Classe d'erreur pour la saisie des informations du type d'employe
 */
package mesExceptions;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class ErrorEmployePermanent  extends Exception{
    public ErrorEmployePermanent(String message){
        System.err.println(message);
    }
}
